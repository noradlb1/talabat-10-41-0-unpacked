package com.newrelic.agent.android.stats;

public class TicToc {
    private long endTime;
    private long startTime;
    private State state;

    public enum State {
        STOPPED,
        STARTED
    }

    public long peek() {
        if (this.state == State.STARTED) {
            return System.currentTimeMillis() - this.startTime;
        }
        return 0;
    }

    public void tic() {
        this.state = State.STARTED;
        this.startTime = System.currentTimeMillis();
    }

    public long toc() {
        long currentTimeMillis = System.currentTimeMillis();
        this.endTime = currentTimeMillis;
        if (this.state != State.STARTED) {
            return -1;
        }
        this.state = State.STOPPED;
        return currentTimeMillis - this.startTime;
    }
}
