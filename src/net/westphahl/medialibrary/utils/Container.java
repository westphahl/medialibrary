package net.westphahl.medialibrary.utils;

import net.westphahl.medialibrary.media.Medium;

public class Container {
	
	private ContainerElement head;
	private ContainerElement tail;
	private ContainerElement current;

	public boolean add(Medium newItem) {
		// Instead of throwing bad_alloc return a NULL pointer
		ContainerElement newElement = new ContainerElement();
		if (newElement == null) {
			return false;
		}
		if (this.tail != null) {
			this.tail.next = newElement;
		} else {
			this.head = newElement;
		}
		newElement.item = newItem;
		newElement.previous = this.tail;
		newElement.next = null;
		this.tail = newElement;
		return true;
	}

	public boolean remove() {
		ContainerElement oldElement = this.current;
		if (this.current == null) return false;
   
		this.current = oldElement.next;
		// Check if old element was tail
		if (this.current != null) {
			this.current.previous = oldElement.previous;
		} else {
			this.tail = oldElement.previous;
		}

		this.current = oldElement.previous;
		// Check if old element was head
		if (this.current != null) {
			this.current.next = oldElement.next;
		} else {
			this.head = oldElement.next;
			this.begin();
		}
		return true;
	}

	public void begin() {
		this.current = this.head;
	}

	public void next() {
		if (this.current != null) this.current = this.current.next;
	}

	public Medium getItem() {
		if (this.current != null) {
			return this.current.item;
		} else {
			return null;
		}
	}
}

class ContainerElement {
	protected Medium item;
	protected ContainerElement previous;
	protected ContainerElement next;
}