import java.rmi.Naming;
import java.util.Scanner;
public class Cliente {
	 public static void main (String[] argv) {
		    try {
		      int op;
		      IOArchivoInterface archivo = (IOArchivoInterface) Naming.lookup ("//localhost/Archivo");

		      Scanner x=new Scanner(System.in);
		      op=1;	
		while(op!=9){	
		      System.out.println("Seleccione una opcion para realizar con el archivo:");
		      System.out.println("	1.Contar lineas");
		      System.out.println("	2.Contar vocales");
		      System.out.println("	3.Escribir el contenido");
		      System.out.println("	4.Imprimir archivo");
		      System.out.println("	5.Respaldar archivo");
		      System.out.println("	6.Copiar archivo");
		      System.out.println("	7.Renombrar archivo");
		      System.out.println("	8.Eliminar archivo");
		      System.out.println("	9.Salir");
		      op=x.nextInt();
		      String nombreArchivo;
		      switch(op) {
		      	case 1: System.out.println("El archivo tiene "+ archivo.cuentaLineas()+" lineas");
		      			break;
		      	case 2: System.out.println("El archivo tiene "+ archivo.cuentaVocales()+" vocales");
		      			break;
		      	case 3: System.out.println("Linea que desea agregar");
                                x.nextLine();
                                String linea = x.nextLine();
                                nombreArchivo = "archivo.txt";
                                archivo.escribe(nombreArchivo, linea);
                                break;
		      	case 4: System.out.println(archivo.imprimir());
		      			break;
		      	case 5: archivo.respaldar();
		      			break;
		      	case 6: System.out.println("Ingrese el nombre del archivo copia");
		      		x.nextLine();
				nombreArchivo=x.nextLine();
		      		archivo.copiar(nombreArchivo);
		      		break;
		      	case 7: System.out.println("Ingrese el nombre del archivo renombrado");
				x.nextLine();
		      		nombreArchivo=x.nextLine();
		      		archivo.renombrar(nombreArchivo);
		      		break;
		      	case 8: System.out.println("Ingrese el nombre del archivo a eliminar");
				x.nextLine();
      				nombreArchivo=x.nextLine();
      				archivo.eliminar(nombreArchivo);
		      		break;
			case 9:System.out.println("Programa finalizado");
				break;
		      	default:System.out.println("Opcion no valida");
		      			break;
		      }
		     }
		    } catch (Exception e) {
		      System.out.println ("Client exception: " + e);
		    }
		  }
}