package net.westphahl.medialibrary.media;

import java.util.Scanner;

import net.westphahl.medialibrary.media.Medium;

public class Video extends Medium {
	
	private float length;
	
	public Video() {
		super(0);
		System.out.println("Please enter info for video: signature, length and title");
		this.type = "Video";
		this.signature = readSignature();
		this.length = readLength();
		this.title = readTitle();
	}
	
	public String toString() {
		return String.format("%s %s", super.toString(), "Length " + this.length);
	}
	
	private float readLength() {
		Scanner inputScanner;
		
		System.out.print("Length: ");
		do {
			inputScanner = new Scanner(System.in);
		} while (!inputScanner.hasNextFloat());
		return inputScanner.nextFloat();	
	}
}