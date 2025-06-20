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
        if (this.head == null) { //If the head is empty 
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
        this.numberOfStations = this.numberOfStations + 1;
        // or this.numberOfStations++;
        // or this.numberOfStatiosn += 1;
    } // method add

    /**
     * Finds where a station is by name
     * Search for the station using @param
     * @return the position or use -1 if no station is found.
     */
    public int indexOf(String name) {
    Station current = head; //The head position is at 0.
    int position = 0;
    while (current != null) { //Find the position of the current station name.
        if (current.getName().equals(name)) { //Check if the name you are searching for matches that current staiton name and record the postion.
            return position;
        }
        current = current.getNext(); //Keep looking until the name matches with searched station name.
        position++; //The position will increase by 1 from the head.
    }
    return -1; //The station is not found.
}
/**Use the logic and compare it to the Station Names used in the Trainline_Implementation Names */
        public boolean contains(String name) { //If the logic above is true and contaions that station name the postion will not return 0.
        return indexOf(name) != -1;
    }
    /**
     * Finds how many stations are in a train line
     * 
     * METHOD MADE OBSOLETE BY INTRODUCTING TrainLine.numberOfStations
     */
        public int stationCounter() {
        int counter = 0;
        Station cursor = head;
        while (cursor != null) {
            counter++;
            cursor = cursor.getNext();
        }
        return counter;
    }


    /**
     * String representation of the object
     */
    private static final String EMPTY_TRAIN_LINE = "The train line is empty";
    private static final String TRAIN_LINE_HEADER = "\"%s\" has the following stations: %s";
    private static final String NEXT_ARROW = " --> ";

        public String toString() {
        if (this.head == null) { //if it is empty use the empty string format messages.
            return EMPTY_TRAIN_LINE; //The message will say The train line is empty.
        } else {//If not use the Station Name format. Red Line Southbound has the following stations.
            String stations = String.format(TRAIN_LINE_HEADER, this.name, this.head.getName());
            Station cursor = this.head.getNext();
            while (cursor != null) {
                stations = stations + NEXT_ARROW + cursor.getName();//Name of station, arrow, next station until the last station has been named.
                cursor = cursor.getNext();
            }
            return stations;
        }

            }   //method toString()
         } //class TrainLine
