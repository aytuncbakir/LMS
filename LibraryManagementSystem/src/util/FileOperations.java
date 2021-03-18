package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import model.Book;
import model.Member;
import model.Novel;
import model.User;

public class FileOperations {

	public List<User> loadUsers() {
		try {

			String dosyayolu = "C:\\Users\\sivam\\git\\LMS\\LibraryManagementSystem\\resources\\users.txt";

			FileReader okuyucu = new FileReader(dosyayolu); 
			BufferedReader okumaTamponu = new BufferedReader(okuyucu);
			List<User> users = new ArrayList<User>();
			String satir = okumaTamponu.readLine();
			int i;
			String[] str = null;
			while (satir != null) {

				i = 0;
				str = satir.split(",");

				while (i < str.length) {
					User user = new Member();

					user.setName(str[i++]);
					user.setUserName(str[i++]);
					user.setPassword(str[i++]);

					//System.out.println(user);
					users.add(user);
				}
				str = null;
				satir = okumaTamponu.readLine();
			}
			okumaTamponu.close();

			return users;

		} catch (FileNotFoundException ex) {
			System.out.println("Hata olustu...!");
		} catch (IOException ex1) {
			System.out.println("Hata olustu...!");
		}
		return null;

	}

	public List<Book> loadBooks(){
		try {

			String dosyayolu = "C:\\Users\\sivam\\git\\LMS\\LibraryManagementSystem\\resources\\books.txt";

			FileReader okuyucu = new FileReader(dosyayolu); // biz yeri s�yledik
			BufferedReader okumaTamponu = new BufferedReader(okuyucu);
			List<Book> books = new ArrayList<Book>();
			String satir = okumaTamponu.readLine();
			int i;
			String[] str = null;
			while (satir != null) {

				i = 0;
				str = satir.split(",");
				while (i < str.length) {
					
					
					Book book=  new Novel();

					book.setName(str[i++]);
					book.setAuthorName(str[i++]);
					book.setIsbn(str[i++]);
					book.setType(str[i++]);
					book.setTotal(Integer.parseInt(str[i++]));
					
					books.add(book);
				}
				str = null;
				satir = okumaTamponu.readLine();
			}
			okumaTamponu.close();

			return books;

		} catch (FileNotFoundException ex) {
			System.out.println("Hata olustu...!");
		} catch (IOException ex1) {
			System.out.println("Hata olustu...!");
		}
		return null;

	}
	
	public  void writeBooksToFile(List<Book> books, String filename) {
		String dosyayolu = "C:\\Users\\sivam\\git\\LMS\\LibraryManagementSystem\\resources\\"+ filename;
				
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(dosyayolu);

			int lines = 0;
			while(lines < books.size()) {
				
				fileWriter.append(books.get(lines).toString());
				fileWriter.append("\n");
				lines++;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (fileWriter != null) {
					fileWriter.flush();
					fileWriter.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public  void writeBarrowedBooksToFile(List<Book> books, String str) {
		String dosyayolu = "C:\\Users\\sivam\\git\\LMS\\LibraryManagementSystem\\resources\\barrowed_books.txt";
				
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(dosyayolu);

				fileWriter.append(str);
				fileWriter.append("\n");
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (fileWriter != null) {
					fileWriter.flush();
					fileWriter.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
