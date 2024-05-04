import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { AdminTemplateComponent } from './admin-template/admin-template.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatMenu, MatMenuTrigger} from "@angular/material/menu";
import {MatIcon} from "@angular/material/icon";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatList, MatListItem} from "@angular/material/list";
import { ProfileComponent } from './profile/profile.component';
import { LoadStudentsComponent } from './load-students/load-students.component';
import { LoadPaymentsComponent } from './load-payments/load-payments.component';
import { LoginComponent } from './login/login.component';
import { StudentsComponent } from './students/students.component';
import { PaymentsComponent } from './payments/payments.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import {MatCard, MatCardActions, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatDivider} from "@angular/material/divider";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import {AuthGuard} from "./guards/auth.guard";
import {HttpClientModule} from "@angular/common/http";
import {MatTableDataSource, MatTableModule} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort, MatSortHeader} from "@angular/material/sort";

@NgModule({
  declarations: [
    AppComponent,
    AdminTemplateComponent,
    ProfileComponent,
    LoadStudentsComponent,
    LoadPaymentsComponent,
    LoginComponent,
    StudentsComponent,
    PaymentsComponent,
    DashboardComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButton,
    MatIconButton,
    MatMenu,
    MatIcon,
    MatMenuTrigger,
    MatSidenavModule,
    MatList,
    MatListItem,
    MatCard,
    MatCardHeader,
    MatCardContent,
    MatDivider,
    MatCardTitle,
    MatFormField,
    MatInput,
    MatLabel,
    MatCardActions,
    ReactiveFormsModule,
    HttpClientModule,
    MatTableModule,
    MatPaginator,
    MatSort,
    MatSortHeader,
  ],
  providers: [
    provideAnimationsAsync(),
    AuthGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
