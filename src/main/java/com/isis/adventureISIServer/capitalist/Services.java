package com.isis.adventureISIServer.capitalist;


import generated.World;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    
    public World world = new World();
    
    public Services(){
        readWorldFromXml();
    }
    
    public World readWorldFromXml(){
        JAXBContext jaxbContext;

        InputStream input = getClass().getClassLoader().getResourceAsStream("jaxb/world/world.xml");
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
            OutputStream output = new FileOutputStream("world.xml");
            jaxbContext = JAXBContext.newInstance(World.class);
            Marshaller march = jaxbContext.createMarshaller();
            march.marshal(world, output);
        } catch (Exception ex) {
            System.out.println("Erreur écriture du fichier:"+ex.getMessage());
            ex.printStackTrace();
        }
        
        
}
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public World getWorld(){
        return world;
        
    }
    
}
