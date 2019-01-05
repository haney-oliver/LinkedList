package structures;

/**
 *  A class to provide the basic methods of a singly linked list.
 *  Note that it is simplified in that it does not implement or extend
 *  List, Collection, etc.  It is for learning the basics of Linked
 *  Lists.
 *
 *  @author Daniel Plante
 *  @author Oliver Haney
 *  @version 1.0   2 March 2002
 *  @version 1.1   19 November 2013
 *  @version 1.2   12 November 2018
 */
public class LinkedList<T> {
    /////////////////////////////
    //         Properties      //
    /////////////////////////////
    private Node<T> myHead;
    private int mySize;
    private int myIndex;
    
    
    /////////////////////////////
    //         Methods         //
    /////////////////////////////
    
    /**
     *  Default constructor that creates an empty linked list
     *
     *  <pre>
     *  pre:  the linked list is empty
     *  post: the linked list is empty
     *  </pre>
     */
    public LinkedList() {
        myHead = null;
        mySize = 0;
    }
    
    /**
     *  Constructor that creates a new linked list with a single 
     *  node storing the object passed in
     *
     *  <pre>
     *  pre:  myHead points to null (the linked list is empty)
     *  post: myHead points to the only node in the linked list,
     *        that node holding the object passed in
     *  </pre>
     *
     *  @param datum an object to be inserted at the head of the
     *         linked list
     */
    public LinkedList(T datum) {
    	myHead = new Node<T>(datum);
        myHead.setNext(null);
        mySize = 1;
    }
    
    /**
     *  Adds a node to the head of the linked list; the special
     *  condition of an empty linked list is handled without
     *  special treatment since if myHead points to null, that
     *  simply becomes the next node in the list, immediately
     *  following the new entered node at the head of the list
     *
     *  <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the beginning of the list
     *  </pre>
     *
     *  @param node the node to be entered
     */
    private void addFirst(Node<T> node) {
    	this.setHead(node);;
    	mySize++;
    }
    
    /**
     *  Adds a node to the head of the linked list; the special
     *  condition of an empty linked list is handled without
     *  special treatment since if myHead points to null, that
     *  simply becomes the next node in the list, immediately
     *  following the new entered node at the head of the list
     *
     *  <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the beginning of the list
     *  </pre>
     *
     *  @param datum the object used to create a new node to be 
     *         entered at the head of the list
     */
    public void addFirst(T datum) {
    	Node<T> first = new Node<T>(datum, myHead);
    	this.addFirst(first);
    }
    
    /**
     *  Adds a node to the tail of the linked list; the special
     *  condition of an empty linked list is handled separately
     *
     *  <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the end of the list
     *  </pre>
     *
     *  @param node the node to be entered
     */
    private void addLast(Node<T> node) {
        Node<T> lastNode;
        
        if(myHead==null) {
            this.addFirst(node);
            mySize++;
        } else {
            lastNode = this.getPrevious(null);
            lastNode.setNext(node);
            node.setNext(null);
            mySize++;
        }
    }
    
    /**
     *  Adds a node to the tail of the linked list; the special
     *  condition of an empty linked list is handled separately
     *
     *  <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the end of the list
     *  </pre>
     *
     *  @param datum the object used to create a new node to be 
     *         entered at the tail of the list
     */
    public void addLast(T datum) {	
        Node<T> node = new Node<T>(datum);
        this.addLast(node);
    }
    
    /**
     *  Deletes a node from the list if it is there
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: if the node to be deleted is in the list,
     *        the node no longer exists in the list; the
     *        node previous to the node to be deleted now
     *        points to the node following the deleted node
     *  </pre>
     *
     *  @param node the node to be deleted from the list
     *
     *  @return boolean indicating whether or not the node
     *          was deleted
     */
    private boolean remove(Node<T> node) {
        if(this.contains(node.getData())) {
        	if(node.equals(myHead)) {
        		this.removeFirst();
        		return true;
        	} else {
        		getPrevious(node).setNext(node.getNext());
        		mySize--;
        		return true;
        	}
        }
        return false;
    }
    
    /**
     *  Deletes a node from the list if it is there
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: if the node to be deleted is in the list,
     *        the node no longer exists in the list; the
     *        node previous to the node to be deleted now
     *        points to the node following the deleted node
     *  </pre>
     *
     *  @param datum the object to be deleted from the list
     *
     *  @return boolean indicating whether or not the node
     *          was deleted
     */
    public boolean remove(T datum) {
    	if (findNode(datum) != null) {
    		if (remove(findNode(datum))) {
        		return true;
        	}
    	}
        return false;
    }
    
    /**
     *  Find a node in the list with the same data as that passed in 
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: list is unchanged
     *  </pre>
     *
     *  @param datum the object for which a node is to be found 
     *         in the list
     *
     *  @return null if a node with the given object datum is not in
     *          the list, or the node if it does
     */
    private Node<T> findNode(T datum) {
        Node<T> currentNode;
        Object currentDatum;
        
        currentNode = myHead;
        currentDatum = null;
        
        myIndex = 0;
        
        while(currentNode != null)
        {
            currentDatum = currentNode.getData();
            if(currentDatum.equals(datum))
            {
                return currentNode;
            }
            currentNode = currentNode.getNext();
            myIndex++;
        }
        return null;
    }
    
    /**
     *  Determine if a node exists in the list with the same 
     *  data as that passed in 
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: list is unchanged
     *  </pre>
     *
     *  @param datum the object for which a node is to be found 
     *         in the list
     *
     *  @return false if a node with the given object datum is not in
     *          the list, or true if it does
     */
    public boolean contains(T datum) {
    	if (findNode(datum) == null) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
    /**
     *  Determines the node that resides one closer to the
     *  head of the list than the node passed in
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: the list is unchanged
     *  </pre>
     *
     *  @param node the node whose predecessor is being looked for
     *
     *  @return the node that resides one closer to the head of the
     *          list than the node passed in
     */
    private Node<T> getPrevious(Node<T> node) {
        Node<T> currentNode;
        
        currentNode = myHead;
        
        if(currentNode.equals(node)) {
            return null;
        }
        while(currentNode!=null && currentNode.getNext() != node) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }
    
    /**
     *  A new node is entered into the list immediately before
     *  the designated node
     *
     *  <pre>
     *  pre:  the list may have 0 or more nodes in it
     *  post: if the beforeNode is not in the list, no change
     *        takes place to the list; otherwise, the new
     *        node is entered in the appropriate place
     *  </pre>
     *
     *  @param node the node to be entered into the list
     *  @param beforeNode the node before which the new node
     *         is to be entered
     *
     *  @return boolean designating if the node was or was not
     *          entered into list
     */
    private boolean insertBefore(Node<T> insertNode, Node<T> referenceNode) {
    	 Node<T> currentNode = myHead;
         
         if(currentNode.equals(referenceNode)) {
             myHead = insertNode;
             myHead.setNext(referenceNode);
             mySize++;
             return true;
         }
         
         while(currentNode!=null && currentNode.getNext() != referenceNode) {
             currentNode = currentNode.getNext();
         }
         
         currentNode.setNext(insertNode);
         insertNode.setNext(referenceNode);
         mySize++;
         return true;
    }
    
    /**
     *  A new node with datum is entered into the list immediately
     *  before the node with beforeDatum, the designated node
     *
     *  <pre>
     *  pre:  the list may have 0 or more nodes in it
     *  post: if the node with beforeDatum is not in the list, 
     *        no change takes place to the list; otherwise, a new
     *        node is entered in the appropriate place with the 
     *        object datum
     *  </pre>
     *
     *  @param datum the object used to create the new node 
     *         to be entered into the list
     *  @param beforeDatum the datum of the node before which the 
     *         new node is to be entered
     *
     *  @return boolean designating if the node was or was not
     *          entered
     */
    public boolean insertBefore(T insertDatum, T referenceDatum) {
    
    	Node<T> insertNode = new Node<T>(insertDatum);
    	Node<T> referenceNode = this.findNode(referenceDatum);
    	if( this.insertBefore(insertNode, referenceNode)) {
    		return true;
    	}
        return false;
    }
    
    /**
     *  print the list by converting the objects in the list
     *  to their string representations
     *
     *  <pre>
     *  pre:  the list has 0 or more elements
     *  post: no change to the list
     *  </pre>
     */
    public String toString() {
        String string;
        Node<T> currentNode;
        
        currentNode = myHead;
        
        string = "head ->";
        
        while(currentNode!=null) {
            string += currentNode.getData().toString()+ " -> ";
            currentNode = currentNode.getNext();
        }
        string += "|||";
        return string;
    }

    /**
     * finds the index of a particular object in the list
     * utilizes the findNode function to calculate index
     * by passing T o
     * @param o
     * @return int index of requested object
     */
    public int indexOf(T o) {
    	if(this.contains(o)) {
    		findNode(o);
            return myIndex;
    	}
    	return -1;
    }
    
    /**
     * removes the first Node
     * @return first Node data
     */
    public T removeFirst() {
    	Node<T> first = myHead;
    	T datum = first.getData();
    	myHead = myHead.getNext();
    	mySize--;
    	return datum;
    }
    
    /**
     * removes the last Node is list
     * @return last Node data
     */
    public T removeLast()  {
    	T lastDatum;
    	lastDatum = this.getLast();
    	this.remove(this.getLast());
    	return lastDatum;
    }
    
    /**
     * fetches the size of the list
     * @return int size
     */
    public int size() {
        return mySize;
    }
    
    /**
     * 
     * @return T first Node in list data
     */
    public T getFirst() {
        return this.getHead().getData();
    }
    
    /**
     * 
     * @return T last Node in list data
     */
    public T getLast() {
    	T lastDatum;
    	Node<T> currentNode = new Node<T>();
    	currentNode = myHead;
        while (currentNode != null) {
        	currentNode = currentNode.getNext();
        	if (currentNode.getNext() == null) {
        		lastDatum = currentNode.getData();
        		return lastDatum;
        	}
        }
        return null;
    }
    
    /**
     * Sets up passed in param in a new Node
     * and sets that Node as the new myHead
     * @param o
     */
    public void setFirst(T o) {
    	this.getHead().setData(o);
    }
    
    /**
     * Sets the head of the list as the passed in Node
     * and sets the next of the new head to the same as the
     * old head
     * @param node
     */
    private void setHead(Node<T> node) {	
    	myHead = node;
    }
    
    private Node<T> getHead() {
        return myHead;
    }
 

    /**
     *  Provides the basic structure of a linked-list node
     *
     *  @author Daniel Plante
     *  @version 1.0   2 March 2002
     */
    private class Node<E> {
        ///////////////////////////////////
        //           Properties          //
        ///////////////////////////////////
        private T myData;
        private Node<T> myNext;
        
        ///////////////////////////////////
        //             Methods           //
        ///////////////////////////////////
        
        /**
         *  Default constructor for a node with null
         *  data and pointer to a next node
         */
        public Node() {
            myData = null;
            myNext = null;
        }
        
        /**
         *  Constructor for a node with some object for
         *  its data and null for a pointer to a next node
         *
         *  <pre>
         *  pre:  a null node
         *  post: a node with some object for its data and
         *        null for a pointer to a next node
         *  </pre>
         *
         *  @param datum an object for the node's data
         */
        public Node(T datum) {
        	myData = datum;
			myNext = null;
        }
        
        /**
         *  Constructor for a node with some object for 
         *  its data and a pointer to another node
         *
         *  <pre>
         *  pre:  a null node
         *  post: a node with some object for its data and
         *        a pointer to a next node
         *  </pre>
         *
         *  @param datum an object for the node's data
         *  @param next the node that this node points to
         */
        public Node(T datum, Node<T> next) {
            myData = datum;
            myNext = next;
        }
        
        // Accessor methods
        public void setData(T datum) {
            myData = datum;
        }
        
        public T getData() {
            return myData;
        }
        
        public void setNext(Node<T> myHead) {
            myNext = myHead;
        }
        
        public Node<T> getNext() {
            return myNext;
        }
    }     
}