/**
 * Created by celine on 2015/7/21.
 */
public class OutputResult {

    public void trainOutput(){
        //Output #1:
        String filename ="input.txt" ;
        String fileFullPath = this.getClass().getResource(filename).getPath();
        InputFileReader ifr = new InputFileReader();
        int[][] graph = ifr.readFile(fileFullPath);
        RouteService routeService = new RouteService();
        routeService.setGraph(graph);


    }
}
