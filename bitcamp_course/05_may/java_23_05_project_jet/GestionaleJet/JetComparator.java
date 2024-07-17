package java_23_05.GestionaleJet;

import java.util.Comparator;

public class JetComparator implements Comparator<Jet> {
    public int compare(Jet p1, Jet p2) {
    return Double.compare(p1.getPrezzo(), p2.getPrezzo());
}
}
