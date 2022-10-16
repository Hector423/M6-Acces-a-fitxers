import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SegonExercici {
	public static void main(String[] args) throws IOException {
	/**
	 * Segona part exercici
	 */	
	File arxiu = new File("Departaments.dat");
	FileOutputStream fileout = new FileOutputStream(arxiu);
	FileInputStream filein = new FileInputStream(arxiu);
	DataOutputStream dataOut = new DataOutputStream(fileout);
	DataInputStream dataInput = new DataInputStream(filein); 
	
	int id[] = {1,2,3};
	String noms[] = {"Departament de RRHH", "Departament de marqueting", "Departament de logistica"};
	String localitzacio[] = {"Oficina 1", "Oficina 2", "Oficina 3"};
	
	for(int i = 0; i<localitzacio.length; i++) {
		dataOut.writeInt(id[i]);
		dataOut.writeUTF(noms[i]);
		dataOut.writeUTF(localitzacio[i]);
	}
	dataOut.close();
	
	String nom;
	String ubicacio;
	int numero;
	
	try {
		for(int i = 0; i<localitzacio.length; i++) {
			
			numero = dataInput.readInt();
			nom = dataInput.readUTF();
			ubicacio = dataInput.readUTF();
			
			System.out.println("Numero departament: " + numero + "\n Nom departament: " + nom + "\n Localitat: " + ubicacio);
	}
	}catch (EOFException eo) {}
	
	dataInput.close();
	}
}
