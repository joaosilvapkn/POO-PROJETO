import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.StreamCorruptedException;
import java.util.Collection;

public class Vintage implements Serializable
{
    private HashMap<String, Utilizador> users;
    private ArrayList<Transportador> transportadores;

    
    public Vintage(){
        HashMap<String, Utilizador> users = new HashMap<String, Utilizador>();
        ArrayList<Transportador> transportadores = new ArrayList<Transportador>();
        this.users=users;
        this.transportadores=transportadores;
    }
    
    
    
    //SETS E GETS
    public HashMap<String, Utilizador> getusers(){
        return this.users;
    }
    public ArrayList<Transportador> gettransportadores(){
        return this.transportadores;
    }
    
    
    public void setusers(HashMap<String, Utilizador> users){
        this.users=users;
    }
    public void settransportadores(ArrayList<Transportador> transportadores){
        this.transportadores=transportadores;
    }
    
    //OUTROS METODOS
    public void adduser(Utilizador x){
        this.users.put(x.getcodigo(), x);
    }
    public void removeuser(Utilizador x){
        this.users.remove(x.getcodigo(), x);
    }
    
    public void addtransportador(Transportador x){
        this.transportadores.add(x);
    }
    public void removetransportador(Transportador x){
        this.transportadores.remove(x);
    }
    
    public boolean existeuser(String codigo){
        return this.users.containsKey(codigo);
    }
    
    public Utilizador procurauser(String codigo){
        return  this.users.get(codigo);
    }
    
    public Collection<Utilizador> todosusers(){
        return this.users.values();
    }
    
    public boolean existetransportador(String nome){
        boolean r = false;
        for(Transportador t : this.transportadores){
            if(t.getnome().equals(nome)){
                r=true;
                break;
            }
        }
        return r;
    }
    
    public Transportador procuratransportador(String nome){
        for(Transportador t : this.transportadores){
            if(t.getnome().equals(nome)){
                return t;
            }
        }
        return null;
    }
    
    
    //LER E ESCREVER
    public void gravaobj(String nomef) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomef));
        
        oos.writeObject(this);
        oos.close();
    }
    
    public static Vintage leobj(String nomef) throws ClassNotFoundException, IOException, StreamCorruptedException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomef));
        
        Vintage vin = (Vintage) ois.readObject();
        ois.close();
        
        return vin;
    }
    
   
    
    
 
}
 

