package practice_16;

public class CustomVector {
    private String[] buffer;
    private int size;
    private int capacity;

    public CustomVector() {
        this.capacity = 5;
        this.buffer = new String[this.capacity];
        this.size = 0;
    }

    public void add(String element) {
        if (size == capacity) {
            expandBuffer();
        }
        buffer[size] = element;
        size++;
    }

    public void add(int index, String element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Вихід за межі вектора. Індекс: " + index + ", Розмір: " + size);
        }
        if (size == capacity) {
            expandBuffer();
        }
        for (int i = size; i > index; i--) {
            buffer[i] = buffer[i - 1];
        }
        buffer[index] = element;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неіснуючий індекс для видалення: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            buffer[i] = buffer[i + 1];
        }
        buffer[size - 1] = null;
        size--;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неіснуючий індекс: " + index);
        }
        return buffer[index];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private void expandBuffer() {
        capacity *= 2;
        String[] newBuffer = new String[capacity];
        for (int i = 0; i < size; i++) {
            newBuffer[i] = buffer[i];
        }
        buffer = newBuffer;
    }
}