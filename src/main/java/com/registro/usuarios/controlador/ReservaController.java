package com.registro.usuarios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.registro.usuarios.modelo.Destino;
import com.registro.usuarios.modelo.Reserva;
import com.registro.usuarios.servicio.CompañiaService;
import com.registro.usuarios.servicio.DestinoService;
import com.registro.usuarios.servicio.PasajeService;
import com.registro.usuarios.servicio.ReservaService;


@Controller
@RequestMapping("/reserva")
@SessionAttributes("reserva")
public class ReservaController {
	@Autowired
	@Qualifier("reserva")
	ReservaService reservaService;
	
	@Autowired
	@Qualifier("destino")
	DestinoService destinoService;
	
	@Autowired
	@Qualifier("pasaje")
	PasajeService pasajeService;
	
	@Autowired
	@Qualifier("compañia")
	CompañiaService compañiaService;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Reserva> reserva = reservaService.listar();
		model.addAttribute("reserva",reserva);
		model.addAttribute("titulo","Lista de Reserva");
		return "reservaListar";
	}
	
	@RequestMapping("/form")
	public String formulario(Model model) {
		Reserva reserva= new Reserva();
		model.addAttribute("reserva", reserva);
		model.addAttribute("destino", destinoService.listar());
		model.addAttribute("clientes", pasajeService.listar());
		model.addAttribute("clientes", compañiaService.listar());
		model.addAttribute("btn", "Registrar Venta");
		return "reservaForm";
	}
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated Reserva reserva, Model model) {
		try {
			String codigo =reserva.getIdes();
			Destino pro = destinoService.buscar(codigo);

			if(reserva.getCantidad() > 0) {
				double pago = reserva.getCantidad() * pro.getCost_dest();
				reserva.setPago(pago);
				
				//destinoService.guardar(pro);
				reservaService.guardar(reserva);
			}else {
				model.addAttribute("ERROR", "Inserte cantidad");
				reserva= new Reserva();
				model.addAttribute("reserva", reserva);
				model.addAttribute("destino", destinoService.listar());
				model.addAttribute("pasaje", pasajeService.listar());
				model.addAttribute("compañia", compañiaService.listar());
				model.addAttribute("btn", "Registrar Reserva");
				return "reservaForm";
			}
		} catch (Exception e) {
		}
		return "redirect:/reserva/listar";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("reserva", reservaService.buscar(id));
		model.addAttribute("destino", destinoService.listar());
		model.addAttribute("pasaje", pasajeService.listar());
		model.addAttribute("compañia", compañiaService.listar());
		model.addAttribute("btn","Actualiza Registro");
		return "reservaForm";
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		reservaService.eliminar(id);
		return "redirect:/reserva/listar";
	}
}
