package com.nineoldandroids.animation;

public class TimeAnimator extends ValueAnimator {
    private TimeListener mListener;
    private long mPreviousTime = -1;

    public interface TimeListener {
        void onTimeUpdate(TimeAnimator timeAnimator, long j11, long j12);
    }

    public void l(float f11) {
    }

    public boolean m(long j11) {
        long j12 = 0;
        if (this.f52838e == 0) {
            this.f52838e = 1;
            long j13 = this.f52837d;
            if (j13 < 0) {
                this.f52836c = j11;
            } else {
                this.f52836c = j11 - j13;
                this.f52837d = -1;
            }
        }
        TimeListener timeListener = this.mListener;
        if (timeListener == null) {
            return false;
        }
        long j14 = j11 - this.f52836c;
        long j15 = this.mPreviousTime;
        if (j15 >= 0) {
            j12 = j11 - j15;
        }
        this.mPreviousTime = j11;
        timeListener.onTimeUpdate(this, j14, j12);
        return false;
    }

    public void n() {
    }

    public void setTimeListener(TimeListener timeListener) {
        this.mListener = timeListener;
    }
}
