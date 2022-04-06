package com.Desafio7.Desafio7.unitTests;

import com.Desafio7.Desafio7.domain.Operation;
import com.Desafio7.Desafio7.domain.enums.Operator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {
    @Test
    void testOperationReturnsNewInstance(){
        Double right = 50.0;
        Double left = 40.0;
        Operator operator = Operator.ADD;
        Operation operation = new Operation(left, right, operator);

        assertThat(operation).isEqualTo(operation);
    }
}
