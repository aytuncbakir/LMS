package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Article;
import model.Book;
import model.Member;
import model.Novel;
import model.Poet;
import model.Staff;
import model.User;
import util.FileOperations;




public class LibraryManagement {
	
	public  List<User> users = null;
	public  List<Book> books = null;
	public  List<Book> barrowBooks = null;
	public  FileOperations fileOperations;
	public  int currentUser =-1;
	
	public  void run() {
		initializeLists();
		
		fileOperations = new FileOperations();
		users = fileOperations.loadUsers();
		books = fileOperations.loadBooks();
		menuLogin();		
	}
	
	private void initializeLists() {
		users = new ArrayList<User>();
		books = new ArrayList<Book>();
		barrowBooks = new ArrayList<Book>();
		
	}

	private void signup() {
		
		System.out.println("Enter Name:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		System.out.println("Enter Username:");
		Scanner sc1 = new Scanner(System.in);
		String username = sc1.nextLine();
		
		
		System.out.println("Enter Password:");
		Scanner sc2 = new Scanner(System.in);
		String password = sc2.nextLine();
		
		
		User user = new Member(name, username,password);
		
		users.add(user);
		login();
		
	}
	
	private boolean loginKontrol(String username, String password) {
		
		boolean isMemberOrStaff = false;	
		for(int i = 0; i<users.size(); i++) {	
			if(users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password) ) {
				isMemberOrStaff = true;
				currentUser = i;
				return  isMemberOrStaff;
			}	
		}
		return  isMemberOrStaff;
	}	
		
	private void login() {
		
		System.out.print("USERNAME: ");
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
		
		System.out.print("PASSWORD: ");
		Scanner sc1 = new Scanner(System.in);
		String password = sc1.nextLine();
		System.out.println(password);
		
		boolean isMemberOrStaff  = loginKontrol(username, password);
		if(isMemberOrStaff)
			mainMenu();
		else
			login();  // kontrol olabilir ona göre signup yadalogine yönlendir
	
		
		
	}
	
	private void menuLogin() {
		
		System.out.println(" ----------------------------------------");
		System.out.println();
		System.out.println(" 	WELCOME TO HOUSTON LIBRARY ");
		System.out.println();
		System.out.println("Press 1 for Sing up");
		System.out.println("Press 2 for Log in");
		System.out.println("Press 3 for exit");
		
		System.out.println();
		System.out.println(" ----------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		do {
			
			switch(choice) {
			
			case 1: 
				signup();
				break;
				
			case 2: 
				login();
				break;
				
			case 3: 
				System.exit(0);
				break;

			}
			System.out.println(" ----------------------------------------");
			System.out.println();
			System.out.println(" 	WELCOME TO HOUSTON LIBRARY ");
			System.out.println();
			System.out.println("Press 1 for Sing up");
			System.out.println("Press 2 for Log in");
			System.out.println("Press 3 for exit");
			
			System.out.println();
			System.out.println(" ----------------------------------------");
		 sc = new Scanner(System.in);
		 choice = sc.nextInt();
		}while(choice != 3);
		
		
		
	}
	
	
	// ceza hesapla
	// sendWarning uyari gonder

	
	private void createUsers() {
		
		User user1 = new Member("Ali Han", "ahan", "ahan01");
		User user2 = new Member("Veli Sel", "vsel", "vsel02");
		User user3 = new Staff("Selim Pak", "spak", "spak03");
		
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}
	
	private void createBooks() {
		
		Book book = new Novel("Novel1", "Author1", "isbn1", "novel",2);
		Book book1 = new Novel("Novel2", "Author2", "isbn2", "novel",3);
		Book book2 = new Novel("Novel3", "Author3", "isbn3", "novel",2);
		Book book3= new Novel("Novel4", "Author4", "isbn4", "novel",1);
		Book book4 = new Novel("Novel5", "Author5", "isbn5", "novel",4);
		
		Book book5= new Poet("Poet6", "Author6", "isbn6","poet",3);	
		Book book6 = new Poet("Poet7", "Author7", "isbn7", "poet",2);
		
		Book book7 = new Article("Article8", "Author8", "isbn8", "article",2);
		
		
		books.add(book);
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		books.add(book6);
		books.add(book7);
		
		
	}
	
	private void showBooks() {
		
		System.out.println("----------------------------------------------------------");
		System.out.println(" 	WELCOME TO HOUSTON LIBRARY ");
		System.out.println();
		for(int i = 0; i< books.size(); i++) {
			
			if(books.get(i).getTotal() == 0)
				System.err.println("\t"+books.get(i));
			else
				System.out.println("\t"+books.get(i));
		}
		System.out.println("----------------------------------------------------------");
	}
	
	
	

	private void mainMenu() {
		
		System.out.println(" 	WELCOME TO HOUSTON LIBRARY ");
		System.out.println("Show books Press 1");
		System.out.println("Barrow books Press 2");
		System.out.println("Give books back Press 3");
		System.out.println("For exit Press 4 ");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		do {
			
			switch(choice) {
				
				case 1: 
					showBooks();
					break;
				case 2: 
					barrowBooks();
					break;
					
				case 3: 
					giveBackBooks();
					break;
				
				case 4: 
					System.exit(0);
					break;
				}

			System.out.println(" 	WELCOME TO HOUSTON LIBRARY ");
			System.out.println("Show books Press 1");
			System.out.println("Barrow books Press 2");
			System.out.println("Give books back Press 3");
			System.out.println("For exit Press 4 ");
			 sc = new Scanner(System.in);
			 choice = sc.nextInt();
		}while(choice != 4);
		
	}	
		
	private void giveBackBooks() {
		
		showBooks();
		
		System.out.println("Give Book");
		System.out.print("Write books' ISBN: ");
		Scanner sc = new Scanner(System.in);
		String isbn = sc.nextLine();
		
		for(int i = 0; i< books.size(); i++) {
			
			if(isbn.equals(books.get(i).getIsbn())) {

				int total = books.get(i).getTotal();
				books.get(i).setTotal(total+1);	
			}
			
			System.err.println("Hatali isbn ...!!!");
			
		}
			
		showBooks();
		
	}

	private void barrowBooks() {
		
		showBooks();
		
		System.out.println("Select Book");
		System.out.print("Write books' ISBN: ");
		Scanner sc = new Scanner(System.in);
		String isbn = sc.nextLine();
		String record = "";
		for(int i = 0; i< books.size(); i++) {
			
			if(isbn.equals(books.get(i).getIsbn())) {
				
				
				int total = books.get(i).getTotal();
				if(total > 0) {
					books.get(i).setTotal(total-1);
					barrowBooks.add(books.get(i));
					Book book = books.get(i);
					record = barrowedBookRecord(book);
				}else
					System.err.println("Book is not avalible");
			}
			
		}
		fileOperations.writeBooksToFile(books,"books.txt");
		fileOperations.writeBarrowedBooksToFile(barrowBooks, record);
		showBooks();
	
	}
	
	public String barrowedBookRecord(Book book) {
		
		String str = "";
		str = 	book.getName()+","+
		book.getAuthorName()+","+
				book.getIsbn()+","+book.getType()+","+book.getTotal()+","+
				users.get(currentUser).name;
		
		return str;
		
	}
	

}
