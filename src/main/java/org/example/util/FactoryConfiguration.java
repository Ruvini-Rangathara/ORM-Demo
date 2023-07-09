package org.example.util;

import org.example.entity.Owner;
import org.example.entity.Passport;
import org.example.entity.Pet;
import org.example.entity.User;
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

        configuration.addAnnotatedClass(Owner.class);
        configuration.addAnnotatedClass(Pet.class);

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
