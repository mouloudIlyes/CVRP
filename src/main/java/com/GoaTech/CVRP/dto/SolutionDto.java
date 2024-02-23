package com.GoaTech.CVRP.dto;

import com.GoaTech.CVRP.dto.embiddable.Affectation;

import java.util.List;

public class SolutionDto {
    List<Affectation> affectations;

    public SolutionDto() {
    }

    public SolutionDto(List<Affectation> affectations) {
        this.affectations = affectations;
    }

    public List<Affectation> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<Affectation> affectations) {
        this.affectations = affectations;
    }
}
