import com.sun.prism.ReadbackRenderTarget;

/**
 * Created by celine on 2015/7/21.
 */
public class RouteService {

    private int [][] graph;
    private int [][] dis;
    public void setGraph(int[][] graph) {
        this.graph = graph;
    }
    private int bestCost = Integer.MAX_VALUE;
    private String bestPath;
    /*
    * support 6
    * */
    public void dfs(char start,char end,String path, int maxStops){
        int startIndex = InputFileReader.getNodeIndex(start);
        int lastIndex = InputFileReader.getNodeIndex(end);
        path  += start;
        if (path.length()-1>maxStops) return;
        if (path.length()>1 && path.charAt(path.length()-1) == end){
            System.out.println(path+", "+path.length());
        }

        for ( int i=0; i<graph[startIndex].length; i++ )
        {
            if (graph[startIndex][i] > 0) {
                char newChar = InputFileReader.getNodeChar(i);
                dfs(newChar, end, path, maxStops);
            }
        }
    }

    public void dfsExact(char start,char end,String path, int Stops){
        int startIndex = InputFileReader.getNodeIndex(start);
        path  += start;
        if (path.length()==Stops){
            if (start == end){
                System.out.println(path+", "+path.length());
            }
            return;
        }
        for ( int i=0; i<graph[startIndex].length; i++ )
        {
            if (graph[startIndex][i] > 0) {
                char newChar = InputFileReader.getNodeChar(i);
                dfsExact(newChar, end, path, Stops);
            }
        }
    }
    public int dfsCost(char start,char end,String path, int cost){
        int startIndex = InputFileReader.getNodeIndex(start);
        path  += start;
        if (path.length()>1){
            if (start == end && cost<bestCost && cost>0){
                System.out.println(path+", "+cost);
                bestCost = cost;
                bestPath = path;
                return cost;
            }

        }
        for ( int i=0; i<graph[startIndex].length; i++ )
        {
            if (graph[startIndex][i] > 0) {
                char newChar = InputFileReader.getNodeChar(i);
                int newCost = graph[startIndex][i];
                if (newCost>0){
                    dfsCost(newChar, end, path, newCost+cost);
                }

            }
        }
        return cost;
    }
    public int dfsLimitedCost(char start,char end,String path, int cost){
        int startIndex = InputFileReader.getNodeIndex(start);
        path  += start;
        if (cost>30){
            return cost;
        }
        if (path.length()>1){
            if (start == end  && cost>0){
                System.out.println(path+", "+cost);
            }

        }
        for ( int i=0; i<graph[startIndex].length; i++ )
        {
            if (graph[startIndex][i] > 0) {
                char newChar = InputFileReader.getNodeChar(i);
                int newCost = graph[startIndex][i];
                if (newCost>0){
                    dfsLimitedCost(newChar, end, path, newCost+cost);
                }

            }
        }
        return cost;
    }
    /*
    * support 1~5 questions
    * */
    public int routeFormAtoB(char A,char B){
        int x = InputFileReader.getNodeIndex(A);
        int y = InputFileReader.getNodeIndex(B);
        return graph[x][y];
    }
    public int shortestFormAtoB(char A,char B){
        int x = InputFileReader.getNodeIndex(A);
        int y = InputFileReader.getNodeIndex(B);
        return dis[x][y];
    }

}
