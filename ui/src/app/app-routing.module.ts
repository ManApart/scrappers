import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { GarageMenuComponent } from './garage-menu/garage-menu.component';

const routes: Routes = [
  { path: '', component: MainMenuComponent },
  { path: 'garage', component: GarageMenuComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
