package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class HlsChunkSource {
    public static final int CHUNK_PUBLICATION_STATE_PRELOAD = 0;
    public static final int CHUNK_PUBLICATION_STATE_PUBLISHED = 1;
    public static final int CHUNK_PUBLICATION_STATE_REMOVED = 2;
    private static final int KEY_CACHE_SIZE = 4;
    private final DataSource encryptionDataSource;
    @Nullable
    private Uri expectedPlaylistUrl;
    private final HlsExtractorFactory extractorFactory;
    @Nullable
    private IOException fatalError;
    private boolean independentSegments;
    private boolean isTimestampMaster;
    private final FullSegmentEncryptionKeyCache keyCache = new FullSegmentEncryptionKeyCache(4);
    private long liveEdgeInPeriodTimeUs = C.TIME_UNSET;
    private final DataSource mediaDataSource;
    @Nullable
    private final List<Format> muxedCaptionFormats;
    private final PlayerId playerId;
    private final Format[] playlistFormats;
    private final HlsPlaylistTracker playlistTracker;
    private final Uri[] playlistUrls;
    private byte[] scratchSpace = Util.EMPTY_BYTE_ARRAY;
    private boolean seenExpectedPlaylistError;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    private final TrackGroup trackGroup;
    private ExoTrackSelection trackSelection;

    public static final class EncryptionKeyChunk extends DataChunk {
        private byte[] result;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i11, @Nullable Object obj, byte[] bArr) {
            super(dataSource, dataSpec, 3, format, i11, obj, bArr);
        }

        public void consume(byte[] bArr, int i11) {
            this.result = Arrays.copyOf(bArr, i11);
        }

        @Nullable
        public byte[] getResult() {
            return this.result;
        }
    }

    public static final class HlsChunkHolder {
        @Nullable
        public Chunk chunk;
        public boolean endOfStream;
        @Nullable
        public Uri playlistUrl;

        public HlsChunkHolder() {
            clear();
        }

        public void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.playlistUrl = null;
        }
    }

    @VisibleForTesting
    public static final class HlsMediaPlaylistSegmentIterator extends BaseMediaChunkIterator {
        private final String playlistBaseUri;
        private final List<HlsMediaPlaylist.SegmentBase> segmentBases;
        private final long startOfPlaylistInPeriodUs;

        public HlsMediaPlaylistSegmentIterator(String str, long j11, List<HlsMediaPlaylist.SegmentBase> list) {
            super(0, (long) (list.size() - 1));
            this.playlistBaseUri = str;
            this.startOfPlaylistInPeriodUs = j11;
            this.segmentBases = list;
        }

        public long getChunkEndTimeUs() {
            checkInBounds();
            HlsMediaPlaylist.SegmentBase segmentBase = this.segmentBases.get((int) getCurrentIndex());
            return this.startOfPlaylistInPeriodUs + segmentBase.relativeStartTimeUs + segmentBase.durationUs;
        }

        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.startOfPlaylistInPeriodUs + this.segmentBases.get((int) getCurrentIndex()).relativeStartTimeUs;
        }

        public DataSpec getDataSpec() {
            checkInBounds();
            HlsMediaPlaylist.SegmentBase segmentBase = this.segmentBases.get((int) getCurrentIndex());
            return new DataSpec(UriUtil.resolveToUri(this.playlistBaseUri, segmentBase.url), segmentBase.byteRangeOffset, segmentBase.byteRangeLength);
        }
    }

    public static final class InitializationTrackSelection extends BaseTrackSelection {
        private int selectedIndex;

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.selectedIndex = indexOf(trackGroup.getFormat(iArr[0]));
        }

        public int getSelectedIndex() {
            return this.selectedIndex;
        }

        @Nullable
        public Object getSelectionData() {
            return null;
        }

        public int getSelectionReason() {
            return 0;
        }

        public void updateSelectedTrack(long j11, long j12, long j13, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (isBlacklisted(this.selectedIndex, elapsedRealtime)) {
                for (int i11 = this.length - 1; i11 >= 0; i11--) {
                    if (!isBlacklisted(i11, elapsedRealtime)) {
                        this.selectedIndex = i11;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }
    }

    public static final class SegmentBaseHolder {
        public final boolean isPreload;
        public final long mediaSequence;
        public final int partIndex;
        public final HlsMediaPlaylist.SegmentBase segmentBase;

        public SegmentBaseHolder(HlsMediaPlaylist.SegmentBase segmentBase2, long j11, int i11) {
            boolean z11;
            this.segmentBase = segmentBase2;
            this.mediaSequence = j11;
            this.partIndex = i11;
            if (!(segmentBase2 instanceof HlsMediaPlaylist.Part) || !((HlsMediaPlaylist.Part) segmentBase2).isPreload) {
                z11 = false;
            } else {
                z11 = true;
            }
            this.isPreload = z11;
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, HlsDataSourceFactory hlsDataSourceFactory, @Nullable TransferListener transferListener, TimestampAdjusterProvider timestampAdjusterProvider2, @Nullable List<Format> list, PlayerId playerId2) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.playlistUrls = uriArr;
        this.playlistFormats = formatArr;
        this.timestampAdjusterProvider = timestampAdjusterProvider2;
        this.muxedCaptionFormats = list;
        this.playerId = playerId2;
        DataSource createDataSource = hlsDataSourceFactory.createDataSource(1);
        this.mediaDataSource = createDataSource;
        if (transferListener != null) {
            createDataSource.addTransferListener(transferListener);
        }
        this.encryptionDataSource = hlsDataSourceFactory.createDataSource(3);
        this.trackGroup = new TrackGroup(formatArr);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < uriArr.length; i11++) {
            if ((formatArr[i11].roleFlags & 16384) == 0) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        this.trackSelection = new InitializationTrackSelection(this.trackGroup, Ints.toArray(arrayList));
    }

    @Nullable
    private static Uri getFullEncryptionKeyUri(HlsMediaPlaylist hlsMediaPlaylist, @Nullable HlsMediaPlaylist.SegmentBase segmentBase) {
        String str;
        if (segmentBase == null || (str = segmentBase.fullSegmentEncryptionKeyUri) == null) {
            return null;
        }
        return UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, str);
    }

    private Pair<Long, Integer> getNextMediaSequenceAndPartIndex(@Nullable HlsMediaChunk hlsMediaChunk, boolean z11, HlsMediaPlaylist hlsMediaPlaylist, long j11, long j12) {
        boolean z12;
        List<HlsMediaPlaylist.Part> list;
        long j13;
        long j14;
        int i11 = -1;
        if (hlsMediaChunk == null || z11) {
            long j15 = hlsMediaPlaylist.durationUs + j11;
            if (hlsMediaChunk != null && !this.independentSegments) {
                j12 = hlsMediaChunk.startTimeUs;
            }
            if (!hlsMediaPlaylist.hasEndTag && j12 >= j15) {
                return new Pair<>(Long.valueOf(hlsMediaPlaylist.mediaSequence + ((long) hlsMediaPlaylist.segments.size())), -1);
            }
            long j16 = j12 - j11;
            List<HlsMediaPlaylist.Segment> list2 = hlsMediaPlaylist.segments;
            Long valueOf = Long.valueOf(j16);
            int i12 = 0;
            if (!this.playlistTracker.isLive() || hlsMediaChunk == null) {
                z12 = true;
            } else {
                z12 = false;
            }
            int binarySearchFloor = Util.binarySearchFloor(list2, valueOf, true, z12);
            long j17 = ((long) binarySearchFloor) + hlsMediaPlaylist.mediaSequence;
            if (binarySearchFloor >= 0) {
                HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(binarySearchFloor);
                if (j16 < segment.relativeStartTimeUs + segment.durationUs) {
                    list = segment.parts;
                } else {
                    list = hlsMediaPlaylist.trailingParts;
                }
                while (true) {
                    if (i12 >= list.size()) {
                        break;
                    }
                    HlsMediaPlaylist.Part part = list.get(i12);
                    if (j16 >= part.relativeStartTimeUs + part.durationUs) {
                        i12++;
                    } else if (part.isIndependent) {
                        if (list == hlsMediaPlaylist.trailingParts) {
                            j13 = 1;
                        } else {
                            j13 = 0;
                        }
                        j17 += j13;
                        i11 = i12;
                    }
                }
            }
            return new Pair<>(Long.valueOf(j17), Integer.valueOf(i11));
        } else if (!hlsMediaChunk.isLoadCompleted()) {
            return new Pair<>(Long.valueOf(hlsMediaChunk.chunkIndex), Integer.valueOf(hlsMediaChunk.partIndex));
        } else {
            if (hlsMediaChunk.partIndex == -1) {
                j14 = hlsMediaChunk.getNextChunkIndex();
            } else {
                j14 = hlsMediaChunk.chunkIndex;
            }
            Long valueOf2 = Long.valueOf(j14);
            int i13 = hlsMediaChunk.partIndex;
            if (i13 != -1) {
                i11 = i13 + 1;
            }
            return new Pair<>(valueOf2, Integer.valueOf(i11));
        }
    }

    @Nullable
    private static SegmentBaseHolder getNextSegmentHolder(HlsMediaPlaylist hlsMediaPlaylist, long j11, int i11) {
        int i12 = (int) (j11 - hlsMediaPlaylist.mediaSequence);
        if (i12 == hlsMediaPlaylist.segments.size()) {
            if (i11 == -1) {
                i11 = 0;
            }
            if (i11 < hlsMediaPlaylist.trailingParts.size()) {
                return new SegmentBaseHolder(hlsMediaPlaylist.trailingParts.get(i11), j11, i11);
            }
            return null;
        }
        HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(i12);
        if (i11 == -1) {
            return new SegmentBaseHolder(segment, j11, -1);
        }
        if (i11 < segment.parts.size()) {
            return new SegmentBaseHolder(segment.parts.get(i11), j11, i11);
        }
        int i13 = i12 + 1;
        if (i13 < hlsMediaPlaylist.segments.size()) {
            return new SegmentBaseHolder(hlsMediaPlaylist.segments.get(i13), j11 + 1, -1);
        }
        if (!hlsMediaPlaylist.trailingParts.isEmpty()) {
            return new SegmentBaseHolder(hlsMediaPlaylist.trailingParts.get(0), j11 + 1, 0);
        }
        return null;
    }

    @VisibleForTesting
    public static List<HlsMediaPlaylist.SegmentBase> getSegmentBaseList(HlsMediaPlaylist hlsMediaPlaylist, long j11, int i11) {
        int i12 = (int) (j11 - hlsMediaPlaylist.mediaSequence);
        if (i12 < 0 || hlsMediaPlaylist.segments.size() < i12) {
            return ImmutableList.of();
        }
        ArrayList arrayList = new ArrayList();
        int i13 = 0;
        if (i12 < hlsMediaPlaylist.segments.size()) {
            if (i11 != -1) {
                HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(i12);
                if (i11 == 0) {
                    arrayList.add(segment);
                } else if (i11 < segment.parts.size()) {
                    List<HlsMediaPlaylist.Part> list = segment.parts;
                    arrayList.addAll(list.subList(i11, list.size()));
                }
                i12++;
            }
            List<HlsMediaPlaylist.Segment> list2 = hlsMediaPlaylist.segments;
            arrayList.addAll(list2.subList(i12, list2.size()));
            i11 = 0;
        }
        if (hlsMediaPlaylist.partTargetDurationUs != C.TIME_UNSET) {
            if (i11 != -1) {
                i13 = i11;
            }
            if (i13 < hlsMediaPlaylist.trailingParts.size()) {
                List<HlsMediaPlaylist.Part> list3 = hlsMediaPlaylist.trailingParts;
                arrayList.addAll(list3.subList(i13, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    private Chunk maybeCreateEncryptionChunkFor(@Nullable Uri uri, int i11) {
        if (uri == null) {
            return null;
        }
        byte[] remove = this.keyCache.remove(uri);
        if (remove != null) {
            this.keyCache.put(uri, remove);
            return null;
        }
        return new EncryptionKeyChunk(this.encryptionDataSource, new DataSpec.Builder().setUri(uri).setFlags(1).build(), this.playlistFormats[i11], this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), this.scratchSpace);
    }

    private long resolveTimeToLiveEdgeUs(long j11) {
        long j12 = this.liveEdgeInPeriodTimeUs;
        return (j12 > C.TIME_UNSET ? 1 : (j12 == C.TIME_UNSET ? 0 : -1)) != 0 ? j12 - j11 : C.TIME_UNSET;
    }

    private void updateLiveEdgeTimeUs(HlsMediaPlaylist hlsMediaPlaylist) {
        long j11;
        if (hlsMediaPlaylist.hasEndTag) {
            j11 = C.TIME_UNSET;
        } else {
            j11 = hlsMediaPlaylist.getEndTimeUs() - this.playlistTracker.getInitialStartTimeUs();
        }
        this.liveEdgeInPeriodTimeUs = j11;
    }

    public MediaChunkIterator[] createMediaChunkIterators(@Nullable HlsMediaChunk hlsMediaChunk, long j11) {
        int i11;
        int i12;
        boolean z11;
        HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
        if (hlsMediaChunk2 == null) {
            i11 = -1;
        } else {
            i11 = this.trackGroup.indexOf(hlsMediaChunk2.trackFormat);
        }
        int i13 = i11;
        int length = this.trackSelection.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        boolean z12 = false;
        int i14 = 0;
        while (i14 < length) {
            int indexInTrackGroup = this.trackSelection.getIndexInTrackGroup(i14);
            Uri uri = this.playlistUrls[indexInTrackGroup];
            if (!this.playlistTracker.isSnapshotValid(uri)) {
                mediaChunkIteratorArr[i14] = MediaChunkIterator.EMPTY;
                i12 = i14;
            } else {
                HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(uri, z12);
                Assertions.checkNotNull(playlistSnapshot);
                long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
                if (indexInTrackGroup != i13) {
                    z11 = true;
                } else {
                    z11 = z12;
                }
                i12 = i14;
                Pair<Long, Integer> nextMediaSequenceAndPartIndex = getNextMediaSequenceAndPartIndex(hlsMediaChunk, z11, playlistSnapshot, initialStartTimeUs, j11);
                mediaChunkIteratorArr[i12] = new HlsMediaPlaylistSegmentIterator(playlistSnapshot.baseUri, initialStartTimeUs, getSegmentBaseList(playlistSnapshot, ((Long) nextMediaSequenceAndPartIndex.first).longValue(), ((Integer) nextMediaSequenceAndPartIndex.second).intValue()));
            }
            i14 = i12 + 1;
            z12 = false;
        }
        return mediaChunkIteratorArr;
    }

    public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
        HlsMediaPlaylist hlsMediaPlaylist;
        long j12;
        int selectedIndex = this.trackSelection.getSelectedIndex();
        Uri[] uriArr = this.playlistUrls;
        if (selectedIndex >= uriArr.length || selectedIndex == -1) {
            hlsMediaPlaylist = null;
        } else {
            hlsMediaPlaylist = this.playlistTracker.getPlaylistSnapshot(uriArr[this.trackSelection.getSelectedIndexInTrackGroup()], true);
        }
        if (hlsMediaPlaylist == null || hlsMediaPlaylist.segments.isEmpty() || !hlsMediaPlaylist.hasIndependentSegments) {
            return j11;
        }
        long initialStartTimeUs = hlsMediaPlaylist.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
        long j13 = j11 - initialStartTimeUs;
        int binarySearchFloor = Util.binarySearchFloor(hlsMediaPlaylist.segments, Long.valueOf(j13), true, true);
        long j14 = hlsMediaPlaylist.segments.get(binarySearchFloor).relativeStartTimeUs;
        if (binarySearchFloor != hlsMediaPlaylist.segments.size() - 1) {
            j12 = hlsMediaPlaylist.segments.get(binarySearchFloor + 1).relativeStartTimeUs;
        } else {
            j12 = j14;
        }
        return seekParameters.resolveSeekPositionUs(j13, j14, j12) + initialStartTimeUs;
    }

    public int getChunkPublicationState(HlsMediaChunk hlsMediaChunk) {
        List<HlsMediaPlaylist.Part> list;
        if (hlsMediaChunk.partIndex == -1) {
            return 1;
        }
        HlsMediaPlaylist hlsMediaPlaylist = (HlsMediaPlaylist) Assertions.checkNotNull(this.playlistTracker.getPlaylistSnapshot(this.playlistUrls[this.trackGroup.indexOf(hlsMediaChunk.trackFormat)], false));
        int i11 = (int) (hlsMediaChunk.chunkIndex - hlsMediaPlaylist.mediaSequence);
        if (i11 < 0) {
            return 1;
        }
        if (i11 < hlsMediaPlaylist.segments.size()) {
            list = hlsMediaPlaylist.segments.get(i11).parts;
        } else {
            list = hlsMediaPlaylist.trailingParts;
        }
        if (hlsMediaChunk.partIndex >= list.size()) {
            return 2;
        }
        HlsMediaPlaylist.Part part = list.get(hlsMediaChunk.partIndex);
        if (part.isPreload) {
            return 0;
        }
        if (Util.areEqual(Uri.parse(UriUtil.resolve(hlsMediaPlaylist.baseUri, part.url)), hlsMediaChunk.dataSpec.uri)) {
            return 1;
        }
        return 2;
    }

    public void getNextChunk(long j11, long j12, List<HlsMediaChunk> list, boolean z11, HlsChunkHolder hlsChunkHolder) {
        HlsMediaChunk hlsMediaChunk;
        int i11;
        boolean z12;
        long j13;
        Uri uri;
        HlsMediaPlaylist hlsMediaPlaylist;
        int i12;
        long j14 = j12;
        HlsChunkHolder hlsChunkHolder2 = hlsChunkHolder;
        if (list.isEmpty()) {
            hlsMediaChunk = null;
        } else {
            hlsMediaChunk = (HlsMediaChunk) Iterables.getLast(list);
        }
        if (hlsMediaChunk == null) {
            i11 = -1;
        } else {
            i11 = this.trackGroup.indexOf(hlsMediaChunk.trackFormat);
        }
        long j15 = j14 - j11;
        long resolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j11);
        if (hlsMediaChunk != null && !this.independentSegments) {
            long durationUs = hlsMediaChunk.getDurationUs();
            j15 = Math.max(0, j15 - durationUs);
            if (resolveTimeToLiveEdgeUs != C.TIME_UNSET) {
                resolveTimeToLiveEdgeUs = Math.max(0, resolveTimeToLiveEdgeUs - durationUs);
            }
        }
        this.trackSelection.updateSelectedTrack(j11, j15, resolveTimeToLiveEdgeUs, list, createMediaChunkIterators(hlsMediaChunk, j14));
        int selectedIndexInTrackGroup = this.trackSelection.getSelectedIndexInTrackGroup();
        if (i11 != selectedIndexInTrackGroup) {
            z12 = true;
        } else {
            z12 = false;
        }
        Uri uri2 = this.playlistUrls[selectedIndexInTrackGroup];
        if (!this.playlistTracker.isSnapshotValid(uri2)) {
            hlsChunkHolder2.playlistUrl = uri2;
            this.seenExpectedPlaylistError &= uri2.equals(this.expectedPlaylistUrl);
            this.expectedPlaylistUrl = uri2;
            return;
        }
        HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(uri2, true);
        Assertions.checkNotNull(playlistSnapshot);
        this.independentSegments = playlistSnapshot.hasIndependentSegments;
        updateLiveEdgeTimeUs(playlistSnapshot);
        long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
        HlsMediaPlaylist hlsMediaPlaylist2 = playlistSnapshot;
        Uri uri3 = uri2;
        int i13 = selectedIndexInTrackGroup;
        Pair<Long, Integer> nextMediaSequenceAndPartIndex = getNextMediaSequenceAndPartIndex(hlsMediaChunk, z12, playlistSnapshot, initialStartTimeUs, j12);
        long longValue = ((Long) nextMediaSequenceAndPartIndex.first).longValue();
        int intValue = ((Integer) nextMediaSequenceAndPartIndex.second).intValue();
        if (longValue >= playlistSnapshot.mediaSequence || hlsMediaChunk == null || !z12) {
            hlsMediaPlaylist = playlistSnapshot;
            j13 = initialStartTimeUs;
            uri = uri3;
            i12 = i13;
        } else {
            Uri uri4 = this.playlistUrls[i11];
            HlsMediaPlaylist playlistSnapshot2 = this.playlistTracker.getPlaylistSnapshot(uri4, true);
            Assertions.checkNotNull(playlistSnapshot2);
            j13 = playlistSnapshot2.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
            Pair<Long, Integer> nextMediaSequenceAndPartIndex2 = getNextMediaSequenceAndPartIndex(hlsMediaChunk, false, playlistSnapshot2, j13, j12);
            longValue = ((Long) nextMediaSequenceAndPartIndex2.first).longValue();
            intValue = ((Integer) nextMediaSequenceAndPartIndex2.second).intValue();
            i12 = i11;
            uri = uri4;
            hlsMediaPlaylist = playlistSnapshot2;
        }
        if (longValue < hlsMediaPlaylist.mediaSequence) {
            this.fatalError = new BehindLiveWindowException();
            return;
        }
        SegmentBaseHolder nextSegmentHolder = getNextSegmentHolder(hlsMediaPlaylist, longValue, intValue);
        if (nextSegmentHolder == null) {
            if (!hlsMediaPlaylist.hasEndTag) {
                hlsChunkHolder2.playlistUrl = uri;
                this.seenExpectedPlaylistError &= uri.equals(this.expectedPlaylistUrl);
                this.expectedPlaylistUrl = uri;
                return;
            } else if (z11 || hlsMediaPlaylist.segments.isEmpty()) {
                hlsChunkHolder2.endOfStream = true;
                return;
            } else {
                nextSegmentHolder = new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) Iterables.getLast(hlsMediaPlaylist.segments), (hlsMediaPlaylist.mediaSequence + ((long) hlsMediaPlaylist.segments.size())) - 1, -1);
            }
        }
        this.seenExpectedPlaylistError = false;
        this.expectedPlaylistUrl = null;
        Uri fullEncryptionKeyUri = getFullEncryptionKeyUri(hlsMediaPlaylist, nextSegmentHolder.segmentBase.initializationSegment);
        Chunk maybeCreateEncryptionChunkFor = maybeCreateEncryptionChunkFor(fullEncryptionKeyUri, i12);
        hlsChunkHolder2.chunk = maybeCreateEncryptionChunkFor;
        if (maybeCreateEncryptionChunkFor == null) {
            Uri fullEncryptionKeyUri2 = getFullEncryptionKeyUri(hlsMediaPlaylist, nextSegmentHolder.segmentBase);
            Chunk maybeCreateEncryptionChunkFor2 = maybeCreateEncryptionChunkFor(fullEncryptionKeyUri2, i12);
            hlsChunkHolder2.chunk = maybeCreateEncryptionChunkFor2;
            if (maybeCreateEncryptionChunkFor2 == null) {
                boolean shouldSpliceIn = HlsMediaChunk.shouldSpliceIn(hlsMediaChunk, uri, hlsMediaPlaylist, nextSegmentHolder, j13);
                if (!shouldSpliceIn || !nextSegmentHolder.isPreload) {
                    hlsChunkHolder2.chunk = HlsMediaChunk.createInstance(this.extractorFactory, this.mediaDataSource, this.playlistFormats[i12], j13, hlsMediaPlaylist, nextSegmentHolder, uri, this.muxedCaptionFormats, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), this.isTimestampMaster, this.timestampAdjusterProvider, hlsMediaChunk, this.keyCache.get(fullEncryptionKeyUri2), this.keyCache.get(fullEncryptionKeyUri), shouldSpliceIn, this.playerId);
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

    public TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    public ExoTrackSelection getTrackSelection() {
        return this.trackSelection;
    }

    public boolean maybeExcludeTrack(Chunk chunk, long j11) {
        ExoTrackSelection exoTrackSelection = this.trackSelection;
        return exoTrackSelection.blacklist(exoTrackSelection.indexOf(this.trackGroup.indexOf(chunk.trackFormat)), j11);
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            Uri uri = this.expectedPlaylistUrl;
            if (uri != null && this.seenExpectedPlaylistError) {
                this.playlistTracker.maybeThrowPlaylistRefreshError(uri);
                return;
            }
            return;
        }
        throw iOException;
    }

    public boolean obtainsChunksForPlaylist(Uri uri) {
        return Util.contains(this.playlistUrls, uri);
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.scratchSpace = encryptionKeyChunk.getDataHolder();
            this.keyCache.put(encryptionKeyChunk.dataSpec.uri, (byte[]) Assertions.checkNotNull(encryptionKeyChunk.getResult()));
        }
    }

    public boolean onPlaylistError(Uri uri, long j11) {
        int indexOf;
        int i11 = 0;
        while (true) {
            Uri[] uriArr = this.playlistUrls;
            if (i11 >= uriArr.length) {
                i11 = -1;
                break;
            } else if (uriArr[i11].equals(uri)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 == -1 || (indexOf = this.trackSelection.indexOf(i11)) == -1) {
            return true;
        }
        this.seenExpectedPlaylistError |= uri.equals(this.expectedPlaylistUrl);
        if (j11 == C.TIME_UNSET || (this.trackSelection.blacklist(indexOf, j11) && this.playlistTracker.excludeMediaPlaylist(uri, j11))) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.fatalError = null;
    }

    public void setIsTimestampMaster(boolean z11) {
        this.isTimestampMaster = z11;
    }

    public void setTrackSelection(ExoTrackSelection exoTrackSelection) {
        this.trackSelection = exoTrackSelection;
    }

    public boolean shouldCancelLoad(long j11, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.fatalError != null) {
            return false;
        }
        return this.trackSelection.shouldCancelChunkLoad(j11, chunk, list);
    }
}
