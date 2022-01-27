package com.leoncito.demo.controlador;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.leoncito.demo.interfaceService.IpersonaService;
import com.leoncito.demo.modelo.Persona;

@Controller
@RequestMapping
public class Controlador 
{
	@Autowired
	private IpersonaService service;
	@GetMapping("/")
	public String index()
	{
		return "base";
	}
	@GetMapping("/listar")
	public String listar(Model model)
	{
		index();
		List<Persona> personas = service.listar();
		model.addAttribute("personas", personas);
		return "index";
	}
	@GetMapping("/new")
	public String agregar(Model model)
	{
		model.addAttribute("persona", new Persona());
		return "form";
	}
	@PostMapping("/save")
	public String save(@Validated Persona p, Model model)
	{
		service.save(p);
		return "redirect:/listar";
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model)
	{
		Optional<Persona> persona = service.listarId(id);
		model.addAttribute("persona", persona);
		return "form";
	}
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id)
	{
		service.delete(id);
		return "redirect:/listar";
	}
}
