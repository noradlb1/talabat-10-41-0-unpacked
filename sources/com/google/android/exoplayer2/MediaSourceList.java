package com.google.android.exoplayer2;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MaskingMediaSource;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k7.e;

final class MediaSourceList {
    private static final String TAG = "MediaSourceList";
    private final HashMap<MediaSourceHolder, MediaSourceAndListener> childSources;
    private final Set<MediaSourceHolder> enabledMediaSourceHolders;
    /* access modifiers changed from: private */
    public final HandlerWrapper eventHandler;
    /* access modifiers changed from: private */
    public final AnalyticsCollector eventListener;
    private boolean isPrepared;
    private final IdentityHashMap<MediaPeriod, MediaSourceHolder> mediaSourceByMediaPeriod = new IdentityHashMap<>();
    private final Map<Object, MediaSourceHolder> mediaSourceByUid = new HashMap();
    private final List<MediaSourceHolder> mediaSourceHolders = new ArrayList();
    private final MediaSourceListInfoRefreshListener mediaSourceListInfoListener;
    @Nullable
    private TransferListener mediaTransferListener;
    private final PlayerId playerId;
    private ShuffleOrder shuffleOrder = new ShuffleOrder.DefaultShuffleOrder(0);

    public final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {

        /* renamed from: id  reason: collision with root package name */
        private final MediaSourceHolder f34905id;

        public ForwardingEventListener(MediaSourceHolder mediaSourceHolder) {
            this.f34905id = mediaSourceHolder;
        }

        @Nullable
        private Pair<Integer, MediaSource.MediaPeriodId> getEventParameters(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2 = null;
            if (mediaPeriodId != null) {
                MediaSource.MediaPeriodId access$100 = MediaSourceList.getMediaPeriodIdForChildMediaPeriodId(this.f34905id, mediaPeriodId);
                if (access$100 == null) {
                    return null;
                }
                mediaPeriodId2 = access$100;
            }
            return Pair.create(Integer.valueOf(MediaSourceList.getWindowIndexForChildWindowIndex(this.f34905id, i11)), mediaPeriodId2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onDownstreamFormatChanged$5(Pair pair, MediaLoadData mediaLoadData) {
            MediaSourceList.this.eventListener.onDownstreamFormatChanged(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onDrmKeysLoaded$7(Pair pair) {
            MediaSourceList.this.eventListener.onDrmKeysLoaded(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onDrmKeysRemoved$10(Pair pair) {
            MediaSourceList.this.eventListener.onDrmKeysRemoved(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onDrmKeysRestored$9(Pair pair) {
            MediaSourceList.this.eventListener.onDrmKeysRestored(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onDrmSessionAcquired$6(Pair pair, int i11) {
            MediaSourceList.this.eventListener.onDrmSessionAcquired(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, i11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onDrmSessionManagerError$8(Pair pair, Exception exc) {
            MediaSourceList.this.eventListener.onDrmSessionManagerError(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onDrmSessionReleased$11(Pair pair) {
            MediaSourceList.this.eventListener.onDrmSessionReleased(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoadCanceled$2(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.eventListener.onLoadCanceled(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoadCompleted$1(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.eventListener.onLoadCompleted(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoadError$3(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
            MediaSourceList.this.eventListener.onLoadError(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData, iOException, z11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoadStarted$0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.eventListener.onLoadStarted(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onUpstreamDiscarded$4(Pair pair, MediaLoadData mediaLoadData) {
            MediaSourceList.this.eventListener.onUpstreamDiscarded(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) Assertions.checkNotNull((MediaSource.MediaPeriodId) pair.second), mediaLoadData);
        }

        public void onDownstreamFormatChanged(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i11, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new u0(this, eventParameters, mediaLoadData));
            }
        }

        public void onDrmKeysLoaded(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i11, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new r0(this, eventParameters));
            }
        }

        public void onDrmKeysRemoved(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i11, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new x0(this, eventParameters));
            }
        }

        public void onDrmKeysRestored(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i11, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new s0(this, eventParameters));
            }
        }

        public /* synthetic */ void onDrmSessionAcquired(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
            e.d(this, i11, mediaPeriodId);
        }

        public void onDrmSessionAcquired(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, int i12) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i11, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new w0(this, eventParameters, i12));
            }
        }

        public void onDrmSessionManagerError(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i11, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new a1(this, eventParameters, exc));
            }
        }

        public void onDrmSessionReleased(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i11, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new z0(this, eventParameters));
            }
        }

        public void onLoadCanceled(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i11, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new v0(this, eventParameters, loadEventInfo, mediaLoadData));
            }
        }

        public void onLoadCompleted(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i11, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new b1(this, eventParameters, loadEventInfo, mediaLoadData));
            }
        }

        public void onLoadError(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i11, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new t0(this, eventParameters, loadEventInfo, mediaLoadData, iOException, z11));
            }
        }

        public void onLoadStarted(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i11, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new q0(this, eventParameters, loadEventInfo, mediaLoadData));
            }
        }

        public void onUpstreamDiscarded(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i11, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new y0(this, eventParameters, mediaLoadData));
            }
        }
    }

    public static final class MediaSourceAndListener {
        public final MediaSource.MediaSourceCaller caller;
        public final ForwardingEventListener eventListener;
        public final MediaSource mediaSource;

        public MediaSourceAndListener(MediaSource mediaSource2, MediaSource.MediaSourceCaller mediaSourceCaller, ForwardingEventListener forwardingEventListener) {
            this.mediaSource = mediaSource2;
            this.caller = mediaSourceCaller;
            this.eventListener = forwardingEventListener;
        }
    }

    public static final class MediaSourceHolder implements MediaSourceInfoHolder {
        public final List<MediaSource.MediaPeriodId> activeMediaPeriodIds = new ArrayList();
        public int firstWindowIndexInChild;
        public boolean isRemoved;
        public final MaskingMediaSource mediaSource;
        public final Object uid = new Object();

        public MediaSourceHolder(MediaSource mediaSource2, boolean z11) {
            this.mediaSource = new MaskingMediaSource(mediaSource2, z11);
        }

        public Timeline getTimeline() {
            return this.mediaSource.getTimeline();
        }

        public Object getUid() {
            return this.uid;
        }

        public void reset(int i11) {
            this.firstWindowIndexInChild = i11;
            this.isRemoved = false;
            this.activeMediaPeriodIds.clear();
        }
    }

    public interface MediaSourceListInfoRefreshListener {
        void onPlaylistUpdateRequested();
    }

    public MediaSourceList(MediaSourceListInfoRefreshListener mediaSourceListInfoRefreshListener, AnalyticsCollector analyticsCollector, HandlerWrapper handlerWrapper, PlayerId playerId2) {
        this.playerId = playerId2;
        this.mediaSourceListInfoListener = mediaSourceListInfoRefreshListener;
        this.eventListener = analyticsCollector;
        this.eventHandler = handlerWrapper;
        this.childSources = new HashMap<>();
        this.enabledMediaSourceHolders = new HashSet();
    }

    private void correctOffsets(int i11, int i12) {
        while (i11 < this.mediaSourceHolders.size()) {
            this.mediaSourceHolders.get(i11).firstWindowIndexInChild += i12;
            i11++;
        }
    }

    private void disableChildSource(MediaSourceHolder mediaSourceHolder) {
        MediaSourceAndListener mediaSourceAndListener = this.childSources.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.mediaSource.disable(mediaSourceAndListener.caller);
        }
    }

    private void disableUnusedMediaSources() {
        Iterator<MediaSourceHolder> it = this.enabledMediaSourceHolders.iterator();
        while (it.hasNext()) {
            MediaSourceHolder next = it.next();
            if (next.activeMediaPeriodIds.isEmpty()) {
                disableChildSource(next);
                it.remove();
            }
        }
    }

    private void enableMediaSource(MediaSourceHolder mediaSourceHolder) {
        this.enabledMediaSourceHolders.add(mediaSourceHolder);
        MediaSourceAndListener mediaSourceAndListener = this.childSources.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.mediaSource.enable(mediaSourceAndListener.caller);
        }
    }

    private static Object getChildPeriodUid(Object obj) {
        return AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(obj);
    }

    /* access modifiers changed from: private */
    @Nullable
    public static MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i11 = 0; i11 < mediaSourceHolder.activeMediaPeriodIds.size(); i11++) {
            if (mediaSourceHolder.activeMediaPeriodIds.get(i11).windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return mediaPeriodId.copyWithPeriodUid(getPeriodUid(mediaSourceHolder, mediaPeriodId.periodUid));
            }
        }
        return null;
    }

    private static Object getMediaSourceHolderUid(Object obj) {
        return AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(obj);
    }

    private static Object getPeriodUid(MediaSourceHolder mediaSourceHolder, Object obj) {
        return AbstractConcatenatedTimeline.getConcatenatedUid(mediaSourceHolder.uid, obj);
    }

    /* access modifiers changed from: private */
    public static int getWindowIndexForChildWindowIndex(MediaSourceHolder mediaSourceHolder, int i11) {
        return i11 + mediaSourceHolder.firstWindowIndexInChild;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareChildSource$0(MediaSource mediaSource, Timeline timeline) {
        this.mediaSourceListInfoListener.onPlaylistUpdateRequested();
    }

    private void maybeReleaseChildSource(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.isRemoved && mediaSourceHolder.activeMediaPeriodIds.isEmpty()) {
            MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.checkNotNull(this.childSources.remove(mediaSourceHolder));
            mediaSourceAndListener.mediaSource.releaseSource(mediaSourceAndListener.caller);
            mediaSourceAndListener.mediaSource.removeEventListener(mediaSourceAndListener.eventListener);
            mediaSourceAndListener.mediaSource.removeDrmEventListener(mediaSourceAndListener.eventListener);
            this.enabledMediaSourceHolders.remove(mediaSourceHolder);
        }
    }

    private void prepareChildSource(MediaSourceHolder mediaSourceHolder) {
        MaskingMediaSource maskingMediaSource = mediaSourceHolder.mediaSource;
        p0 p0Var = new p0(this);
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(mediaSourceHolder);
        this.childSources.put(mediaSourceHolder, new MediaSourceAndListener(maskingMediaSource, p0Var, forwardingEventListener));
        maskingMediaSource.addEventListener(Util.createHandlerForCurrentOrMainLooper(), forwardingEventListener);
        maskingMediaSource.addDrmEventListener(Util.createHandlerForCurrentOrMainLooper(), forwardingEventListener);
        maskingMediaSource.prepareSource(p0Var, this.mediaTransferListener, this.playerId);
    }

    private void removeMediaSourcesInternal(int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            MediaSourceHolder remove = this.mediaSourceHolders.remove(i13);
            this.mediaSourceByUid.remove(remove.uid);
            correctOffsets(i13, -remove.mediaSource.getTimeline().getWindowCount());
            remove.isRemoved = true;
            if (this.isPrepared) {
                maybeReleaseChildSource(remove);
            }
        }
    }

    public Timeline addMediaSources(int i11, List<MediaSourceHolder> list, ShuffleOrder shuffleOrder2) {
        if (!list.isEmpty()) {
            this.shuffleOrder = shuffleOrder2;
            for (int i12 = i11; i12 < list.size() + i11; i12++) {
                MediaSourceHolder mediaSourceHolder = list.get(i12 - i11);
                if (i12 > 0) {
                    MediaSourceHolder mediaSourceHolder2 = this.mediaSourceHolders.get(i12 - 1);
                    mediaSourceHolder.reset(mediaSourceHolder2.firstWindowIndexInChild + mediaSourceHolder2.mediaSource.getTimeline().getWindowCount());
                } else {
                    mediaSourceHolder.reset(0);
                }
                correctOffsets(i12, mediaSourceHolder.mediaSource.getTimeline().getWindowCount());
                this.mediaSourceHolders.add(i12, mediaSourceHolder);
                this.mediaSourceByUid.put(mediaSourceHolder.uid, mediaSourceHolder);
                if (this.isPrepared) {
                    prepareChildSource(mediaSourceHolder);
                    if (this.mediaSourceByMediaPeriod.isEmpty()) {
                        this.enabledMediaSourceHolders.add(mediaSourceHolder);
                    } else {
                        disableChildSource(mediaSourceHolder);
                    }
                }
            }
        }
        return createTimeline();
    }

    public Timeline clear(@Nullable ShuffleOrder shuffleOrder2) {
        if (shuffleOrder2 == null) {
            shuffleOrder2 = this.shuffleOrder.cloneAndClear();
        }
        this.shuffleOrder = shuffleOrder2;
        removeMediaSourcesInternal(0, getSize());
        return createTimeline();
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        Object mediaSourceHolderUid = getMediaSourceHolderUid(mediaPeriodId.periodUid);
        MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(getChildPeriodUid(mediaPeriodId.periodUid));
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.checkNotNull(this.mediaSourceByUid.get(mediaSourceHolderUid));
        enableMediaSource(mediaSourceHolder);
        mediaSourceHolder.activeMediaPeriodIds.add(copyWithPeriodUid);
        MaskingMediaPeriod createPeriod = mediaSourceHolder.mediaSource.createPeriod(copyWithPeriodUid, allocator, j11);
        this.mediaSourceByMediaPeriod.put(createPeriod, mediaSourceHolder);
        disableUnusedMediaSources();
        return createPeriod;
    }

    public Timeline createTimeline() {
        if (this.mediaSourceHolders.isEmpty()) {
            return Timeline.EMPTY;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.mediaSourceHolders.size(); i12++) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i12);
            mediaSourceHolder.firstWindowIndexInChild = i11;
            i11 += mediaSourceHolder.mediaSource.getTimeline().getWindowCount();
        }
        return new PlaylistTimeline(this.mediaSourceHolders, this.shuffleOrder);
    }

    public int getSize() {
        return this.mediaSourceHolders.size();
    }

    public boolean isPrepared() {
        return this.isPrepared;
    }

    public Timeline moveMediaSource(int i11, int i12, ShuffleOrder shuffleOrder2) {
        return moveMediaSourceRange(i11, i11 + 1, i12, shuffleOrder2);
    }

    public Timeline moveMediaSourceRange(int i11, int i12, int i13, ShuffleOrder shuffleOrder2) {
        boolean z11;
        if (i11 < 0 || i11 > i12 || i12 > getSize() || i13 < 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        Assertions.checkArgument(z11);
        this.shuffleOrder = shuffleOrder2;
        if (i11 == i12 || i11 == i13) {
            return createTimeline();
        }
        int min = Math.min(i11, i13);
        int max = Math.max(((i12 - i11) + i13) - 1, i12 - 1);
        int i14 = this.mediaSourceHolders.get(min).firstWindowIndexInChild;
        Util.moveItems(this.mediaSourceHolders, i11, i12, i13);
        while (min <= max) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(min);
            mediaSourceHolder.firstWindowIndexInChild = i14;
            i14 += mediaSourceHolder.mediaSource.getTimeline().getWindowCount();
            min++;
        }
        return createTimeline();
    }

    public void prepare(@Nullable TransferListener transferListener) {
        Assertions.checkState(!this.isPrepared);
        this.mediaTransferListener = transferListener;
        for (int i11 = 0; i11 < this.mediaSourceHolders.size(); i11++) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i11);
            prepareChildSource(mediaSourceHolder);
            this.enabledMediaSourceHolders.add(mediaSourceHolder);
        }
        this.isPrepared = true;
    }

    public void release() {
        for (MediaSourceAndListener next : this.childSources.values()) {
            try {
                next.mediaSource.releaseSource(next.caller);
            } catch (RuntimeException e11) {
                Log.e(TAG, "Failed to release child source.", e11);
            }
            next.mediaSource.removeEventListener(next.eventListener);
            next.mediaSource.removeDrmEventListener(next.eventListener);
        }
        this.childSources.clear();
        this.enabledMediaSourceHolders.clear();
        this.isPrepared = false;
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.checkNotNull(this.mediaSourceByMediaPeriod.remove(mediaPeriod));
        mediaSourceHolder.mediaSource.releasePeriod(mediaPeriod);
        mediaSourceHolder.activeMediaPeriodIds.remove(((MaskingMediaPeriod) mediaPeriod).f34998id);
        if (!this.mediaSourceByMediaPeriod.isEmpty()) {
            disableUnusedMediaSources();
        }
        maybeReleaseChildSource(mediaSourceHolder);
    }

    public Timeline removeMediaSourceRange(int i11, int i12, ShuffleOrder shuffleOrder2) {
        boolean z11;
        if (i11 < 0 || i11 > i12 || i12 > getSize()) {
            z11 = false;
        } else {
            z11 = true;
        }
        Assertions.checkArgument(z11);
        this.shuffleOrder = shuffleOrder2;
        removeMediaSourcesInternal(i11, i12);
        return createTimeline();
    }

    public Timeline setMediaSources(List<MediaSourceHolder> list, ShuffleOrder shuffleOrder2) {
        removeMediaSourcesInternal(0, this.mediaSourceHolders.size());
        return addMediaSources(this.mediaSourceHolders.size(), list, shuffleOrder2);
    }

    public Timeline setShuffleOrder(ShuffleOrder shuffleOrder2) {
        int size = getSize();
        if (shuffleOrder2.getLength() != size) {
            shuffleOrder2 = shuffleOrder2.cloneAndClear().cloneAndInsert(0, size);
        }
        this.shuffleOrder = shuffleOrder2;
        return createTimeline();
    }
}
