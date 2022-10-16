import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class TercerExercici {

	public static void main(String[] args) throws IOException {

		File arxiu = new File("AleatoriTreballador.dat");
		
		RandomAccessFile accesArxiu = new RandomAccessFile(arxiu, "rw");
		
		String cognoms[] = {"Vallvé", "Ribellas", "Altozano", "Martinez"};
		
		Double salari[] = {2000.0, 1500.0, 1200.0, 1900.0};
		
		String llegirCognoms;
		Double llegirSalari;
		int llegirIdentificador, posicio = 0;
		char cognomsChar[] = new char[10], aux;
		
		Scanner sc = new Scanner(System.in);
		int sortir = 0;
		int opcio;
		
		StringBuffer buffer = null;
		int n = cognoms.length;
		
		for(int i=0; i<n; i++) {
			accesArxiu.writeInt(i+1);
			buffer = new StringBuffer(cognoms[i]);
			buffer.setLength(10);
			accesArxiu.writeChars(buffer.toString());
			accesArxiu.writeDouble(salari[i]);
		}
		while (sortir != 3) {
				System.out.println("1. Veure treballadors");
				System.out.println("2. Canviar salari treballador");
				System.out.println("3. Sortir");
	            
				System.out.println("Escriu una opcio");
				opcio = sc.nextInt();
				
				switch (opcio) {
				case 1:
					RandomAccessFile accesArxiuLectura = new RandomAccessFile(arxiu, "r");
					for(;;) {
						accesArxiuLectura.seek(posicio);
						llegirIdentificador = accesArxiuLectura.readInt(); 
						for (int i=0; i<cognomsChar.length; i++) {
							aux = accesArxiuLectura.readChar();
							cognomsChar[i] = aux;
						}
						String cognoms2 = new String(cognomsChar);
						llegirSalari = accesArxiuLectura.readDouble();
						System.out.println("ID: " + llegirIdentificador + "Cognom: " + cognoms2 + "Salari: " + llegirSalari);
						posicio = posicio+32;
						if (accesArxiuLectura.getFilePointer()==accesArxiuLectura.length()) {
							break;
						}
					}
					accesArxiuLectura.close();
					break;
				case 2:
					int buscarIdentificador, obtenirSalari;
					System.out.println("Escriu l'identificador: ");
					buscarIdentificador = sc.nextInt();
					posicio = (buscarIdentificador - 1)* 32;
					if(posicio >= accesArxiu.length()) {
						System.out.println("Aquest id no existeix");
					}else {
						System.out.println("Escriu el nou salari: ");
						
						int canviarSalari = sc.nextInt();
						
						accesArxiu.seek(posicio+4+20);
						obtenirSalari = accesArxiu.readInt();
						obtenirSalari = obtenirSalari + canviarSalari;
						accesArxiu.writeDouble(canviarSalari);
						System.out.println("S'ha canviat el salari del treballador");
					}
					
					
					break;
				}
		}
		accesArxiu.close();
		
	}

}
