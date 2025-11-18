package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.EmpresaEnvios;
import co.edu.uniquindio.poo.envioproyecto.model.Repartidor;

import java.util.List;

/**
 * Controlador de gestión de repartidores. Provee operaciones CRUD básicas
 * sobre la colección de repartidores almacenada en {@link EmpresaEnvios}.
 */
public class RepartidorGestionController {

	private static EmpresaEnvios empresa() {
		return EmpresaEnvios.getinstancia();
	}

	/** Agrega un repartidor si su id no existe. */
	public static boolean agregarRepartidor(Repartidor repartidor) {
		if (buscarRepartidorPorId(repartidor.getIdRepartidor()) == null) {
			empresa().agregarRepartidor(repartidor);
			return true;
		}
		return false;
	}

	/** Elimina un repartidor por id, si existe. */
	public static boolean eliminarRepartidor(int idRepartidor) {
		Repartidor r = buscarRepartidorPorId(idRepartidor);
		if (r != null) {
			empresa().eliminarRepartidor(r);
			return true;
		}
		return false;
	}

	/** Actualiza campos básicos del repartidor. */
	public static boolean actualizarRepartidor(int idRepartidor, String nombre, String cedula, String correo) {
		Repartidor r = buscarRepartidorPorId(idRepartidor);
		if (r != null) {
			r.setNombre(nombre);
			r.setCedula(cedula);
			r.setCorreo(correo);
			return true;
		}
		return false;
	}

	/** Busca un repartidor por su identificador. */
	public static Repartidor buscarRepartidorPorId(int idRepartidor) {
		List<Repartidor> list = empresa().getListRepartidor();
		for (Repartidor r : list) {
			if (r.getIdRepartidor() == idRepartidor) return r;
		}
		return null;
	}
}


