import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ex1 {

	public static void main(String[] args) {
		llegirFitxer();
	}

	static void llegirFitxer() {
		try {
			Files.lines(Path.of("examConfig.conf")).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
