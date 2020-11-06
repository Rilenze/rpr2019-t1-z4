package ba.unsa.etf.rpr;

public class Korpa {
    private Artikl[] artikli = new Artikl[50];
    private int broj_artikala=0;
    public Artikl[] getArtikli() { return artikli; }
    public boolean dodajArtikl(Artikl a) {
        if (broj_artikala == 50) return false;
        artikli[broj_artikala] = a;
        return true;
    }
    public int dajUkupnuCijenuArtikala() {
        int suma=0;
        for (int i=0; i<broj_artikala; i++) {
            suma += artikli[i].getCijena();
        }
        return suma;
    }
    public Artikl izbaciArtiklSaKodom(String kod) {
        boolean postoji = false;
        int indeksIzbacenog = 0;
        for (int i=0; i<broj_artikala; i++) {
            if (artikli[i].getKod().equals(kod)) {
                postoji = true;
                indeksIzbacenog = i;
                break;
            }
        }
        if (!postoji) return null;
        Artikl kopija = artikli[indeksIzbacenog];
        for (int i = indeksIzbacenog; i < broj_artikala - 1; i++) {
            artikli[i] = artikli[i+1];
        }
        broj_artikala--;
        return kopija;
    }
}
