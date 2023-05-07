
import java.util.ArrayList;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class Utilizador implements Serializable
{
    private String codigo;
    private String email;
    private String nome;
    private String morada;
    private int nif;
    private ArrayList<Artigo> avenda;
    private ArrayList<Artigo> avender;
    private double precovendas;
    
    public Utilizador(String codigo, String email, String nome, String morada, int nif){
        this.codigo=codigo;
        this.email=email;
        this.nome=nome;
        this.morada=morada;
        this.nif=nif;
        this.precovendas=0;
        
        this.avenda = new ArrayList<Artigo>();
        this.avender= new ArrayList<Artigo>();
    }
    
    
    public void avenda(Artigo x){
        this.avenda.add(x);
    }
     public void retiravenda(Artigo x){
        this.avenda.remove(x);
    }
  
    
    public void avender(Artigo x){
        this.avenda.remove(x);
        this.avender.add(x);
        this.aumentaprecovendas(x);
    }
    public void retiravender(Artigo x){
        this.avender.remove(x);
        this.diminuiprecovendas(x);
    }
    
  
    
    public void aumentaprecovendas(Artigo x){
        this.precovendas+=x.getprecocorrecao();
    }
    
    public void diminuiprecovendas(Artigo x){
        this.precovendas-=x.getprecocorrecao();
    }
    
    
    //METODOS GET
    public String getcodigo(){
        return this.codigo;
    }
    public String getemail(){
        return this.email;
    }
    public String getnome(){
       return this.nome;
    }
    public String getmorada(){
        return this.morada;
    }
    public int getnif(){
        return this.nif;
    }
    public double getprecovendas(){
        return this.precovendas;
    }
    public ArrayList<Artigo> getavender(){
        return this.avender;
    }
    public ArrayList<Artigo> getavenda(){
        return this.avenda;
    }
    
    //METODOS SET
    public void setcodigo(String codigo){
        this.codigo=codigo;
    }
    public void setemail(String email){
        this.email=email;
    }
    public void setnome(String nome){
        this.nome=nome;
    }
    public void setmorada(String morada){
        this.morada=morada;
    }
    public void setnif(int nif){
        this.nif=nif;
    }
    public void setprecovendas(double precovendas){
        this.precovendas=precovendas;
    }
    public void setavenda(ArrayList<Artigo> avenda){
        this.avenda=avenda;
    }
    public void setavender(ArrayList<Artigo> avender){
        this.avender=avender;
    }
    
    //Metodo equals
    public boolean equals(Object o){
        if(o==null || this.getClass()!=o.getClass()) return false;
        if(this==o)return true;
        Utilizador user = (Utilizador) o;
        return user.getcodigo().equals(user.getcodigo());
    }
    
    //TO STRING
    public String toString(){
        
        final StringBuffer sb = new StringBuffer();
        sb.append("\tCodigo= ").append(this.codigo).append("\n");
        sb.append("\tEmail= ").append(this.email).append("\n");
        sb.append("\tNome= ").append(this.nome).append("\n");
        sb.append("\tMorada= ").append(this.morada).append("\n");
        sb.append("\tNif= ").append(String.valueOf(this.getnif())).append("\n");
        return sb.toString();
    }
    
    //LER E ESCREVER
      public void gravaobj(String f) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        
        oos.writeObject(this);
        oos.close();
    }
    
    public static Utilizador leobj(String f) throws ClassNotFoundException, IOException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        
        Utilizador user = (Utilizador) ois.readObject();
        ois.close();
        
        return user;
    }
    
    
    
    //testeeee
    
}
