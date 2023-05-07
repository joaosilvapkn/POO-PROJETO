import java.util.Random;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.File;

public abstract class Artigo implements Serializable
{
    private String codigo;
    private String descricao;
    private int exDonos;
    private double precobase;
    private double precocorrecao;
    private boolean novo;
    private double estadoutilizacao;
    

    
    public Artigo(String desc, int exdonos, double precobase, boolean novo, double aval){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
      
        this.codigo=generatedString;
        
        this.codigo=codigo;
        this.descricao=desc;
        this.precobase=precobase;
        this.exDonos=exdonos;
        this.novo = novo;
        this.estadoutilizacao=aval;
        this.precocorrecao = precobase - (precobase/exDonos * estadoutilizacao);
    }
    
    //METODOS GET
    public String getcodigo(){
        return this.codigo;
    }
    public String getdescricao(){
        return this.descricao;
    }
    public int getexdonos(){
        return this.exDonos;
    }
    public double getprecobase(){
        return this.precobase;
    }
    public double getprecocorrecao(){
        return this.precocorrecao;
    }
    public double getestadoutilizacao(){
        return this.estadoutilizacao;
    }
    public boolean getnovo(){
        return this.novo;
    }

    //METODOS SET
    public void setcodigo(String x){
        this.codigo=x;
    }
    public void setdescricao(String desc){
        this.descricao=desc;
    }
    public void setexdonos(int exdonos){
        this.exDonos=exdonos;
    }
    public void setprecobase(double precobase){
        this.precobase=precobase;
    }
    public void setprecocorrecao(double precocorrecao){
        this.precocorrecao=precocorrecao;
    }
    public void setnovo(boolean b){
        this.novo=b;
    }
    public void setestadoutilizacao(double est){
        this.estadoutilizacao=est;
    }

    
    //METODO EQUALS
    public boolean equals(Object o){
        if(o==null || o.getClass()!=this.getClass()) return false;
        if(this==o) return true;
        Artigo art = (Artigo) o;
        return this.codigo.equals(art.getcodigo());

    }
    
    
    /*
    //teste
    public void gravaobj(String nomef) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomef));
        
        oos.writeObject(this);
        oos.close();
    }
    
    public static Artigo leobj(String nomef) throws ClassNotFoundException, IOException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomef));
        
        Artigo art = (Artigo) ois.readObject();
        ois.close();
        
        return art;
    }
    */
}
