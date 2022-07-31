import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {

  @Input() data: {avatar:'',name:'',op:'',amount:''} | any


  constructor() { }

  ngOnInit(): void {
    console.log("transfer component")
    console.log(this.data)
    let dollarUSLocale = Intl.NumberFormat('en-US');
    this.data.amount = dollarUSLocale.format(this.data.amount)
  }
}
