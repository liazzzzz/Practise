import { Component, OnInit, Input } from '@angular/core';
import { Operation } from 'src/app/operations/operation';

import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import  { OperationService } from "../operation.service";

@Component({
  selector: 'app-operation-detail',
  templateUrl: './operation-detail.component.html',
  styleUrls: ['./operation-detail.component.css']
})
export class OperationDetailComponent implements OnInit {

  @Input() operation?: Operation;

  constructor(
    private route: ActivatedRoute,
    private operationService: OperationService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getOperation();
  }

  getOperation(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.operationService.getOperation(id)
      .subscribe(operation => this.operation = operation);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    if (this.operation) {
      this.operationService.updateOperation(this.operation)
        .subscribe(() => this.goBack());
    }
  }

}
