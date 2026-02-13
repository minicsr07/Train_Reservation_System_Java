public class Train {
    private int trainId;
    private String trainName;
    private int totalSeats;
    private int availableSeats;

    public Train(int trainId, String trainName, int totalSeats, int availableSeats) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public int getTrainId() {
        return trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}