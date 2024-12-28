package LaboratoryExercises.Lab6;

import DataStructures.HashTables.CBHT;

import java.util.Objects;
import java.util.Scanner;

class Proekt {
    Integer vreme;
    Integer plataCas;

    public Proekt(Integer vreme, Integer plataCas) {
        this.vreme = vreme;
        this.plataCas = plataCas;
    }

    Integer vkupnaPlata() {
        return plataCas * vreme;
    }

    @Override
    public String toString() {
        return "<" + plataCas + ", " + vreme + ">";
    }
}

class Vraboten implements Comparable<Vraboten> {
    String ime;
    Integer vozrast;

    public Vraboten(String ime, Integer vozrast) {
        this.ime = ime;
        this.vozrast = vozrast;
    }

    @Override
    public String toString() {
        return "<" + ime + ", " + vozrast + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vraboten vraboten = (Vraboten) o;
        return Objects.equals(ime, vraboten.ime) && Objects.equals(vozrast, vraboten.vozrast);
    }

    @Override
    public int hashCode() {
        return vozrast * ime.charAt(0);
    }

    @Override
    public int compareTo(Vraboten o) {
        return 0;
    }
}


public class Exercise1_HashTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CBHT<Vraboten, Proekt> table = new CBHT<Vraboten, Proekt>(10);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String ime;
            Integer vozrast;
            Integer plataCas;
            Integer vreme;
            ime = scanner.next();
            vozrast = scanner.nextInt();
            plataCas = scanner.nextInt();
            vreme = scanner.nextInt();
            Vraboten v = new Vraboten(ime, vozrast);
            Proekt p = new Proekt(vreme, plataCas);
            if (table.search(v) == null){
                table.insert(v,p);
            } else if (table.search(v).element.value.vkupnaPlata() < p.vkupnaPlata()){
                table.insert(v,p);
            }
        }
        System.out.println(table.toString());
    }
}
