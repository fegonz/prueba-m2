import { Component, OnInit } from '@angular/core';
import { interval } from 'rxjs';
@Component({
  selector: 'app-time-hour',
  templateUrl: './time-hour.component.html',
  styleUrls: ['./time-hour.component.scss']
})
export class TimeHourComponent implements OnInit{

  fechaHora!: string;
  spinner:boolean=false;
  arrayHora: string[] = [];
  constructor() { }
  
  ngOnInit(): void {
    interval(1000).subscribe(() => {
      this.spinner=true;
      this.fechaHora = new Date().toLocaleString();
    });
  }

  
  guardarHora(){
    this.arrayHora.push(this.fechaHora);
  }

  

}
