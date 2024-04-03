package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewPropertyAnimatorCompatSet {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<ViewPropertyAnimatorCompat> f684a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ViewPropertyAnimatorListener f685b;
    private long mDuration = -1;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    private final ViewPropertyAnimatorListenerAdapter mProxyListener = new ViewPropertyAnimatorListenerAdapter() {
        private int mProxyEndCount = 0;
        private boolean mProxyStarted = false;

        public void a() {
            this.mProxyEndCount = 0;
            this.mProxyStarted = false;
            ViewPropertyAnimatorCompatSet.this.a();
        }

        public void onAnimationEnd(View view) {
            int i11 = this.mProxyEndCount + 1;
            this.mProxyEndCount = i11;
            if (i11 == ViewPropertyAnimatorCompatSet.this.f684a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f685b;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd((View) null);
                }
                a();
            }
        }

        public void onAnimationStart(View view) {
            if (!this.mProxyStarted) {
                this.mProxyStarted = true;
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f685b;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart((View) null);
                }
            }
        }
    };

    public void a() {
        this.mIsStarted = false;
    }

    public void cancel() {
        if (this.mIsStarted) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f684a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.mIsStarted = false;
        }
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.mIsStarted) {
            this.f684a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f684a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.f684a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j11) {
        if (!this.mIsStarted) {
            this.mDuration = j11;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (!this.mIsStarted) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.mIsStarted) {
            this.f685b = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void start() {
        if (!this.mIsStarted) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f684a.iterator();
            while (it.hasNext()) {
                ViewPropertyAnimatorCompat next = it.next();
                long j11 = this.mDuration;
                if (j11 >= 0) {
                    next.setDuration(j11);
                }
                Interpolator interpolator = this.mInterpolator;
                if (interpolator != null) {
                    next.setInterpolator(interpolator);
                }
                if (this.f685b != null) {
                    next.setListener(this.mProxyListener);
                }
                next.start();
            }
            this.mIsStarted = true;
        }
    }
}
