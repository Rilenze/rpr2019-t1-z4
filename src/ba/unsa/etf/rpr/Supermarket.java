package ba.unsa.etf.rpr;

public class Supermarket {
    private static Artikl[] artikli = new Artikl[1000];
    private static int broj_artikala=0;

    public static boolean dodajArtikl(Artikl a) {
        if (broj_artikala == 1000) return false;
        artikli[broj_artikala] = a;
        broj_artikala++;
        return true;
    }
    public Artikl[] getArtikli() { return artikli; }
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
