package ozr_xml_converter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OzrXmlConverterManagement implements FileManager{
	static String FILE_PATH;
	static String TARGET_LANGUAGE;
	public static void mainMenu() {
		// TODO Auto-generated method stub
		char c ; 
		Scanner scanner = new Scanner(System.in);
		do {
		System.out.flush();
		System.out.println("OZR-XML Converter(for Translate)");
		System.out.println("Choose Menu");
		System.out.println("================================");
		System.out.println("current path \t    : [" + FILE_PATH + "]\ntarget language seq : " + TARGET_LANGUAGE );
		System.out.println("0. Set File Path");
		System.out.println("1. OZR -> XML Convert");		
		System.out.println("2. XML -> OZR Convert");
		System.out.println("3. Exit Converter");
		System.out.println("================================");
		System.out.println("");
			c  = scanner.next().charAt(0);
			switch (c) {
			case '0':
				System.out.print("Set File Path : ");
				FILE_PATH = readString(1);
				System.out.print("Set Target Language : ");
				TARGET_LANGUAGE = readString(2);
				break;
			case '1':
				System.out.println("OZR -> XML Convert");
				checkSetting();
				try {
					FileManager.OzrXmlConvert(FILE_PATH);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case '2':
				System.out.println("XML -> OZR Convert");
				checkSetting();
				try {
					FileManager.XmlOzrConvert(FILE_PATH, TARGET_LANGUAGE);
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
	private static String readString(int flag) {
		// TODO Auto-generated method stub
		//flag = 1 - file path check, 2 just read
		String tempString = "";
		Scanner scanner = new Scanner(System.in);
		do {
			if(!(new File(tempString)).exists() && !tempString.equals("")){
				System.out.println("please enter right path");
			}
			tempString = scanner.nextLine();
		} while (!(new File(tempString)).exists() && flag == 1);
		return tempString;
	}
	static void checkSetting() {
		if(FILE_PATH == null || FILE_PATH == "") {
			System.out.println("please setting File Path first.");
			FILE_PATH = readString(1);
		}
		if(TARGET_LANGUAGE == null || TARGET_LANGUAGE == "") {
			System.out.println("please setting Target Language first.");
			TARGET_LANGUAGE = readString(2);
		}
	}
}
