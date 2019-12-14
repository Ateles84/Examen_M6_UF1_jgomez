import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nomF,cont;
		
		System.out.println("Introduce el nombre del fichero: ");
		nomF = sc.nextLine();
		
		System.out.println("Introduce el contenido del fichero!");
		cont = sc.nextLine();
		
		crearFichero(nomF, cont);
		
		sc.close();
	}

	static void crearFichero(String nombreFich, String textoContenido) {
		File f = new File(nombreFich);
		
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("No se ha podido crear el archivo :( "+ e.getMessage());
			}
		
		PrintStream ps;
		
		try {
			ps = new PrintStream(f);
			ps.println(textoContenido);
			ps.close();
			System.out.println("Archivo creado y escrito satisfactoriamente");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
