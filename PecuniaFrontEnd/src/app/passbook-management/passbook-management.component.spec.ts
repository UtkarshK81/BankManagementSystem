import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PassbookManagementComponent } from './passbook-management.component';

describe('PassbookManagementComponent', () => {
  let component: PassbookManagementComponent;
  let fixture: ComponentFixture<PassbookManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PassbookManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PassbookManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
