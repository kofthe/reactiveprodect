package banktransactionexample;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BankTransactionExample {

    public static void main(String[] args) {

        long totalTransactions = getTotalTransactions();
        System.out.println("Total Transactions :" + totalTransactions );

        Optional<BankTransaction> getBiggest = getBiggestTransaction(LocalDate.now());
        

    }

    private static final List<BankTransaction> transactions = getTransactions();

    private static List<BankTransaction> getTransactions() {
        return Arrays.asList(
                new BankTransaction("125", BigDecimal.valueOf(205.00), LocalDate.now()),
                new BankTransaction("456", BigDecimal.valueOf(100.00), LocalDate.now()),
                new BankTransaction("342", BigDecimal.valueOf(3360.00), LocalDate.now()),
                new BankTransaction("234", BigDecimal.valueOf(05.00), LocalDate.now()),
                new BankTransaction("645", BigDecimal.valueOf(22305.00), LocalDate.now()),
                new BankTransaction("345", BigDecimal.valueOf(250000.00), LocalDate.now())
        );
    }


    private static Optional<BankTransaction> getBiggestTransaction(LocalDate when) {
        Comparator<BankTransaction> byAmount = Comparator.comparing(BankTransaction::getAmount);
        return transactions.stream()
                .filter(transaction -> transaction.getDate().equals(when))
                .max(byAmount);
    }

    private static Optional<BankTransaction> getSmallestTransaction(LocalDate when) {
        Comparator<BankTransaction> byAmount = Comparator.comparing(BankTransaction::getAmount);
        return transactions.stream()
                .filter(transaction ->transaction.getDate().equals(when))
                .min(byAmount);
    }

    private static long getTotalTransactions() {
        return transactions.stream()
                .filter(transaction -> transaction.getDate().equals(LocalDate.now()))
                .count();
    }


}
