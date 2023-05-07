import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

/**
 * Write a description of class Tshirt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tshirt extends Artigo implements Serializable
{
    private String tamanho;
    private String padrao;
    
    public Tshirt(String desc, int exdonos, double precobase, boolean novo, double aval, String tamanho, String padrao){
        super(desc, exdonos, precobase, novo, aval);
        if(tamanho.equals("S")) this.tamanho="S";
        if(tamanho.equals("M")) this.tamanho="M";
        if(tamanho.equals("l")) this.tamanho="l";
        if(tamanho.equals("XL")) this.tamanho="XL";
        
        if(padrao.equals("liso")) this.padrao="liso";
        if(padrao.equals("riscas")) this.padrao="riscas";
        if(padrao.equals("palmeiras")) this.padrao="palmeiras";
        
        if((padrao.equals("liso") || padrao.equals("palmeiras")) && super.getnovo()==false){
            super.setprecocorrecao(precobase/2);
        }
        else{super.setprecocorrecao(precobase);}
    }
    
    //METODOS GET
    public String gettamanho(){
        return this.tamanho;
    }
    public String getpadrao(){
        return this.padrao;
    }
    
    //METODOS SET
    public void settamanho(String tamanho){
        this.tamanho=tamanho;
    }
    public void setpadrao(String padrao){
        this.padrao=padrao;
    }
    
    //METODO CLONE
    public Tshirt clone(){
        Tshirt t = new Tshirt(super.getdescricao(), super.getexdonos(), super.getprecobase(), super.getnovo(), super.getestadoutilizacao(), this.tamanho, this.padrao);
        t.setcodigo(this.getcodigo());
        t.setprecocorrecao(this.getprecocorrecao());
        return t;
    }
    
    //TO STRING
    public String toString(){
        final StringBuffer sb = new StringBuffer();
        sb.append("\tCodigo= ").append(super.getcodigo()).append("\n");
        sb.append("\tDescricao= ").append(super.getdescricao()).append("\n");
        sb.append("\tNumero de Ex donos= ").append(String.valueOf(super.getexdonos())).append("\n");
        sb.append("\tPreco Base= ").append(String.valueOf(super.getprecobase())).append("\n");
        sb.append("\tPreco correcao= ").append(String.valueOf(super.getprecocorrecao())).append("\n");
        sb.append("\tAvalicacao= ").append(String.valueOf(super.getestadoutilizacao())).append("\n");
        sb.append("\t").append(this.tamanho).append("\n");
        sb.append("\t").append(this.padrao).append("\n");
        return sb.toString();
    }
    /*
    //LER E ESCREVER
      public void gravaobj(String nomef) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomef));
        
        oos.writeObject(this);
        oos.close();
    }
    
    public static Artigo leobj(String nomef) throws ClassNotFoundException, IOException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomef));
        
        Tshirt shirt = (Tshirt) ois.readObject();
        ois.close();
        
        return shirt;
    }
    */
}

