package com.google.android.exoplayer2.trackselection;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdaptiveTrackSelection extends BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.7f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MAX_HEIGHT_TO_DISCARD = 719;
    public static final int DEFAULT_MAX_WIDTH_TO_DISCARD = 1279;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    private static final long MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS = 1000;
    private static final String TAG = "AdaptiveTrackSelection";
    private final ImmutableList<AdaptationCheckpoint> adaptationCheckpoints;
    private final float bandwidthFraction;
    private final BandwidthMeter bandwidthMeter;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final Clock clock;
    @Nullable
    private MediaChunk lastBufferEvaluationMediaChunk;
    private long lastBufferEvaluationMs;
    private final long maxDurationForQualityDecreaseUs;
    private final int maxHeightToDiscard;
    private final int maxWidthToDiscard;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private float playbackSpeed;
    private int reason;
    private int selectedIndex;

    public static final class AdaptationCheckpoint {
        public final long allocatedBandwidth;
        public final long totalBandwidth;

        public AdaptationCheckpoint(long j11, long j12) {
            this.totalBandwidth = j11;
            this.allocatedBandwidth = j12;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdaptationCheckpoint)) {
                return false;
            }
            AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) obj;
            if (this.totalBandwidth == adaptationCheckpoint.totalBandwidth && this.allocatedBandwidth == adaptationCheckpoint.allocatedBandwidth) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((int) this.totalBandwidth) * 31) + ((int) this.allocatedBandwidth);
        }
    }

    public static class Factory implements ExoTrackSelection.Factory {
        private final float bandwidthFraction;
        private final float bufferedFractionToLiveEdgeForQualityIncrease;
        private final Clock clock;
        private final int maxDurationForQualityDecreaseMs;
        private final int maxHeightToDiscard;
        private final int maxWidthToDiscard;
        private final int minDurationForQualityIncreaseMs;
        private final int minDurationToRetainAfterDiscardMs;

        public Factory() {
            this(10000, 25000, 25000, 0.7f);
        }

        public AdaptiveTrackSelection createAdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i11, BandwidthMeter bandwidthMeter, ImmutableList<AdaptationCheckpoint> immutableList) {
            return new AdaptiveTrackSelection(trackGroup, iArr, i11, bandwidthMeter, (long) this.minDurationForQualityIncreaseMs, (long) this.maxDurationForQualityDecreaseMs, (long) this.minDurationToRetainAfterDiscardMs, this.maxWidthToDiscard, this.maxHeightToDiscard, this.bandwidthFraction, this.bufferedFractionToLiveEdgeForQualityIncrease, immutableList, this.clock);
        }

        public final ExoTrackSelection[] createTrackSelections(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            ExoTrackSelection exoTrackSelection;
            ImmutableList access$000 = AdaptiveTrackSelection.getAdaptationCheckpoints(definitionArr);
            ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
            for (int i11 = 0; i11 < definitionArr.length; i11++) {
                ExoTrackSelection.Definition definition = definitionArr[i11];
                if (definition != null) {
                    int[] iArr = definition.tracks;
                    if (iArr.length != 0) {
                        if (iArr.length == 1) {
                            exoTrackSelection = new FixedTrackSelection(definition.group, iArr[0], definition.type);
                        } else {
                            exoTrackSelection = createAdaptiveTrackSelection(definition.group, iArr, definition.type, bandwidthMeter, (ImmutableList) access$000.get(i11));
                        }
                        exoTrackSelectionArr[i11] = exoTrackSelection;
                    }
                }
            }
            return exoTrackSelectionArr;
        }

        public Factory(int i11, int i12, int i13, float f11) {
            this(i11, i12, i13, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, f11, 0.75f, Clock.DEFAULT);
        }

        public Factory(int i11, int i12, int i13, int i14, int i15, float f11) {
            this(i11, i12, i13, i14, i15, f11, 0.75f, Clock.DEFAULT);
        }

        public Factory(int i11, int i12, int i13, float f11, float f12, Clock clock2) {
            this(i11, i12, i13, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, f11, f12, clock2);
        }

        public Factory(int i11, int i12, int i13, int i14, int i15, float f11, float f12, Clock clock2) {
            this.minDurationForQualityIncreaseMs = i11;
            this.maxDurationForQualityDecreaseMs = i12;
            this.minDurationToRetainAfterDiscardMs = i13;
            this.maxWidthToDiscard = i14;
            this.maxHeightToDiscard = i15;
            this.bandwidthFraction = f11;
            this.bufferedFractionToLiveEdgeForQualityIncrease = f12;
            this.clock = clock2;
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter2) {
        this(trackGroup, iArr, 0, bandwidthMeter2, 10000, 25000, 25000, DEFAULT_MAX_WIDTH_TO_DISCARD, DEFAULT_MAX_HEIGHT_TO_DISCARD, 0.7f, 0.75f, ImmutableList.of(), Clock.DEFAULT);
    }

    private static void addCheckpoint(List<ImmutableList.Builder<AdaptationCheckpoint>> list, long[] jArr) {
        long j11 = 0;
        for (long j12 : jArr) {
            j11 += j12;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            ImmutableList.Builder builder = list.get(i11);
            if (builder != null) {
                builder.add((Object) new AdaptationCheckpoint(j11, jArr[i11]));
            }
        }
    }

    private int determineIdealSelectedIndex(long j11, long j12) {
        long allocatedBandwidth = getAllocatedBandwidth(j12);
        int i11 = 0;
        for (int i12 = 0; i12 < this.length; i12++) {
            if (j11 == Long.MIN_VALUE || !isBlacklisted(i12, j11)) {
                Format format = getFormat(i12);
                if (canSelectFormat(format, format.bitrate, allocatedBandwidth)) {
                    return i12;
                }
                i11 = i12;
            }
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public static ImmutableList<ImmutableList<AdaptationCheckpoint>> getAdaptationCheckpoints(ExoTrackSelection.Definition[] definitionArr) {
        ImmutableList immutableList;
        long j11;
        ArrayList arrayList = new ArrayList();
        for (ExoTrackSelection.Definition definition : definitionArr) {
            if (definition == null || definition.tracks.length <= 1) {
                arrayList.add((Object) null);
            } else {
                ImmutableList.Builder builder = ImmutableList.builder();
                builder.add((Object) new AdaptationCheckpoint(0, 0));
                arrayList.add(builder);
            }
        }
        long[][] sortedTrackBitrates = getSortedTrackBitrates(definitionArr);
        int[] iArr = new int[sortedTrackBitrates.length];
        long[] jArr = new long[sortedTrackBitrates.length];
        for (int i11 = 0; i11 < sortedTrackBitrates.length; i11++) {
            long[] jArr2 = sortedTrackBitrates[i11];
            if (jArr2.length == 0) {
                j11 = 0;
            } else {
                j11 = jArr2[0];
            }
            jArr[i11] = j11;
        }
        addCheckpoint(arrayList, jArr);
        ImmutableList<Integer> switchOrder = getSwitchOrder(sortedTrackBitrates);
        for (int i12 = 0; i12 < switchOrder.size(); i12++) {
            int intValue = switchOrder.get(i12).intValue();
            int i13 = iArr[intValue] + 1;
            iArr[intValue] = i13;
            jArr[intValue] = sortedTrackBitrates[intValue][i13];
            addCheckpoint(arrayList, jArr);
        }
        for (int i14 = 0; i14 < definitionArr.length; i14++) {
            if (arrayList.get(i14) != null) {
                jArr[i14] = jArr[i14] * 2;
            }
        }
        addCheckpoint(arrayList, jArr);
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            ImmutableList.Builder builder3 = (ImmutableList.Builder) arrayList.get(i15);
            if (builder3 == null) {
                immutableList = ImmutableList.of();
            } else {
                immutableList = builder3.build();
            }
            builder2.add((Object) immutableList);
        }
        return builder2.build();
    }

    private long getAllocatedBandwidth(long j11) {
        long totalAllocatableBandwidth = getTotalAllocatableBandwidth(j11);
        if (this.adaptationCheckpoints.isEmpty()) {
            return totalAllocatableBandwidth;
        }
        int i11 = 1;
        while (i11 < this.adaptationCheckpoints.size() - 1 && this.adaptationCheckpoints.get(i11).totalBandwidth < totalAllocatableBandwidth) {
            i11++;
        }
        AdaptationCheckpoint adaptationCheckpoint = this.adaptationCheckpoints.get(i11 - 1);
        AdaptationCheckpoint adaptationCheckpoint2 = this.adaptationCheckpoints.get(i11);
        long j12 = adaptationCheckpoint.totalBandwidth;
        long j13 = adaptationCheckpoint.allocatedBandwidth;
        return j13 + ((long) ((((float) (totalAllocatableBandwidth - j12)) / ((float) (adaptationCheckpoint2.totalBandwidth - j12))) * ((float) (adaptationCheckpoint2.allocatedBandwidth - j13))));
    }

    private long getLastChunkDurationUs(List<? extends MediaChunk> list) {
        if (list.isEmpty()) {
            return C.TIME_UNSET;
        }
        MediaChunk mediaChunk = (MediaChunk) Iterables.getLast(list);
        long j11 = mediaChunk.startTimeUs;
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j12 = mediaChunk.endTimeUs;
        if (j12 != C.TIME_UNSET) {
            return j12 - j11;
        }
        return C.TIME_UNSET;
    }

    private long getNextChunkDurationUs(MediaChunkIterator[] mediaChunkIteratorArr, List<? extends MediaChunk> list) {
        int i11 = this.selectedIndex;
        if (i11 >= mediaChunkIteratorArr.length || !mediaChunkIteratorArr[i11].next()) {
            for (MediaChunkIterator mediaChunkIterator : mediaChunkIteratorArr) {
                if (mediaChunkIterator.next()) {
                    return mediaChunkIterator.getChunkEndTimeUs() - mediaChunkIterator.getChunkStartTimeUs();
                }
            }
            return getLastChunkDurationUs(list);
        }
        MediaChunkIterator mediaChunkIterator2 = mediaChunkIteratorArr[this.selectedIndex];
        return mediaChunkIterator2.getChunkEndTimeUs() - mediaChunkIterator2.getChunkStartTimeUs();
    }

    private static long[][] getSortedTrackBitrates(ExoTrackSelection.Definition[] definitionArr) {
        long[][] jArr = new long[definitionArr.length][];
        for (int i11 = 0; i11 < definitionArr.length; i11++) {
            ExoTrackSelection.Definition definition = definitionArr[i11];
            if (definition == null) {
                jArr[i11] = new long[0];
            } else {
                jArr[i11] = new long[definition.tracks.length];
                int i12 = 0;
                while (true) {
                    int[] iArr = definition.tracks;
                    if (i12 >= iArr.length) {
                        break;
                    }
                    long j11 = (long) definition.group.getFormat(iArr[i12]).bitrate;
                    long[] jArr2 = jArr[i11];
                    if (j11 == -1) {
                        j11 = 0;
                    }
                    jArr2[i12] = j11;
                    i12++;
                }
                Arrays.sort(jArr[i11]);
            }
        }
        return jArr;
    }

    private static ImmutableList<Integer> getSwitchOrder(long[][] jArr) {
        double d11;
        ListMultimap<K, V> build = MultimapBuilder.treeKeys().arrayListValues().build();
        for (int i11 = 0; i11 < jArr.length; i11++) {
            long[] jArr2 = jArr[i11];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i12 = 0;
                while (true) {
                    long[] jArr3 = jArr[i11];
                    double d12 = 0.0d;
                    if (i12 >= jArr3.length) {
                        break;
                    }
                    long j11 = jArr3[i12];
                    if (j11 != -1) {
                        d12 = Math.log((double) j11);
                    }
                    dArr[i12] = d12;
                    i12++;
                }
                int i13 = length - 1;
                double d13 = dArr[i13] - dArr[0];
                int i14 = 0;
                while (i14 < i13) {
                    double d14 = dArr[i14];
                    i14++;
                    double d15 = (d14 + dArr[i14]) * 0.5d;
                    if (d13 == 0.0d) {
                        d11 = 1.0d;
                    } else {
                        d11 = (d15 - dArr[0]) / d13;
                    }
                    build.put(Double.valueOf(d11), Integer.valueOf(i11));
                }
            }
        }
        return ImmutableList.copyOf(build.values());
    }

    private long getTotalAllocatableBandwidth(long j11) {
        long bitrateEstimate = (long) (((float) this.bandwidthMeter.getBitrateEstimate()) * this.bandwidthFraction);
        long timeToFirstByteEstimateUs = this.bandwidthMeter.getTimeToFirstByteEstimateUs();
        if (timeToFirstByteEstimateUs == C.TIME_UNSET || j11 == C.TIME_UNSET) {
            return (long) (((float) bitrateEstimate) / this.playbackSpeed);
        }
        float f11 = (float) j11;
        return (long) ((((float) bitrateEstimate) * Math.max((f11 / this.playbackSpeed) - ((float) timeToFirstByteEstimateUs), 0.0f)) / f11);
    }

    private long minDurationForQualityIncreaseUs(long j11, long j12) {
        if (j11 == C.TIME_UNSET) {
            return this.minDurationForQualityIncreaseUs;
        }
        if (j12 != C.TIME_UNSET) {
            j11 -= j12;
        }
        return Math.min((long) (((float) j11) * this.bufferedFractionToLiveEdgeForQualityIncrease), this.minDurationForQualityIncreaseUs);
    }

    public boolean canSelectFormat(Format format, int i11, long j11) {
        return ((long) i11) <= j11;
    }

    @CallSuper
    public void disable() {
        this.lastBufferEvaluationMediaChunk = null;
    }

    @CallSuper
    public void enable() {
        this.lastBufferEvaluationMs = C.TIME_UNSET;
        this.lastBufferEvaluationMediaChunk = null;
    }

    public int evaluateQueueSize(long j11, List<? extends MediaChunk> list) {
        MediaChunk mediaChunk;
        int i11;
        int i12;
        long elapsedRealtime = this.clock.elapsedRealtime();
        if (!shouldEvaluateQueueSize(elapsedRealtime, list)) {
            return list.size();
        }
        this.lastBufferEvaluationMs = elapsedRealtime;
        if (list.isEmpty()) {
            mediaChunk = null;
        } else {
            mediaChunk = (MediaChunk) Iterables.getLast(list);
        }
        this.lastBufferEvaluationMediaChunk = mediaChunk;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(((MediaChunk) list.get(size - 1)).startTimeUs - j11, this.playbackSpeed);
        long minDurationToRetainAfterDiscardUs2 = getMinDurationToRetainAfterDiscardUs();
        if (playoutDurationForMediaDuration < minDurationToRetainAfterDiscardUs2) {
            return size;
        }
        Format format = getFormat(determineIdealSelectedIndex(elapsedRealtime, getLastChunkDurationUs(list)));
        for (int i13 = 0; i13 < size; i13++) {
            MediaChunk mediaChunk2 = (MediaChunk) list.get(i13);
            Format format2 = mediaChunk2.trackFormat;
            if (Util.getPlayoutDurationForMediaDuration(mediaChunk2.startTimeUs - j11, this.playbackSpeed) >= minDurationToRetainAfterDiscardUs2 && format2.bitrate < format.bitrate && (i11 = format2.height) != -1 && i11 <= this.maxHeightToDiscard && (i12 = format2.width) != -1 && i12 <= this.maxWidthToDiscard && i11 < format.height) {
                return i13;
            }
        }
        return size;
    }

    public long getMinDurationToRetainAfterDiscardUs() {
        return this.minDurationToRetainAfterDiscardUs;
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Nullable
    public Object getSelectionData() {
        return null;
    }

    public int getSelectionReason() {
        return this.reason;
    }

    public void onPlaybackSpeed(float f11) {
        this.playbackSpeed = f11;
    }

    public boolean shouldEvaluateQueueSize(long j11, List<? extends MediaChunk> list) {
        long j12 = this.lastBufferEvaluationMs;
        if (j12 == C.TIME_UNSET || j11 - j12 >= 1000 || (!list.isEmpty() && !((MediaChunk) Iterables.getLast(list)).equals(this.lastBufferEvaluationMediaChunk))) {
            return true;
        }
        return false;
    }

    public void updateSelectedTrack(long j11, long j12, long j13, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        int i11;
        long elapsedRealtime = this.clock.elapsedRealtime();
        long nextChunkDurationUs = getNextChunkDurationUs(mediaChunkIteratorArr, list);
        int i12 = this.reason;
        if (i12 == 0) {
            this.reason = 1;
            this.selectedIndex = determineIdealSelectedIndex(elapsedRealtime, nextChunkDurationUs);
            return;
        }
        int i13 = this.selectedIndex;
        if (list.isEmpty()) {
            i11 = -1;
        } else {
            i11 = indexOf(((MediaChunk) Iterables.getLast(list)).trackFormat);
        }
        if (i11 != -1) {
            i12 = ((MediaChunk) Iterables.getLast(list)).trackSelectionReason;
            i13 = i11;
        }
        int determineIdealSelectedIndex = determineIdealSelectedIndex(elapsedRealtime, nextChunkDurationUs);
        if (!isBlacklisted(i13, elapsedRealtime)) {
            Format format = getFormat(i13);
            Format format2 = getFormat(determineIdealSelectedIndex);
            long minDurationForQualityIncreaseUs2 = minDurationForQualityIncreaseUs(j13, nextChunkDurationUs);
            int i14 = format2.bitrate;
            int i15 = format.bitrate;
            if ((i14 > i15 && j12 < minDurationForQualityIncreaseUs2) || (i14 < i15 && j12 >= this.maxDurationForQualityDecreaseUs)) {
                determineIdealSelectedIndex = i13;
            }
        }
        if (determineIdealSelectedIndex != i13) {
            i12 = 3;
        }
        this.reason = i12;
        this.selectedIndex = determineIdealSelectedIndex;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i11, BandwidthMeter bandwidthMeter2, long j11, long j12, long j13, int i12, int i13, float f11, float f12, List<AdaptationCheckpoint> list, Clock clock2) {
        super(trackGroup, iArr, i11);
        BandwidthMeter bandwidthMeter3;
        long j14;
        if (j13 < j11) {
            Log.w(TAG, "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            bandwidthMeter3 = bandwidthMeter2;
            j14 = j11;
        } else {
            bandwidthMeter3 = bandwidthMeter2;
            j14 = j13;
        }
        this.bandwidthMeter = bandwidthMeter3;
        this.minDurationForQualityIncreaseUs = j11 * 1000;
        this.maxDurationForQualityDecreaseUs = j12 * 1000;
        this.minDurationToRetainAfterDiscardUs = j14 * 1000;
        this.maxWidthToDiscard = i12;
        this.maxHeightToDiscard = i13;
        this.bandwidthFraction = f11;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f12;
        this.adaptationCheckpoints = ImmutableList.copyOf(list);
        this.clock = clock2;
        this.playbackSpeed = 1.0f;
        this.reason = 0;
        this.lastBufferEvaluationMs = C.TIME_UNSET;
    }
}
