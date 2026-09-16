package at.htlle.pos;

import at.htlle.pos.comparator.Student;

import java.util.ArrayList;
import java.util.List;

class Main {

    void main() {
        //SHIFT+ALT - move lines up and down with cursor
        //CTRL+Y - delete line
        //CTRL + D - duplicate line
        //CTRL+SHIFT+7 (i.e. CTRL+/) - comment line

        List<Integer> myList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }

        for (Integer i : myList) {  //auto-unboxing
            System.out.println(i);  //sout
        }

        for (int i = 0; i < myList.size(); i++) {
            int temp = myList.get(i);
            myList.set(i, temp + 120);
        }

        System.out.println("List content after item change");
        for (int i : myList) {
            System.out.print(i + ","); //sout
        }

    //    Student myStudent = new Student();
    //    System.out.println(myStudent.name);
    //    System.out.println(id);
    //    System.out.println(classroom);

    }
}
