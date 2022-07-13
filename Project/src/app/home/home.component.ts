import { Component, OnInit } from '@angular/core';
import {OperationService} from "../operation.service";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private operationService: OperationService) { }

  ngOnInit(): void {
  }

  // getBalance(): number {
  //   return this.operationService.getDeposit() - this.operationService.getWithdraw();
  // }

}
