package com.isis.adventureISIServer.capitalist;


import generated.World;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tcrubill
 */
public class Services {
    
    World world = new World();
    
    public World readWorldFromXml(){
        JAXBContext jaxbContext;

        InputStream input = getClass().getClassLoader().getResourceAsStream("worldProduct.xml");
         try {
            jaxbContext = JAXBContext.newInstance(World.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            world = (World) jaxbUnmarshaller.unmarshal(input);
        } catch (JAXBException ex) {
            System.out.println("Erreur lecture du fichier:"+ex.getMessage());
            ex.printStackTrace();
        }
        return this.world;
}
    
public void saveWordlToXml(World world){
        JAXBContext jaxbContext;
        try {
            OutputStream output = new FileOutputStream("worldProduct.xml");
            jaxbContext = JAXBContext.newInstance(World.class);
            Marshaller march = jaxbContext.createMarshaller();
            march.marshal(world, output);
        } catch (Exception ex) {
            System.out.println("Erreur écriture du fichier:"+ex.getMessage());
            ex.printStackTrace();
        }
        
        
}
    
    public World getWorld(){
        return world;
        
    }
    
}
