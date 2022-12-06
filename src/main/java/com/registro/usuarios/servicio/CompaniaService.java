package com.registro.usuarios.servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.registro.usuarios.modelo.Compania;
import com.registro.usuarios.repositorio.ICompania;
@Service("compania")
public class CompaniaService {
	@Autowired
	ICompania iCompania;
	public void guardar(Compania compania) {
		iCompania.save(compania);
	}
	public List<Compania> listar() {
		return iCompania.findAll();
	}
	public Compania buscar (Long id) {
		return iCompania.findById(id);
	}
	public boolean eliminar (Long id) {
		try {
			iCompania.delete(iCompania.findById(id));
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
