package agh.cs.lab8;

public class Chapter {

	private int first;
	private int last;
	private  String start;

	public Chapter(String start, int first, int last) {
		this.start = start;
		this.first = first;
		this.last = last;
	}

	public int getFirst() {
		return first;
	}

	public int getLast() {
		return last;
	}

	public String getStart() {
		return start;
	}
}
