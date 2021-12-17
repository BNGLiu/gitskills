package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface InerfaceRTRepository extends CrudRepository<InterfaceRT, Long> {

    InterfaceRT findByName(String name);
}