package parkanthony.dnn.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import parkanthony.dnn.models.NinjaModel;

@Repository
public interface NinjaRepository extends CrudRepository<NinjaModel, Long> {
	List<NinjaModel> findAll();
	List<NinjaModel> findByDojoIdEquals(Long id);
}
