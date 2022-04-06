import java.io.IOException;
import java.io.OutputStream;
import java.rmi.*;
public interface IOArchivoInterface extends Remote{
	public int cuentaLineas()throws IOException;
	public int cuentaVocales()throws IOException;
	public int numeroDeVocales(String frase) throws RemoteException;
	public void escribe(String nombreArchivo,String Linea) throws RemoteException;
	public String imprimir()throws IOException;
	public void respaldar() throws IOException;
	public void copiar(String nombreArchivoDestino) throws IOException;
	public void renombrar(String nombreArchivo)throws RemoteException ;
	public void eliminar(String nombreArchivo)throws RemoteException ;
}