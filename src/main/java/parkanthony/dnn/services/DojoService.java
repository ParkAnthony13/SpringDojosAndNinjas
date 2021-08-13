package parkanthony.dnn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import parkanthony.dnn.models.DojoModel;
import parkanthony.dnn.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	public List<DojoModel> allItems() {
		return dojoRepository.findAll();
	}
	public DojoModel createItem(DojoModel b) {
		return dojoRepository.save(b);
	}
	public DojoModel findItem(Long id) {
		Optional<DojoModel> optionalItem = dojoRepository.findById(id);
		if(optionalItem.isPresent()) {
			return optionalItem.get();
		} else {
			return null;
		}
	}
}
