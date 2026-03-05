package dev.john.CadastroDeComida.service;

import dev.john.CadastroDeComida.model.FoodModel;
import dev.john.CadastroDeComida.repository.FoodRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

    @InjectMocks
    private FoodService foodService;

    @Mock
    private FoodRepository foodRepository;

    @Test
    @DisplayName("Deve retornar uma lista com apenas um food")
    public void getAllTest(){

        FoodModel foodModel = new FoodModel(1L, "Carne",10, LocalDate.of(2026,01,12));
        Mockito.when(foodRepository.findAll()).thenReturn(List.of(foodModel));
        List<FoodModel> food = foodService.getAll();

        Assertions.assertEquals(1, food.size());
    }

    @Test
    @DisplayName("Deve criar e salvar um food")
    public void saveTest(){

        FoodModel foodModel = new FoodModel(1L, "Carne",10, LocalDate.of(2026,01,12));
        Mockito.when(foodRepository.save(ArgumentMatchers.any(FoodModel.class))).thenReturn(foodModel);

        FoodModel criado = foodService.save(foodModel);

        Assertions.assertNotNull(criado);
        Assertions.assertEquals("Carne", criado.getNome());
    }

    @Test
    @DisplayName("Deve deletar um food pelo ID")
    public void deleteTest(){

        Long idParaTeste = 1L;
        foodService.delete(idParaTeste);

        Mockito.verify(foodRepository, Mockito.times(1)).deleteById(idParaTeste);

    }

    @Test
    @DisplayName("Deve atualizar um food pelo ID")
    public void updateTest(){

        Long idParaTeste = 1L;
        FoodModel foodExistente = new FoodModel(idParaTeste, "Frango", 5, LocalDate.now());
        FoodModel foodNovosDados = new FoodModel(idParaTeste, "Frango Atualizado", 20, LocalDate.of(2026, 5, 20));


        Mockito.when(foodRepository.findById(idParaTeste)).thenReturn(Optional.of(foodExistente));


        Mockito.when(foodRepository.save(ArgumentMatchers.any(FoodModel.class))).thenReturn(foodExistente);

        FoodModel resultado = foodService.update(idParaTeste, foodNovosDados);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("Frango Atualizado", resultado.getNome());
        Assertions.assertEquals(20, resultado.getQuantidade());


        Mockito.verify(foodRepository, Mockito.times(1)).save(ArgumentMatchers.any(FoodModel.class));

    }
}