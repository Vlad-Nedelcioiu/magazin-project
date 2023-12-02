public class Blugi extends Produse{
    private boolean buzunare;

    public boolean areBuzunare(){return this.buzunare;}

    public void setBuzunare(boolean buzunare){this.buzunare = buzunare;}

    public String toString(){
        return super.getTip() + " " + super.getPret() + " " + super.getCuloare() + " " + this.buzunare;
    }
}