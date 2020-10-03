import { TestBed } from '@angular/core/testing';

import { PassbookService } from './passbook.service';

describe('PassbookService', () => {
  let service: PassbookService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PassbookService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
