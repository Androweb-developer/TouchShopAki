package com.tag.touchapp_10;


import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

class Form implements Serializable {
    int formNo;
    String name;
    int touch;

    Form(int formNo, String name, int touch) {
        this.formNo = formNo;
        this.name = name;
        this.touch = touch;
    }

}
public class FileUtil {
    int choice = -1;

    File file = new File(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+"test.txt"));
    ArrayList<Form> al = new ArrayList<Form>();
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    ListIterator li = null;

    public void wakingUpFile() throws Exception{
        if(file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Form>) ois.readObject();
            ois.close();
            System.out.println("The File Is Ready");
        }
    }

    public void insertFormDetails(int formNumber , String name , int touch) throws Exception{

        al.add(new Form(formNumber, name, touch));


        // storing the array in the file
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(al);
        oos.close();
    }


    //To Read the Form Details
    @SuppressWarnings("unchecked")
    public void showAllForms() throws Exception{
        if (file.isFile()) {
            // Loading previous data from text file to the ArrayList
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Form>) ois.readObject();
            ois.close();

            System.out.println("-----------------------------");
            li = al.listIterator();
            while (li.hasNext())
                System.out.println(li.next());
            System.out.println("-----------------------------");
        } else {
            System.out.println("File not Exist please insert data first");
        }
    }


    //To search Form Number
    @SuppressWarnings("unchecked")
    public void SearchFormNumber(int formNum) throws Exception{
        if (file.isFile()) {
            // Loading previous data from text file to the ArrayList
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Form>) ois.readObject();
            ois.close();

            boolean found = false;
            System.out.println("Enter Form Number to Search");

            System.out.println("-----------------------------");
            li = al.listIterator();
            while (li.hasNext()) {
                Form data = (Form) li.next();
                if (data.formNo == formNum) {
                    System.out.println(data);
                    found = true;
                    System.out.println("-----------------------------");
                }
            }

            if (!found) {
                System.out.println("Record not Found");
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("File not Exist please insert data first");
        }
    }

    //To search Form By Name
    @SuppressWarnings("unchecked")
    public void SearchFormNumberByName(String nameSearch) throws Exception{
        if (file.isFile()) {
            // Loading previous data from text file to the ArrayList
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Form>) ois.readObject();
            ois.close();

            boolean found = false;
            System.out.println("Enter Name to Search");

            System.out.println("-----------------------------");
            li = al.listIterator();
            while (li.hasNext()) {
                Form data = (Form) li.next();

                if (nameSearch.equals(data.name)) {
                    System.out.println(data);
                    found = true;
                    System.out.println("-----------------------------");
                }
            }

            if (!found) {
                System.out.println("Record not Found");
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("File not Exist please insert data first");
        }
    }


    //To Update Form
    @SuppressWarnings("unchecked")
    public void updateForm(int formNum , String newName, int newTouchValue) throws Exception{
        if (file.isFile()) {
            // Loading previous data from text file to the ArrayList
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Form>) ois.readObject();
            ois.close();

            boolean found = false;

            li = al.listIterator();
            while (li.hasNext()) {
                Form data = (Form) li.next();
                if (data.formNo == formNum) {

                    li.set(new Form(formNum, newName, newTouchValue));
                    found = true;

                    System.out.println("-----------------------------");
                }
            }

            if (found) {
                // storing current the array in the file
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(al);
                oos.close();

                System.out.println("-----------------------------");
                System.out.println("Updated Successfully...!");
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("File not Exist please insert data first");
        }
    }

    //To Delete Form
    @SuppressWarnings("unchecked")
    public void deleteForm(int formNum) throws Exception{
        if (file.isFile()) {
            // Loading previous data from text file to the ArrayList
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Form>) ois.readObject();
            ois.close();

            boolean found = false;
            System.out.println("Enter Form Number to Delete");


            System.out.println("-----------------------------");
            li = al.listIterator();
            while (li.hasNext()) {
                Form data = (Form) li.next();
                if (data.formNo == formNum) {
                    li.remove();
                    found = true;
                    System.out.println("-----------------------------");
                }
            }

            if (found) {
                // storing current the array in the file
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(al);
                oos.close();

                System.out.println("-----------------------------");
                System.out.println("Deleted Successfully...!");
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("File not Exist please insert data first");
        }
    }
}
