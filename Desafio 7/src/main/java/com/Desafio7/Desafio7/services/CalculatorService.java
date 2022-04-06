package com.Desafio7.Desafio7.services;

import com.Desafio7.Desafio7.domain.Operation;
import com.Desafio7.Desafio7.domain.entities.OperationResultEntity;
import com.Desafio7.Desafio7.domain.enums.Operator;
import com.Desafio7.Desafio7.repositories.OperationResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {
    @Autowired
    private OperationResultRepository operationResultRepository;

    public CalculatorService(OperationResultRepository operationResultRepository){
        this.operationResultRepository = operationResultRepository;
    }

    public List<OperationResultEntity> getOperations(){
        return (List<OperationResultEntity>) this.operationResultRepository.findAll();
    }

    public OperationResultEntity add(Double left, Double right){
        return new OperationResultEntity(Operator.ADD, left, right, left + right);
    }

    public OperationResultEntity difference(Double left, Double right){
        return new OperationResultEntity(Operator.DIFFERENCE, left, right, left - right);
    }

    public OperationResultEntity multiply(Double left, Double right){
        return new OperationResultEntity(Operator.MULTIPLY, left, right, left * right);
    }

    public OperationResultEntity divide(Double left, Double right){
        return new OperationResultEntity(Operator.DIVIDE, left, right, left / right);
    }

    public OperationResultEntity calculate(Operation operation){
        if(Operator.ADD.equals(operation.getOperator())){
            return operationResultRepository.save(this.add(operation.getLeft(), operation.getRight()));
        } else if(Operator.DIFFERENCE.equals(operation.getOperator())){
            return operationResultRepository.save(this.difference(operation.getLeft(), operation.getRight()));
        } else if(Operator.MULTIPLY.equals(operation.getOperator())){
            return operationResultRepository.save(this.multiply(operation.getLeft(), operation.getRight()));
        } else if(Operator.DIVIDE.equals(operation.getOperator())){
            return operationResultRepository.save(this.divide(operation.getLeft(), operation.getRight()));
        } else {
            return null;
        }
    }

    public String validateResult(OperationResultEntity operationResult){
        Operation prevOperation = new Operation(operationResult.getLeft(), operationResult.getRight(), operationResult.getOperator());
        Double result = this.calculate(prevOperation).getResult();

        if(!operationResult.getResult().equals(result)){
            return "Wrong result";
        } else {
            return "Correct result";
        }
    }
}
