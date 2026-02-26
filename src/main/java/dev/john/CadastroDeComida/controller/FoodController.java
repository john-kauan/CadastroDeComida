package dev.john.CadastroDeComida.controller;


import dev.john.CadastroDeComida.model.FoodModel;
import dev.john.CadastroDeComida.service.FoodService;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<FoodModel> getAll(){
        return foodService.getAll();
    }

    @PostMapping
    public FoodModel create(@RequestBody FoodModel foodModel){
        return foodService.save(foodModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        foodService.delete(id);
    }

    @PutMapping("/{id}")
    public List<FoodModel> update( @PathVariable Long id, @RequestBody FoodModel foodAtualizado) {
        FoodModel food = foodService.update(id, foodAtualizado);
        return foodService.getAll();
    }

}
