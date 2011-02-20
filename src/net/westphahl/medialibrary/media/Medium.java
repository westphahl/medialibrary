package net.westphahl.medialibrary.media;

import java.util.Scanner;

import net.westphahl.medialibrary.media.StatusError;

public class Medium {
	
	protected int signature;
	protected boolean status = true;
	protected String type = "Medium";
	protected String title;
	
	public Medium() {
		  System.out.println("Please enter info for medium: signature and title");
		  this.signature = readSignature();
		  this.title = readTitle();
	}
	
	public Medium(int i) {}
	
	public String getType() {
		return this.type;
	}
  
	public String getTitle() {
		return this.title;
	}
  
	public boolean isAvailable() {
		return this.status;
	}
  
	public String toString() {
		String humanStatus = "unavail.";
		if (this.status) {
			humanStatus = "avail.";
		}
		return String.format("%10d %-10s %-25s %-10s",
				this.signature, this.type, this.title, humanStatus);
	}

	public static void printTitles() {
		System.out.println(String.format("%10s %-10s %-25s %-10s %s",
				"Signature", "Type", "Title", "Status", "Further Information"));
	}
  
	public void borrow() throws StatusError{
		if (this.status == true) {
			this.status = false;
		} else {
			throw new StatusError(this.title);
		}
	}
  
	public void handBack() throws StatusError {
		if (this.status == false) {
			this.status = true;
			System.out.println("Thank your for returning this media!");
		} else {
			throw new StatusError(this.title);
		}
	}
  
	public int getSignature() {
		return this.signature;
	}
  
	protected int readSignature() {
		Scanner inputScanner;
		
		System.out.print("Signature: ");
		do {
			inputScanner = new Scanner(System.in);
		} while (!inputScanner.hasNextInt());
		return inputScanner.nextInt();	
	}
	
	protected String readTitle() {
		Scanner inputScanner;
		System.out.print("Title: ");
		inputScanner = new Scanner(System.in);
		return inputScanner.nextLine();
	}
};
