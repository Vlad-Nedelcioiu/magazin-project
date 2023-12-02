import java.util.*;

public class Main{
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        Magazin magazin = Magazin.getInstance();

        while(true){
            switch(scanner.nextLine()){
                case "adauga client":
                    Client client = new Client();
                    magazin.adaugaClient(client);
                    break;
                case "afiseaza client":
                    magazin.afiseazaClient();
                    break;
                case "adauga produs":
                    Produse produs = new Produse();
                    magazin.adaugaProduse(produs);
                    break;
                case "afiseaza produse":
                    magazin.afiseazaProduse();
                    break;
                case "adauga produs pentru client":
                    produs = new Produse();
                    System.out.println("Carui client vrei sa-i adaugi un produs?");
                    magazin.adaugaProdusPentruClient(scanner.nextLine(), produs);
                    break;
                case "vizualizare suma":
                    System.out.println("Carui client vrei sa-i vizualizezi suma?");
                    magazin.vizualizareSuma(scanner.nextLine());
                    break;
                case "afiseaza blugi":
                    magazin.afiseazaBlugi();
                    break;
                case "exit":
                    System.out.println("La revedere!");
                    System.exit(0);
                default:
                    System.exit(1);
            }
        }
    }
}