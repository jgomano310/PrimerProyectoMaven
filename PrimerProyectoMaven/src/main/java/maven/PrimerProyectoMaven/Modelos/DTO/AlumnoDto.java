package maven.PrimerProyectoMaven.Modelos.DTO;

public class AlumnoDto {

	
		public String id_alumno = "";
		public String Nombre = "";
		public String Apellidos = "";
		public String email = "";

		// Constructor
		public AlumnoDto(String Id, String Nombre, String Apellidos, String Email) {
			this.id_alumno = Id;
			this.Nombre = Nombre;
			this.Apellidos = Apellidos;
			this.email = Email;
		}
}
