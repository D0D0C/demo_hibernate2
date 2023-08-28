package org.example.exercice1;

import org.example.entities.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {

        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();


        Session session = sessionFactory.openSession();

//********************** Ajouter 5 produits *************************************

        session.getTransaction().begin();
        Product product1 = new Product();
        product1.setMarque("test1");
        product1.setReference("tst1");
        product1.setDate(LocalDate.ofEpochDay(12-12-2012));
        product1.setPrice(12.50);
        product1.setStock(10);

        session.getTransaction().begin();
        Product product2 = new Product();
        product2.setMarque("test2");
        product2.setReference("tst2");
        product2.setDate(LocalDate.ofEpochDay(15-03-2010));
        product2.setPrice(80.23);
        product2.setStock(5);

        session.getTransaction().begin();
        Product product3 = new Product();
        product3.setMarque("test3");
        product3.setReference("tst3");
        product3.setDate(LocalDate.ofEpochDay(05-05-2005));
        product3.setPrice(21.45);
        product3.setStock(100);

        session.getTransaction().begin();
        Product product4 = new Product();
        product4.setMarque("test4");
        product4.setReference("tst4");
        product4.setDate(LocalDate.ofEpochDay(6-6-2006));
        product4.setPrice(18.18);
        product4.setStock(50);

        session.getTransaction().begin();
        Product product5 = new Product();
        product5.setMarque("test5");
        product5.setReference("tst5");
        product5.setDate(LocalDate.ofEpochDay(8-8-2008));
        product5.setPrice(45.45);
        product5.setStock(78);

        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.save(product4);
        session.save(product5);
        session.getTransaction().commit();

//********************** afficher information produit id  *************************************
        session.getTransaction().begin();
        Product p = session.load(Product.class,2L);
        System.out.println(p.getId());

//********************** supprimer  produit id  *************************************
        session.delete(3);
        session.getTransaction().commit();

//********************** modifier  produit id 1 *************************************

        p.setMarque("test1bis");
        session.update(product1);
        System.out.println(product1.getId());

        session.close();
        sessionFactory.close();

    }


}
