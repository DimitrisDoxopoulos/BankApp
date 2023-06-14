package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.IsNotValidException;
import gr.aueb.cf.exceptions.NegativeAmountException;

public class OverdraftAccount extends Account {

    public OverdraftAccount() {};

    public OverdraftAccount(User holder, String iban, double balance) {
        super(holder, iban, balance);
    }

    @Override
    public void withdraw(double amount, String ssn)
            throws IsNotValidException, NegativeAmountException {
        try {
            if (amount < 0) throw new NegativeAmountException(amount);
            if (!isSsnValid(ssn)) throw new IsNotValidException(ssn);

            setBalance(getBalance() - amount);
        } catch (IsNotValidException | NegativeAmountException e) {
            System.err.println("Error: Withdrawal");
            throw e;
        }
    }
}
