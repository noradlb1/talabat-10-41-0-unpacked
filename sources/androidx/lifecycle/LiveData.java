package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final Object f36049d = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Object f36050a;

    /* renamed from: b  reason: collision with root package name */
    public int f36051b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Object f36052c;
    private boolean mChangingActiveState;
    private volatile Object mData;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> mObservers;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    public class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        public AlwaysActiveObserver(Observer<? super T> observer) {
            super(observer);
        }

        public boolean d() {
            return true;
        }
    }

    public class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        public final LifecycleOwner f36055f;

        public LifecycleBoundObserver(@NonNull LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(observer);
            this.f36055f = lifecycleOwner;
        }

        public void b() {
            this.f36055f.getLifecycle().removeObserver(this);
        }

        public boolean c(LifecycleOwner lifecycleOwner) {
            return this.f36055f == lifecycleOwner;
        }

        public boolean d() {
            return this.f36055f.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            Lifecycle.State currentState = this.f36055f.getLifecycle().getCurrentState();
            if (currentState == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.f36057b);
                return;
            }
            Lifecycle.State state = null;
            while (state != currentState) {
                a(d());
                state = currentState;
                currentState = this.f36055f.getLifecycle().getCurrentState();
            }
        }
    }

    public abstract class ObserverWrapper {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f36057b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36058c;

        /* renamed from: d  reason: collision with root package name */
        public int f36059d = -1;

        public ObserverWrapper(Observer<? super T> observer) {
            this.f36057b = observer;
        }

        public void a(boolean z11) {
            int i11;
            if (z11 != this.f36058c) {
                this.f36058c = z11;
                LiveData liveData = LiveData.this;
                if (z11) {
                    i11 = 1;
                } else {
                    i11 = -1;
                }
                liveData.b(i11);
                if (this.f36058c) {
                    LiveData.this.c(this);
                }
            }
        }

        public void b() {
        }

        public boolean c(LifecycleOwner lifecycleOwner) {
            return false;
        }

        public abstract boolean d();
    }

    public LiveData(T t11) {
        this.f36050a = new Object();
        this.mObservers = new SafeIterableMap<>();
        this.f36051b = 0;
        this.f36052c = f36049d;
        this.mPostValueRunnable = new Runnable() {
            public void run() {
                Object obj;
                synchronized (LiveData.this.f36050a) {
                    obj = LiveData.this.f36052c;
                    LiveData.this.f36052c = LiveData.f36049d;
                }
                LiveData.this.setValue(obj);
            }
        };
        this.mData = t11;
        this.mVersion = 0;
    }

    public static void a(String str) {
        if (!ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void considerNotify(LiveData<T>.ObserverWrapper observerWrapper) {
        if (observerWrapper.f36058c) {
            if (!observerWrapper.d()) {
                observerWrapper.a(false);
                return;
            }
            int i11 = observerWrapper.f36059d;
            int i12 = this.mVersion;
            if (i11 < i12) {
                observerWrapper.f36059d = i12;
                observerWrapper.f36057b.onChanged(this.mData);
            }
        }
    }

    @MainThread
    public void b(int i11) {
        boolean z11;
        boolean z12;
        int i12 = this.f36051b;
        this.f36051b = i11 + i12;
        if (!this.mChangingActiveState) {
            this.mChangingActiveState = true;
            while (true) {
                try {
                    int i13 = this.f36051b;
                    if (i12 != i13) {
                        if (i12 != 0 || i13 <= 0) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        if (i12 <= 0 || i13 != 0) {
                            z12 = false;
                        } else {
                            z12 = true;
                        }
                        if (z11) {
                            e();
                        } else if (z12) {
                            f();
                        }
                        i12 = i13;
                    } else {
                        return;
                    }
                } finally {
                    this.mChangingActiveState = false;
                }
            }
        }
    }

    public void c(@Nullable LiveData<T>.ObserverWrapper observerWrapper) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (observerWrapper == null) {
                SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = this.mObservers.iteratorWithAdditions();
                while (iteratorWithAdditions.hasNext()) {
                    considerNotify((ObserverWrapper) ((Map.Entry) iteratorWithAdditions.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            } else {
                considerNotify(observerWrapper);
                observerWrapper = null;
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public int d() {
        return this.mVersion;
    }

    public void e() {
    }

    public void f() {
    }

    @Nullable
    public T getValue() {
        T t11 = this.mData;
        if (t11 != f36049d) {
            return t11;
        }
        return null;
    }

    public boolean hasActiveObservers() {
        return this.f36051b > 0;
    }

    public boolean hasObservers() {
        return this.mObservers.size() > 0;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        a("observe");
        if (lifecycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
            ObserverWrapper putIfAbsent = this.mObservers.putIfAbsent(observer, lifecycleBoundObserver);
            if (putIfAbsent != null && !putIfAbsent.c(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (putIfAbsent == null) {
                lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
            }
        }
    }

    @MainThread
    public void observeForever(@NonNull Observer<? super T> observer) {
        a("observeForever");
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(observer);
        ObserverWrapper putIfAbsent = this.mObservers.putIfAbsent(observer, alwaysActiveObserver);
        if (putIfAbsent instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (putIfAbsent == null) {
            alwaysActiveObserver.a(true);
        }
    }

    public void postValue(T t11) {
        boolean z11;
        synchronized (this.f36050a) {
            if (this.f36052c == f36049d) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f36052c = t11;
        }
        if (z11) {
            ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
        }
    }

    @MainThread
    public void removeObserver(@NonNull Observer<? super T> observer) {
        a("removeObserver");
        ObserverWrapper remove = this.mObservers.remove(observer);
        if (remove != null) {
            remove.b();
            remove.a(false);
        }
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner lifecycleOwner) {
        a("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (((ObserverWrapper) next.getValue()).c(lifecycleOwner)) {
                removeObserver((Observer) next.getKey());
            }
        }
    }

    @MainThread
    public void setValue(T t11) {
        a("setValue");
        this.mVersion++;
        this.mData = t11;
        c((LiveData<T>.ObserverWrapper) null);
    }

    public LiveData() {
        this.f36050a = new Object();
        this.mObservers = new SafeIterableMap<>();
        this.f36051b = 0;
        Object obj = f36049d;
        this.f36052c = obj;
        this.mPostValueRunnable = new Runnable() {
            public void run() {
                Object obj;
                synchronized (LiveData.this.f36050a) {
                    obj = LiveData.this.f36052c;
                    LiveData.this.f36052c = LiveData.f36049d;
                }
                LiveData.this.setValue(obj);
            }
        };
        this.mData = obj;
        this.mVersion = -1;
    }
}
