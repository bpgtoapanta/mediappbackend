package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Signos;

public interface ISignoRepo extends JpaRepository<Signos, Integer> {

}
