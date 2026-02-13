public class Ticket {

    private int ticketId;
    private Passenger passenger;
    private Train train;   
    private int seatNumber;
    private String status;

    public Ticket(int ticketId, Passenger passenger, Train train, int seatNumber, String status) {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.train = train;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Train getTrain() {
        return train;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId +
               ", Train: " + train.getTrainName() +
               ", " + passenger +
               ", Seat No: " + seatNumber +
               ", Status: " + status;
    }
}