import java.util.*;

public class Magazin implements MagazinInterface{
    String nume;
    Scanner scanner = new Scanner(System.in);
    private static Magazin SINGLETON;

    private List<Produse> listaProduse = new ArrayList<Produse>();
    private List<Client> clientiInMagazin = new ArrayList<Client>();

    private Magazin(){
    }

    public static final Magazin getInstance(){
        if(SINGLETON == null){
            SINGLETON = new Magazin();
        }

        return SINGLETON;
    }

    public void afiseazaBlugi(){
        for(Produse p : listaProduse){
            if(p instanceof Blugi){
                Blugi d = (Blugi) p;
                System.out.println(d.getPret() + " " + d.getCuloare() + " " + d.areBuzunare());
            }
        }
    }


    public void vizualizareSuma(String nume){
        int count = 0;
        ArrayList<Double> suma = new ArrayList<Double>();
        for(Client c : clientiInMagazin) {
            if (nume.equals(c.getNume())) {
                double sum = 0;
                for (Produse p : c.getListaClient()) {
                    if(p.getTip().equals("tricou") && c.areCardReducere()){
                        double tricouRedus = p.getPret() - p.getPret() * 0.15;
                        sum += tricouRedus;
                    } else {
                        sum =+ p.getPret();
                    }
                    suma.add(sum);
                }
                count++;
                System.out.println(suma);
            }
        }
        if(count == 0){
            System.out.println("Clientul " + nume + " nu a fost gasit!");
        }
    }

    @Override
    public void adaugaClient(Client client){
        System.out.println("Numele clientului:");
        client.setNume(scanner.nextLine());

        System.out.println("Prenumele clientului:");
        client.setPrenume(scanner.nextLine());

        System.out.println("Are card de reducere? (true/false)");
        client.setCardReducere(Boolean.parseBoolean(scanner.nextLine()));

        clientiInMagazin.add(client);
        System.out.println("Clientul a fost adaugat!");
        if(clientiInMagazin.size() > 100){
            System.out.println("Magazinul este plin!");
        }
    }

    @Override
    public void afiseazaClient(){
        for(Client c : clientiInMagazin){
            System.out.println(c.getNume() + " " + c.getPrenume() + " " + c.areCardReducere());
            // acelasi lucru cu suprascrierea lui toString din clasa Client
        }
    }

    @Override
    public void adaugaProduse(Produse produs){
        System.out.println("De ce tip este produsul?  blugi/rochie/tricou");
        String tip = produs.setTip(scanner.nextLine());

        if(tip.equals("blugi")){
            Blugi blugi = new Blugi();
            blugi.setTip(tip);
            System.out.println("Blugii au buzunare? true/false");
            blugi.setBuzunare(Boolean.parseBoolean(scanner.nextLine()));

            System.out.println("Ce pret au blugii?");
            blugi.setPret(Double.parseDouble(scanner.nextLine()));

            System.out.println("Ce culoare au blugii?");
            blugi.setCuloare(scanner.nextLine());

            listaProduse.add(blugi);

        } else if(tip.equals("rochie")){
            Rochii rochie = new Rochii();
            rochie.setTip(tip);

            System.out.println("Ce pret are rochia?");
            rochie.setPret(Double.parseDouble(scanner.nextLine()));

            System.out.println("Ce culoare are rochia?");
            rochie.setCuloare(scanner.nextLine());
            listaProduse.add(rochie);

        } else if (tip.equals("tricou")) {
            Tricouri tricou = new Tricouri();
            tricou.setTip(tip);

            System.out.println("Ce pret are tricoul?");
            tricou.setPret(Double.parseDouble(scanner.nextLine()));

            System.out.println("Ce culoare are tricoul?");
            tricou.setCuloare(scanner.nextLine());
            listaProduse.add(tricou);
        }
        System.out.println("Produsul a fost adaugat!");
    }

    @Override
    public void afiseazaProduse(){
        System.out.println("Lista cu produsele din magazin: ");
        for(Produse p : listaProduse){
            System.out.println(p);
        }
    }

    @Override
    public void adaugaProdusPentruClient(String nume, Produse produs){

        System.out.println("Care este tipul produsului pe care vrei sa-l adaugi?");
        produs.setTip(scanner.nextLine());
        System.out.println("Care este pretul produsul pe care vrei sa-l adaugi?");
        produs.setPret(Double.parseDouble(scanner.nextLine()));
        System.out.println("Care este culoare produsului pe care vrei sa-l adaugi?");
        produs.setCuloare(scanner.nextLine());

        int count = 0;
        for(Client c : clientiInMagazin) {
            if (nume.equals(c.getNume())) {
                c.getListaClient().add(produs);
                System.out.println("Produsul a fost adaugat clientului " + c.getNume());
                count++;
            }
        }
        if(count == 0){
            System.out.println("Clientul " + nume + " nu a fost gasit!");
        }
    }

}