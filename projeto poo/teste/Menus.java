import java.util.Scanner;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.EOFException;
import java.io.File;
import java.util.HashMap;


public class Menus
{
    private Scanner ler;
    private Vintage loja;
    
    public Menus() throws ClassNotFoundException, java.io.IOException {
        this.ler=new Scanner(System.in);
        this.loja=new Vintage();
        /*
        try
        {
            this.loja.leobj("vin.txt");
        }
        catch (ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        */
        File f = new File("users.txt");
        if(f.length()!=0){
            FileInputStream fis = new FileInputStream("users.txt");
            ObjectInputStream ois= new ObjectInputStream(fis);
            ArrayList<Utilizador> vintageusers = (ArrayList<Utilizador>) ois.readObject();
            fis.close();
            ois.close();
            System.out.println("USERS ADICIONADOS DE FICHEIROS");
            for(Utilizador u : vintageusers){
                this.loja.adduser(u);
            }
        }
        else{this.loja.setusers(new HashMap<String, Utilizador>());}
            for(Utilizador u : this.loja.todosusers()){
                File f1 = new File(u.getcodigo()+"avender.txt");
                if(f1.length()!=0){
                FileInputStream fis7 = new FileInputStream(u.getcodigo()+"avender.txt");
                ObjectInputStream ois7= new ObjectInputStream(fis7);
                ArrayList<Artigo> arts = (ArrayList<Artigo>) ois7.readObject();
                ois7.close();
                fis7.close();
                u.setavender(arts);
                System.out.println("ARTIGOS A VENDER ADICIONADOS DE FICHEIROS");
                }
                else{u.setavender(new ArrayList<Artigo>());}
                
                File f2 = new File(u.getcodigo()+"avenda.txt");
                if(f2.length()!=0){
                     FileInputStream fis7 = new FileInputStream(u.getcodigo()+"avenda.txt");
                    ObjectInputStream ois7= new ObjectInputStream(fis7);
                    ArrayList<Artigo> arts = (ArrayList<Artigo>) ois7.readObject();
                    ois7.close();
                    fis7.close();
                    u.setavenda(arts);
                    System.out.println("ARTIGOS À VENDA ADICIONADOS DE FICHEIROS");
                }
                else{u.setavenda(new ArrayList<Artigo>());}
            
        }

        
        File f2 = new File("transps.txt");
        if(f2.length()!=0){
            FileInputStream fis1 = new FileInputStream("transps.txt");
            ObjectInputStream ois1= new ObjectInputStream(fis1);
            ArrayList<Transportador> vintagetransp = (ArrayList<Transportador>) ois1.readObject();
            ois1.close();
            fis1.close();
        
            this.loja.settransportadores(vintagetransp);
            System.out.println("TRANSPORTADORES ADICIONADOS DE FICHEIROS");
        }
        else{
            this.loja.settransportadores(new ArrayList<Transportador>());
        }
        
        for(Transportador t : this.loja.gettransportadores()){
            File f3 = new File(t.getnome()+"encs.txt");
            if(f3.length()!=0){
                FileInputStream fis2 = new FileInputStream(t.getnome()+"encs.txt");
                ObjectInputStream ois2= new ObjectInputStream(fis2);
                ArrayList<Encomenda> tencs = (ArrayList<Encomenda>) ois2.readObject();
                ois2.close();
                fis2.close();
                t.setencomendas(tencs);
                System.out.println("ENCOMENDAS ADICIONADAS DE FICHEIROS");
            }
            else{t.setencomendas(new ArrayList<Encomenda>());}
        }
        
        for(Transportador t : this.loja.gettransportadores()){
            for(Encomenda e : t.getencomendas()){
                FileInputStream fis3 = new FileInputStream(t.getnome()+e.getnum()+"arts.txt");
                ObjectInputStream ois3= new ObjectInputStream(fis3);
                ArrayList<Artigo> arts = (ArrayList<Artigo>) ois3.readObject();
                ois3.close();
                fis3.close();
                
                e.setcomprador(this.loja.procurauser(e.getcomprador().getcodigo()));
                e.setvendedor(this.loja.procurauser(e.getvendedor().getcodigo()));
                
                e.setartigos(arts);
                System.out.println("DADOS DAS ENCOMENDAS ADICIONADOS DE FICHEIROS");
            }
        }
    }
    
    public void menu()throws IOException, ClassNotFoundException{
        System.out.println();
       // System.out.println("tenho a loja");
    
        System.out.println("O QUE PRETENDE FAZER");
        System.out.println("1-> CRIAR USER");
        System.out.println("2-> CRIAR TRANSPORTADORA");
        System.out.println("3-> VER SE USAR EXISTE");
        System.out.println("4-> IMPRIMIR TODOS OS USERS");
        System.out.println("5-> IMPRIMIR ARTIGOS À VENDA DE UM USER");
        System.out.println("6-> IMPRIMIR ARTIGOS A VENDER DE UM USER");
      //  System.out.println("7-> IMPRIMIR ARTIGOS COMPRADOS DE UM USER");
        System.out.println("8-> USER VENDE ARTIGO");
        System.out.println("9-> USER COMPRA ARTIGO");
        System.out.println("10-> IMRPIMIR TODAS AS TRANSPORTADORAS");
        System.out.println("11-> USER ADICIONA ARTIGO A ENCOMENDA");
        System.out.println("12-> IMPRIME AS ENCOMENDAS DE UMA TRANSPORTADORA");
        System.out.println("13-> USER FINALIZA ENCOMENDA");
        System.out.println("14-> TRANSPORTADORA EXPEDE ENCOMENDA");
        System.out.println("15-> TRANSPORTADORA ENTREGA ENCOMENDA");
        System.out.println("16-> TRANSPORTADORA DEVOLVE ENCOMENDA");
        
        
        int opt=this.ler.nextInt();
        
        
        
        
        
        
    
        if(opt==1){
                this.ler.nextLine();
                System.out.println("INSIRA O SEU CODIGO");
                String codigo=this.ler.nextLine();
                System.out.println("INSIRA O SEU EMAIL");
                String email=this.ler.nextLine();
                System.out.println("INSIRA O SEU NOME");
                String nome=this.ler.nextLine();
                System.out.println("INSIRA A SUA MORADA");
                String morada=this.ler.nextLine();
                System.out.println("INSIRA O SEU NIF");
                int nif=this.ler.nextInt();
                Utilizador x = new Utilizador(codigo, email, nome, morada, nif);
                this.loja.adduser(x);
            }
        if(opt==2){
                this.ler.nextLine();
                System.out.println("INSIRA O NOME");
                String nome=this.ler.nextLine();
                
                System.out.println("INSIRA O PRECO PEQUENO");
                double pp=this.ler.nextDouble();
                this.ler.nextLine();
                System.out.println("INSIRA O PRECO MEDIO");
                double pm=this.ler.nextDouble();
                this.ler.nextLine();
                System.out.println("INSIRA O PRECO GRANDE");
                double pg=this.ler.nextDouble();
                this.ler.nextLine();
                System.out.println("INSIRA O IMPOSTO");
                double imp =this.ler.nextDouble();
                this.ler.nextLine();
                Transportador x = new Transportador(nome, pp, pm, pg, imp);
                this.loja.addtransportador(x);
        }
        
        if(opt==3){
            this.ler.nextLine();
            System.out.println("INSIRA O CODIGO DO UTILIZADOR");
            String s = this.ler.nextLine();
            
            boolean b = this.loja.existeuser(s);
            if(b==true){
                System.out.println("EXISTE");
            }
            else{
                
                System.out.println("NOPE");
            }
        }
        
        if(opt==4){
            for(Utilizador u : this.loja.todosusers()){
                System.out.println(u.toString());
            }
        }
        
        if(opt==5){
            System.out.println("INSIRA O CODIGO DO USER");
            this.ler.nextLine();
            String s = this.ler.nextLine();
            if(this.loja.existeuser(s)==false){System.out.println("USER NAO EXISTE");}
            else{
                System.out.println(String.valueOf(this.loja.procurauser(s).getavenda().size())); 
                for(Artigo art : this.loja.procurauser(s).getavenda()){
                    System.out.println(art.toString());
                }
            }
        }
        
        if(opt==6){
            System.out.println("INSIRA O CODIGO DO USER");
            this.ler.nextLine();
            String s = this.ler.nextLine();
            if(this.loja.existeuser(s)==false){System.out.println("USER NAO EXISTE");}
            else{
                System.out.println(String.valueOf(this.loja.procurauser(s).getavenda().size())); 
                for(Artigo art : this.loja.procurauser(s).getavender()){
                    System.out.println(art.toString());
                }
            }
        }
        
               
       
       
        if(opt==8){
            this.ler.nextLine();
            System.out.println("INSIRA O CODIGO DO UTILIZADOR");
            String s = this.ler.nextLine();
            if(this.loja.existeuser(s)==false){System.out.println("NAO EXISTE!");}
            if(this.loja.existeuser(s)==true){
                Utilizador x = this.loja.procurauser(s);
                System.out.println("1-> SAPATILHA");
                System.out.println("2-> TSHIRT");
                System.out.println("3-> CAMISOLA");
                int opt2=this.ler.nextInt();
                if(opt2==1){
                    System.out.println("INSIRA A DESCRICAO DO PRODUTO");
                    this.ler.nextLine();
                    String descricao= this.ler.nextLine();
                    System.out.println("POR QUANTOS DONOS PASSADOS ESTE ARTIGO JA PASSOU");
                    int exdonos= this.ler.nextInt();
                    System.out.println("INSIRA O PRECO BASE DO PRODUTO");
                    double precobase=this.ler.nextDouble();
                    System.out.println("O PRODUTO É NOVO? SIM(1) OU NAO(0)");
                    int novo= this.ler.nextInt();
                    boolean n;
                    if(novo==1){n=true;}
                     else{n=false;}
                    System.out.println("AVALIACAO DO PRODUTO DE 0.0 ATE 1");
                    double aval=this.ler.nextDouble();
                    System.out.println("INSIRA O TAMANHO DA SAPATILHA");
                    int tamanho= this.ler.nextInt();
                    System.out.println("TEM ATACADORES(1) OU ATILHOS(2)");
                    int atacouat=this.ler.nextInt();
                    String tipo;
                    this.ler.nextLine();
                    if(atacouat==1){tipo="atacadores";}
                    else{tipo="atilhos";}
                    System.out.println("INSIRA A COR");
                    String cor=this.ler.nextLine();
                    System.out.println("INSIRA O ANO DA COLECAO");
                    int ano = this.ler.nextInt();
                    Sapatilha sap=new Sapatilha(descricao, exdonos, precobase, n, aval, tamanho, tipo, cor, ano);
                    System.out.println(sap.toString());
                    x.avenda(sap);
                }
            }
        }
        
        if(opt==9){
            this.ler.nextLine();
            System.out.println("INSIRA O CODIGO DO UTILIZADOR QUE VAI COMPRAR");
            String s = this.ler.nextLine();
            if(this.loja.existeuser(s)==false){System.out.println("NAO EXISTE!");}
            else{
                System.out.println("CARREGUE 1 PARA SELECIONAR O UTILIZADOR A QUE QUER COMPRAR");
                
                for(Utilizador u : this.loja.todosusers()){
                    System.out.println(u.toString());
                    int opt6 = this.ler.nextInt();
                    this.ler.nextLine();
                    if(opt6==1){
                        System.out.println("CARREGUE 1 PARA SELCIONAR A TRANSPORTADORA");
                        int optt=0;
                        for(Transportador t : this.loja.gettransportadores()){
                            System.out.println(t.toString());
                            optt=this.ler.nextInt();
                            if(optt==1){
                                 System.out.println("CARREEGUE 1 PARA SELECIONAR O ARTIGO A QUE QUER COMPRAR");
                                 for(Artigo art : u.getavenda()){
                                    int opt7=0;
                                    System.out.println(art.toString());
                                    Artigo a = art;
                                    opt7=this.ler.nextInt();
                                    if(opt7==1){
                                        Encomenda enc = new Encomenda(u, this.loja.procurauser(s), t.getnumenc());
                                        enc.addartigo(art);
                                        t.addencomenda(enc);
                                        System.out.println("ESTA TRANSPORTADORA TEM"+String.valueOf(t.getencomendas().size())+"ENCOMENDAS");
                                    }
                                 }
                            }
                    }
                }
            }
        }
    }
    if(opt==10){
            for(Transportador t : this.loja.gettransportadores()){
                System.out.println(t.toString());
            }
        }
    if(opt==11){
        this.ler.nextLine();
        System.out.println("INSIRA O SEU CODIGO");
        String s=this.ler.nextLine();
        if(this.loja.existeuser(s)==false){System.out.println("ESSE USER NAO EXISTE");}
        else{
            Utilizador x = this.loja.procurauser(s);
            for(Transportador t : this.loja.gettransportadores()){
                for(Encomenda e : t.getencomendas()){
                    if(e.getestado().equals("pendente") && x.equals(e.getcomprador())){
                        Utilizador x2=e.getvendedor();
                        System.out.println("ENCONTRAMOS UMA ENCOMENDA PENDENTE SUA");
                        System.out.println("CARREGUE (1) SE QUISERES ADICIONAR O ARTIGO A ENCOMENDA");
                        int add=0;
                        System.out.println(String.valueOf(e.getvendedor().getavenda().size()));
                        System.out.println(String.valueOf(e.getcomprador().getavenda().size()));
                        System.out.println(x2.toString());
                        for(Artigo art : e.getvendedor().getavenda()){
                            System.out.println(art.toString());
                            add=this.ler.nextInt();
                            if(add==1){
                                e.addartigo(art);
                            }
                        }
                    
                    }
                }
            }
        
        }
    }
    
    
    if(opt==12){
        this.ler.nextLine();
        System.out.println("INSIRA O NOME DA TRANSPORTADORA");
        String n = this.ler.nextLine();
        if(this.loja.existetransportador(n)==true){
                for(Encomenda e : this.loja.procuratransportador(n).getencomendas()){
                    System.out.println(e.toString());
                }
        }
        else{
            System.out.println("NAO EXISTE TAL TRANSPORTADORA ASSOCIADA COM A NOSSA LOJA");
        }
    }
    if(opt==13){
        this.ler.nextLine();
        System.out.println("INSIRA O SEU CODIGO");
        String s=this.ler.nextLine();
        if(this.loja.existeuser(s)==false){System.out.println("ESSE USER NAO EXISTE");}
        else{
            System.out.println("CARREGUE (1) NA ENCOMENDA QUE PRETENDE FINALIZAR");
            int fin=0;
            for(Transportador t : this.loja.gettransportadores()){
                for(Encomenda e : t.getencomendas()){
                    if(e.getestado().equals("pendente") && e.getcomprador().equals(this.loja.procurauser(s))){
                        System.out.println(e);
                        fin=this.ler.nextInt();
                        this.ler.nextLine();
                        if(fin==1){
                            e.finalizada();
                        }
                    }
                }
            }
        }
    }
    if(opt==14){
        this.ler.nextLine();
        System.out.println("INSIRA O NOME DA TRANSPORTADORA");
        String n = this.ler.nextLine();
        if(this.loja.existetransportador(n)){
            System.out.println("CARREGUE (1) PARA EXPEDIR ENCOMENDA");
            for(Encomenda e : this.loja.procuratransportador(n).getencomendas()){
                if(e.getestado().equals("finalizada")){
                System.out.println(e.toString());
                int exp=0;
                exp=this.ler.nextInt();
                if(exp==1){
                    e.expedida();
                }
            }
            }
        }
    }
    if(opt==15){
        this.ler.nextLine();
        System.out.println("INSIRA O NOME DA TRANSPORTADORA");
        String n = this.ler.nextLine();
        if(this.loja.existetransportador(n)){
            System.out.println("CARREGUE (1) PARA EXPEDIR ENCOMENDA");
            for(Encomenda e : this.loja.procuratransportador(n).getencomendas()){
                if(e.getestado().equals("expedida")){
                    System.out.println(e.toString());
                    int entr=0;
                    entr=this.ler.nextInt();
                    if(entr==1){
                        e.entregue();
                    }
                }
            }
        }
    }
    if(opt==16){
        this.ler.nextLine();
        System.out.println("INSIRA O NOME DA TRANSPORTADORA");
        String n = this.ler.nextLine();
        if(this.loja.existetransportador(n)){
            System.out.println("CARREGUE (1) PARA EXPEDIR ENCOMENDA");
            Transportador t= this.loja.procuratransportador(n);
            for(Encomenda e : t.getencomendas()){
                if(e.devolvivel()==true){
                    int dev=0;
                    System.out.println(e.toString());
                    dev=this.ler.nextInt();
                    if(dev==1){
                        t.devolveencomenda(e);
                    }
                }
                
            }
        }
    }
    
        

        

        
    

            
        //guardo os users
        ArrayList<Utilizador> us = new ArrayList<Utilizador>(this.loja.todosusers());
        FileOutputStream fos1 = new FileOutputStream("users.txt");
        ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
        oos1.writeObject(us);
        oos1.close();
        fos1.close();
        //guarda objetos vendidos, comprados e a vender de todos os users
        for(Utilizador u : this.loja.todosusers()){
            String ficheiroavenda = u.getcodigo()+"avenda.txt";
            String ficheiroavender =u.getcodigo()+"avender.txt";
            String ficheirocomprado =u.getcodigo()+"compr.txt";
            FileOutputStream fos30 = new FileOutputStream(ficheiroavenda);
            FileOutputStream fos31 = new FileOutputStream(ficheiroavender);
            
            ObjectOutputStream oos30 = new ObjectOutputStream(fos30);
            ObjectOutputStream oos31 = new ObjectOutputStream(fos31);
            
            oos30.writeObject(u.getavenda());
            oos30.close();
            fos30.close();
            oos31.writeObject(u.getavender());
            oos31.close();
            fos31.close();
            
            u.setavender(new ArrayList<Artigo>());
            u.setavenda(new ArrayList<Artigo>());
        }
        
        //guarda encomendas
        ArrayList<Encomenda> encs = new ArrayList<Encomenda>();
        for(Transportador t : this.loja.gettransportadores()){
            for(Encomenda e : t.getencomendas()){
                String fich = t.getnome()+e.getnum()+"arts.txt";
                FileOutputStream fos4= new FileOutputStream(fich);
                ObjectOutputStream oos4 = new ObjectOutputStream(fos4);
                oos4.writeObject(e.getartigos());
                oos4.close();
                fos4.close();
                
                e.setartigos(new ArrayList<Artigo>());
                encs.add(e); 
            }
            FileOutputStream fos8 = new FileOutputStream(t.getnome()+"encs.txt");
            ObjectOutputStream oos8 = new ObjectOutputStream(fos8);
            oos8.writeObject(encs);
            oos8.close();
            fos8.close();
            t.setencomendas(new ArrayList<Encomenda>());
        }
        
        
        
        
        //guarda transportadores
    
        FileOutputStream fos6 = new FileOutputStream("transps.txt");
        ObjectOutputStream oos6 = new ObjectOutputStream(fos6);
        oos6.writeObject(this.loja.gettransportadores());
        oos6.close();
        fos6.close();
        
        
        
    
}
}

