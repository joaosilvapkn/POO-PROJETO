import java.time.LocalDateTime;
import java.time.LocalDate;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

/**
 * Write a description of class Sapatilhas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sapatilha extends Artigo implements Serializable
{
    private int tamanho;
    private String atacadoresOUatilhos;
    private String cor;
    private int anocolecao;
    
    public Sapatilha(String desc, int exdonos, double precobase, boolean novo, double aval, int tamanho, String atacOUatilhos, String cor, int anocolecao){
        super(desc, exdonos, precobase, novo, aval);
        this.tamanho=tamanho;
        this.cor=cor;
        this.anocolecao=anocolecao;
        if(atacOUatilhos.equals("atacadores")){this.atacadoresOUatilhos="atacadores";}
        if(atacOUatilhos.equals("atilhos")){this.atacadoresOUatilhos="atilhos";}
        
        LocalDate data = LocalDate.now();
        int year = data.getYear();
        

        if(anocolecao<year || super.getnovo()==false || tamanho > 45){
            super.setprecocorrecao(precobase - (precobase/exdonos * aval));
        }
        else{super.setprecocorrecao(precobase);}
    }
    
    //METODOS GET
    public int gettamanho(){
        return this.tamanho;
    }
    public String getatacadoresOUatilhos(){
        return this.atacadoresOUatilhos;
    }
    public String getcor(){
        return this.cor;
    }
    public int getanocolecao(){
        return this.anocolecao;
    }
    
    //METODOS SET
    public void settamanho(int tamanho){
        this.tamanho=tamanho;
    }
    public void setatacadoresOUatilhos(String s){
        this.atacadoresOUatilhos=s;
    }
    public void setcor(String cor){
        this.cor=cor;
    }
    public void setanocolecao(int ano){
        this.anocolecao=ano;
    }
    
    //METODO CLONE
    public Sapatilha clone(){
        Sapatilha sap = new Sapatilha(super.getdescricao(), super.getexdonos(), super.getprecobase(), super.getnovo(), super.getestadoutilizacao(), this.tamanho, this.atacadoresOUatilhos, this.cor, this.anocolecao);
        sap.setprecocorrecao(super.getprecocorrecao());
        sap.setcodigo(super.getcodigo());
        return sap;
    }
    
    //TO String
    public String toString(){
        final StringBuffer sb = new StringBuffer();
        sb.append("\tCodigo= ").append(super.getcodigo()).append("\n");
        sb.append("\tDescricao= ").append(super.getdescricao()).append("\n");
        sb.append("\tNumero de Ex donos= ").append(String.valueOf(super.getexdonos())).append("\n");
        sb.append("\tPreco Base= ").append(String.valueOf(super.getprecobase())).append("\n");
        sb.append("\tPreco correcao= ").append(String.valueOf(super.getprecocorrecao())).append("\n");
        sb.append("\tAvalicacao= ").append(String.valueOf(super.getestadoutilizacao())).append("\n");
        sb.append("\tTamanho= ").append(String.valueOf(this.tamanho)).append("\n");
        sb.append("\t").append(this.atacadoresOUatilhos).append("\n");
        sb.append("\t").append(this.cor).append("\n");
        sb.append("\tAno da Colecao= ").append(String.valueOf(this.anocolecao)).append("\n");
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
        
        Sapatilha sap = (Sapatilha) ois.readObject();
        ois.close();
        
        return sap;
    }
    */
    
}
