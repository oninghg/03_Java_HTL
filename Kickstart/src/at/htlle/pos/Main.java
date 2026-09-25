package at.htlle.pos;

import at.htlle.pos.comparator.Student;
import at.htlle.pos.comparator.StudentIdComparator;
import at.htlle.pos.comparator.StudentNameComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        String aStr = "FIRST";
        String bStr = "SECOND";

        System.out.println(aStr + bStr);

        //using a StringBuilder for MANY String concat operations

        StringBuilder sb = new StringBuilder();
        sb.append(aStr).append(',').append(bStr);

        System.out.println(sb);

        System.out.println("----");
        Student myStudent = new Student("Fabse", 676767, "3AHWIN");
        System.out.println(myStudent.toString());
    //    System.out.println(myStudent.name);
    //    System.out.println(id);
    //    System.out.println(classroom);

        System.out.println("Create List");
        List<Student> myStudentList = new ArrayList<>();

        myStudentList.add(new Student("Schleef", 1, "3IT"));
        myStudentList.add(new Student("OninGHG", 2, "2IT"));
        myStudentList.add(new Student("Massong", 3, "3IT"));

        System.out.println(myStudentList);

        // -- first compare attempt
        System.out.println("---");

        Student student1 = new Student("Wetzi", 6, "3IT");
        Student student2 = new Student("Matthi", 7, "3IT");
        Student student3 = new Student("Nino", 2, "3IT");

        System.out.println(student1.equals(student2)); //false
        System.out.println(student1.equals(student1)); //true
        System.out.println(student1 == student2); //false
        System.out.println(student1 == student1); //true

        System.out.println("---");
        StudentIdComparator studentIdComparator = new StudentIdComparator();
        System.out.println(studentIdComparator.compare(student1,student2)); //0
        System.out.println("-- name compare");
        StudentNameComparator studentnameComparator = new StudentNameComparator();
        System.out.println(studentnameComparator.compare(student1,student2));
        System.out.println(studentnameComparator.compare(student1,student1));
        System.out.println(studentnameComparator.compare(student2,student3));

        System.out.println("Fabse".compareTo("Nowak"));

        Comparator<Student> studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getClassroom().compareTo(o2.getClassroom());
            }
        };

        Collections.shuffle(myList); //make it unsorted againg
        System.out.println("myList unsortet: " + myList);
        System.out.println("myStudentList unsortet: " + myStudentList);
        Collections.sort(myList);
        Collections.sort(myStudentList, studentComparator);
        System.out.println(myStudentList);

        Comparator<Student> myStudentClassroomThenNameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.getClassroom().compareTo(s2.getClassroom())==0){
                    return s1.getName().compareTo(s2.getName());
                }
                return s1.getClassroom().compareTo(s2.getClassroom());
            }
        };

        Collections.sort(myStudentList, myStudentClassroomThenNameComparator);
        System.out.println(myStudentList);

        Collections.shuffle(myStudentList);
        System.out.println("myStudentList shuffeled: " + myStudentList);
        Collections.sort(myStudentList, studentComparator.thenComparing(new StudentNameComparator()));
        System.out.println("myStudentList sortet: " + myStudentList);
    }
}
