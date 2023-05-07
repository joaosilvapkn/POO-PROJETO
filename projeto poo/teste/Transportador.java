import java.util.ArrayList;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.time.LocalDateTime;


public class Transportador implements Serializable
{
    private String nome;
    private double valorbasePequeno;
    private double valorbaseMedio;
    private double valorbaseGrande;
    private double imposto;
    private double precoExpedicao;
    private ArrayList<Encomenda> encomendas;
    private int numenc;
    
    public Transportador(String nome, double valorp, double valorm, double valorg, double imposto){
        this.nome=nome;
        this.valorbasePequeno=valorp;
        this.valorbaseMedio=valorm;
        this.valorbaseGrande=valorg;
        this.imposto=imposto;
        ArrayList<Encomenda> encomendas = new ArrayList<Encomenda>();
        this.encomendas=encomendas;
        this.numenc=0;
    }
    
    //METODOS GET
    public String getnome(){
        return this.nome;
    }
    public double getvalorbasePequeno(){
        return this.valorbasePequeno;
    }
    public double getvalorbaseMedio(){
        return this.valorbaseMedio;
    }
    public double getvalorbaseGrande(){
        return this.valorbaseGrande;
    }
    public double getimposto(){
        return this.imposto;
    }
    public double getprecoExpedicao(){
        return this.precoExpedicao;
    }
    public ArrayList<Encomenda> getencomendas(){
        return this.encomendas;
    }
    public int getnumenc(){
        return this.numenc;
    }
    
    //METODOS SET
    public void setnome(String nome){
        this.nome=nome;
    }
    public void setvalorbasePequeno(double v){
        this.valorbasePequeno=v;
    }
    public void setvalorbaseMedio(double v){
        this.valorbaseMedio=v;
    }
    public void setvalorbaseGrande(double v){
        this.valorbaseGrande=v;
    }
    public void setimposto(double imposto){
        this.imposto=imposto;
    }
    public void setprecoExpedicao(double precoExpedicao){
        this.precoExpedicao=precoExpedicao;
    }
    public void setencomendas(ArrayList<Encomenda> encomendas){
        this.encomendas=encomendas;
    }
    public void setnumenc(int numenc){
        this.numenc=numenc;
    }
    
    //OUTROS METODOS
    public void addencomenda(Encomenda e){
        this.encomendas.add(e);
        this.numenc++;
    }
    public void removeencomenda(Encomenda e){
        this.encomendas.remove(e);
    }
    
    public void encomendachegou(Encomenda e){
        for(Encomenda enc : this.encomendas){
            if(e.equals(enc)){
                e.entregue();
            }
        }
    }
    
    public void devolveencomenda(Encomenda e){
        for(Encomenda enc : this.encomendas){
            if(e.devolvivel()==true && e.equals(enc) ){
                enc.devolvida();
                this.removeencomenda(e);
            }
        }
        
    }
    
    //METODO EQUALS
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || o.getClass()!=this.getClass()) return false;
        Transportador t = (Transportador) o;
        return this.nome.equals(t.getnome());
    }
    
    //METODO TO STRING
    public String toString(){
        return this.nome+String.valueOf(this.numenc);
    }
    
    /*
    //LER E ESCREVER
    public void gravaobj(String nomef) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomef));
        
        oos.writeObject(this);
        oos.close();
    }
    
    public static Transportador leobj(String nomef) throws ClassNotFoundException, IOException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomef));
        
        Transportador transp = (Transportador) ois.readObject();
        ois.close();
        
        return transp;
    }
    */
    
    
    

 
    
    
    
    
}
