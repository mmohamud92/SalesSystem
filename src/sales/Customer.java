package sales;

import java.util.ArrayList;
import java.util.List;

/**
 * The Customer class holds all transactions (purchases/refunds)
 * and provides methods to add, remove, and total them.
 */
public class Customer {
    private List<Transaction> transactions;

    public Customer() {
        this.transactions = new ArrayList<>();
    }

    /**
     * Records a new transaction.
     */
    public void transact(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * Clears all recorded transactions.
     */
    public void clearTransactions() {
        transactions.clear();
    }

    /**
     * Removes the transaction at the given index.
     */
    public void removeTransaction(int index) {
        transactions.remove(index);
    }

    /**
     * Returns the live list of transactions.
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Sums all transaction values (purchases positive, refunds negative).
     */
    public int getTotal() {
        int total = 0;
        for (Transaction t : transactions) {
            total += t.getValue();
        }
        return total;
    }
}