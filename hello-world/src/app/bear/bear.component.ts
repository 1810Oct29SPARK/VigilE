import { Component, OnInit } from '@angular/core';
import { BearService } from '../services/bear.service';
import { Bear } from '../models/bear.model';

@Component({
  selector: 'app-bear',
  templateUrl: './bear.component.html',
  styleUrls: ['./bear.component.css']
})
export class BearComponent implements OnInit {

private bears: Bear[];

  // inject service by providing it as a constructor argument
  constructor(private bearService: BearService) {}

  ngOnInit() {
    this.bears = this.bearService.getBears();
  }

}
