package engr9791;

public class Cup {
    private final int capacity;
    private int currentVolume;

    /**
     * Construct a cup
     *
     * @param capacity the capacity of the cup.
     * @Exception If amount is negative throws an IllegalArgumentException.
     */
    public Cup(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.currentVolume = 0;
    }

    /**
     * Fill the cup to a given amount
     *
     * @param amount the amount to fill the cup.
     * @Exception If amount is negative or amount plus the current volume
     * exceeds the capacity throws an IllegalArgumentException
     */
    public void fill(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non-negative");
        }
        if (currentVolume + amount > capacity) {
            throw new IllegalArgumentException("Exceeds cup capacity");
        }
        currentVolume += amount;
    }

    /**
     * Empty this cup.
     */
    public void empty() {
        currentVolume = 0;
    }

    /**
     * Get the volume of liquid this cup can hold
     *
     * @return the capacity of this cup
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Get the current volume of liquid in this cup
     *
     * @return the current volume of liquid in this cup
     */
    public int getCurrentVolume() {
        return currentVolume;
    }

    /**
     * Is this cup empty - the current volume of liquid is zero.
     *
     * @return whether the cup is empty
     */
    public boolean isEmpty() {
        return currentVolume == 0;
    }

    /**
     * Is this cup full - the current volume of liquid is equal to the capacity
     *
     * @return whether the cup is full
     */
    public boolean isFull() {
        return currentVolume == capacity;
    }
}
