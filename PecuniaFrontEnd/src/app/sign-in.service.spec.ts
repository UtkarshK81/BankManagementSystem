import { TestBed } from '@angular/core/testing';

import { SignINService } from './sign-in.service';

describe('SignINService', () => {
  let service: SignINService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SignINService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
