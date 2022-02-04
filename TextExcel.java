package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    // Add your command loop here
		Spreadsheet spread = new Spreadsheet();
		Scanner s = new Scanner(System.in);
		
		String userInput = s.nextLine();
		while (!(userInput.equals("quit"))){
			System.out.println(spread.processCommand(userInput));
			userInput = s.nextLine();
		}
		s.close();
		
		/*TestsALL.Helper th = new TestsALL.Helper();
		System.out.println(th.getText());
		*/
	}
}
