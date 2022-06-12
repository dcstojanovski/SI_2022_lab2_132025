import java.util.ArrayList;
import java.util.List;

public class SILab2 {

    public static List<String> function(List<String> list) {
        if (list.size() <= 0) {   //7
            throw new IllegalArgumentException("List length should be greater than 0");   //8
        }
        int n = list.size(); //10
        int rootOfN = (int) Math.sqrt(n); //11
        if (rootOfN * rootOfN  != n) {  //12
            throw new IllegalArgumentException("List length should be a perfect square"); //13
        }
        List<String> numMines = new ArrayList<>(); //14
        for (int i = 0; i < n; i++) {   //16.1 -> 16.2 -> 16.3
            if (!list.get(i).equals("#")) { // 17
                int num = 0; //18
                if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ) {  //19
                    if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ){  //20
                        num += 2; //21
                    }
                    else { //23
                        num  += 1; //24
                    }
                }
                if (i - rootOfN >= 0 && list.get(i - rootOfN).equals("#")){ //27
                    num++;  //28
                }
                if (i + rootOfN < n && list.get(i + rootOfN).equals("#")){  //29
                    num++;  //30
                }
                numMines.add(String.valueOf(num));  //31
            }
            else { //35
                numMines.add(list.get(i));  //36
            }
        }
        return numMines; //39
    }
}