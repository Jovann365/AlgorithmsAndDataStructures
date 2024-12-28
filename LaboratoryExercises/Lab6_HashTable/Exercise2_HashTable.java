package LaboratoryExercises.Lab6_HashTable;

import DataStructures.HashTables.CBHT;

import java.util.Scanner;

class Person {
    String name;
    String salary;
    String network;
    String time;
    String city;
    String price;

    public Person( String name, String salary, String network, String time,String city, String price) {
        this.city = city;
        this.name = name;
        this.salary = salary;
        this.network = network;
        this.time = time;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " with salary " + salary + " from address " + network + " who logged in at " + time;
    }

    String print() {
        return name + " with salary " + salary + " from address " + network + " who logged in at " + time;
    }

}

public class Exercise2_HashTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String [] entries = new String[n];
        CBHT<String, Integer> counters = new CBHT<>(n);
        CBHT<String, Person> earliest = new CBHT<>(n);
        for (int i = 0; i < n; i ++){
            String entry = sc.nextLine();
            entries[i] = entry;
            String [] entrySplit = entry.split("\\s+");
            String [] networkSplit =  entrySplit[3].split("\\.");
            Person p = new Person(entrySplit[0] + " " + entrySplit[1], entrySplit[2], entrySplit[3], entrySplit[4], entrySplit[5], entrySplit[6]);
            String network = networkSplit[0] + "." + networkSplit[1] + "." + networkSplit[2];
            String [] time = entrySplit[4].split(":");
            Integer hour = Integer.parseInt(time[0]);
            Integer minutes = Integer.parseInt(time[1]);
            if (hour >= 12) {
                if (counters.search(network) == null) {
                    counters.insert(network, 1);
                } else {
                    counters.search(network).element.value++;
                }
                if (earliest.search(network) == null) {
                    earliest.insert(network, p);
                } else {
                    String currTime = earliest.search(network).element.value.time;
                    String[] currSplitTime = currTime.split(":");
                    Integer currHour = Integer.parseInt(currSplitTime[0]);
                    Integer currMinutes = Integer.parseInt(currSplitTime[1]);
                    if ((currHour * 60 + currMinutes) > (hour*60 + minutes)) {
                        earliest.insert(network, p);
                    }
                }
            }
        }
        sc.nextLine();
        int m = sc.nextInt();
        sc.nextLine();
        for (int i =0; i < m; i++){
            String entry = sc.nextLine();
            String [] entrySplit = entry.split("\\s+");
            String fullNetwork = entrySplit[3];
            String [] networkSplit = fullNetwork.split("\\.");
            String network = networkSplit[0] + "." + networkSplit[1] + "." + networkSplit[2];
            System.out.print("IP network: "+network+" has the following number of users:");
            System.out.println();
            System.out.println(counters.search(network).element.value);
            System.out.println("The user who logged on earliest after noon from that network is:");
            System.out.print(earliest.search(network).element.value.print());
            System.out.println();
            System.out.println();
        }
    }
}
