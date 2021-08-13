package parkanthony.dnn.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import parkanthony.dnn.models.DojoModel;
import parkanthony.dnn.models.NinjaModel;
import parkanthony.dnn.services.DojoService;
import parkanthony.dnn.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	@RequestMapping("/ninjas/new")
	public String newNinjaPage(@ModelAttribute("ninja") NinjaModel ninja,Model model) {
		List<DojoModel> dojos = dojoService.allItems();
		model.addAttribute("dojos", dojos);
		return "/dnn/newNinja.jsp";
	}
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String createNewNinja(@Valid @ModelAttribute("ninja") NinjaModel ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "/dnn/newNinja.jsp";
		} else {
			ninjaService.createItem(ninja);
			return "redirect:/";
		}
	}
}
