package org.example;

import org.example.entity.Lecturer;
import org.example.entity.Module;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManyToMany_Main {
    public static void main(String[] args) {

        Lecturer lec1 = new Lecturer();
        lec1.setId("L001");
        lec1.setName("Amal");

        Lecturer lec2 = new Lecturer();
        lec2.setId("L002");
        lec2.setName("Kamal");

        Module module1 = new Module();
        module1.setId("M001");
        module1.setSubject("PRF");

        Module module2 = new Module();
        module2.setId("M002");
        module2.setSubject("DBM");

        Module module3 = new Module();
        module3.setId("M003");
        module3.setSubject("ORM");

        lec1.getModuleList().add(module1);
        lec1.getModuleList().add(module2);

        lec2.getModuleList().add(module2);
        lec2.getModuleList().add(module3);

        module1.getLecturerList().add(lec1);
        module2.getLecturerList().add(lec1);

        module2.getLecturerList().add(lec2);
        module3.getLecturerList().add(lec2);

        saveLecturer(lec1);
        saveLecturer(lec2);

        saveModule(module1);
        saveModule(module2);
        saveModule(module3);

    }

    //------------------------  Lecturer CRUD  ---------------------------
    public static boolean saveLecturer(Lecturer lecturer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(lecturer);
            transaction.commit();
            System.out.println("Lecturer saved");
            return true;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }
    public static boolean updateLecturer(Lecturer lecturer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(lecturer);
            transaction.commit();
            return true;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public static boolean deleteLecturer(Lecturer lecturer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(lecturer);
            transaction.commit();
            return true;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public static Lecturer searchLecturer(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Lecturer lecturer = session.get(Lecturer.class, id);
            transaction.commit();
            return lecturer;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return null;
        }finally {
            session.close();
        }
    }

    //------------------------  Module CRUD  ---------------------------

    public static boolean saveModule(Module module) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(module);
            transaction.commit();
            System.out.println("Module saved");
            return true;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }
    public static boolean updateModule(Module module) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(module);
            transaction.commit();
            return true;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public static boolean deleteModule(Module module) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(module);
            transaction.commit();
            return true;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public static Module searchModule(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Module module = session.get(Module.class, id);
            transaction.commit();
            return module;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return null;
        }finally {
            session.close();
        }
    }
}
