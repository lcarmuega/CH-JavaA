package com.Desafio7.Desafio7.unitTests;

import com.Desafio7.Desafio7.controllers.CalculatorController;
import com.Desafio7.Desafio7.domain.entities.OperationResultEntity;
import com.Desafio7.Desafio7.services.CalculatorService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
    @InjectMocks
    CalculatorController calculatorController;
    
    @Mock
    CalculatorService calculatorService;
    
    @Test
    void testValidateOperationDoesNothingWhenServiceCalled(){
        OperationResultEntity operationResult = mock(OperationResultEntity.class);
        
        doNothing().when(this.calculatorService).validateResult(operationResult);
        
        this.calculatorController.validateResult(operationResult);
        
        verify(this.calculatorService, times(1)).validateResult(operationResult);
    }
    
    @Test
    void testListOperationDoesNothingWhenServiceCalled(){
        this.calculatorController.getOperations();

        verify(this.calculatorService, times(1)).getOperations();
    }
}
