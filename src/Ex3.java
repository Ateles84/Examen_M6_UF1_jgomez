import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String nomF;
		char ripChar;

		System.out.println("Introduce el nombre del fichero: ");
		nomF = sc.nextLine();

		System.out.println("Introduce el caracter que quieres eliminar");
		ripChar = validarChar();

		eliminarCharDeFichero(nomF, ripChar);

		sc.close();
	}

	static void eliminarCharDeFichero(String ruta, char ripChar) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(ruta));
		
		File aux = new File("ruta2");
		
		PrintStream ps = new PrintStream(aux);
		
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			String novaLinea = "";
			
			for (int i = 0; i < linea.length(); i++) {
				if (linea.charAt(i) != ripChar) {
					novaLinea += linea.charAt(i);
				}
			}
			
			ps.println(novaLinea);
		}
		
		new File(ruta).delete();
		
		aux.renameTo(new File(ruta));
		
		ps.close();
		
		sc.close();

	}

	static char validarChar() {
		Scanner sc = new Scanner(System.in);
		String aux;

		while (true) {
			aux = sc.next();

			if (aux.length() > 1) {
				System.out.println("Escribe solo un caracter");
			} else {
				sc.close();
				return aux.charAt(0);
			}
		}
	}
}
