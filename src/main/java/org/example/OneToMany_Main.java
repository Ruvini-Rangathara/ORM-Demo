package org.example;

import org.example.entity.Owner;
import org.example.entity.Pet;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToMany_Main {
    public static void main(String[] args) {

        // Create the Owner objects
        Owner owner1 = new Owner();
        owner1.setId("O001");
        owner1.setName("John");
        owner1.setAge(30);

        Owner owner2 = new Owner();
        owner2.setId("O002");
        owner2.setName("Alice");
        owner2.setAge(25);

// Create the Pet objects
        Pet pet1 = new Pet();
        pet1.setId("P001");
        pet1.setColor("Brown");
        pet1.setAge(2);
        pet1.setOwner(owner1);

        Pet pet2 = new Pet();
        pet2.setId("P002");
        pet2.setColor("White");
        pet2.setAge(4);
        pet2.setOwner(owner1);

        Pet pet3 = new Pet();
        pet3.setId("P003");
        pet3.setColor("Black");
        pet3.setAge(3);
        pet3.setOwner(owner2);

// Add the Pet objects to the Owner's petList
        owner1.getPetList().add(pet1);
        owner1.getPetList().add(pet2);
        owner2.getPetList().add(pet3);

// Save the Owner objects first
        saveOwner(owner1);
        saveOwner(owner2);

// Save the Pet objects
        savePet(pet1);
        savePet(pet2);
        savePet(pet3);


    }

    //----------------------  Owner CRUD  -----------------------------
    public static boolean saveOwner(Owner owner) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(owner);
            transaction.commit();
            System.out.println("Owner saved");
            return true;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }
    public static boolean updateOwner(Owner owner) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(owner);
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

    public static boolean deleteOwner(Owner owner) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(owner);
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

    public static Owner searchOwner(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Owner owner = session.get(Owner.class, id);
            transaction.commit();
            return owner;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return null;
        }finally {
            session.close();
        }
    }

    //------------------------  Pet CRUD  ---------------------------

    public static boolean savePet(Pet pet) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(pet);
            transaction.commit();
            System.out.println("Pet saved");
            return true;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }
    public static boolean updatePet(Pet pet) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(pet);
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

    public static boolean deletePet(Pet pet) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(pet);
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

    public static Pet searchPet(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Pet pet = session.get(Pet.class, id);
            transaction.commit();
            return pet;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return null;
        }finally {
            session.close();
        }
    }


}
