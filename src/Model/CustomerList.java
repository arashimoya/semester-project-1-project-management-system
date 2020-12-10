package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class CustomerList  implements Serializable {
    private ArrayList<Customer> customers;
    private static int idCounter;

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

    public Customer getCustomer(String name) throws CustomNotFoundException {
        for (Customer customer :
                customers) {
            if (customer.getName().equals(name))
                return customer;
        }
        throw new CustomNotFoundException();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) throws ObjectAlreadyExistsException{
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        else {
            throw new ObjectAlreadyExistsException();
        }
    }

    public void deleteCustomer(Customer customer) throws CustomNotFoundException {
        if (customers.contains(customer)) {
            customers.remove(customer);
        }
        else
            throw new CustomNotFoundException();
    }

    public Customer createCustomer(String name) throws ObjectAlreadyExistsException {
        Customer customer = new Customer(idCounter++, name);
        if (!customers.contains(customer)){
            customers.add(customer);
            return customer;
        }
        else {
            throw new ObjectAlreadyExistsException();
        }
    }

    public void editCustomer(Customer customer, String name) throws CustomNotFoundException {
        if (customers.contains(customer)){
            customer.setName(name);
        } else {
            throw new CustomNotFoundException();
        }

    }

}
