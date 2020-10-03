import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePassbookComponent } from './update-passbook.component';

describe('UpdatePassbookComponent', () => {
  let component: UpdatePassbookComponent;
  let fixture: ComponentFixture<UpdatePassbookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatePassbookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatePassbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
