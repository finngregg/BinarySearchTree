// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTreeNode<LS>
{
   LS data;
   BinaryTreeNode<LS> left;
   BinaryTreeNode<LS> right;
   
   public BinaryTreeNode ( LS d, BinaryTreeNode<LS> l, BinaryTreeNode<LS> r )
   {
      data = d;
      left = l;
      right = r;
   }

   public LS getData(){
      return data;
   }

   BinaryTreeNode<LS> getLeft () { return left; }
   BinaryTreeNode<LS> getRight () { return right; }
}
