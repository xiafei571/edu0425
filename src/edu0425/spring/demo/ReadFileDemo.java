package edu0425.spring.demo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFileDemo {

	private static String email_filepath = "G:\\dev\\eclipse-workspace\\edu0425\\src\\u-email.txt";
	private static String phone_filepath = "G:\\dev\\eclipse-workspace\\edu0425\\src\\u-phone.txt";
	private static String out_filepath = "G:\\dev\\eclipse-workspace\\edu0425\\src\\u-out.txt";

	public static void main(String[] args) {
		try {
//			readFile1(email_filepath);
//			readFile2(phone_filepath);
//			writeFile(out_filepath);
			mergeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mergeFile() throws IOException {
		List<String> f1_id = new ArrayList<String>();
		List<String> f1_name = new ArrayList<String>();
		List<String> f1_email = new ArrayList<String>();
		List<String> f2_id = new ArrayList<String>();
		List<String> f2_name = new ArrayList<String>();
		List<String> f2_phone = new ArrayList<String>();
		// File 1
		FileInputStream fin = new FileInputStream(email_filepath);
		InputStreamReader reader = new InputStreamReader(fin, "UTF-8");
		BufferedReader buffer = new BufferedReader(reader);
		String strTmp = "";
		buffer.readLine();
		while ((strTmp = buffer.readLine()) != null) {
			String[] str = strTmp.split("\\s");
			f1_id.add(str[0]);
			f1_name.add(str[1]);
			f1_email.add(str[2]);
		}
		// File 2
		fin = new FileInputStream(phone_filepath);
		reader = new InputStreamReader(fin, "UTF-8");
		buffer = new BufferedReader(reader);
		strTmp = "";
		buffer.readLine();
		while ((strTmp = buffer.readLine()) != null) {
			String[] str = strTmp.split("\\s");
			f2_id.add(str[0]);
			f2_name.add(str[1]);
			f2_phone.add(str[2]);
		}

		buffer.close();
		reader.close();
		fin.close();
		
		// write file
		File writeName = new File(out_filepath);
		// 创建新文件，有同名的文件的话直接覆盖
		writeName.createNewFile();
		FileWriter writer = new FileWriter(writeName);
		BufferedWriter out = new BufferedWriter(writer);
		
		for (int i = 0; i < f1_id.size(); i++) {
			if (f2_id.contains(f1_id.get(i))) {
				out.write(f1_id.get(i) +"\t"+ f1_name.get(i) +"\t"+ f1_email.get(i) +"\t"+ f2_phone.get(i) + "\r\n");
			} else {
				out.write(f1_id.get(i) +"\t"+ f1_name.get(i) +"\t"+ f1_email.get(i) +"\t"+ "    ----    " + "\r\n");
			}
		}

		for (int j = 0; j < f2_id.size(); j++) {
			if (!f1_id.contains(f2_id.get(j))) {
				out.write(f2_id.get(j) +"\t"+ f2_name.get(j) +"\t"+ "    ----    " +"\t"+ f2_phone.get(j) + "\r\n");
			}
		}
		
		out.flush();// 把缓存区内容压入文件
		out.close();// 关闭文件流
	}

	private static void readFile1(String filepath) throws IOException {
		FileInputStream fin = new FileInputStream(filepath);
		InputStreamReader reader = new InputStreamReader(fin, "UTF-8");
		BufferedReader buffer = new BufferedReader(reader);

		String strTmp = "";
		buffer.readLine();
		while ((strTmp = buffer.readLine()) != null) {
			String[] str = strTmp.split("\\s");
			System.out.println(str[0] + "," + str[1] + "," + str[2]);
		}

		buffer.close();
		reader.close();
		fin.close();
	}

	private static void readFile2(String filepath) throws IOException {
		// 使用NIO的方式读文件
		Path path = Paths.get(filepath);
		List<String> lines = Files.readAllLines(path);
		for (String line : lines) {
			System.out.println(line);
		}
	}

	private static void writeFile(String filepath) throws IOException {
		File writeName = new File(filepath);
		// 创建新文件，有同名的文件的话直接覆盖
		writeName.createNewFile();

		FileWriter writer = new FileWriter(writeName);
		BufferedWriter out = new BufferedWriter(writer);
		out.write("Hello world \r\n");// \r\n为回车换行
		out.write("会当凌绝顶，一览众山小。 \r\n");
		out.flush();// 把缓存区内容压入文件
		out.close();// 关闭文件流
	}
}
