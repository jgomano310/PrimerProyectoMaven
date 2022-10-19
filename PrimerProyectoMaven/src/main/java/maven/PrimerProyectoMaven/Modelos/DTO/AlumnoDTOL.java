package maven.PrimerProyectoMaven.Modelos.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class AlumnoDTOL {

	public static List<AlumnoDto> ReaderAListAlumnoDTO(ResultSet resultadoConsulta) {
		// Metemos los datos en la lista alumnoDTo
		List<AlumnoDto> listAlumnos = new ArrayList<AlumnoDto>();
		try {
			while (resultadoConsulta.next()) {
				listAlumnos
						.add(new AlumnoDto((resultadoConsulta.getString("id_alumno")), resultadoConsulta.getString("Nombre"),
								resultadoConsulta.getString("Apellidos"), resultadoConsulta.getString("email")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAlumnos;
	}
}
