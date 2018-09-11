
// This is an interesting program, that I wrote long ago. Run it, see if you can figure out what's going on.
// The 0's are unoccupied points, the 4's (4 is chosen for perceptual salience) are points occupied by a "color", and thus the rays report 1 when they hit them

package Kermo_Evolution;


import java.util.Arrays;


public class RayTracer_Concept 
{
    
    static int [] Angles = { 30, 45, 60, 75, 105, 120, 135, 150 } ;
    static int [] Frame = new int [8];
    
    public static void main (String [] args)
    {
        System.out.println("This is a simplified 2d test of a ray-tracing algorithmic paradigm: ");
        World W = new World();
        
        for (int i = 325; i < 350; ++i)           // the purpose of the procreding for-loops is to arbitrarily color certain points
            for (int j = 375; j < 400; ++j)
                W.points[i][j].setColor(4);     // 4 is chosen because it is visually contrastive to 0
        
        for (int i = 375; i < 400; ++i)
            for (int j = 75; j < 125; ++j)
                W.points[i][j].setColor(4);
        
        for (int i = 400; i < 425; ++i)
            for (int j = 300; j < 350; ++j)
                W.points[i][j].setColor(4);
        
        for (int i = 400; i < 425; ++i)
            for (int j = 450; j < 475; ++j)
                W.points[i][j].setColor(4);
        
        for (int i = 450; i < 475; ++i)
            for (int j = 50; j < 75; ++j)
                W.points[i][j].setColor(4);
        
        for (int i = 450; i < 500; ++i)
            for (int j = 400; j < 425; ++j)
                W.points[i][j].setColor(4);
        
        
        TraceRays(W);
        
        System.out.println();
        System.out.println("Now, let's have a look at the frame created from the position of the camera: ");
        System.out.println(Arrays.toString(Frame));
    }
    
    static void TraceRays(World w)
    {
        boolean rayFound = false;
        int b = w.C.origin.Y;
        System.out.println("b = " + b);
        
        for (int i = 0; i < 500; ++i) System.out.print(i + "  ");
        System.out.println();
        
        for (int i = 0; i < 500; ++i)
        {
            System.out.print (i + "   ");
            for (int j = 0; j < 500; ++j)
            {
                    int tan30 = (int)(Math.tan(30) * j + b);
                    int tan45 = (int)(Math.tan(45) * j + b);
                    int tan60 = (int)(Math.tan(60) * j + b);
                    int tan75 = (int)(Math.tan(75) * j + b);
                    int tan105 = (int)(Math.tan(105) * j + b);
                    int tan120 = (int)(Math.tan(120) * j + b);
                    int tan135 = (int)(Math.tan(135) * j + b);
                    int tan150 = (int)(Math.tan(150) * j + b);
                    
                    
                    
                    if (tan30 >= i - 2  &&  tan30 <= i + 2) 
                    {
                        System.out.print("RT  ");
                        if (w.points[i][j].C > 0) Frame[0] = 1;
                    } 
                        
                    else if (tan45 >= i - 2  &&  tan45 <= i + 2) 
                    {
                        System.out.print("RT  ");
                        if (w.points[i][j].C > 0) Frame[1] = 1;
                    } 
                    else if (tan60 >= i - 2  &&  tan60 <= i + 2) 
                    {
                        System.out.print("RT  ");
                        if (w.points[i][j].C > 0) Frame[2] = 1;
                    } 
                    else if (tan75 >= i - 2  &&  tan75 <= i + 2) 
                    {
                        System.out.print("RT  ");
                        if (w.points[i][j].C > 0) Frame[3] = 1;
                    } 
                    else if (tan105 >= i - 2  &&  tan105 <= i + 2) 
                    {
                        System.out.print("RT  ");
                        if (w.points[i][j].C > 0) Frame[4] = 1;
                    } 
                    else if (tan120 >= i - 2  &&  tan120 <= i + 2) 
                    {
                        System.out.print("RT  ");
                        if (w.points[i][j].C > 0) Frame[5] = 1;
                    } 
                    else if (tan135 >= i - 2  &&  tan135 <= i + 2) 
                    {
                        System.out.print("RT  ");
                        if (w.points[i][j].C > 0) Frame[6] = 4;
                    } 
                    else if (tan150 >= i - 2  &&  tan150 <= i + 2) 
                    {
                        System.out.print("RT  ");
                        if (w.points[i][j].C > 0) Frame[7] = 4;
                    } 
                    
                    
                    
                    
                    else System.out.print(w.points[i][j].C + "  ");
                    
            } System.out.println();
        }
    }
    
    
    static class World
    {
        static Point [][] points;
        Camera C;
        
        World()
        {
            points = new Point[500][500];
            
            for (int i = 0; i < 500; ++i)
                for (int j = 0; j < 500; ++j)
                    points[i][j] = new Point(i, j, 0);     // init the world as a 2d array of points each with a 0 default color value
            
            C = new Camera();
        }
        
        
    }
    static class Point
    {
        int X;
        int Y;
        int C;
        
        Point(int x, int y, int c)
        {
            X = x;
            Y = y;
            C = c;
        }
        
        void setColor(int c)
        {
            C = c;
        }
    }
    
    static class Camera
    {
        Point origin;
        int FoV = 120;
        int Rays = 8;
        
        Camera()
        {
            origin = World.points[250][250];   // init the camera at the midpoint of both axes of the world i.e. the center
        }
    }
}