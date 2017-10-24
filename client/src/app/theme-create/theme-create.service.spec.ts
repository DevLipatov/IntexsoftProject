import { TestBed, inject } from '@angular/core/testing';

import { ThemeCreateService } from './theme-create.service';

describe('ThemeCreateService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ThemeCreateService]
    });
  });

  it('should be created', inject([ThemeCreateService], (service: ThemeCreateService) => {
    expect(service).toBeTruthy();
  }));
});
