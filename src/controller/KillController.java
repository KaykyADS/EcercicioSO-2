package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public KillController() {
		super();
	}
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void chamaProcessos(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void mataProcessos(String processo, String os) {
		String cmdPid;
		String cmdNome;
		if (os.contains("Windows")) {
			cmdPid = "TASKKILL /PID";
			cmdNome = "TASKKILL /IM";
		} else {
			cmdPid = "kill -9";
			cmdNome = "pkill -f";
		}
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		try {
			pid = Integer.parseInt(processo);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch(Exception e) {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(processo);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}