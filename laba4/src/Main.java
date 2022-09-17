import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//класс человека, в который записываются данные из файла
class Car {
    int ID;
    String name;
    double mpg;
    double cyl;
    double disp;
    double hp;
    double drat;
    double wt;
    double qsec;
    double vs;
    double am;
    double gear;
    double carb;

    Car(int ID,
        String name,
        double mpg,
        double cyl,
        double disp,
        double hp,
        double drat,
        double wt,
        double qsec,
        double vs,
        double am,
        double gear,
        double carb) {

        this.ID = ID;
        this.name = name;
        this.mpg = mpg;
        this.cyl = cyl;
        this.disp = disp;
        this.hp = hp;
        this.drat = drat;
        this.wt = wt;
        this.qsec = qsec;
        this.vs = vs;
        this.am = am;
        this.gear = gear;
        this.carb = carb;
    }

    //метод, который возвращает данные класса человек в виде строки для печати
    public String toString() {
        return String.valueOf(ID) + " | " + name + " | " + mpg + " | " + cyl + " | " + disp + " | " + hp + " | " + drat + " | " + wt + " | " + qsec + " | " + vs + " | " + am + " | " + gear + " | " + carb;
    }
}

//класс Departament в классе  Car - это композиция. Класс департамент, который хранит информацию о департаменте из файла
class Department {
    int ID;
    String name;

    Department(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    //метод, который возвращает данные класса департамент(id и название) в виде строки для печати
    public String toString() {
        return String.valueOf(ID) + " | " + name;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\danya\\IdeaProjects\\laba4\\src\\cars.csv";
        CSVReader reader = new CSVReader(new FileReader(path));
        if (reader == null) {
            throw new FileNotFoundException(path);
        }
        List<Car> cars = new ArrayList<>();

        String[] nextLine = reader.readNext();
        int i = 0;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                if (nextLine.length == 12) {
                    cars.add(new Car(i++, nextLine[0],
                            Double.parseDouble(nextLine[1]),
                            Double.parseDouble(nextLine[2]),
                            Double.parseDouble(nextLine[3]),
                            Double.parseDouble(nextLine[4]),
                            Double.parseDouble(nextLine[5]),
                            Double.parseDouble(nextLine[6]),
                            Double.parseDouble(nextLine[7]),
                            Double.parseDouble(nextLine[8]),
                            Double.parseDouble(nextLine[9]),
                            Double.parseDouble(nextLine[10]),
                            Double.parseDouble(nextLine[11])));
                } else {
                    System.out.print("Incorrect string ");
                    System.out.println(nextLine.length);
                }
            }
        }
        sort(cars);
        print(cars);
    }

    private static void print(List<Car> list) {
        for (Car i : list) {
            System.out.println(i.toString());
        }
    }

    private static void sort(List<Car> list) {
        list.sort((o1, o2) -> (int) (o1.mpg > o2.mpg ? 1 : -1));
    }
}
