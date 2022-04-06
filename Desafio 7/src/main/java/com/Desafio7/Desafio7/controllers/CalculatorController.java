package com.Desafio7.Desafio7.controllers;

import com.Desafio7.Desafio7.domain.Operation;
import com.Desafio7.Desafio7.domain.OperationResult;
import com.Desafio7.Desafio7.domain.entities.OperationResultEntity;
import com.Desafio7.Desafio7.services.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    @ResponseStatus(HttpStatus.OK)
    public OperationResultEntity calculate(@RequestBody Operation operation){
        return this.calculatorService.calculate(operation);
    }

    @PostMapping("/validateResult")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String validateResult(@RequestBody OperationResultEntity operationResult){
        return this.calculatorService.validateResult(operationResult);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<OperationResultEntity> getOperations(){
        return this.calculatorService.getOperations();
    }
}
