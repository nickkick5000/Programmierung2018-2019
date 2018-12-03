public class Tree {
  private int label;
  
  private TreeList children;

  /**
   * builds a tree object with a label and a children
   * @param inputLabel the label that is being assigned to the current object
   * @param inputChildren the children that is being assigned to the current object
   */
  public Tree(int inputLabel, TreeList inputChildren){
    this.label = inputLabel;
    this.children = inputChildren;
  }
  
  //a)

  /**
   * gets the label of the current object
   * @return the label of the current object
   */
  public int getLabel() {
    return this.label;
  }

  /**
   * gets the children of the current object
   * @return the children of the current object
   */
  public TreeList getChildren() {
    return this.children;
  }

  /**
   * sets the label of the current object
   * @param label that is being assigned to the current object
   */
  public void setLabel(int label) {
    this.label = label;
  }

  /**
   * sets the children of the current object
   * @param children that is being assigned to the current object
   */
  public void setChildren(TreeList children) {
    this.children = children;
  }

  
  //b)

  /**
   * builds a string that represent the tree
   * @return a string representation of the tree
   */
  @Override
  public String toString() {
    return label + "->[" + (this.children == null ? "" : this.children.toString()) + "]";
  }
  
  //c)

  /**
   * calculates the maximum branching degree of a tree
   * @return the maximum branching degree as an int
   */
  public int branchingDegree() {
    if(this.children == null || this.children.getHead() == null) {
      return 0;
    }

    return this.children.getHead().branchingDegree();
  }
  
  //d)

  /**
   * checks if the tree contains a specific value
   * @param toSearch the integer that is being searched in the tree
   * @return true if the tree contains toSearch, else false
   */
  public boolean contains(int toSearch) {
    if(this.children == null || this.children.getHead() == null) {
      return label == toSearch;
    }

    return label == toSearch || getChildren().getHead().contains(toSearch);
  }
  
  //e)

  /**
   * Builds a tree with Tree, TreeList and TreeListElements
   * @param value current value of the TreeListElement
   * @param children an array that contains the number of childrens in the tree
   * @return new Tree with the value and a TreeList if the number of childrens is more than 0
   */
  public static Tree buildTree(int value, Tree... children) {
    if(children.length == 0) {
      return new Tree(value, null);
    }
    else {
      return new Tree(value, new TreeList(children));
    }
  }
  
  /**
  * Method for trying out some of the implemented commands.
  * @param args input strings from the console
  */
  
  public static void main(String[] args) {
    Tree[] trees = {buildTree(1,buildTree(2),buildTree(3),buildTree(4)), buildTree(-1) , buildTree(4,buildTree(1,buildTree(1,buildTree(1,buildTree(1),buildTree(1),buildTree(1)),buildTree(1),buildTree(1))),buildTree(2),buildTree(2,buildTree(2))),
    buildTree(72, buildTree(27), buildTree(11), buildTree(54,buildTree(89,buildTree(10),buildTree(20),buildTree(42))), buildTree(23)),
    buildTree(54,buildTree(89,buildTree(10),buildTree(20),buildTree(42)))};
    
    for(Tree tree:trees){
      if(tree != null){
        String test = "";
        test = test + tree.toString() + "\n";
        test = test + "Branching Degree: " + tree.branchingDegree() + "\n";
        test = test + "2 contained: " + tree.contains(2) + "\n";
        test = test + "42 contained: " + tree.contains(42) + "\n";
        test = test + "1 contained: " + tree.contains(1) + "\n";
        //SimpleIO.output(test);
        System.out.println(test);
      }
    }
    
  }
  
}
