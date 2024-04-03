package com.google.android.exoplayer2.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrueHdSampleRechunker;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.lang3.CharUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p7.a;

public class MatroskaExtractor implements Extractor {
    private static final int BLOCK_ADDITIONAL_ID_VP9_ITU_T_35 = 4;
    private static final int BLOCK_ADD_ID_TYPE_DVCC = 1685480259;
    private static final int BLOCK_ADD_ID_TYPE_DVVC = 1685485123;
    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_ACM = "A_MS/ACM";
    private static final String CODEC_ID_ASS = "S_TEXT/ASS";
    private static final String CODEC_ID_AV1 = "V_AV1";
    private static final String CODEC_ID_DTS = "A_DTS";
    private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final String CODEC_ID_DVBSUB = "S_DVBSUB";
    private static final String CODEC_ID_E_AC3 = "A_EAC3";
    private static final String CODEC_ID_FLAC = "A_FLAC";
    private static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP2 = "A_MPEG/L2";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG2 = "V_MPEG2";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_PCM_FLOAT = "A_PCM/FLOAT/IEEE";
    private static final String CODEC_ID_PCM_INT_BIG = "A_PCM/INT/BIG";
    private static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    private static final String CODEC_ID_PGS = "S_HDMV/PGS";
    private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final String CODEC_ID_THEORA = "V_THEORA";
    private static final String CODEC_ID_TRUEHD = "A_TRUEHD";
    private static final String CODEC_ID_VOBSUB = "S_VOBSUB";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final String CODEC_ID_VTT = "S_TEXT/WEBVTT";
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    public static final ExtractorsFactory FACTORY = new a();
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    private static final int FOURCC_COMPRESSION_DIVX = 1482049860;
    private static final int FOURCC_COMPRESSION_H263 = 859189832;
    private static final int FOURCC_COMPRESSION_VC1 = 826496599;
    private static final int ID_AUDIO = 225;
    private static final int ID_AUDIO_BIT_DEPTH = 25188;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_ADDITIONAL = 165;
    private static final int ID_BLOCK_ADDITIONS = 30113;
    private static final int ID_BLOCK_ADDITION_MAPPING = 16868;
    private static final int ID_BLOCK_ADD_ID = 238;
    private static final int ID_BLOCK_ADD_ID_EXTRA_DATA = 16877;
    private static final int ID_BLOCK_ADD_ID_TYPE = 16871;
    private static final int ID_BLOCK_DURATION = 155;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_BLOCK_MORE = 166;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 524531317;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_COLOUR = 21936;
    private static final int ID_COLOUR_PRIMARIES = 21947;
    private static final int ID_COLOUR_RANGE = 21945;
    private static final int ID_COLOUR_TRANSFER = 21946;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 475249515;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 2352003;
    private static final int ID_DISCARD_PADDING = 30114;
    private static final int ID_DISPLAY_HEIGHT = 21690;
    private static final int ID_DISPLAY_UNIT = 21682;
    private static final int ID_DISPLAY_WIDTH = 21680;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 440786851;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_FLAG_DEFAULT = 136;
    private static final int ID_FLAG_FORCED = 21930;
    private static final int ID_INFO = 357149030;
    private static final int ID_LANGUAGE = 2274716;
    private static final int ID_LUMNINANCE_MAX = 21977;
    private static final int ID_LUMNINANCE_MIN = 21978;
    private static final int ID_MASTERING_METADATA = 21968;
    private static final int ID_MAX_BLOCK_ADDITION_ID = 21998;
    private static final int ID_MAX_CLL = 21948;
    private static final int ID_MAX_FALL = 21949;
    private static final int ID_NAME = 21358;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
    private static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
    private static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
    private static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
    private static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
    private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    private static final int ID_PROJECTION = 30320;
    private static final int ID_PROJECTION_POSE_PITCH = 30324;
    private static final int ID_PROJECTION_POSE_ROLL = 30325;
    private static final int ID_PROJECTION_POSE_YAW = 30323;
    private static final int ID_PROJECTION_PRIVATE = 30322;
    private static final int ID_PROJECTION_TYPE = 30321;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 290298740;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 408125543;
    private static final int ID_SEGMENT_INFO = 357149030;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_STEREO_MODE = 21432;
    private static final int ID_TIMECODE_SCALE = 2807729;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 374648427;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
    private static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    /* access modifiers changed from: private */
    public static final byte[] SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] SSA_PREFIX = {68, 105, 97, 108, 111, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 117, 101, 58, 32, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 44, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 44};
    private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    private static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000;
    private static final byte[] SUBRIP_PREFIX = {TarConstants.LF_LINK, 10, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 44, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 32, 45, 45, 62, 32, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 44, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 10};
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final String TAG = "MatroskaExtractor";
    /* access modifiers changed from: private */
    public static final Map<String, Integer> TRACK_NAME_TO_ROTATION_DEGREES;
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int UNSET_ENTRY_ID = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private static final byte[] VTT_PREFIX = {87, 69, 66, 86, 84, 84, 10, 10, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 46, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 32, 45, 45, 62, 32, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 46, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 10};
    private static final int VTT_PREFIX_END_TIMECODE_OFFSET = 25;
    private static final String VTT_TIMECODE_FORMAT = "%02d:%02d:%02d.%03d";
    private static final long VTT_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final int WAVE_FORMAT_EXTENSIBLE = 65534;
    private static final int WAVE_FORMAT_PCM = 1;
    private static final int WAVE_FORMAT_SIZE = 18;
    /* access modifiers changed from: private */
    public static final UUID WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);
    private int blockAdditionalId;
    private long blockDurationUs;
    private int blockFlags;
    private long blockGroupDiscardPaddingNs;
    private boolean blockHasReferenceBlock;
    private int blockSampleCount;
    private int blockSampleIndex;
    private int[] blockSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    @Nullable
    private LongArray cueClusterPositions;
    @Nullable
    private LongArray cueTimesUs;
    private long cuesContentPosition;
    @Nullable
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private boolean haveOutputSample;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final ParsableByteArray subtitleSample;
    private final ParsableByteArray supplementalData;
    private long timecodeScale;
    private final SparseArray<Track> tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public final class InnerEbmlProcessor implements EbmlProcessor {
        private InnerEbmlProcessor() {
        }

        public void binaryElement(int i11, int i12, ExtractorInput extractorInput) throws IOException {
            MatroskaExtractor.this.binaryElement(i11, i12, extractorInput);
        }

        public void endMasterElement(int i11) throws ParserException {
            MatroskaExtractor.this.endMasterElement(i11);
        }

        public void floatElement(int i11, double d11) throws ParserException {
            MatroskaExtractor.this.floatElement(i11, d11);
        }

        public int getElementType(int i11) {
            return MatroskaExtractor.this.getElementType(i11);
        }

        public void integerElement(int i11, long j11) throws ParserException {
            MatroskaExtractor.this.integerElement(i11, j11);
        }

        public boolean isLevel1Element(int i11) {
            return MatroskaExtractor.this.isLevel1Element(i11);
        }

        public void startMasterElement(int i11, long j11, long j12) throws ParserException {
            MatroskaExtractor.this.startMasterElement(i11, j11, j12);
        }

        public void stringElement(int i11, String str) throws ParserException {
            MatroskaExtractor.this.stringElement(i11, str);
        }
    }

    public static final class Track {
        private static final int DEFAULT_MAX_CLL = 1000;
        private static final int DEFAULT_MAX_FALL = 200;
        private static final int DISPLAY_UNIT_PIXELS = 0;
        private static final int MAX_CHROMATICITY = 50000;
        public int audioBitDepth = -1;
        /* access modifiers changed from: private */
        public int blockAddIdType;
        public int channelCount = 1;
        public long codecDelayNs = 0;
        public String codecId;
        public byte[] codecPrivate;
        public int colorRange = -1;
        public int colorSpace = -1;
        public int colorTransfer = -1;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public int displayHeight = -1;
        public int displayUnit = 0;
        public int displayWidth = -1;
        public byte[] dolbyVisionConfigBytes;
        public DrmInitData drmInitData;
        public boolean flagDefault = true;
        public boolean flagForced;
        public boolean hasColorInfo = false;
        public boolean hasContentEncryption;
        public int height = -1;
        /* access modifiers changed from: private */
        public String language = "eng";
        public int maxBlockAdditionId;
        public int maxContentLuminance = 1000;
        public int maxFrameAverageLuminance = 200;
        public float maxMasteringLuminance = -1.0f;
        public float minMasteringLuminance = -1.0f;
        public int nalUnitLengthFieldLength;

        /* renamed from: name  reason: collision with root package name */
        public String f34933name;
        public int number;
        public TrackOutput output;
        public float primaryBChromaticityX = -1.0f;
        public float primaryBChromaticityY = -1.0f;
        public float primaryGChromaticityX = -1.0f;
        public float primaryGChromaticityY = -1.0f;
        public float primaryRChromaticityX = -1.0f;
        public float primaryRChromaticityY = -1.0f;
        public byte[] projectionData = null;
        public float projectionPosePitch = 0.0f;
        public float projectionPoseRoll = 0.0f;
        public float projectionPoseYaw = 0.0f;
        public int projectionType = -1;
        public int sampleRate = 8000;
        public byte[] sampleStrippedBytes;
        public long seekPreRollNs = 0;
        public int stereoMode = -1;
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public float whitePointChromaticityX = -1.0f;
        public float whitePointChromaticityY = -1.0f;
        public int width = -1;

        /* access modifiers changed from: private */
        @EnsuresNonNull({"output"})
        public void assertOutputInitialized() {
            Assertions.checkNotNull(this.output);
        }

        @EnsuresNonNull({"codecPrivate"})
        private byte[] getCodecPrivate(String str) throws ParserException {
            byte[] bArr = this.codecPrivate;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.createForMalformedContainer("Missing CodecPrivate for codec " + str, (Throwable) null);
        }

        @Nullable
        private byte[] getHdrStaticInfo() {
            if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((int) ((this.primaryRChromaticityX * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryRChromaticityY * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryGChromaticityX * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryGChromaticityY * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryBChromaticityX * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryBChromaticityY * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.whitePointChromaticityX * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.whitePointChromaticityY * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) (this.maxMasteringLuminance + 0.5f)));
            order.putShort((short) ((int) (this.minMasteringLuminance + 0.5f)));
            order.putShort((short) this.maxContentLuminance);
            order.putShort((short) this.maxFrameAverageLuminance);
            return bArr;
        }

        private static Pair<String, List<byte[]>> parseFourCcPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.skipBytes(16);
                long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
                if (readLittleEndianUnsignedInt == 1482049860) {
                    return new Pair<>(MimeTypes.VIDEO_DIVX, (Object) null);
                }
                if (readLittleEndianUnsignedInt == 859189832) {
                    return new Pair<>(MimeTypes.VIDEO_H263, (Object) null);
                }
                if (readLittleEndianUnsignedInt == 826496599) {
                    byte[] data = parsableByteArray.getData();
                    for (int position = parsableByteArray.getPosition() + 20; position < data.length - 4; position++) {
                        if (data[position] == 0 && data[position + 1] == 0 && data[position + 2] == 1 && data[position + 3] == 15) {
                            return new Pair<>(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(data, position, data.length)));
                        }
                    }
                    throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", (Throwable) null);
                }
                Log.w(MatroskaExtractor.TAG, "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>(MimeTypes.VIDEO_UNKNOWN, (Object) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing FourCC private data", (Throwable) null);
            }
        }

        private static boolean parseMsAcmCodecPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                if (readLittleEndianUnsignedShort == 1) {
                    return true;
                }
                if (readLittleEndianUnsignedShort != 65534) {
                    return false;
                }
                parsableByteArray.setPosition(24);
                if (parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits() && parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits()) {
                    return true;
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing MS/ACM codec private", (Throwable) null);
            }
        }

        private static List<byte[]> parseVorbisCodecPrivate(byte[] bArr) throws ParserException {
            byte b11;
            byte b12;
            try {
                if (bArr[0] == 2) {
                    int i11 = 0;
                    int i12 = 1;
                    while (true) {
                        b11 = bArr[i12];
                        if ((b11 & 255) != 255) {
                            break;
                        }
                        i11 += 255;
                        i12++;
                    }
                    int i13 = i12 + 1;
                    int i14 = i11 + (b11 & 255);
                    int i15 = 0;
                    while (true) {
                        b12 = bArr[i13];
                        if ((b12 & 255) != 255) {
                            break;
                        }
                        i15 += 255;
                        i13++;
                    }
                    int i16 = i13 + 1;
                    int i17 = i15 + (b12 & 255);
                    if (bArr[i16] == 1) {
                        byte[] bArr2 = new byte[i14];
                        System.arraycopy(bArr, i16, bArr2, 0, i14);
                        int i18 = i16 + i14;
                        if (bArr[i18] == 3) {
                            int i19 = i18 + i17;
                            if (bArr[i19] == 5) {
                                byte[] bArr3 = new byte[(bArr.length - i19)];
                                System.arraycopy(bArr, i19, bArr3, 0, bArr.length - i19);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", (Throwable) null);
                        }
                        throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", (Throwable) null);
                    }
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", (Throwable) null);
                }
                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", (Throwable) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", (Throwable) null);
            }
        }

        /* access modifiers changed from: private */
        public boolean samplesHaveSupplementalData(boolean z11) {
            if (MatroskaExtractor.CODEC_ID_OPUS.equals(this.codecId)) {
                return z11;
            }
            if (this.maxBlockAdditionId > 0) {
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v15, resolved type: java.lang.String} */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x029d, code lost:
            r4 = r1;
            r1 = null;
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x0300, code lost:
            r1 = null;
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x0302, code lost:
            r4 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x0303, code lost:
            r6 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x0356, code lost:
            r4 = -1;
            r6 = -1;
            r18 = r3;
            r3 = r1;
            r1 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x038c, code lost:
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x0394, code lost:
            r1 = null;
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x03a5, code lost:
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x03a6, code lost:
            r6 = r16;
            r4 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x03ff, code lost:
            r1 = null;
            r3 = null;
            r17 = com.google.android.exoplayer2.util.MimeTypes.AUDIO_UNKNOWN;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x0415, code lost:
            if (r0.dolbyVisionConfigBytes == null) goto L_0x0428;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x0417, code lost:
            r7 = com.google.android.exoplayer2.video.DolbyVisionConfig.parse(new com.google.android.exoplayer2.util.ParsableByteArray(r0.dolbyVisionConfigBytes));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x0422, code lost:
            if (r7 == null) goto L_0x0428;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x0424, code lost:
            r3 = r7.codecs;
            r17 = com.google.android.exoplayer2.util.MimeTypes.VIDEO_DOLBY_VISION;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x0428, code lost:
            r7 = r17;
            r10 = r0.flagDefault | 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x0430, code lost:
            if (r0.flagForced == false) goto L_0x0434;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x0432, code lost:
            r9 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x0434, code lost:
            r9 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x0435, code lost:
            r9 = r9 | r10;
            r10 = new com.google.android.exoplayer2.Format.Builder();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x043f, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.isAudio(r7) == false) goto L_0x0453;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x0441, code lost:
            r10.setChannelCount(r0.channelCount).setSampleRate(r0.sampleRate).setPcmEncoding(r4);
            r5 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x0457, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.isVideo(r7) == false) goto L_0x052c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x045b, code lost:
            if (r0.displayUnit != 0) goto L_0x046f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x045d, code lost:
            r2 = r0.displayWidth;
            r4 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x0460, code lost:
            if (r2 != -1) goto L_0x0464;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x0462, code lost:
            r2 = r0.width;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x0464, code lost:
            r0.displayWidth = r2;
            r2 = r0.displayHeight;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x0468, code lost:
            if (r2 != -1) goto L_0x046c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x046a, code lost:
            r2 = r0.height;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x046c, code lost:
            r0.displayHeight = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x046f, code lost:
            r4 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x0470, code lost:
            r2 = r0.displayWidth;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x0472, code lost:
            if (r2 == r4) goto L_0x0482;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x0474, code lost:
            r5 = r0.displayHeight;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x0476, code lost:
            if (r5 == r4) goto L_0x0482;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x0478, code lost:
            r2 = ((float) (r0.height * r2)) / ((float) (r0.width * r5));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x0482, code lost:
            r2 = -1.0f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x0486, code lost:
            if (r0.hasColorInfo == false) goto L_0x0497;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0488, code lost:
            r8 = new com.google.android.exoplayer2.video.ColorInfo(r0.colorSpace, r0.colorRange, r0.colorTransfer, getHdrStaticInfo());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x0499, code lost:
            if (r0.f34933name == null) goto L_0x04b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x04a5, code lost:
            if (com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.access$600().containsKey(r0.f34933name) == false) goto L_0x04b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x04a7, code lost:
            r4 = ((java.lang.Integer) com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.access$600().get(r0.f34933name)).intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x04b9, code lost:
            if (r0.projectionType != 0) goto L_0x0507;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:206:0x04c2, code lost:
            if (java.lang.Float.compare(r0.projectionPoseYaw, 0.0f) != 0) goto L_0x0507;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:208:0x04ca, code lost:
            if (java.lang.Float.compare(r0.projectionPosePitch, 0.0f) != 0) goto L_0x0507;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x04d2, code lost:
            if (java.lang.Float.compare(r0.projectionPoseRoll, 0.0f) != 0) goto L_0x04d6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x04d4, code lost:
            r4 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:213:0x04de, code lost:
            if (java.lang.Float.compare(r0.projectionPosePitch, 90.0f) != 0) goto L_0x04e3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x04e0, code lost:
            r4 = 90;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:216:0x04eb, code lost:
            if (java.lang.Float.compare(r0.projectionPosePitch, -180.0f) == 0) goto L_0x0505;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:218:0x04f5, code lost:
            if (java.lang.Float.compare(r0.projectionPosePitch, 180.0f) != 0) goto L_0x04f8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:220:0x0500, code lost:
            if (java.lang.Float.compare(r0.projectionPosePitch, -90.0f) != 0) goto L_0x0507;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:221:0x0502, code lost:
            r4 = 270;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:222:0x0505, code lost:
            r4 = 180;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:223:0x0507, code lost:
            r10.setWidth(r0.width).setHeight(r0.height).setPixelWidthHeightRatio(r2).setRotationDegrees(r4).setProjectionData(r0.projectionData).setStereoMode(r0.stereoMode).setColorInfo(r8);
            r5 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:225:0x0530, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_SUBRIP.equals(r7) != false) goto L_0x0558;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:227:0x0536, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.TEXT_SSA.equals(r7) != false) goto L_0x0558;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:229:0x053c, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.TEXT_VTT.equals(r7) != false) goto L_0x0558;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:231:0x0542, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_VOBSUB.equals(r7) != false) goto L_0x0558;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:233:0x0548, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_PGS.equals(r7) != false) goto L_0x0558;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:235:0x054e, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_DVBSUBS.equals(r7) == false) goto L_0x0551;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:237:0x0557, code lost:
            throw com.google.android.exoplayer2.ParserException.createForMalformedContainer("Unexpected MIME type.", (java.lang.Throwable) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:238:0x0558, code lost:
            r5 = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:240:0x055b, code lost:
            if (r0.f34933name == null) goto L_0x056e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:242:0x0567, code lost:
            if (com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.access$600().containsKey(r0.f34933name) != false) goto L_0x056e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:243:0x0569, code lost:
            r10.setLabel(r0.f34933name);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:244:0x056e, code lost:
            r1 = r10.setId(r21).setSampleMimeType(r7).setMaxInputSize(r6).setLanguage(r0.language).setSelectionFlags(r9).setInitializationData(r1).setCodecs(r3).setDrmInitData(r0.drmInitData).build();
            r2 = r20.track(r0.number, r5);
            r0.output = r2;
            r2.format(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:245:0x05a5, code lost:
            return;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
        @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void initializeOutput(com.google.android.exoplayer2.extractor.ExtractorOutput r20, int r21) throws com.google.android.exoplayer2.ParserException {
            /*
                r19 = this;
                r0 = r19
                java.lang.String r1 = r0.codecId
                r1.hashCode()
                int r2 = r1.hashCode()
                r3 = 32
                r4 = 16
                r7 = 8
                r9 = 3
                switch(r2) {
                    case -2095576542: goto L_0x01bd;
                    case -2095575984: goto L_0x01b1;
                    case -1985379776: goto L_0x01a5;
                    case -1784763192: goto L_0x0199;
                    case -1730367663: goto L_0x018d;
                    case -1482641358: goto L_0x0181;
                    case -1482641357: goto L_0x0175;
                    case -1373388978: goto L_0x0169;
                    case -933872740: goto L_0x015c;
                    case -538363189: goto L_0x014e;
                    case -538363109: goto L_0x0140;
                    case -425012669: goto L_0x0132;
                    case -356037306: goto L_0x0124;
                    case 62923557: goto L_0x0116;
                    case 62923603: goto L_0x0108;
                    case 62927045: goto L_0x00fa;
                    case 82318131: goto L_0x00ed;
                    case 82338133: goto L_0x00df;
                    case 82338134: goto L_0x00d1;
                    case 99146302: goto L_0x00c3;
                    case 444813526: goto L_0x00b5;
                    case 542569478: goto L_0x00a7;
                    case 635596514: goto L_0x0099;
                    case 725948237: goto L_0x008c;
                    case 725957860: goto L_0x007f;
                    case 738597099: goto L_0x0072;
                    case 855502857: goto L_0x0065;
                    case 1045209816: goto L_0x0058;
                    case 1422270023: goto L_0x004b;
                    case 1809237540: goto L_0x003e;
                    case 1950749482: goto L_0x0031;
                    case 1950789798: goto L_0x0024;
                    case 1951062397: goto L_0x0018;
                    default: goto L_0x0015;
                }
            L_0x0015:
                r1 = -1
                goto L_0x01c8
            L_0x0018:
                java.lang.String r2 = "A_OPUS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0021
                goto L_0x0015
            L_0x0021:
                r1 = r3
                goto L_0x01c8
            L_0x0024:
                java.lang.String r2 = "A_FLAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x002d
                goto L_0x0015
            L_0x002d:
                r1 = 31
                goto L_0x01c8
            L_0x0031:
                java.lang.String r2 = "A_EAC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x003a
                goto L_0x0015
            L_0x003a:
                r1 = 30
                goto L_0x01c8
            L_0x003e:
                java.lang.String r2 = "V_MPEG2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0047
                goto L_0x0015
            L_0x0047:
                r1 = 29
                goto L_0x01c8
            L_0x004b:
                java.lang.String r2 = "S_TEXT/UTF8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0054
                goto L_0x0015
            L_0x0054:
                r1 = 28
                goto L_0x01c8
            L_0x0058:
                java.lang.String r2 = "S_TEXT/WEBVTT"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0061
                goto L_0x0015
            L_0x0061:
                r1 = 27
                goto L_0x01c8
            L_0x0065:
                java.lang.String r2 = "V_MPEGH/ISO/HEVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x006e
                goto L_0x0015
            L_0x006e:
                r1 = 26
                goto L_0x01c8
            L_0x0072:
                java.lang.String r2 = "S_TEXT/ASS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x007b
                goto L_0x0015
            L_0x007b:
                r1 = 25
                goto L_0x01c8
            L_0x007f:
                java.lang.String r2 = "A_PCM/INT/LIT"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0088
                goto L_0x0015
            L_0x0088:
                r1 = 24
                goto L_0x01c8
            L_0x008c:
                java.lang.String r2 = "A_PCM/INT/BIG"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0095
                goto L_0x0015
            L_0x0095:
                r1 = 23
                goto L_0x01c8
            L_0x0099:
                java.lang.String r2 = "A_PCM/FLOAT/IEEE"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00a3
                goto L_0x0015
            L_0x00a3:
                r1 = 22
                goto L_0x01c8
            L_0x00a7:
                java.lang.String r2 = "A_DTS/EXPRESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00b1
                goto L_0x0015
            L_0x00b1:
                r1 = 21
                goto L_0x01c8
            L_0x00b5:
                java.lang.String r2 = "V_THEORA"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00bf
                goto L_0x0015
            L_0x00bf:
                r1 = 20
                goto L_0x01c8
            L_0x00c3:
                java.lang.String r2 = "S_HDMV/PGS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00cd
                goto L_0x0015
            L_0x00cd:
                r1 = 19
                goto L_0x01c8
            L_0x00d1:
                java.lang.String r2 = "V_VP9"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00db
                goto L_0x0015
            L_0x00db:
                r1 = 18
                goto L_0x01c8
            L_0x00df:
                java.lang.String r2 = "V_VP8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00e9
                goto L_0x0015
            L_0x00e9:
                r1 = 17
                goto L_0x01c8
            L_0x00ed:
                java.lang.String r2 = "V_AV1"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00f7
                goto L_0x0015
            L_0x00f7:
                r1 = r4
                goto L_0x01c8
            L_0x00fa:
                java.lang.String r2 = "A_DTS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0104
                goto L_0x0015
            L_0x0104:
                r1 = 15
                goto L_0x01c8
            L_0x0108:
                java.lang.String r2 = "A_AC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0112
                goto L_0x0015
            L_0x0112:
                r1 = 14
                goto L_0x01c8
            L_0x0116:
                java.lang.String r2 = "A_AAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0120
                goto L_0x0015
            L_0x0120:
                r1 = 13
                goto L_0x01c8
            L_0x0124:
                java.lang.String r2 = "A_DTS/LOSSLESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x012e
                goto L_0x0015
            L_0x012e:
                r1 = 12
                goto L_0x01c8
            L_0x0132:
                java.lang.String r2 = "S_VOBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x013c
                goto L_0x0015
            L_0x013c:
                r1 = 11
                goto L_0x01c8
            L_0x0140:
                java.lang.String r2 = "V_MPEG4/ISO/AVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x014a
                goto L_0x0015
            L_0x014a:
                r1 = 10
                goto L_0x01c8
            L_0x014e:
                java.lang.String r2 = "V_MPEG4/ISO/ASP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0158
                goto L_0x0015
            L_0x0158:
                r1 = 9
                goto L_0x01c8
            L_0x015c:
                java.lang.String r2 = "S_DVBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0166
                goto L_0x0015
            L_0x0166:
                r1 = r7
                goto L_0x01c8
            L_0x0169:
                java.lang.String r2 = "V_MS/VFW/FOURCC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0173
                goto L_0x0015
            L_0x0173:
                r1 = 7
                goto L_0x01c8
            L_0x0175:
                java.lang.String r2 = "A_MPEG/L3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x017f
                goto L_0x0015
            L_0x017f:
                r1 = 6
                goto L_0x01c8
            L_0x0181:
                java.lang.String r2 = "A_MPEG/L2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x018b
                goto L_0x0015
            L_0x018b:
                r1 = 5
                goto L_0x01c8
            L_0x018d:
                java.lang.String r2 = "A_VORBIS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0197
                goto L_0x0015
            L_0x0197:
                r1 = 4
                goto L_0x01c8
            L_0x0199:
                java.lang.String r2 = "A_TRUEHD"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01a3
                goto L_0x0015
            L_0x01a3:
                r1 = r9
                goto L_0x01c8
            L_0x01a5:
                java.lang.String r2 = "A_MS/ACM"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01af
                goto L_0x0015
            L_0x01af:
                r1 = 2
                goto L_0x01c8
            L_0x01b1:
                java.lang.String r2 = "V_MPEG4/ISO/SP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01bb
                goto L_0x0015
            L_0x01bb:
                r1 = 1
                goto L_0x01c8
            L_0x01bd:
                java.lang.String r2 = "V_MPEG4/ISO/AP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01c7
                goto L_0x0015
            L_0x01c7:
                r1 = 0
            L_0x01c8:
                java.lang.String r2 = "application/dvbsubs"
                java.lang.String r12 = "application/pgs"
                java.lang.String r13 = "application/vobsub"
                java.lang.String r14 = "text/vtt"
                java.lang.String r15 = "text/x-ssa"
                java.lang.String r5 = "application/x-subrip"
                r16 = 4096(0x1000, float:5.74E-42)
                java.lang.String r6 = ". Setting mimeType to "
                java.lang.String r17 = "audio/raw"
                java.lang.String r11 = "MatroskaExtractor"
                java.lang.String r10 = "audio/x-unknown"
                r8 = 0
                switch(r1) {
                    case 0: goto L_0x0405;
                    case 1: goto L_0x0405;
                    case 2: goto L_0x03b5;
                    case 3: goto L_0x03aa;
                    case 4: goto L_0x0397;
                    case 5: goto L_0x0392;
                    case 6: goto L_0x038f;
                    case 7: goto L_0x0373;
                    case 8: goto L_0x035f;
                    case 9: goto L_0x0405;
                    case 10: goto L_0x033d;
                    case 11: goto L_0x032f;
                    case 12: goto L_0x032c;
                    case 13: goto L_0x030f;
                    case 14: goto L_0x030c;
                    case 15: goto L_0x0309;
                    case 16: goto L_0x0306;
                    case 17: goto L_0x02fe;
                    case 18: goto L_0x02fb;
                    case 19: goto L_0x02f6;
                    case 20: goto L_0x02f3;
                    case 21: goto L_0x0309;
                    case 22: goto L_0x02cd;
                    case 23: goto L_0x02a2;
                    case 24: goto L_0x0277;
                    case 25: goto L_0x0264;
                    case 26: goto L_0x0249;
                    case 27: goto L_0x0243;
                    case 28: goto L_0x023f;
                    case 29: goto L_0x023b;
                    case 30: goto L_0x0237;
                    case 31: goto L_0x0229;
                    case 32: goto L_0x01e9;
                    default: goto L_0x01e2;
                }
            L_0x01e2:
                java.lang.String r1 = "Unrecognized codec identifier."
                com.google.android.exoplayer2.ParserException r1 = com.google.android.exoplayer2.ParserException.createForMalformedContainer(r1, r8)
                throw r1
            L_0x01e9:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r9)
                java.lang.String r3 = r0.codecId
                byte[] r3 = r0.getCodecPrivate(r3)
                r1.add(r3)
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r7)
                java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN
                java.nio.ByteBuffer r3 = r3.order(r4)
                long r10 = r0.codecDelayNs
                java.nio.ByteBuffer r3 = r3.putLong(r10)
                byte[] r3 = r3.array()
                r1.add(r3)
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r7)
                java.nio.ByteBuffer r3 = r3.order(r4)
                long r6 = r0.seekPreRollNs
                java.nio.ByteBuffer r3 = r3.putLong(r6)
                byte[] r3 = r3.array()
                r1.add(r3)
                java.lang.String r17 = "audio/opus"
                r16 = 5760(0x1680, float:8.071E-42)
                goto L_0x03a5
            L_0x0229:
                java.lang.String r1 = r0.codecId
                byte[] r1 = r0.getCodecPrivate(r1)
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r17 = "audio/flac"
                goto L_0x038c
            L_0x0237:
                java.lang.String r17 = "audio/eac3"
                goto L_0x0300
            L_0x023b:
                java.lang.String r17 = "video/mpeg2"
                goto L_0x0300
            L_0x023f:
                r17 = r5
                goto L_0x0300
            L_0x0243:
                r1 = r8
                r3 = r1
                r17 = r14
                goto L_0x0302
            L_0x0249:
                com.google.android.exoplayer2.util.ParsableByteArray r1 = new com.google.android.exoplayer2.util.ParsableByteArray
                java.lang.String r3 = r0.codecId
                byte[] r3 = r0.getCodecPrivate(r3)
                r1.<init>((byte[]) r3)
                com.google.android.exoplayer2.video.HevcConfig r1 = com.google.android.exoplayer2.video.HevcConfig.parse(r1)
                java.util.List<byte[]> r3 = r1.initializationData
                int r4 = r1.nalUnitLengthFieldLength
                r0.nalUnitLengthFieldLength = r4
                java.lang.String r1 = r1.codecs
                java.lang.String r17 = "video/hevc"
                goto L_0x0356
            L_0x0264:
                byte[] r1 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.SSA_DIALOGUE_FORMAT
                java.lang.String r3 = r0.codecId
                byte[] r3 = r0.getCodecPrivate(r3)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.of(r1, r3)
                r3 = r8
                r17 = r15
                goto L_0x0302
            L_0x0277:
                int r1 = r0.audioBitDepth
                int r1 = com.google.android.exoplayer2.util.Util.getPcmEncoding(r1)
                if (r1 != 0) goto L_0x029d
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported little endian PCM bit depth: "
                r1.append(r3)
                int r3 = r0.audioBitDepth
                r1.append(r3)
                r1.append(r6)
                r1.append(r10)
                java.lang.String r1 = r1.toString()
                com.google.android.exoplayer2.util.Log.w(r11, r1)
                goto L_0x03ff
            L_0x029d:
                r4 = r1
                r1 = r8
                r3 = r1
                goto L_0x0303
            L_0x02a2:
                int r1 = r0.audioBitDepth
                if (r1 != r7) goto L_0x02aa
                r1 = r8
                r3 = r1
                r4 = r9
                goto L_0x0303
            L_0x02aa:
                if (r1 != r4) goto L_0x02af
                r1 = 268435456(0x10000000, float:2.5243549E-29)
                goto L_0x029d
            L_0x02af:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported big endian PCM bit depth: "
                r1.append(r3)
                int r3 = r0.audioBitDepth
                r1.append(r3)
                r1.append(r6)
                r1.append(r10)
                java.lang.String r1 = r1.toString()
                com.google.android.exoplayer2.util.Log.w(r11, r1)
                goto L_0x03ff
            L_0x02cd:
                int r1 = r0.audioBitDepth
                if (r1 != r3) goto L_0x02d5
                r1 = r8
                r3 = r1
                r4 = 4
                goto L_0x0303
            L_0x02d5:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported floating point PCM bit depth: "
                r1.append(r3)
                int r3 = r0.audioBitDepth
                r1.append(r3)
                r1.append(r6)
                r1.append(r10)
                java.lang.String r1 = r1.toString()
                com.google.android.exoplayer2.util.Log.w(r11, r1)
                goto L_0x03ff
            L_0x02f3:
                java.lang.String r17 = "video/x-unknown"
                goto L_0x0300
            L_0x02f6:
                r1 = r8
                r3 = r1
                r17 = r12
                goto L_0x0302
            L_0x02fb:
                java.lang.String r17 = "video/x-vnd.on2.vp9"
                goto L_0x0300
            L_0x02fe:
                java.lang.String r17 = "video/x-vnd.on2.vp8"
            L_0x0300:
                r1 = r8
                r3 = r1
            L_0x0302:
                r4 = -1
            L_0x0303:
                r6 = -1
                goto L_0x0413
            L_0x0306:
                java.lang.String r17 = "video/av01"
                goto L_0x0300
            L_0x0309:
                java.lang.String r17 = "audio/vnd.dts"
                goto L_0x0300
            L_0x030c:
                java.lang.String r17 = "audio/ac3"
                goto L_0x0300
            L_0x030f:
                java.lang.String r1 = r0.codecId
                byte[] r1 = r0.getCodecPrivate(r1)
                java.util.List r1 = java.util.Collections.singletonList(r1)
                byte[] r3 = r0.codecPrivate
                com.google.android.exoplayer2.audio.AacUtil$Config r3 = com.google.android.exoplayer2.audio.AacUtil.parseAudioSpecificConfig(r3)
                int r4 = r3.sampleRateHz
                r0.sampleRate = r4
                int r4 = r3.channelCount
                r0.channelCount = r4
                java.lang.String r3 = r3.codecs
                java.lang.String r17 = "audio/mp4a-latm"
                goto L_0x0302
            L_0x032c:
                java.lang.String r17 = "audio/vnd.dts.hd"
                goto L_0x0300
            L_0x032f:
                java.lang.String r1 = r0.codecId
                byte[] r1 = r0.getCodecPrivate(r1)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.of(r1)
                r3 = r8
                r17 = r13
                goto L_0x0302
            L_0x033d:
                com.google.android.exoplayer2.util.ParsableByteArray r1 = new com.google.android.exoplayer2.util.ParsableByteArray
                java.lang.String r3 = r0.codecId
                byte[] r3 = r0.getCodecPrivate(r3)
                r1.<init>((byte[]) r3)
                com.google.android.exoplayer2.video.AvcConfig r1 = com.google.android.exoplayer2.video.AvcConfig.parse(r1)
                java.util.List<byte[]> r3 = r1.initializationData
                int r4 = r1.nalUnitLengthFieldLength
                r0.nalUnitLengthFieldLength = r4
                java.lang.String r1 = r1.codecs
                java.lang.String r17 = "video/avc"
            L_0x0356:
                r4 = -1
                r6 = -1
                r18 = r3
                r3 = r1
                r1 = r18
                goto L_0x0413
            L_0x035f:
                r1 = 4
                byte[] r3 = new byte[r1]
                java.lang.String r4 = r0.codecId
                byte[] r4 = r0.getCodecPrivate(r4)
                r6 = 0
                java.lang.System.arraycopy(r4, r6, r3, r6, r1)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.of(r3)
                r17 = r2
                goto L_0x038c
            L_0x0373:
                com.google.android.exoplayer2.util.ParsableByteArray r1 = new com.google.android.exoplayer2.util.ParsableByteArray
                java.lang.String r3 = r0.codecId
                byte[] r3 = r0.getCodecPrivate(r3)
                r1.<init>((byte[]) r3)
                android.util.Pair r1 = parseFourCcPrivate(r1)
                java.lang.Object r3 = r1.first
                r17 = r3
                java.lang.String r17 = (java.lang.String) r17
                java.lang.Object r1 = r1.second
                java.util.List r1 = (java.util.List) r1
            L_0x038c:
                r3 = r8
                goto L_0x0302
            L_0x038f:
                java.lang.String r17 = "audio/mpeg"
                goto L_0x0394
            L_0x0392:
                java.lang.String r17 = "audio/mpeg-L2"
            L_0x0394:
                r1 = r8
                r3 = r1
                goto L_0x03a6
            L_0x0397:
                java.lang.String r1 = r0.codecId
                byte[] r1 = r0.getCodecPrivate(r1)
                java.util.List r1 = parseVorbisCodecPrivate(r1)
                java.lang.String r17 = "audio/vorbis"
                r16 = 8192(0x2000, float:1.14794E-41)
            L_0x03a5:
                r3 = r8
            L_0x03a6:
                r6 = r16
                r4 = -1
                goto L_0x0413
            L_0x03aa:
                com.google.android.exoplayer2.extractor.TrueHdSampleRechunker r1 = new com.google.android.exoplayer2.extractor.TrueHdSampleRechunker
                r1.<init>()
                r0.trueHdSampleRechunker = r1
                java.lang.String r17 = "audio/true-hd"
                goto L_0x0300
            L_0x03b5:
                com.google.android.exoplayer2.util.ParsableByteArray r1 = new com.google.android.exoplayer2.util.ParsableByteArray
                java.lang.String r3 = r0.codecId
                byte[] r3 = r0.getCodecPrivate(r3)
                r1.<init>((byte[]) r3)
                boolean r1 = parseMsAcmCodecPrivate(r1)
                if (r1 == 0) goto L_0x03eb
                int r1 = r0.audioBitDepth
                int r1 = com.google.android.exoplayer2.util.Util.getPcmEncoding(r1)
                if (r1 != 0) goto L_0x029d
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported PCM bit depth: "
                r1.append(r3)
                int r3 = r0.audioBitDepth
                r1.append(r3)
                r1.append(r6)
                r1.append(r10)
                java.lang.String r1 = r1.toString()
                com.google.android.exoplayer2.util.Log.w(r11, r1)
                goto L_0x03ff
            L_0x03eb:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
                r1.append(r3)
                r1.append(r10)
                java.lang.String r1 = r1.toString()
                com.google.android.exoplayer2.util.Log.w(r11, r1)
            L_0x03ff:
                r1 = r8
                r3 = r1
                r17 = r10
                goto L_0x0302
            L_0x0405:
                byte[] r1 = r0.codecPrivate
                if (r1 != 0) goto L_0x040b
                r1 = r8
                goto L_0x040f
            L_0x040b:
                java.util.List r1 = java.util.Collections.singletonList(r1)
            L_0x040f:
                java.lang.String r17 = "video/mp4v-es"
                goto L_0x038c
            L_0x0413:
                byte[] r7 = r0.dolbyVisionConfigBytes
                if (r7 == 0) goto L_0x0428
                com.google.android.exoplayer2.util.ParsableByteArray r7 = new com.google.android.exoplayer2.util.ParsableByteArray
                byte[] r10 = r0.dolbyVisionConfigBytes
                r7.<init>((byte[]) r10)
                com.google.android.exoplayer2.video.DolbyVisionConfig r7 = com.google.android.exoplayer2.video.DolbyVisionConfig.parse(r7)
                if (r7 == 0) goto L_0x0428
                java.lang.String r3 = r7.codecs
                java.lang.String r17 = "video/dolby-vision"
            L_0x0428:
                r7 = r17
                boolean r10 = r0.flagDefault
                r11 = 0
                r10 = r10 | r11
                boolean r9 = r0.flagForced
                if (r9 == 0) goto L_0x0434
                r9 = 2
                goto L_0x0435
            L_0x0434:
                r9 = r11
            L_0x0435:
                r9 = r9 | r10
                com.google.android.exoplayer2.Format$Builder r10 = new com.google.android.exoplayer2.Format$Builder
                r10.<init>()
                boolean r17 = com.google.android.exoplayer2.util.MimeTypes.isAudio(r7)
                if (r17 == 0) goto L_0x0453
                int r2 = r0.channelCount
                com.google.android.exoplayer2.Format$Builder r2 = r10.setChannelCount(r2)
                int r5 = r0.sampleRate
                com.google.android.exoplayer2.Format$Builder r2 = r2.setSampleRate(r5)
                r2.setPcmEncoding(r4)
                r5 = 1
                goto L_0x0559
            L_0x0453:
                boolean r4 = com.google.android.exoplayer2.util.MimeTypes.isVideo(r7)
                if (r4 == 0) goto L_0x052c
                int r2 = r0.displayUnit
                if (r2 != 0) goto L_0x046f
                int r2 = r0.displayWidth
                r4 = -1
                if (r2 != r4) goto L_0x0464
                int r2 = r0.width
            L_0x0464:
                r0.displayWidth = r2
                int r2 = r0.displayHeight
                if (r2 != r4) goto L_0x046c
                int r2 = r0.height
            L_0x046c:
                r0.displayHeight = r2
                goto L_0x0470
            L_0x046f:
                r4 = -1
            L_0x0470:
                int r2 = r0.displayWidth
                if (r2 == r4) goto L_0x0482
                int r5 = r0.displayHeight
                if (r5 == r4) goto L_0x0482
                int r12 = r0.height
                int r12 = r12 * r2
                float r2 = (float) r12
                int r12 = r0.width
                int r12 = r12 * r5
                float r5 = (float) r12
                float r2 = r2 / r5
                goto L_0x0484
            L_0x0482:
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            L_0x0484:
                boolean r5 = r0.hasColorInfo
                if (r5 == 0) goto L_0x0497
                byte[] r5 = r19.getHdrStaticInfo()
                com.google.android.exoplayer2.video.ColorInfo r8 = new com.google.android.exoplayer2.video.ColorInfo
                int r12 = r0.colorSpace
                int r13 = r0.colorRange
                int r14 = r0.colorTransfer
                r8.<init>(r12, r13, r14, r5)
            L_0x0497:
                java.lang.String r5 = r0.f34933name
                if (r5 == 0) goto L_0x04b7
                java.util.Map r5 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES
                java.lang.String r12 = r0.f34933name
                boolean r5 = r5.containsKey(r12)
                if (r5 == 0) goto L_0x04b7
                java.util.Map r4 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES
                java.lang.String r5 = r0.f34933name
                java.lang.Object r4 = r4.get(r5)
                java.lang.Integer r4 = (java.lang.Integer) r4
                int r4 = r4.intValue()
            L_0x04b7:
                int r5 = r0.projectionType
                if (r5 != 0) goto L_0x0507
                float r5 = r0.projectionPoseYaw
                r12 = 0
                int r5 = java.lang.Float.compare(r5, r12)
                if (r5 != 0) goto L_0x0507
                float r5 = r0.projectionPosePitch
                int r5 = java.lang.Float.compare(r5, r12)
                if (r5 != 0) goto L_0x0507
                float r5 = r0.projectionPoseRoll
                int r5 = java.lang.Float.compare(r5, r12)
                if (r5 != 0) goto L_0x04d6
                r4 = r11
                goto L_0x0507
            L_0x04d6:
                float r5 = r0.projectionPosePitch
                r11 = 1119092736(0x42b40000, float:90.0)
                int r5 = java.lang.Float.compare(r5, r11)
                if (r5 != 0) goto L_0x04e3
                r4 = 90
                goto L_0x0507
            L_0x04e3:
                float r5 = r0.projectionPosePitch
                r11 = -1020002304(0xffffffffc3340000, float:-180.0)
                int r5 = java.lang.Float.compare(r5, r11)
                if (r5 == 0) goto L_0x0505
                float r5 = r0.projectionPosePitch
                r11 = 1127481344(0x43340000, float:180.0)
                int r5 = java.lang.Float.compare(r5, r11)
                if (r5 != 0) goto L_0x04f8
                goto L_0x0505
            L_0x04f8:
                float r5 = r0.projectionPosePitch
                r11 = -1028390912(0xffffffffc2b40000, float:-90.0)
                int r5 = java.lang.Float.compare(r5, r11)
                if (r5 != 0) goto L_0x0507
                r4 = 270(0x10e, float:3.78E-43)
                goto L_0x0507
            L_0x0505:
                r4 = 180(0xb4, float:2.52E-43)
            L_0x0507:
                int r5 = r0.width
                com.google.android.exoplayer2.Format$Builder r5 = r10.setWidth(r5)
                int r11 = r0.height
                com.google.android.exoplayer2.Format$Builder r5 = r5.setHeight(r11)
                com.google.android.exoplayer2.Format$Builder r2 = r5.setPixelWidthHeightRatio(r2)
                com.google.android.exoplayer2.Format$Builder r2 = r2.setRotationDegrees(r4)
                byte[] r4 = r0.projectionData
                com.google.android.exoplayer2.Format$Builder r2 = r2.setProjectionData(r4)
                int r4 = r0.stereoMode
                com.google.android.exoplayer2.Format$Builder r2 = r2.setStereoMode(r4)
                r2.setColorInfo(r8)
                r5 = 2
                goto L_0x0559
            L_0x052c:
                boolean r4 = r5.equals(r7)
                if (r4 != 0) goto L_0x0558
                boolean r4 = r15.equals(r7)
                if (r4 != 0) goto L_0x0558
                boolean r4 = r14.equals(r7)
                if (r4 != 0) goto L_0x0558
                boolean r4 = r13.equals(r7)
                if (r4 != 0) goto L_0x0558
                boolean r4 = r12.equals(r7)
                if (r4 != 0) goto L_0x0558
                boolean r2 = r2.equals(r7)
                if (r2 == 0) goto L_0x0551
                goto L_0x0558
            L_0x0551:
                java.lang.String r1 = "Unexpected MIME type."
                com.google.android.exoplayer2.ParserException r1 = com.google.android.exoplayer2.ParserException.createForMalformedContainer(r1, r8)
                throw r1
            L_0x0558:
                r5 = 3
            L_0x0559:
                java.lang.String r2 = r0.f34933name
                if (r2 == 0) goto L_0x056e
                java.util.Map r2 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES
                java.lang.String r4 = r0.f34933name
                boolean r2 = r2.containsKey(r4)
                if (r2 != 0) goto L_0x056e
                java.lang.String r2 = r0.f34933name
                r10.setLabel(r2)
            L_0x056e:
                r2 = r21
                com.google.android.exoplayer2.Format$Builder r2 = r10.setId((int) r2)
                com.google.android.exoplayer2.Format$Builder r2 = r2.setSampleMimeType(r7)
                com.google.android.exoplayer2.Format$Builder r2 = r2.setMaxInputSize(r6)
                java.lang.String r4 = r0.language
                com.google.android.exoplayer2.Format$Builder r2 = r2.setLanguage(r4)
                com.google.android.exoplayer2.Format$Builder r2 = r2.setSelectionFlags(r9)
                com.google.android.exoplayer2.Format$Builder r1 = r2.setInitializationData(r1)
                com.google.android.exoplayer2.Format$Builder r1 = r1.setCodecs(r3)
                com.google.android.exoplayer2.drm.DrmInitData r2 = r0.drmInitData
                com.google.android.exoplayer2.Format$Builder r1 = r1.setDrmInitData(r2)
                com.google.android.exoplayer2.Format r1 = r1.build()
                int r2 = r0.number
                r3 = r20
                com.google.android.exoplayer2.extractor.TrackOutput r2 = r3.track(r2, r5)
                r0.output = r2
                r2.format(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track.initializeOutput(com.google.android.exoplayer2.extractor.ExtractorOutput, int):void");
        }

        @RequiresNonNull({"output"})
        public void outputPendingSampleMetadata() {
            TrueHdSampleRechunker trueHdSampleRechunker2 = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker2 != null) {
                trueHdSampleRechunker2.outputPendingSampleMetadata(this.output, this.cryptoData);
            }
        }

        public void reset() {
            TrueHdSampleRechunker trueHdSampleRechunker2 = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker2 != null) {
                trueHdSampleRechunker2.reset();
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        TRACK_NAME_TO_ROTATION_DEGREES = Collections.unmodifiableMap(hashMap);
    }

    public MatroskaExtractor() {
        this(0);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private void assertInCues(int i11) throws ParserException {
        if (this.cueTimesUs == null || this.cueClusterPositions == null) {
            throw ParserException.createForMalformedContainer("Element " + i11 + " must be in a Cues", (Throwable) null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private void assertInTrackEntry(int i11) throws ParserException {
        if (this.currentTrack == null) {
            throw ParserException.createForMalformedContainer("Element " + i11 + " must be in a TrackEntry", (Throwable) null);
        }
    }

    @EnsuresNonNull({"extractorOutput"})
    private void assertInitialized() {
        Assertions.checkStateNotNull(this.extractorOutput);
    }

    private SeekMap buildSeekMap(@Nullable LongArray longArray, @Nullable LongArray longArray2) {
        int i11;
        if (this.segmentContentPosition == -1 || this.durationUs == C.TIME_UNSET || longArray == null || longArray.size() == 0 || longArray2 == null || longArray2.size() != longArray.size()) {
            return new SeekMap.Unseekable(this.durationUs);
        }
        int size = longArray.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            jArr3[i13] = longArray.get(i13);
            jArr[i13] = this.segmentContentPosition + longArray2.get(i13);
        }
        while (true) {
            i11 = size - 1;
            if (i12 >= i11) {
                break;
            }
            int i14 = i12 + 1;
            iArr[i12] = (int) (jArr[i14] - jArr[i12]);
            jArr2[i12] = jArr3[i14] - jArr3[i12];
            i12 = i14;
        }
        iArr[i11] = (int) ((this.segmentContentPosition + this.segmentContentSize) - jArr[i11]);
        long j11 = this.durationUs - jArr3[i11];
        jArr2[i11] = j11;
        if (j11 <= 0) {
            Log.w(TAG, "Discarding last cue point with unexpected duration: " + j11);
            iArr = Arrays.copyOf(iArr, i11);
            jArr = Arrays.copyOf(jArr, i11);
            jArr2 = Arrays.copyOf(jArr2, i11);
            jArr3 = Arrays.copyOf(jArr3, i11);
        }
        return new ChunkIndex(iArr, jArr, jArr2, jArr3);
    }

    @RequiresNonNull({"#1.output"})
    private void commitSampleToOutput(Track track, long j11, int i11, int i12, int i13) {
        TrueHdSampleRechunker trueHdSampleRechunker = track.trueHdSampleRechunker;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.sampleMetadata(track.output, j11, i11, i12, i13, track.cryptoData);
        } else {
            if (CODEC_ID_SUBRIP.equals(track.codecId) || CODEC_ID_ASS.equals(track.codecId) || CODEC_ID_VTT.equals(track.codecId)) {
                if (this.blockSampleCount > 1) {
                    Log.w(TAG, "Skipping subtitle sample in laced block.");
                } else {
                    long j12 = this.blockDurationUs;
                    if (j12 == C.TIME_UNSET) {
                        Log.w(TAG, "Skipping subtitle sample with no duration.");
                    } else {
                        setSubtitleEndTime(track.codecId, j12, this.subtitleSample.getData());
                        int position = this.subtitleSample.getPosition();
                        while (true) {
                            if (position >= this.subtitleSample.limit()) {
                                break;
                            } else if (this.subtitleSample.getData()[position] == 0) {
                                this.subtitleSample.setLimit(position);
                                break;
                            } else {
                                position++;
                            }
                        }
                        TrackOutput trackOutput = track.output;
                        ParsableByteArray parsableByteArray = this.subtitleSample;
                        trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
                        i12 += this.subtitleSample.limit();
                    }
                }
            }
            if ((268435456 & i11) != 0) {
                if (this.blockSampleCount > 1) {
                    this.supplementalData.reset(0);
                } else {
                    int limit = this.supplementalData.limit();
                    track.output.sampleData(this.supplementalData, limit, 2);
                    i12 += limit;
                }
            }
            track.output.sampleMetadata(j11, i11, i12, i13, track.cryptoData);
        }
        this.haveOutputSample = true;
    }

    private static int[] ensureArrayCapacity(@Nullable int[] iArr, int i11) {
        if (iArr == null) {
            return new int[i11];
        }
        if (iArr.length >= i11) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i11)];
    }

    private int finishWriteSampleData() {
        int i11 = this.sampleBytesWritten;
        resetWriteSampleData();
        return i11;
    }

    private static byte[] formatSubtitleTimecode(long j11, String str, long j12) {
        boolean z11;
        if (j11 != C.TIME_UNSET) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        int i11 = (int) (j11 / 3600000000L);
        long j13 = j11 - ((((long) i11) * 3600) * 1000000);
        int i12 = (int) (j13 / 60000000);
        long j14 = j13 - ((((long) i12) * 60) * 1000000);
        int i13 = (int) (j14 / 1000000);
        return Util.getUtf8Bytes(String.format(Locale.US, str, new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf((int) ((j14 - (((long) i13) * 1000000)) / j12))}));
    }

    private static boolean isCodecSupported(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals(CODEC_ID_MPEG4_AP)) {
                    c11 = 0;
                    break;
                }
                break;
            case -2095575984:
                if (str.equals(CODEC_ID_MPEG4_SP)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1985379776:
                if (str.equals(CODEC_ID_ACM)) {
                    c11 = 2;
                    break;
                }
                break;
            case -1784763192:
                if (str.equals(CODEC_ID_TRUEHD)) {
                    c11 = 3;
                    break;
                }
                break;
            case -1730367663:
                if (str.equals(CODEC_ID_VORBIS)) {
                    c11 = 4;
                    break;
                }
                break;
            case -1482641358:
                if (str.equals(CODEC_ID_MP2)) {
                    c11 = 5;
                    break;
                }
                break;
            case -1482641357:
                if (str.equals(CODEC_ID_MP3)) {
                    c11 = 6;
                    break;
                }
                break;
            case -1373388978:
                if (str.equals(CODEC_ID_FOURCC)) {
                    c11 = 7;
                    break;
                }
                break;
            case -933872740:
                if (str.equals(CODEC_ID_DVBSUB)) {
                    c11 = 8;
                    break;
                }
                break;
            case -538363189:
                if (str.equals(CODEC_ID_MPEG4_ASP)) {
                    c11 = 9;
                    break;
                }
                break;
            case -538363109:
                if (str.equals(CODEC_ID_H264)) {
                    c11 = 10;
                    break;
                }
                break;
            case -425012669:
                if (str.equals(CODEC_ID_VOBSUB)) {
                    c11 = 11;
                    break;
                }
                break;
            case -356037306:
                if (str.equals(CODEC_ID_DTS_LOSSLESS)) {
                    c11 = 12;
                    break;
                }
                break;
            case 62923557:
                if (str.equals(CODEC_ID_AAC)) {
                    c11 = CharUtils.CR;
                    break;
                }
                break;
            case 62923603:
                if (str.equals(CODEC_ID_AC3)) {
                    c11 = 14;
                    break;
                }
                break;
            case 62927045:
                if (str.equals(CODEC_ID_DTS)) {
                    c11 = 15;
                    break;
                }
                break;
            case 82318131:
                if (str.equals(CODEC_ID_AV1)) {
                    c11 = 16;
                    break;
                }
                break;
            case 82338133:
                if (str.equals(CODEC_ID_VP8)) {
                    c11 = 17;
                    break;
                }
                break;
            case 82338134:
                if (str.equals(CODEC_ID_VP9)) {
                    c11 = 18;
                    break;
                }
                break;
            case 99146302:
                if (str.equals(CODEC_ID_PGS)) {
                    c11 = 19;
                    break;
                }
                break;
            case 444813526:
                if (str.equals(CODEC_ID_THEORA)) {
                    c11 = 20;
                    break;
                }
                break;
            case 542569478:
                if (str.equals(CODEC_ID_DTS_EXPRESS)) {
                    c11 = 21;
                    break;
                }
                break;
            case 635596514:
                if (str.equals(CODEC_ID_PCM_FLOAT)) {
                    c11 = 22;
                    break;
                }
                break;
            case 725948237:
                if (str.equals(CODEC_ID_PCM_INT_BIG)) {
                    c11 = 23;
                    break;
                }
                break;
            case 725957860:
                if (str.equals(CODEC_ID_PCM_INT_LIT)) {
                    c11 = 24;
                    break;
                }
                break;
            case 738597099:
                if (str.equals(CODEC_ID_ASS)) {
                    c11 = 25;
                    break;
                }
                break;
            case 855502857:
                if (str.equals(CODEC_ID_H265)) {
                    c11 = 26;
                    break;
                }
                break;
            case 1045209816:
                if (str.equals(CODEC_ID_VTT)) {
                    c11 = 27;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals(CODEC_ID_SUBRIP)) {
                    c11 = 28;
                    break;
                }
                break;
            case 1809237540:
                if (str.equals(CODEC_ID_MPEG2)) {
                    c11 = 29;
                    break;
                }
                break;
            case 1950749482:
                if (str.equals(CODEC_ID_E_AC3)) {
                    c11 = 30;
                    break;
                }
                break;
            case 1950789798:
                if (str.equals(CODEC_ID_FLAC)) {
                    c11 = 31;
                    break;
                }
                break;
            case 1951062397:
                if (str.equals(CODEC_ID_OPUS)) {
                    c11 = ' ';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case ' ':
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new MatroskaExtractor()};
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder, long j11) {
        if (this.seekForCues) {
            this.seekPositionAfterBuildingCues = j11;
            positionHolder.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if (this.sentSeekMap) {
            long j12 = this.seekPositionAfterBuildingCues;
            if (j12 != -1) {
                positionHolder.position = j12;
                this.seekPositionAfterBuildingCues = -1;
                return true;
            }
        }
        return false;
    }

    private void readScratch(ExtractorInput extractorInput, int i11) throws IOException {
        if (this.scratch.limit() < i11) {
            if (this.scratch.capacity() < i11) {
                ParsableByteArray parsableByteArray = this.scratch;
                parsableByteArray.ensureCapacity(Math.max(parsableByteArray.capacity() * 2, i11));
            }
            extractorInput.readFully(this.scratch.getData(), this.scratch.limit(), i11 - this.scratch.limit());
            this.scratch.setLimit(i11);
        }
    }

    private void resetWriteSampleData() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset(0);
    }

    private long scaleTimecodeToUs(long j11) throws ParserException {
        long j12 = this.timecodeScale;
        if (j12 != C.TIME_UNSET) {
            return Util.scaleLargeTimestamp(j11, j12, 1000);
        }
        throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", (Throwable) null);
    }

    private static void setSubtitleEndTime(String str, long j11, byte[] bArr) {
        int i11;
        byte[] bArr2;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 738597099:
                if (str.equals(CODEC_ID_ASS)) {
                    c11 = 0;
                    break;
                }
                break;
            case 1045209816:
                if (str.equals(CODEC_ID_VTT)) {
                    c11 = 1;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals(CODEC_ID_SUBRIP)) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                bArr2 = formatSubtitleTimecode(j11, SSA_TIMECODE_FORMAT, 10000);
                i11 = 21;
                break;
            case 1:
                bArr2 = formatSubtitleTimecode(j11, VTT_TIMECODE_FORMAT, 1000);
                i11 = 25;
                break;
            case 2:
                bArr2 = formatSubtitleTimecode(j11, SUBRIP_TIMECODE_FORMAT, 1000);
                i11 = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(bArr2, 0, bArr, i11, bArr2.length);
    }

    @RequiresNonNull({"#2.output"})
    private int writeSampleData(ExtractorInput extractorInput, Track track, int i11, boolean z11) throws IOException {
        boolean z12;
        boolean z13;
        int i12;
        if (CODEC_ID_SUBRIP.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i11);
            return finishWriteSampleData();
        } else if (CODEC_ID_ASS.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SSA_PREFIX, i11);
            return finishWriteSampleData();
        } else if (CODEC_ID_VTT.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, VTT_PREFIX, i11);
            return finishWriteSampleData();
        } else {
            TrackOutput trackOutput = track.output;
            boolean z14 = true;
            if (!this.sampleEncodingHandled) {
                if (track.hasContentEncryption) {
                    this.blockFlags &= -1073741825;
                    int i13 = 128;
                    if (!this.sampleSignalByteRead) {
                        extractorInput.readFully(this.scratch.getData(), 0, 1);
                        this.sampleBytesRead++;
                        if ((this.scratch.getData()[0] & 128) != 128) {
                            this.sampleSignalByte = this.scratch.getData()[0];
                            this.sampleSignalByteRead = true;
                        } else {
                            throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", (Throwable) null);
                        }
                    }
                    byte b11 = this.sampleSignalByte;
                    if ((b11 & 1) == 1) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        if ((b11 & 2) == 2) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        this.blockFlags |= 1073741824;
                        if (!this.sampleInitializationVectorRead) {
                            extractorInput.readFully(this.encryptionInitializationVector.getData(), 0, 8);
                            this.sampleBytesRead += 8;
                            this.sampleInitializationVectorRead = true;
                            byte[] data = this.scratch.getData();
                            if (!z13) {
                                i13 = 0;
                            }
                            data[0] = (byte) (i13 | 8);
                            this.scratch.setPosition(0);
                            trackOutput.sampleData(this.scratch, 1, 1);
                            this.sampleBytesWritten++;
                            this.encryptionInitializationVector.setPosition(0);
                            trackOutput.sampleData(this.encryptionInitializationVector, 8, 1);
                            this.sampleBytesWritten += 8;
                        }
                        if (z13) {
                            if (!this.samplePartitionCountRead) {
                                extractorInput.readFully(this.scratch.getData(), 0, 1);
                                this.sampleBytesRead++;
                                this.scratch.setPosition(0);
                                this.samplePartitionCount = this.scratch.readUnsignedByte();
                                this.samplePartitionCountRead = true;
                            }
                            int i14 = this.samplePartitionCount * 4;
                            this.scratch.reset(i14);
                            extractorInput.readFully(this.scratch.getData(), 0, i14);
                            this.sampleBytesRead += i14;
                            short s11 = (short) ((this.samplePartitionCount / 2) + 1);
                            int i15 = (s11 * 6) + 2;
                            ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                            if (byteBuffer == null || byteBuffer.capacity() < i15) {
                                this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i15);
                            }
                            this.encryptionSubsampleDataBuffer.position(0);
                            this.encryptionSubsampleDataBuffer.putShort(s11);
                            int i16 = 0;
                            int i17 = 0;
                            while (true) {
                                i12 = this.samplePartitionCount;
                                if (i16 >= i12) {
                                    break;
                                }
                                int readUnsignedIntToInt = this.scratch.readUnsignedIntToInt();
                                if (i16 % 2 == 0) {
                                    this.encryptionSubsampleDataBuffer.putShort((short) (readUnsignedIntToInt - i17));
                                } else {
                                    this.encryptionSubsampleDataBuffer.putInt(readUnsignedIntToInt - i17);
                                }
                                i16++;
                                i17 = readUnsignedIntToInt;
                            }
                            int i18 = (i11 - this.sampleBytesRead) - i17;
                            if (i12 % 2 == 1) {
                                this.encryptionSubsampleDataBuffer.putInt(i18);
                            } else {
                                this.encryptionSubsampleDataBuffer.putShort((short) i18);
                                this.encryptionSubsampleDataBuffer.putInt(0);
                            }
                            this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i15);
                            trackOutput.sampleData(this.encryptionSubsampleData, i15, 1);
                            this.sampleBytesWritten += i15;
                        }
                    }
                } else {
                    byte[] bArr = track.sampleStrippedBytes;
                    if (bArr != null) {
                        this.sampleStrippedBytes.reset(bArr, bArr.length);
                    }
                }
                if (track.samplesHaveSupplementalData(z11)) {
                    this.blockFlags |= 268435456;
                    this.supplementalData.reset(0);
                    int limit = (this.sampleStrippedBytes.limit() + i11) - this.sampleBytesRead;
                    this.scratch.reset(4);
                    this.scratch.getData()[0] = (byte) ((limit >> 24) & 255);
                    this.scratch.getData()[1] = (byte) ((limit >> 16) & 255);
                    this.scratch.getData()[2] = (byte) ((limit >> 8) & 255);
                    this.scratch.getData()[3] = (byte) (limit & 255);
                    trackOutput.sampleData(this.scratch, 4, 2);
                    this.sampleBytesWritten += 4;
                }
                this.sampleEncodingHandled = true;
            }
            int limit2 = i11 + this.sampleStrippedBytes.limit();
            if (!CODEC_ID_H264.equals(track.codecId) && !CODEC_ID_H265.equals(track.codecId)) {
                if (track.trueHdSampleRechunker != null) {
                    if (this.sampleStrippedBytes.limit() != 0) {
                        z14 = false;
                    }
                    Assertions.checkState(z14);
                    track.trueHdSampleRechunker.startSample(extractorInput);
                }
                while (true) {
                    int i19 = this.sampleBytesRead;
                    if (i19 >= limit2) {
                        break;
                    }
                    int writeToOutput = writeToOutput(extractorInput, trackOutput, limit2 - i19);
                    this.sampleBytesRead += writeToOutput;
                    this.sampleBytesWritten += writeToOutput;
                }
            } else {
                byte[] data2 = this.nalLength.getData();
                data2[0] = 0;
                data2[1] = 0;
                data2[2] = 0;
                int i21 = track.nalUnitLengthFieldLength;
                int i22 = 4 - i21;
                while (this.sampleBytesRead < limit2) {
                    int i23 = this.sampleCurrentNalBytesRemaining;
                    if (i23 == 0) {
                        writeToTarget(extractorInput, data2, i22, i21);
                        this.sampleBytesRead += i21;
                        this.nalLength.setPosition(0);
                        this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                        this.nalStartCode.setPosition(0);
                        trackOutput.sampleData(this.nalStartCode, 4);
                        this.sampleBytesWritten += 4;
                    } else {
                        int writeToOutput2 = writeToOutput(extractorInput, trackOutput, i23);
                        this.sampleBytesRead += writeToOutput2;
                        this.sampleBytesWritten += writeToOutput2;
                        this.sampleCurrentNalBytesRemaining -= writeToOutput2;
                    }
                }
            }
            if (CODEC_ID_VORBIS.equals(track.codecId)) {
                this.vorbisNumPageSamples.setPosition(0);
                trackOutput.sampleData(this.vorbisNumPageSamples, 4);
                this.sampleBytesWritten += 4;
            }
            return finishWriteSampleData();
        }
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] bArr, int i11) throws IOException {
        int length = bArr.length + i11;
        if (this.subtitleSample.capacity() < length) {
            this.subtitleSample.reset(Arrays.copyOf(bArr, length + i11));
        } else {
            System.arraycopy(bArr, 0, this.subtitleSample.getData(), 0, bArr.length);
        }
        extractorInput.readFully(this.subtitleSample.getData(), bArr.length, i11);
        this.subtitleSample.setPosition(0);
        this.subtitleSample.setLimit(length);
    }

    private int writeToOutput(ExtractorInput extractorInput, TrackOutput trackOutput, int i11) throws IOException {
        int bytesLeft = this.sampleStrippedBytes.bytesLeft();
        if (bytesLeft <= 0) {
            return trackOutput.sampleData((DataReader) extractorInput, i11, false);
        }
        int min = Math.min(i11, bytesLeft);
        trackOutput.sampleData(this.sampleStrippedBytes, min);
        return min;
    }

    private void writeToTarget(ExtractorInput extractorInput, byte[] bArr, int i11, int i12) throws IOException {
        int min = Math.min(i12, this.sampleStrippedBytes.bytesLeft());
        extractorInput.readFully(bArr, i11 + min, i12 - min);
        if (min > 0) {
            this.sampleStrippedBytes.readBytes(bArr, i11, min);
        }
    }

    @CallSuper
    public void binaryElement(int i11, int i12, ExtractorInput extractorInput) throws IOException {
        Track track;
        int i13;
        Track track2;
        int i14;
        Track track3;
        long j11;
        int i15;
        byte b11;
        int i16;
        int i17 = i11;
        int i18 = i12;
        ExtractorInput extractorInput2 = extractorInput;
        int i19 = 0;
        int i21 = 1;
        if (i17 == 161 || i17 == 163) {
            if (this.blockState == 0) {
                this.blockTrackNumber = (int) this.varintReader.readUnsignedVarint(extractorInput2, false, true, 8);
                this.blockTrackNumberLength = this.varintReader.getLastLength();
                this.blockDurationUs = C.TIME_UNSET;
                this.blockState = 1;
                this.scratch.reset(0);
            }
            Track track4 = this.tracks.get(this.blockTrackNumber);
            if (track4 == null) {
                extractorInput2.skipFully(i18 - this.blockTrackNumberLength);
                this.blockState = 0;
                return;
            }
            track4.assertOutputInitialized();
            if (this.blockState == 1) {
                readScratch(extractorInput2, 3);
                int i22 = (this.scratch.getData()[2] & 6) >> 1;
                byte b12 = 255;
                if (i22 == 0) {
                    this.blockSampleCount = 1;
                    int[] ensureArrayCapacity = ensureArrayCapacity(this.blockSampleSizes, 1);
                    this.blockSampleSizes = ensureArrayCapacity;
                    ensureArrayCapacity[0] = (i18 - this.blockTrackNumberLength) - 3;
                } else {
                    int i23 = 4;
                    readScratch(extractorInput2, 4);
                    int i24 = (this.scratch.getData()[3] & 255) + 1;
                    this.blockSampleCount = i24;
                    int[] ensureArrayCapacity2 = ensureArrayCapacity(this.blockSampleSizes, i24);
                    this.blockSampleSizes = ensureArrayCapacity2;
                    if (i22 == 2) {
                        int i25 = this.blockSampleCount;
                        Arrays.fill(ensureArrayCapacity2, 0, i25, ((i18 - this.blockTrackNumberLength) - 4) / i25);
                    } else if (i22 == 1) {
                        int i26 = 0;
                        int i27 = 0;
                        while (true) {
                            i15 = this.blockSampleCount;
                            if (i26 >= i15 - 1) {
                                break;
                            }
                            this.blockSampleSizes[i26] = 0;
                            do {
                                i23++;
                                readScratch(extractorInput2, i23);
                                b11 = this.scratch.getData()[i23 - 1] & 255;
                                int[] iArr = this.blockSampleSizes;
                                i16 = iArr[i26] + b11;
                                iArr[i26] = i16;
                            } while (b11 == 255);
                            i27 += i16;
                            i26++;
                        }
                        this.blockSampleSizes[i15 - 1] = ((i18 - this.blockTrackNumberLength) - i23) - i27;
                    } else if (i22 == 3) {
                        int i28 = 0;
                        int i29 = 0;
                        while (true) {
                            int i31 = this.blockSampleCount;
                            if (i28 >= i31 - 1) {
                                track2 = track4;
                                this.blockSampleSizes[i31 - 1] = ((i18 - this.blockTrackNumberLength) - i23) - i29;
                                break;
                            }
                            this.blockSampleSizes[i28] = i19;
                            i23++;
                            readScratch(extractorInput2, i23);
                            int i32 = i23 - 1;
                            if (this.scratch.getData()[i32] != 0) {
                                int i33 = i19;
                                while (true) {
                                    if (i33 >= 8) {
                                        track3 = track4;
                                        j11 = 0;
                                        break;
                                    }
                                    int i34 = i21 << (7 - i33);
                                    if ((this.scratch.getData()[i32] & i34) != 0) {
                                        int i35 = i23 + i33;
                                        readScratch(extractorInput2, i35);
                                        track3 = track4;
                                        j11 = (long) ((~i34) & this.scratch.getData()[i32] & b12);
                                        int i36 = i32 + 1;
                                        while (i36 < i35) {
                                            j11 = (j11 << 8) | ((long) (this.scratch.getData()[i36] & b12));
                                            i36++;
                                            i35 = i35;
                                            b12 = 255;
                                        }
                                        int i37 = i35;
                                        if (i28 > 0) {
                                            j11 -= (1 << ((i33 * 7) + 6)) - 1;
                                        }
                                        i23 = i37;
                                    } else {
                                        Track track5 = track4;
                                        i33++;
                                        i21 = 1;
                                        b12 = 255;
                                    }
                                }
                                if (j11 >= -2147483648L && j11 <= 2147483647L) {
                                    int i38 = (int) j11;
                                    int[] iArr2 = this.blockSampleSizes;
                                    if (i28 != 0) {
                                        i38 += iArr2[i28 - 1];
                                    }
                                    iArr2[i28] = i38;
                                    i29 += i38;
                                    i28++;
                                    track4 = track3;
                                    i19 = 0;
                                    i21 = 1;
                                    b12 = 255;
                                }
                            } else {
                                throw ParserException.createForMalformedContainer("No valid varint length mask found", (Throwable) null);
                            }
                        }
                        throw ParserException.createForMalformedContainer("EBML lacing sample size out of range.", (Throwable) null);
                    } else {
                        throw ParserException.createForMalformedContainer("Unexpected lacing value: " + i22, (Throwable) null);
                    }
                }
                track2 = track4;
                this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((long) ((this.scratch.getData()[0] << 8) | (this.scratch.getData()[1] & 255)));
                track = track2;
                if (track.type == 2 || (i17 == 163 && (this.scratch.getData()[2] & 128) == 128)) {
                    i14 = 1;
                } else {
                    i14 = 0;
                }
                this.blockFlags = i14;
                this.blockState = 2;
                this.blockSampleIndex = 0;
                i13 = 163;
            } else {
                track = track4;
                i13 = 163;
            }
            if (i17 == i13) {
                while (true) {
                    int i39 = this.blockSampleIndex;
                    if (i39 < this.blockSampleCount) {
                        commitSampleToOutput(track, ((long) ((this.blockSampleIndex * track.defaultSampleDurationNs) / 1000)) + this.blockTimeUs, this.blockFlags, writeSampleData(extractorInput2, track, this.blockSampleSizes[i39], false), 0);
                        this.blockSampleIndex++;
                    } else {
                        this.blockState = 0;
                        return;
                    }
                }
            } else {
                while (true) {
                    int i41 = this.blockSampleIndex;
                    if (i41 < this.blockSampleCount) {
                        int[] iArr3 = this.blockSampleSizes;
                        iArr3[i41] = writeSampleData(extractorInput2, track, iArr3[i41], true);
                        this.blockSampleIndex++;
                    } else {
                        return;
                    }
                }
            }
        } else if (i17 != 165) {
            if (i17 == 16877) {
                handleBlockAddIDExtraData(getCurrentTrack(i11), extractorInput2, i18);
            } else if (i17 == ID_CONTENT_COMPRESSION_SETTINGS) {
                assertInTrackEntry(i11);
                byte[] bArr = new byte[i18];
                this.currentTrack.sampleStrippedBytes = bArr;
                extractorInput2.readFully(bArr, 0, i18);
            } else if (i17 == ID_CONTENT_ENCRYPTION_KEY_ID) {
                byte[] bArr2 = new byte[i18];
                extractorInput2.readFully(bArr2, 0, i18);
                getCurrentTrack(i11).cryptoData = new TrackOutput.CryptoData(1, bArr2, 0, 0);
            } else if (i17 == ID_SEEK_ID) {
                Arrays.fill(this.seekEntryIdBytes.getData(), (byte) 0);
                extractorInput2.readFully(this.seekEntryIdBytes.getData(), 4 - i18, i18);
                this.seekEntryIdBytes.setPosition(0);
                this.seekEntryId = (int) this.seekEntryIdBytes.readUnsignedInt();
            } else if (i17 == ID_CODEC_PRIVATE) {
                assertInTrackEntry(i11);
                byte[] bArr3 = new byte[i18];
                this.currentTrack.codecPrivate = bArr3;
                extractorInput2.readFully(bArr3, 0, i18);
            } else if (i17 == ID_PROJECTION_PRIVATE) {
                assertInTrackEntry(i11);
                byte[] bArr4 = new byte[i18];
                this.currentTrack.projectionData = bArr4;
                extractorInput2.readFully(bArr4, 0, i18);
            } else {
                throw ParserException.createForMalformedContainer("Unexpected id: " + i17, (Throwable) null);
            }
        } else if (this.blockState == 2) {
            handleBlockAdditionalData(this.tracks.get(this.blockTrackNumber), this.blockAdditionalId, extractorInput2, i18);
        }
    }

    @CallSuper
    public void endMasterElement(int i11) throws ParserException {
        assertInitialized();
        if (i11 != 160) {
            if (i11 == 174) {
                Track track = (Track) Assertions.checkStateNotNull(this.currentTrack);
                String str = track.codecId;
                if (str != null) {
                    if (isCodecSupported(str)) {
                        track.initializeOutput(this.extractorOutput, track.number);
                        this.tracks.put(track.number, track);
                    }
                    this.currentTrack = null;
                    return;
                }
                throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", (Throwable) null);
            } else if (i11 == ID_SEEK) {
                int i12 = this.seekEntryId;
                if (i12 != -1) {
                    long j11 = this.seekEntryPosition;
                    if (j11 != -1) {
                        if (i12 == ID_CUES) {
                            this.cuesContentPosition = j11;
                            return;
                        }
                        return;
                    }
                }
                throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", (Throwable) null);
            } else if (i11 == ID_CONTENT_ENCODING) {
                assertInTrackEntry(i11);
                Track track2 = this.currentTrack;
                if (!track2.hasContentEncryption) {
                    return;
                }
                if (track2.cryptoData != null) {
                    track2.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C.UUID_NIL, MimeTypes.VIDEO_WEBM, this.currentTrack.cryptoData.encryptionKey));
                    return;
                }
                throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", (Throwable) null);
            } else if (i11 == ID_CONTENT_ENCODINGS) {
                assertInTrackEntry(i11);
                Track track3 = this.currentTrack;
                if (track3.hasContentEncryption && track3.sampleStrippedBytes != null) {
                    throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", (Throwable) null);
                }
            } else if (i11 == 357149030) {
                if (this.timecodeScale == C.TIME_UNSET) {
                    this.timecodeScale = 1000000;
                }
                long j12 = this.durationTimecode;
                if (j12 != C.TIME_UNSET) {
                    this.durationUs = scaleTimecodeToUs(j12);
                }
            } else if (i11 != ID_TRACKS) {
                if (i11 == ID_CUES) {
                    if (!this.sentSeekMap) {
                        this.extractorOutput.seekMap(buildSeekMap(this.cueTimesUs, this.cueClusterPositions));
                        this.sentSeekMap = true;
                    }
                    this.cueTimesUs = null;
                    this.cueClusterPositions = null;
                }
            } else if (this.tracks.size() != 0) {
                this.extractorOutput.endTracks();
            } else {
                throw ParserException.createForMalformedContainer("No valid tracks were found", (Throwable) null);
            }
        } else if (this.blockState == 2) {
            Track track4 = this.tracks.get(this.blockTrackNumber);
            track4.assertOutputInitialized();
            if (this.blockGroupDiscardPaddingNs > 0 && CODEC_ID_OPUS.equals(track4.codecId)) {
                this.supplementalData.reset(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.blockGroupDiscardPaddingNs).array());
            }
            int i13 = 0;
            for (int i14 = 0; i14 < this.blockSampleCount; i14++) {
                i13 += this.blockSampleSizes[i14];
            }
            int i15 = 0;
            while (i15 < this.blockSampleCount) {
                long j13 = this.blockTimeUs + ((long) ((track4.defaultSampleDurationNs * i15) / 1000));
                int i16 = this.blockFlags;
                if (i15 == 0 && !this.blockHasReferenceBlock) {
                    i16 |= 1;
                }
                int i17 = this.blockSampleSizes[i15];
                int i18 = i13 - i17;
                commitSampleToOutput(track4, j13, i16, i17, i18);
                i15++;
                i13 = i18;
            }
            this.blockState = 0;
        }
    }

    @CallSuper
    public void floatElement(int i11, double d11) throws ParserException {
        if (i11 == 181) {
            getCurrentTrack(i11).sampleRate = (int) d11;
        } else if (i11 != ID_DURATION) {
            switch (i11) {
                case ID_PRIMARY_R_CHROMATICITY_X /*21969*/:
                    getCurrentTrack(i11).primaryRChromaticityX = (float) d11;
                    return;
                case ID_PRIMARY_R_CHROMATICITY_Y /*21970*/:
                    getCurrentTrack(i11).primaryRChromaticityY = (float) d11;
                    return;
                case ID_PRIMARY_G_CHROMATICITY_X /*21971*/:
                    getCurrentTrack(i11).primaryGChromaticityX = (float) d11;
                    return;
                case ID_PRIMARY_G_CHROMATICITY_Y /*21972*/:
                    getCurrentTrack(i11).primaryGChromaticityY = (float) d11;
                    return;
                case ID_PRIMARY_B_CHROMATICITY_X /*21973*/:
                    getCurrentTrack(i11).primaryBChromaticityX = (float) d11;
                    return;
                case ID_PRIMARY_B_CHROMATICITY_Y /*21974*/:
                    getCurrentTrack(i11).primaryBChromaticityY = (float) d11;
                    return;
                case ID_WHITE_POINT_CHROMATICITY_X /*21975*/:
                    getCurrentTrack(i11).whitePointChromaticityX = (float) d11;
                    return;
                case ID_WHITE_POINT_CHROMATICITY_Y /*21976*/:
                    getCurrentTrack(i11).whitePointChromaticityY = (float) d11;
                    return;
                case ID_LUMNINANCE_MAX /*21977*/:
                    getCurrentTrack(i11).maxMasteringLuminance = (float) d11;
                    return;
                case ID_LUMNINANCE_MIN /*21978*/:
                    getCurrentTrack(i11).minMasteringLuminance = (float) d11;
                    return;
                default:
                    switch (i11) {
                        case ID_PROJECTION_POSE_YAW /*30323*/:
                            getCurrentTrack(i11).projectionPoseYaw = (float) d11;
                            return;
                        case ID_PROJECTION_POSE_PITCH /*30324*/:
                            getCurrentTrack(i11).projectionPosePitch = (float) d11;
                            return;
                        case ID_PROJECTION_POSE_ROLL /*30325*/:
                            getCurrentTrack(i11).projectionPoseRoll = (float) d11;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.durationTimecode = (long) d11;
        }
    }

    public Track getCurrentTrack(int i11) throws ParserException {
        assertInTrackEntry(i11);
        return this.currentTrack;
    }

    @CallSuper
    public int getElementType(int i11) {
        switch (i11) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case ID_TRACK_NUMBER /*215*/:
            case ID_TIME_CODE /*231*/:
            case ID_BLOCK_ADD_ID /*238*/:
            case ID_CUE_CLUSTER_POSITION /*241*/:
            case ID_REFERENCE_BLOCK /*251*/:
            case ID_BLOCK_ADD_ID_TYPE /*16871*/:
            case ID_CONTENT_COMPRESSION_ALGORITHM /*16980*/:
            case ID_DOC_TYPE_READ_VERSION /*17029*/:
            case ID_EBML_READ_VERSION /*17143*/:
            case ID_CONTENT_ENCRYPTION_ALGORITHM /*18401*/:
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /*18408*/:
            case ID_CONTENT_ENCODING_ORDER /*20529*/:
            case ID_CONTENT_ENCODING_SCOPE /*20530*/:
            case ID_SEEK_POSITION /*21420*/:
            case ID_STEREO_MODE /*21432*/:
            case ID_DISPLAY_WIDTH /*21680*/:
            case ID_DISPLAY_UNIT /*21682*/:
            case ID_DISPLAY_HEIGHT /*21690*/:
            case ID_FLAG_FORCED /*21930*/:
            case ID_COLOUR_RANGE /*21945*/:
            case ID_COLOUR_TRANSFER /*21946*/:
            case ID_COLOUR_PRIMARIES /*21947*/:
            case ID_MAX_CLL /*21948*/:
            case ID_MAX_FALL /*21949*/:
            case ID_MAX_BLOCK_ADDITION_ID /*21998*/:
            case ID_CODEC_DELAY /*22186*/:
            case ID_SEEK_PRE_ROLL /*22203*/:
            case ID_AUDIO_BIT_DEPTH /*25188*/:
            case ID_DISCARD_PADDING /*30114*/:
            case ID_PROJECTION_TYPE /*30321*/:
            case ID_DEFAULT_DURATION /*2352003*/:
            case ID_TIMECODE_SCALE /*2807729*/:
                return 2;
            case 134:
            case 17026:
            case ID_NAME /*21358*/:
            case ID_LANGUAGE /*2274716*/:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case ID_AUDIO /*225*/:
            case ID_BLOCK_ADDITION_MAPPING /*16868*/:
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS /*18407*/:
            case ID_SEEK /*19899*/:
            case ID_CONTENT_COMPRESSION /*20532*/:
            case ID_CONTENT_ENCRYPTION /*20533*/:
            case ID_COLOUR /*21936*/:
            case ID_MASTERING_METADATA /*21968*/:
            case ID_CONTENT_ENCODING /*25152*/:
            case ID_CONTENT_ENCODINGS /*28032*/:
            case ID_BLOCK_ADDITIONS /*30113*/:
            case ID_PROJECTION /*30320*/:
            case ID_SEEK_HEAD /*290298740*/:
            case 357149030:
            case ID_TRACKS /*374648427*/:
            case ID_SEGMENT /*408125543*/:
            case ID_EBML /*440786851*/:
            case ID_CUES /*475249515*/:
            case ID_CLUSTER /*524531317*/:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case ID_CONTENT_COMPRESSION_SETTINGS /*16981*/:
            case ID_CONTENT_ENCRYPTION_KEY_ID /*18402*/:
            case ID_SEEK_ID /*21419*/:
            case ID_CODEC_PRIVATE /*25506*/:
            case ID_PROJECTION_PRIVATE /*30322*/:
                return 4;
            case 181:
            case ID_DURATION /*17545*/:
            case ID_PRIMARY_R_CHROMATICITY_X /*21969*/:
            case ID_PRIMARY_R_CHROMATICITY_Y /*21970*/:
            case ID_PRIMARY_G_CHROMATICITY_X /*21971*/:
            case ID_PRIMARY_G_CHROMATICITY_Y /*21972*/:
            case ID_PRIMARY_B_CHROMATICITY_X /*21973*/:
            case ID_PRIMARY_B_CHROMATICITY_Y /*21974*/:
            case ID_WHITE_POINT_CHROMATICITY_X /*21975*/:
            case ID_WHITE_POINT_CHROMATICITY_Y /*21976*/:
            case ID_LUMNINANCE_MAX /*21977*/:
            case ID_LUMNINANCE_MIN /*21978*/:
            case ID_PROJECTION_POSE_YAW /*30323*/:
            case ID_PROJECTION_POSE_PITCH /*30324*/:
            case ID_PROJECTION_POSE_ROLL /*30325*/:
                return 5;
            default:
                return 0;
        }
    }

    public void handleBlockAddIDExtraData(Track track, ExtractorInput extractorInput, int i11) throws IOException {
        if (track.blockAddIdType == 1685485123 || track.blockAddIdType == 1685480259) {
            byte[] bArr = new byte[i11];
            track.dolbyVisionConfigBytes = bArr;
            extractorInput.readFully(bArr, 0, i11);
            return;
        }
        extractorInput.skipFully(i11);
    }

    public void handleBlockAdditionalData(Track track, int i11, ExtractorInput extractorInput, int i12) throws IOException {
        if (i11 != 4 || !CODEC_ID_VP9.equals(track.codecId)) {
            extractorInput.skipFully(i12);
            return;
        }
        this.supplementalData.reset(i12);
        extractorInput.readFully(this.supplementalData.getData(), 0, i12);
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
    }

    @CallSuper
    public void integerElement(int i11, long j11) throws ParserException {
        if (i11 != ID_CONTENT_ENCODING_ORDER) {
            if (i11 != ID_CONTENT_ENCODING_SCOPE) {
                boolean z11 = false;
                switch (i11) {
                    case 131:
                        getCurrentTrack(i11).type = (int) j11;
                        return;
                    case 136:
                        Track currentTrack2 = getCurrentTrack(i11);
                        if (j11 == 1) {
                            z11 = true;
                        }
                        currentTrack2.flagDefault = z11;
                        return;
                    case 155:
                        this.blockDurationUs = scaleTimecodeToUs(j11);
                        return;
                    case 159:
                        getCurrentTrack(i11).channelCount = (int) j11;
                        return;
                    case 176:
                        getCurrentTrack(i11).width = (int) j11;
                        return;
                    case 179:
                        assertInCues(i11);
                        this.cueTimesUs.add(scaleTimecodeToUs(j11));
                        return;
                    case 186:
                        getCurrentTrack(i11).height = (int) j11;
                        return;
                    case ID_TRACK_NUMBER /*215*/:
                        getCurrentTrack(i11).number = (int) j11;
                        return;
                    case ID_TIME_CODE /*231*/:
                        this.clusterTimecodeUs = scaleTimecodeToUs(j11);
                        return;
                    case ID_BLOCK_ADD_ID /*238*/:
                        this.blockAdditionalId = (int) j11;
                        return;
                    case ID_CUE_CLUSTER_POSITION /*241*/:
                        if (!this.seenClusterPositionForCurrentCuePoint) {
                            assertInCues(i11);
                            this.cueClusterPositions.add(j11);
                            this.seenClusterPositionForCurrentCuePoint = true;
                            return;
                        }
                        return;
                    case ID_REFERENCE_BLOCK /*251*/:
                        this.blockHasReferenceBlock = true;
                        return;
                    case ID_BLOCK_ADD_ID_TYPE /*16871*/:
                        int unused = getCurrentTrack(i11).blockAddIdType = (int) j11;
                        return;
                    case ID_CONTENT_COMPRESSION_ALGORITHM /*16980*/:
                        if (j11 != 3) {
                            throw ParserException.createForMalformedContainer("ContentCompAlgo " + j11 + " not supported", (Throwable) null);
                        }
                        return;
                    case ID_DOC_TYPE_READ_VERSION /*17029*/:
                        if (j11 < 1 || j11 > 2) {
                            throw ParserException.createForMalformedContainer("DocTypeReadVersion " + j11 + " not supported", (Throwable) null);
                        }
                        return;
                    case ID_EBML_READ_VERSION /*17143*/:
                        if (j11 != 1) {
                            throw ParserException.createForMalformedContainer("EBMLReadVersion " + j11 + " not supported", (Throwable) null);
                        }
                        return;
                    case ID_CONTENT_ENCRYPTION_ALGORITHM /*18401*/:
                        if (j11 != 5) {
                            throw ParserException.createForMalformedContainer("ContentEncAlgo " + j11 + " not supported", (Throwable) null);
                        }
                        return;
                    case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /*18408*/:
                        if (j11 != 1) {
                            throw ParserException.createForMalformedContainer("AESSettingsCipherMode " + j11 + " not supported", (Throwable) null);
                        }
                        return;
                    case ID_SEEK_POSITION /*21420*/:
                        this.seekEntryPosition = j11 + this.segmentContentPosition;
                        return;
                    case ID_STEREO_MODE /*21432*/:
                        int i12 = (int) j11;
                        assertInTrackEntry(i11);
                        if (i12 == 0) {
                            this.currentTrack.stereoMode = 0;
                            return;
                        } else if (i12 == 1) {
                            this.currentTrack.stereoMode = 2;
                            return;
                        } else if (i12 == 3) {
                            this.currentTrack.stereoMode = 1;
                            return;
                        } else if (i12 == 15) {
                            this.currentTrack.stereoMode = 3;
                            return;
                        } else {
                            return;
                        }
                    case ID_DISPLAY_WIDTH /*21680*/:
                        getCurrentTrack(i11).displayWidth = (int) j11;
                        return;
                    case ID_DISPLAY_UNIT /*21682*/:
                        getCurrentTrack(i11).displayUnit = (int) j11;
                        return;
                    case ID_DISPLAY_HEIGHT /*21690*/:
                        getCurrentTrack(i11).displayHeight = (int) j11;
                        return;
                    case ID_FLAG_FORCED /*21930*/:
                        Track currentTrack3 = getCurrentTrack(i11);
                        if (j11 == 1) {
                            z11 = true;
                        }
                        currentTrack3.flagForced = z11;
                        return;
                    case ID_MAX_BLOCK_ADDITION_ID /*21998*/:
                        getCurrentTrack(i11).maxBlockAdditionId = (int) j11;
                        return;
                    case ID_CODEC_DELAY /*22186*/:
                        getCurrentTrack(i11).codecDelayNs = j11;
                        return;
                    case ID_SEEK_PRE_ROLL /*22203*/:
                        getCurrentTrack(i11).seekPreRollNs = j11;
                        return;
                    case ID_AUDIO_BIT_DEPTH /*25188*/:
                        getCurrentTrack(i11).audioBitDepth = (int) j11;
                        return;
                    case ID_DISCARD_PADDING /*30114*/:
                        this.blockGroupDiscardPaddingNs = j11;
                        return;
                    case ID_PROJECTION_TYPE /*30321*/:
                        assertInTrackEntry(i11);
                        int i13 = (int) j11;
                        if (i13 == 0) {
                            this.currentTrack.projectionType = 0;
                            return;
                        } else if (i13 == 1) {
                            this.currentTrack.projectionType = 1;
                            return;
                        } else if (i13 == 2) {
                            this.currentTrack.projectionType = 2;
                            return;
                        } else if (i13 == 3) {
                            this.currentTrack.projectionType = 3;
                            return;
                        } else {
                            return;
                        }
                    case ID_DEFAULT_DURATION /*2352003*/:
                        getCurrentTrack(i11).defaultSampleDurationNs = (int) j11;
                        return;
                    case ID_TIMECODE_SCALE /*2807729*/:
                        this.timecodeScale = j11;
                        return;
                    default:
                        switch (i11) {
                            case ID_COLOUR_RANGE /*21945*/:
                                assertInTrackEntry(i11);
                                int i14 = (int) j11;
                                if (i14 == 1) {
                                    this.currentTrack.colorRange = 2;
                                    return;
                                } else if (i14 == 2) {
                                    this.currentTrack.colorRange = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case ID_COLOUR_TRANSFER /*21946*/:
                                assertInTrackEntry(i11);
                                int isoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer((int) j11);
                                if (isoTransferCharacteristicsToColorTransfer != -1) {
                                    this.currentTrack.colorTransfer = isoTransferCharacteristicsToColorTransfer;
                                    return;
                                }
                                return;
                            case ID_COLOUR_PRIMARIES /*21947*/:
                                assertInTrackEntry(i11);
                                this.currentTrack.hasColorInfo = true;
                                int isoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace((int) j11);
                                if (isoColorPrimariesToColorSpace != -1) {
                                    this.currentTrack.colorSpace = isoColorPrimariesToColorSpace;
                                    return;
                                }
                                return;
                            case ID_MAX_CLL /*21948*/:
                                getCurrentTrack(i11).maxContentLuminance = (int) j11;
                                return;
                            case ID_MAX_FALL /*21949*/:
                                getCurrentTrack(i11).maxFrameAverageLuminance = (int) j11;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j11 != 1) {
                throw ParserException.createForMalformedContainer("ContentEncodingScope " + j11 + " not supported", (Throwable) null);
            }
        } else if (j11 != 0) {
            throw ParserException.createForMalformedContainer("ContentEncodingOrder " + j11 + " not supported", (Throwable) null);
        }
    }

    @CallSuper
    public boolean isLevel1Element(int i11) {
        return i11 == 357149030 || i11 == ID_CLUSTER || i11 == ID_CUES || i11 == ID_TRACKS;
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        this.haveOutputSample = false;
        boolean z11 = true;
        while (z11 && !this.haveOutputSample) {
            z11 = this.reader.read(extractorInput);
            if (z11 && maybeSeekForCues(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z11) {
            return 0;
        }
        for (int i11 = 0; i11 < this.tracks.size(); i11++) {
            Track valueAt = this.tracks.valueAt(i11);
            valueAt.assertOutputInitialized();
            valueAt.outputPendingSampleMetadata();
        }
        return -1;
    }

    public final void release() {
    }

    @CallSuper
    public void seek(long j11, long j12) {
        this.clusterTimecodeUs = C.TIME_UNSET;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        resetWriteSampleData();
        for (int i11 = 0; i11 < this.tracks.size(); i11++) {
            this.tracks.valueAt(i11).reset();
        }
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        return new Sniffer().sniff(extractorInput);
    }

    @CallSuper
    public void startMasterElement(int i11, long j11, long j12) throws ParserException {
        assertInitialized();
        if (i11 == 160) {
            this.blockHasReferenceBlock = false;
            this.blockGroupDiscardPaddingNs = 0;
        } else if (i11 == 174) {
            this.currentTrack = new Track();
        } else if (i11 == 187) {
            this.seenClusterPositionForCurrentCuePoint = false;
        } else if (i11 == ID_SEEK) {
            this.seekEntryId = -1;
            this.seekEntryPosition = -1;
        } else if (i11 == ID_CONTENT_ENCRYPTION) {
            getCurrentTrack(i11).hasContentEncryption = true;
        } else if (i11 == ID_MASTERING_METADATA) {
            getCurrentTrack(i11).hasColorInfo = true;
        } else if (i11 == ID_SEGMENT) {
            long j13 = this.segmentContentPosition;
            if (j13 == -1 || j13 == j11) {
                this.segmentContentPosition = j11;
                this.segmentContentSize = j12;
                return;
            }
            throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", (Throwable) null);
        } else if (i11 == ID_CUES) {
            this.cueTimesUs = new LongArray();
            this.cueClusterPositions = new LongArray();
        } else if (i11 != ID_CLUSTER || this.sentSeekMap) {
        } else {
            if (!this.seekForCuesEnabled || this.cuesContentPosition == -1) {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                this.sentSeekMap = true;
                return;
            }
            this.seekForCues = true;
        }
    }

    @CallSuper
    public void stringElement(int i11, String str) throws ParserException {
        if (i11 == 134) {
            getCurrentTrack(i11).codecId = str;
        } else if (i11 != 17026) {
            if (i11 == ID_NAME) {
                getCurrentTrack(i11).f34933name = str;
            } else if (i11 == ID_LANGUAGE) {
                String unused = getCurrentTrack(i11).language = str;
            }
        } else if (!DOC_TYPE_WEBM.equals(str) && !DOC_TYPE_MATROSKA.equals(str)) {
            throw ParserException.createForMalformedContainer("DocType " + str + " not supported", (Throwable) null);
        }
    }

    public MatroskaExtractor(int i11) {
        this(new DefaultEbmlReader(), i11);
    }

    public MatroskaExtractor(EbmlReader ebmlReader, int i11) {
        this.segmentContentPosition = -1;
        this.timecodeScale = C.TIME_UNSET;
        this.durationTimecode = C.TIME_UNSET;
        this.durationUs = C.TIME_UNSET;
        this.cuesContentPosition = -1;
        this.seekPositionAfterBuildingCues = -1;
        this.clusterTimecodeUs = C.TIME_UNSET;
        this.reader = ebmlReader;
        ebmlReader.init(new InnerEbmlProcessor());
        this.seekForCuesEnabled = (i11 & 1) == 0;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray<>();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
        this.supplementalData = new ParsableByteArray();
        this.blockSampleSizes = new int[1];
    }
}
