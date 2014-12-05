package dai_dojo0_streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	public static void copyFileReader(File from,
			File to) {
		
		try (FileReader reader = new FileReader(from);
				FileWriter writer = new FileWriter(to)) {
			int c;
			while ((c = reader.read()) != -1) {
				writer.write(c);
			}
			
		} catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public static void copyBufferedInputStream(File from, File to) {
		try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(from));
			 BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(to))
		){
			int c;
			while((c = reader.read()) != -1){
				writer.write(c);
			}
		
		} catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		}	
	}
	
	public static void copyFileInputStream(File from, File to) {
		try (FileInputStream reader = new FileInputStream(from);
			 FileOutputStream writer = new FileOutputStream(to)
		){
			int c;
			while((c = reader.read()) != -1){
				writer.write(c);
			}
		
		} catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public static void copyBufferedReader(File from,
			File to) {
		
		try (BufferedReader reader = new BufferedReader(new FileReader(from));
				BufferedWriter writer = new BufferedWriter(new FileWriter(to))) {
			int c;
			while ((c = reader.read()) != -1) {
				writer.write(c);
			}
			
		} catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		}	
	}
	
	
	public static long testFileReader(File in, File out)
	{
		long timeStart, timeEnd;
		timeStart = System.currentTimeMillis();
		copyFileReader(in,out);
		timeEnd = System.currentTimeMillis();
		return timeEnd-timeStart;
	}
	
	public static long testBufferedInputStream(File in, File out)
	{
		long timeStart, timeEnd;
		timeStart = System.currentTimeMillis();
		copyBufferedInputStream(in,out);
		timeEnd = System.currentTimeMillis();
		return timeEnd-timeStart;
	}
	
	public static long testFileInputStream(File in, File out)
	{
		long timeStart, timeEnd;
		timeStart = System.currentTimeMillis();
		copyFileInputStream(in,out);
		timeEnd = System.currentTimeMillis();
		return timeEnd-timeStart;
	}
	
	public static long testBufferedReader(File in, File out)
	{
		long timeStart, timeEnd;
		timeStart = System.currentTimeMillis();
		copyBufferedReader(in,out);
		timeEnd = System.currentTimeMillis();
		return timeEnd-timeStart;
	}
	
	public static void main(String[] args) {
		
		File in = new File("Dojo0_pg2000.txt");
		File out = new File("salida.txt");
		
		System.out.println("Realizaranse tres iteracións de cada método de copia");
		System.out.println("Tempos de execucion usando fileReader: "+testFileReader(in,out)+", "+testFileReader(in,out)+" e "+testFileReader(in,out)+" milisegundos.");
		System.out.println("Tempos de execucion usando bufferedInputStream: "+testBufferedInputStream(in,out)+", "+testBufferedInputStream(in,out)+" e "+testBufferedInputStream(in,out)+" milisegundos.");
		System.out.println("Tempos de execucion usando fileInputStream: "+testFileInputStream(in,out)+", "+testFileInputStream(in,out)+" e "+testFileInputStream(in,out)+" milisegundos.");
		System.out.println("Tempos de execucion usando bufferedReader: "+testBufferedReader(in,out)+", "+testBufferedReader(in,out)+" e "+testBufferedReader(in,out)+" milisegundos.");

	}

}