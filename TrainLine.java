public class TrainLine {

    private static final String DEFAULT_NAME = "Hogwarts Express";

    /** The name of the train line */
    private String name;
    /** The head station of the train line */
    private Station head;
    /** station at the end. */
    private Station tail;
    /** Current number of stations in the line */
    private int numberOfStations;

    /** Basic constructor */
    public TrainLine(String name) {
        this.name = name;
        this.head = null;
        this.tail = null;
        this.numberOfStations = 0;
    } // basic constructor

    /** Default constructor */
    public TrainLine() {
        this(DEFAULT_NAME);
    } // default constructor

    /** Accessor for the number of stations */
    public int getNumberOfStations() {
        return this.numberOfStations;
    }

    /**
     * Adds a new station after the last station of a trainline.
     * adding the private tail field and initializing it alongside head, keep a direct reference to the end of the list, or be able to start at the tail.
     * @param name String with name of new station to create and add
     */
    public void add(String name) {
        Station newStation = new Station(name);
        if (this.head == null) {
            // No stations exist in this line. Make this new station
            // point to head or tail
            this.head = newStation;
            this.tail = newStation;
        } else {
            // Remove the head traversal and replace it. Remember the last node, thus whenever a new station is added you can access the tail and not start from its head.
            //Add after the tail station.
            tail.setNext(newStation);
            //update this as the current last station.
              tail = newStation;
            }
        this.numberOfStations = this.numberOfStations+1; 
        // or this.numberOfStations++;
        // or this.numberOfStatiosn += 1;
    } // method add

    /**
     * Finds how many stations are in a train line
     * 
     * METHOD MADE OBSOLETE BY INTRODUCTING TrainLine.numberOfStations
     */
    public int stationCounter() {
        int counter = 0;
        if (this.head != null) {
            // Train line not empty
            Station cursor = this.head;
            while (cursor != null) {
                counter = counter + 1;
                cursor = cursor.getNext();
            }
        }
        return counter;
    } // method countStations


    /**
     * String representation of the object
     */
    private static final String EMPTY_TRAIN_LINE = "The train line is empty";
    private static final String TRAIN_LINE_HEADER = "\"%s\" has the following stations: %s";
    private static final String NEXT_ARROW = " --> ";

    public String toString() {
        if (head == null) {
            return EMPTY_TRAIN_LINE;
        } else {
            String stations = String.format(TRAIN_LINE_HEADER, this.name, this.head.getName());
            Station cursor = this.head.getNext();
            while (cursor != null) {
                stations = stations + NEXT_ARROW + cursor.getName();
                cursor = cursor.getNext();
            }
            return stations;
        }
    } // method toString
} // class TrainLine
