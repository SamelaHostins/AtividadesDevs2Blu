import { DetalhesComponent } from './components/detalhes/detalhes.component';
import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetalhesPeopleComponent } from './components/detalhes-people/detalhes-people.component';



const routes: Routes = [
{path: 'home', component: HomeComponent},
{path: 'detalhes', component: DetalhesComponent},
{path: 'detalhes2', component: DetalhesPeopleComponent},
{path: '', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
