
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
    private String file = "sauvegarde.xml";
    
    public World readWorldFromXml(){
        InputStream input=getClass().getClassLoader().getResourceAsStream(file);
        return this.world;
    }
    
    public void saveWordlToXml(World world) throws JAXBException{
            JAXBContext jaxbContext;
        try{
            jaxbContext = JAXBContext.newInstance(World.class);
            Marshaller march = jaxbContext.createMarshaller();
            OutputStream output = new FileOutputStream(file);
            march.marshal(world, output);
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public World getWorld() throws JAXBException{
        JAXBContext jaxbContext;
        jaxbContext = JAXBContext.newInstance(World.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        File f = new File("world.xml");
        world = (World) jaxbUnmarshaller.unmarshal(f);
        
        return world;
    }
    
}
