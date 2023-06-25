import java.io.IOException;
import java.nio.file.Files;
import java.time.Month;
import java.util.List;
import java.nio.file.*;

public class calc_app {
	private static final String RESOURCES = "src/main/resources/";
	public static void main(final String... args) throws IOException {
		final Path path = Paths.get(RESOURCES + args[0]);
		final List<String> lines = Files.readAllLines(path);
		
		final List<BankTransaction> bankTransactions = BankStatementCSVParser.parseLinesFromCSV(lines);
		
		/*
		System.out.println("The path is " + path.toString());
		System.out.println(bankTransactions.getClass());
		*/
		//System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
		System.out.println("Transactions in January " + calculateTotalInMonth(bankTransactions,	Month.FEBRUARY));

	}
	
	public static double calculateTotalInMonth(final List<BankTransaction> bankTransactions, final Month month) {
		double total = 0;
		for(final BankTransaction bankTransaction: bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month){
				total += bankTransaction.getAmount();
			}
		}
		return total;
	}
	
	public static double calculateTotalForCategory(final List<BankTransaction> bankTransactions, final String category) {
		double total = 0;
		
		for(final BankTransaction bankTransaction: bankTransactions) {
			if(bankTransaction.getDescription().equals(category)) {
				total += bankTransaction.getAmount();
			}
		}
		
		return total;
	}
}
