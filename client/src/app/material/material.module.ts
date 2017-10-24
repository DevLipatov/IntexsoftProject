import {
  MatCardModule,
  MatChipsModule,
  MatInputModule,
  MatPaginatorModule,
  MatSelectModule,
  MatTableModule,
  MatTabsModule,
  MdButtonModule,
  MdCheckboxModule,
  MdSnackBarModule
} from '@angular/material';
import {NgModule} from "@angular/core";

@NgModule({
  imports:
    [MdButtonModule,
      MdCheckboxModule,
      MatCardModule,
      MatTableModule,
      MatChipsModule,
      MatPaginatorModule,
      MatSelectModule,
      MatInputModule,
      MdSnackBarModule,
      MatTabsModule],
  exports:
    [MdButtonModule,
      MdCheckboxModule,
      MatCardModule,
      MatTableModule,
      MatChipsModule,
      MatPaginatorModule,
      MatSelectModule,
      MatInputModule,
      MdSnackBarModule,
      MatTabsModule],
})
export class MaterialModule {
}
