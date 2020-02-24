package adt;

public interface ContactADT<E> {
    boolean addContact(E item);

    void viewContacts();

    void searchInContacts(String name);

    boolean deleteFromContacts(int index);

}
