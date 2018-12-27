import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BearComponent } from './bear/bear.component';
import { BearService } from './services/bear.service';

/*
  This file defines our root module.
  Know the parts!
*/
@NgModule({
  // What components are present in the module?
  declarations: [
    AppComponent,
    BearComponent
  ],
  // Other modules which this module depends on
  imports: [
    BrowserModule
  ],
  // Services which will be shared by all components
  providers: [BearService],
  // Which components should be initialized at app start?
  bootstrap: [AppComponent, BearComponent]
})
export class AppModule { }