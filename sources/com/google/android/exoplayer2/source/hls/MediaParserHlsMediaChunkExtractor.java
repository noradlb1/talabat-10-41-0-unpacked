package com.google.android.exoplayer2.source.hls;

import android.annotation.SuppressLint;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import e8.c;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequiresApi(30)
public final class MediaParserHlsMediaChunkExtractor implements HlsMediaChunkExtractor {
    public static final HlsExtractorFactory FACTORY = new c();
    private final Format format;
    private final InputReaderAdapterV30 inputReaderAdapter = new InputReaderAdapterV30();
    private final MediaParser mediaParser;
    private final ImmutableList<MediaFormat> muxedCaptionMediaFormats;
    private final OutputConsumerAdapterV30 outputConsumerAdapter;
    private final boolean overrideInBandCaptionDeclarations;
    private int pendingSkipBytes;
    private final PlayerId playerId;

    public static final class PeekingInputReader implements MediaParser.SeekableInputReader {
        private final ExtractorInput extractorInput;
        /* access modifiers changed from: private */
        public int totalPeekedBytes;

        public long getLength() {
            return this.extractorInput.getLength();
        }

        public long getPosition() {
            return this.extractorInput.getPeekPosition();
        }

        public int read(byte[] bArr, int i11, int i12) throws IOException {
            int peek = this.extractorInput.peek(bArr, i11, i12);
            this.totalPeekedBytes += peek;
            return peek;
        }

        public void seekToPosition(long j11) {
            throw new UnsupportedOperationException();
        }

        private PeekingInputReader(ExtractorInput extractorInput2) {
            this.extractorInput = extractorInput2;
        }
    }

    public MediaParserHlsMediaChunkExtractor(MediaParser mediaParser2, OutputConsumerAdapterV30 outputConsumerAdapterV30, Format format2, boolean z11, ImmutableList<MediaFormat> immutableList, int i11, PlayerId playerId2) {
        this.mediaParser = mediaParser2;
        this.outputConsumerAdapter = outputConsumerAdapterV30;
        this.overrideInBandCaptionDeclarations = z11;
        this.muxedCaptionMediaFormats = immutableList;
        this.format = format2;
        this.playerId = playerId2;
        this.pendingSkipBytes = i11;
    }

    @SuppressLint({"WrongConstant"})
    private static MediaParser createMediaParserInstance(MediaParser.OutputConsumer outputConsumer, Format format2, boolean z11, ImmutableList<MediaFormat> immutableList, PlayerId playerId2, String... strArr) {
        MediaParser mediaParser2;
        if (strArr.length == 1) {
            mediaParser2 = MediaParser.createByName(strArr[0], outputConsumer);
        } else {
            mediaParser2 = MediaParser.create(outputConsumer, strArr);
        }
        MediaParser unused = mediaParser2.setParameter(MediaParserUtil.PARAMETER_EXPOSE_CAPTION_FORMATS, immutableList);
        MediaParser unused2 = mediaParser2.setParameter(MediaParserUtil.PARAMETER_OVERRIDE_IN_BAND_CAPTION_DECLARATIONS, Boolean.valueOf(z11));
        Boolean bool = Boolean.TRUE;
        MediaParser unused3 = mediaParser2.setParameter(MediaParserUtil.PARAMETER_IN_BAND_CRYPTO_INFO, bool);
        MediaParser unused4 = mediaParser2.setParameter(MediaParserUtil.PARAMETER_EAGERLY_EXPOSE_TRACK_TYPE, bool);
        MediaParser unused5 = mediaParser2.setParameter(MediaParserUtil.PARAMETER_IGNORE_TIMESTAMP_OFFSET, bool);
        MediaParser unused6 = mediaParser2.setParameter("android.media.mediaparser.ts.ignoreSpliceInfoStream", bool);
        MediaParser unused7 = mediaParser2.setParameter("android.media.mediaparser.ts.mode", "hls");
        String str = format2.codecs;
        if (!TextUtils.isEmpty(str)) {
            if (!MimeTypes.AUDIO_AAC.equals(MimeTypes.getAudioMediaMimeType(str))) {
                MediaParser unused8 = mediaParser2.setParameter("android.media.mediaparser.ts.ignoreAacStream", bool);
            }
            if (!MimeTypes.VIDEO_H264.equals(MimeTypes.getVideoMediaMimeType(str))) {
                MediaParser unused9 = mediaParser2.setParameter("android.media.mediaparser.ts.ignoreAvcStream", bool);
            }
        }
        if (Util.SDK_INT >= 31) {
            MediaParserUtil.setLogSessionIdOnMediaParser(mediaParser2, playerId2);
        }
        return mediaParser2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ HlsMediaChunkExtractor lambda$static$0(Uri uri, Format format2, List list, TimestampAdjuster timestampAdjuster, Map map, ExtractorInput extractorInput, PlayerId playerId2) throws IOException {
        boolean z11;
        if (FileTypes.inferFileTypeFromMimeType(format2.sampleMimeType) == 13) {
            return new BundledHlsMediaChunkExtractor(new WebvttExtractor(format2.language, timestampAdjuster), format2, timestampAdjuster);
        }
        if (list != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        if (list != null) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                builder.add((Object) MediaParserUtil.toCaptionsMediaFormat((Format) list.get(i11)));
            }
        } else {
            builder.add((Object) MediaParserUtil.toCaptionsMediaFormat(new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_CEA608).build()));
        }
        ImmutableList build = builder.build();
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30();
        if (list == null) {
            list = ImmutableList.of();
        }
        outputConsumerAdapterV30.setMuxedCaptionFormats(list);
        outputConsumerAdapterV30.setTimestampAdjuster(timestampAdjuster);
        MediaParser createMediaParserInstance = createMediaParserInstance(outputConsumerAdapterV30, format2, z11, build, playerId2, "android.media.mediaparser.FragmentedMp4Parser", "android.media.mediaparser.Ac3Parser", "android.media.mediaparser.Ac4Parser", "android.media.mediaparser.AdtsParser", "android.media.mediaparser.Mp3Parser", "android.media.mediaparser.TsParser");
        PeekingInputReader peekingInputReader = new PeekingInputReader(extractorInput);
        boolean unused = createMediaParserInstance.advance(peekingInputReader);
        outputConsumerAdapterV30.setSelectedParserName(createMediaParserInstance.getParserName());
        return new MediaParserHlsMediaChunkExtractor(createMediaParserInstance, outputConsumerAdapterV30, format2, z11, build, peekingInputReader.totalPeekedBytes, playerId2);
    }

    public void init(ExtractorOutput extractorOutput) {
        this.outputConsumerAdapter.setExtractorOutput(extractorOutput);
    }

    public boolean isPackedAudioExtractor() {
        String a11 = this.mediaParser.getParserName();
        if ("android.media.mediaparser.Ac3Parser".equals(a11) || "android.media.mediaparser.Ac4Parser".equals(a11) || "android.media.mediaparser.AdtsParser".equals(a11) || "android.media.mediaparser.Mp3Parser".equals(a11)) {
            return true;
        }
        return false;
    }

    public boolean isReusable() {
        String a11 = this.mediaParser.getParserName();
        if ("android.media.mediaparser.FragmentedMp4Parser".equals(a11) || "android.media.mediaparser.TsParser".equals(a11)) {
            return true;
        }
        return false;
    }

    public void onTruncatedSegmentParsed() {
        this.mediaParser.seek(MediaParser.SeekPoint.START);
    }

    public boolean read(ExtractorInput extractorInput) throws IOException {
        extractorInput.skipFully(this.pendingSkipBytes);
        this.pendingSkipBytes = 0;
        this.inputReaderAdapter.setDataReader(extractorInput, extractorInput.getLength());
        return this.mediaParser.advance(this.inputReaderAdapter);
    }

    public HlsMediaChunkExtractor recreate() {
        Assertions.checkState(!isReusable());
        return new MediaParserHlsMediaChunkExtractor(createMediaParserInstance(this.outputConsumerAdapter, this.format, this.overrideInBandCaptionDeclarations, this.muxedCaptionMediaFormats, this.playerId, this.mediaParser.getParserName()), this.outputConsumerAdapter, this.format, this.overrideInBandCaptionDeclarations, this.muxedCaptionMediaFormats, 0, this.playerId);
    }
}
