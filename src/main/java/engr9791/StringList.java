package engr9791;

/**
 * Class that simulates a list for storing Strings.
 *
 * @author Tanapong Dechsakul (dech0009)
 * @version 1.0
 */
public class StringList {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 4;

    /**
     * The amount to grow this {@code StringList} when {@code grow()} is called.
     */
    private static final int GROW = 5;
    /**
     * The size of the {@code StringList} (the number of elements it contains).
     */
    private int size = 0;
    /**
     * The array buffer into which the elements of the {@code StringList} are stored.
     */
    private String[] elementData;

    //=============== TASK 1 ===============
    //===== Constructor =====
    /**
     * StringList Constructor, an empty StringList with the DEFAULT_CAPACITY.
     */
    public StringList() {
        elementData = new String[DEFAULT_CAPACITY];
    }
    //===== Constructor =====

    /**
     * Increases the capacity of the list to have more space to fit more elements.
     * @return String[] temp, a list with larger capacity.
     */
    private String[] grow() {
        String[] temp = new String[elementData.length + GROW];

        for (int index = 0; index < elementData.length; index++) {
            temp[index] = elementData[index];
        }

        elementData = temp;
        return elementData;
    }

    /**
     * Adding a string element at the end of the list.
     * @param element String value that want to insert within a list.
     * @return Boolean true if the insertion is successful.
     */
    public boolean add(String element) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = element;
        size++;
        return true;
    }

    /**
     * Get the string value regarding the specified index position in the list.
     * @param index number of the element within a list that wanted to get the value.
     * @return String element value of that list's index.
     * @throws IllegalArgumentException if the index param is out of range.
     */
    public String get(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
        return elementData[index];
    }

    /**
     * Converting all elements of the list to be String.
     * @return String value of all elements in the list.
     */
    public String toString() {
        String printOut;

        if (size == 0) {
            printOut = "List is empty: []";

            return printOut;
        }

        printOut = "Printing List: [" + elementData[0];

        for (int index = 1; index < size; index++) {
            printOut += ", " + elementData[index];
        }

        printOut += "]";

        return printOut;
    }

    //=============== TASK 2 ===============
    /**
     * Checking all elements in the list whether the specified element is existed or not.
     * @param element String value that want to check with the list.
     * @return True if the value is existed in the list, otherwise false.
     */
    public boolean contains(String element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) return true;
        }

        return false;
    }

    /**
     * Checking the list on which index that the specified element is existed.
     * @param element String value that want to check with the list.
     * @return int number of index that the value existed in the list, otherwise -1.
     */
    public int indexOf(String element) {
        for (int index = 0; index < size; index++) {
            if (elementData[index].equals(element)) {
                return index;
            }
        }

        return -1;
    }

    /**
     * Set the new String value regarding the specified index and its new element.
     * @param index number of the element within the list that wanted to change the value.
     * @param element new String value that want to set.
     * @return old String value before it will be changed.
     * @throws IllegalArgumentException if the index param is out of range.
     */
    public String set(int index, String element) {
        String output;

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        output = elementData[index];
        elementData[index] = element;

        return output;
    }

    /**
     * Get the size value of the list.
     * @return int, which is the number of elements in the list.
     */
    public int size() {
        return size;
    }

    //=============== Task 3 ===============
    //===== Constructor =====
    /**
     * StringList Constructor, which can set it own size or capacity of the list.
     * @param capacity the size of the String list.
     */
    public StringList(int capacity) {
        elementData = new String[capacity];
    }
    //===== Constructor =====

    /**
     * Adding String value regarding the index and shift other elements to the right.
     * @param index that wants to insert the value.
     * @param element String value that we want to insert.
     * @throws IllegalArgumentException if the index param is out of range.
     */
    public void add(int index, String element) {
        // detect invalid index
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        // increase capacity of the list
        if (size == elementData.length) {
            grow();
        }

        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;
        size++;
    }

    /**
     * Removing an element and shift the remaining elements to the left.
     * @param index where you want to delete the element.
     * @return String value of the element that has been deleted.
     * @throws IllegalArgumentException if the index param is out of range.
     */
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        String ret = elementData[index];

        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        return ret;
    }

    /**
     * Removing an element by specifying the String value.
     * @param element String value that want to delete.
     * @return true if the list has that element, otherwise false.
     */
    public boolean remove(String element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                for (int index = i; index < size - 1; index++) {
                    elementData[index] = elementData[index + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Clear all elements in the list.
     */
    public void clear() {
        size = 0;
    }

    /**
     * Checking if the list is empty.
     * @return true if the list contains no element, otherwise false.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    //=============== Task 4 ===============

    /**
     * Finding the elements starting from the end of the list.
     * @param element String value of the element that wanted to find.
     * @return the last occurrence of the specified element, otherwise -1.
     */
    public int lastIndexOf(String element) {
        for (int index = size - 1; index >= 0; index--) {
            if (elementData[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Showing the StringList with the specified range.
     * @param fromIndex the first index that will be started.
     * @param toIndex the last index that will be stopped (excluded).
     * @return StringList of the portion of the list between the specified fromIndex to toIndex.
     * @throws IllegalArgumentException if fromIndex or toIndex param is out of range.
     * @throws IllegalArgumentException if fromIndex is greater than toIndex.
     */
    public StringList subList(int fromIndex, int toIndex) {
        // If fromIndex and toIndex are equal, then the returned list is empty.
        if (fromIndex == toIndex) {
            return new StringList();
        }
        // If toIndex is less than fromIndex, an IllegalArgumentException should be thrown.
        if (toIndex < fromIndex) {
            throw new IllegalArgumentException("Indices out of order");
        }
        // If either index is invalid, an IllegalArgumentException should be thrown.
        if (fromIndex < 0 || fromIndex >= size || toIndex > size) {
            throw new IllegalArgumentException("Invalid index");
        }
        // Return portion of the list between the specified fromIndex, inclusive,
        StringList sublist = new StringList(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            sublist.add(elementData[i]);
        }
        return sublist;
    }

    /**
     * Removing the elements in the list with the specified range.
     * @param fromIndex the first index that will be started.
     * @param toIndex the last index that will be stopped.
     * @throws IllegalArgumentException if fromIndex or toIndex param is out of range.
     * @throws IllegalArgumentException if fromIndex is greater than toIndex.
     */
    public void removeRange(int fromIndex, int toIndex) {
        // If toIndex equals fromIndex, this operation has no effect.
        if (toIndex == fromIndex) return;
        // If toIndex is less than fromIndex, an IllegalArgumentException should be thrown.
        if (toIndex < fromIndex) {
            throw new IllegalArgumentException("Indices out of order");
        }
        // If either index is invalid, an IllegalArgumentException should be thrown.
        if (fromIndex < 0 || fromIndex >= size || toIndex > size) {
            throw new IllegalArgumentException("Invalid index");
        }

        String[] temp = new String[size - (toIndex - fromIndex)];

        for (int i = 0; i < fromIndex; i++) {
            temp[i] = elementData[i];
        }

        for (int index = 0; index < temp.length - fromIndex; index++) {
            temp[fromIndex + index] = elementData[toIndex + index];
        }

        size -= (toIndex - fromIndex);
        elementData = temp;
    }

    /**
     * Checking whether the two String list are similar.
     * @param sl is the String list that want to compare with <this>.
     * @return true if they contain the same elements in the same order, otherwise false.
     */
    public boolean equals(StringList sl) {
        // Check for equal object
        if (this == sl) {
            return true;
        }
        // Check for the size equality
        if (sl == null || size != sl.size) {
            return false;
        }
        // Check each element for equality
        for (int i = 0; i < size; i++) {
            if (!elementData[i].equals(sl.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Converting this String list to an array.
     * @return the String array containing all the elements of the list in proper sequence.
     */
    public String[] toArray() {
        String[] array = new String[size];
        System.arraycopy(elementData, 0, array, 0, size);
        return array;
    }
}


