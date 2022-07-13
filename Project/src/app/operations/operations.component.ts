import { Component, OnInit } from '@angular/core';
import { OperationService } from "../operation.service";
import { Operation } from './operation';
import { DatePipe } from '@angular/common';

import { Location } from '@angular/common';

@Component({
  selector: 'app-operations',
  templateUrl: './operations.component.html',
  styleUrls: ['./operations.component.css']
})
export class OperationsComponent implements OnInit {

  operations: Operation[] = [];

  constructor(
    private operationService: OperationService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getOperations();
  }

  getOperations(): void {
    this.operationService.getOperations()
      .subscribe(operations => this.operations = operations)
  }

  goBack(): void {
    this.location.back();
  }

  getDeposit(): number {
    if (!this.operations.length){
      return 0;
    } else {
       let array = this.operations.filter(x => x.type == "deposit");
       let sum = 0;
       array.forEach(element => sum = +sum + +element.sum )
       return sum;
    }
  }

  getWithdraw(): number {
    if (!this.operations.length){
      return 0;
    } else {
      let array = this.operations.filter(x => x.type == "withdraw");
      let sum = 0;
      array.forEach (element => sum = +sum + +element.sum )
      return sum;
    }
  }

  getBalance(): number {
    return this.getDeposit() - this.getWithdraw();
  }

}
