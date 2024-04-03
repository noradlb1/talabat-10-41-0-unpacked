package com.google.android.exoplayer2.source;

import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import l7.f;

public class SampleQueue implements TrackOutput {
    @VisibleForTesting
    static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    private static final String TAG = "SampleQueue";
    private int absoluteFirstIndex;
    private int capacity = 1000;
    private TrackOutput.CryptoData[] cryptoDatas = new TrackOutput.CryptoData[1000];
    @Nullable
    private DrmSession currentDrmSession;
    @Nullable
    private Format downstreamFormat;
    @Nullable
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    @Nullable
    private final DrmSessionManager drmSessionManager;
    private final SampleExtrasHolder extrasHolder = new SampleExtrasHolder();
    private int[] flags = new int[1000];
    private boolean isLastSampleQueued;
    private long largestDiscardedTimestampUs = Long.MIN_VALUE;
    private long largestQueuedTimestampUs = Long.MIN_VALUE;
    private int length;
    private boolean loggedUnexpectedNonSyncSample;
    private long[] offsets = new long[1000];
    private boolean pendingSplice;
    private int readPosition;
    private int relativeFirstIndex;
    private final SampleDataQueue sampleDataQueue;
    private long sampleOffsetUs;
    private final SpannedData<SharedSampleMetadata> sharedSampleMetadata = new SpannedData<>(new j());
    private int[] sizes = new int[1000];
    private int[] sourceIds = new int[1000];
    private long startTimeUs = Long.MIN_VALUE;
    private long[] timesUs = new long[1000];
    @Nullable
    private Format unadjustedUpstreamFormat;
    private boolean upstreamAllSamplesAreSyncSamples;
    @Nullable
    private Format upstreamFormat;
    private boolean upstreamFormatAdjustmentRequired;
    @Nullable
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private boolean upstreamFormatRequired = true;
    private boolean upstreamKeyframeRequired = true;
    private int upstreamSourceId;

    public static final class SampleExtrasHolder {
        @Nullable
        public TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;
    }

    public static final class SharedSampleMetadata {
        public final DrmSessionManager.DrmSessionReference drmSessionReference;
        public final Format format;

        private SharedSampleMetadata(Format format2, DrmSessionManager.DrmSessionReference drmSessionReference2) {
            this.format = format2;
            this.drmSessionReference = drmSessionReference2;
        }
    }

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public SampleQueue(Allocator allocator, @Nullable DrmSessionManager drmSessionManager2, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.drmSessionManager = drmSessionManager2;
        this.drmEventDispatcher = eventDispatcher;
        this.sampleDataQueue = new SampleDataQueue(allocator);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean attemptSplice(long r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.length     // Catch:{ all -> 0x0027 }
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0011
            long r3 = r5.largestDiscardedTimestampUs     // Catch:{ all -> 0x0027 }
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = r2
        L_0x000f:
            monitor-exit(r5)
            return r1
        L_0x0011:
            long r3 = r5.getLargestReadTimestampUs()     // Catch:{ all -> 0x0027 }
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x001b
            monitor-exit(r5)
            return r2
        L_0x001b:
            int r6 = r5.countUnreadSamplesBefore(r6)     // Catch:{ all -> 0x0027 }
            int r7 = r5.absoluteFirstIndex     // Catch:{ all -> 0x0027 }
            int r7 = r7 + r6
            r5.discardUpstreamSampleMetadata(r7)     // Catch:{ all -> 0x0027 }
            monitor-exit(r5)
            return r1
        L_0x0027:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.attemptSplice(long):boolean");
    }

    private synchronized void commitSample(long j11, int i11, long j12, int i12, @Nullable TrackOutput.CryptoData cryptoData) {
        boolean z11;
        DrmSessionManager.DrmSessionReference drmSessionReference;
        boolean z12;
        int i13 = this.length;
        if (i13 > 0) {
            int relativeIndex = getRelativeIndex(i13 - 1);
            if (this.offsets[relativeIndex] + ((long) this.sizes[relativeIndex]) <= j12) {
                z12 = true;
            } else {
                z12 = false;
            }
            Assertions.checkArgument(z12);
        }
        if ((536870912 & i11) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.isLastSampleQueued = z11;
        this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, j11);
        int relativeIndex2 = getRelativeIndex(this.length);
        this.timesUs[relativeIndex2] = j11;
        this.offsets[relativeIndex2] = j12;
        this.sizes[relativeIndex2] = i12;
        this.flags[relativeIndex2] = i11;
        this.cryptoDatas[relativeIndex2] = cryptoData;
        this.sourceIds[relativeIndex2] = this.upstreamSourceId;
        if (this.sharedSampleMetadata.isEmpty() || !this.sharedSampleMetadata.getEndValue().format.equals(this.upstreamFormat)) {
            DrmSessionManager drmSessionManager2 = this.drmSessionManager;
            if (drmSessionManager2 != null) {
                drmSessionReference = drmSessionManager2.preacquireSession(this.drmEventDispatcher, this.upstreamFormat);
            } else {
                drmSessionReference = DrmSessionManager.DrmSessionReference.EMPTY;
            }
            this.sharedSampleMetadata.appendSpan(getWriteIndex(), new SharedSampleMetadata((Format) Assertions.checkNotNull(this.upstreamFormat), drmSessionReference));
        }
        int i14 = this.length + 1;
        this.length = i14;
        int i15 = this.capacity;
        if (i14 == i15) {
            int i16 = i15 + 1000;
            int[] iArr = new int[i16];
            long[] jArr = new long[i16];
            long[] jArr2 = new long[i16];
            int[] iArr2 = new int[i16];
            int[] iArr3 = new int[i16];
            TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i16];
            int i17 = this.relativeFirstIndex;
            int i18 = i15 - i17;
            System.arraycopy(this.offsets, i17, jArr, 0, i18);
            System.arraycopy(this.timesUs, this.relativeFirstIndex, jArr2, 0, i18);
            System.arraycopy(this.flags, this.relativeFirstIndex, iArr2, 0, i18);
            System.arraycopy(this.sizes, this.relativeFirstIndex, iArr3, 0, i18);
            System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, cryptoDataArr, 0, i18);
            System.arraycopy(this.sourceIds, this.relativeFirstIndex, iArr, 0, i18);
            int i19 = this.relativeFirstIndex;
            System.arraycopy(this.offsets, 0, jArr, i18, i19);
            System.arraycopy(this.timesUs, 0, jArr2, i18, i19);
            System.arraycopy(this.flags, 0, iArr2, i18, i19);
            System.arraycopy(this.sizes, 0, iArr3, i18, i19);
            System.arraycopy(this.cryptoDatas, 0, cryptoDataArr, i18, i19);
            System.arraycopy(this.sourceIds, 0, iArr, i18, i19);
            this.offsets = jArr;
            this.timesUs = jArr2;
            this.flags = iArr2;
            this.sizes = iArr3;
            this.cryptoDatas = cryptoDataArr;
            this.sourceIds = iArr;
            this.relativeFirstIndex = 0;
            this.capacity = i16;
        }
    }

    private int countUnreadSamplesBefore(long j11) {
        int i11 = this.length;
        int relativeIndex = getRelativeIndex(i11 - 1);
        while (i11 > this.readPosition && this.timesUs[relativeIndex] >= j11) {
            i11--;
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return i11;
    }

    public static SampleQueue createWithDrm(Allocator allocator, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.checkNotNull(drmSessionManager2), (DrmSessionEventListener.EventDispatcher) Assertions.checkNotNull(eventDispatcher));
    }

    public static SampleQueue createWithoutDrm(Allocator allocator) {
        return new SampleQueue(allocator, (DrmSessionManager) null, (DrmSessionEventListener.EventDispatcher) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized long discardSampleMetadataTo(long r11, boolean r13, boolean r14) {
        /*
            r10 = this;
            monitor-enter(r10)
            int r0 = r10.length     // Catch:{ all -> 0x002f }
            r1 = -1
            if (r0 == 0) goto L_0x002d
            long[] r3 = r10.timesUs     // Catch:{ all -> 0x002f }
            int r5 = r10.relativeFirstIndex     // Catch:{ all -> 0x002f }
            r6 = r3[r5]     // Catch:{ all -> 0x002f }
            int r3 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0012
            goto L_0x002d
        L_0x0012:
            if (r14 == 0) goto L_0x001a
            int r14 = r10.readPosition     // Catch:{ all -> 0x002f }
            if (r14 == r0) goto L_0x001a
            int r0 = r14 + 1
        L_0x001a:
            r6 = r0
            r4 = r10
            r7 = r11
            r9 = r13
            int r11 = r4.findSampleBefore(r5, r6, r7, r9)     // Catch:{ all -> 0x002f }
            r12 = -1
            if (r11 != r12) goto L_0x0027
            monitor-exit(r10)
            return r1
        L_0x0027:
            long r11 = r10.discardSamples(r11)     // Catch:{ all -> 0x002f }
            monitor-exit(r10)
            return r11
        L_0x002d:
            monitor-exit(r10)
            return r1
        L_0x002f:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.discardSampleMetadataTo(long, boolean, boolean):long");
    }

    private synchronized long discardSampleMetadataToEnd() {
        int i11 = this.length;
        if (i11 == 0) {
            return -1;
        }
        return discardSamples(i11);
    }

    @GuardedBy("this")
    private long discardSamples(int i11) {
        this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i11));
        this.length -= i11;
        int i12 = this.absoluteFirstIndex + i11;
        this.absoluteFirstIndex = i12;
        int i13 = this.relativeFirstIndex + i11;
        this.relativeFirstIndex = i13;
        int i14 = this.capacity;
        if (i13 >= i14) {
            this.relativeFirstIndex = i13 - i14;
        }
        int i15 = this.readPosition - i11;
        this.readPosition = i15;
        if (i15 < 0) {
            this.readPosition = 0;
        }
        this.sharedSampleMetadata.discardTo(i12);
        if (this.length != 0) {
            return this.offsets[this.relativeFirstIndex];
        }
        int i16 = this.relativeFirstIndex;
        if (i16 == 0) {
            i16 = this.capacity;
        }
        int i17 = i16 - 1;
        return this.offsets[i17] + ((long) this.sizes[i17]);
    }

    private long discardUpstreamSampleMetadata(int i11) {
        boolean z11;
        int writeIndex = getWriteIndex() - i11;
        boolean z12 = false;
        if (writeIndex < 0 || writeIndex > this.length - this.readPosition) {
            z11 = false;
        } else {
            z11 = true;
        }
        Assertions.checkArgument(z11);
        int i12 = this.length - writeIndex;
        this.length = i12;
        this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i12));
        if (writeIndex == 0 && this.isLastSampleQueued) {
            z12 = true;
        }
        this.isLastSampleQueued = z12;
        this.sharedSampleMetadata.discardFrom(i11);
        int i13 = this.length;
        if (i13 == 0) {
            return 0;
        }
        int relativeIndex = getRelativeIndex(i13 - 1);
        return this.offsets[relativeIndex] + ((long) this.sizes[relativeIndex]);
    }

    private int findSampleBefore(int i11, int i12, long j11, boolean z11) {
        int i13 = -1;
        for (int i14 = 0; i14 < i12; i14++) {
            long j12 = this.timesUs[i11];
            if (j12 > j11) {
                return i13;
            }
            if (!z11 || (this.flags[i11] & 1) != 0) {
                if (j12 == j11) {
                    return i14;
                }
                i13 = i14;
            }
            i11++;
            if (i11 == this.capacity) {
                i11 = 0;
            }
        }
        return i13;
    }

    private long getLargestTimestamp(int i11) {
        long j11 = Long.MIN_VALUE;
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        int relativeIndex = getRelativeIndex(i11 - 1);
        for (int i12 = 0; i12 < i11; i12++) {
            j11 = Math.max(j11, this.timesUs[relativeIndex]);
            if ((this.flags[relativeIndex] & 1) != 0) {
                break;
            }
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return j11;
    }

    private int getRelativeIndex(int i11) {
        int i12 = this.relativeFirstIndex + i11;
        int i13 = this.capacity;
        if (i12 < i13) {
            return i12;
        }
        return i12 - i13;
    }

    private boolean hasNextSample() {
        return this.readPosition != this.length;
    }

    private boolean mayReadSample(int i11) {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession == null || drmSession.getState() == 4 || ((this.flags[i11] & 1073741824) == 0 && this.currentDrmSession.playClearSamplesWithoutKeys())) {
            return true;
        }
        return false;
    }

    private void onFormatResult(Format format, FormatHolder formatHolder) {
        boolean z11;
        DrmInitData drmInitData;
        Format format2;
        Format format3 = this.downstreamFormat;
        if (format3 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            drmInitData = null;
        } else {
            drmInitData = format3.drmInitData;
        }
        this.downstreamFormat = format;
        DrmInitData drmInitData2 = format.drmInitData;
        DrmSessionManager drmSessionManager2 = this.drmSessionManager;
        if (drmSessionManager2 != null) {
            format2 = format.copyWithCryptoType(drmSessionManager2.getCryptoType(format));
        } else {
            format2 = format;
        }
        formatHolder.format = format2;
        formatHolder.drmSession = this.currentDrmSession;
        if (this.drmSessionManager != null) {
            if (z11 || !Util.areEqual(drmInitData, drmInitData2)) {
                DrmSession drmSession = this.currentDrmSession;
                DrmSession acquireSession = this.drmSessionManager.acquireSession(this.drmEventDispatcher, format);
                this.currentDrmSession = acquireSession;
                formatHolder.drmSession = acquireSession;
                if (drmSession != null) {
                    drmSession.release(this.drmEventDispatcher);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int peekSampleMetadata(com.google.android.exoplayer2.FormatHolder r6, com.google.android.exoplayer2.decoder.DecoderInputBuffer r7, boolean r8, boolean r9, com.google.android.exoplayer2.source.SampleQueue.SampleExtrasHolder r10) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r7.waitingForKeys = r0     // Catch:{ all -> 0x009a }
            boolean r0 = r5.hasNextSample()     // Catch:{ all -> 0x009a }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0031
            if (r9 != 0) goto L_0x002b
            boolean r9 = r5.isLastSampleQueued     // Catch:{ all -> 0x009a }
            if (r9 == 0) goto L_0x0014
            goto L_0x002b
        L_0x0014:
            com.google.android.exoplayer2.Format r7 = r5.upstreamFormat     // Catch:{ all -> 0x009a }
            if (r7 == 0) goto L_0x0029
            if (r8 != 0) goto L_0x001e
            com.google.android.exoplayer2.Format r8 = r5.downstreamFormat     // Catch:{ all -> 0x009a }
            if (r7 == r8) goto L_0x0029
        L_0x001e:
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r7)     // Catch:{ all -> 0x009a }
            com.google.android.exoplayer2.Format r7 = (com.google.android.exoplayer2.Format) r7     // Catch:{ all -> 0x009a }
            r5.onFormatResult(r7, r6)     // Catch:{ all -> 0x009a }
            monitor-exit(r5)
            return r1
        L_0x0029:
            monitor-exit(r5)
            return r2
        L_0x002b:
            r6 = 4
            r7.setFlags(r6)     // Catch:{ all -> 0x009a }
            monitor-exit(r5)
            return r3
        L_0x0031:
            com.google.android.exoplayer2.source.SpannedData<com.google.android.exoplayer2.source.SampleQueue$SharedSampleMetadata> r0 = r5.sharedSampleMetadata     // Catch:{ all -> 0x009a }
            int r4 = r5.getReadIndex()     // Catch:{ all -> 0x009a }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x009a }
            com.google.android.exoplayer2.source.SampleQueue$SharedSampleMetadata r0 = (com.google.android.exoplayer2.source.SampleQueue.SharedSampleMetadata) r0     // Catch:{ all -> 0x009a }
            com.google.android.exoplayer2.Format r0 = r0.format     // Catch:{ all -> 0x009a }
            if (r8 != 0) goto L_0x0095
            com.google.android.exoplayer2.Format r8 = r5.downstreamFormat     // Catch:{ all -> 0x009a }
            if (r0 == r8) goto L_0x0046
            goto L_0x0095
        L_0x0046:
            int r6 = r5.readPosition     // Catch:{ all -> 0x009a }
            int r6 = r5.getRelativeIndex(r6)     // Catch:{ all -> 0x009a }
            boolean r8 = r5.mayReadSample(r6)     // Catch:{ all -> 0x009a }
            r0 = 1
            if (r8 != 0) goto L_0x0057
            r7.waitingForKeys = r0     // Catch:{ all -> 0x009a }
            monitor-exit(r5)
            return r2
        L_0x0057:
            int[] r8 = r5.flags     // Catch:{ all -> 0x009a }
            r8 = r8[r6]     // Catch:{ all -> 0x009a }
            r7.setFlags(r8)     // Catch:{ all -> 0x009a }
            int r8 = r5.readPosition     // Catch:{ all -> 0x009a }
            int r1 = r5.length     // Catch:{ all -> 0x009a }
            int r1 = r1 - r0
            if (r8 != r1) goto L_0x0070
            if (r9 != 0) goto L_0x006b
            boolean r8 = r5.isLastSampleQueued     // Catch:{ all -> 0x009a }
            if (r8 == 0) goto L_0x0070
        L_0x006b:
            r8 = 536870912(0x20000000, float:1.0842022E-19)
            r7.addFlag(r8)     // Catch:{ all -> 0x009a }
        L_0x0070:
            long[] r8 = r5.timesUs     // Catch:{ all -> 0x009a }
            r0 = r8[r6]     // Catch:{ all -> 0x009a }
            r7.timeUs = r0     // Catch:{ all -> 0x009a }
            long r8 = r5.startTimeUs     // Catch:{ all -> 0x009a }
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x0081
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r7.addFlag(r8)     // Catch:{ all -> 0x009a }
        L_0x0081:
            int[] r7 = r5.sizes     // Catch:{ all -> 0x009a }
            r7 = r7[r6]     // Catch:{ all -> 0x009a }
            r10.size = r7     // Catch:{ all -> 0x009a }
            long[] r7 = r5.offsets     // Catch:{ all -> 0x009a }
            r8 = r7[r6]     // Catch:{ all -> 0x009a }
            r10.offset = r8     // Catch:{ all -> 0x009a }
            com.google.android.exoplayer2.extractor.TrackOutput$CryptoData[] r7 = r5.cryptoDatas     // Catch:{ all -> 0x009a }
            r6 = r7[r6]     // Catch:{ all -> 0x009a }
            r10.cryptoData = r6     // Catch:{ all -> 0x009a }
            monitor-exit(r5)
            return r3
        L_0x0095:
            r5.onFormatResult(r0, r6)     // Catch:{ all -> 0x009a }
            monitor-exit(r5)
            return r1
        L_0x009a:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.peekSampleMetadata(com.google.android.exoplayer2.FormatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer, boolean, boolean, com.google.android.exoplayer2.source.SampleQueue$SampleExtrasHolder):int");
    }

    private void releaseDrmSessionReferences() {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null) {
            drmSession.release(this.drmEventDispatcher);
            this.currentDrmSession = null;
            this.downstreamFormat = null;
        }
    }

    private synchronized void rewind() {
        this.readPosition = 0;
        this.sampleDataQueue.rewind();
    }

    private synchronized boolean setUpstreamFormat(Format format) {
        this.upstreamFormatRequired = false;
        if (Util.areEqual(format, this.upstreamFormat)) {
            return false;
        }
        if (this.sharedSampleMetadata.isEmpty() || !this.sharedSampleMetadata.getEndValue().format.equals(format)) {
            this.upstreamFormat = format;
        } else {
            this.upstreamFormat = this.sharedSampleMetadata.getEndValue().format;
        }
        Format format2 = this.upstreamFormat;
        this.upstreamAllSamplesAreSyncSamples = MimeTypes.allSamplesAreSyncSamples(format2.sampleMimeType, format2.codecs);
        this.loggedUnexpectedNonSyncSample = false;
        return true;
    }

    public synchronized long discardSampleMetadataToRead() {
        int i11 = this.readPosition;
        if (i11 == 0) {
            return -1;
        }
        return discardSamples(i11);
    }

    public final void discardTo(long j11, boolean z11, boolean z12) {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataTo(j11, z11, z12));
    }

    public final void discardToEnd() {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataToEnd());
    }

    public final void discardToRead() {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataToRead());
    }

    public final void discardUpstreamFrom(long j11) {
        boolean z11;
        if (this.length != 0) {
            if (j11 > getLargestReadTimestampUs()) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkArgument(z11);
            discardUpstreamSamples(this.absoluteFirstIndex + countUnreadSamplesBefore(j11));
        }
    }

    public final void discardUpstreamSamples(int i11) {
        this.sampleDataQueue.discardUpstreamSampleBytes(discardUpstreamSampleMetadata(i11));
    }

    public final void format(Format format) {
        Format adjustedUpstreamFormat = getAdjustedUpstreamFormat(format);
        this.upstreamFormatAdjustmentRequired = false;
        this.unadjustedUpstreamFormat = format;
        boolean upstreamFormat2 = setUpstreamFormat(adjustedUpstreamFormat);
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener != null && upstreamFormat2) {
            upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedUpstreamFormat);
        }
    }

    @CallSuper
    public Format getAdjustedUpstreamFormat(Format format) {
        if (this.sampleOffsetUs == 0 || format.subsampleOffsetUs == Long.MAX_VALUE) {
            return format;
        }
        return format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.sampleOffsetUs).build();
    }

    public final int getFirstIndex() {
        return this.absoluteFirstIndex;
    }

    public final synchronized long getFirstTimestampUs() {
        long j11;
        if (this.length == 0) {
            j11 = Long.MIN_VALUE;
        } else {
            j11 = this.timesUs[this.relativeFirstIndex];
        }
        return j11;
    }

    public final synchronized long getLargestQueuedTimestampUs() {
        return this.largestQueuedTimestampUs;
    }

    public final synchronized long getLargestReadTimestampUs() {
        return Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.readPosition));
    }

    public final int getReadIndex() {
        return this.absoluteFirstIndex + this.readPosition;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int getSkipCount(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.readPosition     // Catch:{ all -> 0x003c }
            int r2 = r8.getRelativeIndex(r0)     // Catch:{ all -> 0x003c }
            boolean r0 = r8.hasNextSample()     // Catch:{ all -> 0x003c }
            r7 = 0
            if (r0 == 0) goto L_0x003a
            long[] r0 = r8.timesUs     // Catch:{ all -> 0x003c }
            r3 = r0[r2]     // Catch:{ all -> 0x003c }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0017
            goto L_0x003a
        L_0x0017:
            long r0 = r8.largestQueuedTimestampUs     // Catch:{ all -> 0x003c }
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0026
            if (r11 == 0) goto L_0x0026
            int r9 = r8.length     // Catch:{ all -> 0x003c }
            int r10 = r8.readPosition     // Catch:{ all -> 0x003c }
            int r9 = r9 - r10
            monitor-exit(r8)
            return r9
        L_0x0026:
            int r11 = r8.length     // Catch:{ all -> 0x003c }
            int r0 = r8.readPosition     // Catch:{ all -> 0x003c }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.findSampleBefore(r2, r3, r4, r6)     // Catch:{ all -> 0x003c }
            r10 = -1
            if (r9 != r10) goto L_0x0038
            monitor-exit(r8)
            return r7
        L_0x0038:
            monitor-exit(r8)
            return r9
        L_0x003a:
            monitor-exit(r8)
            return r7
        L_0x003c:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.getSkipCount(long, boolean):int");
    }

    @Nullable
    public final synchronized Format getUpstreamFormat() {
        Format format;
        if (this.upstreamFormatRequired) {
            format = null;
        } else {
            format = this.upstreamFormat;
        }
        return format;
    }

    public final int getWriteIndex() {
        return this.absoluteFirstIndex + this.length;
    }

    public final void invalidateUpstreamFormatAdjustment() {
        this.upstreamFormatAdjustmentRequired = true;
    }

    public final synchronized boolean isLastSampleQueued() {
        return this.isLastSampleQueued;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return r1;
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isReady(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.hasNextSample()     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 != 0) goto L_0x001a
            if (r3 != 0) goto L_0x0018
            boolean r3 = r2.isLastSampleQueued     // Catch:{ all -> 0x003a }
            if (r3 != 0) goto L_0x0018
            com.google.android.exoplayer2.Format r3 = r2.upstreamFormat     // Catch:{ all -> 0x003a }
            if (r3 == 0) goto L_0x0017
            com.google.android.exoplayer2.Format r0 = r2.downstreamFormat     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            monitor-exit(r2)
            return r1
        L_0x001a:
            com.google.android.exoplayer2.source.SpannedData<com.google.android.exoplayer2.source.SampleQueue$SharedSampleMetadata> r3 = r2.sharedSampleMetadata     // Catch:{ all -> 0x003a }
            int r0 = r2.getReadIndex()     // Catch:{ all -> 0x003a }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x003a }
            com.google.android.exoplayer2.source.SampleQueue$SharedSampleMetadata r3 = (com.google.android.exoplayer2.source.SampleQueue.SharedSampleMetadata) r3     // Catch:{ all -> 0x003a }
            com.google.android.exoplayer2.Format r3 = r3.format     // Catch:{ all -> 0x003a }
            com.google.android.exoplayer2.Format r0 = r2.downstreamFormat     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x002e
            monitor-exit(r2)
            return r1
        L_0x002e:
            int r3 = r2.readPosition     // Catch:{ all -> 0x003a }
            int r3 = r2.getRelativeIndex(r3)     // Catch:{ all -> 0x003a }
            boolean r3 = r2.mayReadSample(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)
            return r3
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.isReady(boolean):boolean");
    }

    @CallSuper
    public void maybeThrowError() throws IOException {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) Assertions.checkNotNull(this.currentDrmSession.getError()));
        }
    }

    public final synchronized int peekSourceId() {
        int i11;
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample()) {
            i11 = this.sourceIds[relativeIndex];
        } else {
            i11 = this.upstreamSourceId;
        }
        return i11;
    }

    @CallSuper
    public void preRelease() {
        discardToEnd();
        releaseDrmSessionReferences();
    }

    @CallSuper
    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i11, boolean z11) {
        boolean z12;
        boolean z13 = false;
        if ((i11 & 2) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        int peekSampleMetadata = peekSampleMetadata(formatHolder, decoderInputBuffer, z12, z11, this.extrasHolder);
        if (peekSampleMetadata == -4 && !decoderInputBuffer.isEndOfStream()) {
            if ((i11 & 1) != 0) {
                z13 = true;
            }
            if ((i11 & 4) == 0) {
                if (z13) {
                    this.sampleDataQueue.peekToBuffer(decoderInputBuffer, this.extrasHolder);
                } else {
                    this.sampleDataQueue.readToBuffer(decoderInputBuffer, this.extrasHolder);
                }
            }
            if (!z13) {
                this.readPosition++;
            }
        }
        return peekSampleMetadata;
    }

    @CallSuper
    public void release() {
        reset(true);
        releaseDrmSessionReferences();
    }

    public final void reset() {
        reset(false);
    }

    public /* synthetic */ int sampleData(DataReader dataReader, int i11, boolean z11) {
        return f.a(this, dataReader, i11, z11);
    }

    public final int sampleData(DataReader dataReader, int i11, boolean z11, int i12) throws IOException {
        return this.sampleDataQueue.sampleData(dataReader, i11, z11);
    }

    public /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i11) {
        f.b(this, parsableByteArray, i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sampleMetadata(long r12, int r14, int r15, int r16, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.TrackOutput.CryptoData r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.upstreamFormatAdjustmentRequired
            if (r0 == 0) goto L_0x0010
            com.google.android.exoplayer2.Format r0 = r8.unadjustedUpstreamFormat
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.checkStateNotNull(r0)
            com.google.android.exoplayer2.Format r0 = (com.google.android.exoplayer2.Format) r0
            r11.format(r0)
        L_0x0010:
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0018
            r3 = r2
            goto L_0x0019
        L_0x0018:
            r3 = r1
        L_0x0019:
            boolean r4 = r8.upstreamKeyframeRequired
            if (r4 == 0) goto L_0x0022
            if (r3 != 0) goto L_0x0020
            return
        L_0x0020:
            r8.upstreamKeyframeRequired = r1
        L_0x0022:
            long r4 = r8.sampleOffsetUs
            long r4 = r4 + r12
            boolean r6 = r8.upstreamAllSamplesAreSyncSamples
            if (r6 == 0) goto L_0x0054
            long r6 = r8.startTimeUs
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x0030
            return
        L_0x0030:
            if (r0 != 0) goto L_0x0054
            boolean r0 = r8.loggedUnexpectedNonSyncSample
            if (r0 != 0) goto L_0x0050
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "Overriding unexpected non-sync sample for format: "
            r0.append(r6)
            com.google.android.exoplayer2.Format r6 = r8.upstreamFormat
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "SampleQueue"
            com.google.android.exoplayer2.util.Log.w(r6, r0)
            r8.loggedUnexpectedNonSyncSample = r2
        L_0x0050:
            r0 = r14 | 1
            r6 = r0
            goto L_0x0055
        L_0x0054:
            r6 = r14
        L_0x0055:
            boolean r0 = r8.pendingSplice
            if (r0 == 0) goto L_0x0066
            if (r3 == 0) goto L_0x0065
            boolean r0 = r11.attemptSplice(r4)
            if (r0 != 0) goto L_0x0062
            goto L_0x0065
        L_0x0062:
            r8.pendingSplice = r1
            goto L_0x0066
        L_0x0065:
            return
        L_0x0066:
            com.google.android.exoplayer2.source.SampleDataQueue r0 = r8.sampleDataQueue
            long r0 = r0.getTotalBytesWritten()
            r7 = r15
            long r2 = (long) r7
            long r0 = r0 - r2
            r2 = r16
            long r2 = (long) r2
            long r9 = r0 - r2
            r0 = r11
            r1 = r4
            r3 = r6
            r4 = r9
            r6 = r15
            r7 = r17
            r0.commitSample(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.sampleMetadata(long, int, int, int, com.google.android.exoplayer2.extractor.TrackOutput$CryptoData):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean seekTo(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.rewind()     // Catch:{ all -> 0x001b }
            int r0 = r3.absoluteFirstIndex     // Catch:{ all -> 0x001b }
            if (r4 < r0) goto L_0x0018
            int r1 = r3.length     // Catch:{ all -> 0x001b }
            int r1 = r1 + r0
            if (r4 <= r1) goto L_0x000e
            goto L_0x0018
        L_0x000e:
            r1 = -9223372036854775808
            r3.startTimeUs = r1     // Catch:{ all -> 0x001b }
            int r4 = r4 - r0
            r3.readPosition = r4     // Catch:{ all -> 0x001b }
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x0018:
            monitor-exit(r3)
            r4 = 0
            return r4
        L_0x001b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.seekTo(int):boolean");
    }

    public final void setSampleOffsetUs(long j11) {
        if (this.sampleOffsetUs != j11) {
            this.sampleOffsetUs = j11;
            invalidateUpstreamFormatAdjustment();
        }
    }

    public final void setStartTimeUs(long j11) {
        this.startTimeUs = j11;
    }

    public final void setUpstreamFormatChangeListener(@Nullable UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public final synchronized void skip(int i11) {
        boolean z11;
        if (i11 >= 0) {
            try {
                if (this.readPosition + i11 <= this.length) {
                    z11 = true;
                    Assertions.checkArgument(z11);
                    this.readPosition += i11;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        z11 = false;
        Assertions.checkArgument(z11);
        this.readPosition += i11;
    }

    public final void sourceId(int i11) {
        this.upstreamSourceId = i11;
    }

    public final void splice() {
        this.pendingSplice = true;
    }

    @CallSuper
    public void reset(boolean z11) {
        this.sampleDataQueue.reset();
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.upstreamKeyframeRequired = true;
        this.startTimeUs = Long.MIN_VALUE;
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        this.isLastSampleQueued = false;
        this.sharedSampleMetadata.clear();
        if (z11) {
            this.unadjustedUpstreamFormat = null;
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
        }
    }

    public final void sampleData(ParsableByteArray parsableByteArray, int i11, int i12) {
        this.sampleDataQueue.sampleData(parsableByteArray, i11);
    }

    @Deprecated
    public static SampleQueue createWithDrm(Allocator allocator, Looper looper, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        drmSessionManager2.setPlayer(looper, PlayerId.UNSET);
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.checkNotNull(drmSessionManager2), (DrmSessionEventListener.EventDispatcher) Assertions.checkNotNull(eventDispatcher));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean seekTo(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.rewind()     // Catch:{ all -> 0x0040 }
            int r0 = r8.readPosition     // Catch:{ all -> 0x0040 }
            int r2 = r8.getRelativeIndex(r0)     // Catch:{ all -> 0x0040 }
            boolean r0 = r8.hasNextSample()     // Catch:{ all -> 0x0040 }
            r7 = 0
            if (r0 == 0) goto L_0x003e
            long[] r0 = r8.timesUs     // Catch:{ all -> 0x0040 }
            r3 = r0[r2]     // Catch:{ all -> 0x0040 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x003e
            long r0 = r8.largestQueuedTimestampUs     // Catch:{ all -> 0x0040 }
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0022
            if (r11 != 0) goto L_0x0022
            goto L_0x003e
        L_0x0022:
            int r11 = r8.length     // Catch:{ all -> 0x0040 }
            int r0 = r8.readPosition     // Catch:{ all -> 0x0040 }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r11 = r1.findSampleBefore(r2, r3, r4, r6)     // Catch:{ all -> 0x0040 }
            r0 = -1
            if (r11 != r0) goto L_0x0034
            monitor-exit(r8)
            return r7
        L_0x0034:
            r8.startTimeUs = r9     // Catch:{ all -> 0x0040 }
            int r9 = r8.readPosition     // Catch:{ all -> 0x0040 }
            int r9 = r9 + r11
            r8.readPosition = r9     // Catch:{ all -> 0x0040 }
            monitor-exit(r8)
            r9 = 1
            return r9
        L_0x003e:
            monitor-exit(r8)
            return r7
        L_0x0040:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.seekTo(long, boolean):boolean");
    }
}
