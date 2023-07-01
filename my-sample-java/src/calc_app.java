import java.io.IOException;
import java.nio.file.Files;
import java.time.Month;
import java.util.List;
import java.nio.file.*;

public class calc_app {
	
	public static void main(final String... args) throws IOException {
		
		final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
		
		final BankStatementParser bankStatementParser = new BankStatementCSVParser();
		
		bankStatementAnalyzer.analyze(args[0], bankStatementParser);		
	}
	
	
}
