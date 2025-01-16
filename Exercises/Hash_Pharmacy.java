package Exercises;

/*
Во магацинот на една фармацевтска компанија се чуваат најразлични видови лекови.
За секој лек потребно е да се чуваат податоци за името на лекот, цената во денари и намената на лекот.
За поефикасен пристап до податоците за лековите, фармацевтската компанија одлучила
податоците да ги чува во хеш табела (CBHT) каде се сместуваат соодветните податоци.
Хеш табелата е достапна до крајните клиенти и истите може да пребаруваат низ внесените податоци.
Бидејќи на пазарот постојат повеќе лекови кои таргетираат иста болест,
најчесто клиентите го бараат оној лек кој има најниска цена.
Па вашата задача е со користење на хеш табелата, за дадена намена (болест),
да го испечатите лекот кој има најниска цена на пазарот.
Доколку за бараната намена во магацинот нема лек се печати "Nema lek za baranata namena vo magacin.".

Влез:
Најпрво е даден бројот на лекови - N, а потоа секој лек е даден во нов ред во форматот:
“Име на лек” “Намена” “Цена во денари”
На крај е дадена намената за која треба да се пронајде лекот со најниска цена.

Излез:
Името на лекот со најмала цена.

Input:
6
Analgin Glavobolka 80
Daleron Glavobolka 90
Lineks Bolki_vo_stomak 120
Spazmeks Bolki_vo_stomak 150
Loratadin Alergija 150
Lorazepam Alergija 75
Bolki_vo_stomak

Result:
Analgin
*/

import DataStructures.HashTables.CBHT;

import java.util.Objects;
import java.util.Scanner;

class Medicine {
    String name;
    int price;

    public Medicine(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return price == medicine.price && Objects.equals(name, medicine.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

public class Hash_Pharmacy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CBHT<String, Medicine> table = new CBHT<>(11);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String medicine = sc.next();
            String sickness = sc.next();
            int price = sc.nextInt();
            Medicine newMedicine = new Medicine(medicine, price);
            if (table.search(sickness) == null) {
                table.insert(sickness, newMedicine);
            }
            else {
                if (price < table.search(sickness).element.value.price) {
                    table.insert(sickness, newMedicine);
                }
            }
        }
        String symptom = sc.next();
        System.out.println(table.search(symptom).element.value.name);
    }
}
