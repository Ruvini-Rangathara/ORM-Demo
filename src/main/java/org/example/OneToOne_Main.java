package org.example;

import org.example.entity.Passport;
import org.example.entity.User;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToOne_Main {
    public static void main(String[] args) {

        User user1 = new User();
        user1.setId("U001");
        user1.setName("Nimal");
        user1.setAge(23);

        User user2 = new User();
        user2.setId("U002");
        user2.setName("Kamal");
        user2.setAge(25);

        Passport passport1 = new Passport();
        passport1.setId("P001");
        passport1.setPassNo(1234);
        passport1.setIssueDate(java.sql.Date.valueOf("2023-07-09"));

        Passport passport2 = new Passport();
        passport2.setId("P002");
        passport2.setPassNo(3456);
        passport2.setIssueDate(java.sql.Date.valueOf("2023-07-10"));

        passport1.setUser(user1);
        passport2.setUser(user2);

        saveUser(user1);
        saveUser(user2);

        savePassport(passport1);
        savePassport(passport2);

    }

    public static boolean saveUser(User user) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(user);
            transaction.commit();
            System.out.println("User saved");
            return true;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }
    public static boolean updateUser(User user) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(user);
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

    public static boolean deleteUser(User user) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(user);
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

    public static User searchUser(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            User user = session.get(User.class, id);
            transaction.commit();
            return user;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return null;
        }finally {
            session.close();
        }
    }

    //------------------------  Passport CRUD  ---------------------------

    public static boolean savePassport(Passport passport) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(passport);
            transaction.commit();
            System.out.println("Passport saved");
            return true;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }
    public static boolean updatePassport(Passport passport) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(passport);
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

    public static boolean deletePassport(Passport passport) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(passport);
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

    public static Passport searchPassport(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Passport passport = session.get(Passport.class, id);
            transaction.commit();
            return passport;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return null;
        }finally {
            session.close();
        }
    }


}
