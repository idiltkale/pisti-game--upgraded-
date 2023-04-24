public class Counter {
    public static int onec ;
    public static int twoc ;
    public static int threec;
    public static int fourc ;
    public static int fivec;
    public static int sixc ;
    public static int sevenc ;
    public static int eightc ;
    public static int ninec ;
    public static int tenc ;
    public static int kingc ;
    public static int queenc ;
    public static int jokerc ;
    public static String PlayThisCard;



    //integer arrayi içine al 1 0 olsun 2 1 olsun etc

    public static void CountForComp(String value){
        if     (value.charAt(1)=='A') onec+=1;
        else if(value.charAt(1)=='2') twoc+=1;
        else if(value.charAt(1)=='3') threec+=1;
        else if(value.charAt(1)=='4') fourc+=1;
        else if(value.charAt(1)=='5') fivec+=1;
        else if(value.charAt(1)=='6') sixc+=1;
        else if(value.charAt(1)=='7') sevenc+=1;
        else if(value.charAt(1)=='8') eightc+=1;
        else if(value.charAt(1)=='9') ninec+=1;
        else if(value.charAt(1)=='1') tenc+=1;
        else if(value.charAt(1)=='K') kingc+=1;
        else if(value.charAt(1)=='Q') queenc+=1;
        else if(value.charAt(1)=='J') jokerc+=1;
    }
    public static String CheckCounts(String cmpcards) {
        if(cmpcards!=null) {
            if     (cmpcards.charAt(1)=='A' && onec==4) PlayThisCard = cmpcards;
            else if(cmpcards.charAt(1)=='2' && twoc==4) PlayThisCard = cmpcards;
            else if(cmpcards.charAt(1)=='3' && threec==4) PlayThisCard = cmpcards;
            else if(cmpcards.charAt(1)=='4' && fourc==4) PlayThisCard = cmpcards;
            else if(cmpcards.charAt(1)=='5' && fivec==4) PlayThisCard = cmpcards;
            else if(cmpcards.charAt(1)=='6' && sixc==4) PlayThisCard = cmpcards;
            else if(cmpcards.charAt(1)=='7' && sevenc==4) PlayThisCard = cmpcards;
            else if(cmpcards.charAt(1)=='8' && eightc==4) PlayThisCard = cmpcards;
            else if(cmpcards.charAt(1)=='9' && ninec==4) PlayThisCard = cmpcards;
            else if(cmpcards.charAt(1)=='1' && tenc==4) PlayThisCard = cmpcards;
            else if(cmpcards.charAt(1)=='K' && kingc==4) PlayThisCard = cmpcards;
            else if(cmpcards.charAt(1)=='Q' && queenc==4) PlayThisCard = cmpcards;
            else if(cmpcards.charAt(1)=='J' && jokerc==4) PlayThisCard = cmpcards;
        }
        return PlayThisCard;
    }
}

