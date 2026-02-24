package main.extraMethods;

public class TerminalTools {
	public static void clearTerminal(){
		System.out.print("\033[2J\033[H");
		System.out.flush();
	}

	void main(){
		System.out.println("sefijseifj");
		Extras.sleep(2);
		clearTerminal();
		//System.out.println("yayp");
	}
}
