package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.gms.common.Scopes;
import com.google.common.collect.ImmutableList;
import com.huawei.hms.flutter.map.constants.Param;
import io.flutter.plugin.platform.PlatformPlugin;
import java.nio.ByteBuffer;
import java.util.List;

public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final int HEVC_MAX_INPUT_SIZE_THRESHOLD = 2097152;
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, PlatformPlugin.DEFAULT_SYSTEM_UI, 960, 854, 640, 540, 480};
    private static final String TAG = "MediaCodecVideoRenderer";
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = Long.MAX_VALUE;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    @Nullable
    private VideoFrameMetadataListener frameMetadataListener;
    private final VideoFrameReleaseHelper frameReleaseHelper;
    private boolean haveReportedFirstFrameRenderedForCurrentSurface;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastBufferPresentationTimeUs;
    private long lastFrameReleaseTimeNs;
    private long lastRenderRealtimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    @Nullable
    private PlaceholderSurface placeholderSurface;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    @Nullable
    private VideoSize reportedVideoSize;
    private int scalingMode;
    @Nullable
    private Surface surface;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    @Nullable
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private int videoFrameProcessingOffsetCount;

    @RequiresApi(26)
    public static final class Api26 {
        private Api26() {
        }

        @DoNotInline
        public static boolean doesDisplaySupportDolbyVision(Context context) {
            Display display;
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                display = displayManager.getDisplay(0);
            } else {
                display = null;
            }
            if (display == null || !display.isHdr()) {
                return false;
            }
            for (int i11 : display.getHdrCapabilities().getSupportedHdrTypes()) {
                if (i11 == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i11, int i12, int i13) {
            this.width = i11;
            this.height = i12;
            this.inputSize = i13;
        }
    }

    @RequiresApi(23)
    public final class OnFrameRenderedListenerV23 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {
        private static final int HANDLE_FRAME_RENDERED = 0;
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler createHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
            this.handler = createHandlerForCurrentLooper;
            mediaCodecAdapter.setOnFrameRenderedListener(this, createHandlerForCurrentLooper);
        }

        private void handleFrameRendered(long j11) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this == mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener && mediaCodecVideoRenderer.getCodec() != null) {
                if (j11 == Long.MAX_VALUE) {
                    MediaCodecVideoRenderer.this.onProcessedTunneledEndOfStream();
                    return;
                }
                try {
                    MediaCodecVideoRenderer.this.onProcessedTunneledBuffer(j11);
                } catch (ExoPlaybackException e11) {
                    MediaCodecVideoRenderer.this.setPendingPlaybackException(e11);
                }
            }
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        public void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j11, long j12) {
            if (Util.SDK_INT < 30) {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (j11 >> 32), (int) j11));
                return;
            }
            handleFrameRendered(j11);
        }
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector) {
        this(context2, mediaCodecSelector, 0);
    }

    private void clearRenderedFirstFrame() {
        MediaCodecAdapter codec;
        this.renderedFirstFrameAfterReset = false;
        if (Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedVideoSize = null;
    }

    @RequiresApi(21)
    private static void configureTunnelingV21(MediaFormat mediaFormat, int i11) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i11);
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Util.MANUFACTURER);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:469:0x0844, code lost:
        if (r0.equals("PGN528") == false) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:494:0x08aa, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean evaluateDeviceNeedsSetOutputSurfaceWorkaround() {
        /*
            int r0 = com.google.android.exoplayer2.util.Util.SDK_INT
            r1 = 7
            r2 = 6
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = -1
            r8 = 0
            r9 = 1
            r10 = 28
            if (r0 > r10) goto L_0x007a
            java.lang.String r11 = com.google.android.exoplayer2.util.Util.DEVICE
            r11.hashCode()
            int r12 = r11.hashCode()
            switch(r12) {
                case -1339091551: goto L_0x006b;
                case -1220081023: goto L_0x0060;
                case -1220066608: goto L_0x0055;
                case -1012436106: goto L_0x004a;
                case -760312546: goto L_0x003f;
                case -64886864: goto L_0x0034;
                case 3415681: goto L_0x0029;
                case 825323514: goto L_0x001e;
                default: goto L_0x001b;
            }
        L_0x001b:
            r11 = r7
            goto L_0x0075
        L_0x001e:
            java.lang.String r12 = "machuca"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0027
            goto L_0x001b
        L_0x0027:
            r11 = r1
            goto L_0x0075
        L_0x0029:
            java.lang.String r12 = "once"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0032
            goto L_0x001b
        L_0x0032:
            r11 = r2
            goto L_0x0075
        L_0x0034:
            java.lang.String r12 = "magnolia"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x003d
            goto L_0x001b
        L_0x003d:
            r11 = r3
            goto L_0x0075
        L_0x003f:
            java.lang.String r12 = "aquaman"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0048
            goto L_0x001b
        L_0x0048:
            r11 = r4
            goto L_0x0075
        L_0x004a:
            java.lang.String r12 = "oneday"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0053
            goto L_0x001b
        L_0x0053:
            r11 = r5
            goto L_0x0075
        L_0x0055:
            java.lang.String r12 = "dangalUHD"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x005e
            goto L_0x001b
        L_0x005e:
            r11 = r6
            goto L_0x0075
        L_0x0060:
            java.lang.String r12 = "dangalFHD"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0069
            goto L_0x001b
        L_0x0069:
            r11 = r9
            goto L_0x0075
        L_0x006b:
            java.lang.String r12 = "dangal"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0074
            goto L_0x001b
        L_0x0074:
            r11 = r8
        L_0x0075:
            switch(r11) {
                case 0: goto L_0x0079;
                case 1: goto L_0x0079;
                case 2: goto L_0x0079;
                case 3: goto L_0x0079;
                case 4: goto L_0x0079;
                case 5: goto L_0x0079;
                case 6: goto L_0x0079;
                case 7: goto L_0x0079;
                default: goto L_0x0078;
            }
        L_0x0078:
            goto L_0x007a
        L_0x0079:
            return r9
        L_0x007a:
            r11 = 27
            if (r0 > r11) goto L_0x0089
            java.lang.String r12 = "HWEML"
            java.lang.String r13 = com.google.android.exoplayer2.util.Util.DEVICE
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x0089
            return r9
        L_0x0089:
            java.lang.String r12 = com.google.android.exoplayer2.util.Util.MODEL
            r12.hashCode()
            int r13 = r12.hashCode()
            r14 = 8
            switch(r13) {
                case -349662828: goto L_0x00f3;
                case -321033677: goto L_0x00e8;
                case 2006354: goto L_0x00dd;
                case 2006367: goto L_0x00d2;
                case 2006371: goto L_0x00c7;
                case 1785421873: goto L_0x00bc;
                case 1785421876: goto L_0x00b1;
                case 1798172390: goto L_0x00a6;
                case 2119412532: goto L_0x009a;
                default: goto L_0x0097;
            }
        L_0x0097:
            r13 = r7
            goto L_0x00fd
        L_0x009a:
            java.lang.String r13 = "AFTEUFF014"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00a3
            goto L_0x0097
        L_0x00a3:
            r13 = r14
            goto L_0x00fd
        L_0x00a6:
            java.lang.String r13 = "AFTSO001"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00af
            goto L_0x0097
        L_0x00af:
            r13 = r1
            goto L_0x00fd
        L_0x00b1:
            java.lang.String r13 = "AFTEU014"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00ba
            goto L_0x0097
        L_0x00ba:
            r13 = r2
            goto L_0x00fd
        L_0x00bc:
            java.lang.String r13 = "AFTEU011"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00c5
            goto L_0x0097
        L_0x00c5:
            r13 = r3
            goto L_0x00fd
        L_0x00c7:
            java.lang.String r13 = "AFTR"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00d0
            goto L_0x0097
        L_0x00d0:
            r13 = r4
            goto L_0x00fd
        L_0x00d2:
            java.lang.String r13 = "AFTN"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00db
            goto L_0x0097
        L_0x00db:
            r13 = r5
            goto L_0x00fd
        L_0x00dd:
            java.lang.String r13 = "AFTA"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00e6
            goto L_0x0097
        L_0x00e6:
            r13 = r6
            goto L_0x00fd
        L_0x00e8:
            java.lang.String r13 = "AFTKMST12"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00f1
            goto L_0x0097
        L_0x00f1:
            r13 = r9
            goto L_0x00fd
        L_0x00f3:
            java.lang.String r13 = "AFTJMST12"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00fc
            goto L_0x0097
        L_0x00fc:
            r13 = r8
        L_0x00fd:
            switch(r13) {
                case 0: goto L_0x08ac;
                case 1: goto L_0x08ac;
                case 2: goto L_0x08ac;
                case 3: goto L_0x08ac;
                case 4: goto L_0x08ac;
                case 5: goto L_0x08ac;
                case 6: goto L_0x08ac;
                case 7: goto L_0x08ac;
                case 8: goto L_0x08ac;
                default: goto L_0x0100;
            }
        L_0x0100:
            r13 = 26
            if (r0 > r13) goto L_0x08ab
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.DEVICE
            r0.hashCode()
            int r15 = r0.hashCode()
            switch(r15) {
                case -2144781245: goto L_0x0890;
                case -2144781185: goto L_0x0884;
                case -2144781160: goto L_0x0878;
                case -2097309513: goto L_0x086c;
                case -2022874474: goto L_0x0860;
                case -1978993182: goto L_0x0854;
                case -1978990237: goto L_0x0848;
                case -1936688988: goto L_0x083e;
                case -1936688066: goto L_0x0831;
                case -1936688065: goto L_0x0823;
                case -1931988508: goto L_0x0815;
                case -1885099851: goto L_0x0807;
                case -1696512866: goto L_0x07f9;
                case -1680025915: goto L_0x07eb;
                case -1615810839: goto L_0x07dd;
                case -1600724499: goto L_0x07cf;
                case -1554255044: goto L_0x07c1;
                case -1481772737: goto L_0x07b3;
                case -1481772730: goto L_0x07a5;
                case -1481772729: goto L_0x0797;
                case -1320080169: goto L_0x0789;
                case -1217592143: goto L_0x077b;
                case -1180384755: goto L_0x076d;
                case -1139198265: goto L_0x075f;
                case -1052835013: goto L_0x0751;
                case -993250464: goto L_0x0743;
                case -993250458: goto L_0x0736;
                case -965403638: goto L_0x0729;
                case -958336948: goto L_0x071c;
                case -879245230: goto L_0x070e;
                case -842500323: goto L_0x0700;
                case -821392978: goto L_0x06f2;
                case -797483286: goto L_0x06e4;
                case -794946968: goto L_0x06d6;
                case -788334647: goto L_0x06c8;
                case -782144577: goto L_0x06ba;
                case -575125681: goto L_0x06ac;
                case -521118391: goto L_0x069e;
                case -430914369: goto L_0x0690;
                case -290434366: goto L_0x0682;
                case -282781963: goto L_0x0674;
                case -277133239: goto L_0x0666;
                case -173639913: goto L_0x0658;
                case -56598463: goto L_0x064a;
                case 2126: goto L_0x063c;
                case 2564: goto L_0x062e;
                case 2715: goto L_0x0620;
                case 2719: goto L_0x0612;
                case 3091: goto L_0x0604;
                case 3483: goto L_0x05f6;
                case 73405: goto L_0x05e8;
                case 75537: goto L_0x05da;
                case 75739: goto L_0x05cc;
                case 76779: goto L_0x05be;
                case 78669: goto L_0x05b0;
                case 79305: goto L_0x05a2;
                case 80618: goto L_0x0594;
                case 88274: goto L_0x0586;
                case 98846: goto L_0x0578;
                case 98848: goto L_0x056a;
                case 99329: goto L_0x055c;
                case 101481: goto L_0x054e;
                case 1513190: goto L_0x0540;
                case 1514184: goto L_0x0532;
                case 1514185: goto L_0x0524;
                case 2133089: goto L_0x0516;
                case 2133091: goto L_0x0508;
                case 2133120: goto L_0x04fa;
                case 2133151: goto L_0x04ec;
                case 2133182: goto L_0x04de;
                case 2133184: goto L_0x04d0;
                case 2436959: goto L_0x04c2;
                case 2463773: goto L_0x04b4;
                case 2464648: goto L_0x04a6;
                case 2689555: goto L_0x0498;
                case 3154429: goto L_0x048a;
                case 3284551: goto L_0x047c;
                case 3351335: goto L_0x046e;
                case 3386211: goto L_0x0460;
                case 41325051: goto L_0x0452;
                case 51349633: goto L_0x0444;
                case 51350594: goto L_0x0436;
                case 55178625: goto L_0x0428;
                case 61542055: goto L_0x041a;
                case 65355429: goto L_0x040c;
                case 66214468: goto L_0x03fe;
                case 66214470: goto L_0x03f0;
                case 66214473: goto L_0x03e2;
                case 66215429: goto L_0x03d4;
                case 66215431: goto L_0x03c6;
                case 66215433: goto L_0x03b8;
                case 66216390: goto L_0x03aa;
                case 76402249: goto L_0x039c;
                case 76404105: goto L_0x038e;
                case 76404911: goto L_0x0380;
                case 80963634: goto L_0x0372;
                case 82882791: goto L_0x0364;
                case 98715550: goto L_0x0356;
                case 101370885: goto L_0x0348;
                case 102844228: goto L_0x033a;
                case 165221241: goto L_0x032c;
                case 182191441: goto L_0x031e;
                case 245388979: goto L_0x0310;
                case 287431619: goto L_0x0302;
                case 307593612: goto L_0x02f4;
                case 308517133: goto L_0x02e6;
                case 316215098: goto L_0x02d8;
                case 316215116: goto L_0x02ca;
                case 316246811: goto L_0x02bc;
                case 316246818: goto L_0x02ae;
                case 407160593: goto L_0x02a0;
                case 507412548: goto L_0x0292;
                case 793982701: goto L_0x0284;
                case 794038622: goto L_0x0276;
                case 794040393: goto L_0x0268;
                case 835649806: goto L_0x025a;
                case 917340916: goto L_0x024c;
                case 958008161: goto L_0x023e;
                case 1060579533: goto L_0x0230;
                case 1150207623: goto L_0x0222;
                case 1176899427: goto L_0x0214;
                case 1280332038: goto L_0x0206;
                case 1306947716: goto L_0x01f8;
                case 1349174697: goto L_0x01ea;
                case 1522194893: goto L_0x01dc;
                case 1691543273: goto L_0x01ce;
                case 1691544261: goto L_0x01c0;
                case 1709443163: goto L_0x01b2;
                case 1865889110: goto L_0x01a4;
                case 1906253259: goto L_0x0196;
                case 1977196784: goto L_0x0188;
                case 2006372676: goto L_0x017b;
                case 2019281702: goto L_0x016e;
                case 2029784656: goto L_0x0161;
                case 2030379515: goto L_0x0154;
                case 2033393791: goto L_0x0147;
                case 2047190025: goto L_0x013a;
                case 2047252157: goto L_0x012d;
                case 2048319463: goto L_0x0120;
                case 2048855701: goto L_0x0113;
                default: goto L_0x0110;
            }
        L_0x0110:
            r1 = r7
            goto L_0x089b
        L_0x0113:
            java.lang.String r1 = "HWWAS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x011c
            goto L_0x0110
        L_0x011c:
            r1 = 139(0x8b, float:1.95E-43)
            goto L_0x089b
        L_0x0120:
            java.lang.String r1 = "HWVNS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0129
            goto L_0x0110
        L_0x0129:
            r1 = 138(0x8a, float:1.93E-43)
            goto L_0x089b
        L_0x012d:
            java.lang.String r1 = "ELUGA_Prim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0136
            goto L_0x0110
        L_0x0136:
            r1 = 137(0x89, float:1.92E-43)
            goto L_0x089b
        L_0x013a:
            java.lang.String r1 = "ELUGA_Note"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0143
            goto L_0x0110
        L_0x0143:
            r1 = 136(0x88, float:1.9E-43)
            goto L_0x089b
        L_0x0147:
            java.lang.String r1 = "ASUS_X00AD_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0150
            goto L_0x0110
        L_0x0150:
            r1 = 135(0x87, float:1.89E-43)
            goto L_0x089b
        L_0x0154:
            java.lang.String r1 = "HWCAM-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x015d
            goto L_0x0110
        L_0x015d:
            r1 = 134(0x86, float:1.88E-43)
            goto L_0x089b
        L_0x0161:
            java.lang.String r1 = "HWBLN-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x016a
            goto L_0x0110
        L_0x016a:
            r1 = 133(0x85, float:1.86E-43)
            goto L_0x089b
        L_0x016e:
            java.lang.String r1 = "DM-01K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0177
            goto L_0x0110
        L_0x0177:
            r1 = 132(0x84, float:1.85E-43)
            goto L_0x089b
        L_0x017b:
            java.lang.String r1 = "BRAVIA_ATV3_4K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0184
            goto L_0x0110
        L_0x0184:
            r1 = 131(0x83, float:1.84E-43)
            goto L_0x089b
        L_0x0188:
            java.lang.String r1 = "Infinix-X572"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0192
            goto L_0x0110
        L_0x0192:
            r1 = 130(0x82, float:1.82E-43)
            goto L_0x089b
        L_0x0196:
            java.lang.String r1 = "PB2-670M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01a0
            goto L_0x0110
        L_0x01a0:
            r1 = 129(0x81, float:1.81E-43)
            goto L_0x089b
        L_0x01a4:
            java.lang.String r1 = "santoni"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01ae
            goto L_0x0110
        L_0x01ae:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x089b
        L_0x01b2:
            java.lang.String r1 = "iball8735_9806"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01bc
            goto L_0x0110
        L_0x01bc:
            r1 = 127(0x7f, float:1.78E-43)
            goto L_0x089b
        L_0x01c0:
            java.lang.String r1 = "CPH1715"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01ca
            goto L_0x0110
        L_0x01ca:
            r1 = 126(0x7e, float:1.77E-43)
            goto L_0x089b
        L_0x01ce:
            java.lang.String r1 = "CPH1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01d8
            goto L_0x0110
        L_0x01d8:
            r1 = 125(0x7d, float:1.75E-43)
            goto L_0x089b
        L_0x01dc:
            java.lang.String r1 = "woods_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01e6
            goto L_0x0110
        L_0x01e6:
            r1 = 124(0x7c, float:1.74E-43)
            goto L_0x089b
        L_0x01ea:
            java.lang.String r1 = "htc_e56ml_dtul"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01f4
            goto L_0x0110
        L_0x01f4:
            r1 = 123(0x7b, float:1.72E-43)
            goto L_0x089b
        L_0x01f8:
            java.lang.String r1 = "EverStar_S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0202
            goto L_0x0110
        L_0x0202:
            r1 = 122(0x7a, float:1.71E-43)
            goto L_0x089b
        L_0x0206:
            java.lang.String r1 = "hwALE-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0210
            goto L_0x0110
        L_0x0210:
            r1 = 121(0x79, float:1.7E-43)
            goto L_0x089b
        L_0x0214:
            java.lang.String r1 = "itel_S41"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x021e
            goto L_0x0110
        L_0x021e:
            r1 = 120(0x78, float:1.68E-43)
            goto L_0x089b
        L_0x0222:
            java.lang.String r1 = "LS-5017"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x022c
            goto L_0x0110
        L_0x022c:
            r1 = 119(0x77, float:1.67E-43)
            goto L_0x089b
        L_0x0230:
            java.lang.String r1 = "panell_d"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x023a
            goto L_0x0110
        L_0x023a:
            r1 = 118(0x76, float:1.65E-43)
            goto L_0x089b
        L_0x023e:
            java.lang.String r1 = "j2xlteins"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0248
            goto L_0x0110
        L_0x0248:
            r1 = 117(0x75, float:1.64E-43)
            goto L_0x089b
        L_0x024c:
            java.lang.String r1 = "A7000plus"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0256
            goto L_0x0110
        L_0x0256:
            r1 = 116(0x74, float:1.63E-43)
            goto L_0x089b
        L_0x025a:
            java.lang.String r1 = "manning"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0264
            goto L_0x0110
        L_0x0264:
            r1 = 115(0x73, float:1.61E-43)
            goto L_0x089b
        L_0x0268:
            java.lang.String r1 = "GIONEE_WBL7519"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0272
            goto L_0x0110
        L_0x0272:
            r1 = 114(0x72, float:1.6E-43)
            goto L_0x089b
        L_0x0276:
            java.lang.String r1 = "GIONEE_WBL7365"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0280
            goto L_0x0110
        L_0x0280:
            r1 = 113(0x71, float:1.58E-43)
            goto L_0x089b
        L_0x0284:
            java.lang.String r1 = "GIONEE_WBL5708"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x028e
            goto L_0x0110
        L_0x028e:
            r1 = 112(0x70, float:1.57E-43)
            goto L_0x089b
        L_0x0292:
            java.lang.String r1 = "QM16XE_U"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x029c
            goto L_0x0110
        L_0x029c:
            r1 = 111(0x6f, float:1.56E-43)
            goto L_0x089b
        L_0x02a0:
            java.lang.String r1 = "Pixi5-10_4G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02aa
            goto L_0x0110
        L_0x02aa:
            r1 = 110(0x6e, float:1.54E-43)
            goto L_0x089b
        L_0x02ae:
            java.lang.String r1 = "TB3-850M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02b8
            goto L_0x0110
        L_0x02b8:
            r1 = 109(0x6d, float:1.53E-43)
            goto L_0x089b
        L_0x02bc:
            java.lang.String r1 = "TB3-850F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c6
            goto L_0x0110
        L_0x02c6:
            r1 = 108(0x6c, float:1.51E-43)
            goto L_0x089b
        L_0x02ca:
            java.lang.String r1 = "TB3-730X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02d4
            goto L_0x0110
        L_0x02d4:
            r1 = 107(0x6b, float:1.5E-43)
            goto L_0x089b
        L_0x02d8:
            java.lang.String r1 = "TB3-730F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02e2
            goto L_0x0110
        L_0x02e2:
            r1 = 106(0x6a, float:1.49E-43)
            goto L_0x089b
        L_0x02e6:
            java.lang.String r1 = "A7020a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02f0
            goto L_0x0110
        L_0x02f0:
            r1 = 105(0x69, float:1.47E-43)
            goto L_0x089b
        L_0x02f4:
            java.lang.String r1 = "A7010a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02fe
            goto L_0x0110
        L_0x02fe:
            r1 = 104(0x68, float:1.46E-43)
            goto L_0x089b
        L_0x0302:
            java.lang.String r1 = "griffin"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x030c
            goto L_0x0110
        L_0x030c:
            r1 = 103(0x67, float:1.44E-43)
            goto L_0x089b
        L_0x0310:
            java.lang.String r1 = "marino_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x031a
            goto L_0x0110
        L_0x031a:
            r1 = 102(0x66, float:1.43E-43)
            goto L_0x089b
        L_0x031e:
            java.lang.String r1 = "CPY83_I00"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0328
            goto L_0x0110
        L_0x0328:
            r1 = 101(0x65, float:1.42E-43)
            goto L_0x089b
        L_0x032c:
            java.lang.String r1 = "A2016a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0336
            goto L_0x0110
        L_0x0336:
            r1 = 100
            goto L_0x089b
        L_0x033a:
            java.lang.String r1 = "le_x6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0344
            goto L_0x0110
        L_0x0344:
            r1 = 99
            goto L_0x089b
        L_0x0348:
            java.lang.String r1 = "l5460"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0352
            goto L_0x0110
        L_0x0352:
            r1 = 98
            goto L_0x089b
        L_0x0356:
            java.lang.String r1 = "i9031"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0360
            goto L_0x0110
        L_0x0360:
            r1 = 97
            goto L_0x089b
        L_0x0364:
            java.lang.String r1 = "X3_HK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x036e
            goto L_0x0110
        L_0x036e:
            r1 = 96
            goto L_0x089b
        L_0x0372:
            java.lang.String r1 = "V23GB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x037c
            goto L_0x0110
        L_0x037c:
            r1 = 95
            goto L_0x089b
        L_0x0380:
            java.lang.String r1 = "Q4310"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x038a
            goto L_0x0110
        L_0x038a:
            r1 = 94
            goto L_0x089b
        L_0x038e:
            java.lang.String r1 = "Q4260"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0398
            goto L_0x0110
        L_0x0398:
            r1 = 93
            goto L_0x089b
        L_0x039c:
            java.lang.String r1 = "PRO7S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03a6
            goto L_0x0110
        L_0x03a6:
            r1 = 92
            goto L_0x089b
        L_0x03aa:
            java.lang.String r1 = "F3311"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03b4
            goto L_0x0110
        L_0x03b4:
            r1 = 91
            goto L_0x089b
        L_0x03b8:
            java.lang.String r1 = "F3215"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03c2
            goto L_0x0110
        L_0x03c2:
            r1 = 90
            goto L_0x089b
        L_0x03c6:
            java.lang.String r1 = "F3213"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03d0
            goto L_0x0110
        L_0x03d0:
            r1 = 89
            goto L_0x089b
        L_0x03d4:
            java.lang.String r1 = "F3211"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03de
            goto L_0x0110
        L_0x03de:
            r1 = 88
            goto L_0x089b
        L_0x03e2:
            java.lang.String r1 = "F3116"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03ec
            goto L_0x0110
        L_0x03ec:
            r1 = 87
            goto L_0x089b
        L_0x03f0:
            java.lang.String r1 = "F3113"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03fa
            goto L_0x0110
        L_0x03fa:
            r1 = 86
            goto L_0x089b
        L_0x03fe:
            java.lang.String r1 = "F3111"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0408
            goto L_0x0110
        L_0x0408:
            r1 = 85
            goto L_0x089b
        L_0x040c:
            java.lang.String r1 = "E5643"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0416
            goto L_0x0110
        L_0x0416:
            r1 = 84
            goto L_0x089b
        L_0x041a:
            java.lang.String r1 = "A1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0424
            goto L_0x0110
        L_0x0424:
            r1 = 83
            goto L_0x089b
        L_0x0428:
            java.lang.String r1 = "Aura_Note_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0432
            goto L_0x0110
        L_0x0432:
            r1 = 82
            goto L_0x089b
        L_0x0436:
            java.lang.String r1 = "602LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0440
            goto L_0x0110
        L_0x0440:
            r1 = 81
            goto L_0x089b
        L_0x0444:
            java.lang.String r1 = "601LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x044e
            goto L_0x0110
        L_0x044e:
            r1 = 80
            goto L_0x089b
        L_0x0452:
            java.lang.String r1 = "MEIZU_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x045c
            goto L_0x0110
        L_0x045c:
            r1 = 79
            goto L_0x089b
        L_0x0460:
            java.lang.String r1 = "p212"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x046a
            goto L_0x0110
        L_0x046a:
            r1 = 78
            goto L_0x089b
        L_0x046e:
            java.lang.String r1 = "mido"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0478
            goto L_0x0110
        L_0x0478:
            r1 = 77
            goto L_0x089b
        L_0x047c:
            java.lang.String r1 = "kate"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0486
            goto L_0x0110
        L_0x0486:
            r1 = 76
            goto L_0x089b
        L_0x048a:
            java.lang.String r1 = "fugu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0494
            goto L_0x0110
        L_0x0494:
            r1 = 75
            goto L_0x089b
        L_0x0498:
            java.lang.String r1 = "XE2X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04a2
            goto L_0x0110
        L_0x04a2:
            r1 = 74
            goto L_0x089b
        L_0x04a6:
            java.lang.String r1 = "Q427"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04b0
            goto L_0x0110
        L_0x04b0:
            r1 = 73
            goto L_0x089b
        L_0x04b4:
            java.lang.String r1 = "Q350"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04be
            goto L_0x0110
        L_0x04be:
            r1 = 72
            goto L_0x089b
        L_0x04c2:
            java.lang.String r1 = "P681"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04cc
            goto L_0x0110
        L_0x04cc:
            r1 = 71
            goto L_0x089b
        L_0x04d0:
            java.lang.String r1 = "F04J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04da
            goto L_0x0110
        L_0x04da:
            r1 = 70
            goto L_0x089b
        L_0x04de:
            java.lang.String r1 = "F04H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04e8
            goto L_0x0110
        L_0x04e8:
            r1 = 69
            goto L_0x089b
        L_0x04ec:
            java.lang.String r1 = "F03H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04f6
            goto L_0x0110
        L_0x04f6:
            r1 = 68
            goto L_0x089b
        L_0x04fa:
            java.lang.String r1 = "F02H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0504
            goto L_0x0110
        L_0x0504:
            r1 = 67
            goto L_0x089b
        L_0x0508:
            java.lang.String r1 = "F01J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0512
            goto L_0x0110
        L_0x0512:
            r1 = 66
            goto L_0x089b
        L_0x0516:
            java.lang.String r1 = "F01H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0520
            goto L_0x0110
        L_0x0520:
            r1 = 65
            goto L_0x089b
        L_0x0524:
            java.lang.String r1 = "1714"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x052e
            goto L_0x0110
        L_0x052e:
            r1 = 64
            goto L_0x089b
        L_0x0532:
            java.lang.String r1 = "1713"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x053c
            goto L_0x0110
        L_0x053c:
            r1 = 63
            goto L_0x089b
        L_0x0540:
            java.lang.String r1 = "1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x054a
            goto L_0x0110
        L_0x054a:
            r1 = 62
            goto L_0x089b
        L_0x054e:
            java.lang.String r1 = "flo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0558
            goto L_0x0110
        L_0x0558:
            r1 = 61
            goto L_0x089b
        L_0x055c:
            java.lang.String r1 = "deb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0566
            goto L_0x0110
        L_0x0566:
            r1 = 60
            goto L_0x089b
        L_0x056a:
            java.lang.String r1 = "cv3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0574
            goto L_0x0110
        L_0x0574:
            r1 = 59
            goto L_0x089b
        L_0x0578:
            java.lang.String r1 = "cv1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0582
            goto L_0x0110
        L_0x0582:
            r1 = 58
            goto L_0x089b
        L_0x0586:
            java.lang.String r1 = "Z80"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0590
            goto L_0x0110
        L_0x0590:
            r1 = 57
            goto L_0x089b
        L_0x0594:
            java.lang.String r1 = "QX1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x059e
            goto L_0x0110
        L_0x059e:
            r1 = 56
            goto L_0x089b
        L_0x05a2:
            java.lang.String r1 = "PLE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05ac
            goto L_0x0110
        L_0x05ac:
            r1 = 55
            goto L_0x089b
        L_0x05b0:
            java.lang.String r1 = "P85"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05ba
            goto L_0x0110
        L_0x05ba:
            r1 = 54
            goto L_0x089b
        L_0x05be:
            java.lang.String r1 = "MX6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05c8
            goto L_0x0110
        L_0x05c8:
            r1 = 53
            goto L_0x089b
        L_0x05cc:
            java.lang.String r1 = "M5c"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05d6
            goto L_0x0110
        L_0x05d6:
            r1 = 52
            goto L_0x089b
        L_0x05da:
            java.lang.String r1 = "M04"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05e4
            goto L_0x0110
        L_0x05e4:
            r1 = 51
            goto L_0x089b
        L_0x05e8:
            java.lang.String r1 = "JGZ"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05f2
            goto L_0x0110
        L_0x05f2:
            r1 = 50
            goto L_0x089b
        L_0x05f6:
            java.lang.String r1 = "mh"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0600
            goto L_0x0110
        L_0x0600:
            r1 = 49
            goto L_0x089b
        L_0x0604:
            java.lang.String r1 = "b5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x060e
            goto L_0x0110
        L_0x060e:
            r1 = 48
            goto L_0x089b
        L_0x0612:
            java.lang.String r1 = "V5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x061c
            goto L_0x0110
        L_0x061c:
            r1 = 47
            goto L_0x089b
        L_0x0620:
            java.lang.String r1 = "V1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x062a
            goto L_0x0110
        L_0x062a:
            r1 = 46
            goto L_0x089b
        L_0x062e:
            java.lang.String r1 = "Q5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0638
            goto L_0x0110
        L_0x0638:
            r1 = 45
            goto L_0x089b
        L_0x063c:
            java.lang.String r1 = "C1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0646
            goto L_0x0110
        L_0x0646:
            r1 = 44
            goto L_0x089b
        L_0x064a:
            java.lang.String r1 = "woods_fn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0654
            goto L_0x0110
        L_0x0654:
            r1 = 43
            goto L_0x089b
        L_0x0658:
            java.lang.String r1 = "ELUGA_A3_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0662
            goto L_0x0110
        L_0x0662:
            r1 = 42
            goto L_0x089b
        L_0x0666:
            java.lang.String r1 = "Z12_PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0670
            goto L_0x0110
        L_0x0670:
            r1 = 41
            goto L_0x089b
        L_0x0674:
            java.lang.String r1 = "BLACK-1X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x067e
            goto L_0x0110
        L_0x067e:
            r1 = 40
            goto L_0x089b
        L_0x0682:
            java.lang.String r1 = "taido_row"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x068c
            goto L_0x0110
        L_0x068c:
            r1 = 39
            goto L_0x089b
        L_0x0690:
            java.lang.String r1 = "Pixi4-7_3G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x069a
            goto L_0x0110
        L_0x069a:
            r1 = 38
            goto L_0x089b
        L_0x069e:
            java.lang.String r1 = "GIONEE_GBL7360"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06a8
            goto L_0x0110
        L_0x06a8:
            r1 = 37
            goto L_0x089b
        L_0x06ac:
            java.lang.String r1 = "GiONEE_CBL7513"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06b6
            goto L_0x0110
        L_0x06b6:
            r1 = 36
            goto L_0x089b
        L_0x06ba:
            java.lang.String r1 = "OnePlus5T"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06c4
            goto L_0x0110
        L_0x06c4:
            r1 = 35
            goto L_0x089b
        L_0x06c8:
            java.lang.String r1 = "whyred"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06d2
            goto L_0x0110
        L_0x06d2:
            r1 = 34
            goto L_0x089b
        L_0x06d6:
            java.lang.String r1 = "watson"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06e0
            goto L_0x0110
        L_0x06e0:
            r1 = 33
            goto L_0x089b
        L_0x06e4:
            java.lang.String r1 = "SVP-DTV15"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06ee
            goto L_0x0110
        L_0x06ee:
            r1 = 32
            goto L_0x089b
        L_0x06f2:
            java.lang.String r1 = "A7000-a"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06fc
            goto L_0x0110
        L_0x06fc:
            r1 = 31
            goto L_0x089b
        L_0x0700:
            java.lang.String r1 = "nicklaus_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x070a
            goto L_0x0110
        L_0x070a:
            r1 = 30
            goto L_0x089b
        L_0x070e:
            java.lang.String r1 = "tcl_eu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0718
            goto L_0x0110
        L_0x0718:
            r1 = 29
            goto L_0x089b
        L_0x071c:
            java.lang.String r1 = "ELUGA_Ray_X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0726
            goto L_0x0110
        L_0x0726:
            r1 = r10
            goto L_0x089b
        L_0x0729:
            java.lang.String r1 = "s905x018"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0733
            goto L_0x0110
        L_0x0733:
            r1 = r11
            goto L_0x089b
        L_0x0736:
            java.lang.String r1 = "A10-70L"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0740
            goto L_0x0110
        L_0x0740:
            r1 = r13
            goto L_0x089b
        L_0x0743:
            java.lang.String r1 = "A10-70F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x074d
            goto L_0x0110
        L_0x074d:
            r1 = 25
            goto L_0x089b
        L_0x0751:
            java.lang.String r1 = "namath"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x075b
            goto L_0x0110
        L_0x075b:
            r1 = 24
            goto L_0x089b
        L_0x075f:
            java.lang.String r1 = "Slate_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0769
            goto L_0x0110
        L_0x0769:
            r1 = 23
            goto L_0x089b
        L_0x076d:
            java.lang.String r1 = "iris60"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0777
            goto L_0x0110
        L_0x0777:
            r1 = 22
            goto L_0x089b
        L_0x077b:
            java.lang.String r1 = "BRAVIA_ATV2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0785
            goto L_0x0110
        L_0x0785:
            r1 = 21
            goto L_0x089b
        L_0x0789:
            java.lang.String r1 = "GiONEE_GBL7319"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0793
            goto L_0x0110
        L_0x0793:
            r1 = 20
            goto L_0x089b
        L_0x0797:
            java.lang.String r1 = "panell_dt"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07a1
            goto L_0x0110
        L_0x07a1:
            r1 = 19
            goto L_0x089b
        L_0x07a5:
            java.lang.String r1 = "panell_ds"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07af
            goto L_0x0110
        L_0x07af:
            r1 = 18
            goto L_0x089b
        L_0x07b3:
            java.lang.String r1 = "panell_dl"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07bd
            goto L_0x0110
        L_0x07bd:
            r1 = 17
            goto L_0x089b
        L_0x07c1:
            java.lang.String r1 = "vernee_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07cb
            goto L_0x0110
        L_0x07cb:
            r1 = 16
            goto L_0x089b
        L_0x07cf:
            java.lang.String r1 = "pacificrim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07d9
            goto L_0x0110
        L_0x07d9:
            r1 = 15
            goto L_0x089b
        L_0x07dd:
            java.lang.String r1 = "Phantom6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07e7
            goto L_0x0110
        L_0x07e7:
            r1 = 14
            goto L_0x089b
        L_0x07eb:
            java.lang.String r1 = "ComioS1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07f5
            goto L_0x0110
        L_0x07f5:
            r1 = 13
            goto L_0x089b
        L_0x07f9:
            java.lang.String r1 = "XT1663"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0803
            goto L_0x0110
        L_0x0803:
            r1 = 12
            goto L_0x089b
        L_0x0807:
            java.lang.String r1 = "RAIJIN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0811
            goto L_0x0110
        L_0x0811:
            r1 = 11
            goto L_0x089b
        L_0x0815:
            java.lang.String r1 = "AquaPowerM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x081f
            goto L_0x0110
        L_0x081f:
            r1 = 10
            goto L_0x089b
        L_0x0823:
            java.lang.String r1 = "PGN611"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x082d
            goto L_0x0110
        L_0x082d:
            r1 = 9
            goto L_0x089b
        L_0x0831:
            java.lang.String r1 = "PGN610"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x083b
            goto L_0x0110
        L_0x083b:
            r1 = r14
            goto L_0x089b
        L_0x083e:
            java.lang.String r2 = "PGN528"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x089b
            goto L_0x0110
        L_0x0848:
            java.lang.String r1 = "NX573J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0852
            goto L_0x0110
        L_0x0852:
            r1 = r2
            goto L_0x089b
        L_0x0854:
            java.lang.String r1 = "NX541J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x085e
            goto L_0x0110
        L_0x085e:
            r1 = r3
            goto L_0x089b
        L_0x0860:
            java.lang.String r1 = "CP8676_I02"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x086a
            goto L_0x0110
        L_0x086a:
            r1 = r4
            goto L_0x089b
        L_0x086c:
            java.lang.String r1 = "K50a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0876
            goto L_0x0110
        L_0x0876:
            r1 = r5
            goto L_0x089b
        L_0x0878:
            java.lang.String r1 = "GIONEE_SWW1631"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0882
            goto L_0x0110
        L_0x0882:
            r1 = r6
            goto L_0x089b
        L_0x0884:
            java.lang.String r1 = "GIONEE_SWW1627"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x088e
            goto L_0x0110
        L_0x088e:
            r1 = r9
            goto L_0x089b
        L_0x0890:
            java.lang.String r1 = "GIONEE_SWW1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x089a
            goto L_0x0110
        L_0x089a:
            r1 = r8
        L_0x089b:
            switch(r1) {
                case 0: goto L_0x08aa;
                case 1: goto L_0x08aa;
                case 2: goto L_0x08aa;
                case 3: goto L_0x08aa;
                case 4: goto L_0x08aa;
                case 5: goto L_0x08aa;
                case 6: goto L_0x08aa;
                case 7: goto L_0x08aa;
                case 8: goto L_0x08aa;
                case 9: goto L_0x08aa;
                case 10: goto L_0x08aa;
                case 11: goto L_0x08aa;
                case 12: goto L_0x08aa;
                case 13: goto L_0x08aa;
                case 14: goto L_0x08aa;
                case 15: goto L_0x08aa;
                case 16: goto L_0x08aa;
                case 17: goto L_0x08aa;
                case 18: goto L_0x08aa;
                case 19: goto L_0x08aa;
                case 20: goto L_0x08aa;
                case 21: goto L_0x08aa;
                case 22: goto L_0x08aa;
                case 23: goto L_0x08aa;
                case 24: goto L_0x08aa;
                case 25: goto L_0x08aa;
                case 26: goto L_0x08aa;
                case 27: goto L_0x08aa;
                case 28: goto L_0x08aa;
                case 29: goto L_0x08aa;
                case 30: goto L_0x08aa;
                case 31: goto L_0x08aa;
                case 32: goto L_0x08aa;
                case 33: goto L_0x08aa;
                case 34: goto L_0x08aa;
                case 35: goto L_0x08aa;
                case 36: goto L_0x08aa;
                case 37: goto L_0x08aa;
                case 38: goto L_0x08aa;
                case 39: goto L_0x08aa;
                case 40: goto L_0x08aa;
                case 41: goto L_0x08aa;
                case 42: goto L_0x08aa;
                case 43: goto L_0x08aa;
                case 44: goto L_0x08aa;
                case 45: goto L_0x08aa;
                case 46: goto L_0x08aa;
                case 47: goto L_0x08aa;
                case 48: goto L_0x08aa;
                case 49: goto L_0x08aa;
                case 50: goto L_0x08aa;
                case 51: goto L_0x08aa;
                case 52: goto L_0x08aa;
                case 53: goto L_0x08aa;
                case 54: goto L_0x08aa;
                case 55: goto L_0x08aa;
                case 56: goto L_0x08aa;
                case 57: goto L_0x08aa;
                case 58: goto L_0x08aa;
                case 59: goto L_0x08aa;
                case 60: goto L_0x08aa;
                case 61: goto L_0x08aa;
                case 62: goto L_0x08aa;
                case 63: goto L_0x08aa;
                case 64: goto L_0x08aa;
                case 65: goto L_0x08aa;
                case 66: goto L_0x08aa;
                case 67: goto L_0x08aa;
                case 68: goto L_0x08aa;
                case 69: goto L_0x08aa;
                case 70: goto L_0x08aa;
                case 71: goto L_0x08aa;
                case 72: goto L_0x08aa;
                case 73: goto L_0x08aa;
                case 74: goto L_0x08aa;
                case 75: goto L_0x08aa;
                case 76: goto L_0x08aa;
                case 77: goto L_0x08aa;
                case 78: goto L_0x08aa;
                case 79: goto L_0x08aa;
                case 80: goto L_0x08aa;
                case 81: goto L_0x08aa;
                case 82: goto L_0x08aa;
                case 83: goto L_0x08aa;
                case 84: goto L_0x08aa;
                case 85: goto L_0x08aa;
                case 86: goto L_0x08aa;
                case 87: goto L_0x08aa;
                case 88: goto L_0x08aa;
                case 89: goto L_0x08aa;
                case 90: goto L_0x08aa;
                case 91: goto L_0x08aa;
                case 92: goto L_0x08aa;
                case 93: goto L_0x08aa;
                case 94: goto L_0x08aa;
                case 95: goto L_0x08aa;
                case 96: goto L_0x08aa;
                case 97: goto L_0x08aa;
                case 98: goto L_0x08aa;
                case 99: goto L_0x08aa;
                case 100: goto L_0x08aa;
                case 101: goto L_0x08aa;
                case 102: goto L_0x08aa;
                case 103: goto L_0x08aa;
                case 104: goto L_0x08aa;
                case 105: goto L_0x08aa;
                case 106: goto L_0x08aa;
                case 107: goto L_0x08aa;
                case 108: goto L_0x08aa;
                case 109: goto L_0x08aa;
                case 110: goto L_0x08aa;
                case 111: goto L_0x08aa;
                case 112: goto L_0x08aa;
                case 113: goto L_0x08aa;
                case 114: goto L_0x08aa;
                case 115: goto L_0x08aa;
                case 116: goto L_0x08aa;
                case 117: goto L_0x08aa;
                case 118: goto L_0x08aa;
                case 119: goto L_0x08aa;
                case 120: goto L_0x08aa;
                case 121: goto L_0x08aa;
                case 122: goto L_0x08aa;
                case 123: goto L_0x08aa;
                case 124: goto L_0x08aa;
                case 125: goto L_0x08aa;
                case 126: goto L_0x08aa;
                case 127: goto L_0x08aa;
                case 128: goto L_0x08aa;
                case 129: goto L_0x08aa;
                case 130: goto L_0x08aa;
                case 131: goto L_0x08aa;
                case 132: goto L_0x08aa;
                case 133: goto L_0x08aa;
                case 134: goto L_0x08aa;
                case 135: goto L_0x08aa;
                case 136: goto L_0x08aa;
                case 137: goto L_0x08aa;
                case 138: goto L_0x08aa;
                case 139: goto L_0x08aa;
                default: goto L_0x089e;
            }
        L_0x089e:
            r12.hashCode()
            java.lang.String r0 = "JSN-L21"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x08aa
            goto L_0x08ab
        L_0x08aa:
            return r9
        L_0x08ab:
            return r8
        L_0x08ac:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.evaluateDeviceNeedsSetOutputSurfaceWorkaround():boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007a, code lost:
        if (r3.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_AV1) == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        r10 = ((java.lang.Integer) r10.first).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo r9, com.google.android.exoplayer2.Format r10) {
        /*
            int r0 = r10.width
            int r1 = r10.height
            r2 = -1
            if (r0 == r2) goto L_0x00df
            if (r1 != r2) goto L_0x000b
            goto L_0x00df
        L_0x000b:
            java.lang.String r3 = r10.sampleMimeType
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = r4.equals(r3)
            java.lang.String r5 = "video/avc"
            java.lang.String r6 = "video/hevc"
            r7 = 1
            r8 = 2
            if (r4 == 0) goto L_0x0034
            android.util.Pair r10 = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(r10)
            if (r10 == 0) goto L_0x0033
            java.lang.Object r10 = r10.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r10 == r3) goto L_0x0031
            if (r10 == r7) goto L_0x0031
            if (r10 != r8) goto L_0x0033
        L_0x0031:
            r3 = r5
            goto L_0x0034
        L_0x0033:
            r3 = r6
        L_0x0034:
            r3.hashCode()
            int r10 = r3.hashCode()
            r4 = 4
            switch(r10) {
                case -1664118616: goto L_0x007d;
                case -1662735862: goto L_0x0074;
                case -1662541442: goto L_0x006b;
                case 1187890754: goto L_0x0060;
                case 1331836730: goto L_0x0057;
                case 1599127256: goto L_0x004c;
                case 1599127257: goto L_0x0041;
                default: goto L_0x003f;
            }
        L_0x003f:
            r7 = r2
            goto L_0x0087
        L_0x0041:
            java.lang.String r10 = "video/x-vnd.on2.vp9"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x004a
            goto L_0x003f
        L_0x004a:
            r7 = 6
            goto L_0x0087
        L_0x004c:
            java.lang.String r10 = "video/x-vnd.on2.vp8"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x0055
            goto L_0x003f
        L_0x0055:
            r7 = 5
            goto L_0x0087
        L_0x0057:
            boolean r10 = r3.equals(r5)
            if (r10 != 0) goto L_0x005e
            goto L_0x003f
        L_0x005e:
            r7 = r4
            goto L_0x0087
        L_0x0060:
            java.lang.String r10 = "video/mp4v-es"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x0069
            goto L_0x003f
        L_0x0069:
            r7 = 3
            goto L_0x0087
        L_0x006b:
            boolean r10 = r3.equals(r6)
            if (r10 != 0) goto L_0x0072
            goto L_0x003f
        L_0x0072:
            r7 = r8
            goto L_0x0087
        L_0x0074:
            java.lang.String r10 = "video/av01"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x0087
            goto L_0x003f
        L_0x007d:
            java.lang.String r10 = "video/3gpp"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x0086
            goto L_0x003f
        L_0x0086:
            r7 = 0
        L_0x0087:
            switch(r7) {
                case 0: goto L_0x00d9;
                case 1: goto L_0x00d9;
                case 2: goto L_0x00cd;
                case 3: goto L_0x00d9;
                case 4: goto L_0x0091;
                case 5: goto L_0x00d9;
                case 6: goto L_0x008b;
                default: goto L_0x008a;
            }
        L_0x008a:
            return r2
        L_0x008b:
            int r0 = r0 * r1
            int r9 = getMaxSampleSize(r0, r4)
            return r9
        L_0x0091:
            java.lang.String r10 = com.google.android.exoplayer2.util.Util.MODEL
            java.lang.String r3 = "BRAVIA 4K 2015"
            boolean r3 = r3.equals(r10)
            if (r3 != 0) goto L_0x00cc
            java.lang.String r3 = "Amazon"
            java.lang.String r4 = com.google.android.exoplayer2.util.Util.MANUFACTURER
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00ba
            java.lang.String r3 = "KFSOWI"
            boolean r3 = r3.equals(r10)
            if (r3 != 0) goto L_0x00cc
            java.lang.String r3 = "AFTS"
            boolean r10 = r3.equals(r10)
            if (r10 == 0) goto L_0x00ba
            boolean r9 = r9.secure
            if (r9 == 0) goto L_0x00ba
            goto L_0x00cc
        L_0x00ba:
            r9 = 16
            int r10 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r0, (int) r9)
            int r0 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r1, (int) r9)
            int r10 = r10 * r0
            int r10 = r10 * r9
            int r10 = r10 * r9
            int r9 = getMaxSampleSize(r10, r8)
            return r9
        L_0x00cc:
            return r2
        L_0x00cd:
            int r0 = r0 * r1
            int r9 = getMaxSampleSize(r0, r8)
            r10 = 2097152(0x200000, float:2.938736E-39)
            int r9 = java.lang.Math.max(r10, r9)
            return r9
        L_0x00d9:
            int r0 = r0 * r1
            int r9 = getMaxSampleSize(r0, r8)
            return r9
        L_0x00df:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo, com.google.android.exoplayer2.Format):int");
    }

    @Nullable
    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14 = format.height;
        int i15 = format.width;
        if (i14 > i15) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = i14;
        } else {
            i11 = i15;
        }
        if (z11) {
            i14 = i15;
        }
        float f11 = ((float) i14) / ((float) i11);
        for (int i16 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i17 = (int) (((float) i16) * f11);
            if (i16 <= i11 || i17 <= i14) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                if (z11) {
                    i13 = i17;
                } else {
                    i13 = i16;
                }
                if (!z11) {
                    i16 = i17;
                }
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i13, i16);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, (double) format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                try {
                    int ceilDivide = Util.ceilDivide(i16, 16) * 16;
                    int ceilDivide2 = Util.ceilDivide(i17, 16) * 16;
                    if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        if (z11) {
                            i12 = ceilDivide2;
                        } else {
                            i12 = ceilDivide;
                        }
                        if (!z11) {
                            ceilDivide = ceilDivide2;
                        }
                        return new Point(i12, ceilDivide);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    public static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getCodecMaxInputSize(mediaCodecInfo, format);
        }
        int size = format.initializationData.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += format.initializationData.get(i12).length;
        }
        return format.maxInputSize + i11;
    }

    private static int getMaxSampleSize(int i11, int i12) {
        return (i11 * 3) / (i12 * 2);
    }

    private static boolean isBufferLate(long j11) {
        return j11 < -30000;
    }

    private static boolean isBufferVeryLate(long j11) {
        return j11 < -500000;
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        int i11 = this.videoFrameProcessingOffsetCount;
        if (i11 != 0) {
            this.eventDispatcher.reportVideoFrameProcessingOffset(this.totalVideoFrameProcessingOffsetUs, i11);
            this.totalVideoFrameProcessingOffsetUs = 0;
            this.videoFrameProcessingOffsetCount = 0;
        }
    }

    private void maybeNotifyVideoSizeChanged() {
        int i11 = this.currentWidth;
        if (i11 != -1 || this.currentHeight != -1) {
            VideoSize videoSize = this.reportedVideoSize;
            if (videoSize == null || videoSize.width != i11 || videoSize.height != this.currentHeight || videoSize.unappliedRotationDegrees != this.currentUnappliedRotationDegrees || videoSize.pixelWidthHeightRatio != this.currentPixelWidthHeightRatio) {
                VideoSize videoSize2 = new VideoSize(this.currentWidth, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
                this.reportedVideoSize = videoSize2;
                this.eventDispatcher.videoSizeChanged(videoSize2);
            }
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.haveReportedFirstFrameRenderedForCurrentSurface) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize != null) {
            this.eventDispatcher.videoSizeChanged(videoSize);
        }
    }

    private void notifyFrameMetadataListener(long j11, long j12, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j11, j12, format, getCodecOutputMediaFormat());
        }
    }

    /* access modifiers changed from: private */
    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    @RequiresApi(17)
    private void releasePlaceholderSurface() {
        Surface surface2 = this.surface;
        PlaceholderSurface placeholderSurface2 = this.placeholderSurface;
        if (surface2 == placeholderSurface2) {
            this.surface = null;
        }
        placeholderSurface2.release();
        this.placeholderSurface = null;
    }

    @RequiresApi(29)
    private static void setHdr10PlusInfoV29(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.setParameters(bundle);
    }

    private void setJoiningDeadlineMs() {
        long j11;
        if (this.allowedJoiningTimeMs > 0) {
            j11 = SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs;
        } else {
            j11 = C.TIME_UNSET;
        }
        this.joiningDeadlineMs = j11;
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setOutput(@androidx.annotation.Nullable java.lang.Object r5) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.view.Surface
            if (r0 == 0) goto L_0x0007
            android.view.Surface r5 = (android.view.Surface) r5
            goto L_0x0008
        L_0x0007:
            r5 = 0
        L_0x0008:
            if (r5 != 0) goto L_0x0026
            com.google.android.exoplayer2.video.PlaceholderSurface r0 = r4.placeholderSurface
            if (r0 == 0) goto L_0x0010
            r5 = r0
            goto L_0x0026
        L_0x0010:
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r0 = r4.getCodecInfo()
            if (r0 == 0) goto L_0x0026
            boolean r1 = r4.shouldUsePlaceholderSurface(r0)
            if (r1 == 0) goto L_0x0026
            android.content.Context r5 = r4.context
            boolean r0 = r0.secure
            com.google.android.exoplayer2.video.PlaceholderSurface r5 = com.google.android.exoplayer2.video.PlaceholderSurface.newInstanceV17(r5, r0)
            r4.placeholderSurface = r5
        L_0x0026:
            android.view.Surface r0 = r4.surface
            if (r0 == r5) goto L_0x006e
            r4.surface = r5
            com.google.android.exoplayer2.video.VideoFrameReleaseHelper r0 = r4.frameReleaseHelper
            r0.onSurfaceChanged(r5)
            r0 = 0
            r4.haveReportedFirstFrameRenderedForCurrentSurface = r0
            int r0 = r4.getState()
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r1 = r4.getCodec()
            if (r1 == 0) goto L_0x0054
            int r2 = com.google.android.exoplayer2.util.Util.SDK_INT
            r3 = 23
            if (r2 < r3) goto L_0x004e
            if (r5 == 0) goto L_0x004e
            boolean r2 = r4.codecNeedsSetOutputSurfaceWorkaround
            if (r2 != 0) goto L_0x004e
            r4.setOutputSurfaceV23(r1, r5)
            goto L_0x0054
        L_0x004e:
            r4.releaseCodec()
            r4.maybeInitCodecOrBypass()
        L_0x0054:
            if (r5 == 0) goto L_0x0067
            com.google.android.exoplayer2.video.PlaceholderSurface r1 = r4.placeholderSurface
            if (r5 == r1) goto L_0x0067
            r4.maybeRenotifyVideoSizeChanged()
            r4.clearRenderedFirstFrame()
            r5 = 2
            if (r0 != r5) goto L_0x007a
            r4.setJoiningDeadlineMs()
            goto L_0x007a
        L_0x0067:
            r4.clearReportedVideoSize()
            r4.clearRenderedFirstFrame()
            goto L_0x007a
        L_0x006e:
            if (r5 == 0) goto L_0x007a
            com.google.android.exoplayer2.video.PlaceholderSurface r0 = r4.placeholderSurface
            if (r5 == r0) goto L_0x007a
            r4.maybeRenotifyVideoSizeChanged()
            r4.maybeRenotifyRenderedFirstFrame()
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.setOutput(java.lang.Object):void");
    }

    private boolean shouldUsePlaceholderSurface(MediaCodecInfo mediaCodecInfo) {
        if (Util.SDK_INT < 23 || this.tunneling || codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.f34956name) || (mediaCodecInfo.secure && !PlaceholderSurface.isSecureSupported(this.context))) {
            return false;
        }
        return true;
    }

    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        int i11;
        DecoderReuseEvaluation canReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i12 = canReuseCodec.discardReasons;
        int i13 = format2.width;
        CodecMaxValues codecMaxValues2 = this.codecMaxValues;
        if (i13 > codecMaxValues2.width || format2.height > codecMaxValues2.height) {
            i12 |= 256;
        }
        if (getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            i12 |= 64;
        }
        int i14 = i12;
        String str = mediaCodecInfo.f34956name;
        if (i14 != 0) {
            i11 = 0;
        } else {
            i11 = canReuseCodec.result;
        }
        return new DecoderReuseEvaluation(str, format, format2, i11, i14);
    }

    public boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                deviceNeedsSetOutputSurfaceWorkaround = evaluateDeviceNeedsSetOutputSurfaceWorkaround();
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    public MediaCodecDecoderException createDecoderException(Throwable th2, @Nullable MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th2, mediaCodecInfo, this.surface);
    }

    public void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i11, long j11) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i11, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(0, 1);
    }

    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        boolean z11;
        int codecMaxInputSize;
        int i11 = format.width;
        int i12 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (!(maxInputSize == -1 || (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format)) == -1)) {
                maxInputSize = Math.min((int) (((float) maxInputSize) * INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR), codecMaxInputSize);
            }
            return new CodecMaxValues(i11, i12, maxInputSize);
        }
        int length = formatArr.length;
        boolean z12 = false;
        for (int i13 = 0; i13 < length; i13++) {
            Format format2 = formatArr[i13];
            if (format.colorInfo != null && format2.colorInfo == null) {
                format2 = format2.buildUpon().setColorInfo(format.colorInfo).build();
            }
            if (mediaCodecInfo.canReuseCodec(format, format2).result != 0) {
                int i14 = format2.width;
                if (i14 == -1 || format2.height == -1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 |= z11;
                i11 = Math.max(i11, i14);
                i12 = Math.max(i12, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z12) {
            Log.w(TAG, "Resolutions unknown. Codec max resolution: " + i11 + Param.X + i12);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i11 = Math.max(i11, codecMaxSize.x);
                i12 = Math.max(i12, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.buildUpon().setWidth(i11).setHeight(i12).build()));
                Log.w(TAG, "Codec max resolution adjusted to: " + i11 + Param.X + i12);
            }
        }
        return new CodecMaxValues(i11, i12, maxInputSize);
    }

    public boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    public float getCodecOperatingRateV23(float f11, Format format, Format[] formatArr) {
        float f12 = -1.0f;
        for (Format format2 : formatArr) {
            float f13 = format2.frameRate;
            if (f13 != -1.0f) {
                f12 = Math.max(f12, f13);
            }
        }
        if (f12 == -1.0f) {
            return -1.0f;
        }
        return f12 * f11;
    }

    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z11) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.getDecoderInfosSortedByFormatSupport(getDecoderInfos(this.context, mediaCodecSelector, format, z11, this.tunneling), format);
    }

    @TargetApi(17)
    public MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, @Nullable MediaCrypto mediaCrypto, float f11) {
        int i11;
        PlaceholderSurface placeholderSurface2 = this.placeholderSurface;
        if (!(placeholderSurface2 == null || placeholderSurface2.secure == mediaCodecInfo.secure)) {
            releasePlaceholderSurface();
        }
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues2 = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues2;
        boolean z11 = this.deviceNeedsNoPostProcessWorkaround;
        if (this.tunneling) {
            i11 = this.tunnelingAudioSessionId;
        } else {
            i11 = 0;
        }
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues2, f11, z11, i11);
        if (this.surface == null) {
            if (shouldUsePlaceholderSurface(mediaCodecInfo)) {
                if (this.placeholderSurface == null) {
                    this.placeholderSurface = PlaceholderSurface.newInstanceV17(this.context, mediaCodecInfo.secure);
                }
                this.surface = this.placeholderSurface;
            } else {
                throw new IllegalStateException();
            }
        }
        return MediaCodecAdapter.Configuration.createForVideoDecoding(mediaCodecInfo, mediaFormat, format, this.surface, mediaCrypto);
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues2, float f11, boolean z11, int i11) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, Scopes.PROFILE, ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues2.width);
        mediaFormat.setInteger("max-height", codecMaxValues2.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues2.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f11 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f11);
            }
        }
        if (z11) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i11 != 0) {
            configureTunnelingV21(mediaFormat, i11);
        }
        return mediaFormat;
    }

    public String getName() {
        return TAG;
    }

    public Surface getSurface() {
        return this.surface;
    }

    @TargetApi(29)
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b11 = byteBuffer.get();
                short s11 = byteBuffer.getShort();
                short s12 = byteBuffer.getShort();
                byte b12 = byteBuffer.get();
                byte b13 = byteBuffer.get();
                byteBuffer.position(0);
                if (b11 != -75 || s11 != 60 || s12 != 1 || b12 != 4) {
                    return;
                }
                if (b13 == 0 || b13 == 1) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    setHdr10PlusInfoV29(getCodec(), bArr);
                }
            }
        }
    }

    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
        if (i11 == 1) {
            setOutput(obj);
        } else if (i11 == 7) {
            this.frameMetadataListener = (VideoFrameMetadataListener) obj;
        } else if (i11 == 10) {
            int intValue = ((Integer) obj).intValue();
            if (this.tunnelingAudioSessionId != intValue) {
                this.tunnelingAudioSessionId = intValue;
                if (this.tunneling) {
                    releaseCodec();
                }
            }
        } else if (i11 == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodecAdapter codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
            }
        } else if (i11 != 5) {
            super.handleMessage(i11, obj);
        } else {
            this.frameReleaseHelper.setChangeFrameRateStrategy(((Integer) obj).intValue());
        }
    }

    public boolean isReady() {
        PlaceholderSurface placeholderSurface2;
        if (super.isReady() && (this.renderedFirstFrameAfterReset || (((placeholderSurface2 = this.placeholderSurface) != null && this.surface == placeholderSurface2) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = C.TIME_UNSET;
            return true;
        } else if (this.joiningDeadlineMs == C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
                return true;
            }
            this.joiningDeadlineMs = C.TIME_UNSET;
            return false;
        }
    }

    public boolean maybeDropBuffersToKeyframe(long j11, boolean z11) throws ExoPlaybackException {
        int skipSource = skipSource(j11);
        if (skipSource == 0) {
            return false;
        }
        if (z11) {
            DecoderCounters decoderCounters = this.decoderCounters;
            decoderCounters.skippedInputBufferCount += skipSource;
            decoderCounters.skippedOutputBufferCount += this.buffersInCodecCount;
        } else {
            this.decoderCounters.droppedToKeyframeCount++;
            updateDroppedBufferCounters(skipSource, this.buffersInCodecCount);
        }
        flushOrReinitializeCodec();
        return true;
    }

    public void maybeNotifyRenderedFirstFrame() {
        this.renderedFirstFrameAfterEnable = true;
        if (!this.renderedFirstFrameAfterReset) {
            this.renderedFirstFrameAfterReset = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
            this.haveReportedFirstFrameRenderedForCurrentSurface = true;
        }
    }

    public void onCodecError(Exception exc) {
        Log.e(TAG, "Video codec error", exc);
        this.eventDispatcher.videoCodecError(exc);
    }

    public void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j11, long j12) {
        this.eventDispatcher.decoderInitialized(str, j11, j12);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
        if (Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23((MediaCodecAdapter) Assertions.checkNotNull(getCodec()));
        }
    }

    public void onCodecReleased(String str) {
        this.eventDispatcher.decoderReleased(str);
    }

    public void onDisabled() {
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    public void onEnabled(boolean z11, boolean z12) throws ExoPlaybackException {
        boolean z13;
        super.onEnabled(z11, z12);
        boolean z14 = getConfiguration().tunneling;
        if (!z14 || this.tunnelingAudioSessionId != 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        Assertions.checkState(z13);
        if (this.tunneling != z14) {
            this.tunneling = z14;
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        this.mayRenderFirstFrameAfterEnableIfNotStarted = z12;
        this.renderedFirstFrameAfterEnable = false;
    }

    @Nullable
    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation onInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.eventDispatcher.inputFormatChanged(formatHolder.format, onInputFormatChanged);
        return onInputFormatChanged;
    }

    public void onOutputFormatChanged(Format format, @Nullable MediaFormat mediaFormat) {
        boolean z11;
        int i11;
        int i12;
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
        if (this.tunneling) {
            this.currentWidth = format.width;
            this.currentHeight = format.height;
        } else {
            Assertions.checkNotNull(mediaFormat);
            if (!mediaFormat.containsKey(KEY_CROP_RIGHT) || !mediaFormat.containsKey(KEY_CROP_LEFT) || !mediaFormat.containsKey(KEY_CROP_BOTTOM) || !mediaFormat.containsKey(KEY_CROP_TOP)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                i11 = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
            } else {
                i11 = mediaFormat.getInteger("width");
            }
            this.currentWidth = i11;
            if (z11) {
                i12 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
            } else {
                i12 = mediaFormat.getInteger("height");
            }
            this.currentHeight = i12;
        }
        float f11 = format.pixelWidthHeightRatio;
        this.currentPixelWidthHeightRatio = f11;
        if (Util.SDK_INT >= 21) {
            int i13 = format.rotationDegrees;
            if (i13 == 90 || i13 == 270) {
                int i14 = this.currentWidth;
                this.currentWidth = this.currentHeight;
                this.currentHeight = i14;
                this.currentPixelWidthHeightRatio = 1.0f / f11;
            }
        } else {
            this.currentUnappliedRotationDegrees = format.rotationDegrees;
        }
        this.frameReleaseHelper.onFormatChanged(format.frameRate);
    }

    public void onPositionReset(long j11, boolean z11) throws ExoPlaybackException {
        super.onPositionReset(j11, z11);
        clearRenderedFirstFrame();
        this.frameReleaseHelper.onPositionReset();
        this.lastBufferPresentationTimeUs = C.TIME_UNSET;
        this.initialPositionUs = C.TIME_UNSET;
        this.consecutiveDroppedFrameCount = 0;
        if (z11) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = C.TIME_UNSET;
        }
    }

    @CallSuper
    public void onProcessedOutputBuffer(long j11) {
        super.onProcessedOutputBuffer(j11);
        if (!this.tunneling) {
            this.buffersInCodecCount--;
        }
    }

    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        clearRenderedFirstFrame();
    }

    public void onProcessedTunneledBuffer(long j11) throws ExoPlaybackException {
        updateOutputFormatForTime(j11);
        maybeNotifyVideoSizeChanged();
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j11);
    }

    @CallSuper
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z11 = this.tunneling;
        if (!z11) {
            this.buffersInCodecCount++;
        }
        if (Util.SDK_INT < 23 && z11) {
            onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
        }
    }

    @TargetApi(17)
    public void onReset() {
        try {
            super.onReset();
        } finally {
            if (this.placeholderSurface != null) {
                releasePlaceholderSurface();
            }
        }
    }

    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.totalVideoFrameProcessingOffsetUs = 0;
        this.videoFrameProcessingOffsetCount = 0;
        this.frameReleaseHelper.onStarted();
    }

    public void onStopped() {
        this.joiningDeadlineMs = C.TIME_UNSET;
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        this.frameReleaseHelper.onStopped();
        super.onStopped();
    }

    public boolean processOutputBuffer(long j11, long j12, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, Format format) throws ExoPlaybackException {
        boolean z13;
        long j14;
        boolean z14;
        boolean z15;
        boolean z16;
        long j15 = j11;
        MediaCodecAdapter mediaCodecAdapter2 = mediaCodecAdapter;
        int i14 = i11;
        long j16 = j13;
        Assertions.checkNotNull(mediaCodecAdapter);
        if (this.initialPositionUs == C.TIME_UNSET) {
            this.initialPositionUs = j15;
        }
        if (j16 != this.lastBufferPresentationTimeUs) {
            this.frameReleaseHelper.onNextFrame(j16);
            this.lastBufferPresentationTimeUs = j16;
        }
        long outputStreamOffsetUs = getOutputStreamOffsetUs();
        long j17 = j16 - outputStreamOffsetUs;
        if (!z11 || z12) {
            double playbackSpeed = (double) getPlaybackSpeed();
            if (getState() == 2) {
                z13 = true;
            } else {
                z13 = false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            long j18 = (long) (((double) (j16 - j15)) / playbackSpeed);
            if (z13) {
                j18 -= elapsedRealtime - j12;
            }
            if (this.surface != this.placeholderSurface) {
                long j19 = elapsedRealtime - this.lastRenderRealtimeUs;
                if (this.renderedFirstFrameAfterEnable ? this.renderedFirstFrameAfterReset : !z13 && !this.mayRenderFirstFrameAfterEnableIfNotStarted) {
                    j14 = j19;
                    z14 = false;
                } else {
                    z14 = true;
                    j14 = j19;
                }
                if (this.joiningDeadlineMs != C.TIME_UNSET || j15 < outputStreamOffsetUs || (!z14 && (!z13 || !shouldForceRenderOutputBuffer(j18, j14)))) {
                    z15 = false;
                } else {
                    z15 = true;
                }
                if (z15) {
                    long nanoTime = System.nanoTime();
                    notifyFrameMetadataListener(j17, nanoTime, format);
                    if (Util.SDK_INT >= 21) {
                        renderOutputBufferV21(mediaCodecAdapter, i11, j17, nanoTime);
                    } else {
                        renderOutputBuffer(mediaCodecAdapter2, i14, j17);
                    }
                    updateVideoFrameProcessingOffsetCounters(j18);
                    return true;
                }
                if (z13 && j15 != this.initialPositionUs) {
                    long nanoTime2 = System.nanoTime();
                    long adjustReleaseTime = this.frameReleaseHelper.adjustReleaseTime((j18 * 1000) + nanoTime2);
                    long j21 = (adjustReleaseTime - nanoTime2) / 1000;
                    if (this.joiningDeadlineMs != C.TIME_UNSET) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    long j22 = j21;
                    boolean z17 = z16;
                    if (shouldDropBuffersToKeyframe(j21, j12, z12) && maybeDropBuffersToKeyframe(j15, z17)) {
                        return false;
                    }
                    if (shouldDropOutputBuffer(j22, j12, z12)) {
                        if (z17) {
                            skipOutputBuffer(mediaCodecAdapter2, i14, j17);
                        } else {
                            dropOutputBuffer(mediaCodecAdapter2, i14, j17);
                        }
                        updateVideoFrameProcessingOffsetCounters(j22);
                        return true;
                    }
                    long j23 = j22;
                    if (Util.SDK_INT >= 21) {
                        if (j23 < 50000) {
                            if (adjustReleaseTime == this.lastFrameReleaseTimeNs) {
                                skipOutputBuffer(mediaCodecAdapter2, i14, j17);
                            } else {
                                notifyFrameMetadataListener(j17, adjustReleaseTime, format);
                                renderOutputBufferV21(mediaCodecAdapter, i11, j17, adjustReleaseTime);
                            }
                            updateVideoFrameProcessingOffsetCounters(j23);
                            this.lastFrameReleaseTimeNs = adjustReleaseTime;
                            return true;
                        }
                    } else if (j23 < 30000) {
                        if (j23 > 11000) {
                            try {
                                Thread.sleep((j23 - 10000) / 1000);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return false;
                            }
                        }
                        notifyFrameMetadataListener(j17, adjustReleaseTime, format);
                        renderOutputBuffer(mediaCodecAdapter2, i14, j17);
                        updateVideoFrameProcessingOffsetCounters(j23);
                        return true;
                    }
                }
                return false;
            } else if (!isBufferLate(j18)) {
                return false;
            } else {
                skipOutputBuffer(mediaCodecAdapter2, i14, j17);
                updateVideoFrameProcessingOffsetCounters(j18);
                return true;
            }
        } else {
            skipOutputBuffer(mediaCodecAdapter2, i14, j17);
            return true;
        }
    }

    public void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i11, long j11) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i11, true);
        TraceUtil.endSection();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    @RequiresApi(21)
    public void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i11, long j11, long j12) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i11, j12);
        TraceUtil.endSection();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    @CallSuper
    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.buffersInCodecCount = 0;
    }

    @RequiresApi(23)
    public void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface2) {
        mediaCodecAdapter.setOutputSurface(surface2);
    }

    public void setPlaybackSpeed(float f11, float f12) throws ExoPlaybackException {
        super.setPlaybackSpeed(f11, f12);
        this.frameReleaseHelper.onPlaybackSpeed(f11);
    }

    public boolean shouldDropBuffersToKeyframe(long j11, long j12, boolean z11) {
        return isBufferVeryLate(j11) && !z11;
    }

    public boolean shouldDropOutputBuffer(long j11, long j12, boolean z11) {
        return isBufferLate(j11) && !z11;
    }

    public boolean shouldForceRenderOutputBuffer(long j11, long j12) {
        return isBufferLate(j11) && j12 > 100000;
    }

    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.surface != null || shouldUsePlaceholderSurface(mediaCodecInfo);
    }

    public void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i11, long j11) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i11, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int supportsFormat(com.google.android.exoplayer2.mediacodec.MediaCodecSelector r11, com.google.android.exoplayer2.Format r12) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            r10 = this;
            java.lang.String r0 = r12.sampleMimeType
            boolean r0 = com.google.android.exoplayer2.util.MimeTypes.isVideo(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            int r11 = g7.c1.a(r1)
            return r11
        L_0x000e:
            com.google.android.exoplayer2.drm.DrmInitData r0 = r12.drmInitData
            r2 = 1
            if (r0 == 0) goto L_0x0015
            r0 = r2
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            android.content.Context r3 = r10.context
            java.util.List r3 = getDecoderInfos(r3, r11, r12, r0, r1)
            if (r0 == 0) goto L_0x002a
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x002a
            android.content.Context r3 = r10.context
            java.util.List r3 = getDecoderInfos(r3, r11, r12, r1, r1)
        L_0x002a:
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0035
            int r11 = g7.c1.a(r2)
            return r11
        L_0x0035:
            boolean r4 = com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.supportsFormatDrm(r12)
            if (r4 != 0) goto L_0x0041
            r11 = 2
            int r11 = g7.c1.a(r11)
            return r11
        L_0x0041:
            java.lang.Object r4 = r3.get(r1)
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r4 = (com.google.android.exoplayer2.mediacodec.MediaCodecInfo) r4
            boolean r5 = r4.isFormatSupported(r12)
            if (r5 != 0) goto L_0x0067
            r6 = r2
        L_0x004e:
            int r7 = r3.size()
            if (r6 >= r7) goto L_0x0067
            java.lang.Object r7 = r3.get(r6)
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r7 = (com.google.android.exoplayer2.mediacodec.MediaCodecInfo) r7
            boolean r8 = r7.isFormatSupported(r12)
            if (r8 == 0) goto L_0x0064
            r3 = r1
            r5 = r2
            r4 = r7
            goto L_0x0068
        L_0x0064:
            int r6 = r6 + 1
            goto L_0x004e
        L_0x0067:
            r3 = r2
        L_0x0068:
            if (r5 == 0) goto L_0x006c
            r6 = 4
            goto L_0x006d
        L_0x006c:
            r6 = 3
        L_0x006d:
            boolean r7 = r4.isSeamlessAdaptationSupported(r12)
            if (r7 == 0) goto L_0x0076
            r7 = 16
            goto L_0x0078
        L_0x0076:
            r7 = 8
        L_0x0078:
            boolean r4 = r4.hardwareAccelerated
            if (r4 == 0) goto L_0x007f
            r4 = 64
            goto L_0x0080
        L_0x007f:
            r4 = r1
        L_0x0080:
            if (r3 == 0) goto L_0x0085
            r3 = 128(0x80, float:1.794E-43)
            goto L_0x0086
        L_0x0085:
            r3 = r1
        L_0x0086:
            int r8 = com.google.android.exoplayer2.util.Util.SDK_INT
            r9 = 26
            if (r8 < r9) goto L_0x00a0
            java.lang.String r8 = "video/dolby-vision"
            java.lang.String r9 = r12.sampleMimeType
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00a0
            android.content.Context r8 = r10.context
            boolean r8 = com.google.android.exoplayer2.video.MediaCodecVideoRenderer.Api26.doesDisplaySupportDolbyVision(r8)
            if (r8 != 0) goto L_0x00a0
            r3 = 256(0x100, float:3.59E-43)
        L_0x00a0:
            if (r5 == 0) goto L_0x00c6
            android.content.Context r5 = r10.context
            java.util.List r11 = getDecoderInfos(r5, r11, r12, r0, r2)
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x00c6
            java.util.List r11 = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getDecoderInfosSortedByFormatSupport(r11, r12)
            java.lang.Object r11 = r11.get(r1)
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r11 = (com.google.android.exoplayer2.mediacodec.MediaCodecInfo) r11
            boolean r0 = r11.isFormatSupported(r12)
            if (r0 == 0) goto L_0x00c6
            boolean r11 = r11.isSeamlessAdaptationSupported(r12)
            if (r11 == 0) goto L_0x00c6
            r1 = 32
        L_0x00c6:
            int r11 = g7.c1.c(r6, r7, r1, r4, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.supportsFormat(com.google.android.exoplayer2.mediacodec.MediaCodecSelector, com.google.android.exoplayer2.Format):int");
    }

    public void updateDroppedBufferCounters(int i11, int i12) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedInputBufferCount += i11;
        int i13 = i11 + i12;
        decoderCounters.droppedBufferCount += i13;
        this.droppedFrames += i13;
        int i14 = this.consecutiveDroppedFrameCount + i13;
        this.consecutiveDroppedFrameCount = i14;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i14, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i15 = this.maxDroppedFramesToNotify;
        if (i15 > 0 && this.droppedFrames >= i15) {
            maybeNotifyDroppedFrames();
        }
    }

    public void updateVideoFrameProcessingOffsetCounters(long j11) {
        this.decoderCounters.addVideoFrameProcessingOffset(j11);
        this.totalVideoFrameProcessingOffsetUs += j11;
        this.videoFrameProcessingOffsetCount++;
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j11) {
        this(context2, mediaCodecSelector, j11, (Handler) null, (VideoRendererEventListener) null, 0);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j11, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i11) {
        this(context2, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j11, false, handler, videoRendererEventListener, i11, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j11, boolean z11, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i11) {
        this(context2, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j11, z11, handler, videoRendererEventListener, i11, 30.0f);
    }

    private static List<MediaCodecInfo> getDecoderInfos(Context context2, MediaCodecSelector mediaCodecSelector, Format format, boolean z11, boolean z12) throws MediaCodecUtil.DecoderQueryException {
        String str = format.sampleMimeType;
        if (str == null) {
            return ImmutableList.of();
        }
        List<MediaCodecInfo> decoderInfos = mediaCodecSelector.getDecoderInfos(str, z11, z12);
        String alternativeCodecMimeType = MediaCodecUtil.getAlternativeCodecMimeType(format);
        if (alternativeCodecMimeType == null) {
            return ImmutableList.copyOf(decoderInfos);
        }
        List<MediaCodecInfo> decoderInfos2 = mediaCodecSelector.getDecoderInfos(alternativeCodecMimeType, z11, z12);
        if (Util.SDK_INT < 26 || !MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) || decoderInfos2.isEmpty() || Api26.doesDisplaySupportDolbyVision(context2)) {
            return ImmutableList.builder().addAll((Iterable) decoderInfos).addAll((Iterable) decoderInfos2).build();
        }
        return ImmutableList.copyOf(decoderInfos2);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j11, boolean z11, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i11) {
        this(context2, factory, mediaCodecSelector, j11, z11, handler, videoRendererEventListener, i11, 30.0f);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaCodecVideoRenderer(Context context2, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j11, boolean z11, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i11, float f11) {
        super(2, factory, mediaCodecSelector, z11, f11);
        this.allowedJoiningTimeMs = j11;
        this.maxDroppedFramesToNotify = i11;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.frameReleaseHelper = new VideoFrameReleaseHelper(applicationContext);
        Handler handler2 = handler;
        VideoRendererEventListener videoRendererEventListener2 = videoRendererEventListener;
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.joiningDeadlineMs = C.TIME_UNSET;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        this.tunnelingAudioSessionId = 0;
        clearReportedVideoSize();
    }
}
