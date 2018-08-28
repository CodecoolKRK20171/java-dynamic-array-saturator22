package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {
    public int[] intArray;
    public int size;

    public DynamicIntArray() {
        intArray = new int[10];
    }

    public DynamicIntArray(int size) {
        createArray(size);
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for(int i = index; i < this.size; i++) {
           intArray[i] = intArray[i + 1];
        }
        intArray[this.size-1] = 0;
        this.size--;
        adjustSize();
    }

    public void insert(int index, int value) {
        int[] tempArray = new int[this.size + 1];

        if(index >= this.size) {
            add(value);
        } else {
            for(int i = 0; i < index; i++) {
                tempArray[i] = intArray[i];
            }

            tempArray[index] = value;

            for(int j = index + 1; j < this.size + 1; j++) {
                tempArray[j] = intArray[j-1];
            }
            adjustSize();
            intArray = tempArray;
            this.size++;
        }
    }

    private void adjustSize()
    {
        if(this.size>=this.intArray.length)
        {
            increaseSize();
        }
        else if(this.size==(this.intArray.length/4-1))
        {
            decreaseSize();
        }
    }

    private void increaseSize()
    {
        int[] tempArray = new int[2*this.intArray.length];
        for(int i=0; i<this.intArray.length; i++)
        {
            tempArray[i] = intArray[i];
        }
        intArray = tempArray;
    }

    private void decreaseSize()
    {
        int[] tempArray= new int[this.intArray.length/4];
        for(int i=0; i < this.size; i++)
        {
            tempArray[i] = intArray[i];
        }
        intArray=tempArray;
    }

    public void add(int value) {
        adjustSize();
        intArray[size] = value;
        this.size++;
    }

    public void createArray(int size) {
        this.intArray = new int[size];
        for(int i = 0; i < size; i++) {
            this.intArray[i] = i;
            this.size ++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.size; i ++) {
            sb.append(" " + intArray[i]);
        }
        return sb.toString();
    }
}
