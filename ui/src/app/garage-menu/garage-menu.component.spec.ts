import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GarageMenuComponent } from './garage-menu.component';

describe('GarageMenuComponent', () => {
  let component: GarageMenuComponent;
  let fixture: ComponentFixture<GarageMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GarageMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GarageMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
