import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-transfers-list',
  templateUrl: './transfers-list.component.html',
  styleUrls: ['./transfers-list.component.css']
})
export class TransfersListComponent implements OnInit {
  @Input() data: any
  transactions: any[]=[]

  constructor() { }

  ngOnInit(): void {
    // let rawData: any[]=[]
    // rawData = rawData.concat(this.data.transactions_received,this.data.transactions_sent)

    this.data.transactions_received.forEach((transaction:any)=> {
      this.transactions.push(formatTransferData(transaction, "deposit"))
    })

    this.data.transactions_sent.forEach((transaction:any)=>{
      this.transactions.push(formatTransferData(transaction,"withdraw"))

      //withdraw and deposit

      // let firstname = transaction?.receptor?.firstname || transaction?.giver?.firstname
      // let lastname = transaction?.receptor?.lastname || transaction?.giver?.lastname
      //
      // let viewStructure = {
      //   name: firstname + " " + lastname,
      //   avatar: "assets/images/users/avatar-default.jpg",
      //   op: "Transfer",
      //   type: "sent",
      //   amount: transaction?.amount,
      //   date: transaction?.date
      // }
      // this.transactions.push(viewStructure)
    })
  }
}

function formatTransferData(transaction: { receptor: { firstname: any; lastname: any; }; giver: { firstname: any; lastname: any; }; amount: any; date: any; },type: String){
  let firstname = transaction?.receptor?.firstname || transaction?.giver?.firstname
  let lastname = transaction?.receptor?.lastname || transaction?.giver?.lastname

  let viewStructure = {
    name: firstname + " " + lastname,
    avatar: "assets/images/users/avatar-default.jpg",
    op: "Transfer",
    type: type,
    amount: transaction?.amount,
    date: transaction?.date
  }
  return(viewStructure)
}
