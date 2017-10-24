import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemeCreateComponent } from './theme-create.component';

describe('ThemeCreateComponent', () => {
  let component: ThemeCreateComponent;
  let fixture: ComponentFixture<ThemeCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ThemeCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ThemeCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
