package ozr_xml_converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public interface FileManager {

	static void OzrXmlConvert(String source) throws IOException {
		// TODO Auto-generated method stub
		File dir = new File(source);
		File[] fileList = dir.listFiles();
//					if(!(new File(dir.toString()+"\\ozr_to_xml")).exists()) {
//						(new File(dir.toString()+"\\ozr_to_xml")).mkdirs();
//					}
		for (int i = 0; i < fileList.length; i++) {
			File file = fileList[i];
			if (file.isFile()) {
				if( file.getName().substring(file.getName().lastIndexOf(".")+1,file.getName().length()).equals("ozr")) {
					//String fileContents = getFileContents(file);
					makeFileOutput(file,getFileContents(file),1, "");
				}
			}
		}
	}
	static void XmlOzrConvert(String source, String languageSeq) throws IOException {
		// TODO Auto-generated method stub
		File dir = new File(source+"\\xml");
		if(!dir.isDirectory()) {
			System.out.println("there is no xml folder.");
			return;	
		}			
		File[] fileList = dir.listFiles();
//					if(!(new File(dir.toString()+"\\ozr_to_xml")).exists()) {
//						(new File(dir.toString()+"\\ozr_to_xml")).mkdirs();
//					}
		for (int i = 0; i < fileList.length; i++) {
			File file = fileList[i];
			if (file.isFile()) {
				if( file.getName().substring(file.getName().lastIndexOf(".")+1,file.getName().length()).equals("xml")) {
					//String fileContents = getFileContents(file);
					makeFileOutput(file,getFileContents(file),2, languageSeq);
				}
			}
		}
	}

	static void makeFileOutput(File file, String fileContents, int flag, String languageSeq) throws IOException {
		// TODO Auto-generated method stub
		String target;
		File folder;
		if (flag==1) {
			folder = new File(file.getParentFile()+"\\xml");
			System.out.println("test" + folder.exists());
			if(!folder.exists()){
				System.out.println("Xml folder created.");
				folder.mkdir();
			}
			target = folder.getPath()+"\\"+file.getName().replace(".ozr", ".xml");
		}else{
			folder = new File(file.getParentFile().toString().replaceAll("xml", "language"+languageSeq));
			if(!folder.exists()){
				System.out.println("language"+languageSeq +"folder created.");
				folder.mkdir();
			}
			target = folder.getPath()+"\\"+file.getName().replace(".xml", "_L"+ languageSeq + ".ozr");
		}
		System.out.println(target);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target),"UTF8"));
        out.write(fileContents.toString()); out.newLine();
        out.close();
	}

	static String getFileContents(File file) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
        String sb = new String();
        String line = br.readLine();
        boolean flag = true;
        while (line != null) {
        	if(flag) {
        		flag = false;
        		sb = sb + "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";		
        	}else {
        		sb = sb + line;
        	}
            sb += "\n";
            line = br.readLine();
        }
        br.close();
		return sb;
	}

}
