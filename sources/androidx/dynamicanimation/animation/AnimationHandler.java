package androidx.dynamicanimation.animation;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

class AnimationHandler {
    private static final long FRAME_DELAY_MS = 10;
    public static final ThreadLocal<AnimationHandler> sAnimatorHandler = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<AnimationFrameCallback> f35864a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public long f35865b = 0;
    private final AnimationCallbackDispatcher mCallbackDispatcher = new AnimationCallbackDispatcher();
    private final SimpleArrayMap<AnimationFrameCallback, Long> mDelayedCallbackStartTime = new SimpleArrayMap<>();
    private boolean mListDirty = false;
    private AnimationFrameCallbackProvider mProvider;

    public class AnimationCallbackDispatcher {
        public AnimationCallbackDispatcher() {
        }

        public void a() {
            AnimationHandler.this.f35865b = SystemClock.uptimeMillis();
            AnimationHandler animationHandler = AnimationHandler.this;
            animationHandler.a(animationHandler.f35865b);
            if (AnimationHandler.this.f35864a.size() > 0) {
                AnimationHandler.this.b().a();
            }
        }
    }

    public interface AnimationFrameCallback {
        boolean doAnimationFrame(long j11);
    }

    public static abstract class AnimationFrameCallbackProvider {

        /* renamed from: a  reason: collision with root package name */
        public final AnimationCallbackDispatcher f35867a;

        public AnimationFrameCallbackProvider(AnimationCallbackDispatcher animationCallbackDispatcher) {
            this.f35867a = animationCallbackDispatcher;
        }

        public abstract void a();
    }

    public static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {

        /* renamed from: b  reason: collision with root package name */
        public long f35868b;
        private final Handler mHandler;
        private final Runnable mRunnable;

        /* renamed from: androidx.dynamicanimation.animation.AnimationHandler$FrameCallbackProvider14$1  reason: invalid class name */
        class AnonymousClass1 implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ FrameCallbackProvider14 f35869b;

            public void run() {
                this.f35869b.f35868b = SystemClock.uptimeMillis();
                this.f35869b.f35867a.a();
            }
        }

        public void a() {
            this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.f35868b), 0));
        }
    }

    @RequiresApi(16)
    public static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {
        private final Choreographer mChoreographer = Choreographer.getInstance();
        private final Choreographer.FrameCallback mChoreographerCallback = new Choreographer.FrameCallback() {
            public void doFrame(long j11) {
                FrameCallbackProvider16.this.f35867a.a();
            }
        };

        public FrameCallbackProvider16(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
        }

        public void a() {
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }

    private void cleanUpList() {
        if (this.mListDirty) {
            for (int size = this.f35864a.size() - 1; size >= 0; size--) {
                if (this.f35864a.get(size) == null) {
                    this.f35864a.remove(size);
                }
            }
            this.mListDirty = false;
        }
    }

    public static long getFrameTime() {
        ThreadLocal<AnimationHandler> threadLocal = sAnimatorHandler;
        if (threadLocal.get() == null) {
            return 0;
        }
        return threadLocal.get().f35865b;
    }

    public static AnimationHandler getInstance() {
        ThreadLocal<AnimationHandler> threadLocal = sAnimatorHandler;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler());
        }
        return threadLocal.get();
    }

    private boolean isCallbackDue(AnimationFrameCallback animationFrameCallback, long j11) {
        Long l11 = this.mDelayedCallbackStartTime.get(animationFrameCallback);
        if (l11 == null) {
            return true;
        }
        if (l11.longValue() >= j11) {
            return false;
        }
        this.mDelayedCallbackStartTime.remove(animationFrameCallback);
        return true;
    }

    public void a(long j11) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i11 = 0; i11 < this.f35864a.size(); i11++) {
            AnimationFrameCallback animationFrameCallback = this.f35864a.get(i11);
            if (animationFrameCallback != null && isCallbackDue(animationFrameCallback, uptimeMillis)) {
                animationFrameCallback.doAnimationFrame(j11);
            }
        }
        cleanUpList();
    }

    public void addAnimationFrameCallback(AnimationFrameCallback animationFrameCallback, long j11) {
        if (this.f35864a.size() == 0) {
            b().a();
        }
        if (!this.f35864a.contains(animationFrameCallback)) {
            this.f35864a.add(animationFrameCallback);
        }
        if (j11 > 0) {
            this.mDelayedCallbackStartTime.put(animationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + j11));
        }
    }

    public AnimationFrameCallbackProvider b() {
        if (this.mProvider == null) {
            this.mProvider = new FrameCallbackProvider16(this.mCallbackDispatcher);
        }
        return this.mProvider;
    }

    public void removeCallback(AnimationFrameCallback animationFrameCallback) {
        this.mDelayedCallbackStartTime.remove(animationFrameCallback);
        int indexOf = this.f35864a.indexOf(animationFrameCallback);
        if (indexOf >= 0) {
            this.f35864a.set(indexOf, (Object) null);
            this.mListDirty = true;
        }
    }

    public void setProvider(AnimationFrameCallbackProvider animationFrameCallbackProvider) {
        this.mProvider = animationFrameCallbackProvider;
    }
}
