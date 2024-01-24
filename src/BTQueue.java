// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BTQueue<LS>
{   
   BTQueueNode<LS> head;
   BTQueueNode<LS> tail;
      
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   
   public BinaryTreeNode<LS> getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode<LS> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
   
   public void enQueue ( BinaryTreeNode<LS> node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode<LS> (node, null);
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode<LS> (node, null);
         tail = tail.next;
      }   
   }   
}
