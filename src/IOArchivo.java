import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class IOArchivo extends UnicastRemoteObject implements IOArchivoInterface {

	private String nombreArchivo;

		public IOArchivo(String nombreArchivo) throws RemoteException{
			this.nombreArchivo=nombreArchivo;
		}

		public int cuentaLineas()throws IOException{
			int nLineas;
			String linea;
			FileReader lec= new FileReader(nombreArchivo);
			BufferedReader lectura=new BufferedReader(lec);
			nLineas=0;
			while ((linea = lectura.readLine())!= null) {
				nLineas++;
			}
			lec.close();
			return nLineas;
		}

		public int cuentaVocales()throws IOException{
			int nVocales;
			String linea;
			FileReader lec= new FileReader(nombreArchivo);
			BufferedReader lectura=new BufferedReader(lec);
			nVocales=0;
			while ((linea = lectura.readLine())!= null) {
				nVocales+=numeroDeVocales(linea);
			}
			lec.close();
			return nVocales;
		}
		
		public int numeroDeVocales(String frase) throws RemoteException {
			int res = 0;
			String fraseMin = frase.toLowerCase();

			for (int i = 0; i < fraseMin.length(); ++i) {
	    		switch(fraseMin.charAt(i)) {
	        		case 'a': 
	        		case 'e': 
	        		case 'i': 
	        		case 'o': 
	        		case 'u': 
	            		res++;
	            		break;
	        		default:
	   			}
	   		}
			return res;
		}
		@Override
                   public void escribe(String nombreArchivo,String linea) throws RemoteException {
	// TODO Auto-generated method stub
	         try {
		   BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo,true));
		   writer.write("\n"+linea);
		   writer.close();	
	         }catch(Exception e) {
		     System.out.println("No se ha encontrado el archivo");
	}	
}           
	 	public String imprimir()throws IOException{
			String linea;
			String texto=" ";
			FileReader lec= new FileReader(nombreArchivo);
			BufferedReader lectura=new BufferedReader(lec);
			
		
			while ((linea = lectura.readLine())!= null) {
				//System.out.println(linea);
				texto+=linea+"\n";
			}
			
			lec.close();
		
			return texto;
		}
		public void respaldar() throws IOException{
			String linea;
			FileWriter esc=new FileWriter("respaldo"+nombreArchivo);
			PrintWriter escritura=new PrintWriter(esc);
			
			FileReader lec= new FileReader(nombreArchivo);
			BufferedReader lectura=new BufferedReader(lec);
			
		
			while ((linea = lectura.readLine())!= null) {
				escritura.println(linea);
			}
			System.out.println("Archivo "+ this.nombreArchivo+" fue respaldado");
			esc.close();
			lec.close();
		}
		
		public void copiar(String nombreArchivoDestino) throws IOException{
			String linea;
			FileWriter esc=new FileWriter(nombreArchivoDestino,true);
			PrintWriter escritura=new PrintWriter(esc);
			
			FileReader lec= new FileReader(nombreArchivo);
			BufferedReader lectura=new BufferedReader(lec);
			
		
			while ((linea = lectura.readLine())!= null) {
				escritura.println(linea);
			}
			System.out.println("Archivo "+ this.nombreArchivo+" fue copiado");
			esc.close();
			lec.close();
		}
		public void renombrar(String nombreArchivo) throws RemoteException {
			File archivo1= new File(this.nombreArchivo);
			File archivo2=new File(nombreArchivo);
			boolean b=archivo1.renameTo(archivo2);
			if(b=true) {
				System.out.println("Archivo " + this.nombreArchivo + " fue renombrado a " + nombreArchivo);
			}else {
				System.out.println("Fallo en renombracion de archivo");
			}
		}
		
		public void eliminar(String nombreArchivo)throws RemoteException {
			File archivo= new File(nombreArchivo);
			boolean b=archivo.delete();
			
			if(b=true) 
				System.out.println("Archivo "+ nombreArchivo+" fue eliminado");
			else
				System.out.println("Fallo en eliminacion de archivo");
		}
}