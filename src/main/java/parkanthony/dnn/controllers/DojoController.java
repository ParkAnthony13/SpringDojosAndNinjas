package parkanthony.dnn.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import parkanthony.dnn.models.DojoModel;
import parkanthony.dnn.models.NinjaModel;
import parkanthony.dnn.services.DojoService;
import parkanthony.dnn.services.NinjaService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	public DojoController (DojoService dojoService,NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	@RequestMapping("/")
	public String landing() {
		return "redirect:/dojos/new";
	}
	@RequestMapping("/dojos/new")
	public String newDojoPage(@ModelAttribute("dojo") DojoModel dojo, Model model) {
		List<DojoModel> dojos = dojoService.allItems();
		model.addAttribute("dojos", dojos);
		return "/dnn/newDojo.jsp";
	}
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String createNewDojo(@Valid @ModelAttribute("dojo") DojoModel dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/dnn/newDojo.jsp";
		} else {
			dojoService.createItem(dojo);
			return "redirect:/dojos/new";
		}
	}
	@RequestMapping("/dojos/{id}")
	public String ninjasInDojo(@PathVariable("id")Long id,Model model) {
		List<NinjaModel> ninjas = ninjaService.ninjasInDojo(id);
		DojoModel dojo = dojoService.findItem(id);
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("dojo", dojo);
		return "/dnn/index.jsp";
	}
}
