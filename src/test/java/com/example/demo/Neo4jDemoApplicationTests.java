package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Neo4jDemoApplicationTests {

    @Autowired
    InerfaceRTRepository InerfaceRepo;

    @Test
    public void contextLoads() {}

//创建节点以及关系
    @Test
    public void testSavePerson1() {
        InerfaceRepo.deleteAll();
        InterfaceRT interfaceRT1 = new InterfaceRT("Collection", "interface");
        InterfaceRT interfaceRT2 = new InterfaceRT("Set", "interface");
        InterfaceRT interfaceRT3 = new InterfaceRT("List", "interface");
        InterfaceRT interfaceRT4 = new InterfaceRT("ArrayList", "interfaceImp");
        InterfaceRT interfaceRT5 = new InterfaceRT("LinkedList", "interfaceImp");
        InterfaceRT interfaceRT6 = new InterfaceRT("HashSet", "interfaceImp");

        interfaceRT1.addChildInterface(interfaceRT2);
        interfaceRT1.addChildInterface(interfaceRT3);
        interfaceRT2.addChildInterface(interfaceRT6);
        interfaceRT3.addChildInterface(interfaceRT4);
        interfaceRT3.addChildInterface(interfaceRT5);

        interfaceRT2.addFatherInterface(interfaceRT1);
        interfaceRT3.addFatherInterface(interfaceRT1);
        interfaceRT4.addFatherInterface(interfaceRT3);
        interfaceRT5.addFatherInterface(interfaceRT3);
        interfaceRT6.addFatherInterface(interfaceRT2);


        interfaceRT2.addCallInterface(interfaceRT1);


        InerfaceRepo.save(interfaceRT1);
        InerfaceRepo.save(interfaceRT2);
        InerfaceRepo.save(interfaceRT3);
        InerfaceRepo.save(interfaceRT4);
        InerfaceRepo.save(interfaceRT5);
        InerfaceRepo.save(interfaceRT6);
    }
//查询节点
    @Test
    public void testfindByName() {
        InterfaceRT interfaceRT = InerfaceRepo.findByName("Collection");
        System.out.println(interfaceRT);
    }








}

