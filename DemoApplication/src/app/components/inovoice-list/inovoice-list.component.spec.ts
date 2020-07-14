import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InovoiceListComponent } from './inovoice-list.component';

describe('InovoiceListComponent', () => {
  let component: InovoiceListComponent;
  let fixture: ComponentFixture<InovoiceListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InovoiceListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InovoiceListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
