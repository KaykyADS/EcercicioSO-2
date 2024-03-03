package view;
import java.util.Scanner;

import controller.KillController;

public class Principal {
	public static void main (String[] args) {
		KillController kill = new KillController();
		String os = kill.os();	
		
		if (os.contains("Windows")) {
			String process = "TASKLIST /FO TABLE";
			kill.chamaProcessos(process);
			Scanner leia = new Scanner(System.in);
			System.out.print("Digite o processo que quer matar: ");
			String param = leia.next();
			kill.mataProcessos(param, os);
		} else {
			String process = "ps -ef";
			kill.chamaProcessos(process);
			Scanner leia = new Scanner(System.in);
			System.out.print("Digite o processo que quer matar: ");
			String param = leia.next();
			kill.mataProcessos(param, os);
		}
	}
}