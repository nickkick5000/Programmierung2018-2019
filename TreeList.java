public class TreeList {

  private TreeListElement head;

  /**
   * builds a TreeList object with an empty head
   */
  public TreeList() {
    this.head = null;
  }

  /**
   * builds a TreeList object with a head that builds a TreeListElement
   * @param trees represent the children array from the tree class
   */
  public TreeList(Tree[] trees) {
    this.head = new TreeListElement(trees);
  }
  
  //a)

  /**
   * gets the head of the current object
   * @return the head of the current object
   */
  public TreeListElement getHead() {
    return this.head;
  }

  /**
   * sets the head of the current object
   * @param head that is being assigned to the current object
   */
  public void setHead(TreeListElement head) {
    this.head = head;
  }

  
  //b)

  /**
   * builds a string that represent the tree
   * @return calls the toString method for the next element after head
   */
  @Override
  public String toString() {
    return head.toString();
  }
  
  //c)
  
  //d)

  //e)
  
}
