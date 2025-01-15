package Exercises;

import DataStructures.HashTables.CBHT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Driver {
    public String fullName;
    public int time;

    Driver(String fullName, int time) {
        this.fullName = fullName;
        this.time = time;
    }
}

public class HashTable_Plates {
    public static void sort(List<Driver> drivers) {
        for (int i = 0; i < drivers.size(); i++) {
            for (int j = 0; j < drivers.size()-1; j++) {
                if (drivers.get(j).time > drivers.get(j+1).time) {
                    Driver temp = drivers.get(j);
                    drivers.set(j,drivers.get(j+1));
                    drivers.set(j+1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CBHT<String, String> table = new CBHT<>(23);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String plate = sc.next();
            String name = sc.next();
            String surname = sc.next();
            String fullName = name + " " + surname;
            if (table.search(plate) == null) {
                table.insert(plate, fullName);
            }
        }
        int speed = sc.nextInt();
        sc.nextLine();
        String info = sc.nextLine();
        String [] details = info.split(" ");
        List<Driver> drivers = new ArrayList<>();
        for (int i = 0; i < details.length - 2; i+=3) {
            String plate = details[i];
            int driverSpeed = Integer.parseInt(details[i+1]);
            String [] times = details[i+2].split(":");
            int time = (Integer.parseInt(times[0]) * 60 * 60) + (Integer.parseInt(times[1]) * 60) + Integer.parseInt(times[2]);
            if (driverSpeed > speed) {
                Driver newDriver = new Driver(table.search(plate).element.value, time);
                drivers.add(newDriver);
            }
        }

        sort(drivers);

        for (int i = 0; i < drivers.size(); i++) {
            System.out.println(drivers.get(i).fullName);
        }
    }
}
