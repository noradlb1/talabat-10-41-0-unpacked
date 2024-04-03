package com.google.android.exoplayer2.source.mediaparser;

import android.annotation.SuppressLint;
import android.media.DrmInitData;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharUtils;

@RequiresApi(30)
@SuppressLint({"Override"})
public final class OutputConsumerAdapterV30 implements MediaParser.OutputConsumer {
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_DURATIONS = "chunk-index-long-us-durations";
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_OFFSETS = "chunk-index-long-offsets";
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_SIZES = "chunk-index-int-sizes";
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_TIMES = "chunk-index-long-us-times";
    private static final String MEDIA_FORMAT_KEY_TRACK_TYPE = "track-type-string";
    private static final Pattern REGEX_CRYPTO_INFO_PATTERN = Pattern.compile("pattern \\(encrypt: (\\d+), skip: (\\d+)\\)");
    private static final Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> SEEK_POINT_PAIR_START = Pair.create(MediaParser.SeekPoint.START, MediaParser.SeekPoint.START);
    private static final String TAG = "OConsumerAdapterV30";
    @Nullable
    private String containerMimeType;
    @Nullable
    private MediaParser.SeekMap dummySeekMap;
    private final boolean expectDummySeekMap;
    private ExtractorOutput extractorOutput;
    @Nullable
    private ChunkIndex lastChunkIndex;
    private final ArrayList<TrackOutput.CryptoData> lastOutputCryptoDatas;
    private final ArrayList<MediaCodec.CryptoInfo> lastReceivedCryptoInfos;
    @Nullable
    private MediaParser.SeekMap lastSeekMap;
    private List<Format> muxedCaptionFormats;
    private int primaryTrackIndex;
    @Nullable
    private final Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private long sampleTimestampUpperLimitFilterUs;
    private final DataReaderAdapter scratchDataReaderAdapter;
    private boolean seekingDisabled;
    @Nullable
    private TimestampAdjuster timestampAdjuster;
    private final ArrayList<Format> trackFormats;
    private final ArrayList<TrackOutput> trackOutputs;
    private boolean tracksEnded;
    private boolean tracksFoundCalled;

    public static final class DataReaderAdapter implements DataReader {
        @Nullable
        public MediaParser.InputReader input;

        private DataReaderAdapter() {
        }

        public int read(byte[] bArr, int i11, int i12) throws IOException {
            return ((MediaParser.InputReader) Util.castNonNull(this.input)).read(bArr, i11, i12);
        }
    }

    public static final class SeekMapAdapter implements SeekMap {
        private final MediaParser.SeekMap adaptedSeekMap;

        public SeekMapAdapter(MediaParser.SeekMap seekMap) {
            this.adaptedSeekMap = seekMap;
        }

        private static SeekPoint asExoPlayerSeekPoint(MediaParser.SeekPoint seekPoint) {
            return new SeekPoint(seekPoint.timeMicros, seekPoint.position);
        }

        public long getDurationUs() {
            long a11 = this.adaptedSeekMap.getDurationMicros();
            return a11 != -2147483648L ? a11 : C.TIME_UNSET;
        }

        public SeekMap.SeekPoints getSeekPoints(long j11) {
            Pair a11 = this.adaptedSeekMap.getSeekPoints(j11);
            Object obj = a11.first;
            if (obj == a11.second) {
                return new SeekMap.SeekPoints(asExoPlayerSeekPoint((MediaParser.SeekPoint) obj));
            }
            return new SeekMap.SeekPoints(asExoPlayerSeekPoint((MediaParser.SeekPoint) obj), asExoPlayerSeekPoint((MediaParser.SeekPoint) a11.second));
        }

        public boolean isSeekable() {
            return this.adaptedSeekMap.isSeekable();
        }
    }

    public OutputConsumerAdapterV30() {
        this((Format) null, -2, false);
    }

    private void ensureSpaceForTrackIndex(int i11) {
        for (int size = this.trackOutputs.size(); size <= i11; size++) {
            this.trackOutputs.add((Object) null);
            this.trackFormats.add((Object) null);
            this.lastReceivedCryptoInfos.add((Object) null);
            this.lastOutputCryptoDatas.add((Object) null);
        }
    }

    private static int getFlag(MediaFormat mediaFormat, String str, int i11) {
        if (mediaFormat.getInteger(str, 0) != 0) {
            return i11;
        }
        return 0;
    }

    private static List<byte[]> getInitializationData(MediaFormat mediaFormat) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (true) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("csd-");
            int i12 = i11 + 1;
            sb2.append(i11);
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(sb2.toString());
            if (byteBuffer == null) {
                return arrayList;
            }
            arrayList.add(MediaFormatUtil.getArray(byteBuffer));
            i11 = i12;
        }
    }

    private static String getMimeType(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2063506020:
                if (str.equals("android.media.mediaparser.Mp4Parser")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1870824006:
                if (str.equals("android.media.mediaparser.OggParser")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1566427438:
                if (str.equals("android.media.mediaparser.TsParser")) {
                    c11 = 2;
                    break;
                }
                break;
            case -900207883:
                if (str.equals("android.media.mediaparser.AdtsParser")) {
                    c11 = 3;
                    break;
                }
                break;
            case -589864617:
                if (str.equals("android.media.mediaparser.WavParser")) {
                    c11 = 4;
                    break;
                }
                break;
            case 52265814:
                if (str.equals("android.media.mediaparser.PsParser")) {
                    c11 = 5;
                    break;
                }
                break;
            case 116768877:
                if (str.equals("android.media.mediaparser.FragmentedMp4Parser")) {
                    c11 = 6;
                    break;
                }
                break;
            case 376876796:
                if (str.equals("android.media.mediaparser.Ac3Parser")) {
                    c11 = 7;
                    break;
                }
                break;
            case 703268017:
                if (str.equals("android.media.mediaparser.AmrParser")) {
                    c11 = 8;
                    break;
                }
                break;
            case 768643067:
                if (str.equals("android.media.mediaparser.FlacParser")) {
                    c11 = 9;
                    break;
                }
                break;
            case 965962719:
                if (str.equals("android.media.mediaparser.MatroskaParser")) {
                    c11 = 10;
                    break;
                }
                break;
            case 1264380477:
                if (str.equals("android.media.mediaparser.Ac4Parser")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1343957595:
                if (str.equals("android.media.mediaparser.Mp3Parser")) {
                    c11 = 12;
                    break;
                }
                break;
            case 2063134683:
                if (str.equals("android.media.mediaparser.FlvParser")) {
                    c11 = CharUtils.CR;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 6:
                return MimeTypes.VIDEO_MP4;
            case 1:
                return MimeTypes.AUDIO_OGG;
            case 2:
                return MimeTypes.VIDEO_MP2T;
            case 3:
                return MimeTypes.AUDIO_AAC;
            case 4:
                return MimeTypes.AUDIO_RAW;
            case 5:
                return MimeTypes.VIDEO_PS;
            case 7:
                return MimeTypes.AUDIO_AC3;
            case 8:
                return MimeTypes.AUDIO_AMR;
            case 9:
                return MimeTypes.AUDIO_FLAC;
            case 10:
                return MimeTypes.VIDEO_WEBM;
            case 11:
                return MimeTypes.AUDIO_AC4;
            case 12:
                return MimeTypes.AUDIO_MPEG;
            case 13:
                return MimeTypes.VIDEO_FLV;
            default:
                throw new IllegalArgumentException("Illegal parser name: " + str);
        }
    }

    private static int getSelectionFlags(MediaFormat mediaFormat) {
        return getFlag(mediaFormat, "is-forced-subtitle", 2) | getFlag(mediaFormat, "is-autoselect", 4) | 0 | getFlag(mediaFormat, "is-default", 1);
    }

    private void maybeEndTracks() {
        if (this.tracksFoundCalled && !this.tracksEnded) {
            int size = this.trackOutputs.size();
            int i11 = 0;
            while (i11 < size) {
                if (this.trackOutputs.get(i11) != null) {
                    i11++;
                } else {
                    return;
                }
            }
            this.extractorOutput.endTracks();
            this.tracksEnded = true;
        }
    }

    private boolean maybeObtainChunkIndex(MediaFormat mediaFormat) {
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_SIZES);
        if (byteBuffer == null) {
            return false;
        }
        IntBuffer asIntBuffer = byteBuffer.asIntBuffer();
        LongBuffer asLongBuffer = ((ByteBuffer) Assertions.checkNotNull(mediaFormat.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_OFFSETS))).asLongBuffer();
        LongBuffer asLongBuffer2 = ((ByteBuffer) Assertions.checkNotNull(mediaFormat.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_DURATIONS))).asLongBuffer();
        LongBuffer asLongBuffer3 = ((ByteBuffer) Assertions.checkNotNull(mediaFormat.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_TIMES))).asLongBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        long[] jArr = new long[asLongBuffer.remaining()];
        long[] jArr2 = new long[asLongBuffer2.remaining()];
        long[] jArr3 = new long[asLongBuffer3.remaining()];
        asIntBuffer.get(iArr);
        asLongBuffer.get(jArr);
        asLongBuffer2.get(jArr2);
        asLongBuffer3.get(jArr3);
        ChunkIndex chunkIndex = new ChunkIndex(iArr, jArr, jArr2, jArr3);
        this.lastChunkIndex = chunkIndex;
        this.extractorOutput.seekMap(chunkIndex);
        return true;
    }

    @Nullable
    private TrackOutput.CryptoData toExoPlayerCryptoData(int i11, @Nullable MediaCodec.CryptoInfo cryptoInfo) {
        int i12;
        int i13;
        if (cryptoInfo == null) {
            return null;
        }
        if (this.lastReceivedCryptoInfos.get(i11) == cryptoInfo) {
            return (TrackOutput.CryptoData) Assertions.checkNotNull(this.lastOutputCryptoDatas.get(i11));
        }
        try {
            Matcher matcher = REGEX_CRYPTO_INFO_PATTERN.matcher(cryptoInfo.toString());
            matcher.find();
            i12 = Integer.parseInt((String) Util.castNonNull(matcher.group(1)));
            i13 = Integer.parseInt((String) Util.castNonNull(matcher.group(2)));
        } catch (RuntimeException e11) {
            Log.e(TAG, "Unexpected error while parsing CryptoInfo: " + cryptoInfo, e11);
            i12 = 0;
            i13 = 0;
        }
        TrackOutput.CryptoData cryptoData = new TrackOutput.CryptoData(cryptoInfo.mode, cryptoInfo.key, i12, i13);
        this.lastReceivedCryptoInfos.set(i11, cryptoInfo);
        this.lastOutputCryptoDatas.set(i11, cryptoData);
        return cryptoData;
    }

    @Nullable
    private static DrmInitData toExoPlayerDrmInitData(@Nullable String str, @Nullable android.media.DrmInitData drmInitData) {
        if (drmInitData == null) {
            return null;
        }
        int a11 = drmInitData.getSchemeInitDataCount();
        DrmInitData.SchemeData[] schemeDataArr = new DrmInitData.SchemeData[a11];
        for (int i11 = 0; i11 < a11; i11++) {
            DrmInitData.SchemeInitData a12 = drmInitData.getSchemeInitDataAt(i11);
            schemeDataArr[i11] = new DrmInitData.SchemeData(a12.uuid, a12.mimeType, a12.data);
        }
        return new com.google.android.exoplayer2.drm.DrmInitData(str, schemeDataArr);
    }

    private Format toExoPlayerFormat(MediaParser.TrackData trackData) {
        MediaFormat a11 = trackData.mediaFormat;
        String string = a11.getString("mime");
        int a12 = a11.getInteger("caption-service-number", -1);
        int i11 = 0;
        Format.Builder accessibilityChannel = new Format.Builder().setDrmInitData(toExoPlayerDrmInitData(a11.getString("crypto-mode-fourcc"), trackData.drmInitData)).setContainerMimeType(this.containerMimeType).setPeakBitrate(a11.getInteger("bitrate", -1)).setChannelCount(a11.getInteger("channel-count", -1)).setColorInfo(MediaFormatUtil.getColorInfo(a11)).setSampleMimeType(string).setCodecs(a11.getString("codecs-string")).setFrameRate(a11.getFloat("frame-rate", -1.0f)).setWidth(a11.getInteger("width", -1)).setHeight(a11.getInteger("height", -1)).setInitializationData(getInitializationData(a11)).setLanguage(a11.getString(ConstantsKt.ADJUST_LANGUAGE)).setMaxInputSize(a11.getInteger("max-input-size", -1)).setPcmEncoding(a11.getInteger("exo-pcm-encoding", -1)).setRotationDegrees(a11.getInteger("rotation-degrees", 0)).setSampleRate(a11.getInteger("sample-rate", -1)).setSelectionFlags(getSelectionFlags(a11)).setEncoderDelay(a11.getInteger("encoder-delay", 0)).setEncoderPadding(a11.getInteger("encoder-padding", 0)).setPixelWidthHeightRatio(a11.getFloat("pixel-width-height-ratio-float", 1.0f)).setSubsampleOffsetUs(a11.getLong("subsample-offset-us-long", Long.MAX_VALUE)).setAccessibilityChannel(a12);
        while (true) {
            if (i11 >= this.muxedCaptionFormats.size()) {
                break;
            }
            Format format = this.muxedCaptionFormats.get(i11);
            if (Util.areEqual(format.sampleMimeType, string) && format.accessibilityChannel == a12) {
                accessibilityChannel.setLanguage(format.language).setRoleFlags(format.roleFlags).setSelectionFlags(format.selectionFlags).setLabel(format.label).setMetadata(format.metadata);
                break;
            }
            i11++;
        }
        return accessibilityChannel.build();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int toTrackTypeConstant(@androidx.annotation.Nullable java.lang.String r5) {
        /*
            r0 = -1
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r5.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -450004177: goto L_0x003c;
                case -284840886: goto L_0x0031;
                case 3556653: goto L_0x0026;
                case 93166550: goto L_0x001b;
                case 112202875: goto L_0x0010;
                default: goto L_0x000e;
            }
        L_0x000e:
            r1 = r0
            goto L_0x0046
        L_0x0010:
            java.lang.String r1 = "video"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0019
            goto L_0x000e
        L_0x0019:
            r1 = 4
            goto L_0x0046
        L_0x001b:
            java.lang.String r1 = "audio"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0024
            goto L_0x000e
        L_0x0024:
            r1 = r2
            goto L_0x0046
        L_0x0026:
            java.lang.String r1 = "text"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x002f
            goto L_0x000e
        L_0x002f:
            r1 = r3
            goto L_0x0046
        L_0x0031:
            java.lang.String r1 = "unknown"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x003a
            goto L_0x000e
        L_0x003a:
            r1 = r4
            goto L_0x0046
        L_0x003c:
            java.lang.String r1 = "metadata"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0045
            goto L_0x000e
        L_0x0045:
            r1 = 0
        L_0x0046:
            switch(r1) {
                case 0: goto L_0x0052;
                case 1: goto L_0x0051;
                case 2: goto L_0x0050;
                case 3: goto L_0x004f;
                case 4: goto L_0x004e;
                default: goto L_0x0049;
            }
        L_0x0049:
            int r5 = com.google.android.exoplayer2.util.MimeTypes.getTrackType(r5)
            return r5
        L_0x004e:
            return r3
        L_0x004f:
            return r4
        L_0x0050:
            return r2
        L_0x0051:
            return r0
        L_0x0052:
            r5 = 5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30.toTrackTypeConstant(java.lang.String):int");
    }

    public void disableSeeking() {
        this.seekingDisabled = true;
    }

    @Nullable
    public ChunkIndex getChunkIndex() {
        return this.lastChunkIndex;
    }

    @Nullable
    public MediaParser.SeekMap getDummySeekMap() {
        return this.dummySeekMap;
    }

    @Nullable
    public Format[] getSampleFormats() {
        if (!this.tracksFoundCalled) {
            return null;
        }
        Format[] formatArr = new Format[this.trackFormats.size()];
        for (int i11 = 0; i11 < this.trackFormats.size(); i11++) {
            formatArr[i11] = (Format) Assertions.checkNotNull(this.trackFormats.get(i11));
        }
        return formatArr;
    }

    public Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> getSeekPoints(long j11) {
        MediaParser.SeekMap seekMap = this.lastSeekMap;
        return seekMap != null ? seekMap.getSeekPoints(j11) : SEEK_POINT_PAIR_START;
    }

    public void onSampleCompleted(int i11, long j11, int i12, int i13, int i14, @Nullable MediaCodec.CryptoInfo cryptoInfo) {
        long j12 = this.sampleTimestampUpperLimitFilterUs;
        if (j12 == C.TIME_UNSET || j11 < j12) {
            TimestampAdjuster timestampAdjuster2 = this.timestampAdjuster;
            if (timestampAdjuster2 != null) {
                j11 = timestampAdjuster2.adjustSampleTimestamp(j11);
            }
            ((TrackOutput) Assertions.checkNotNull(this.trackOutputs.get(i11))).sampleMetadata(j11, i12, i13, i14, toExoPlayerCryptoData(i11, cryptoInfo));
        }
    }

    public void onSampleDataFound(int i11, MediaParser.InputReader inputReader) throws IOException {
        ensureSpaceForTrackIndex(i11);
        this.scratchDataReaderAdapter.input = inputReader;
        TrackOutput trackOutput = this.trackOutputs.get(i11);
        if (trackOutput == null) {
            trackOutput = this.extractorOutput.track(i11, -1);
            this.trackOutputs.set(i11, trackOutput);
        }
        trackOutput.sampleData((DataReader) this.scratchDataReaderAdapter, (int) inputReader.getLength(), true);
    }

    public void onSeekMapFound(MediaParser.SeekMap seekMap) {
        SeekMap seekMap2;
        if (!this.expectDummySeekMap || this.dummySeekMap != null) {
            this.lastSeekMap = seekMap;
            long a11 = seekMap.getDurationMicros();
            ExtractorOutput extractorOutput2 = this.extractorOutput;
            if (this.seekingDisabled) {
                if (a11 == -2147483648L) {
                    a11 = C.TIME_UNSET;
                }
                seekMap2 = new SeekMap.Unseekable(a11);
            } else {
                seekMap2 = new SeekMapAdapter(seekMap);
            }
            extractorOutput2.seekMap(seekMap2);
            return;
        }
        this.dummySeekMap = seekMap;
    }

    public void onTrackCountFound(int i11) {
        this.tracksFoundCalled = true;
        maybeEndTracks();
    }

    public void onTrackDataFound(int i11, MediaParser.TrackData trackData) {
        Format format;
        String str;
        if (!maybeObtainChunkIndex(trackData.mediaFormat)) {
            ensureSpaceForTrackIndex(i11);
            TrackOutput trackOutput = this.trackOutputs.get(i11);
            if (trackOutput == null) {
                String string = trackData.mediaFormat.getString(MEDIA_FORMAT_KEY_TRACK_TYPE);
                if (string != null) {
                    str = string;
                } else {
                    str = trackData.mediaFormat.getString("mime");
                }
                int trackTypeConstant = toTrackTypeConstant(str);
                if (trackTypeConstant == this.primaryTrackType) {
                    this.primaryTrackIndex = i11;
                }
                TrackOutput track = this.extractorOutput.track(i11, trackTypeConstant);
                this.trackOutputs.set(i11, track);
                if (string == null) {
                    trackOutput = track;
                } else {
                    return;
                }
            }
            Format exoPlayerFormat = toExoPlayerFormat(trackData);
            Format format2 = this.primaryTrackManifestFormat;
            if (format2 == null || i11 != this.primaryTrackIndex) {
                format = exoPlayerFormat;
            } else {
                format = exoPlayerFormat.withManifestFormatInfo(format2);
            }
            trackOutput.format(format);
            this.trackFormats.set(i11, exoPlayerFormat);
            maybeEndTracks();
        }
    }

    public void setExtractorOutput(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
    }

    public void setMuxedCaptionFormats(List<Format> list) {
        this.muxedCaptionFormats = list;
    }

    public void setSampleTimestampUpperLimitFilterUs(long j11) {
        this.sampleTimestampUpperLimitFilterUs = j11;
    }

    public void setSelectedParserName(String str) {
        this.containerMimeType = getMimeType(str);
    }

    public void setTimestampAdjuster(TimestampAdjuster timestampAdjuster2) {
        this.timestampAdjuster = timestampAdjuster2;
    }

    public OutputConsumerAdapterV30(@Nullable Format format, int i11, boolean z11) {
        this.expectDummySeekMap = z11;
        this.primaryTrackManifestFormat = format;
        this.primaryTrackType = i11;
        this.trackOutputs = new ArrayList<>();
        this.trackFormats = new ArrayList<>();
        this.lastReceivedCryptoInfos = new ArrayList<>();
        this.lastOutputCryptoDatas = new ArrayList<>();
        this.scratchDataReaderAdapter = new DataReaderAdapter();
        this.extractorOutput = new DummyExtractorOutput();
        this.sampleTimestampUpperLimitFilterUs = C.TIME_UNSET;
        this.muxedCaptionFormats = ImmutableList.of();
    }
}
