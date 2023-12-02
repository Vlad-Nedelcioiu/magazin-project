import java.util.*;

public class Client{
    private String nume;
    private String prenume;
    private boolean cardReducere;
    private List<Produse> listaClient = new ArrayList<Produse>();

    public List<Produse> getListaClient() {
        return listaClient;
    }

    public void setListaClient(List<Produse> listaClient) {
        this.listaClient = listaClient;
    }

    public String getNume(){return this.nume;}

    public void setNume(String nume){this.nume = nume;}

    public String getPrenume(){return this.prenume;}

    public void setPrenume(String prenume){this.prenume = prenume;}

    public boolean areCardReducere(){return this.cardReducere;}

    public void setCardReducere(boolean cardReducere){this.cardReducere = cardReducere;}

    @Override
    public String toString(){
        return (this.nume + " " + this.prenume + " " + this.cardReducere);
    }
}