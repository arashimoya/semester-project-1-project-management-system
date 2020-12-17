package Model;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * @author Oliver
 * class to hold a list of customers
 */
public class CustomerList implements Serializable {
    private ArrayList<Customer> customers;
    private int idCounter;

    /**
     * no args constructor initializing the customer list and the id count
     */
    public CustomerList() {
        customers = new ArrayList<Customer>();
        idCounter = 0;
    }

    /**
     * to find customer by id
     *
     * @param id id to find the customer by
     * @return found customer
     * @throws CustomNotFoundException if no customer with such id was found
     */
    public Customer getCustomer(int id) throws CustomNotFoundException {
        for (Customer customer :
                customers) {
            if (customer.getId() == id)
                return customer;
        }
        throw new CustomNotFoundException();
    }

    /**
     * to find customer by name
     *
     * @param name name to find the customer by
     * @return the found customer
     * @throws CustomNotFoundException if no customer with such name was found
     */
    public Customer getCustomer(String name) throws CustomNotFoundException {
        for (Customer customer :
                customers) {
            if (customer.getName().equals(name))
                return customer;
        }
        throw new CustomNotFoundException();
    }

    /**
     * to get all customers in the list
     *
     * @return the list of customers
     */
    public ArrayList<Customer> getCustomers() {

        return customers;
    }

    /**
     * to add a customer into the list
     *
     * @param customer customer to be added into the list
     * @throws ObjectAlreadyExistsException if the customer is already in the list
     */
    public void addCustomer(Customer customer) throws ObjectAlreadyExistsException {
        if (!customers.contains(customer)) {
            customers.add(customer);
        } else {
            throw new ObjectAlreadyExistsException();
        }
    }

    /**
     * to delete a customer
     *
     * @param customer customer to be deleted
     * @throws CustomNotFoundException if the customer was not found
     */
    public void deleteCustomer(Customer customer) throws CustomNotFoundException {
        if (customers.contains(customer)) {
            customers.remove(customer);
        } else
            throw new CustomNotFoundException();
    }

    /**
     * to create a new customer in the list
     *
     * @param name name for the new customer
     * @return the newly created customer
     * @throws ObjectAlreadyExistsException if the object already exists in the list
     */
    public Customer createCustomer(String name) throws ObjectAlreadyExistsException {
        Customer customer = new Customer(idCounter, name);
        if (!customers.contains(customer)) {
            customers.add(customer);
            idCounter++;
            return customer;
        } else {
            throw new ObjectAlreadyExistsException();
        }
    }

    /**
     * to edit a customer in the list
     *
     * @param customer the customer to be edited
     * @param name     new name for the customer
     * @throws CustomNotFoundException if the customer was not found
     */
    public void editCustomer(Customer customer, String name) throws CustomNotFoundException {
        if (customers.contains(customer)) {
            customer.setName(name);
        } else {
            throw new CustomNotFoundException();
        }

    }

    public int getIdCounter() {
        return idCounter;
    }
}
