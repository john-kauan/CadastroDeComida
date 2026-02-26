package dev.john.CadastroDeComida.repository;

import dev.john.CadastroDeComida.model.FoodModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodModel, Long> {
}
