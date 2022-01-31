import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChattersComponent } from './chatters.component';

describe('ChattersComponent', () => {
  let component: ChattersComponent;
  let fixture: ComponentFixture<ChattersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChattersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChattersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
