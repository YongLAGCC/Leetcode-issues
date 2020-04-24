

#implements offer (inset) and poll(delete) 
# Time complexity: Delete -> O(log n); Insert: O(1);
# Space complexity : O(n)

#offer: insert（）in front of the heap.

#错误点： 基础知识不牢固 

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> items;
    public Heap(){
        items = new ArrayList<T>();
    }

    // delete the first one, then last one move up
    private void siftUp(){
        int k = items.size() - 1;
        while(k > 0)
        {
            int p = (k - 1)/2;
            T item = items.get(k);
            T parent = items.get(p);
            if(item.compareTo(parent) > 0)
            {
                items.set(k, parent);
                items.set(p, item);
                k = p;
            } else {
                break;
            }
        }
    }
    public void insert(T item) {
        items.add(item);
        siftUp();
    }

    public void siftDown() {
        int k = 0;
        int left= 2 * k + 1;
        while(left < items.size()) {

            int max = left;
            int right = left + 1;
            if (right < items.size()) {
                if (items.get(right).compareTo(items.get(left)) > 0) {
                    max++;
                }
            }
                if (items.get(k).compareTo(items.get(max)) < 0) {
                    T temp = items.get(k);
                    items.set(k, items.get(max));
                    items.set(max, temp);
                    k = max;
                    left = 2 * k + 1;

                } else {
                    break;
                }
        }
    }
    public T delete() throws NoSuchElementException{
        if(items.size() == 0) throw new NoSuchElementException();
        if(items.size() == 1) return items.remove(0);

        T hold = items.get(0);
        items.set(0, items.remove(items.size() - 1));
        siftDown();
        return hold;
    }
    public int size(){
        return items.size();
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public String toString() {
        return items.toString();
    }


     public static void main(String[] args) {
        Heap<Integer> hp = new Heap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the next int, 'done' to stop: ");
        String line = sc.next();

        while (!line.equals("done")) {
            hp.insert(Integer.parseInt(line));
            System.out.println(hp);
            System.out.println("Enter next int, 'done to stop: ");
            line = sc.next();
        }

        while(!hp.isEmpty())
        {
            int max = hp.delete();
            System.out.println(max + " " + hp);
        }
    }
}
