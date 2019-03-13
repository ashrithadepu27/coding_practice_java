/** Timer class for roughly calculating running time of programs
 *  @author rbk
 *  Usage:  Timer timer = new Timer();
 *          timer.start();
 *          timer.end();
 *          System.out.println(timer);  // output statistics
 */

package com.java.timer;

public class Timer {
    long startTime, endTime, elapsedTime, memAvailable, memUsed, noOfIteration;

    public Timer() {
        startTime = System.currentTimeMillis();
        noOfIteration = 1;
    }

    public void setNoOfIteration(int noOfIteration) {
        this.noOfIteration = noOfIteration;
    }
    public void start() {
        startTime = System.currentTimeMillis();
    }

    public Timer end() {
        endTime = System.currentTimeMillis();
        elapsedTime = (endTime-startTime) / noOfIteration;
        memAvailable = Runtime.getRuntime().totalMemory();
        memUsed = memAvailable - Runtime.getRuntime().freeMemory();
        return this;
    }

    public String toString() {
        return "Time: " + elapsedTime + " msec.\n" + "Memory: " + (memUsed/1048576) + " MB / " + (memAvailable/1048576) + " MB.";
    }

}
