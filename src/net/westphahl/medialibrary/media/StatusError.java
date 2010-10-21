package net.westphahl.medialibrary.media;

public class StatusError extends Throwable {
	
	private String source;
	
	public StatusError(String source) {
		this.source = source;
	}

	public String toString() {
		return "Error on borrowing/returning '" + this.source + "'.";
	}
}
