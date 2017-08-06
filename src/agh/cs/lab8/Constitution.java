package agh.cs.lab8;

import java.util.ArrayList;
import java.util.List;

public class Constitution {

	List<Article> article = new ArrayList<>();
	List<Chapter> chapter = new ArrayList<>();

	private String previewText = "";

	private String name;

	public Constitution(String nazwa) {
		this.name = nazwa;
		Parser as = new Parser();
		as.openFile(this);
		showAll();
	}

	public Constitution(String name, int nr, String dane) {
		this.name = name;

		Parser as = new Parser();
		as.openFile(this);
		
		if (dane.equals("R") && nr < 11 && nr > 0)
			showChapter(nr);

			
		if (dane.equals("A") && nr < 234 && nr > 0)
			showArticle(nr);
	
	}

	public Constitution(String nazwa, int start, int end) {
		if (start > end || start < 0 || end > 243)
			throw new IllegalArgumentException("bledne wartosci");

		this.name = nazwa;
		Parser as = new Parser();
		as.openFile(this);
		show(start, end);
	}

	

	public void showArticle(int start) {

		System.out.println(article.get(start - 1));
	}

	public void show(int start, int end) {
		for (int i = start - 1; i < end; i++) {
			System.out.println(article.get(i));
		}
	}

	public void showChapter(int numberOfChapter) {

		int first = chapter.get(numberOfChapter - 1).getFirst();
		int last = chapter.get(numberOfChapter - 1).getLast();
		String Preview = chapter.get(numberOfChapter - 1).getStart();

		System.out.println(Preview);
		show(first, last);
	}

	public void showAll() {
		System.out.println(getPreview());
		for (int i = 1; i < 14; i++) {
			showChapter(i);
		}

	}

	public String getName() {
		return name;
	}

	public String getPreview(){
		return previewText;
	}
	public void setPreview(String previewText){
		this.previewText=previewText;
	}
}
