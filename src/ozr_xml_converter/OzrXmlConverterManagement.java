package ozr_xml_converter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OzrXmlConverterManagement implements FileManager{
	private static String FILE_PATH;
	public static void mainMenu() {
		// TODO Auto-generated method stub
		char c ; 
		Scanner scanner = new Scanner(System.in);
		do {
		System.out.flush();
		System.out.println("OZR-XML Converter(for Translate)");
		System.out.println("Choose Menu");
		System.out.println("================================");
		System.out.println("0. Set File Path (current path : " + FILE_PATH + ")");
		System.out.println("1. OZR -> XML Convert");		
		System.out.println("2. XML -> OZR Convert");
		System.out.println("3. Exit Converter");
		System.out.println("================================");
		System.out.println("");
			c  = scanner.next().charAt(0);
			switch (c) {
			case '0':
				System.out.println("Set File Path");
				FILE_PATH = setFilePath();
				break;
			case '1':
				System.out.println("OZR -> XML Convert");
				checkFilePath();
				try {
					FileManager.OzrXmlConvert(FILE_PATH);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case '2':
				System.out.println("XML -> OZR Convert");
				checkFilePath();
				try {
					FileManager.XmlOzrConvert(FILE_PATH);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case '3':
				System.out.println("Exit");
				break;
			default:
				System.out.println("You type wrong menu. please enter right menu. ");
				break;
			}
		} while (c != '3');
	}
	private static String setFilePath() {
		// TODO Auto-generated method stub
		
		String tempPath;
		Scanner scanner = new Scanner(System.in);
		do {
		System.out.println("please enter right path");
		tempPath = scanner.nextLine();
		} while (!(new File(tempPath)).exists());
		return tempPath;
	}
	static void checkFilePath() {
		if(FILE_PATH == null || FILE_PATH == "") {
			System.out.println("please setting File Path first.");
			FILE_PATH = setFilePath();
		}			
	}
}
