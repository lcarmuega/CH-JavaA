package com.Desafio7.Desafio7.domain.entities;

import com.Desafio7.Desafio7.domain.enums.Operator;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "operation_result")
public class OperationResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Operator operator;

    private Double left;
    private Double right;
    private Double result;

    public OperationResultEntity(Operator operator, Double left, Double right, Double result) {
        super();
        this.operator = operator;
        this.left = left;
        this.right = right;
        this.result = result;
    }

    public OperationResultEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Double getLeft() {
        return left;
    }

    public void setLeft(Double left) {
        this.left = left;
    }

    public Double getRight() {
        return right;
    }

    public void setRight(Double right) {
        this.right = right;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        OperationResultEntity that = (OperationResultEntity) o;
        return Objects.equals(left, that.left) && operator == that.operator && Objects.equals(right, that.right) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode(){
        return Objects.hash(left, operator, right, result);
    }
}
