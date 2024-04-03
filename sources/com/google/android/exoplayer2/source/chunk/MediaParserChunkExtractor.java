package com.google.android.exoplayer2.source.chunk;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import c8.d;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(30)
public final class MediaParserChunkExtractor implements ChunkExtractor {
    public static final ChunkExtractor.Factory FACTORY = new d();
    private static final String TAG = "MediaPrsrChunkExtractor";
    /* access modifiers changed from: private */
    public final DummyTrackOutput dummyTrackOutput;
    private final InputReaderAdapterV30 inputReaderAdapter = new InputReaderAdapterV30();
    private final MediaParser mediaParser;
    /* access modifiers changed from: private */
    public final OutputConsumerAdapterV30 outputConsumerAdapter;
    private long pendingSeekUs;
    /* access modifiers changed from: private */
    @Nullable
    public Format[] sampleFormats;
    /* access modifiers changed from: private */
    @Nullable
    public ChunkExtractor.TrackOutputProvider trackOutputProvider;
    private final TrackOutputProviderAdapter trackOutputProviderAdapter;

    public class TrackOutputProviderAdapter implements ExtractorOutput {
        private TrackOutputProviderAdapter() {
        }

        public void endTracks() {
            MediaParserChunkExtractor mediaParserChunkExtractor = MediaParserChunkExtractor.this;
            Format[] unused = mediaParserChunkExtractor.sampleFormats = mediaParserChunkExtractor.outputConsumerAdapter.getSampleFormats();
        }

        public void seekMap(SeekMap seekMap) {
        }

        public TrackOutput track(int i11, int i12) {
            return MediaParserChunkExtractor.this.trackOutputProvider != null ? MediaParserChunkExtractor.this.trackOutputProvider.track(i11, i12) : MediaParserChunkExtractor.this.dummyTrackOutput;
        }
    }

    @SuppressLint({"WrongConstant"})
    public MediaParserChunkExtractor(int i11, Format format, List<Format> list, PlayerId playerId) {
        String str;
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30(format, i11, true);
        this.outputConsumerAdapter = outputConsumerAdapterV30;
        if (MimeTypes.isMatroska((String) Assertions.checkNotNull(format.containerMimeType))) {
            str = "android.media.mediaparser.MatroskaParser";
        } else {
            str = "android.media.mediaparser.FragmentedMp4Parser";
        }
        outputConsumerAdapterV30.setSelectedParserName(str);
        MediaParser a11 = MediaParser.createByName(str, outputConsumerAdapterV30);
        this.mediaParser = a11;
        Boolean bool = Boolean.TRUE;
        MediaParser unused = a11.setParameter("android.media.mediaparser.matroska.disableCuesSeeking", bool);
        MediaParser unused2 = a11.setParameter(MediaParserUtil.PARAMETER_IN_BAND_CRYPTO_INFO, bool);
        MediaParser unused3 = a11.setParameter(MediaParserUtil.PARAMETER_INCLUDE_SUPPLEMENTAL_DATA, bool);
        MediaParser unused4 = a11.setParameter(MediaParserUtil.PARAMETER_EAGERLY_EXPOSE_TRACK_TYPE, bool);
        MediaParser unused5 = a11.setParameter(MediaParserUtil.PARAMETER_EXPOSE_DUMMY_SEEK_MAP, bool);
        MediaParser unused6 = a11.setParameter(MediaParserUtil.PARAMETER_EXPOSE_CHUNK_INDEX_AS_MEDIA_FORMAT, bool);
        MediaParser unused7 = a11.setParameter(MediaParserUtil.PARAMETER_OVERRIDE_IN_BAND_CAPTION_DECLARATIONS, bool);
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            arrayList.add(MediaParserUtil.toCaptionsMediaFormat(list.get(i12)));
        }
        MediaParser unused8 = this.mediaParser.setParameter(MediaParserUtil.PARAMETER_EXPOSE_CAPTION_FORMATS, arrayList);
        if (Util.SDK_INT >= 31) {
            MediaParserUtil.setLogSessionIdOnMediaParser(this.mediaParser, playerId);
        }
        this.outputConsumerAdapter.setMuxedCaptionFormats(list);
        this.trackOutputProviderAdapter = new TrackOutputProviderAdapter();
        this.dummyTrackOutput = new DummyTrackOutput();
        this.pendingSeekUs = C.TIME_UNSET;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ChunkExtractor lambda$static$0(int i11, Format format, boolean z11, List list, TrackOutput trackOutput, PlayerId playerId) {
        if (!MimeTypes.isText(format.containerMimeType)) {
            return new MediaParserChunkExtractor(i11, format, list, playerId);
        }
        Log.w(TAG, "Ignoring an unsupported text track.");
        return null;
    }

    private void maybeExecutePendingSeek() {
        MediaParser.SeekMap dummySeekMap = this.outputConsumerAdapter.getDummySeekMap();
        long j11 = this.pendingSeekUs;
        if (j11 != C.TIME_UNSET && dummySeekMap != null) {
            this.mediaParser.seek((MediaParser.SeekPoint) dummySeekMap.getSeekPoints(j11).first);
            this.pendingSeekUs = C.TIME_UNSET;
        }
    }

    @Nullable
    public ChunkIndex getChunkIndex() {
        return this.outputConsumerAdapter.getChunkIndex();
    }

    @Nullable
    public Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    public void init(@Nullable ChunkExtractor.TrackOutputProvider trackOutputProvider2, long j11, long j12) {
        this.trackOutputProvider = trackOutputProvider2;
        this.outputConsumerAdapter.setSampleTimestampUpperLimitFilterUs(j12);
        this.outputConsumerAdapter.setExtractorOutput(this.trackOutputProviderAdapter);
        this.pendingSeekUs = j11;
    }

    public boolean read(ExtractorInput extractorInput) throws IOException {
        maybeExecutePendingSeek();
        this.inputReaderAdapter.setDataReader(extractorInput, extractorInput.getLength());
        return this.mediaParser.advance(this.inputReaderAdapter);
    }

    public void release() {
        this.mediaParser.release();
    }
}
