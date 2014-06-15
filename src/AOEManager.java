/*********************************************************************
Project: Task Manager

*********************************************************************/


import java.util.* ;
import java.awt.* ;

public class AOEManager
{
   private Vector vVertex;   // Set of Event
   private Vector vEdge;     // Set of Edge

   private WeightedDirectedGraph graph ;

   private VectorStack stack ;

   private boolean isTesting = false ;  // Turn Testing On and Off

   public AOEManager()
   {
      vVertex = new Vector();
      vEdge = new Vector();
   }

   // Draw the activity network
   public void draw ( Graphics g )
   {

      for ( int i =  0 ; i < vVertex.size() ; i ++ )
        ((Vertex)vVertex.elementAt(i)).draw(g);

      for ( int i =  0 ; i < vEdge.size() ; i ++ )
        ((Edge)vEdge.elementAt(i)).draw(g);
   }

   public void addVertex ( int x , int y , int id )
   {

      vVertex.add(new Vertex(x,y,id ));
   }

   public void addEdge ( Vertex v1 ,  Vertex v2 , int timeActivity, int iDedge )
   {
      vEdge.add(new Edge(v1,v2, timeActivity,iDedge));
   }

   // Return a specific Vertex if x and y are within the circle
   public Vertex findVertex ( int x , int y )
   {
    for ( int i =0; i < vVertex.size()  ; i++ )
    {
      if (((Vertex)vVertex.elementAt(i)).isInclude( x , y ))
      {

        return (Vertex)vVertex.elementAt(i);
      }
    }
    return null;
  }
  // Return a specific Vertex if the point are along the Edge
   public Edge findEdge ( Point pt )
  {
    for ( int i =0; i < vEdge.size()  ; i++ )
    {
      if (((Edge)vEdge.elementAt(i)).isInclude( pt))
      {

        return (Edge)vEdge.elementAt(i);
      }
    }
    return null;
  }

  public void criticalPath ()
  {
    if ( vVertex.isEmpty() )
      return ;


   // Missing Code
   // Task 2.1 in the Dialog Message



    forwardStage ();

    // Missing Code
    // Task 2.3 in the Dialog Message

    backwardStage ();



  }


  public void forwardStage ()
  {

     // Missing Code

     testing (isTesting);



  }

  public void backwardStage ()
  {

      // Missing Code ;
      testing ( isTesting );

  }

  public void resetEarlyLateTime ()
  {
    for ( int i = 0 ; i < vVertex.size() ; i ++ )
    {
      Vertex current = (Vertex)vVertex.elementAt(i);
      current.reset();


    }

  }


  public void testing ( boolean testing)
  {
    if (  testing )
    {

      System.out.println("Testing Forward Stage");

       for ( int i = 0 ; i < vVertex.size() ; i ++ )
      {
        Vertex vtry =      ((Vertex)vVertex.elementAt(i))  ;
        System.out.println(vtry.getEarliestEvent());
      }

      System.out.println("Testing BackWard Stage");

      for ( int i = 0 ; i < vVertex.size() ; i ++ )
      {
        Vertex vtry =      ((Vertex)vVertex.elementAt(i))  ;
        System.out.println(vtry.getLatestEvent());
      }
    }
  }
}
