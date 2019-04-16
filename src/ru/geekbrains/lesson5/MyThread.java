package ru.geekbrains.lesson5;

public class MyThread extends Thread {

    float []arr;
    int startPos;

    public MyThread(int startPos) {
        startPos = startPos;
        arr = new float[MyArray.getH()];
    }

    @Override
    public void run() {

        System.arraycopy(MyArray.getArr(), startPos, arr, 0, MyArray.getH());

        for(int i =0; i < this.arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public float[] getArr() {
        return arr;
    }
}
