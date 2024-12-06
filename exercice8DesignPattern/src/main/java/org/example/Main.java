package org.example;

public class Main {
    public static void main(String[] args) {
        Employee ceo = new Manager("John Doe", "CEO");

        Employee manager1 = new Manager("Jane Smith", "Manager");
        Employee manager2 = new Manager("Bob Johnson", "Manager");

        Employee dev1 = new IndividualEmployee("Alice Brown", "Developer");
        Employee dev2 = new IndividualEmployee("Charlie Green", "Developer");

        Employee hr1 = new IndividualEmployee("Eve White", "HR");

        ((Manager) manager1).addSubordinate(dev1);
        ((Manager) manager1).addSubordinate(dev2);

        ((Manager) manager2).addSubordinate(hr1);

        ((Manager) ceo).addSubordinate(manager1);
        ((Manager) ceo).addSubordinate(manager2);

        ceo.showDetails();
    }
}
