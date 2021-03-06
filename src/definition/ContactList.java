package definition;

import adt.ContactADT;

import java.util.ArrayList;


public class ContactList<E> implements ContactADT<E> {

    ArrayList listName = new ArrayList<String>();
    ArrayList listNameFirstName = new ArrayList<String>();
    private Node<E> head;
    private int size= 0;
    private int counter = 0;

    //Created addFirst method
    private void addFirst(E data){
        head = new Node<>((person) data,head);
        size++;
    }

    //Created addAfter method
    private void addAfter (Node <E> node , E data){
        node.next = new Node<>((person) data , node.next);
        size++;
    }
    public int getSize() {
        return size;
    }


    @Override
    public boolean addContact(int index , E data) {
        if(index<0 || index >size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        else if(size == 0){
            addFirst(data);
        }
        else{
            Node<E> count = getNode(index - 1);
            addAfter(count,data);
        }
        return false;
    }
    private Node<E> getNode(int index){
        Node<E> response = head;
        for(int i= 0; i < index ;i++){
            response= response.getNext();

        }
        return response;

    }

    public void setName(String contactFirstName , String contactLastName) {
        listName.add(contactFirstName+ " " + contactLastName);
    }

    public ArrayList getListName() {
        return listName;
    }
    public boolean addContact(E data) {
        addContact(size ,data);
        return false;
    }

    private person deleteFromContactsFirst(){
        person response = null;
        Node<E> count= head;
        if (head != null){
            head=head.getNext();
        }
        if (count!=null){
            size--;
            response = count.getData();

        }
        return response;
    }

    private person deleteFromContactsAfter(Node<E> node) {
        person response = null;
        Node<E> count = node.getNext();

        if (count != null) {
            node.next = count.getNext();
            size--;
            response = count.getData();
        }
        if (count == null) {
            node = null;
            size--;
        }
        return response;
    }

    @Override
    public void viewContacts() {
        if (size!=0){
            System.out.println("---Here are all your contacts---");
            for (int i=0;i<size;i++){
                person data = this.getNode(i).getData();
                System.out.println(data);
            }
        }
        else {
            System.out.println("No Contact Added Yet");
        }


    }

    @Override
    public void searchInContacts(String name) {
        for (int i = 0; i<listNameFirstName.size();i++){
            if (name.compareTo(listNameFirstName.get(i).toString())==0){
                counter++;
            }
        }

        if (counter!=0){
            System.out.println(counter + " match found!");
            for (int i = 0; i <listNameFirstName.size();i++){
                if (name.compareTo(listNameFirstName.get(i).toString())==0){
                    Node <E> personNode=getNode(i);
                    System.out.println(personNode.getData().toString());
                }

            }
        }
        else {
            System.out.println("NO RESULTS FOUND!");
        }


    }

    @Override
    public boolean deleteFromContacts(int index) {
        boolean response=false;
        if (index-1<0 || (index-1>getSize())){
            throw new IndexOutOfBoundsException(Integer.toString(index-1));
        }

        else if (index-1==0){
            deleteFromContactsFirst();
            listName.remove(index-1);
            response=true;
        }
        else {
            Node<E> lastNode= getNode(index-1);
            deleteFromContactsAfter(lastNode);
            listName.remove(index-1);
            response = true;
        }
        return response;
    }
    public void setFirstNameInList(String name) {
        listNameFirstName.add(name);
    }

    public ArrayList getArrayOfFirstName() {
        return listNameFirstName;
    }

    private static class Node<E>{
        private person data;
        private Node<E> next;

        private Node(person data , Node<E> next){
            this.data = data;
            this.next = next;
        }
        private person getData() {
            return data;
        }
        private void setData(person data) {
            this.data = data;
        }
        private Node<E> getNext() {
            return next;
        }
        private void setNext(Node<E> next) {
            this.next = next;
        }

    }
}
