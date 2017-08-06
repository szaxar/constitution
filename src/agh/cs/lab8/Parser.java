package agh.cs.lab8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

	public void openFile(Constitution consty) {

		boolean testPreview = true;
		boolean testArticle = false;
		boolean testChapter = false;
		boolean testEnd = false;
		String end = "dnia jej og³oszenia.";
		String tmp = "";
		String tmpRoz = "";
		String tmpEnd = "";
		String tmpEnd2 = "";
		String tmpEnd3 = "";
		int tmpRest = 0;
		int numberOfArticle = 2;
		int numberOfChapter = 2;
		Number number = new Number(numberOfChapter);
		int one = 1;
		FileReader fr = null;
		String line = "";

		// OTWIERANIE PLIKU:
		try {
			fr = new FileReader(consty.getName());
		} catch (FileNotFoundException e) {
			System.out.println("B£¥D PRZY OTWIERANIU PLIKU!");
			System.exit(1);
		}

		BufferedReader bfr = new BufferedReader(fr);
		// ODCZYT KOLEJNYCH LINII Z PLIKU:
		try {
			while ((line = bfr.readLine()) != null) {

				Trash testTrash = new Trash(line);

				if (testEnd) {
					testEnd = false;
					tmpEnd3 = "";
					for (int i = tmpEnd.length() - 1; i > -1; i--) {
						tmpEnd3 = tmpEnd3 + tmpEnd.charAt(i);
					}
					tmpEnd = tmpEnd3;

					for (int i = 0; i < line.length(); i++) {
						if (line.charAt(i) == ' ' || line.charAt(i) == ','
								|| line.charAt(i) == '.'
								|| line.charAt(i) == ':') {
							tmpRest = i;

							break;
						} else
							tmpEnd2 = tmpEnd2 + line.charAt(i);
					}

					line = tmpEnd + tmpEnd2
							+ line.substring(tmpRest, line.length());
					tmpEnd = "";
					tmpEnd2 = "";
				}

				if (line.endsWith("-")) {
					testEnd = true;

					for (int i = line.length() - 2; i > 0; i--) {
						if (line.charAt(i) == ' ') {
							tmpRest = i;
							break;

						} else
							tmpEnd = tmpEnd + line.charAt(i);
					}
					line = line.substring(0, tmpRest);
				}

				if (line.equals(new String("Rozdzia³ I"))) { // Pretext
					testPreview = false;
					testChapter = true;

				}

				if (testPreview && !testTrash.getTest())
					consty.setPreview(consty.getPreview() + line + "\n"); // Pretext

				if ((testChapter && line.equals(new String("Rozdzia³ "
						+ number.get())))
						|| line.equals(end) && !testTrash.getTest()) {
					testArticle = false;

					consty.chapter.add(new Chapter(tmpRoz, one, numberOfArticle - 1));
					one = numberOfArticle;
					tmpRoz = "";
					numberOfChapter++;
					number = new Number(numberOfChapter);

				}

				if (line.equals(new String("Art. " + numberOfArticle + "."))
						|| line.equals(new String("Art. 1.")))
					testArticle = true;

				if (testArticle == false && testChapter && !testTrash.getTest()) {
					tmpRoz = tmpRoz + line + "\n";
				}

				if (testArticle && line.equals(new String("Art. " + numberOfArticle + "."))
						|| line.equals(end)) {

					if (line.equals(end)) {
						tmp = tmp + end;
						Article ar = new Article(consty, tmp);
						consty.article.add(ar);
					} else {
						Article ar = new Article(consty, tmp);
						consty.article.add(ar);
						tmp = "";
						numberOfArticle++;
					}

				}

				if (testArticle && line != new String("Art. " + numberOfArticle + ".")
						&& !testTrash.getTest()) {

					tmp = tmp + line + "\n";
				}

			}
		} catch (IOException e) {
			System.out.println("B£¥D ODCZYTU Z PLIKU!");
			System.exit(2);
		}

		try {
			fr.close();
		} catch (IOException e) {
			System.out.println("B£¥D PRZY ZAMYKANIU PLIKU!");
			System.exit(3);
		}

	}

}
