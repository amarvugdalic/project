package avugdalic_1_23;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WebPage {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> html = new ArrayList<String>();

		createBaseHTML(html);
		System.out.println("Enter Title to Your Web Page:\n");
		String title = scan.nextLine();
		System.out.println("Enter Your Name:\n");
		String name = scan.nextLine();
		System.out.println("Enter Your Description:\n");
		String desc = scan.nextLine();

		html.add(2, title + "<br>");
		html.add(5, name + "<br>");
		html.add(8, desc + "<br>");
		int choice = 0;

		while (choice != 9) {
			menu();
			choice = scan.nextInt();

			scan.nextLine();
			switch (choice) {
			case 1:
				String prevTitle = title;
				System.out.println("Change Title:\n");
				title = scan.nextLine();
				html.set(html.indexOf(prevTitle + "<br>"), title + "<br>");
				break;
			case 2:
				String prevName = name;
				System.out.println("Change Name:\n");
				name = scan.nextLine();
				html.set(html.indexOf(prevName + "<br>"), name + "<br>");
				break;
			case 3:
				String prevDesc = desc;
				System.out.println("Change Description:\n");
				desc = scan.nextLine();
				html.set(html.indexOf(prevDesc + "<br>"), desc + "<br>");
				break;
			case 4:
				System.out.println("Change Text Color of:");
				changeColor(html);
				break;
			case 5:
				System.out.println("Change Centering of:");
				changeCentering(html);
				break;
			case 6:
				System.out.println("Change Style of:");
				changeStyle(html);
				break;
			case 7:
				writeToFile(html);
				break;
			case 8: 
				printToConsole(html);
				break;
			case 9:
				break;
			}
		}
	}

	public static void createBaseHTML(ArrayList<String> html) {
		html.add("<html>");
		html.add("<head>");

		html.add("</head>");
		html.add("<body>");

		html.add("</body>");
		html.add("<body2>");

		html.add("</body2>");

		html.add("</html>");

	}

	public static void changeColor(ArrayList<String> html) {
		Scanner scan = new Scanner(System.in);

		System.out.println("1. Title\n2. Name\n3. Description\n");
		int TND = scan.nextInt();

		System.out.println("Choose a Color:");
		System.out.println("1. Red\n2. Orange\n 3. Yellow\n4. Green\n5. Blue\n6. Purple\n7. Gray\n8. Black");
		int color = scan.nextInt();

		String fontColor = "";

		switch (color) {
		case 1:
			fontColor = "<font color = \"red\">";
			break;
		case 2:
			fontColor = "<font color = \"orange\">";
			break;
		case 3:
			fontColor = "<font color = \"yellow\">";
			break;
		case 4:
			fontColor = "<font color = \"green\">";
			break;
		case 5:
			fontColor = "<font color = \"blue\">";
			break;
		case 6:
			fontColor = "<font color = \"purple\">";
			break;
		case 7:
			fontColor = "<font color = \"gray\">";
			break;
		case 8:
			fontColor = "<font color = \"black\">";
			break;
		}

		switch (TND) {
		case 1: // change title color
			html.add(html.indexOf("<head>") + 1, fontColor);
			html.add(html.indexOf("</head>"), "</font>");
			break;
		case 2:
			html.add(html.indexOf("<body>") + 1, fontColor);
			html.add(html.indexOf("</body>"), "</font>");
			break;
		case 3:
			html.add(html.indexOf("<body2>") + 1, fontColor);
			html.add(html.indexOf("</body2>"), "</font>");
			break;
		}

	}

	public static void changeCentering(ArrayList<String> html) {
		Scanner scan = new Scanner(System.in);

		System.out.println("1. Title\n2. Name\n3. Description\n");
		int TND = scan.nextInt();

		System.out.println("Choose a Centering:");
		System.out.println("1. Left\n2. Center\n 3. Right");
		int centering = scan.nextInt();

		String LCR = "";

		switch (centering) {
		case 1:
			LCR = "<p style=\"text-align:left;\">";
			break;
		case 2:
			LCR = "<p style=\"text-align:center;\">";
			break;
		case 3:
			LCR = "<p style=\"text-align:right;\">";
			break;
		}
		
		switch (TND) {
		case 1: // change title color
			html.add(html.indexOf("<head>") + 1, LCR);
			html.add(html.indexOf("</head>"), "</p>");
			break;
		case 2:
			html.add(html.indexOf("<body>") + 1, LCR);
			html.add(html.indexOf("</body>"), "</p>");
			break;
		case 3:
			html.add(html.indexOf("<body2>") + 1, LCR);
			html.add(html.indexOf("</body2>"), "</p>");
			break;
		}
	}

	public static void changeStyle(ArrayList<String> html) {
		Scanner scan = new Scanner(System.in);

		System.out.println("1. Title\n2. Name\n3. Description\n");
		int TND = scan.nextInt();
		
		System.out.println("Choose a Style:");
		System.out.println("1. Bold\n2. Italics\n 3. Underline");
		int style = scan.nextInt();

		String BIU = "";
		String BIU2 = "";
		
		switch (style) {
		case 1:
			BIU = "<b>";
			BIU2 = "</b>";
			break;
		case 2:
			BIU = "<i>";
			BIU2= "</i>";
			break;
		case 3:
			BIU = "<u>";
			BIU2 = "</u>";
			break;
		}
		
		switch (TND) {
		case 1: // change title color
			html.add(html.indexOf("<head>") + 1, BIU);
			html.add(html.indexOf("</head>"), BIU2);
			break;
		case 2:
			html.add(html.indexOf("<body>") + 1, BIU);
			html.add(html.indexOf("</body>"), BIU2);
			break;
		case 3:
			html.add(html.indexOf("<body2>") + 1, BIU);
			html.add(html.indexOf("</body2>"), BIU2);
			break;
		}
		
	}
	
	public static void printToConsole(ArrayList<String> html) {
		for(String m: html) {
			System.out.println(m);
		}
	}
	
	public static void menu() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Edit Web Page!:");
		System.out.println("   1.  Change Title");
		System.out.println("   2.  Change Name");
		System.out.println("   3.  Change Description ");
		System.out.println("   4.  Change Text Color");
		System.out.println("   5.  Change Centering");
		System.out.println("   6.  Set Bold/Italics");
		System.out.println("   7.  Save File");
		System.out.println("   8.  Write out the HTML Code to Console");
		System.out.println("   9.  End");
		System.out.println("\n CHOICE:");

	}

	public static void writeToFile(ArrayList<String> es) {
		String filename; // File name

		Scanner scan = new Scanner(System.in);
		System.out.println("Save filename with .html extension");
		// Get the filename.
		filename = pickLocOut();

		// Open the file.
		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(filename);

			// Get data and write it to the file.
			for (String s : es) {

				outputFile.println(s);
			}

		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			outputFile.close();
		}

	}

	public static String pickLocOut() {
		Frame f = new Frame();
		// decide from where to read the file
		FileDialog foBox = new FileDialog(f, "Pick location for writing your file", FileDialog.SAVE);
		System.out.println("The dialog box might appear behind Eclipse.  "
				+ "\n   Choose where you would like to write your data.");
		foBox.setVisible(true);
		// get the absolute path to the file
		String foName = foBox.getFile();
		String dirPath = foBox.getDirectory();
		String name = dirPath + foName;

		return name;
	}
}
