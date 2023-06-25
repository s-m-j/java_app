import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.*;

public class calc_app {
	private static final String RESOURCES = "src/main/resources/";
	public static void main(final String... args) throws IOException {
		final Path path = Paths.get(RESOURCES + args[0]);
		final List<String> lines = Files.readAllLines(path);
	}

}
