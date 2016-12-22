public class Driver{
  public static void main(String[] args) {
    SuperArray data = new SuperArray(0);
    SuperArrayIterator looper = new SuperArrayIterator(data);
    int i = 0;
    /*while (i < 26) {
      data.add(""+(char)('A'+i%26));
      i++;
      }*/

    while (looper.hasNext()) {
	System.out.print(looper.next() + "|");
    }
  }
}
