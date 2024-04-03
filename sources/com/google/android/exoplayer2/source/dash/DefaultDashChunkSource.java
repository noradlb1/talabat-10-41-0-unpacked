package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultDashChunkSource implements DashChunkSource {
    private final int[] adaptationSetIndices;
    private final BaseUrlExclusionList baseUrlExclusionList;
    private final DataSource dataSource;
    private final long elapsedRealtimeOffsetMs;
    @Nullable
    private IOException fatalError;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int maxSegmentsPerLoad;
    private boolean missingLastSegment;
    private int periodIndex;
    @Nullable
    private final PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler;
    protected final RepresentationHolder[] representationHolders;
    private ExoTrackSelection trackSelection;
    private final int trackType;

    public static final class Factory implements DashChunkSource.Factory {
        private final ChunkExtractor.Factory chunkExtractorFactory;
        private final DataSource.Factory dataSourceFactory;
        private final int maxSegmentsPerLoad;

        public Factory(DataSource.Factory factory) {
            this(factory, 1);
        }

        public DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i11, int[] iArr, ExoTrackSelection exoTrackSelection, int i12, long j11, boolean z11, List<Format> list, @Nullable PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, @Nullable TransferListener transferListener, PlayerId playerId) {
            TransferListener transferListener2 = transferListener;
            DataSource createDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener2 != null) {
                createDataSource.addTransferListener(transferListener2);
            }
            return new DefaultDashChunkSource(this.chunkExtractorFactory, loaderErrorThrower, dashManifest, baseUrlExclusionList, i11, iArr, exoTrackSelection, i12, createDataSource, j11, this.maxSegmentsPerLoad, z11, list, playerTrackEmsgHandler, playerId);
        }

        public Factory(DataSource.Factory factory, int i11) {
            this(BundledChunkExtractor.FACTORY, factory, i11);
        }

        public Factory(ChunkExtractor.Factory factory, DataSource.Factory factory2, int i11) {
            this.chunkExtractorFactory = factory;
            this.dataSourceFactory = factory2;
            this.maxSegmentsPerLoad = i11;
        }
    }

    public static final class RepresentationHolder {
        @Nullable
        final ChunkExtractor chunkExtractor;
        /* access modifiers changed from: private */
        public final long periodDurationUs;
        public final Representation representation;
        @Nullable
        public final DashSegmentIndex segmentIndex;
        private final long segmentNumShift;
        public final BaseUrl selectedBaseUrl;

        public RepresentationHolder(long j11, Representation representation2, BaseUrl baseUrl, @Nullable ChunkExtractor chunkExtractor2, long j12, @Nullable DashSegmentIndex dashSegmentIndex) {
            this.periodDurationUs = j11;
            this.representation = representation2;
            this.selectedBaseUrl = baseUrl;
            this.segmentNumShift = j12;
            this.chunkExtractor = chunkExtractor2;
            this.segmentIndex = dashSegmentIndex;
        }

        @CheckResult
        public RepresentationHolder copyWithNewRepresentation(long j11, Representation representation2) throws BehindLiveWindowException {
            long segmentNum;
            long segmentNum2;
            long j12 = j11;
            DashSegmentIndex index = this.representation.getIndex();
            DashSegmentIndex index2 = representation2.getIndex();
            if (index == null) {
                return new RepresentationHolder(j11, representation2, this.selectedBaseUrl, this.chunkExtractor, this.segmentNumShift, index);
            } else if (!index.isExplicit()) {
                return new RepresentationHolder(j11, representation2, this.selectedBaseUrl, this.chunkExtractor, this.segmentNumShift, index2);
            } else {
                long segmentCount = index.getSegmentCount(j12);
                if (segmentCount == 0) {
                    return new RepresentationHolder(j11, representation2, this.selectedBaseUrl, this.chunkExtractor, this.segmentNumShift, index2);
                }
                long firstSegmentNum = index.getFirstSegmentNum();
                long timeUs = index.getTimeUs(firstSegmentNum);
                long j13 = (segmentCount + firstSegmentNum) - 1;
                long firstSegmentNum2 = index2.getFirstSegmentNum();
                DashSegmentIndex dashSegmentIndex = index;
                long timeUs2 = index2.getTimeUs(firstSegmentNum2);
                long j14 = firstSegmentNum;
                long j15 = this.segmentNumShift;
                int i11 = ((index.getTimeUs(j13) + index.getDurationUs(j13, j12)) > timeUs2 ? 1 : ((index.getTimeUs(j13) + index.getDurationUs(j13, j12)) == timeUs2 ? 0 : -1));
                if (i11 == 0) {
                    segmentNum = j13 + 1;
                } else if (i11 < 0) {
                    throw new BehindLiveWindowException();
                } else if (timeUs2 < timeUs) {
                    segmentNum2 = j15 - (index2.getSegmentNum(timeUs, j12) - j14);
                    return new RepresentationHolder(j11, representation2, this.selectedBaseUrl, this.chunkExtractor, segmentNum2, index2);
                } else {
                    segmentNum = dashSegmentIndex.getSegmentNum(timeUs2, j12);
                }
                segmentNum2 = j15 + (segmentNum - firstSegmentNum2);
                return new RepresentationHolder(j11, representation2, this.selectedBaseUrl, this.chunkExtractor, segmentNum2, index2);
            }
        }

        @CheckResult
        public RepresentationHolder copyWithNewSegmentIndex(DashSegmentIndex dashSegmentIndex) {
            return new RepresentationHolder(this.periodDurationUs, this.representation, this.selectedBaseUrl, this.chunkExtractor, this.segmentNumShift, dashSegmentIndex);
        }

        @CheckResult
        public RepresentationHolder copyWithNewSelectedBaseUrl(BaseUrl baseUrl) {
            return new RepresentationHolder(this.periodDurationUs, this.representation, baseUrl, this.chunkExtractor, this.segmentNumShift, this.segmentIndex);
        }

        public long getFirstAvailableSegmentNum(long j11) {
            return this.segmentIndex.getFirstAvailableSegmentNum(this.periodDurationUs, j11) + this.segmentNumShift;
        }

        public long getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.segmentNumShift;
        }

        public long getLastAvailableSegmentNum(long j11) {
            return (getFirstAvailableSegmentNum(j11) + this.segmentIndex.getAvailableSegmentCount(this.periodDurationUs, j11)) - 1;
        }

        public long getSegmentCount() {
            return this.segmentIndex.getSegmentCount(this.periodDurationUs);
        }

        public long getSegmentEndTimeUs(long j11) {
            return getSegmentStartTimeUs(j11) + this.segmentIndex.getDurationUs(j11 - this.segmentNumShift, this.periodDurationUs);
        }

        public long getSegmentNum(long j11) {
            return this.segmentIndex.getSegmentNum(j11, this.periodDurationUs) + this.segmentNumShift;
        }

        public long getSegmentStartTimeUs(long j11) {
            return this.segmentIndex.getTimeUs(j11 - this.segmentNumShift);
        }

        public RangedUri getSegmentUrl(long j11) {
            return this.segmentIndex.getSegmentUrl(j11 - this.segmentNumShift);
        }

        public boolean isSegmentAvailableAtFullNetworkSpeed(long j11, long j12) {
            if (!this.segmentIndex.isExplicit() && j12 != C.TIME_UNSET && getSegmentEndTimeUs(j11) > j12) {
                return false;
            }
            return true;
        }
    }

    public static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {
        private final long nowPeriodTimeUs;
        private final RepresentationHolder representationHolder;

        public RepresentationSegmentIterator(RepresentationHolder representationHolder2, long j11, long j12, long j13) {
            super(j11, j12);
            this.representationHolder = representationHolder2;
            this.nowPeriodTimeUs = j13;
        }

        public long getChunkEndTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentEndTimeUs(getCurrentIndex());
        }

        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentStartTimeUs(getCurrentIndex());
        }

        public DataSpec getDataSpec() {
            int i11;
            checkInBounds();
            long currentIndex = getCurrentIndex();
            RangedUri segmentUrl = this.representationHolder.getSegmentUrl(currentIndex);
            if (this.representationHolder.isSegmentAvailableAtFullNetworkSpeed(currentIndex, this.nowPeriodTimeUs)) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            RepresentationHolder representationHolder2 = this.representationHolder;
            return DashUtil.buildDataSpec(representationHolder2.representation, representationHolder2.selectedBaseUrl.url, segmentUrl, i11);
        }
    }

    public DefaultDashChunkSource(ChunkExtractor.Factory factory, LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList2, int i11, int[] iArr, ExoTrackSelection exoTrackSelection, int i12, DataSource dataSource2, long j11, int i13, boolean z11, List<Format> list, @Nullable PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2, PlayerId playerId) {
        DashManifest dashManifest2 = dashManifest;
        BaseUrlExclusionList baseUrlExclusionList3 = baseUrlExclusionList2;
        int i14 = i11;
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = dashManifest2;
        this.baseUrlExclusionList = baseUrlExclusionList3;
        this.adaptationSetIndices = iArr;
        this.trackSelection = exoTrackSelection2;
        this.trackType = i12;
        this.dataSource = dataSource2;
        this.periodIndex = i14;
        this.elapsedRealtimeOffsetMs = j11;
        this.maxSegmentsPerLoad = i13;
        this.playerTrackEmsgHandler = playerTrackEmsgHandler2;
        long periodDurationUs = dashManifest2.getPeriodDurationUs(i14);
        ArrayList<Representation> representations = getRepresentations();
        this.representationHolders = new RepresentationHolder[exoTrackSelection.length()];
        int i15 = 0;
        while (i15 < this.representationHolders.length) {
            Representation representation = representations.get(exoTrackSelection2.getIndexInTrackGroup(i15));
            BaseUrl selectBaseUrl = baseUrlExclusionList3.selectBaseUrl(representation.baseUrls);
            RepresentationHolder[] representationHolderArr = this.representationHolders;
            if (selectBaseUrl == null) {
                selectBaseUrl = representation.baseUrls.get(0);
            }
            int i16 = i15;
            representationHolderArr[i16] = new RepresentationHolder(periodDurationUs, representation, selectBaseUrl, factory.createProgressiveMediaExtractor(i12, representation.format, z11, list, playerTrackEmsgHandler2, playerId), 0, representation.getIndex());
            i15 = i16 + 1;
        }
    }

    private LoadErrorHandlingPolicy.FallbackOptions createFallbackOptions(ExoTrackSelection exoTrackSelection, List<BaseUrl> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (exoTrackSelection.isBlacklisted(i12, elapsedRealtime)) {
                i11++;
            }
        }
        int priorityCount = BaseUrlExclusionList.getPriorityCount(list);
        return new LoadErrorHandlingPolicy.FallbackOptions(priorityCount, priorityCount - this.baseUrlExclusionList.getPriorityCountAfterExclusion(list), length, i11);
    }

    private long getAvailableLiveDurationUs(long j11, long j12) {
        if (!this.manifest.dynamic || this.representationHolders[0].getSegmentCount() == 0) {
            return C.TIME_UNSET;
        }
        return Math.max(0, Math.min(getNowPeriodTimeUs(j11), this.representationHolders[0].getSegmentEndTimeUs(this.representationHolders[0].getLastAvailableSegmentNum(j11))) - j12);
    }

    private long getNowPeriodTimeUs(long j11) {
        DashManifest dashManifest = this.manifest;
        long j12 = dashManifest.availabilityStartTimeMs;
        if (j12 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        return j11 - Util.msToUs(j12 + dashManifest.getPeriod(this.periodIndex).startMs);
    }

    private ArrayList<Representation> getRepresentations() {
        List<AdaptationSet> list = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i11 : this.adaptationSetIndices) {
            arrayList.addAll(list.get(i11).representations);
        }
        return arrayList;
    }

    private long getSegmentNum(RepresentationHolder representationHolder, @Nullable MediaChunk mediaChunk, long j11, long j12, long j13) {
        if (mediaChunk != null) {
            return mediaChunk.getNextChunkIndex();
        }
        return Util.constrainValue(representationHolder.getSegmentNum(j11), j12, j13);
    }

    private RepresentationHolder updateSelectedBaseUrl(int i11) {
        RepresentationHolder representationHolder = this.representationHolders[i11];
        BaseUrl selectBaseUrl = this.baseUrlExclusionList.selectBaseUrl(representationHolder.representation.baseUrls);
        if (selectBaseUrl == null || selectBaseUrl.equals(representationHolder.selectedBaseUrl)) {
            return representationHolder;
        }
        RepresentationHolder copyWithNewSelectedBaseUrl = representationHolder.copyWithNewSelectedBaseUrl(selectBaseUrl);
        this.representationHolders[i11] = copyWithNewSelectedBaseUrl;
        return copyWithNewSelectedBaseUrl;
    }

    public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
        long j12;
        long j13 = j11;
        for (RepresentationHolder representationHolder : this.representationHolders) {
            if (representationHolder.segmentIndex != null) {
                long segmentCount = representationHolder.getSegmentCount();
                if (segmentCount != 0) {
                    long segmentNum = representationHolder.getSegmentNum(j13);
                    long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(segmentNum);
                    if (segmentStartTimeUs >= j13 || (segmentCount != -1 && segmentNum >= (representationHolder.getFirstSegmentNum() + segmentCount) - 1)) {
                        j12 = segmentStartTimeUs;
                    } else {
                        j12 = representationHolder.getSegmentStartTimeUs(segmentNum + 1);
                    }
                    return seekParameters.resolveSeekPositionUs(j11, segmentStartTimeUs, j12);
                }
            }
        }
        return j13;
    }

    public void getNextChunk(long j11, long j12, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        MediaChunk mediaChunk;
        boolean z11;
        RangedUri rangedUri;
        RangedUri rangedUri2;
        long j13;
        int i11;
        MediaChunkIterator[] mediaChunkIteratorArr;
        int i12;
        long j14;
        long j15 = j11;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.fatalError == null) {
            long j16 = j12 - j15;
            long msToUs = Util.msToUs(this.manifest.availabilityStartTimeMs) + Util.msToUs(this.manifest.getPeriod(this.periodIndex).startMs) + j12;
            PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = this.playerTrackEmsgHandler;
            if (playerTrackEmsgHandler2 == null || !playerTrackEmsgHandler2.maybeRefreshManifestBeforeLoadingNextChunk(msToUs)) {
                long msToUs2 = Util.msToUs(Util.getNowUnixTimeMs(this.elapsedRealtimeOffsetMs));
                long nowPeriodTimeUs = getNowPeriodTimeUs(msToUs2);
                if (list.isEmpty()) {
                    List<? extends MediaChunk> list2 = list;
                    mediaChunk = null;
                } else {
                    mediaChunk = (MediaChunk) list.get(list.size() - 1);
                }
                int length = this.trackSelection.length();
                MediaChunkIterator[] mediaChunkIteratorArr2 = new MediaChunkIterator[length];
                int i13 = 0;
                while (i13 < length) {
                    RepresentationHolder representationHolder = this.representationHolders[i13];
                    if (representationHolder.segmentIndex == null) {
                        mediaChunkIteratorArr2[i13] = MediaChunkIterator.EMPTY;
                        i12 = i13;
                        i11 = length;
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        j13 = j16;
                        j14 = msToUs2;
                    } else {
                        long firstAvailableSegmentNum = representationHolder.getFirstAvailableSegmentNum(msToUs2);
                        long lastAvailableSegmentNum = representationHolder.getLastAvailableSegmentNum(msToUs2);
                        i12 = i13;
                        i11 = length;
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        j13 = j16;
                        j14 = msToUs2;
                        long segmentNum = getSegmentNum(representationHolder, mediaChunk, j12, firstAvailableSegmentNum, lastAvailableSegmentNum);
                        if (segmentNum < firstAvailableSegmentNum) {
                            mediaChunkIteratorArr[i12] = MediaChunkIterator.EMPTY;
                        } else {
                            mediaChunkIteratorArr[i12] = new RepresentationSegmentIterator(updateSelectedBaseUrl(i12), segmentNum, lastAvailableSegmentNum, nowPeriodTimeUs);
                        }
                    }
                    i13 = i12 + 1;
                    List<? extends MediaChunk> list3 = list;
                    msToUs2 = j14;
                    mediaChunkIteratorArr2 = mediaChunkIteratorArr;
                    length = i11;
                    j16 = j13;
                }
                long j17 = j16;
                long j18 = msToUs2;
                this.trackSelection.updateSelectedTrack(j11, j17, getAvailableLiveDurationUs(j18, j15), list, mediaChunkIteratorArr2);
                RepresentationHolder updateSelectedBaseUrl = updateSelectedBaseUrl(this.trackSelection.getSelectedIndex());
                ChunkExtractor chunkExtractor = updateSelectedBaseUrl.chunkExtractor;
                if (chunkExtractor != null) {
                    Representation representation = updateSelectedBaseUrl.representation;
                    if (chunkExtractor.getSampleFormats() == null) {
                        rangedUri = representation.getInitializationUri();
                    } else {
                        rangedUri = null;
                    }
                    if (updateSelectedBaseUrl.segmentIndex == null) {
                        rangedUri2 = representation.getIndexUri();
                    } else {
                        rangedUri2 = null;
                    }
                    if (!(rangedUri == null && rangedUri2 == null)) {
                        chunkHolder2.chunk = newInitializationChunk(updateSelectedBaseUrl, this.dataSource, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), rangedUri, rangedUri2);
                        return;
                    }
                }
                long access$000 = updateSelectedBaseUrl.periodDurationUs;
                long j19 = C.TIME_UNSET;
                int i14 = (access$000 > C.TIME_UNSET ? 1 : (access$000 == C.TIME_UNSET ? 0 : -1));
                if (i14 != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (updateSelectedBaseUrl.getSegmentCount() == 0) {
                    chunkHolder2.endOfStream = z11;
                    return;
                }
                long firstAvailableSegmentNum2 = updateSelectedBaseUrl.getFirstAvailableSegmentNum(j18);
                long lastAvailableSegmentNum2 = updateSelectedBaseUrl.getLastAvailableSegmentNum(j18);
                long segmentNum2 = getSegmentNum(updateSelectedBaseUrl, mediaChunk, j12, firstAvailableSegmentNum2, lastAvailableSegmentNum2);
                if (segmentNum2 < firstAvailableSegmentNum2) {
                    this.fatalError = new BehindLiveWindowException();
                    return;
                }
                int i15 = (segmentNum2 > lastAvailableSegmentNum2 ? 1 : (segmentNum2 == lastAvailableSegmentNum2 ? 0 : -1));
                if (i15 > 0 || (this.missingLastSegment && i15 >= 0)) {
                    chunkHolder2.endOfStream = z11;
                } else if (!z11 || updateSelectedBaseUrl.getSegmentStartTimeUs(segmentNum2) < access$000) {
                    int min = (int) Math.min((long) this.maxSegmentsPerLoad, (lastAvailableSegmentNum2 - segmentNum2) + 1);
                    if (i14 != 0) {
                        while (min > 1 && updateSelectedBaseUrl.getSegmentStartTimeUs((((long) min) + segmentNum2) - 1) >= access$000) {
                            min--;
                        }
                    }
                    int i16 = min;
                    if (list.isEmpty()) {
                        j19 = j12;
                    }
                    chunkHolder2.chunk = newMediaChunk(updateSelectedBaseUrl, this.dataSource, this.trackType, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), segmentNum2, i16, j19, nowPeriodTimeUs);
                } else {
                    chunkHolder2.endOfStream = true;
                }
            }
        }
    }

    public int getPreferredQueueSize(long j11, List<? extends MediaChunk> list) {
        if (this.fatalError != null || this.trackSelection.length() < 2) {
            return list.size();
        }
        return this.trackSelection.evaluateQueueSize(j11, list);
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            this.manifestLoaderErrorThrower.maybeThrowError();
            return;
        }
        throw iOException;
    }

    public Chunk newInitializationChunk(RepresentationHolder representationHolder, DataSource dataSource2, Format format, int i11, @Nullable Object obj, @Nullable RangedUri rangedUri, @Nullable RangedUri rangedUri2) {
        RepresentationHolder representationHolder2 = representationHolder;
        RangedUri rangedUri3 = rangedUri;
        Representation representation = representationHolder2.representation;
        if (rangedUri3 != null) {
            RangedUri attemptMerge = rangedUri3.attemptMerge(rangedUri2, representationHolder2.selectedBaseUrl.url);
            if (attemptMerge != null) {
                rangedUri3 = attemptMerge;
            }
        } else {
            rangedUri3 = rangedUri2;
        }
        return new InitializationChunk(dataSource2, DashUtil.buildDataSpec(representation, representationHolder2.selectedBaseUrl.url, rangedUri3, 0), format, i11, obj, representationHolder2.chunkExtractor);
    }

    public Chunk newMediaChunk(RepresentationHolder representationHolder, DataSource dataSource2, int i11, Format format, int i12, Object obj, long j11, int i13, long j12, long j13) {
        long j14;
        RepresentationHolder representationHolder2 = representationHolder;
        long j15 = j11;
        long j16 = j13;
        Representation representation = representationHolder2.representation;
        long segmentStartTimeUs = representationHolder2.getSegmentStartTimeUs(j15);
        RangedUri segmentUrl = representationHolder2.getSegmentUrl(j15);
        int i14 = 0;
        if (representationHolder2.chunkExtractor == null) {
            long segmentEndTimeUs = representationHolder2.getSegmentEndTimeUs(j15);
            if (!representationHolder2.isSegmentAvailableAtFullNetworkSpeed(j15, j16)) {
                i14 = 8;
            }
            return new SingleSampleMediaChunk(dataSource2, DashUtil.buildDataSpec(representation, representationHolder2.selectedBaseUrl.url, segmentUrl, i14), format, i12, obj, segmentStartTimeUs, segmentEndTimeUs, j11, i11, format);
        }
        int i15 = 1;
        int i16 = i13;
        int i17 = 1;
        while (i15 < i16) {
            RangedUri attemptMerge = segmentUrl.attemptMerge(representationHolder2.getSegmentUrl(((long) i15) + j15), representationHolder2.selectedBaseUrl.url);
            if (attemptMerge == null) {
                break;
            }
            i17++;
            i15++;
            segmentUrl = attemptMerge;
        }
        long j17 = (((long) i17) + j15) - 1;
        long segmentEndTimeUs2 = representationHolder2.getSegmentEndTimeUs(j17);
        long access$000 = representationHolder.periodDurationUs;
        if (access$000 == C.TIME_UNSET || access$000 > segmentEndTimeUs2) {
            j14 = -9223372036854775807L;
        } else {
            j14 = access$000;
        }
        if (!representationHolder2.isSegmentAvailableAtFullNetworkSpeed(j17, j16)) {
            i14 = 8;
        }
        ChunkExtractor chunkExtractor = representationHolder2.chunkExtractor;
        return new ContainerMediaChunk(dataSource2, DashUtil.buildDataSpec(representation, representationHolder2.selectedBaseUrl.url, segmentUrl, i14), format, i12, obj, segmentStartTimeUs, segmentEndTimeUs2, j12, j14, j11, i17, -representation.presentationTimeOffsetUs, chunkExtractor);
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        ChunkIndex chunkIndex;
        if (chunk instanceof InitializationChunk) {
            int indexOf = this.trackSelection.indexOf(((InitializationChunk) chunk).trackFormat);
            RepresentationHolder representationHolder = this.representationHolders[indexOf];
            if (representationHolder.segmentIndex == null && (chunkIndex = representationHolder.chunkExtractor.getChunkIndex()) != null) {
                this.representationHolders[indexOf] = representationHolder.copyWithNewSegmentIndex(new DashWrappingSegmentIndex(chunkIndex, representationHolder.representation.presentationTimeOffsetUs));
            }
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler2 != null) {
            playerTrackEmsgHandler2.onChunkLoadCompleted(chunk);
        }
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z11, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionFor;
        if (!z11) {
            return false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler2 != null && playerTrackEmsgHandler2.onChunkLoadError(chunk)) {
            return true;
        }
        if (!this.manifest.dynamic && (chunk instanceof MediaChunk)) {
            IOException iOException = loadErrorInfo.exception;
            if ((iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode == 404) {
                RepresentationHolder representationHolder = this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)];
                long segmentCount = representationHolder.getSegmentCount();
                if (!(segmentCount == -1 || segmentCount == 0)) {
                    if (((MediaChunk) chunk).getNextChunkIndex() > (representationHolder.getFirstSegmentNum() + segmentCount) - 1) {
                        this.missingLastSegment = true;
                        return true;
                    }
                }
            }
        }
        RepresentationHolder representationHolder2 = this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)];
        BaseUrl selectBaseUrl = this.baseUrlExclusionList.selectBaseUrl(representationHolder2.representation.baseUrls);
        if (selectBaseUrl != null && !representationHolder2.selectedBaseUrl.equals(selectBaseUrl)) {
            return true;
        }
        LoadErrorHandlingPolicy.FallbackOptions createFallbackOptions = createFallbackOptions(this.trackSelection, representationHolder2.representation.baseUrls);
        if ((!createFallbackOptions.isFallbackAvailable(2) && !createFallbackOptions.isFallbackAvailable(1)) || (fallbackSelectionFor = loadErrorHandlingPolicy.getFallbackSelectionFor(createFallbackOptions, loadErrorInfo)) == null || !createFallbackOptions.isFallbackAvailable(fallbackSelectionFor.type)) {
            return false;
        }
        int i11 = fallbackSelectionFor.type;
        if (i11 == 2) {
            ExoTrackSelection exoTrackSelection = this.trackSelection;
            return exoTrackSelection.blacklist(exoTrackSelection.indexOf(chunk.trackFormat), fallbackSelectionFor.exclusionDurationMs);
        } else if (i11 != 1) {
            return false;
        } else {
            this.baseUrlExclusionList.exclude(representationHolder2.selectedBaseUrl, fallbackSelectionFor.exclusionDurationMs);
            return true;
        }
    }

    public void release() {
        for (RepresentationHolder representationHolder : this.representationHolders) {
            ChunkExtractor chunkExtractor = representationHolder.chunkExtractor;
            if (chunkExtractor != null) {
                chunkExtractor.release();
            }
        }
    }

    public boolean shouldCancelLoad(long j11, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.fatalError != null) {
            return false;
        }
        return this.trackSelection.shouldCancelChunkLoad(j11, chunk, list);
    }

    public void updateManifest(DashManifest dashManifest, int i11) {
        try {
            this.manifest = dashManifest;
            this.periodIndex = i11;
            long periodDurationUs = dashManifest.getPeriodDurationUs(i11);
            ArrayList<Representation> representations = getRepresentations();
            for (int i12 = 0; i12 < this.representationHolders.length; i12++) {
                RepresentationHolder[] representationHolderArr = this.representationHolders;
                representationHolderArr[i12] = representationHolderArr[i12].copyWithNewRepresentation(periodDurationUs, representations.get(this.trackSelection.getIndexInTrackGroup(i12)));
            }
        } catch (BehindLiveWindowException e11) {
            this.fatalError = e11;
        }
    }

    public void updateTrackSelection(ExoTrackSelection exoTrackSelection) {
        this.trackSelection = exoTrackSelection;
    }
}
