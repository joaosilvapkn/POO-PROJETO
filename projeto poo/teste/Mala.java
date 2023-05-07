import java.time.LocalDate;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Mala extends Artigo implements Serializable
{ 
    public double largura;
    public double comprimento;
    public double altura;
    public double volume;
    public int anocolecao;
    private String material;
    
    public Mala(String desc, int exdonos, double precobase, boolean novo, double aval, double largura, double comprimento, double altura, int ano, String material){
        super(desc, exdonos, precobase, novo, aval);
        this.largura=largura;
        this.comprimento=comprimento;
        this.altura=altura;
        this.volume=largura*comprimento*altura;
        this.anocolecao=ano;
        this.material=material;
        
        LocalDate agora = LocalDate.now();
        int year = agora.getYear();
        
        if(super.getnovo()==false || anocolecao<year){super.setprecocorrecao(precobase/2);}
        else{super.setprecocorrecao(precobase);}
    }
    
    //METODOS GETS
    public double getlargura(){
        return this.largura;
    }
    public double getcomprimento(){
        return this.comprimento;
    }
    public double getaltura(){
        return this.altura;
    }
    public double getvolume(){
        return this.volume;
    }
    public int getanocolecao(){
        return this.anocolecao;
    }
    public String getmaterial(){
        return this.material;
    }
    
    //METODOS SET
    public void setlargura(double largura){
        this.largura=largura;
        this.volume=this.largura*this.comprimento*this.altura;
    }
    public void setcomprimento(double comprimento){
        this.comprimento=comprimento;
        this.volume=this.largura*this.comprimento*this.altura;
    }
    public void setaltura(double altura){
        this.altura=altura;
        this.volume=this.largura*this.comprimento*this.altura;
    }
    public void setvolume(double l, double c, double a){
        this.largura=l;
        this.comprimento=c;
        this.altura=a;
        this.volume=l*c*a;
    }
    public void setanocolecao(int ano){
        this.anocolecao=ano;
    }
    public void setmaterial(String material){
        this.material=material;
    }
    
    //METODO CLONE
    public Mala clone(){
        Mala m = new Mala(super.getdescricao(), super.getexdonos(), super.getprecobase(), super.getnovo(), super.getestadoutilizacao(), this.largura, this.comprimento, this.altura, this.anocolecao, this.material);
        m.setcodigo(super.getcodigo());
        m.setprecocorrecao(super.getprecocorrecao());
        return m;
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
        sb.append("\tLargura= ").append(String.valueOf(this.largura)).append("\n");
        sb.append("\tComprimento= ").append(String.valueOf(this.comprimento)).append("\n");
        sb.append("\tAltura= ").append(String.valueOf(this.altura)).append("\n");
        sb.append("\tVolume= ").append(String.valueOf(this.volume)).append("\n");
        sb.append("\tAno de Colecao= ").append(String.valueOf(this.anocolecao)).append("\n");
        sb.append("\tMaterial= ").append(this.material).append("\n");
        
        return sb.toString();
    }
    /*
    //ESCREVER E LER
      public void gravaobj(String nomef) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomef));
        
        oos.writeObject(this);
        oos.close();
    }
    
    public static Artigo leobj(String nomef) throws ClassNotFoundException, IOException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomef));
        
        Mala m = (Mala) ois.readObject();
        ois.close();
        
        return m;
    }
    */
}
