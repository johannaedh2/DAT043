import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.System.*;

/*
 *  Program to simulate segregation.
 *  See : http://nifty.stanford.edu/2014/mccown-schelling-model-segregation/
 *
 * NOTE:
 * - JavaFX first calls method init() and then method start() far below.
 * - To test uncomment call to test() first in init() method!
 *
 */
// Extends Application because of JavaFX (just accept for now)
public class Neighbours extends Application {
    final static Random rand = new Random();

    class Actor {
        final Color color;        // Color an existing JavaFX class
        boolean isSatisfied;      // false by default

        Actor(Color color) {      // Constructor to initialize
            this.color = color;
        }
    }

    // Below is the *only* accepted instance variable (i.e. variables outside any method)
    // This variable may *only* be used in methods init() and updateWorld()

    Actor[][] world; // The world is a square matrix of Actors


    // This is the method called by the timer to update the world
    // (i.e move unsatisfied) approx each 1/60 sec.
    void updateWorld() {
        // % of surrounding neighbours that are like me
        double threshold = 0.7;
        world = nextState(world, threshold);
    }

    // This method initializes the world variable with a random distribution of Actors
    // Method automatically called by JavaFX runtime
    // That's why we must have "@Override" and "public" (just accept for now)
    @Override
    public void init() {
        //test();    // <---------------- Uncomment to TEST!
        // %-distribution of RED, BLUE and NONE
        double[] dist = {0.25, 0.25, 0.5};
        // Number of locations (places) in world (must be a square)
        int nLocations = 900;   // Should also try 90 000

        Actor[] arr = getActors(dist, nLocations);
        arr = shuffle(arr);
        world = toMatrix(arr);

        // Should be last
        fixScreenSize(nLocations);
    }


    // --------------- Methods ------------------------------

    // TODO Many ... |

    Actor[][] nextState(Actor[][] oldWorld, double threshold) {
        int size = oldWorld.length;
        Actor[][] newWorld = new Actor[size][size];

        int[] oneToNumnulls = numNullsArr(numNulls(oldWorld));
        oneToNumnulls = shuffleInt(oneToNumnulls);
        int index = 0;
        int[] rr = rowIndexForNulls(oldWorld);
        int[] cc = colIndexForNulls(oldWorld);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (newWorld[row][col] == null) {
                    if (oldWorld[row][col] == null) {
                        newWorld[row][col] = null;
                    } else {
                        if (!isSatisfied(oldWorld, oldWorld[row][col], row, col, threshold).isSatisfied) {
                            int hej = oneToNumnulls[index];
                            int r = rr[hej];
                            int c = cc[hej];
                            newWorld[r][c] = oldWorld[row][col];
                            newWorld[row][col] = null;
                            index++;
                        }
                        else {
                           newWorld[row][col] = oldWorld[row][col];
                        }
                    }
                }
            }
        }
        return newWorld;
    }

    Actor[] getActors(double[] d, int nLocations) {
        int numred = (int) Math.round(d[0]*nLocations);
        int numblue = (int) Math.round(d[1]*nLocations);
        Actor reds = new Actor(Color.FUCHSIA);
        Actor blues = new Actor(Color.CORAL);

        Actor[] arr = new Actor[nLocations];
        for (int i=0; i<nLocations; i++) {
            if (i<numred) {
                arr[i] = reds;
            }
            else if (i >= numred & i<numred+numblue) {
                arr[i] = blues;
            }
            else arr[i] = null;
        }
        return arr;
    }

    int numNulls(Actor[][] actors) {
        int n=0;
        for (int row=0; row < actors.length; row++) {
            for (int col = 0; col < actors[0].length; col++) {
                if (actors[row][col] == null) {
                    n++;
                }
            }
        }
        return n;
    }

    int[] rowIndexForNulls(Actor[][] actors) {
        int index = 0;
        int[] rows = new int[numNulls(actors)];
        for (int row=0; row< actors.length; row++) {
            for (int col=0; col<actors[0].length; col++) {
                if (actors[row][col] == null) {
                    rows[index] = row;
                    index++;
                }
            }
        }
        return rows;
    }

    int[] colIndexForNulls(Actor[][] actors) {
        int index = 0;
        int[] cols = new int[numNulls(actors)];
        for (int row=0; row < actors.length; row++) {
            for (int col=0; col<actors[0].length; col++) {
                if (actors[row][col] == null) {
                    cols[index] = col;
                    index++;
                }
            }
        }
        return cols;
    }

    int numNeighbours(Actor[][] actors, int r,int c) {
        int count = 0;
        for (int i=r-1; i<=r+1; i++) {
            for (int j=c-1; j<=c+1; j++) {
                if (isValidLocation(actors.length, i,j) && actors[i][j] != null) {
                    count++;
                }
            }
        }
        count--;
        if (count <= 0) {
            return 100;
        }
        return count;
    }

    Actor isSatisfied(Actor[][] actors, Actor a,int r, int c,double threshold) {
        int count = 0;
        int n = numNeighbours(actors,r,c);
        if (a == null) {
            a.isSatisfied = true;
            return a;
        }
        for (int i=r-1; i<=r+1; i++) {
            for (int j=c-1; j<=c+1; j++) {
                if (isValidLocation(actors.length, i,j) && (actors[i][j] != null) && actors[i][j].color == a.color) {
                            count++;
                    }
                }
            }
        count--;
        int x = (int) Math.round(n*threshold);
        if (count >= x) {
            a.isSatisfied = true;
            return a;
        } else {
            a.isSatisfied = false;
            return a;
        }
    }

    Actor[] shuffle(Actor[] actors) {
        for (int i=actors.length; i>1; i--) {
            int j = rand.nextInt(i);
            Actor tmp = actors[j];
            actors[j] = actors[i-1];
            actors[i-1] = tmp;
        }
        return actors;
    }

    int[] shuffleInt(int[] y) {
        for (int i=y.length; i>1; i--) {
            int j = rand.nextInt(i);
            int tmp = y[j];
            y[j] = y[i-1];
            y[i-1] = tmp;
        }
        return y;
    }

    int[] numNullsArr(int n) {
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    Actor[][] toMatrix(Actor[] actors) {
        int size = (int) sqrt(actors.length);
        Actor[][] worldMatrix = new Actor[size][size];
        for (int j=0; j<actors.length; j++) {
            worldMatrix[j/size][j%size] = actors[j];
        }
        return worldMatrix;
    }

    // Check if inside world
    boolean isValidLocation(int size, int row, int col) {
        return 0 <= row && row < size && 0 <= col && col < size;
    }

    // ----------- Utility methods -----------------

    // TODO (general method possible reusable elsewhere)

    // ------- Testing -------------------------------------

    // Here you run your tests i.e. call your logic methods
    // to see that they really work. Important!!!!
    void test() {
        // A small hard coded world for testing
        Actor[][] testWorld = new Actor[][]{
                {new Actor(Color.RED), new Actor(Color.RED), null},
                {null, new Actor(Color.BLUE), new Actor(Color.BLUE)/*null*/},
                {new Actor(Color.RED), null, new Actor(Color.BLUE)}
        };
        double th = 0.5;   // Simple threshold used for testing

        int size = testWorld.length;
        //out.println(isValidLocation(size, 0, 0));
        //out.println(!isValidLocation(size, -1, 0));
        //out.println(!isValidLocation(size, 0, 3));

        // TODO

        //Actor[][] bajs = nextState(testWorld, 0.5);

        out.println(isSatisfied(testWorld,testWorld[1][1],1,1, 0.7).isSatisfied);



        //out.println(Arrays.toString((nextState(testWorld,th))[0]));
        /*for (int k=0; k< bajs.length; k++) {
            out.println(Arrays.toString(bajs[k]));
        }*/
        //out.println(isSatisfied(testWorld,testWorld[0][1],0,1,0.5));

        //out.println(Arrays.toString(rowIndexForNulls(testWorld)));
        //out.println(Arrays.toString(colIndexForNulls(testWorld)));
        //out.println(numNulls(testWorld));

        exit(0);
    }

    // ******************** NOTHING to do below this row, it's JavaFX stuff  **************

    double width = 500;   // Size for window
    double height = 500;
    final double margin = 50;
    double dotSize;

    void fixScreenSize(int nLocations) {
        // Adjust screen window
        dotSize = 9000 / nLocations;
        if (dotSize < 1) {
            dotSize = 2;
        }
        width = sqrt(nLocations) * dotSize + 2 * margin;
        height = width;
    }

    long lastUpdateTime;
    final long INTERVAL = 450_000_000;


    @Override
    public void start(Stage primaryStage) throws Exception {

        // Build a scene graph
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        root.getChildren().addAll(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create a timer
        AnimationTimer timer = new AnimationTimer() {
            // This method called by FX, parameter is the current time
            public void handle(long now) {
                long elapsedNanos = now - lastUpdateTime;
                if (elapsedNanos > INTERVAL) {
                    updateWorld();
                    renderWorld(gc);
                    lastUpdateTime = now;
                }
            }
        };

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation");
        primaryStage.show();

        timer.start();  // Start simulation
    }


    // Render the state of the world to the screen
    public void renderWorld(GraphicsContext g) {
        g.clearRect(0, 0, width, height);
        int size = world.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int x = (int) (dotSize * col + margin);
                int y = (int) (dotSize * row + margin);
                if (world[row][col] != null) {
                    g.setFill(world[row][col].color);
                    g.fillOval(x, y, dotSize, dotSize);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
