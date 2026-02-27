package main.extraMethods;

public class TerminalTools {
	public static void clearTerminal(){
		//Clear screen, place cursor at start
		System.out.print("\033[2J\033[H");
		//Clear scroll back (Most consoles)
		System.out.print("\033[3J");
		//IDK
		System.out.flush();
	}

	/*void main(){
		System.out.println("sefijseifj");
		Extras.sleep(2);
		clearTerminal();
		//System.out.println("yayp");
	}*/
}
