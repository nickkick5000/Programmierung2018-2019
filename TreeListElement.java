public class TreeListElement {

  private Tree value;
  private TreeListElement next;
  private int degree;

  /**
  * @param inputValue The value of the new TreeListElement
  * @param inputNext The next elements of the TreeListElement
  */
  public TreeListElement(Tree inputValue, TreeListElement inputNext){
    this.value = inputValue;
    this.next = inputNext;
  }

  /**
   * calls the next constructor of TreeListElement
   * @param trees represent the children array from the tree class
   */
  public TreeListElement(Tree[] trees) {
    this(trees, 0);
  }

  /**
   * builds treeListElements with a value, degree an next
   * @param trees represent the children array from the tree class
   * @param index the current index of the trees array
   */
  public TreeListElement(Tree[] trees, int index) {
    this.degree = trees.length;
    this.value = trees[index];
    if(index == trees.length - 1) {
      this.next = null;
    }
    else {
      this.next = new TreeListElement(trees, ++index);
    }
  }
  
  //a)

  /**
   * gets the value of the current object
   * @return the value of the current object
   */
  public Tree getValue() {
    return value;
  }

  /**
   * gets the next of the current object
   * @return the next of the current object
   */
  public TreeListElement getNext() {
    return next;
  }

  /**
   * sets the value of the current object
   * @param value that is being assigned to the current object
   */
  public void setValue(Tree value) {
    this.value = value;
  }

  /**
   * sets the next of the current object
   * @param next that is being assigned to the current object
   */
  public void setNext(TreeListElement next) {
    this.next = next;
  }

  //b)

  /**
   * builds a string that represent the tree
   * @return the value of the TreeListElements and checks of a next element exists
   */
  @Override
  public String toString() {
    return value.toString() + (this.next == null ? "" : "," + next.toString());
  }


  //c)

  /**
   * calculates the maximum branching degree of a tree
   * @return the maximum of all branchingdegrees
   */
  public int branchingDegree() {
    if(this.next == null) {
      return this.value.branchingDegree();
    }

    return max(this.degree, max(this.value.branchingDegree(), this.next.branchingDegree()));
  }
  
  //d)

  /**
   * checks if the tree contains a specific value
   * @param toSearch the integer that is being searched in the tree
   * @return true if the value contains toSearch, or the next element contains toSearch, else false
   */
  public boolean contains(int toSearch) {
    return this.value.contains(toSearch) || (this.next != null && this.next.contains(toSearch));
  }
  
  //e)

  /**
   * calculates the maximum of two numbers
   * @param a an int that is being compared
   * @param b an int that is being compared
   * @return a int that is the max
   */
  private int max(int a, int b) {
    return a > b ? a : b;
  }
}
