package com.tesji.estoico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alumnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlumnoService {
	
	private static Map<Integer, Alumno> alumnos = new HashMap<>();
	
	static {
		Alumno david = new Alumno(201723504, "David", "Osornio", "Ing Sistemas");
		Alumno araceli = new Alumno(2017235045, "Araceli", "Angeles", "Ing Industrial");
		
		alumnos.put(1, david);
		alumnos.put(2, araceli);
	}
	
	/*
	 * Obtener lista de alumnos
	 */
	@GET
	public List<Alumno> getAlumnos(){
		return new ArrayList<Alumno>(alumnos.values());
	}
	
	/*
	 * obtener un alumno por id 
	 */
	@GET
	@Path("/{alumnoId}")
	public Alumno getalumno(@PathParam("alumnoId") int alumnoId) {
		return alumnos.get(alumnoId);
	}

	/*
	 * Agragar un nuervo alumno
	 */
	@POST
	public void addAlumno(Alumno alumno) {
		alumnos.put(alumnos.size() + 1, alumno);
	}
	
	/*
	 * Actualizar un alumno
	 */
	@PUT
	@Path("/{alumnoId}")
	public void updateAlumno(@PathParam("alumnoId") int id, Alumno alumno) {
		alumnos.put(id, alumno);
	}
	
	/*
	 *Eleminar alumno 
	 */
	@DELETE
	@Path("/{alumnoId}")
	public void deleteAlumno(@PathParam("alumnoId") int id) {
		alumnos.remove(id);
	}
}
