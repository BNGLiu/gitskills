package com.example.demo;

import org.neo4j.driver.v1.*;

import java.util.Scanner;


//输入标签，起始节点，关系，末尾节点
public class CreateNodeRelation {
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("bolt://114.67.225.53:7687", AuthTokens.basic("neo4j", "devops"));
        Session session = driver.session();
        Scanner sc=new Scanner(System.in);
        String inputLabel=sc.next();
        String inputStartName=sc.next();
        String inputRelation=sc.next();
        String inputEndName=sc.next();

        String selectName=String.format("CREATE p = (a:%s{name:'%s'}) - [:%s] -> (b:%s{name:'%s'})  return p",inputLabel,inputStartName,inputRelation,inputLabel,inputEndName);


        session.run(selectName);

//        StatementResult result = session.run(selectName);

//        while (result.hasNext()) {
//            Record record = result.next();
//            String relationName = record.get("featureName").asString();
//
//
//            System.out.println(inputName+"的父节点："+relationName);
//
//        }
        session.close();
        driver.close();
    }
}
