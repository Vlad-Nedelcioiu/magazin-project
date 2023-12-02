public interface MagazinInterface{
    void adaugaClient(Client client);

    void afiseazaClient();

    void adaugaProduse(Produse produs);

    void afiseazaProduse();

    void adaugaProdusPentruClient(String nume, Produse produs);

}