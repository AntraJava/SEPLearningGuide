package com.antra.sep.restapidemo.controller;

import com.antra.sep.restapidemo.entity.Ingredient;
import com.antra.sep.restapidemo.exception.IngredientNotFoundException;
import com.antra.sep.restapidemo.request.IngredientUpdateRequest;
import com.antra.sep.restapidemo.response.ErrorResponse;
import com.antra.sep.restapidemo.response.IngredientResponse;
import com.antra.sep.restapidemo.response.PageResponse;
import com.antra.sep.restapidemo.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
@CrossOrigin("*")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/{id}")
    public ResponseEntity<IngredientResponse> getIngredientById(@PathVariable int id) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        IngredientResponse resp = new IngredientResponse();
        resp.setId(ingredient.getId());
        resp.setName(ingredient.getName());
        return ResponseEntity.ok(resp);
    }

    @GetMapping()
    public ResponseEntity<List<IngredientResponse>> getAllIngredient() {
        List<IngredientResponse> resp = ingredientService.getAllIngredient();
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/page")
    public ResponseEntity<PageResponse<IngredientResponse>> getAllIngredientByPage(int page, int rowPerPage) {
        PageResponse<IngredientResponse> resp = ingredientService.getAllIngredientByPage(page, rowPerPage);
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<IngredientResponse> createIngredient( @Validated @RequestBody IngredientUpdateRequest request) {
        IngredientResponse ingredient = ingredientService.addIngredient(request);
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping
    public ResponseEntity<IngredientResponse> updateIngredient(@Validated @RequestBody IngredientUpdateRequest request) {
        IngredientResponse ingredient = ingredientService.updateIngredient(request);
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<IngredientResponse> deleteIngredient(@PathVariable int id) {
        IngredientResponse ingredient = ingredientService.deleteIngredientById(id);
        return ResponseEntity.ok(ingredient);
    }

    @ExceptionHandler(IngredientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleIngredientNotFoundException(Exception e) {
        return new ResponseEntity<>(ErrorResponse.builder().message("Ingredient doesn't exist").statusCode(404)
                .cause("Id may be too large").build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleIngredientRunException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(ErrorResponse.builder().message(e.getMessage()).statusCode(400)
                .cause("Invalid input").build(), HttpStatus.BAD_REQUEST);
    }
}
