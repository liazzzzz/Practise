import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import { OperationService } from "../operation.service";
import { Operation } from 'src/app/operations/operation';
import { Location } from "@angular/common";

@Component({
  selector: 'app-new-operation',
  templateUrl: './new-operation.component.html',
  styleUrls: ['./new-operation.component.css']
})
export class NewOperationComponent implements OnInit {

  form: FormGroup;

  constructor(
    private operationService: OperationService,
    private location: Location
  ) {
    this.form = new FormGroup({
      type: new FormControl(null, Validators.required),
      sum: new FormControl(null, [Validators.required, Validators.min(0.001), Validators.pattern("^[0-9]*$")]),
      note: new FormControl(''),
      createdAt: new FormControl(new Date(), Validators.required)
    })
  }

  goBack(): void {
    this.location.back();
  }

  ngOnInit(): void {
  }

  create(): void {
    this.operationService.addOperation(this.form.value).subscribe();
      // (response: Operation) => {
      //   console.log(response);
      // })
  }

}
