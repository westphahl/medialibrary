package net.westphahl.medialibrary;

import java.util.Scanner;

import net.westphahl.medialibrary.media.Medium;
import net.westphahl.medialibrary.media.Book;
import net.westphahl.medialibrary.media.Video;
import net.westphahl.medialibrary.media.StatusError;
import net.westphahl.medialibrary.utils.Container;

class MediaLibrary {
	private static Container mediaContainer = new Container();
	private static Medium media;
	private static String command = "q";	
  
	public static void main(String[] args) {
		while (true) {
			printCommands();
			Scanner inputScanner;
			System.out.print("Command: ");
			inputScanner = new Scanner(System.in);
			command = inputScanner.next();
			
			switch (command.charAt(0)) {
			case 'm':
				if (!mediaContainer.add(new Medium())) System.exit(1);
				break;
			case 'b':
				if (!mediaContainer.add(new Book())) System.exit(1);
				break;
			case 'v':
				if (!mediaContainer.add(new Video())) System.exit(1);
				break;
			case 'l':
	        	listAllMedia();
				break;
			case 'e':
				try {
					borrowMedia(inputScanner.nextInt());
				}
				catch (java.util.InputMismatchException e){
					System.out.println("Error: Please supply a valid signature.");
				}
				break;
			case 'r':
				try {
					returnMedia(inputScanner.nextInt());
				}
				catch (java.util.InputMismatchException e){
					System.out.println("Error: Please supply a valid signature.");
				}
				break;
			case 'd':
				try {
					deleteMedia(inputScanner.nextInt());
				}
				catch (java.util.InputMismatchException e){
					System.out.println("Error: Please supply a valid signature.");
				}
				break;
			case 'q':
				System.exit(0);
				break;
			}
			System.out.print("\n");
		}
	}
	
	public static void printCommands() {
		System.out.println("What do you want to do?\n" +
				"m: Create new medium\n" +
				"b: Create new book\n" +
				"v: Create new video\n" +
				"l: List all media\n" +
				"e SIGNATURE: Borrow media with the given signature\n" +
		        "r SIGNATURE: Return media with the given signature\n" +
		        "d SIGNATURE: Delete media with the given signature\n" +
		        "q: quit\n");
	}
	
	public static void listAllMedia() {
	    Medium.printTitles();
        for (mediaContainer.begin();
            (media = mediaContainer.getItem()) != null;
             mediaContainer.next()) System.out.println(media);
	}
	
	public static void borrowMedia(int signature) {
        // Borrow medium with given signature.
        for (mediaContainer.begin();
            (media = mediaContainer.getItem()) != null;
             mediaContainer.next()) {
        	if (media.getSignature() == signature) {
        		try {
        			media.borrow();
        		} catch (StatusError e) {
        			System.out.println(e);
        		}
        	}
        }
	}
	
	public static void returnMedia(int signature) {
        // Return medium with given signature.
        for (mediaContainer.begin();
            (media = mediaContainer.getItem()) != null;
             mediaContainer.next()) {
        	if (media.getSignature() == signature) {
        		try {
        			media.handBack();
        		} catch (StatusError e) {
        			System.out.println(e);
        		}
        	}
        }
	}
	
	public static void deleteMedia(int signature) {
        // Delete medium with given signature.
        for (mediaContainer.begin();
            (media = mediaContainer.getItem()) != null;
             mediaContainer.next()) {
        	if (media.getSignature() == signature) {
        		if (!mediaContainer.remove()) System.exit(0);           
        	}
        }
	}
}