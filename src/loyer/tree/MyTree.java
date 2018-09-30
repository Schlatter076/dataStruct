package loyer.tree;

import loyer.tree.BiNode;

public class MyTree {
  
  public static void main(String[] args) {
    BiNode binTree = new BiNode();
    Object[] datas = {1, 4, 6, 8, 9, 12, 16, 19};
    binTree.creatTree(datas);
    //binTree.preOrder(binTree.getRoot());
    //binTree.inOrder(binTree.getRoot());
    //binTree.afterOrder(binTree.getRoot());
    binTree.levelOrder(binTree.getRoot());
  }
}
