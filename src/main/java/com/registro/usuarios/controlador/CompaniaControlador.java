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

import com.registro.usuarios.modelo.Compania;
import com.registro.usuarios.servicio.CompaniaService;
 
@Controller
@RequestMapping("/companias")
@SessionAttributes("compania")
public class CompaniaControlador {
	@Autowired
	@Qualifier("compania")
	CompaniaService companiaService;
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<Compania> companias =companiaService.listar();
		model.addAttribute("companias",companias);
		model.addAttribute("titulo","Lista de Compañias");
		return "companiaListar";
	}
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Compania compania = new Compania();
		model.put("compania",compania);
		model.put("btn", "Crear Compania");
		return "companiaForm";
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("compania",companiaService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "companiaForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated Compania compania,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			compania = new Compania();
			model.addAttribute("compania",compania);
			model.addAttribute("btn", "Crear Compania");
			return "companiaForm";
		}else {
		companiaService.guardar(compania);
		return "redirect:/companias/listar";
		}
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		companiaService.eliminar(id);
		return"redirect:/companias/listar";
	}	
}
