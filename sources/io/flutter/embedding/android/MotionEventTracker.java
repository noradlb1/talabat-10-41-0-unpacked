package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

public final class MotionEventTracker {
    private static MotionEventTracker INSTANCE;
    private final LongSparseArray<MotionEvent> eventById = new LongSparseArray<>();
    private final PriorityQueue<Long> unusedEvents = new PriorityQueue<>();

    public static class MotionEventId {
        private static final AtomicLong ID_COUNTER = new AtomicLong(0);
        /* access modifiers changed from: private */

        /* renamed from: id  reason: collision with root package name */
        public final long f14163id;

        private MotionEventId(long j11) {
            this.f14163id = j11;
        }

        @NonNull
        public static MotionEventId createUnique() {
            return from(ID_COUNTER.incrementAndGet());
        }

        @NonNull
        public static MotionEventId from(long j11) {
            return new MotionEventId(j11);
        }

        public long getId() {
            return this.f14163id;
        }
    }

    private MotionEventTracker() {
    }

    @NonNull
    public static MotionEventTracker getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MotionEventTracker();
        }
        return INSTANCE;
    }

    @Nullable
    public MotionEvent pop(@NonNull MotionEventId motionEventId) {
        while (!this.unusedEvents.isEmpty() && this.unusedEvents.peek().longValue() < motionEventId.f14163id) {
            this.eventById.remove(this.unusedEvents.poll().longValue());
        }
        if (!this.unusedEvents.isEmpty() && this.unusedEvents.peek().longValue() == motionEventId.f14163id) {
            this.unusedEvents.poll();
        }
        MotionEvent motionEvent = this.eventById.get(motionEventId.f14163id);
        this.eventById.remove(motionEventId.f14163id);
        return motionEvent;
    }

    @NonNull
    public MotionEventId track(@NonNull MotionEvent motionEvent) {
        MotionEventId createUnique = MotionEventId.createUnique();
        this.eventById.put(createUnique.f14163id, MotionEvent.obtain(motionEvent));
        this.unusedEvents.add(Long.valueOf(createUnique.f14163id));
        return createUnique;
    }
}
