
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
    
    String path ="D:\\Users\\tcrubill\\Documents\\GitHub\\adventureCapitalist";
    public World readWorldFromXml(){

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(World.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File f = new File("worldProduct.xml");
            world = (World) jaxbUnmarshaller.unmarshal(f);
            
           
        } catch (JAXBException ex) {
            System.out.println("Erreur lecture du fichier:"+ex.getMessage());
            ex.printStackTrace();
        }
        
        return this.world;
    }

    public void saveWordlToXml(World world) throws JAXBException{
            JAXBContext jaxbContext;
        try{
            jaxbContext = JAXBContext.newInstance(World.class);
            Marshaller march = jaxbContext.createMarshaller();
            OutputStream output = new FileOutputStream("world.xml");
            march.marshal(this.world, output);
             
        }catch(IOException ex){
            System.out.println("Erreur lecture du fichier:"+ex.getMessage());
            ex.printStackTrace();
        } 
    }
    
    public World getWorld(){
        return world;
        
    }
    
}
