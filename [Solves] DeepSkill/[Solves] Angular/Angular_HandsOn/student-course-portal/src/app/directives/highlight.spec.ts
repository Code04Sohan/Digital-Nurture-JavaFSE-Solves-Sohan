import { ElementRef } from '@angular/core';
import { HighlightDirective } from './highlight';

describe('HighlightDirective', () => {
  it('should create an instance', () => {
    // 1. Create a dummy element to pass to the constructor
    const mockElementRef = new ElementRef(document.createElement('div'));
    
    // 2. Pass the mock element into the directive instance
    const directive = new HighlightDirective(mockElementRef);
    
    expect(directive).toBeTruthy();
  });
});