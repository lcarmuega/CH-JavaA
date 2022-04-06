package com.Desafio7.Desafio7.unitTests.businessTests;

import com.Desafio7.Desafio7.domain.Operation;
import com.Desafio7.Desafio7.domain.entities.OperationResultEntity;
import com.Desafio7.Desafio7.domain.enums.Operator;
import com.Desafio7.Desafio7.repositories.OperationResultRepository;
import com.Desafio7.Desafio7.services.CalculatorService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {
    @Mock
    private OperationResultRepository repository;
    private CalculatorService calculatorService;

    @Spy
    @InjectMocks
    private CalculatorService calculatorServiceMock;

    @BeforeEach
    void config(){
        calculatorService = new CalculatorService(repository);
    }

    @Test
    void testWhenAddShouldReturnCorrectResult(){

        Operation incoming = new Operation(1.0, 65.0, Operator.ADD);

        OperationResultEntity expected = new OperationResultEntity(Operator.ADD,1.0, 65.0, 66.0);

        OperationResultEntity result = calculatorService.add(incoming.getLeft(), incoming.getRight());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testWhenDifferenceShouldReturnCorrectResult(){

        Operation incoming = new Operation(10.0, 5.0, Operator.DIFFERENCE);

        OperationResultEntity expected = new OperationResultEntity(Operator.DIFFERENCE,10.0, 5.0, 5.0);

        OperationResultEntity result = calculatorService.difference(incoming.getLeft(), incoming.getRight());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testWhenMultiplyShouldReturnCorrectResult(){

        Operation incoming = new Operation(10.0, 3.0, Operator.MULTIPLY);

        OperationResultEntity expected = new OperationResultEntity(Operator.MULTIPLY,10.0, 3.0, 30.0);

        OperationResultEntity result = calculatorService.multiply(incoming.getLeft(), incoming.getRight());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testWhenDivideShouldReturnCorrectResult(){

        Operation incoming = new Operation(15.0, 3.0, Operator.DIVIDE);

        OperationResultEntity expected = new OperationResultEntity(Operator.DIVIDE,15.0, 3.0, 5.0);

        OperationResultEntity result = calculatorService.divide(incoming.getLeft(), incoming.getRight());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testGetOperations(){
        calculatorService.getOperations();
        verify(repository).findAll();
    }

    @Test
    void testValidate(){
        OperationResultEntity incoming = new OperationResultEntity(Operator.ADD,50.0, 20.0, 70.0);
        Operation incomingOperation = new Operation(50.0, 20.0, Operator.ADD);
        OperationResultEntity result = new OperationResultEntity(Operator.ADD, 50.0, 20.0, 70.0);

        doReturn(result).when(this.calculatorServiceMock).calculate(incomingOperation);

        calculatorServiceMock.validateResult(incoming);
        verify(calculatorServiceMock,times(1)).validateResult(incoming);
    }
}
