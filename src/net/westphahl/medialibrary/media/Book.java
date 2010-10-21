package net.westphahl.medialibrary.media;

import java.util.Scanner;

import net.westphahl.medialibrary.media.Medium;

public class Book extends Medium {
	
	private int pages;
	
	public Book() {
		super(0);
		System.out.println("Please enter info for book: signature, pages and title");
		this.type = "Book";
		this.signature = readSignature();
		this.pages = readPages();
		this.title = readTitle();
	}
	
	public String toString() {
		return String.format("%s %s", super.toString(), "Pages " + this.pages);
	}
	
	private int readPages() {
		Scanner inputScanner;
		
		System.out.print("Pages: ");
		do {
			inputScanner = new Scanner(System.in);
		} while (!inputScanner.hasNextInt());
		return inputScanner.nextInt();	
	}
}
