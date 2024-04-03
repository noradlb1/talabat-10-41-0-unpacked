package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.FlagSet;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import n8.c;
import n8.d;

public final class ListenerSet<T> {
    private static final int MSG_ITERATION_FINISHED = 0;
    private final Clock clock;
    private final ArrayDeque<Runnable> flushingEvents;
    private final HandlerWrapper handler;
    private final IterationFinishedEvent<T> iterationFinishedEvent;
    private final CopyOnWriteArraySet<ListenerHolder<T>> listeners;
    private final ArrayDeque<Runnable> queuedEvents;
    @GuardedBy("releasedLock")
    private boolean released;
    private final Object releasedLock;
    private boolean throwsWhenUsingWrongThread;

    public interface Event<T> {
        void invoke(T t11);
    }

    public interface IterationFinishedEvent<T> {
        void invoke(T t11, FlagSet flagSet);
    }

    public static final class ListenerHolder<T> {
        private FlagSet.Builder flagsBuilder = new FlagSet.Builder();
        public final T listener;
        private boolean needsIterationFinishedEvent;
        private boolean released;

        public ListenerHolder(T t11) {
            this.listener = t11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ListenerHolder.class != obj.getClass()) {
                return false;
            }
            return this.listener.equals(((ListenerHolder) obj).listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        public void invoke(int i11, Event<T> event) {
            if (!this.released) {
                if (i11 != -1) {
                    this.flagsBuilder.add(i11);
                }
                this.needsIterationFinishedEvent = true;
                event.invoke(this.listener);
            }
        }

        public void iterationFinished(IterationFinishedEvent<T> iterationFinishedEvent) {
            if (!this.released && this.needsIterationFinishedEvent) {
                FlagSet build = this.flagsBuilder.build();
                this.flagsBuilder = new FlagSet.Builder();
                this.needsIterationFinishedEvent = false;
                iterationFinishedEvent.invoke(this.listener, build);
            }
        }

        public void release(IterationFinishedEvent<T> iterationFinishedEvent) {
            this.released = true;
            if (this.needsIterationFinishedEvent) {
                this.needsIterationFinishedEvent = false;
                iterationFinishedEvent.invoke(this.listener, this.flagsBuilder.build());
            }
        }
    }

    public ListenerSet(Looper looper, Clock clock2, IterationFinishedEvent<T> iterationFinishedEvent2) {
        this(new CopyOnWriteArraySet(), looper, clock2, iterationFinishedEvent2);
    }

    /* access modifiers changed from: private */
    public boolean handleMessage(Message message) {
        Iterator<ListenerHolder<T>> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().iterationFinished(this.iterationFinishedEvent);
            if (this.handler.hasMessages(0)) {
                return true;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$queueEvent$0(CopyOnWriteArraySet copyOnWriteArraySet, int i11, Event event) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((ListenerHolder) it.next()).invoke(i11, event);
        }
    }

    private void verifyCurrentThread() {
        boolean z11;
        if (this.throwsWhenUsingWrongThread) {
            if (Thread.currentThread() == this.handler.getLooper().getThread()) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkState(z11);
        }
    }

    public void add(T t11) {
        Assertions.checkNotNull(t11);
        synchronized (this.releasedLock) {
            if (!this.released) {
                this.listeners.add(new ListenerHolder(t11));
            }
        }
    }

    public void clear() {
        verifyCurrentThread();
        this.listeners.clear();
    }

    @CheckResult
    public ListenerSet<T> copy(Looper looper, IterationFinishedEvent<T> iterationFinishedEvent2) {
        return copy(looper, this.clock, iterationFinishedEvent2);
    }

    public void flushEvents() {
        verifyCurrentThread();
        if (!this.queuedEvents.isEmpty()) {
            if (!this.handler.hasMessages(0)) {
                HandlerWrapper handlerWrapper = this.handler;
                handlerWrapper.sendMessageAtFrontOfQueue(handlerWrapper.obtainMessage(0));
            }
            boolean z11 = !this.flushingEvents.isEmpty();
            this.flushingEvents.addAll(this.queuedEvents);
            this.queuedEvents.clear();
            if (!z11) {
                while (!this.flushingEvents.isEmpty()) {
                    this.flushingEvents.peekFirst().run();
                    this.flushingEvents.removeFirst();
                }
            }
        }
    }

    public void queueEvent(int i11, Event<T> event) {
        verifyCurrentThread();
        this.queuedEvents.add(new d(new CopyOnWriteArraySet(this.listeners), i11, event));
    }

    public void release() {
        verifyCurrentThread();
        synchronized (this.releasedLock) {
            this.released = true;
        }
        Iterator<ListenerHolder<T>> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().release(this.iterationFinishedEvent);
        }
        this.listeners.clear();
    }

    public void remove(T t11) {
        verifyCurrentThread();
        Iterator<ListenerHolder<T>> it = this.listeners.iterator();
        while (it.hasNext()) {
            ListenerHolder next = it.next();
            if (next.listener.equals(t11)) {
                next.release(this.iterationFinishedEvent);
                this.listeners.remove(next);
            }
        }
    }

    public void sendEvent(int i11, Event<T> event) {
        queueEvent(i11, event);
        flushEvents();
    }

    @Deprecated
    public void setThrowsWhenUsingWrongThread(boolean z11) {
        this.throwsWhenUsingWrongThread = z11;
    }

    public int size() {
        verifyCurrentThread();
        return this.listeners.size();
    }

    private ListenerSet(CopyOnWriteArraySet<ListenerHolder<T>> copyOnWriteArraySet, Looper looper, Clock clock2, IterationFinishedEvent<T> iterationFinishedEvent2) {
        this.clock = clock2;
        this.listeners = copyOnWriteArraySet;
        this.iterationFinishedEvent = iterationFinishedEvent2;
        this.releasedLock = new Object();
        this.flushingEvents = new ArrayDeque<>();
        this.queuedEvents = new ArrayDeque<>();
        this.handler = clock2.createHandler(looper, new c(this));
        this.throwsWhenUsingWrongThread = true;
    }

    @CheckResult
    public ListenerSet<T> copy(Looper looper, Clock clock2, IterationFinishedEvent<T> iterationFinishedEvent2) {
        return new ListenerSet<>(this.listeners, looper, clock2, iterationFinishedEvent2);
    }
}
