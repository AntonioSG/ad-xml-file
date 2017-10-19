/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ad.xmlfile.test;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Administrador
 */
public class WriteParkin {

    public static void main(String[] args) {

        Parking park = new Parking();
        Calendar cal = Calendar.getInstance();
        cal.set(2005, 2, 28);
        Coche c1 = new Coche("1234cfd", "Coche", "uno", cal.getTime(), "Azul");
        cal.set(1980, 10, 15);
        Persona p1 = new Persona("98675872K", "Persona", "Uno", "López", cal.getTime());

        p1.addCoche(c1);
        try {
            park.addPersona(p1);
        } catch (Exception ex) {
            Logger.getLogger(WriteParkin.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Listado Parking: \n" + park.toString());
        System.out.println("Listado coches: \n");
        Iterator it = park.getListaTotalCoches().iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }

        System.out.println("---------------------------------------------------------------------");

        Persona p2 = new Persona("11111111K", "Persona", "dos", "11111", cal.getTime());
        Coche c2 = new Coche("11111ckk", "coche", "dos", cal.getTime(), "1111");
        Coche c3 = new Coche("11111ckk", "coche", "repetido", cal.getTime(), "1111");

        Persona p3 = new Persona("22222222K", "Persona", "tres", "11111", cal.getTime());
        Coche c4 = new Coche("44444ckk", "coche", "cuatro", cal.getTime(), "1111");
        Coche c5 = new Coche("55555ckk", "coche", "cinco", cal.getTime(), "1111");
        Coche c6 = new Coche("66666ckk", "coche", "seis", cal.getTime(), "1111");

        try {
            park.addPersona(p2);
        } catch (Exception ex) {
            Logger.getLogger(WriteParkin.class.getName()).log(Level.SEVERE, null, ex);
        }
        park.addCoche(p2, c2);
        park.addCoche(p2, c3);
        park.addCoche(p1, c3);
        park.addCoche(p1, c6);

        try {
            park.addPersona(p3);
        } catch (Exception ex) {
            Logger.getLogger(WriteParkin.class.getName()).log(Level.SEVERE, null, ex);
        }
        park.addCoche(p3, c4);
        park.addCoche(p3, c5);
        park.addCoche(p3, c3);

        System.out.println(park.toString());
        System.out.println("Listado coches: \n");
        it = park.getListaTotalCoches().iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());

        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Borro persona uno\n");

        park.delPersona(p1);
        System.out.println(park.toString());
        System.out.println("Listado coches: \n");
        it = park.getListaTotalCoches().iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());

        }

        System.out.println("Grabo fichero XML.");
        try {

            File file = new File("parking.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Parking.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(park, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("Leo fichero XML.");
        try {

		File file = new File("parking.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Parking.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Parking park2 = (Parking) jaxbUnmarshaller.unmarshal(file);
		System.out.println(park2.toString());

	  } catch (JAXBException e) {
		e.printStackTrace();
	  }
        
//        HashSet<Persona> nuevaListaPersonas = new HashSet<>();
//        HashSet<Coche> nuevaListaCoches = new HashSet<>();
//
//        System.out.println(
//                "Leo fichero de objetos.");
//
//        try {
//            fpo.leeFicheroObjetos(null, nuevaListaPersonas, nuevaListaCoches);
//        } catch (Exception ex) {
//            Logger.getLogger(WriteParkin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        System.out.println(
//                "Datos leidos del fichero:");
//
//        it = nuevaListaPersonas.iterator();
//
//        while (it.hasNext()) {
//            System.out.println(it.next().toString());
//
//        }
//
//        System.out.println(
//                "Listado coches: \n");
//        it = nuevaListaCoches.iterator();
//
//        while (it.hasNext()) {
//            System.out.println(it.next().toString());
//
//        }

    }
}
