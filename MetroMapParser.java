import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This class reads a text description of a metro subway system
 * and generates a graph representation of the metro.
 *
 * Students should feel free to modify this code as needed
 *  to complete this exercise.
 *
 *<p>
 *
 * The grammar for the file is described below in BNF. A typical line
 * in the file looks like this :
 *
 * <code> 20 NorthStation   Green 19 22  Orange 15 22  </code>
 *
 * where :
 *         20 is the StationID
 *         NorthStation is the StationName
 *         Green 19 22
 *                  Green is the LineName
 *                  19 is the StationID of the outbound station
 *                  22 is the StationID of the inbound station
 *         Orange 15 22 is a LineID in which :
 *                  Orange is the LineName
 *                  15 is the StationID of the outbound station
 *                  22 is the StationID of the inbound station
 *
 *         Therefore, NorthStation has two outgoing lines.
 *
 *  note : 0 denotes the end of a line : i.e. in this case,
 *  OakGrove would be at the end of the line, as there is no other outbound
 *  station.
 *
 *<p>
 * metro-map ::= station-spec* <BR>
 * station-spec ::= station-id station-name station-line+ <BR>
 * station-id ::= (positive integer) <BR>
 * station-name ::= string <BR>
 * station-line ::= line-name station-id station-id <BR>
 *
 */



public class MetroMapParser
{

    private BufferedReader fileInput;
    private Graph graph;


    /**
     * @effects: creates a new parser that will read from the file
     * filename unless the file does not exist. The filename should specify
     * the exact location of the file. This means it should be something like
     * /mit/$USER/6.170/ex3/bostonmetro.txt
     *
     *
     * @throws java.io.IOException if there <tt>filename</tt> cannot be read
     *
     * @returns a new MetroMapParser that will parse the file filename"filename")
     */

    public MetroMapParser(String filename, Graph graph) throws IOException
    {
        //a buffered reader reads line by line, returning null when file is done
        fileInput = new BufferedReader(new FileReader(filename));

        this.graph = graph;

    }


    /**
     * @effects: parses the file, and generates a graph from it, unless there
     * is a problem reading the file, or there is a problem with the format of the
     * file.
     *
     * @throws java.io.IOException if there is a problem reading the file
     * @throws BadFileException if there is a problem with the format of the file
     *
     * @returns the Graph generated by the file
     */

    public Graph generateGraphFromFile()
            throws IOException, BadFileException
    {

        String line = fileInput.readLine();
        StringTokenizer st;
        String stationID;
        String stationName;
        String lineName;
        String outboundID, inboundID;

        while(line != null)
        {

            st = new StringTokenizer(line);

            //We want to handle empty lines effectively, we just ignore them!
            if(!st.hasMoreTokens())
            {
                line = fileInput.readLine();
                continue;
            }

            //from the grammar, we know that the Station ID is the first token on the line
            stationID = st.nextToken();

            int id = Integer.parseInt(stationID);

            if(!st.hasMoreTokens())
            {

                throw new BadFileException("no station name");
            }

            //from the grammar, we know that the Station Name is the second token on the line.
            stationName = st.nextToken();

            graph.addNode(new Station(id,stationName));
            if(!st.hasMoreTokens())
            {
                throw new BadFileException("station is on no lines");
            }


            while(st.hasMoreTokens())
            {
                lineName = st.nextToken();


                if(!st.hasMoreTokens())
                {
                    throw new BadFileException("poorly formatted line info");
                }

                outboundID = st.nextToken();
                int outId = Integer.parseInt(outboundID);//predecessor

                if(!st.hasMoreTokens())
                {
                    throw new BadFileException("poorly formatted adjacent stations");
                }
                inboundID = st.nextToken();
                int inId = Integer.parseInt(inboundID);//successor


                if(outId !=0){


                    graph.addEdge(id,new Line(lineName,new Station(outId,""),new Station(id,"")));

                }

                if(inId!=0){
                    /*adding a new line with station name "" since not all the nodes are created at the time
                so they dont know of their names
                names are set on the setNodeNames method below
                same for the outId
                 */
                    graph.addEdge(id,new Line(lineName,new Station(id,""),new Station(inId,"")));
                }



            }



            line = fileInput.readLine();
        }
        setNodeNames();
        return graph;
    }

    private void setNodeNames(){/*sets the node names */
        for(int i=0; i<graph.getAllConnections().size(); i++){
            for(int j =0; j<graph.getAllConnections().get(i).size(); j++){

                Line line = (Line) graph.getAllConnections().get(i).get(j);
                Station source = (Station) line.getSource();
                Station destination = (Station) line.getDestination();

                source.setName(graph.getNodes().get(source.getID()-1).getName());
                destination.setName(graph.getNodes().get(destination.getID()-1).getName());

            }
        }
    }

}





