package loyer.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BiNode {
  /**根节点*/
  private BiNode root;
  /**左孩子*/
  private BiNode leftChild;
  /**右孩子*/
  private BiNode rightChild;
  /**数据域*/
  private Object data;
  /**存储所有的节点*/
  private List<BiNode> datas;
  
  public BiNode(BiNode left, BiNode right, Object data) {
    super();
    this.leftChild = left;
    this.rightChild = right;
    this.data = data;
  }
  public BiNode(Object data) {
    this(null, null, data);
  }
  public BiNode() {
    super();
  }
  /**
   * 创建二叉树
   * @param obj 待创建的数据域
   */
  public void creatTree(Object[] obj) {
    if(obj == null) {
      return;
    }
    datas = new ArrayList<BiNode>();
    for(Object object: obj) {
      datas.add(new BiNode(object));
    }
    root = datas.get(0); //将第一个数据作为根节点
    for(int i = 0; i < obj.length / 2; i++) {
      datas.get(i).leftChild = datas.get(i * 2 + 1);
      if((i * 2 + 2) < datas.size()) {
        datas.get(i).rightChild = datas.get(i * 2 + 2);
      }
    }
  }//*/
  
  public BiNode getRoot() {
    return root;
  }
  public void visit(Object obje) {
    System.out.print(obje + " ");
  }
  /**
   * 前序遍历：若二叉树为空，则返回。1.访问根节点 2.按前序遍历左子树 3.按前序遍历右子树
   * @param tree 待遍历的二叉树
   */
  public void preOrder(BiNode tree) {
    if(tree == null) {
      return;
    }
    tree.visit(tree.data);
    preOrder(tree.leftChild);
    preOrder(tree.rightChild);
  }
  /**
   * 中序遍历：若二叉树为空，则返回。1.先中序遍历左子树 2.访问根节点 3.中序遍历右子树
   * @param tree 待遍历的二叉树
   */
  public void inOrder(BiNode tree) {
    if(tree == null) {
      return;
    }
    inOrder(tree.leftChild);
    visit(tree.data);
    inOrder(tree.rightChild);
  }
  /**
   * 后序遍历：若二叉树为空，则返回。1.从左到右先叶子后节点访问左右子树 2.访问根节点
   * @param tree 待遍历的二叉树
   */
  public void afterOrder(BiNode tree) {
    if(tree == null) {
      return;
    }
    afterOrder(tree.leftChild);
    afterOrder(tree.rightChild);
    visit(tree.data);
  }
  /**
   * 层序遍历：若二叉树为空，则返回。1.访问根节点 2.从上而下逐层遍历，同一层中按照从左至右的顺序对结点进行访问
   * @param tree 待遍历的树
   */
  public void levelOrder(BiNode tree) {
    if(tree == null) {
      return;
    }
    Queue<BiNode> queue = new ArrayDeque<>();
    queue.add(tree);
    
    BiNode curNode;
    while(!queue.isEmpty()) {
      curNode = queue.peek();  //检索队列的头，但不删除
      visit(curNode.data);
      if(curNode.leftChild != null) {
        queue.add(curNode.leftChild);
      }
      if(curNode.rightChild != null) {
        queue.add(curNode.rightChild);
      }
      queue.poll();  //删除队列的头
    }
  }
}
















