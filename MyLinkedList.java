public class MyLinkedList{
  private int size;
  private Node start,end;
  public MyLinkedList(){
    size=0;
    start=null;
    end=null;
  }
  public int size(){
    return size;
  }
  public boolean add(String value){
    if (end==null){
      start= new Node(value);
      end=start;
      size++;
    }
    else{
      Node temp=new Node(value);
      end.setNext(temp);
      temp.setPrev(end);
      size++;
      end=temp;
    }
  }
  public void add(int index, String value){

  }
  public String get(int index){

  }
  public String set(int index, String value){

  }
  public String toString(){

  }
  //Any helper method that returns a Node object MUST BE PRIVATE!
}
