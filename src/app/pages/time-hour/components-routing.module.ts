import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TimeHourComponent } from './time-hour/time-hour.component';

const routes: Routes = [
  {
    path: 'fecha-hora',
    component: TimeHourComponent,
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ComponentsRoutingModule { }
