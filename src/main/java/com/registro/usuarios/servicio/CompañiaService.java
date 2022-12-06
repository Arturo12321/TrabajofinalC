package com.registro.usuarios.servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.registro.usuarios.modelo.Compañia;
import com.registro.usuarios.repositorio.ICompañia;
@Service("compañia")
public class CompañiaService {
	@Autowired
	ICompañia iCompañia;
	public void guardar(Compañia compañia) {
		iCompañia.save(compañia);
	}
	public List<Compañia> listar() {
		return iCompañia.findAll();
	}
	public Compañia buscar (Long id) {
		return iCompañia.findById(id);
	}
	public boolean eliminar (Long id) {
		try {
			iCompañia.delete(iCompañia.findById(id));
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
