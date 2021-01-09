import java.lang.IndexOutOfBoundsException;
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
    }return true;
  }
  public void add(int index, String value){
    if (index==size){
      add(value);
      return;
    }
    if (index==0){
      Node temp3=new Node (value);
      temp3.setNext(start);
      start.setPrev(temp3);
      size++;
      start=temp3;
      return;
    }

    if (index>size||index<0){
      throw new  IndexOutOfBoundsException();
    }
    Node temp=start;
index--;

      while (index>0){
      index--;
      temp=temp.getNext();
    }
    Node temp2=new Node(value);
    temp2.setNext(temp.getNext());
    temp2.setPrev(temp);
    if (temp2.getNext()==null){
      end=temp2;
    }
  else{  temp2.getNext().setPrev(temp2);
  }
    temp.setNext(temp2);
    size++;
  }
  public String get(int index){
    if (index>=size||index<0){
      throw new  IndexOutOfBoundsException();
    }
    Node temp=start;
    while (index>0){
      index--;
      temp=temp.getNext();
    }
    return temp.getData();
  }
  public String set(int index, String value){
    if (index>=size||index<0){
      throw new  IndexOutOfBoundsException();
    }
    Node temp=start;
    while (index>0){
      index--;
      temp=temp.getNext();
    }
    String temp2= temp.getData();
    temp.setData(value);
    return temp2;
  }
  public String toString(){
    Node temp2=start;
    String ret="";
    while (temp2!=null){
      ret= ret+temp2.getData()+" ";
      temp2=temp2.getNext();


    }return ret;

  }
  public String toStringReversed(){
    Node temp2=end;
    String ret="";
    while (temp2!=null){
      ret= ret+temp2.getData()+" ";
      temp2=temp2.getPrev();


    }return ret;

  }
  public String remove(int index){
    if (index>=size||index<0){
      throw new  IndexOutOfBoundsException();
    }
    Node temp=start;
    while (index>0){
      index--;
      temp=temp.getNext();
    }
    if (size==1){
      String temp2=temp.getData();
      end=null;
      start=null;
      size--;
      return temp2;

    }
    if (temp.getNext()==null){
      String temp2=temp.getData();
      end=temp.getPrev();
      end.setNext(null);
      size--;
      return temp2;
    }
    if (temp.getPrev()==null){
      String temp2=temp.getData();
      start=temp.getNext();
      start.setPrev(null);
      size--;
      return temp2;
    }
    else{
      String temp2=temp.getData();
      temp.getPrev().setNext(temp.getNext());
      temp.getNext().setPrev(temp.getPrev());
      size--;
      return temp2;
    }
  }
  public void extend(MyLinkedList other){
    if (other.size()==0){
      return;
    }
    if(this.size==0){
      this.start=other.start;
      this.end=other.end;
      other.start=null;
      other.end=null;
      this.size=other.size;
      other.size=0;
    }
    else{
      this.end.setNext(other.start);
      other.start.setPrev(this.end);
      this.end=other.end;
      this.size=this.size+other.size;
      other.start=null;
      other.end=null;
      other.size=0;
    }
  }
  //Any helper method that returns a Node object MUST BE PRIVATE!
}
