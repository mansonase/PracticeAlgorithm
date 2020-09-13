package old;

public class Flags {
    private static void swap(char[] arr,int x, int y){
        char temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    public static String adjust(String flags){
        char[] fs=flags.toCharArray();

        int b=0,w=0,r=fs.length-1,count=0;

        while (fs[w]=='B'&&w<fs.length){
            b++;
            w++;
        }
        while (fs[r]=='R'&&r>0){
            r--;
        }
        while (w<=r){
            switch (fs[w]){
                case 'W':
                    w++;
                    break;
                case 'B':
                    swap(fs,b,w);
                    b++;
                    w++;
                    count++;
                    break;
                case 'R':
                    swap(fs,r,w);
                    r--;
                    count++;
                    break;
            }
        }
        System.out.println("total swapping times : "+count);
        return new String(fs);
    }

    public static void main(String[] args) {
        String flags="WWWBBWWRRBWRRWRWB";
        System.out.println(adjust(flags));
    }
}
