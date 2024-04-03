package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class LifecycleRegistry extends Lifecycle {
    private int mAddingObserverCounter;
    private final boolean mEnforceMainThread;
    private boolean mHandlingEvent;
    private final WeakReference<LifecycleOwner> mLifecycleOwner;
    private boolean mNewEventOccurred;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> mObserverMap;
    private ArrayList<Lifecycle.State> mParentStates;
    private Lifecycle.State mState;

    public static class ObserverWithState {

        /* renamed from: a  reason: collision with root package name */
        public Lifecycle.State f36046a;

        /* renamed from: b  reason: collision with root package name */
        public LifecycleEventObserver f36047b;

        public ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            this.f36047b = Lifecycling.a(lifecycleObserver);
            this.f36046a = state;
        }

        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State targetState = event.getTargetState();
            this.f36046a = LifecycleRegistry.a(this.f36046a, targetState);
            this.f36047b.onStateChanged(lifecycleOwner, event);
            this.f36046a = targetState;
        }
    }

    public LifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, true);
    }

    public static Lifecycle.State a(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    private void backwardPass(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> descendingIterator = this.mObserverMap.descendingIterator();
        while (descendingIterator.hasNext() && !this.mNewEventOccurred) {
            Map.Entry next = descendingIterator.next();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.f36046a.compareTo(this.mState) > 0 && !this.mNewEventOccurred && this.mObserverMap.contains((LifecycleObserver) next.getKey())) {
                Lifecycle.Event downFrom = Lifecycle.Event.downFrom(observerWithState.f36046a);
                if (downFrom != null) {
                    pushParentState(downFrom.getTargetState());
                    observerWithState.a(lifecycleOwner, downFrom);
                    popParentState();
                } else {
                    throw new IllegalStateException("no event down from " + observerWithState.f36046a);
                }
            }
        }
    }

    private Lifecycle.State calculateTargetState(LifecycleObserver lifecycleObserver) {
        Lifecycle.State state;
        Map.Entry<LifecycleObserver, ObserverWithState> ceil = this.mObserverMap.ceil(lifecycleObserver);
        Lifecycle.State state2 = null;
        if (ceil != null) {
            state = ceil.getValue().f36046a;
        } else {
            state = null;
        }
        if (!this.mParentStates.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.mParentStates;
            state2 = arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.mState, state), state2);
    }

    @VisibleForTesting
    @NonNull
    public static LifecycleRegistry createUnsafe(@NonNull LifecycleOwner lifecycleOwner) {
        return new LifecycleRegistry(lifecycleOwner, false);
    }

    @SuppressLint({"RestrictedApi"})
    private void enforceMainThreadIfNeeded(String str) {
        if (this.mEnforceMainThread && !ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException("Method " + str + " must be called on the main thread");
        }
    }

    private void forwardPass(LifecycleOwner lifecycleOwner) {
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = this.mObserverMap.iteratorWithAdditions();
        while (iteratorWithAdditions.hasNext() && !this.mNewEventOccurred) {
            Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.f36046a.compareTo(this.mState) < 0 && !this.mNewEventOccurred && this.mObserverMap.contains((LifecycleObserver) entry.getKey())) {
                pushParentState(observerWithState.f36046a);
                Lifecycle.Event upFrom = Lifecycle.Event.upFrom(observerWithState.f36046a);
                if (upFrom != null) {
                    observerWithState.a(lifecycleOwner, upFrom);
                    popParentState();
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.f36046a);
                }
            }
        }
    }

    private boolean isSynced() {
        if (this.mObserverMap.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.mObserverMap.eldest().getValue().f36046a;
        Lifecycle.State state2 = this.mObserverMap.newest().getValue().f36046a;
        if (state == state2 && this.mState == state2) {
            return true;
        }
        return false;
    }

    private void moveToState(Lifecycle.State state) {
        Lifecycle.State state2 = this.mState;
        if (state2 != state) {
            if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
                throw new IllegalStateException("no event down from " + this.mState);
            }
            this.mState = state;
            if (this.mHandlingEvent || this.mAddingObserverCounter != 0) {
                this.mNewEventOccurred = true;
                return;
            }
            this.mHandlingEvent = true;
            sync();
            this.mHandlingEvent = false;
            if (this.mState == Lifecycle.State.DESTROYED) {
                this.mObserverMap = new FastSafeIterableMap<>();
            }
        }
    }

    private void popParentState() {
        ArrayList<Lifecycle.State> arrayList = this.mParentStates;
        arrayList.remove(arrayList.size() - 1);
    }

    private void pushParentState(Lifecycle.State state) {
        this.mParentStates.add(state);
    }

    private void sync() {
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner.get();
        if (lifecycleOwner != null) {
            while (!isSynced()) {
                this.mNewEventOccurred = false;
                if (this.mState.compareTo(this.mObserverMap.eldest().getValue().f36046a) < 0) {
                    backwardPass(lifecycleOwner);
                }
                Map.Entry<LifecycleObserver, ObserverWithState> newest = this.mObserverMap.newest();
                if (!this.mNewEventOccurred && newest != null && this.mState.compareTo(newest.getValue().f36046a) > 0) {
                    forwardPass(lifecycleOwner);
                }
            }
            this.mNewEventOccurred = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    public void addObserver(@NonNull LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        boolean z11;
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State state = this.mState;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, state2);
        if (this.mObserverMap.putIfAbsent(lifecycleObserver, observerWithState) == null && (lifecycleOwner = this.mLifecycleOwner.get()) != null) {
            if (this.mAddingObserverCounter != 0 || this.mHandlingEvent) {
                z11 = true;
            } else {
                z11 = false;
            }
            Lifecycle.State calculateTargetState = calculateTargetState(lifecycleObserver);
            this.mAddingObserverCounter++;
            while (observerWithState.f36046a.compareTo(calculateTargetState) < 0 && this.mObserverMap.contains(lifecycleObserver)) {
                pushParentState(observerWithState.f36046a);
                Lifecycle.Event upFrom = Lifecycle.Event.upFrom(observerWithState.f36046a);
                if (upFrom != null) {
                    observerWithState.a(lifecycleOwner, upFrom);
                    popParentState();
                    calculateTargetState = calculateTargetState(lifecycleObserver);
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.f36046a);
                }
            }
            if (!z11) {
                sync();
            }
            this.mAddingObserverCounter--;
        }
    }

    @NonNull
    public Lifecycle.State getCurrentState() {
        return this.mState;
    }

    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.mObserverMap.size();
    }

    public void handleLifecycleEvent(@NonNull Lifecycle.Event event) {
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    @MainThread
    @Deprecated
    public void markState(@NonNull Lifecycle.State state) {
        enforceMainThreadIfNeeded("markState");
        setCurrentState(state);
    }

    public void removeObserver(@NonNull LifecycleObserver lifecycleObserver) {
        enforceMainThreadIfNeeded("removeObserver");
        this.mObserverMap.remove(lifecycleObserver);
    }

    @MainThread
    public void setCurrentState(@NonNull Lifecycle.State state) {
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state);
    }

    private LifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner, boolean z11) {
        this.mObserverMap = new FastSafeIterableMap<>();
        this.mAddingObserverCounter = 0;
        this.mHandlingEvent = false;
        this.mNewEventOccurred = false;
        this.mParentStates = new ArrayList<>();
        this.mLifecycleOwner = new WeakReference<>(lifecycleOwner);
        this.mState = Lifecycle.State.INITIALIZED;
        this.mEnforceMainThread = z11;
    }
}
