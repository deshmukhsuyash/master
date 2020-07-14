import { Component, OnInit } from '@angular/core';
import { InovoiceService } from '../../service/inovoice.service';
import { Inovoice } from '../../service/inovoice';
import { Observable,Subject } from "rxjs";

import {FormControl,FormGroup,Validators} from '@angular/forms';

@Component({
  selector: 'app-inovoice-list',
  templateUrl: './inovoice-list.component.html',
  styleUrls: ['./inovoice-list.component.css']
})
export class InovoiceListComponent implements OnInit {
	
	constructor(private inovoiceService:InovoiceService) {
		
	}
	dtTrigger: Subject<any>= new Subject();


	inovoices: Observable<Inovoice[]>;
	inovoice : Inovoice=new Inovoice();
	deleteMessage=false;
	isupdated = false;    


	ngOnInit() {
	  this.isupdated=false; 
	  this.inovoiceService.getInovoiceList().subscribe(data =>{
	  this.inovoices =data;
	  this.dtTrigger.next();
	  })
	}
}
