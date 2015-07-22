import javafx.scene.transform.Rotate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by celine on 2015/7/21.
 */
public class InputFileReader {
    public int[][] readFile(String filePath){
        int[][] graph=new int[5][5];
        int n = graph.length;
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                graph[i][j] = -1;//init array distance
            }
        }
        try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //check file exists
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//code
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    //System.out.println(lineTxt);
                    parseCode(lineTxt,graph);
                }
                read.close();
            }else{
                System.out.println("can't find file");
            }
        } catch (Exception e) {
            System.out.println("read file wrong");
            e.printStackTrace();
        }
        return graph;
    }
    private static int[][] parseCode(String fileText,int [][] graph){
        String[] routeKeys = fileText.split(", ");
        int [][] routArray =graph;
        for(String routekey : routeKeys){
            char[] keys = routekey.toCharArray();
            int fromKey = getNodeIndex(keys[0]) ;
            int toKey = getNodeIndex(keys[1]) ;
            int distance = Integer.parseInt(keys[2]+"");
            routArray[fromKey][toKey] = distance;
        }
        return routArray;
    }
    public static int getNodeIndex(char node){
        return node - 'A';
    }
    public static char getNodeChar(int index){
        return (char) ('A'+ index );
    }
}
