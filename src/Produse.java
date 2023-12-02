public class Produse{
    private double pret;
    private String culoare;

    private String tip;

    public String getTip() {
        return tip;
    }

    public String setTip(String tip) {
        this.tip = tip;
        return tip;
    }

    public double getPret(){return this.pret;}

    public void setPret(double pret){this.pret = pret;}

    public String getCuloare(){return this.culoare;}

    public void setCuloare(String culoare){this.culoare = culoare;}

    public String toString(){
        return this.tip + " " + this.pret + " " + this.culoare;
    }
}