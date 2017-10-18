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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBRead {
	public static void main(String[] args) {

	 try {

		File file = new File("customers.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
		System.out.println(customer.getId()+" "+customer.getName()+" "+customer.getAge()+" "+customer.getMiCat().getName());

	  } catch (JAXBException e) {
		e.printStackTrace();
	  }

	}
}