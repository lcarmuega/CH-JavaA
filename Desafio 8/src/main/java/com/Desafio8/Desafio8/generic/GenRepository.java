package com.Desafio8.Desafio8.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenRepository<T extends GenEntity<T, ID>, ID> extends JpaRepository<T, ID> {
}
