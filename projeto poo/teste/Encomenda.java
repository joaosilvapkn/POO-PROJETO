import java.util.ArrayList;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;


public class Encomenda implements Serializable
{
    private final static String pequena="pequena";
    private final static String media="media";
    private final static String grande="grande";
    
    private final static String pendente="pendente";
    private final static String finalizada="finalizada";
    private final static String expedida="expedida";
    private final static String entregue="entregue";
    
    
    private ArrayList<Artigo> artigos;
    private Utilizador vendedor;
    private Utilizador comprador;
    private int num;
    private double precofinal;
    private String tamanho;
    private String estado;
    private LocalDateTime data;
    private LocalDateTime datachegada;
    
    public Encomenda(Utilizador vendedor, Utilizador comprador, int num){
        ArrayList<Artigo> artigos = new ArrayList<Artigo>();
        this.comprador=comprador;
        this.vendedor=vendedor;
        this.num=num;
        this.artigos=artigos;
        this.estado="pendente";
        this.data=LocalDateTime.now();
    }
    
    public void addartigo(Artigo x){
        if(this.estado.equals("pendente")){
        this.artigos.add(x);
        double preco=0;
        int n=0;
        for(Artigo a : this.artigos){
            if(x.getnovo()==true){preco+=a.getprecocorrecao(); preco+=0.50;}
            if(x.getnovo()==false){preco+=a.getprecocorrecao(); preco+=0.25;}
            n++;
        }
        this.precofinal=preco;
        if(n==1)this.tamanho="pequeno";
        if(n>1 && n<6) this.tamanho="medio";
        if(n>5) this.tamanho="grande";
        }
    }
    
    
    
    public void removeartigo(Artigo x){
        this.artigos.remove(x);
        double preco=0;
        int n=0;
        for(Artigo a : this.artigos){
            if(x.getnovo()==true){preco+=a.getprecocorrecao(); preco+=0.50;}
            if(x.getnovo()==false){preco+=a.getprecocorrecao(); preco+=0.25;}
            n++;
        }
        this.precofinal=preco;
        if(n==1)this.tamanho="pequeno";
        if(n>1 && n<6) this.tamanho="medio";
        if(n>5) this.tamanho="grande";
    }
    
    public void finalizada(){
        this.estado="finalizada";
        for(Artigo art : this.artigos){
            this.vendedor.avender(art);
            this.vendedor.aumentaprecovendas(art);
        }
    }
    
    public void expedida(){
        this.estado="expedida";
    }
    
    public void entregue(){
        this.estado="entregue";
        this.datachegada = LocalDateTime.now();
    }
    
    //outros metodos
    public boolean temartigo(Artigo x){
        boolean r=false;
        for(Artigo art : this.artigos){
            if(art.equals(x)){
                r=true;
            }
        }
        return r;
    }
    public boolean evendedor(Utilizador x){
        boolean r=false;
        if(this.vendedor.equals(x)){r=true;}
        return r;
    }
        public boolean ecomprador(Utilizador x){
        boolean r=false;
        if(this.comprador.equals(x)){r=true;}
        return r;
    }
    public void devolvida(){
        if(this.estado==expedida || this.estado==finalizada)
        for(Artigo art : this.artigos){
            this.vendedor.retiravender(art);
        }
    }
    
    public boolean devolvivel(){
        if(this.estado.equals("finalizada") || this.estado.equals("expedida")){
            return true;
        }
       /* if(this.estado.equals("entregue")){
            LocalDateTime agora = LocalDateTime.now();
            long daysdiff=
            if(daysdiff<2){ return true;}
        }*/
        return false;
    }
    
    
    //METODOS GET
    public ArrayList<Artigo> getartigos(){
        return this.artigos;
    }
    public String gettamanho(){
        return this.tamanho;
    }
    public String getestado(){
        return this.estado;
    }
    public double getprecofinal(){
        return this.precofinal;
    }
    public LocalDateTime getdata(){
        return this.data;
    }
    public Utilizador getcomprador(){
        return this.comprador;
    }
    public Utilizador getvendedor(){
        return this.vendedor;
    }
    public int getnum(){
        return this.num;
    }
    public LocalDateTime getdatachegada(){
        return this.datachegada;
    }
    
    //METODOS SET
    public void setartigos(ArrayList<Artigo> artigos){
        this.artigos=artigos;
    }
    public void settamanho(String tamanho){
        this.tamanho=tamanho;
    }
    public void setestado(String estado){
        this.estado=estado;
    }
    public void setprecofinal(double precofinal){
        this.precofinal=precofinal;
    }
    public void setdata(LocalDateTime data){
        this.data=data;
    }
    public void setcomprador(Utilizador comprador){
        this.comprador=comprador;
    }
    public void setvendedor(Utilizador vendedor){
        this.vendedor=vendedor;
    }
    public void setnum(int num){
        this.num=num;
    }
    public void setdatachegada(LocalDateTime datachegada){
        this.datachegada=datachegada;
    }
    
    //TO String
    public String toString(){
        final StringBuffer sb = new StringBuffer();
        sb.append("\tVendedor= ").append(this.vendedor.getmorada()).append("\n");
        sb.append("\tComprador= ").append(this.comprador.getmorada()).append("\n");
        sb.append("\tEstado= ").append(this.estado).append("\n");
        sb.append("\tNumero de Artigos= ").append(String.valueOf(this.artigos.size())).append("\n");
        sb.append("\tNumero da Encomenda = ").append(String.valueOf(this.getnum())).append("\n");
        
        return sb.toString();
    }
    
  
    
    //EQUALS
    public boolean equals(Object o){
        if(o==null || o.getClass()!=this.getClass()) return false;
        if(this==o) return true;
        Encomenda e = (Encomenda) o;
        return this.comprador.equals(e.getcomprador()) && this.vendedor.equals(e.getvendedor())
        && this.data.equals(e.getdata());
    }
    
    //LER E ESCREVER
    public void gravaobj(String nomef) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomef));
        
        oos.writeObject(this);
        oos.close();
    }
    
    public static Encomenda leobj(String nomef) throws ClassNotFoundException, IOException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomef));
        
        Encomenda enc = (Encomenda) ois.readObject();
        ois.close();
        
        return enc;
    }

    
    

}
