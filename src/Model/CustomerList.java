package Model;

import java.util.ArrayList;
import java.util.Objects;

public class CustomerList {
    private ArrayList<Customer> customers;
    private int idCounter;

    public CustomerList() {
        customers = new ArrayList<Customer>();
        idCounter = 0;
    }

    public Customer getCustomer(int id) throws CustomNotFoundException {
        for (Customer customer :
                customers) {
            if (customer.getId() == id)
                return customer;
        }
        throw new CustomNotFoundException();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        boolean exists = false;
        for (Customer customer1 :
                customers) {
            if (customer.equals(customer1))
                exists = true;
        }
        if (!exists)
            customers.add(customer);
    }

    public void deleteCustomer(Customer customer) throws CustomNotFoundException {
        boolean removed = false;
        for (Customer customer1 :
                customers) {
            if (customer1.equals(customer)) {
                customers.remove(customer);
                removed = true;
            }
        }
        if (!removed)
            throw new CustomNotFoundException();
    }

    public void createCustomer(String name) {
        Customer customer = new Customer(idCounter++, name);
        customers.add(customer);
    }

    public void editCustomer(int id, String name) throws CustomNotFoundException {
        boolean found = false;
        for (Customer customer :
                customers) {
            if (customer.getId() == id) {
                customer.setName(name);
                found = true;
            }

        }
        if (!found)
            throw new CustomNotFoundException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerList that = (CustomerList) o;
        return idCounter == that.idCounter &&
                Objects.equals(customers, that.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customers, idCounter);
    }
}
