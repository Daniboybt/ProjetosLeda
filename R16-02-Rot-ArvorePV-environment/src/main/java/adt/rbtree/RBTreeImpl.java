package adt.rbtree;

import adt.bst.BSTImpl;
import adt.bt.Util;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements RBTree<T> {

   public RBTreeImpl() {
      this.root = new RBNode<T>();
   }

   protected int blackHeight() {
      return blackHeight((RBNode<T>) this.root);
   }

   private int blackHeight(RBNode<T> current) {
      if (!current.isEmpty()) {
         if (current.isBlack()) {
            return 1 + blackHeight((RBNode<T>) current.getLeft());
         } else {
            return blackHeight((RBNode<T>) current.getLeft());
         }
      }
      return 0;
   }

   protected boolean verifyProperties() {
      boolean resp = verifyNodesColour() && verifyNILNodeColour() && verifyRootColour() && verifyChildrenOfRedNodes()
            && verifyBlackHeight();

      return resp;
   }

   /**
    * The colour of each node of a RB tree is black or red. This is guaranteed
    * by the type Colour.
    */
   private boolean verifyNodesColour() {
      return true; // already implemented
   }

   /**
    * The colour of the root must be black.
    */
   private boolean verifyRootColour() {
      return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
      // implemented
   }

   /**
    * This is guaranteed by the constructor.
    */
   private boolean verifyNILNodeColour() {
      return true; // already implemented
   }

   /**
    * Verifies the property for all RED nodes: the children of a red node must
    * be BLACK.
    */
   private boolean verifyChildrenOfRedNodes() {
      return verifyChildrenOfRedNodes((RBNode<T>) this.root);
   }

   private boolean verifyChildrenOfRedNodes(RBNode<T> current) {
      boolean res = true;
      if (!current.isEmpty()) {
         if (current.isRED()) {
            if (((RBNode<T>) current.getLeft()).isRED() || ((RBNode<T>) current.getRight()).isRED()) {
               return false;
            } else {
               res = verifyChildrenOfRedNodes((RBNode<T>) current.getLeft());
               if (res != false) {
                  res = verifyChildrenOfRedNodes((RBNode<T>) current.getRight());
               }
            }
         }
      }
      return res;
   }

   /**
    * Verifies the black-height property from the root. The method blackHeight
    * returns an exception if the black heights are different.
    */
   private boolean verifyBlackHeight() {
      return verifyBlackHeight((RBNode<T>) this.root, 0);
   }

   private boolean verifyBlackHeight(RBNode<T> current, int qtdBlacks) {
	  boolean res = true;
      if (!current.isEmpty()) {
    	  if(current.isBlack()) {
    		  return 
    	  }
      }
   }
      
   @Override
   public void insert(T value) {
      insert(value, (RBNode<T>) this.root, new RBNode<T>());
   }

   private void insert(T value, RBNode<T> current, RBNode<T> parent) {
      if (current.isEmpty()) {
         current.setData(value);
         current.setLeft(new RBNode<T>());
         current.setRight(new RBNode<T>());
         current.setParent(parent);
         current.setColour(Colour.RED);
         this.fixUpCase1(current);
      } else {
         if (value.compareTo(current.getData()) < 0) {
            insert(value, (RBNode<T>) current.getLeft(), current);
         } else if (value.compareTo(current.getData()) > 0) {
            insert(value, (RBNode<T>) current.getRight(), current);
         }
      }
   }

   @Override
   public RBNode<T>[] rbPreOrder() {
      RBNode<T>[] array = (RBNode<T>[]) new RBNode[this.size()];
      if (!this.isEmpty()) {
         rbPreOrderArray((RBNode<T>) this.root, array, 0);
      }
      return array;
   }

   private int rbPreOrderArray(RBNode<T> current, RBNode<T>[] array, int i) {
      if (!current.isEmpty()) {
         array[i++] = current;
         i = this.rbPreOrderArray((RBNode<T>) current.getLeft(), array, i);
         i = this.rbPreOrderArray((RBNode<T>) current.getRight(), array, i);
      }
      return i;
   }

   // FIXUP methods
   protected void fixUpCase1(RBNode<T> node) {
      if (node.getData().equals(this.root.getData())) {
         node.setColour(Colour.BLACK);
      } else {
         this.fixUpCase2(node);
      }
   }

   protected void fixUpCase2(RBNode<T> node) {
      if (((RBNode<T>) node.getParent()).isBlack()) {
         return;
      } else {
         this.fixUpCase3(node);
      }
   }

   protected void fixUpCase3(RBNode<T> node) {
      RBNode<T> grandma = (RBNode<T>) node.getParent().getParent();
      RBNode<T> uncle = this.findUncle(node, grandma);

      if (uncle.isRED()) {
         ((RBNode<T>) node.getParent()).setColour(Colour.BLACK);
         uncle.setColour(Colour.BLACK);
         grandma.setColour(Colour.RED);
         this.fixUpCase1(grandma);
      } else {
         this.fixUpCase4(node);
      }
   }

   private RBNode<T> findUncle(RBNode<T> node, RBNode<T> grandma) {
      if (node.getParent().getData().equals(grandma.getLeft().getData())) {
         return (RBNode<T>) grandma.getRight();
      } else {
         return (RBNode<T>) grandma.getLeft();
      }
   }

   protected void fixUpCase4(RBNode<T> node) {
      RBNode<T> next = node;
      RBNode<T> pai = (RBNode<T>) node.getParent();
      RBNode<T> avo = (RBNode<T>) pai.getParent();

      if (next == pai.getRight() && pai == avo.getLeft()) {
         Util.leftRotation(pai);
         next = (RBNode<T>) node.getLeft();
      } else if (next == pai.getLeft() && pai == avo.getRight()) {
         Util.rightRotation(pai);
         next = (RBNode<T>) node.getRight();
      }
      fixUpCase5(next);
   }

   protected void fixUpCase5(RBNode<T> node) {
      RBNode<T> pai = (RBNode<T>) node.getParent();
      RBNode<T> avo = (RBNode<T>) pai.getParent();

      pai.setColour(Colour.BLACK);
      avo.setColour(Colour.RED);

      if (node == pai.getLeft()) {
         Util.rightRotation(avo);
      } else {
         Util.leftRotation(avo);
      }
   }
}
