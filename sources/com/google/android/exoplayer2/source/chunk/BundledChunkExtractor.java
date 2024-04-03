package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import c8.a;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import l7.f;

public final class BundledChunkExtractor implements ExtractorOutput, ChunkExtractor {
    public static final ChunkExtractor.Factory FACTORY = new a();
    private static final PositionHolder POSITION_HOLDER = new PositionHolder();
    private final SparseArray<BindingTrackOutput> bindingTrackOutputs = new SparseArray<>();
    private long endTimeUs;
    private final Extractor extractor;
    private boolean extractorInitialized;
    private final Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private Format[] sampleFormats;
    private SeekMap seekMap;
    @Nullable
    private ChunkExtractor.TrackOutputProvider trackOutputProvider;

    public static final class BindingTrackOutput implements TrackOutput {
        private long endTimeUs;
        private final DummyTrackOutput fakeTrackOutput = new DummyTrackOutput();

        /* renamed from: id  reason: collision with root package name */
        private final int f35019id;
        @Nullable
        private final Format manifestFormat;
        public Format sampleFormat;
        private TrackOutput trackOutput;
        private final int type;

        public BindingTrackOutput(int i11, int i12, @Nullable Format format) {
            this.f35019id = i11;
            this.type = i12;
            this.manifestFormat = format;
        }

        public void bind(@Nullable ChunkExtractor.TrackOutputProvider trackOutputProvider, long j11) {
            if (trackOutputProvider == null) {
                this.trackOutput = this.fakeTrackOutput;
                return;
            }
            this.endTimeUs = j11;
            TrackOutput track = trackOutputProvider.track(this.f35019id, this.type);
            this.trackOutput = track;
            Format format = this.sampleFormat;
            if (format != null) {
                track.format(format);
            }
        }

        public void format(Format format) {
            Format format2 = this.manifestFormat;
            if (format2 != null) {
                format = format.withManifestFormatInfo(format2);
            }
            this.sampleFormat = format;
            ((TrackOutput) Util.castNonNull(this.trackOutput)).format(this.sampleFormat);
        }

        public /* synthetic */ int sampleData(DataReader dataReader, int i11, boolean z11) {
            return f.a(this, dataReader, i11, z11);
        }

        public int sampleData(DataReader dataReader, int i11, boolean z11, int i12) throws IOException {
            return ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleData(dataReader, i11, z11);
        }

        public /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i11) {
            f.b(this, parsableByteArray, i11);
        }

        public void sampleMetadata(long j11, int i11, int i12, int i13, @Nullable TrackOutput.CryptoData cryptoData) {
            long j12 = this.endTimeUs;
            if (j12 != C.TIME_UNSET && j11 >= j12) {
                this.trackOutput = this.fakeTrackOutput;
            }
            ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleMetadata(j11, i11, i12, i13, cryptoData);
        }

        public void sampleData(ParsableByteArray parsableByteArray, int i11, int i12) {
            ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleData(parsableByteArray, i11);
        }
    }

    public BundledChunkExtractor(Extractor extractor2, int i11, Format format) {
        this.extractor = extractor2;
        this.primaryTrackType = i11;
        this.primaryTrackManifestFormat = format;
    }

    /* JADX WARNING: type inference failed for: r8v6, types: [com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ com.google.android.exoplayer2.source.chunk.ChunkExtractor lambda$static$0(int r6, com.google.android.exoplayer2.Format r7, boolean r8, java.util.List r9, com.google.android.exoplayer2.extractor.TrackOutput r10, com.google.android.exoplayer2.analytics.PlayerId r11) {
        /*
            java.lang.String r11 = r7.containerMimeType
            boolean r0 = com.google.android.exoplayer2.util.MimeTypes.isText(r11)
            if (r0 == 0) goto L_0x000a
            r6 = 0
            return r6
        L_0x000a:
            boolean r11 = com.google.android.exoplayer2.util.MimeTypes.isMatroska(r11)
            if (r11 == 0) goto L_0x0017
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor r8 = new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor
            r9 = 1
            r8.<init>(r9)
            goto L_0x0027
        L_0x0017:
            if (r8 == 0) goto L_0x001b
            r8 = 4
            goto L_0x001c
        L_0x001b:
            r8 = 0
        L_0x001c:
            r1 = r8
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor r8 = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor
            r2 = 0
            r3 = 0
            r0 = r8
            r4 = r9
            r5 = r10
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0027:
            com.google.android.exoplayer2.source.chunk.BundledChunkExtractor r9 = new com.google.android.exoplayer2.source.chunk.BundledChunkExtractor
            r9.<init>(r8, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.chunk.BundledChunkExtractor.lambda$static$0(int, com.google.android.exoplayer2.Format, boolean, java.util.List, com.google.android.exoplayer2.extractor.TrackOutput, com.google.android.exoplayer2.analytics.PlayerId):com.google.android.exoplayer2.source.chunk.ChunkExtractor");
    }

    public void endTracks() {
        Format[] formatArr = new Format[this.bindingTrackOutputs.size()];
        for (int i11 = 0; i11 < this.bindingTrackOutputs.size(); i11++) {
            formatArr[i11] = (Format) Assertions.checkStateNotNull(this.bindingTrackOutputs.valueAt(i11).sampleFormat);
        }
        this.sampleFormats = formatArr;
    }

    @Nullable
    public ChunkIndex getChunkIndex() {
        SeekMap seekMap2 = this.seekMap;
        if (seekMap2 instanceof ChunkIndex) {
            return (ChunkIndex) seekMap2;
        }
        return null;
    }

    @Nullable
    public Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    public void init(@Nullable ChunkExtractor.TrackOutputProvider trackOutputProvider2, long j11, long j12) {
        this.trackOutputProvider = trackOutputProvider2;
        this.endTimeUs = j12;
        if (!this.extractorInitialized) {
            this.extractor.init(this);
            if (j11 != C.TIME_UNSET) {
                this.extractor.seek(0, j11);
            }
            this.extractorInitialized = true;
            return;
        }
        Extractor extractor2 = this.extractor;
        if (j11 == C.TIME_UNSET) {
            j11 = 0;
        }
        extractor2.seek(0, j11);
        for (int i11 = 0; i11 < this.bindingTrackOutputs.size(); i11++) {
            this.bindingTrackOutputs.valueAt(i11).bind(trackOutputProvider2, j12);
        }
    }

    public boolean read(ExtractorInput extractorInput) throws IOException {
        boolean z11;
        int read = this.extractor.read(extractorInput, POSITION_HOLDER);
        if (read != 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        if (read == 0) {
            return true;
        }
        return false;
    }

    public void release() {
        this.extractor.release();
    }

    public void seekMap(SeekMap seekMap2) {
        this.seekMap = seekMap2;
    }

    public TrackOutput track(int i11, int i12) {
        boolean z11;
        Format format;
        BindingTrackOutput bindingTrackOutput = this.bindingTrackOutputs.get(i11);
        if (bindingTrackOutput == null) {
            if (this.sampleFormats == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkState(z11);
            if (i12 == this.primaryTrackType) {
                format = this.primaryTrackManifestFormat;
            } else {
                format = null;
            }
            bindingTrackOutput = new BindingTrackOutput(i11, i12, format);
            bindingTrackOutput.bind(this.trackOutputProvider, this.endTimeUs);
            this.bindingTrackOutputs.put(i11, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }
}
