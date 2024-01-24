// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BTQueueNode<LS>
{
   BinaryTreeNode<LS> node;
   BTQueueNode<LS> next;
   
   public BTQueueNode ( BinaryTreeNode<LS> n, BTQueueNode<LS> nxt )
   {
      node = n;
      next = nxt;
   }
}
