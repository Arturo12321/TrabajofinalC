package com.registro.usuarios.controlador;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.registro.usuarios.modelo.Compañia;
import com.registro.usuarios.servicio.CompañiaService;
 
@Controller
@RequestMapping("/compañias")
@SessionAttributes("compañia")
public class CompañiaControlador {
	@Autowired
	@Qualifier("compañia")
	CompañiaService compañiaService;
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<Compañia> compañias =compañiaService.listar();
		model.addAttribute("compañias",compañias);
		model.addAttribute("titulo","Lista de Compañias");
		return "compañiaListar";
	}
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Compañia compañia = new Compañia();
		model.put("compañia",compañia);
		model.put("btn", "Crear Compañia");
		return "compañiaForm";
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("compañia",compañiaService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "compañiaForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated Compañia compañia,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			compañia = new Compañia();
			model.addAttribute("compañia",compañia);
			model.addAttribute("btn", "Crear Compañia");
			return "compañiaForm";
		}else {
		compañiaService.guardar(compañia);
		return "redirect:/compañias/listar";
		}
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		compañiaService.eliminar(id);
		return"redirect:/compañias/listar";
	}	
}
