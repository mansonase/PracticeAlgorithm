package old;

interface Fake{
    void doAction(int index, boolean isBigger);
}
public class Coins {
    public static void compare(int[] coins, int i, int j, int k, Fake fake){
        if (coins[i]>coins[k]){
            fake.doAction(i+1,true);
        }else {
            fake.doAction(j+1,false);
        }
    }

    public static void compare(int[] coins, Fake fake){
        Integer h1=coins[0]+coins[1]+coins[2];
        Integer h2=coins[3]+coins[4]+coins[5];
        Integer h3=coins[0]+coins[3];
        Integer h4=coins[1]+coins[4];

        switch (h1.compareTo(h2)){
            case 0:
                if (coins[6]>coins[7]){
                    compare(coins,6,7,0,fake);
                }else {
                    compare(coins,7,6,0,fake);
                }
                break;
            case 1:
                switch (h3.compareTo(h4)){
                    case 0:
                        compare(coins,2,5,0,fake);
                        break;
                    case 1:
                        compare(coins,0,4,1,fake);
                        break;
                    case -1:
                        compare(coins,1,3,0,fake);
                        break;
                }
                break;
            case -1:
                switch (h3.compareTo(h4)){
                    case 0:
                        compare(coins,5,2,0,fake);
                        break;
                    case 1:
                        compare(coins,3,1,2,fake);
                        break;
                    case -1:
                        compare(coins,4,0,2,fake);
                        break;
                }
                break;
        }
    }

    public static void main(String[] args) {
        compare(new int[]{10,10,11,10,10,10,10,10},
                (index, isBigger)->{
            System.out.printf("coin %d is much %s",index, isBigger?"heavier":"lighter");
                });
    }
}
