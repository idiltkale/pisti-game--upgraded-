import java.util.ArrayList;

public class Counter {

    private static int[] counter = new int[13];
    public static String play = null;

    public static int[] getCounter() {
        return counter;
    }

    public void setCounter(int[] counter) {
        this.counter = counter;
    }
    public static void CountForComp(String value){
        char a = value.charAt(1);
        for(int i=2;i<10;i++){
            if(a == 'A') {
                getCounter()[0]++;
                break;
            } else if(a == '1'){
                getCounter()[9]++;
                break;
            } else if(a == 'J'){
                getCounter()[10]++;
                break;
            } else if(a == 'Q'){
                getCounter()[11]++;
                break;
            } else if(a == 'K'){
                getCounter()[12]++;
                break;
            } else if(Integer.parseInt(String.valueOf(a)) == i)  {
                getCounter()[i-1]++;
                break;
            }
        }
    }
    public static String CheckCounts(ArrayList<String> cards) {
        int max =0;
        for(int j=0;j<cards.size();j++){
            for(int i=2;i<10;i++){
                char a = cards.get(j).charAt(1);
                if(a=='A' && getCounter()[0]>max){
                    max = getCounter()[0];
                    play =cards.get(j);
                }
                if (a== '1' && getCounter()[9]>max) {
                    max = getCounter()[9];
                    play =cards.get(j);
                }
                if (a== 'J' && getCounter()[10]>max) {
                    max = getCounter()[10];
                    play =cards.get(j);
                }
                if (a== 'Q' && getCounter()[11]>max) {
                    max = getCounter()[11];
                    play =cards.get(j);
                }
                if (a== 'K' && getCounter()[12]>max) {
                    max = getCounter()[12];
                    play = cards.get(j);
                }
                if(!Character.isLetter(a)){
                    if (Integer.parseInt(String.valueOf(a))== i && getCounter()[i]>max) {
                        max = getCounter()[i-1];
                        play =cards.get(j);
                    }
                }
            }
        }
       // System.out.println("MAX OLAN KARTTTTT" + play +" Sayısı daaa: " + max);
        return play;
    }
    public static void printcounter(){
        System.out.println("A--" + getCounter()[0]);
        System.out.println("2--" + getCounter()[1]);
        System.out.println("3--" + getCounter()[2]);
        System.out.println("4--" + getCounter()[3]);
        System.out.println("5--" + getCounter()[4]);
        System.out.println("6--" + getCounter()[5]);
        System.out.println("7--" + getCounter()[6]);
        System.out.println("8--" + getCounter()[7]);
        System.out.println("9--" + getCounter()[8]);
        System.out.println("10--" + getCounter()[9]);
        System.out.println("J--" + getCounter()[10]);
        System.out.println("Q--" + getCounter()[11]);
        System.out.println("K--" + getCounter()[12]);
    }
}