import org.junit.Assert;
import org.junit.Test;

/**
 * Created by u6031313 on 7/22/2015.
 */
public class UnitTest {
    @Test
    public void testInput(){
        String filename ="input.txt" ;
        String fileFullPaath = this.getClass().getResource(filename).getPath();
        InputFileReader ifr = new InputFileReader();
        int[][] array = ifr.readFile(fileFullPaath);
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[0].length;j++){
                int dis = array[i][j];
                System.out.print(dis+" ");
            }
            System.out.println();
        }
    }
    @Test
    public void testParse(){
        int rst = 1;
        int expected ='B'-'A' ;
        Assert.assertEquals(expected,rst);
    }
    @Test
    public void testRouteService(){
        String filename ="input.txt" ;
        String fileFullPath = this.getClass().getResource(filename).getPath();
        InputFileReader ifr = new InputFileReader();
        int[][] array = ifr.readFile(fileFullPath);
        RouteService routeService = new RouteService();
        routeService.setGraph(array);
        //routeService.dfs('C','C',"",3);// 6
        //routeService.dfsExact('A','C',"",4); // 7
        //routeService.dfsCost('A','C',"",-1);//8
        //routeService.dfsCost('B','B',"",-1);//9
        //routeService.dfsLimitedCost('C','C',"",0);//10
    }

}
