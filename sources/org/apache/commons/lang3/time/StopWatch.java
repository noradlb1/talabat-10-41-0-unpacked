package org.apache.commons.lang3.time;

public class StopWatch {
    private static final long NANO_2_MILLIS = 1000000;
    private State runningState = State.UNSTARTED;
    private SplitState splitState = SplitState.UNSPLIT;
    private long startTime;
    private long startTimeMillis;
    private long stopTime;

    public enum SplitState {
        SPLIT,
        UNSPLIT
    }

    public enum State {
        UNSTARTED {
            public boolean a() {
                return false;
            }

            public boolean b() {
                return true;
            }

            public boolean c() {
                return false;
            }
        },
        RUNNING {
            public boolean a() {
                return true;
            }

            public boolean b() {
                return false;
            }

            public boolean c() {
                return false;
            }
        },
        STOPPED {
            public boolean a() {
                return false;
            }

            public boolean b() {
                return true;
            }

            public boolean c() {
                return false;
            }
        },
        SUSPENDED {
            public boolean a() {
                return true;
            }

            public boolean b() {
                return false;
            }

            public boolean c() {
                return true;
            }
        };

        public abstract boolean a();

        public abstract boolean b();

        public abstract boolean c();
    }

    public long getNanoTime() {
        long j11;
        long j12;
        State state = this.runningState;
        if (state == State.STOPPED || state == State.SUSPENDED) {
            j11 = this.stopTime;
            j12 = this.startTime;
        } else if (state == State.UNSTARTED) {
            return 0;
        } else {
            if (state == State.RUNNING) {
                j11 = System.nanoTime();
                j12 = this.startTime;
            } else {
                throw new RuntimeException("Illegal running state has occurred.");
            }
        }
        return j11 - j12;
    }

    public long getSplitNanoTime() {
        if (this.splitState == SplitState.SPLIT) {
            return this.stopTime - this.startTime;
        }
        throw new IllegalStateException("Stopwatch must be split to get the split time. ");
    }

    public long getSplitTime() {
        return getSplitNanoTime() / 1000000;
    }

    public long getStartTime() {
        if (this.runningState != State.UNSTARTED) {
            return this.startTimeMillis;
        }
        throw new IllegalStateException("Stopwatch has not been started");
    }

    public long getTime() {
        return getNanoTime() / 1000000;
    }

    public boolean isStarted() {
        return this.runningState.a();
    }

    public boolean isStopped() {
        return this.runningState.b();
    }

    public boolean isSuspended() {
        return this.runningState.c();
    }

    public void reset() {
        this.runningState = State.UNSTARTED;
        this.splitState = SplitState.UNSPLIT;
    }

    public void resume() {
        if (this.runningState == State.SUSPENDED) {
            this.startTime += System.nanoTime() - this.stopTime;
            this.runningState = State.RUNNING;
            return;
        }
        throw new IllegalStateException("Stopwatch must be suspended to resume. ");
    }

    public void split() {
        if (this.runningState == State.RUNNING) {
            this.stopTime = System.nanoTime();
            this.splitState = SplitState.SPLIT;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void start() {
        State state = this.runningState;
        if (state == State.STOPPED) {
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        } else if (state == State.UNSTARTED) {
            this.startTime = System.nanoTime();
            this.startTimeMillis = System.currentTimeMillis();
            this.runningState = State.RUNNING;
        } else {
            throw new IllegalStateException("Stopwatch already started. ");
        }
    }

    public void stop() {
        State state = this.runningState;
        State state2 = State.RUNNING;
        if (state == state2 || state == State.SUSPENDED) {
            if (state == state2) {
                this.stopTime = System.nanoTime();
            }
            this.runningState = State.STOPPED;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void suspend() {
        if (this.runningState == State.RUNNING) {
            this.stopTime = System.nanoTime();
            this.runningState = State.SUSPENDED;
            return;
        }
        throw new IllegalStateException("Stopwatch must be running to suspend. ");
    }

    public String toSplitString() {
        return DurationFormatUtils.formatDurationHMS(getSplitTime());
    }

    public String toString() {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }

    public void unsplit() {
        if (this.splitState == SplitState.SPLIT) {
            this.splitState = SplitState.UNSPLIT;
            return;
        }
        throw new IllegalStateException("Stopwatch has not been split. ");
    }
}
