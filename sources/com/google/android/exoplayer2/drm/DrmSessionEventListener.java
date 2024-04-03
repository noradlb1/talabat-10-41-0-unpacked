package com.google.android.exoplayer2.drm;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import k7.f;
import k7.g;
import k7.h;
import k7.i;
import k7.j;
import k7.k;

public interface DrmSessionEventListener {

    public static class EventDispatcher {
        private final CopyOnWriteArrayList<ListenerAndHandler> listenerAndHandlers;
        @Nullable
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final int windowIndex;

        public static final class ListenerAndHandler {
            public Handler handler;
            public DrmSessionEventListener listener;

            public ListenerAndHandler(Handler handler2, DrmSessionEventListener drmSessionEventListener) {
                this.handler = handler2;
                this.listener = drmSessionEventListener;
            }
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, (MediaSource.MediaPeriodId) null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$drmKeysLoaded$1(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.onDrmKeysLoaded(this.windowIndex, this.mediaPeriodId);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$drmKeysRemoved$4(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.onDrmKeysRemoved(this.windowIndex, this.mediaPeriodId);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$drmKeysRestored$3(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.onDrmKeysRestored(this.windowIndex, this.mediaPeriodId);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$drmSessionAcquired$0(DrmSessionEventListener drmSessionEventListener, int i11) {
            drmSessionEventListener.onDrmSessionAcquired(this.windowIndex, this.mediaPeriodId);
            drmSessionEventListener.onDrmSessionAcquired(this.windowIndex, this.mediaPeriodId, i11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$drmSessionManagerError$2(DrmSessionEventListener drmSessionEventListener, Exception exc) {
            drmSessionEventListener.onDrmSessionManagerError(this.windowIndex, this.mediaPeriodId, exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$drmSessionReleased$5(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.onDrmSessionReleased(this.windowIndex, this.mediaPeriodId);
        }

        public void addEventListener(Handler handler, DrmSessionEventListener drmSessionEventListener) {
            Assertions.checkNotNull(handler);
            Assertions.checkNotNull(drmSessionEventListener);
            this.listenerAndHandlers.add(new ListenerAndHandler(handler, drmSessionEventListener));
        }

        public void drmKeysLoaded() {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                Util.postOrRun(next.handler, new j(this, next.listener));
            }
        }

        public void drmKeysRemoved() {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                Util.postOrRun(next.handler, new i(this, next.listener));
            }
        }

        public void drmKeysRestored() {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                Util.postOrRun(next.handler, new k(this, next.listener));
            }
        }

        public void drmSessionAcquired(int i11) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                Util.postOrRun(next.handler, new h(this, next.listener, i11));
            }
        }

        public void drmSessionManagerError(Exception exc) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                Util.postOrRun(next.handler, new g(this, next.listener, exc));
            }
        }

        public void drmSessionReleased() {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                Util.postOrRun(next.handler, new f(this, next.listener));
            }
        }

        public void removeEventListener(DrmSessionEventListener drmSessionEventListener) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                if (next.listener == drmSessionEventListener) {
                    this.listenerAndHandlers.remove(next);
                }
            }
        }

        @CheckResult
        public EventDispatcher withParameters(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId2) {
            return new EventDispatcher(this.listenerAndHandlers, i11, mediaPeriodId2);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId2) {
            this.listenerAndHandlers = copyOnWriteArrayList;
            this.windowIndex = i11;
            this.mediaPeriodId = mediaPeriodId2;
        }
    }

    void onDrmKeysLoaded(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmKeysRemoved(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmKeysRestored(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    @Deprecated
    void onDrmSessionAcquired(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmSessionAcquired(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, int i12);

    void onDrmSessionManagerError(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc);

    void onDrmSessionReleased(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId);
}
