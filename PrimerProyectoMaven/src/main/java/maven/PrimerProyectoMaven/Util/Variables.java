package maven.PrimerProyectoMaven.Util;

public class Variables {

	
		// Variables de conexion a postgreSQL
		static final String USER = "postgres";
		static final String PASS = "AlumnoCMI2";
		static final String PORT = "5432";
		static final String HOST = "localhost";
		static final String DB = "EjemploInicial";

		// Getter para recoger la información
		public static String getUser() {
			return USER;
		}

		public static String getPass() {
			return PASS;
		}

		public static String getPort() {
			return PORT;
		}

		public static String getHost() {
			return HOST;
		}

		public static String getDb() {
			return DB;
		}
	}

