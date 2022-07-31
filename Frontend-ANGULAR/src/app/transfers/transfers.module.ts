import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TransfersListComponent } from './transfers-list/transfers-list.component';
import { TransferComponent } from './transfer/transfer.component';

@NgModule({
  declarations: [
    TransfersListComponent,
    TransferComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[TransfersListComponent]
})
export class TransfersModule { }
