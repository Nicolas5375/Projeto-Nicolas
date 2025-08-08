package modelo.dao.animal;

import modelo.entidade.animal.Animal;
import java.util.List;

public interface AnimalDao {
	void inserirAnimal(Animal animal);

	void deletarAnimal(Animal animal);

	void atualizarRacaAnimal(Animal animal, String novaRaca);

	void atualizarCorAnimal(Animal animal, String novaCor);

	List<Animal> recuperarAnimal();
}
