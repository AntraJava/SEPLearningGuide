import {Component, OnInit} from '@angular/core';
import {IngredientService} from "../services/ingredient.service";

@Component({
  selector: 'app-ingredient-list',
  templateUrl: './ingredient-list.component.html',
  styleUrls: ['./ingredient-list.component.css']
})
export class IngredientListComponent implements OnInit{

  ingredientList:any[] = [];

  constructor(private ingredientService:IngredientService) {
  }

  ngOnInit(): void {
    this.ingredientService.getAllIngredient().subscribe(value => this.ingredientList = value);

  }

}
