package old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Fruit{
    String name;
    int weight;
    int price;

    public Fruit(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("(%s, %d, %d)",name,weight,price);
    }
}
public class Knapsack {
    public static List<Fruit> knapsack(List<Fruit> fruits, int limit){
        int[] values=new int[limit+1];
        int[] items=new int[limit+1];

        for (int i=0;i<fruits.size();i++){
            System.out.println("i : "+i);
            for (int w=fruits.get(i).weight;w<=limit;w++){
                int p=w-fruits.get(i).weight;
                int newValue=values[p]+fruits.get(i).price;

                //System.out.println("w : "+w+", p : "+p+", newValue : "+newValue+", value[w] : "+values[w]+", items[w] : "+items[w]);

                if (newValue>values[w]){
                    values[w]=newValue;
                    items[w]=i;

                    System.out.println("w : "+w+", p : "+p+", value[w] : "+values[w]+", items[w] : "+items[w]);
                }
            }
        }
        List<Fruit> solution=new ArrayList<>();
        int min= Collections.min(fruits,(f1,f2)->f1.weight-f2.weight).weight;
        for (int i=limit;i>=min;i-=fruits.get(items[i]).weight){
            solution.add(fruits.get(items[i]));
        }
        return solution;
    }

    public static void main(String[] args) {
        System.out.println(knapsack(Arrays.asList(
                new Fruit("Plum",4,4500),new Fruit("Apple",5,5700),
                new Fruit("Orange",2,2250),new Fruit("Strawberry",1,1100),
                new Fruit("melon",6,6700)),8));


        //System.out.println(Arrays.toString(new int[8]));
    }
}
