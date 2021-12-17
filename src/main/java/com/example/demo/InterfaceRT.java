package com.example.demo;

import java.util.HashSet;
import java.util.Set;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "InterfaceRelation")//这是数据库中的node
public class InterfaceRT {

    @Id 
    @GeneratedValue
    private Long id;
    
    private String name;
    
    private String relationFeature;
       

    public InterfaceRT() {// 从 Neo4j API 2.0.5开始需要无参构造函数

    }
    
    public InterfaceRT(String name, String relationFeature) {
        this.name = name;
        this.relationFeature = relationFeature;
    }


    @Relationship(type = "Child", direction = Relationship.OUTGOING)
    public Set<InterfaceRT> actors;

    public void addChildInterface(InterfaceRT childInterface) {
        if (actors == null) {
            actors = new HashSet<>();
        }
        actors.add(childInterface);
    }

    @Relationship(type = "Father", direction = Relationship.OUTGOING)
    public Set<InterfaceRT> actorsa;

    public void addFatherInterface(InterfaceRT fatherInterface) {
        if (actorsa == null) {
            actorsa = new HashSet<>();
        }
        actorsa.add(fatherInterface);
    }

    @Relationship(type = "CallRalation", direction = Relationship.OUTGOING)
    public Set<InterfaceRT> actorsas;

    public void addCallInterface(InterfaceRT callInterface) {
        if (actorsas == null) {
            actorsas = new HashSet<>();
        }
        actorsas.add(callInterface);
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationFeature() {
        return relationFeature;
    }

    public void setRelationFeature(String relationFeature) {
        this.relationFeature = relationFeature;
    }

    @Override
    public String toString() {
        return "InterfaceRT{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", born='" + relationFeature + '\'' +
                ", actors=" + actors +
                '}';
    }
}
