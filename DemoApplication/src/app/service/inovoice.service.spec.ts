import { TestBed } from '@angular/core/testing';

import { InovoiceService } from './inovoice.service';

describe('InovoiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: InovoiceService = TestBed.get(InovoiceService);
    expect(service).toBeTruthy();
  });
});
