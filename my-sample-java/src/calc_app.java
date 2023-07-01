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
		
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
		
		collectSummary(bankStatementProcessor);
	}
	
	private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
		
		System.out.println("The total for all transactions is "	+ bankStatementProcessor.calculateTotalAmount());
		
		System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotallnMonth(Month.JANUARY));
			
		System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotallnMonth(Month.FEBRUARY));
			
		System.out.println("The total salary received is " 	+ bankStatementProcessor.calculateTotalForCategory("Salary"));
	}
}
