package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;

public class ProcessLifecycleOwner implements LifecycleOwner {
    private static final ProcessLifecycleOwner sInstance = new ProcessLifecycleOwner();

    /* renamed from: b  reason: collision with root package name */
    public ReportFragment.ActivityInitializationListener f36075b = new ReportFragment.ActivityInitializationListener() {
        public void onCreate() {
        }

        public void onResume() {
            ProcessLifecycleOwner.this.b();
        }

        public void onStart() {
            ProcessLifecycleOwner.this.c();
        }
    };
    private Runnable mDelayedPauseRunnable = new Runnable() {
        public void run() {
            ProcessLifecycleOwner.this.f();
            ProcessLifecycleOwner.this.g();
        }
    };
    private Handler mHandler;
    private boolean mPauseSent = true;
    private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);
    private int mResumedCounter = 0;
    private int mStartedCounter = 0;
    private boolean mStopSent = true;

    private ProcessLifecycleOwner() {
    }

    @NonNull
    public static LifecycleOwner get() {
        return sInstance;
    }

    public static void h(Context context) {
        sInstance.e(context);
    }

    public void a() {
        int i11 = this.mResumedCounter - 1;
        this.mResumedCounter = i11;
        if (i11 == 0) {
            this.mHandler.postDelayed(this.mDelayedPauseRunnable, 700);
        }
    }

    public void b() {
        int i11 = this.mResumedCounter + 1;
        this.mResumedCounter = i11;
        if (i11 != 1) {
            return;
        }
        if (this.mPauseSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            this.mPauseSent = false;
            return;
        }
        this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
    }

    public void c() {
        int i11 = this.mStartedCounter + 1;
        this.mStartedCounter = i11;
        if (i11 == 1 && this.mStopSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.mStopSent = false;
        }
    }

    public void d() {
        this.mStartedCounter--;
        g();
    }

    public void e(Context context) {
        this.mHandler = new Handler();
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (Build.VERSION.SDK_INT < 29) {
                    ReportFragment.b(activity).c(ProcessLifecycleOwner.this.f36075b);
                }
            }

            public void onActivityPaused(Activity activity) {
                ProcessLifecycleOwner.this.a();
            }

            @RequiresApi(29)
            public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                activity.registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() {
                    public void onActivityPostResumed(@NonNull Activity activity) {
                        ProcessLifecycleOwner.this.b();
                    }

                    public void onActivityPostStarted(@NonNull Activity activity) {
                        ProcessLifecycleOwner.this.c();
                    }
                });
            }

            public void onActivityStopped(Activity activity) {
                ProcessLifecycleOwner.this.d();
            }
        });
    }

    public void f() {
        if (this.mResumedCounter == 0) {
            this.mPauseSent = true;
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    public void g() {
        if (this.mStartedCounter == 0 && this.mPauseSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            this.mStopSent = true;
        }
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }
}
