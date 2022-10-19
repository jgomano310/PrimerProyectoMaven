package maven.PrimerProyectoMaven;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import maven.PrimerProyectoMaven.Modelos.Conexiones.ConexionSql;
import maven.PrimerProyectoMaven.Modelos.Consultas.ConsultasPostgres;
import maven.PrimerProyectoMaven.Modelos.DTO.AlumnoDto;
import maven.PrimerProyectoMaven.Util.Variables;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ConexionSql conexion = new ConexionSql();

		// Instanciamos variablesConexionPostgreSQL para poder recoger los credenciales
		// de inicio de sesion
		
    	
		// Instanciamos las listas
		List<AlumnoDto> listAlumnos = new ArrayList<AlumnoDto>();

		// Hacemos su desestructuracion
		final String HOST =Variables.getHost();
		final String PORT = Variables.getPort();
		final String DB = Variables.getDb();
		final String USER = Variables.getUser();
		final String PASS = Variables.getPass();

		// Hacemos la conexion
		Connection cn = conexion.añadirConexionPostgreSql(USER, PASS, PORT, HOST, DB);

		// Hacemos el insert para ver los datos por pantalla
		ConsultasPostgres.insertarAlumnos(cn);
		// Una vez hecha la conexión hacemos la consulta
		

		// metemos los valores en la lista
		listAlumnos = ConsultasPostgres.listarAlumnos(cn);

		// Imprimimos por pantalla

		for (int i = 0; i < listAlumnos.size(); i++) {
			System.out.println("id: " + " " + listAlumnos.get(i).id_alumno + " || " + "Nombre: " + " "
					+ listAlumnos.get(i).Nombre + " || " + "Apellidos: " + " " + listAlumnos.get(i).Apellidos + " || "
					+ "email: " + " " + listAlumnos.get(i).email);
		}
		//delete
		ConsultasPostgres.eliminarAlumnos(cn);
		
		//update
		ConsultasPostgres.cambiarDatosAlumno(cn);
		
		//Creamos la tabla ejemplo
		ConsultasPostgres.crearTabla(cn);
		
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
