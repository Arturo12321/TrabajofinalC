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

import com.registro.usuarios.modelo.Pasaje;
import com.registro.usuarios.servicio.PasajeService;

@Controller
@RequestMapping("/pasajes")
@SessionAttributes("pasaje")
public class PasajeControlador {
	@Autowired
	@Qualifier("pasaje")
	PasajeService pasajeService;
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<Pasaje> pasajes =pasajeService.listar();
		model.addAttribute("pasajes",pasajes);
		model.addAttribute("titulo","Lista de Pasajes");
		return "pasajeListar";
	}
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Pasaje pasaje = new Pasaje();
		model.put("pasaje",pasaje);
		model.put("btn", "Crear Pasaje");
		return "pasajeForm";
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("pasaje",pasajeService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "pasajeForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated Pasaje pasaje,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			pasaje = new Pasaje();
			model.addAttribute("pasaje",pasaje);
			model.addAttribute("btn", "Crear Pasaje");
			return "pasajeForm";
		}else {
		pasajeService.guardar(pasaje);
		return "redirect:/pasajes/listar";
		}
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		pasajeService.eliminar(id);
		return"redirect:/pasajes/listar";
	}	
}
