package parkanthony.dnn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import parkanthony.dnn.models.NinjaModel;
import parkanthony.dnn.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	public List<NinjaModel> allItems(){
		return ninjaRepository.findAll();
	}
	public List<NinjaModel> ninjasInDojo(Long id){
		return ninjaRepository.findByDojoIdEquals(id);
	}
	public NinjaModel createItem(NinjaModel b) {
		return ninjaRepository.save(b);
	}
	public NinjaModel findItem(Long id) {
		Optional<NinjaModel> optionalItem = ninjaRepository.findById(id);
		if(optionalItem.isPresent()) {
			return optionalItem.get();
		} else {
			return null;
		}
	}
}
