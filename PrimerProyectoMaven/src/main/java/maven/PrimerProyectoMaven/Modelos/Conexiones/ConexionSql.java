package maven.PrimerProyectoMaven.Modelos.Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSql {

	public Connection añadirConexionPostgreSql(final String user, final String pass, final String port,
			final String host, final String db) {
		// Hacemos la conexión
		Connection conexion = null;
		// Creamos la url para poder hacer la conexión a la base de datos
		String url = "";
		url = "jdbc:postgresql://" + host + ":" + port + "/" + db;

		try {

			/*
			 * Utilizamos el Class.forName para obtener la instancia de la clase java para
			 * registrarla como dirver JDBC
			 */
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException cnfe) {
				System.out.println("Error en registro driver PostgreSQL: " + cnfe);
			}

			// Conexión a la base de datos en PostgreSQL y la validación
			conexion = DriverManager.getConnection(url, user, pass);
			// Si es valida continuamos y si no lo paramos
			boolean esValida = conexion.isValid(50000);
			if (esValida == false) {
				conexion = null;
			}
			System.out
					.println(esValida ? "La Conexión a PostgreSQL es válida" : "La Conexión a PostgreSQL no es válida");
			return conexion;

		} catch (java.sql.SQLException jsqle) {

			System.out.println("Error en conexión a PostgreSQL (" + url + "): " + jsqle);
			return conexion;

		}}
}
