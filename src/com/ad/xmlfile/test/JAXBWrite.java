/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ad.xmlfile.test;

/**
 *
 * @author Administrador
 */
import java.io.File;
import java.time.LocalDate;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBWrite {
	public static void main(String[] args) {

	  Customer customer = new Customer();
	  customer.setId(100);
	  customer.setName("mkyong");
	  customer.setAge(29);
          Cat cat=new Cat("Miau");
          customer.setMiCat(cat);

          Customer cliente2 = new Customer();
	  customer.setId(200);
	  customer.setName("pepito");
	  customer.setAge(49);
          Cat cat2=new Cat("Guau");
          customer.setMiCat(cat2);
          
	  try {

		File file = new File("customers.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(customer, file);
//                jaxbMarshaller.marshal(cliente2, file);
		jaxbMarshaller.marshal(customer, System.out);
                

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }

	}
}
