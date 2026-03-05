package dev.john.CadastroDeComida.service;


import dev.john.CadastroDeComida.model.FoodModel;
import dev.john.CadastroDeComida.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    //lista
    public List<FoodModel> getAll(){
        return foodRepository.findAll();
    }

    //cria
    public FoodModel save(FoodModel foodModel){
        return foodRepository.save(foodModel);
    }

    //deleta
    public void delete(Long id){
        foodRepository.deleteById(id);
    }

    //atualiza
    public FoodModel update(Long id, FoodModel foodAtualizado) {

        FoodModel food = foodRepository.findById(id).orElse(null);

        if (food != null) {

            food.setNome(foodAtualizado.getNome());
            food.setQuantidade(foodAtualizado.getQuantidade());
            food.setDataValidade(foodAtualizado.getDataValidade());

            return foodRepository.save(food);

        } else {
            throw new RuntimeException("Food não encontrado com id: " + id);
        }
    }
}
