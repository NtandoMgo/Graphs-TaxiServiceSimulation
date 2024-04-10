import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SimulatorOne{
    public static void main (String[]args)
    {
        Graph map = new Graph();

        Scanner keyboard = new Scanner (System.in);
        int numNodes = keyboard.nextInt();
        keyboard.nextLine();
        String line;
        
        //reading the edges in from the first few (e.g. 5) lines
        for (int i = 0; i <numNodes;i++)
        {
            line = keyboard.nextLine();
            String [] values = line.split(" ");

            if(values.length == 0)
            {
                map.getVertex(values[0]);
            }
            else
            {
                int count = values.length/2, incr =1;

                for (int j = 0; j<count;j++)
                {
                    map.addEdge(values[0],values[incr++],Double.parseDouble(values[incr++]));
                }

            }

        }

        //getting the number of shops and clients [shops first]

        keyboard.nextLine();
        line = keyboard.nextLine();
        String [] shops  = line.split(" ");

        for (String s:shops)
        {
            map.setType(s,'s');
        }

        //gets the client's values in order first sets all of their types to client
        keyboard.nextLine();
        line = keyboard.nextLine();
        String [] clients = line.split(" ");
        for (String c: clients)
        {
            map.setType(c,'c');
        }

        //now process the orders
        for (String client: clients)
        {
            System.out.println("client " + client);

            //finding the nearest taxi to the client
            double minDist = 999999;
            boolean multiple = false; //to see if there are multiple solutions
            ArrayList <String> taxis = new ArrayList<String>();

            //loop through all shop nodes and see which is the closest to the client
            for (String s: shops)
            {
                    map.dijkstra(s);
                    double dist = map.getDist(client);
                    if (dist < minDist)
                    {
                        multiple = false;
                        minDist = dist;
                        taxis.clear();
                        taxis.add(s);
                    }
                    else if (dist == minDist)
                    {multiple = true;
                    taxis.add(s);}

            }


            //finding the shortest route from client to the nearest shop
            ArrayList <String> shopList = new ArrayList<String>();
            minDist = 99999;
            ArrayList<String> arrlist = map.dijkstra(client);
            for(String shop: shops)
            {
                double dist = map.getDist(shop);
                if (dist < minDist)
                {
                    minDist = dist;
                    shopList.clear();
                    shopList.add(shop);
                }
                else if (dist == minDist)
                {
                    shopList.add(shop);
                }
            }


                //printing out commands
                if(shopList.isEmpty() | taxis.isEmpty()) {
                    System.out.println("cannot be helped");
                }
                else
                {
                    //prints out all of the taxis
                    Collections.sort(taxis);
                    for (String s: taxis)
                    {
                        System.out.println("taxi " + s);
                        ArrayList<String> alist = map.dijkstra(s);
                        map.printPath(client,alist);
                        System.out.println("");
                    }

                    for (String s: shopList)
                    {
                        System.out.println("shop " + s);
                        ArrayList<String> alist = map.dijkstra(client);
                        map.printPath(s, alist);
                        System.out.println("");
                    }
                }
        }


    }
}