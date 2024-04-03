package com.google.android.exoplayer2.source.ads;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import b8.d;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k7.e;

public final class ServerSideAdInsertionMediaSource extends BaseMediaSource implements MediaSource.MediaSourceCaller, MediaSourceEventListener, DrmSessionEventListener {
    @Nullable
    private final AdPlaybackStateUpdater adPlaybackStateUpdater;
    private ImmutableMap<Object, AdPlaybackState> adPlaybackStates = ImmutableMap.of();
    @Nullable
    private Timeline contentTimeline;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcherWithoutId = createDrmEventDispatcher((MediaSource.MediaPeriodId) null);
    @Nullable
    private SharedMediaPeriod lastUsedMediaPeriod;
    private final ListMultimap<Pair<Long, Object>, SharedMediaPeriod> mediaPeriods = ArrayListMultimap.create();
    private final MediaSource mediaSource;
    private final MediaSourceEventListener.EventDispatcher mediaSourceEventDispatcherWithoutId = createEventDispatcher((MediaSource.MediaPeriodId) null);
    @GuardedBy("this")
    @Nullable
    private Handler playbackHandler;

    public interface AdPlaybackStateUpdater {
        boolean onAdPlaybackStateUpdateRequested(Timeline timeline);
    }

    public static final class MediaPeriodImpl implements MediaPeriod {
        public MediaPeriod.Callback callback;
        public final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
        public boolean[] hasNotifiedDownstreamFormatChange = new boolean[0];
        public long lastStartPositionUs;
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final MediaSourceEventListener.EventDispatcher mediaSourceEventDispatcher;
        public final SharedMediaPeriod sharedPeriod;

        public MediaPeriodImpl(SharedMediaPeriod sharedMediaPeriod, MediaSource.MediaPeriodId mediaPeriodId2, MediaSourceEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
            this.sharedPeriod = sharedMediaPeriod;
            this.mediaPeriodId = mediaPeriodId2;
            this.mediaSourceEventDispatcher = eventDispatcher;
            this.drmEventDispatcher = eventDispatcher2;
        }

        public boolean continueLoading(long j11) {
            return this.sharedPeriod.continueLoading(this, j11);
        }

        public void discardBuffer(long j11, boolean z11) {
            this.sharedPeriod.discardBuffer(this, j11, z11);
        }

        public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
            return this.sharedPeriod.getAdjustedSeekPositionUs(this, j11, seekParameters);
        }

        public long getBufferedPositionUs() {
            return this.sharedPeriod.getBufferedPositionUs(this);
        }

        public long getNextLoadPositionUs() {
            return this.sharedPeriod.getNextLoadPositionUs(this);
        }

        public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
            return this.sharedPeriod.getStreamKeys(list);
        }

        public TrackGroupArray getTrackGroups() {
            return this.sharedPeriod.getTrackGroups();
        }

        public boolean isLoading() {
            return this.sharedPeriod.isLoading(this);
        }

        public void maybeThrowPrepareError() throws IOException {
            this.sharedPeriod.maybeThrowPrepareError();
        }

        public void prepare(MediaPeriod.Callback callback2, long j11) {
            this.callback = callback2;
            this.sharedPeriod.prepare(this, j11);
        }

        public long readDiscontinuity() {
            return this.sharedPeriod.readDiscontinuity(this);
        }

        public void reevaluateBuffer(long j11) {
            this.sharedPeriod.reevaluateBuffer(this, j11);
        }

        public long seekToUs(long j11) {
            return this.sharedPeriod.seekToUs(this, j11);
        }

        public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j11) {
            if (this.hasNotifiedDownstreamFormatChange.length == 0) {
                this.hasNotifiedDownstreamFormatChange = new boolean[sampleStreamArr.length];
            }
            return this.sharedPeriod.selectTracks(this, exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j11);
        }
    }

    public static final class SampleStreamImpl implements SampleStream {
        private final MediaPeriodImpl mediaPeriod;
        private final int streamIndex;

        public SampleStreamImpl(MediaPeriodImpl mediaPeriodImpl, int i11) {
            this.mediaPeriod = mediaPeriodImpl;
            this.streamIndex = i11;
        }

        public boolean isReady() {
            return this.mediaPeriod.sharedPeriod.isReady(this.streamIndex);
        }

        public void maybeThrowError() throws IOException {
            this.mediaPeriod.sharedPeriod.maybeThrowError(this.streamIndex);
        }

        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i11) {
            MediaPeriodImpl mediaPeriodImpl = this.mediaPeriod;
            return mediaPeriodImpl.sharedPeriod.readData(mediaPeriodImpl, this.streamIndex, formatHolder, decoderInputBuffer, i11);
        }

        public int skipData(long j11) {
            MediaPeriodImpl mediaPeriodImpl = this.mediaPeriod;
            return mediaPeriodImpl.sharedPeriod.skipData(mediaPeriodImpl, this.streamIndex, j11);
        }
    }

    public static final class ServerSideAdInsertionTimeline extends ForwardingTimeline {
        private final ImmutableMap<Object, AdPlaybackState> adPlaybackStates;

        public ServerSideAdInsertionTimeline(Timeline timeline, ImmutableMap<Object, AdPlaybackState> immutableMap) {
            super(timeline);
            boolean z11;
            if (timeline.getWindowCount() == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkState(z11);
            Timeline.Period period = new Timeline.Period();
            for (int i11 = 0; i11 < timeline.getPeriodCount(); i11++) {
                timeline.getPeriod(i11, period, true);
                Assertions.checkState(immutableMap.containsKey(Assertions.checkNotNull(period.uid)));
            }
            this.adPlaybackStates = immutableMap;
        }

        public Timeline.Period getPeriod(int i11, Timeline.Period period, boolean z11) {
            long j11;
            super.getPeriod(i11, period, true);
            AdPlaybackState adPlaybackState = (AdPlaybackState) Assertions.checkNotNull(this.adPlaybackStates.get(period.uid));
            long j12 = period.durationUs;
            if (j12 == C.TIME_UNSET) {
                j11 = adPlaybackState.contentDurationUs;
            } else {
                j11 = ServerSideAdInsertionUtil.getMediaPeriodPositionUsForContent(j12, -1, adPlaybackState);
            }
            long j13 = j11;
            Timeline.Period period2 = new Timeline.Period();
            long j14 = 0;
            for (int i12 = 0; i12 < i11 + 1; i12++) {
                this.timeline.getPeriod(i12, period2, true);
                AdPlaybackState adPlaybackState2 = (AdPlaybackState) Assertions.checkNotNull(this.adPlaybackStates.get(period2.uid));
                if (i12 == 0) {
                    j14 = -ServerSideAdInsertionUtil.getMediaPeriodPositionUsForContent(-period2.getPositionInWindowUs(), -1, adPlaybackState2);
                }
                if (i12 != i11) {
                    j14 += ServerSideAdInsertionUtil.getMediaPeriodPositionUsForContent(period2.durationUs, -1, adPlaybackState2);
                }
            }
            period.set(period.f34906id, period.uid, period.windowIndex, j13, j14, adPlaybackState, period.isPlaceholder);
            return period;
        }

        public Timeline.Window getWindow(int i11, Timeline.Window window, long j11) {
            super.getWindow(i11, window, j11);
            Timeline.Period period = new Timeline.Period();
            AdPlaybackState adPlaybackState = (AdPlaybackState) Assertions.checkNotNull(this.adPlaybackStates.get(Assertions.checkNotNull(getPeriod(window.firstPeriodIndex, period, true).uid)));
            long mediaPeriodPositionUsForContent = ServerSideAdInsertionUtil.getMediaPeriodPositionUsForContent(window.positionInFirstPeriodUs, -1, adPlaybackState);
            if (window.durationUs == C.TIME_UNSET) {
                long j12 = adPlaybackState.contentDurationUs;
                if (j12 != C.TIME_UNSET) {
                    window.durationUs = j12 - mediaPeriodPositionUsForContent;
                }
            } else {
                Timeline.Period period2 = super.getPeriod(window.lastPeriodIndex, period, true);
                long j13 = period2.positionInWindowUs;
                Timeline.Period period3 = getPeriod(window.lastPeriodIndex, period);
                window.durationUs = period3.positionInWindowUs + ServerSideAdInsertionUtil.getMediaPeriodPositionUsForContent(window.durationUs - j13, -1, (AdPlaybackState) Assertions.checkNotNull(this.adPlaybackStates.get(period2.uid)));
            }
            window.positionInFirstPeriodUs = mediaPeriodPositionUsForContent;
            return window;
        }
    }

    public static final class SharedMediaPeriod implements MediaPeriod.Callback {
        private final Map<Long, Pair<LoadEventInfo, MediaLoadData>> activeLoads = new HashMap();
        private final MediaPeriod actualMediaPeriod;
        private AdPlaybackState adPlaybackState;
        private boolean hasStartedPreparing;
        private boolean isPrepared;
        public MediaLoadData[] lastDownstreamFormatChangeData = new MediaLoadData[0];
        /* access modifiers changed from: private */
        @Nullable
        public MediaPeriodImpl loadingPeriod;
        /* access modifiers changed from: private */
        public final List<MediaPeriodImpl> mediaPeriods = new ArrayList();
        /* access modifiers changed from: private */
        public final Object periodUid;
        public SampleStream[] sampleStreams = new SampleStream[0];
        public ExoTrackSelection[] trackSelections = new ExoTrackSelection[0];

        public SharedMediaPeriod(MediaPeriod mediaPeriod, Object obj, AdPlaybackState adPlaybackState2) {
            this.actualMediaPeriod = mediaPeriod;
            this.periodUid = obj;
            this.adPlaybackState = adPlaybackState2;
        }

        private int findMatchingStreamIndex(MediaLoadData mediaLoadData) {
            boolean z11;
            String str;
            if (mediaLoadData.trackFormat == null) {
                return -1;
            }
            int i11 = 0;
            loop0:
            while (true) {
                ExoTrackSelection[] exoTrackSelectionArr = this.trackSelections;
                if (i11 >= exoTrackSelectionArr.length) {
                    return -1;
                }
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i11];
                if (exoTrackSelection != null) {
                    TrackGroup trackGroup = exoTrackSelection.getTrackGroup();
                    if (mediaLoadData.trackType != 0 || !trackGroup.equals(getTrackGroups().get(0))) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    for (int i12 = 0; i12 < trackGroup.length; i12++) {
                        Format format = trackGroup.getFormat(i12);
                        if (format.equals(mediaLoadData.trackFormat) || (z11 && (str = format.f34900id) != null && str.equals(mediaLoadData.trackFormat.f34900id))) {
                            return i11;
                        }
                    }
                    continue;
                }
                i11++;
            }
            return i11;
        }

        private long getMediaPeriodPositionUsWithEndOfSourceHandling(MediaPeriodImpl mediaPeriodImpl, long j11) {
            if (j11 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            long mediaPeriodPositionUs = ServerSideAdInsertionUtil.getMediaPeriodPositionUs(j11, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState);
            if (mediaPeriodPositionUs >= ServerSideAdInsertionMediaSource.getMediaPeriodEndPositionUs(mediaPeriodImpl, this.adPlaybackState)) {
                return Long.MIN_VALUE;
            }
            return mediaPeriodPositionUs;
        }

        private long getStreamPositionUsWithNotYetStartedHandling(MediaPeriodImpl mediaPeriodImpl, long j11) {
            long j12 = mediaPeriodImpl.lastStartPositionUs;
            if (j11 < j12) {
                return ServerSideAdInsertionUtil.getStreamPositionUs(j12, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState) - (mediaPeriodImpl.lastStartPositionUs - j11);
            }
            return ServerSideAdInsertionUtil.getStreamPositionUs(j11, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState);
        }

        private void maybeNotifyDownstreamFormatChanged(MediaPeriodImpl mediaPeriodImpl, int i11) {
            MediaLoadData mediaLoadData;
            boolean[] zArr = mediaPeriodImpl.hasNotifiedDownstreamFormatChange;
            if (!zArr[i11] && (mediaLoadData = this.lastDownstreamFormatChangeData[i11]) != null) {
                zArr[i11] = true;
                mediaPeriodImpl.mediaSourceEventDispatcher.downstreamFormatChanged(ServerSideAdInsertionMediaSource.correctMediaLoadData(mediaPeriodImpl, mediaLoadData, this.adPlaybackState));
            }
        }

        public void add(MediaPeriodImpl mediaPeriodImpl) {
            this.mediaPeriods.add(mediaPeriodImpl);
        }

        public boolean canReuseMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, long j11) {
            MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) Iterables.getLast(this.mediaPeriods);
            if (ServerSideAdInsertionUtil.getStreamPositionUs(j11, mediaPeriodId, this.adPlaybackState) == ServerSideAdInsertionUtil.getStreamPositionUs(ServerSideAdInsertionMediaSource.getMediaPeriodEndPositionUs(mediaPeriodImpl, this.adPlaybackState), mediaPeriodImpl.mediaPeriodId, this.adPlaybackState)) {
                return true;
            }
            return false;
        }

        public boolean continueLoading(MediaPeriodImpl mediaPeriodImpl, long j11) {
            MediaPeriodImpl mediaPeriodImpl2 = this.loadingPeriod;
            if (mediaPeriodImpl2 != null && !mediaPeriodImpl.equals(mediaPeriodImpl2)) {
                for (Pair next : this.activeLoads.values()) {
                    mediaPeriodImpl2.mediaSourceEventDispatcher.loadCompleted((LoadEventInfo) next.first, ServerSideAdInsertionMediaSource.correctMediaLoadData(mediaPeriodImpl2, (MediaLoadData) next.second, this.adPlaybackState));
                    mediaPeriodImpl.mediaSourceEventDispatcher.loadStarted((LoadEventInfo) next.first, ServerSideAdInsertionMediaSource.correctMediaLoadData(mediaPeriodImpl, (MediaLoadData) next.second, this.adPlaybackState));
                }
            }
            this.loadingPeriod = mediaPeriodImpl;
            return this.actualMediaPeriod.continueLoading(getStreamPositionUsWithNotYetStartedHandling(mediaPeriodImpl, j11));
        }

        public void discardBuffer(MediaPeriodImpl mediaPeriodImpl, long j11, boolean z11) {
            this.actualMediaPeriod.discardBuffer(ServerSideAdInsertionUtil.getStreamPositionUs(j11, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState), z11);
        }

        public long getAdjustedSeekPositionUs(MediaPeriodImpl mediaPeriodImpl, long j11, SeekParameters seekParameters) {
            return ServerSideAdInsertionUtil.getMediaPeriodPositionUs(this.actualMediaPeriod.getAdjustedSeekPositionUs(ServerSideAdInsertionUtil.getStreamPositionUs(j11, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState), seekParameters), mediaPeriodImpl.mediaPeriodId, this.adPlaybackState);
        }

        public long getBufferedPositionUs(MediaPeriodImpl mediaPeriodImpl) {
            return getMediaPeriodPositionUsWithEndOfSourceHandling(mediaPeriodImpl, this.actualMediaPeriod.getBufferedPositionUs());
        }

        @Nullable
        public MediaPeriodImpl getMediaPeriodForEvent(@Nullable MediaLoadData mediaLoadData) {
            if (mediaLoadData == null || mediaLoadData.mediaStartTimeMs == C.TIME_UNSET) {
                return null;
            }
            for (int i11 = 0; i11 < this.mediaPeriods.size(); i11++) {
                MediaPeriodImpl mediaPeriodImpl = this.mediaPeriods.get(i11);
                long mediaPeriodPositionUs = ServerSideAdInsertionUtil.getMediaPeriodPositionUs(Util.msToUs(mediaLoadData.mediaStartTimeMs), mediaPeriodImpl.mediaPeriodId, this.adPlaybackState);
                long access$300 = ServerSideAdInsertionMediaSource.getMediaPeriodEndPositionUs(mediaPeriodImpl, this.adPlaybackState);
                if (mediaPeriodPositionUs >= 0 && mediaPeriodPositionUs < access$300) {
                    return mediaPeriodImpl;
                }
            }
            return null;
        }

        public long getNextLoadPositionUs(MediaPeriodImpl mediaPeriodImpl) {
            return getMediaPeriodPositionUsWithEndOfSourceHandling(mediaPeriodImpl, this.actualMediaPeriod.getNextLoadPositionUs());
        }

        public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
            return this.actualMediaPeriod.getStreamKeys(list);
        }

        public TrackGroupArray getTrackGroups() {
            return this.actualMediaPeriod.getTrackGroups();
        }

        public boolean isLoading(MediaPeriodImpl mediaPeriodImpl) {
            return mediaPeriodImpl.equals(this.loadingPeriod) && this.actualMediaPeriod.isLoading();
        }

        public boolean isReady(int i11) {
            return ((SampleStream) Util.castNonNull(this.sampleStreams[i11])).isReady();
        }

        public boolean isUnused() {
            return this.mediaPeriods.isEmpty();
        }

        public void maybeThrowError(int i11) throws IOException {
            ((SampleStream) Util.castNonNull(this.sampleStreams[i11])).maybeThrowError();
        }

        public void maybeThrowPrepareError() throws IOException {
            this.actualMediaPeriod.maybeThrowPrepareError();
        }

        public void onDownstreamFormatChanged(MediaPeriodImpl mediaPeriodImpl, MediaLoadData mediaLoadData) {
            int findMatchingStreamIndex = findMatchingStreamIndex(mediaLoadData);
            if (findMatchingStreamIndex != -1) {
                this.lastDownstreamFormatChangeData[findMatchingStreamIndex] = mediaLoadData;
                mediaPeriodImpl.hasNotifiedDownstreamFormatChange[findMatchingStreamIndex] = true;
            }
        }

        public void onLoadFinished(LoadEventInfo loadEventInfo) {
            this.activeLoads.remove(Long.valueOf(loadEventInfo.loadTaskId));
        }

        public void onLoadStarted(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            this.activeLoads.put(Long.valueOf(loadEventInfo.loadTaskId), Pair.create(loadEventInfo, mediaLoadData));
        }

        public void onPrepared(MediaPeriod mediaPeriod) {
            this.isPrepared = true;
            for (int i11 = 0; i11 < this.mediaPeriods.size(); i11++) {
                MediaPeriodImpl mediaPeriodImpl = this.mediaPeriods.get(i11);
                MediaPeriod.Callback callback = mediaPeriodImpl.callback;
                if (callback != null) {
                    callback.onPrepared(mediaPeriodImpl);
                }
            }
        }

        public void prepare(MediaPeriodImpl mediaPeriodImpl, long j11) {
            mediaPeriodImpl.lastStartPositionUs = j11;
            if (!this.hasStartedPreparing) {
                this.hasStartedPreparing = true;
                this.actualMediaPeriod.prepare(this, ServerSideAdInsertionUtil.getStreamPositionUs(j11, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState));
            } else if (this.isPrepared) {
                ((MediaPeriod.Callback) Assertions.checkNotNull(mediaPeriodImpl.callback)).onPrepared(mediaPeriodImpl);
            }
        }

        public int readData(MediaPeriodImpl mediaPeriodImpl, int i11, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i12) {
            int readData = ((SampleStream) Util.castNonNull(this.sampleStreams[i11])).readData(formatHolder, decoderInputBuffer, i12 | 1 | 4);
            long mediaPeriodPositionUsWithEndOfSourceHandling = getMediaPeriodPositionUsWithEndOfSourceHandling(mediaPeriodImpl, decoderInputBuffer.timeUs);
            if ((readData == -4 && mediaPeriodPositionUsWithEndOfSourceHandling == Long.MIN_VALUE) || (readData == -3 && getBufferedPositionUs(mediaPeriodImpl) == Long.MIN_VALUE && !decoderInputBuffer.waitingForKeys)) {
                maybeNotifyDownstreamFormatChanged(mediaPeriodImpl, i11);
                decoderInputBuffer.clear();
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            if (readData == -4) {
                maybeNotifyDownstreamFormatChanged(mediaPeriodImpl, i11);
                ((SampleStream) Util.castNonNull(this.sampleStreams[i11])).readData(formatHolder, decoderInputBuffer, i12);
                decoderInputBuffer.timeUs = mediaPeriodPositionUsWithEndOfSourceHandling;
            }
            return readData;
        }

        public long readDiscontinuity(MediaPeriodImpl mediaPeriodImpl) {
            if (!mediaPeriodImpl.equals(this.mediaPeriods.get(0))) {
                return C.TIME_UNSET;
            }
            long readDiscontinuity = this.actualMediaPeriod.readDiscontinuity();
            if (readDiscontinuity == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            return ServerSideAdInsertionUtil.getMediaPeriodPositionUs(readDiscontinuity, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState);
        }

        public void reevaluateBuffer(MediaPeriodImpl mediaPeriodImpl, long j11) {
            this.actualMediaPeriod.reevaluateBuffer(getStreamPositionUsWithNotYetStartedHandling(mediaPeriodImpl, j11));
        }

        public void release(MediaSource mediaSource) {
            mediaSource.releasePeriod(this.actualMediaPeriod);
        }

        public void remove(MediaPeriodImpl mediaPeriodImpl) {
            if (mediaPeriodImpl.equals(this.loadingPeriod)) {
                this.loadingPeriod = null;
                this.activeLoads.clear();
            }
            this.mediaPeriods.remove(mediaPeriodImpl);
        }

        public long seekToUs(MediaPeriodImpl mediaPeriodImpl, long j11) {
            return ServerSideAdInsertionUtil.getMediaPeriodPositionUs(this.actualMediaPeriod.seekToUs(ServerSideAdInsertionUtil.getStreamPositionUs(j11, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState)), mediaPeriodImpl.mediaPeriodId, this.adPlaybackState);
        }

        public long selectTracks(MediaPeriodImpl mediaPeriodImpl, ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j11) {
            SampleStream sampleStream;
            SampleStream[] sampleStreamArr2;
            MediaPeriodImpl mediaPeriodImpl2 = mediaPeriodImpl;
            ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
            long j12 = j11;
            mediaPeriodImpl2.lastStartPositionUs = j12;
            if (mediaPeriodImpl.equals(this.mediaPeriods.get(0))) {
                this.trackSelections = (ExoTrackSelection[]) Arrays.copyOf(exoTrackSelectionArr, exoTrackSelectionArr2.length);
                long streamPositionUs = ServerSideAdInsertionUtil.getStreamPositionUs(j12, mediaPeriodImpl2.mediaPeriodId, this.adPlaybackState);
                SampleStream[] sampleStreamArr3 = this.sampleStreams;
                if (sampleStreamArr3.length == 0) {
                    sampleStreamArr2 = new SampleStream[exoTrackSelectionArr2.length];
                } else {
                    sampleStreamArr2 = (SampleStream[]) Arrays.copyOf(sampleStreamArr3, sampleStreamArr3.length);
                }
                SampleStream[] sampleStreamArr4 = sampleStreamArr2;
                long selectTracks = this.actualMediaPeriod.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr4, zArr2, streamPositionUs);
                this.sampleStreams = (SampleStream[]) Arrays.copyOf(sampleStreamArr4, sampleStreamArr4.length);
                this.lastDownstreamFormatChangeData = (MediaLoadData[]) Arrays.copyOf(this.lastDownstreamFormatChangeData, sampleStreamArr4.length);
                for (int i11 = 0; i11 < sampleStreamArr4.length; i11++) {
                    if (sampleStreamArr4[i11] == null) {
                        sampleStreamArr[i11] = null;
                        this.lastDownstreamFormatChangeData[i11] = null;
                    } else if (sampleStreamArr[i11] == null || zArr2[i11]) {
                        sampleStreamArr[i11] = new SampleStreamImpl(mediaPeriodImpl, i11);
                        this.lastDownstreamFormatChangeData[i11] = null;
                    }
                }
                return ServerSideAdInsertionUtil.getMediaPeriodPositionUs(selectTracks, mediaPeriodImpl2.mediaPeriodId, this.adPlaybackState);
            }
            for (int i12 = 0; i12 < exoTrackSelectionArr2.length; i12++) {
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr2[i12];
                boolean z11 = true;
                if (exoTrackSelection != null) {
                    if (zArr[i12] && sampleStreamArr[i12] != null) {
                        z11 = false;
                    }
                    zArr2[i12] = z11;
                    if (z11) {
                        if (Util.areEqual(this.trackSelections[i12], exoTrackSelection)) {
                            sampleStream = new SampleStreamImpl(mediaPeriodImpl, i12);
                        } else {
                            sampleStream = new EmptySampleStream();
                        }
                        sampleStreamArr[i12] = sampleStream;
                    }
                } else {
                    sampleStreamArr[i12] = null;
                    zArr2[i12] = true;
                }
            }
            return j12;
        }

        public int skipData(MediaPeriodImpl mediaPeriodImpl, int i11, long j11) {
            return ((SampleStream) Util.castNonNull(this.sampleStreams[i11])).skipData(ServerSideAdInsertionUtil.getStreamPositionUs(j11, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState));
        }

        public void updateAdPlaybackState(AdPlaybackState adPlaybackState2) {
            this.adPlaybackState = adPlaybackState2;
        }

        public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
            MediaPeriodImpl mediaPeriodImpl = this.loadingPeriod;
            if (mediaPeriodImpl != null) {
                ((MediaPeriod.Callback) Assertions.checkNotNull(mediaPeriodImpl.callback)).onContinueLoadingRequested(this.loadingPeriod);
            }
        }
    }

    public ServerSideAdInsertionMediaSource(MediaSource mediaSource2, @Nullable AdPlaybackStateUpdater adPlaybackStateUpdater2) {
        this.mediaSource = mediaSource2;
        this.adPlaybackStateUpdater = adPlaybackStateUpdater2;
    }

    /* access modifiers changed from: private */
    public static MediaLoadData correctMediaLoadData(MediaPeriodImpl mediaPeriodImpl, MediaLoadData mediaLoadData, AdPlaybackState adPlaybackState) {
        return new MediaLoadData(mediaLoadData.dataType, mediaLoadData.trackType, mediaLoadData.trackFormat, mediaLoadData.trackSelectionReason, mediaLoadData.trackSelectionData, correctMediaLoadDataPositionMs(mediaLoadData.mediaStartTimeMs, mediaPeriodImpl, adPlaybackState), correctMediaLoadDataPositionMs(mediaLoadData.mediaEndTimeMs, mediaPeriodImpl, adPlaybackState));
    }

    private static long correctMediaLoadDataPositionMs(long j11, MediaPeriodImpl mediaPeriodImpl, AdPlaybackState adPlaybackState) {
        long j12;
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long msToUs = Util.msToUs(j11);
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodImpl.mediaPeriodId;
        if (mediaPeriodId.isAd()) {
            j12 = ServerSideAdInsertionUtil.getMediaPeriodPositionUsForAd(msToUs, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, adPlaybackState);
        } else {
            j12 = ServerSideAdInsertionUtil.getMediaPeriodPositionUsForContent(msToUs, -1, adPlaybackState);
        }
        return Util.usToMs(j12);
    }

    /* access modifiers changed from: private */
    public static long getMediaPeriodEndPositionUs(MediaPeriodImpl mediaPeriodImpl, AdPlaybackState adPlaybackState) {
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodImpl.mediaPeriodId;
        if (mediaPeriodId.isAd()) {
            AdPlaybackState.AdGroup adGroup = adPlaybackState.getAdGroup(mediaPeriodId.adGroupIndex);
            if (adGroup.count == -1) {
                return 0;
            }
            return adGroup.durationsUs[mediaPeriodId.adIndexInAdGroup];
        }
        int i11 = mediaPeriodId.nextAdGroupIndex;
        if (i11 == -1) {
            return Long.MAX_VALUE;
        }
        long j11 = adPlaybackState.getAdGroup(i11).timeUs;
        if (j11 == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return j11;
    }

    @Nullable
    private MediaPeriodImpl getMediaPeriodForEvent(@Nullable MediaSource.MediaPeriodId mediaPeriodId, @Nullable MediaLoadData mediaLoadData, boolean z11) {
        if (mediaPeriodId == null) {
            return null;
        }
        List list = this.mediaPeriods.get((Object) new Pair(Long.valueOf(mediaPeriodId.windowSequenceNumber), mediaPeriodId.periodUid));
        if (list.isEmpty()) {
            return null;
        }
        if (z11) {
            SharedMediaPeriod sharedMediaPeriod = (SharedMediaPeriod) Iterables.getLast(list);
            if (sharedMediaPeriod.loadingPeriod != null) {
                return sharedMediaPeriod.loadingPeriod;
            }
            return (MediaPeriodImpl) Iterables.getLast(sharedMediaPeriod.mediaPeriods);
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            MediaPeriodImpl mediaPeriodForEvent = ((SharedMediaPeriod) list.get(i11)).getMediaPeriodForEvent(mediaLoadData);
            if (mediaPeriodForEvent != null) {
                return mediaPeriodForEvent;
            }
        }
        return (MediaPeriodImpl) ((SharedMediaPeriod) list.get(0)).mediaPeriods.get(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setAdPlaybackStates$0(ImmutableMap immutableMap) {
        AdPlaybackState adPlaybackState;
        for (SharedMediaPeriod next : this.mediaPeriods.values()) {
            AdPlaybackState adPlaybackState2 = (AdPlaybackState) immutableMap.get(next.periodUid);
            if (adPlaybackState2 != null) {
                next.updateAdPlaybackState(adPlaybackState2);
            }
        }
        SharedMediaPeriod sharedMediaPeriod = this.lastUsedMediaPeriod;
        if (!(sharedMediaPeriod == null || (adPlaybackState = (AdPlaybackState) immutableMap.get(sharedMediaPeriod.periodUid)) == null)) {
            this.lastUsedMediaPeriod.updateAdPlaybackState(adPlaybackState);
        }
        this.adPlaybackStates = immutableMap;
        if (this.contentTimeline != null) {
            refreshSourceInfo(new ServerSideAdInsertionTimeline(this.contentTimeline, immutableMap));
        }
    }

    private void releaseLastUsedMediaPeriod() {
        SharedMediaPeriod sharedMediaPeriod = this.lastUsedMediaPeriod;
        if (sharedMediaPeriod != null) {
            sharedMediaPeriod.release(this.mediaSource);
            this.lastUsedMediaPeriod = null;
        }
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        SharedMediaPeriod sharedMediaPeriod;
        Pair pair = new Pair(Long.valueOf(mediaPeriodId.windowSequenceNumber), mediaPeriodId.periodUid);
        SharedMediaPeriod sharedMediaPeriod2 = this.lastUsedMediaPeriod;
        boolean z11 = false;
        if (sharedMediaPeriod2 != null) {
            if (sharedMediaPeriod2.periodUid.equals(mediaPeriodId.periodUid)) {
                sharedMediaPeriod = this.lastUsedMediaPeriod;
                this.mediaPeriods.put(pair, sharedMediaPeriod);
                z11 = true;
            } else {
                this.lastUsedMediaPeriod.release(this.mediaSource);
                sharedMediaPeriod = null;
            }
            this.lastUsedMediaPeriod = null;
        } else {
            sharedMediaPeriod = null;
        }
        if (sharedMediaPeriod == null && ((sharedMediaPeriod = (SharedMediaPeriod) Iterables.getLast(this.mediaPeriods.get((Object) pair), null)) == null || !sharedMediaPeriod.canReuseMediaPeriod(mediaPeriodId, j11))) {
            AdPlaybackState adPlaybackState = (AdPlaybackState) Assertions.checkNotNull(this.adPlaybackStates.get(mediaPeriodId.periodUid));
            SharedMediaPeriod sharedMediaPeriod3 = new SharedMediaPeriod(this.mediaSource.createPeriod(new MediaSource.MediaPeriodId(mediaPeriodId.periodUid, mediaPeriodId.windowSequenceNumber), allocator, ServerSideAdInsertionUtil.getStreamPositionUs(j11, mediaPeriodId, adPlaybackState)), mediaPeriodId.periodUid, adPlaybackState);
            this.mediaPeriods.put(pair, sharedMediaPeriod3);
            sharedMediaPeriod = sharedMediaPeriod3;
        }
        MediaPeriodImpl mediaPeriodImpl = new MediaPeriodImpl(sharedMediaPeriod, mediaPeriodId, createEventDispatcher(mediaPeriodId), createDrmEventDispatcher(mediaPeriodId));
        sharedMediaPeriod.add(mediaPeriodImpl);
        if (z11 && sharedMediaPeriod.trackSelections.length > 0) {
            mediaPeriodImpl.seekToUs(j11);
        }
        return mediaPeriodImpl;
    }

    public void disableInternal() {
        releaseLastUsedMediaPeriod();
        this.mediaSource.disable(this);
    }

    public void enableInternal() {
        this.mediaSource.enable(this);
    }

    public MediaItem getMediaItem() {
        return this.mediaSource.getMediaItem();
    }

    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.mediaSource.maybeThrowSourceInfoRefreshError();
    }

    public void onDownstreamFormatChanged(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, mediaLoadData, false);
        if (mediaPeriodForEvent == null) {
            this.mediaSourceEventDispatcherWithoutId.downstreamFormatChanged(mediaLoadData);
            return;
        }
        mediaPeriodForEvent.sharedPeriod.onDownstreamFormatChanged(mediaPeriodForEvent, mediaLoadData);
        mediaPeriodForEvent.mediaSourceEventDispatcher.downstreamFormatChanged(correctMediaLoadData(mediaPeriodForEvent, mediaLoadData, (AdPlaybackState) Assertions.checkNotNull(this.adPlaybackStates.get(mediaPeriodForEvent.mediaPeriodId.periodUid))));
    }

    public void onDrmKeysLoaded(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, (MediaLoadData) null, false);
        if (mediaPeriodForEvent == null) {
            this.drmEventDispatcherWithoutId.drmKeysLoaded();
        } else {
            mediaPeriodForEvent.drmEventDispatcher.drmKeysLoaded();
        }
    }

    public void onDrmKeysRemoved(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, (MediaLoadData) null, false);
        if (mediaPeriodForEvent == null) {
            this.drmEventDispatcherWithoutId.drmKeysRemoved();
        } else {
            mediaPeriodForEvent.drmEventDispatcher.drmKeysRemoved();
        }
    }

    public void onDrmKeysRestored(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, (MediaLoadData) null, false);
        if (mediaPeriodForEvent == null) {
            this.drmEventDispatcherWithoutId.drmKeysRestored();
        } else {
            mediaPeriodForEvent.drmEventDispatcher.drmKeysRestored();
        }
    }

    public /* synthetic */ void onDrmSessionAcquired(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
        e.d(this, i11, mediaPeriodId);
    }

    public void onDrmSessionAcquired(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, int i12) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, (MediaLoadData) null, true);
        if (mediaPeriodForEvent == null) {
            this.drmEventDispatcherWithoutId.drmSessionAcquired(i12);
        } else {
            mediaPeriodForEvent.drmEventDispatcher.drmSessionAcquired(i12);
        }
    }

    public void onDrmSessionManagerError(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, (MediaLoadData) null, false);
        if (mediaPeriodForEvent == null) {
            this.drmEventDispatcherWithoutId.drmSessionManagerError(exc);
        } else {
            mediaPeriodForEvent.drmEventDispatcher.drmSessionManagerError(exc);
        }
    }

    public void onDrmSessionReleased(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, (MediaLoadData) null, false);
        if (mediaPeriodForEvent == null) {
            this.drmEventDispatcherWithoutId.drmSessionReleased();
        } else {
            mediaPeriodForEvent.drmEventDispatcher.drmSessionReleased();
        }
    }

    public void onLoadCanceled(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodForEvent == null) {
            this.mediaSourceEventDispatcherWithoutId.loadCanceled(loadEventInfo, mediaLoadData);
            return;
        }
        mediaPeriodForEvent.sharedPeriod.onLoadFinished(loadEventInfo);
        mediaPeriodForEvent.mediaSourceEventDispatcher.loadCanceled(loadEventInfo, correctMediaLoadData(mediaPeriodForEvent, mediaLoadData, (AdPlaybackState) Assertions.checkNotNull(this.adPlaybackStates.get(mediaPeriodForEvent.mediaPeriodId.periodUid))));
    }

    public void onLoadCompleted(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodForEvent == null) {
            this.mediaSourceEventDispatcherWithoutId.loadCompleted(loadEventInfo, mediaLoadData);
            return;
        }
        mediaPeriodForEvent.sharedPeriod.onLoadFinished(loadEventInfo);
        mediaPeriodForEvent.mediaSourceEventDispatcher.loadCompleted(loadEventInfo, correctMediaLoadData(mediaPeriodForEvent, mediaLoadData, (AdPlaybackState) Assertions.checkNotNull(this.adPlaybackStates.get(mediaPeriodForEvent.mediaPeriodId.periodUid))));
    }

    public void onLoadError(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodForEvent == null) {
            this.mediaSourceEventDispatcherWithoutId.loadError(loadEventInfo, mediaLoadData, iOException, z11);
            return;
        }
        if (z11) {
            mediaPeriodForEvent.sharedPeriod.onLoadFinished(loadEventInfo);
        }
        mediaPeriodForEvent.mediaSourceEventDispatcher.loadError(loadEventInfo, correctMediaLoadData(mediaPeriodForEvent, mediaLoadData, (AdPlaybackState) Assertions.checkNotNull(this.adPlaybackStates.get(mediaPeriodForEvent.mediaPeriodId.periodUid))), iOException, z11);
    }

    public void onLoadStarted(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodForEvent == null) {
            this.mediaSourceEventDispatcherWithoutId.loadStarted(loadEventInfo, mediaLoadData);
            return;
        }
        mediaPeriodForEvent.sharedPeriod.onLoadStarted(loadEventInfo, mediaLoadData);
        mediaPeriodForEvent.mediaSourceEventDispatcher.loadStarted(loadEventInfo, correctMediaLoadData(mediaPeriodForEvent, mediaLoadData, (AdPlaybackState) Assertions.checkNotNull(this.adPlaybackStates.get(mediaPeriodForEvent.mediaPeriodId.periodUid))));
    }

    public void onSourceInfoRefreshed(MediaSource mediaSource2, Timeline timeline) {
        this.contentTimeline = timeline;
        AdPlaybackStateUpdater adPlaybackStateUpdater2 = this.adPlaybackStateUpdater;
        if ((adPlaybackStateUpdater2 == null || !adPlaybackStateUpdater2.onAdPlaybackStateUpdateRequested(timeline)) && !this.adPlaybackStates.isEmpty()) {
            refreshSourceInfo(new ServerSideAdInsertionTimeline(timeline, this.adPlaybackStates));
        }
    }

    public void onUpstreamDiscarded(int i11, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, mediaLoadData, false);
        if (mediaPeriodForEvent == null) {
            this.mediaSourceEventDispatcherWithoutId.upstreamDiscarded(mediaLoadData);
        } else {
            mediaPeriodForEvent.mediaSourceEventDispatcher.upstreamDiscarded(correctMediaLoadData(mediaPeriodForEvent, mediaLoadData, (AdPlaybackState) Assertions.checkNotNull(this.adPlaybackStates.get(mediaPeriodForEvent.mediaPeriodId.periodUid))));
        }
    }

    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        Handler createHandlerForCurrentLooper = Util.createHandlerForCurrentLooper();
        synchronized (this) {
            this.playbackHandler = createHandlerForCurrentLooper;
        }
        this.mediaSource.addEventListener(createHandlerForCurrentLooper, this);
        this.mediaSource.addDrmEventListener(createHandlerForCurrentLooper, this);
        this.mediaSource.prepareSource(this, transferListener, getPlayerId());
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) mediaPeriod;
        mediaPeriodImpl.sharedPeriod.remove(mediaPeriodImpl);
        if (mediaPeriodImpl.sharedPeriod.isUnused()) {
            this.mediaPeriods.remove(new Pair(Long.valueOf(mediaPeriodImpl.mediaPeriodId.windowSequenceNumber), mediaPeriodImpl.mediaPeriodId.periodUid), mediaPeriodImpl.sharedPeriod);
            if (this.mediaPeriods.isEmpty()) {
                this.lastUsedMediaPeriod = mediaPeriodImpl.sharedPeriod;
            } else {
                mediaPeriodImpl.sharedPeriod.release(this.mediaSource);
            }
        }
    }

    public void releaseSourceInternal() {
        releaseLastUsedMediaPeriod();
        this.contentTimeline = null;
        synchronized (this) {
            this.playbackHandler = null;
        }
        this.mediaSource.releaseSource(this);
        this.mediaSource.removeEventListener(this);
        this.mediaSource.removeDrmEventListener(this);
    }

    public void setAdPlaybackStates(ImmutableMap<Object, AdPlaybackState> immutableMap) {
        boolean z11;
        boolean z12;
        boolean z13;
        Assertions.checkArgument(!immutableMap.isEmpty());
        Object checkNotNull = Assertions.checkNotNull(immutableMap.values().asList().get(0).adsId);
        UnmodifiableIterator<Map.Entry<Object, AdPlaybackState>> it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            Object key = next.getKey();
            AdPlaybackState adPlaybackState = (AdPlaybackState) next.getValue();
            Assertions.checkArgument(Util.areEqual(checkNotNull, adPlaybackState.adsId));
            AdPlaybackState adPlaybackState2 = this.adPlaybackStates.get(key);
            if (adPlaybackState2 != null) {
                for (int i11 = adPlaybackState.removedAdGroupCount; i11 < adPlaybackState.adGroupCount; i11++) {
                    AdPlaybackState.AdGroup adGroup = adPlaybackState.getAdGroup(i11);
                    Assertions.checkArgument(adGroup.isServerSideInserted);
                    if (i11 < adPlaybackState2.adGroupCount && ServerSideAdInsertionUtil.getAdCountInGroup(adPlaybackState, i11) < ServerSideAdInsertionUtil.getAdCountInGroup(adPlaybackState2, i11)) {
                        AdPlaybackState.AdGroup adGroup2 = adPlaybackState.getAdGroup(i11 + 1);
                        if (adGroup.contentResumeOffsetUs + adGroup2.contentResumeOffsetUs == adPlaybackState2.getAdGroup(i11).contentResumeOffsetUs) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        Assertions.checkArgument(z12);
                        if (adGroup.timeUs + adGroup.contentResumeOffsetUs == adGroup2.timeUs) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        Assertions.checkArgument(z13);
                    }
                    if (adGroup.timeUs == Long.MIN_VALUE) {
                        if (ServerSideAdInsertionUtil.getAdCountInGroup(adPlaybackState, i11) == 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        Assertions.checkArgument(z11);
                    }
                }
            }
        }
        synchronized (this) {
            Handler handler = this.playbackHandler;
            if (handler == null) {
                this.adPlaybackStates = immutableMap;
            } else {
                handler.post(new d(this, immutableMap));
            }
        }
    }
}
