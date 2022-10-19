package maven.PrimerProyectoMaven.Modelos.Consultas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import maven.PrimerProyectoMaven.Modelos.DTO.AlumnoDTOL;
import maven.PrimerProyectoMaven.Modelos.DTO.AlumnoDto;



public class ConsultasPostgres {

	public static List<AlumnoDto> listarAlumnos(Connection conexion) {
		// Declaramos la lista
		List<AlumnoDto> listAlumnos = new ArrayList<AlumnoDto>();
		// Declaramos el statement y la respuesta
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		if (conexion != null) {

			try {
				System.out.println("HACEMOS LA CONSULTA listar");
				// Abrimos la declaracion
				declaracionSQL = conexion.createStatement();
				// Se hace y ejecuta la consulta
				resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"proyectoEclipse\".\"Alumnos\"");

				// Lo metemos en la lista

				listAlumnos = AlumnoDTOL.ReaderAListAlumnoDTO(resultadoConsulta);

			} catch (SQLException e) {

				System.out.println("Error generando la declaracionSQL: " + e);

			}
		}
		return listAlumnos;
	}

	// Insert alumno
	public static void insertarAlumnos(Connection conexion) {
		// Declaramos el state y la respuesta
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		if (conexion != null) {

			try {
				System.out.println("HACEMOS El INSERT");
				// Abrimos la declaracion
				declaracionSQL = conexion.createStatement();
				// Se hace y ejecuta la consulta
				declaracionSQL.
						executeUpdate("INSERT INTO \"proyectoEclipse\".\"Alumnos\" (id_alumno,Nombre,Apellidos,email)"
								+ "VALUES(5,'emilio','garcia','fran@gmail.com')");

			} catch (SQLException e) {
				System.out.println("Error generando la declaracionSQL (insert): " + e);

			}
		}
	}

	// Delete alumno

	public static void eliminarAlumnos(Connection conexion) {
		// Declaramos el state y la respuesta
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		if (conexion != null) {

			try {
				System.out.println("HACEMOS El DELETE");
				// Abrimos la declaracion
				declaracionSQL = conexion.createStatement();
				// Se hace y ejecuta la consulta
				declaracionSQL
						.executeUpdate("DELETE FROM \"proyectoEclipse\".\"Alumnos\" WHERE id_alumno='2'");

			} catch (SQLException e) {

				System.out.println("Error generando la declaracionSQL: " + e);

			}
		}
	}

	// Update alumno
	public static void cambiarDatosAlumno(Connection conexion) {
		// Declaramos el state y la respuesta
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		if (conexion != null) {

			try {
				System.out.println("HACEMOS El UPDATE");
				// Abrimos la declaracion
				declaracionSQL = conexion.createStatement();
				// Se hace y ejecuta la consulta
				declaracionSQL.executeUpdate(
						"UPDATE \"proyectoEclipse\".\"Alumnos\" SET email='MANUEL@update.com' WHERE id_alumno=1 ");

			} catch (SQLException e) {
				System.out.println("Error generando la declaracionSQL (UPDATE): " + e);

			}
		}
	}

	// Create table

	public static void crearTabla(Connection conexion) {
		// Declaramos el state y la respuesta
		Statement declaracionSQL = null;
		if (conexion != null) {

			try {
				System.out.println("CREAMOS TABLA NUEVA");
				// Abrimos la declaracion
				declaracionSQL = conexion.createStatement();
				// Se hace y ejecuta la consulta
				declaracionSQL.executeUpdate(
						"CREATE TABLE IF NOT EXISTS ejemplo (prueba CHARACTER VARYING NOT NULL)");
			} catch (SQLException e) {
				System.out.println("Error generando la declaracionSQL (CREATE TABLE): " + e);

			}
		}}
}
