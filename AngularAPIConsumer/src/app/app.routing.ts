import {NgModule} from '@angular/core';
import {CommonModule,} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule, Routes} from '@angular/router';
import {IngredientListComponent} from "./ingredient-list/ingredient-list.component";
import {DashboardComponent} from "./dashboard/dashboard.component";


const routes: Routes =[
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home',             component: DashboardComponent },
    { path: 'ingredient',           component: IngredientListComponent },
    // { path: 'login',           component: SigninComponent },
    // { path: 'nucleoicons',      component: NucleoiconsComponent },
    // { path: 'base',      component: BasicelementsComponent },
    // { path: 'control',
    //     // canActivate: [AuthGuardService],
    //     component: ControlBoardComponent }
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes,{
      //useHash: true
    })
  ],
  exports: [
  ],
})
export class AppRoutingModule { }
