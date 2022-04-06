import java.rmi.Naming;


public class Server {
	public static void main (String[] argv) {
	    try {
	      Naming.rebind ("Archivo",new IOArchivo("archivo.txt"));
	      System.out.println ("Server is ready.");
	    } catch (Exception e) {
	      System.out.println ("Server failed: " + e);
	    }
	  }
}
