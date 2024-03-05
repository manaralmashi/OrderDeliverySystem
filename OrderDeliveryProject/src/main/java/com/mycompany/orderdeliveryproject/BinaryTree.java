/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;


/**
 *
 * @author Lamis Mohammed
 */
public class BinaryTree {
     private static class Node  {
        private OrderService element;
        private Node  left;
        private Node  right;

        public Node(OrderService e)  {
            element = e;
            right = null;
            left = null;
        }		
    }//----------- end of nested Node class -----------
		
    private Node  root = null;
	  
    /**
     *
     */
    public BinaryTree() { } // constructor constructs an initially empty tree
	
    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }

    // return the number of nodes/elements in the tree

    /**
     *
     * @return
     */
    public int getSize() {
        return getSizeRecursive(root);
    }
    private int getSizeRecursive(Node n) {
		//implement this method
        if (n == null) {
            return 0;
        } else {
            return getSizeRecursive(n.left) + 1 + getSizeRecursive(n.right);
        }
    }
 // insert a node

    /**
     *
     * @param e
     */
    public void addNode(OrderService e) {
        root = addNodeRecursive(root, e);
    }
    private Node addNodeRecursive(Node  n, OrderService e) {
		//implement this method
         if (n == null) {
            Node temp = new Node(e); //create new node
            return temp;
        }
        if (e.getOrderNumber() < n.element.getOrderNumber()) {
            n.left = addNodeRecursive(n.left, e);
        } else if (e.getOrderNumber() > n.element.getOrderNumber()) {
            n.right = addNodeRecursive(n.right, e);
        }
        return n;
    }
    
   // search for a given node, return true if it is found, false otherwise 

    /**
     *
     * @param e
     * @return
     */
    public boolean searchNode(OrderService e) {
        return searchNodeRecursive(root, e);
    }
    private boolean searchNodeRecursive(Node n, OrderService e) {
		//implement this method
         if (n == null) {
            return false;
        }
        if (e.getOrderNumber() == n.element.getOrderNumber()) {
            return true;
        }
        if (e.getOrderNumber() < n.element.getOrderNumber()) {
            return searchNodeRecursive(n.left, e);
        } else {
            return searchNodeRecursive(n.right, e);
        }
    } 
    
    /**
     *
     * @param e
     */
    public void deleteNode(OrderService e) {
        root = deleteNodeRecursive(root, e);
    }

    /**
     *
     * @param n
     * @param e
     * @return
     */
    public Node deleteNodeRecursive(Node n, OrderService e) {
        if (n == null) {
            return null;
        }
        if (e == n.element) {
            if (n.left == null && n.right == null) {
                return null;
            }
            if (n.left == null) // 1 child
            {
                return n.right;
            }
            if (n.right == null) // 1 child return left(v)
            {
                return n.left;
            }
            OrderService temp = findSmallestValue(n.right);
            n.element = temp;
            n.right = deleteNodeRecursive(n.right, temp);
            return n;
        }

        if (e.getOrderNumber() < n.element.getOrderNumber()) {
            n.left = deleteNodeRecursive(n.left, e);
            return n;
        }
        n.right = deleteNodeRecursive(n.right, e);
        return n;
    }

    //finds the smallest value starting from the subtree rooted at Node n.
     private OrderService findSmallestValue(Node n) {
        if(n.left == null )
            return n.element; 
        else
            return findSmallestValue(n.left);
    }
    
     // in-order traversal

    /**
     *
     */
    public void traverseInOrder() {
        traverseInOrderRecursive(root);
    }
    private void traverseInOrderRecursive(Node n) {
		//implement this method
        if (n != null) {
            traverseInOrderRecursive(n.left);
            visit(n.element);
            traverseInOrderRecursive(n.right);
        }
    }
    
     // post-order traversal

    /**
     *
     */
    public void traversePostOrder() {
        traversePostOrderRecursive(root);
    }
    private void traversePostOrderRecursive(Node n) {
		//implement this method
        if (n != null) {
            traversePostOrderRecursive(n.left);
            traversePostOrderRecursive(n.right);
            visit(n.element);
        }
    }
    
// pre-order traversal

    /**
     *
     */
    public void traversePreOrder() {
        traversePreOrderRecursive(root);
    }
    private void traversePreOrderRecursive(Node n) {
		//implement this method
     if (n != null) {
            visit(n.element);
            traversePreOrderRecursive(n.left);
            traversePreOrderRecursive(n.right);
        }
    }
    
   // our visit is printing the nodes stored values
    private void visit(OrderService value) {
        System.out.print(" " + value);        
    }
}

