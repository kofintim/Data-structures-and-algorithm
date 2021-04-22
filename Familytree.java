
import java.util.*;

class Family {
    //A node class for doubly linked list
    class Node{
        String name;
        Node previous;
        Node next;

        public Node(String name) {
            this.name = name;
        }
    }
    //Initially, head and tail is set to null
    Node head, tail = null;

    //add a node to the list
    public void addNodehead(String name) {
        //Create a new node
        Node newNode = new Node(name);

        //if list is empty, head and tail points to newNode
        if(head == null) {
            head = tail = newNode;
            //head's previous will be null
            head.previous = null;
            //tail's next will be null
            tail.next = null;
        }
        else {
            //add newNode to the end of list. tail->next set to newNode
            tail.next = newNode;
            //newNode->previous set to tail
            newNode.previous = tail;
            //newNode becomes new tail
            tail = newNode;
            //tail's next point to null
            tail.next = null;
        }
    }

    //print all the nodes of doubly linked list
    public void printNodes() {
        //Node current will point to head
        Node current = head;

        if(head == null) {
            System.out.println("There is no name .");
            return;
        }
        System.out.println("Members of the Branam clan :");
        while(current != null) {
            //Print each node and then go to next.
            System.out.print(current.name + " \n");
            current = current.next;

        }

        Node last = tail;
        if(tail == null) {
            System.out.println("That's it for now.");
            return;
        }
        System.out.println("\n Names in reciprocal ");
        while (last != null) {
            //Print each node and then go to next.
            System.out.print(last.name + " \n");
            last = last.previous;

        }
    }
    /* Given a node as previous node, insert a new node after the given node */
    public void addNode(Node previous,String name)
    {
        //Node newNode = new Node(name);

        if (previous == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        /*  Allocating  nodes
         *  put in the data */
        Node new_node = new Node(name);

        /*  Make next of new node as next of previous node */
        new_node.next = previous.next;

        /*  Make the next of prev_node as new_node */
        previous.next = new_node;

        /*  Make prev_node as previous of new_node */
        new_node.previous = previous;

        /*  Change previous of new_node's next node */
        if (new_node.next != null)
            new_node.next.previous = new_node;
    }
    public void deleteFromStart() {
        //Checks whether list is empty
        if(head == null) {
            return;
        }
        else {
            //Checks whether the list contains only one element
            if(head != tail) {
                //head will point to next node in the list
                head = head.next;
                //Previous node to current head will be made null
                head.previous = null;
            }
            //If the list contains only one element
            //then, it will remove node and now both head and tail will point to null
            else {
                head = tail = null;
            }
        }
    }

    public static void main(String[] args) {


//create a DoublyLinkedList object
       Family dl_List = new Family();
        Scanner keyboard = new Scanner(System.in);
        dl_List.addNodehead("Nana Kwaku Beaye");
        dl_List.addNodehead("Kwasi Badu");
        dl_List.addNodehead("Stephen Kodom");
        dl_List.addNodehead("Kwaku Nsiah");
        dl_List.addNodehead("Yaa Nsiah");
        dl_List.addNodehead("Maafia Ntim ");
        dl_List.addNodehead("Richard Ntim");
        dl_List.addNodehead("Yaw Adjei Ntim");
        dl_List.addNodehead("Afrifa Mawuli Ntim");
        dl_List.addNodehead("Adwoa Frema Nsiah");
        dl_List.printNodes();
        int treesize;


        System.out.println("How many new members are there?");
        treesize = keyboard.nextInt();

        //This allows the user to add names of new family members. For Example babies or new born children
        System.out.println("Please enter the names of the new members ");
        String node;
        int count =0;
        while(count<=treesize)
        {
            //System.out.println("Name: " + count);
            node = keyboard.nextLine();
            //Inserting the nodes
            dl_List.addNodehead(node.toUpperCase());
            count++;
        }

        //This prints the nodes of DoublyLinkedList
        dl_List.printNodes();

       System.out.println("\nPlease enter the new family head ");
        node = keyboard.nextLine();
        dl_List.addNode(dl_List.head.next.previous, node);
        dl_List.printNodes();

        System.out.println("\nPlease enter the new name to be added ");
        node = keyboard.nextLine();

        dl_List.addNodehead(node);
        dl_List.printNodes();

        dl_List.deleteFromStart();
        dl_List.printNodes();


        System.out.println("\nThe size of the list is: "+node.length());



    }
}
