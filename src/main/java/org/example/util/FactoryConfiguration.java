package org.example.util;

import org.example.entity.*;
import org.example.entity.Module;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//
//        configuration.addAnnotatedClass(User.class);
//        configuration.addAnnotatedClass(Passport.class);

//        configuration.addAnnotatedClass(Owner.class);
//        configuration.addAnnotatedClass(Pet.class);

        configuration.addAnnotatedClass(Lecturer.class);
        configuration.addAnnotatedClass(Module.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static synchronized FactoryConfiguration getInstance() {
        if (factoryConfiguration == null) {
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
