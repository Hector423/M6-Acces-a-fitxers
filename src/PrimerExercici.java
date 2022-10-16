import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PrimerExercici {

	public static void main(String[] args) throws IOException {
		/**
		 * Primera part exercici
		 */
		Scanner entradaFitxerVisualitzar = new Scanner(System.in);
		
		System.out.println("Escriu el nom del fitxer:");
		
		File fitxerVisualitzar = new File(entradaFitxerVisualitzar.nextLine());
		
		if(!fitxerVisualitzar.exists()) {
			throw new IOException("Error. No existeix ");
		}
		
		FileReader leerFichero = new FileReader(fitxerVisualitzar);
		
		try {
			BufferedReader fitxer = new BufferedReader( new FileReader(fitxerVisualitzar));
			String linia;
			while ((linia = fitxer.readLine())!=null) {
				System.out.println(linia);
				}
			} finally {
			
			leerFichero.close();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}


