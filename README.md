# Data access object(DAO)

In computer software, a data access object (DAO) is an object that provides an abstract interface to some type of database or other persistence mechanism. By mapping application calls to the persistence layer, DAO provide some specific data operations without exposing details of the database. This isolation supports the Single responsibility principle. It separates what data accesses the application needs, in terms of domain-specific objects and data types (the public interface of the DAO), from how these needs can be satisfied with a specific DBMS, database schema, etc. (the implementation of the DAO).

#### Advantages

The advantage of using data access objects is the relatively simple and rigorous separation between two important parts of an application that can but should not know anything of each other, and which can be expected to evolve frequently and independently. Changing business logic can rely on the same DAO interface, while changes to persistence logic do not affect DAO clients as long as the interface remains correctly implemented. All details of storage are hidden from the rest of the application (see Information hiding). Thus, possible changes to the persistence mechanism can be implemented by just modifying one DAO implementation while the rest of the application isn't affected. DAOs act as an intermediary between the application and the database. They move data back and forth between objects and database records. Unit testing the code is facilitated by substituting the DAO with a test double in the test, thereby making the tests non-dependent on the persistence layer.

In the non specific context of the Java programming language, Data Access Objects as a design concept can be implemented in a number of ways. This can range from a fairly simple interface that separates the data access parts from the application logic, to frameworks and commercial products. DAO coding paradigms can require some skill. Technologies like Java Persistence API and Enterprise JavaBeans come built into application servers and can be used in applications that use a JavaEE application server. Commercial products like TopLink are available based on Object-relational mapping (ORM). Popular open source ORM products include Doctrine, Hibernate, iBATIS and JPA implementations such as Apache OpenJPA.

#### Disadvantages
Potential disadvantages of using DAO include leaky abstraction,[citation needed] code duplication,[2] and abstraction inversion. In particular, the abstraction of the DAO as a regular Java object can hide the high cost of each database access, and can also force developers to trigger multiple database queries to retrieve information that could otherwise be returned in a single operation with normal SQL set operations. Time consumption is moderate.


## Active Record implementation in Ruby - https://github.com/sun1x/active-record


