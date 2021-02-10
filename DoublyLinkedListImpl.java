/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.util.Scanner;

public class DoublyLinkedListImpl {
    
    static Node head;
    
    static class Node{
      int data;
      Node next;
      Node prev;
      Node(int val){
        this.data = val;
        this.next = null;
        this.prev = null;
      }
    }
    
    static void addFirst(int val){
        
        Node node = new Node(val);
        if(head != null){
           head.prev = node;
           node.next = head;
        }
        head = node;
    }
    
    static void addLast(int val){
        
        Node node = new Node(val);
        if(head == null){
           head = node;
           return;
        }
        
        Node tempnode = head;
        while(tempnode.next != null){
          tempnode = tempnode.next;
        }
        tempnode.next = node;
        node.prev = tempnode;
    }
    
    static void addAtIndex(int val,int index){
        Node node = new Node(val);
        int size = getSize();
        if(index == 0){
            addFirst(val);
        }else if(index == size){
            addLast(val);
        }else if(index < 0 || index > size){
            System.out.println("Invalid index");
        }else{
            Node tempNode = head;
            for(int i=0;i<index;i++){
               tempNode = tempNode.next;
            }
            Node leftNode = tempNode.prev;
            leftNode.next = node;
            node.prev = leftNode;
            node.next = tempNode;
            tempNode.prev = node;
       }
    }
    
    static void removeFirst(){
        if(head != null){
           head = head.next;
        }else{
            System.out.println("LinkedList is Empty");
        }
    }
    
    static void removeLast(){
         if(head != null){
           Node tempNode = head;
           while(tempNode.next != null){
             tempNode = tempNode.next;
           }
           Node preNode = tempNode.prev;
           preNode.next = null;
         }else{
            System.out.println("LinkedList is Empty");
         }
    }
    
    static void removeAtIndex(int index){
       int size = getSize();
       if(index < 0 || index > size-1){
           System.out.println("Invalid index");
       }else if(index == 0){
          removeFirst();
       }else if(index == size-1){
         removeLast();
       }else{
         Node tempNode = head;
         for(int i=0;i<index;i++){
           tempNode = tempNode.next;
         }
         Node leftNode = tempNode.prev;
         leftNode.next = tempNode.next;
       }
    }
    
    static int getSize(){
      int count = 0;
      Node tempnode = head;
      while(tempnode != null){
         tempnode = tempnode.next;
         count++;
      }
      return count;
    }
    
    static void PrintList(){
       Node tempNode = head;
       System.out.print("[");
       while(tempNode != null){
           System.out.print(" "+tempNode.data);
           tempNode = tempNode.next;
       }
       System.out.println("]");
    }
    
    static void findNode(int val){
       Node tempNode = head;
       int index =-1;
       while(tempNode != null){
         if(tempNode.data == val){
             ++index;
             System.out.println("Elemnt found at index" + index);
             return;
         }else{
            tempNode = tempNode.next;
            index++;
         }
       }
        System.out.println("Elemnt not found");
    }
    
    public static void main(String args[]){
        Scanner read = new Scanner(System.in);
        System.out.println("AddFirst-A1, AddLast-A2, AddAtIndex-A3, RemoveFirst-R1, RemoveLast-R2, RemoveAtIndex-A3,FindNode-F1");
        String command = "";
        while(1==1){
                System.out.println("Enter the command");
                command = read.next();
                if(command.equals("end")){
                  break;
                }else if(command.equals("A1")){
                   int val = read.nextInt();
                   addFirst(val);
                   PrintList();
                }else if(command.equals("A2")){
                    int val = read.nextInt();
                    addLast(val);
                    PrintList();
                }else if(command.equals("A3")){
                    int val = read.nextInt();
                    int index = read.nextInt();
                    addAtIndex(val, index);
                    PrintList();
                }else if(command.equals("R1")){
                   removeFirst();
                   PrintList();
                }else if(command.equals("R2")){
                  removeLast();
                  PrintList();
                }else if(command.equals("R3")){
                    int index = read.nextInt();
                    removeAtIndex(index);
                    PrintList();
                }else if(command.equals("F1")){
                   int val = read.nextInt();
                   findNode(val);
                }else{
                    System.out.println("invalid command");
                }
                
        }
    }
 
}
    
   

