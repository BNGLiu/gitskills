package com.example.demo;

import org.neo4j.driver.v1.*;

import java.util.Scanner;

public class SelectRelation {
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("bolt://114.67.225.53:7687", AuthTokens.basic("neo4j", "devops"));
        Session session = driver.session();

        Scanner sc=new Scanner(System.in);
        String inputName=sc.next();
        String inputRelation=sc.next();
        String selectName=String.format("MATCH (n:InterfaceRelation{name:\"%s\"})-[:%s*1..]->(m) return n.name as nName,m.name as mName",inputName,inputRelation);
        StatementResult result = session.run(selectName);
        System.out.println("起始节点"+"     "+"关系"+"        "+"关系节点");

        while (result.hasNext()) {
            Record record = result.next();
            String relationNameN = record.get("nName").asString();
            String relationNameM = record.get("mName").asString();
            System.out.println(relationNameN+"      "+inputRelation+"       "+relationNameM);
        }
        session.close();
        driver.close();
    }
}
