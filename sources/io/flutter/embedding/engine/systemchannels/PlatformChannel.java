package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlatformChannel {
    private static final String TAG = "PlatformChannel";
    @VisibleForTesting
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final MethodChannel.MethodCallHandler f14214a;
    @NonNull
    public final MethodChannel channel;
    /* access modifiers changed from: private */
    @Nullable
    public PlatformMessageHandler platformMessageHandler;

    /* renamed from: io.flutter.embedding.engine.systemchannels.PlatformChannel$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14216a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f14217b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f14218c;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        static {
            /*
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiMode[] r0 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14218c = r0
                r1 = 1
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiMode r2 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiMode.LEAN_BACK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f14218c     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiMode r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiMode.IMMERSIVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f14218c     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiMode r4 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiMode.IMMERSIVE_STICKY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f14218c     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiMode r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiMode.EDGE_TO_EDGE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiOverlay[] r4 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f14217b = r4
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiOverlay r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay.TOP_OVERLAYS     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = f14217b     // Catch:{ NoSuchFieldError -> 0x004e }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiOverlay r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay.BOTTOM_OVERLAYS     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                io.flutter.embedding.engine.systemchannels.PlatformChannel$DeviceOrientation[] r4 = io.flutter.embedding.engine.systemchannels.PlatformChannel.DeviceOrientation.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f14216a = r4
                io.flutter.embedding.engine.systemchannels.PlatformChannel$DeviceOrientation r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.DeviceOrientation.PORTRAIT_UP     // Catch:{ NoSuchFieldError -> 0x005f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                int[] r1 = f14216a     // Catch:{ NoSuchFieldError -> 0x0069 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$DeviceOrientation r4 = io.flutter.embedding.engine.systemchannels.PlatformChannel.DeviceOrientation.PORTRAIT_DOWN     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r0 = f14216a     // Catch:{ NoSuchFieldError -> 0x0073 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$DeviceOrientation r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.DeviceOrientation.LANDSCAPE_LEFT     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r0 = f14216a     // Catch:{ NoSuchFieldError -> 0x007d }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$DeviceOrientation r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.DeviceOrientation.LANDSCAPE_RIGHT     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.PlatformChannel.AnonymousClass2.<clinit>():void");
        }
    }

    public static class AppSwitcherDescription {
        public final int color;
        @NonNull
        public final String label;

        public AppSwitcherDescription(int i11, @NonNull String str) {
            this.color = i11;
            this.label = str;
        }
    }

    public enum Brightness {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");
        
        @NonNull
        private String encodedName;

        private Brightness(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static Brightness a(@NonNull String str) throws NoSuchFieldException {
            for (Brightness brightness : values()) {
                if (brightness.encodedName.equals(str)) {
                    return brightness;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }
    }

    public enum ClipboardContentFormat {
        PLAIN_TEXT("text/plain");
        
        @NonNull
        private String encodedName;

        private ClipboardContentFormat(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static ClipboardContentFormat a(@NonNull String str) throws NoSuchFieldException {
            for (ClipboardContentFormat clipboardContentFormat : values()) {
                if (clipboardContentFormat.encodedName.equals(str)) {
                    return clipboardContentFormat;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }
    }

    public enum DeviceOrientation {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");
        
        @NonNull
        private String encodedName;

        private DeviceOrientation(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static DeviceOrientation a(@NonNull String str) throws NoSuchFieldException {
            for (DeviceOrientation deviceOrientation : values()) {
                if (deviceOrientation.encodedName.equals(str)) {
                    return deviceOrientation;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }
    }

    public enum HapticFeedbackType {
        STANDARD((String) null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");
        
        @Nullable
        private final String encodedName;

        private HapticFeedbackType(@Nullable String str) {
            this.encodedName = str;
        }

        @NonNull
        public static HapticFeedbackType a(@Nullable String str) throws NoSuchFieldException {
            for (HapticFeedbackType hapticFeedbackType : values()) {
                String str2 = hapticFeedbackType.encodedName;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return hapticFeedbackType;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }
    }

    public interface PlatformMessageHandler {
        boolean clipboardHasStrings();

        @Nullable
        CharSequence getClipboardData(@Nullable ClipboardContentFormat clipboardContentFormat);

        void playSystemSound(@NonNull SoundType soundType);

        void popSystemNavigator();

        void restoreSystemUiOverlays();

        void setApplicationSwitcherDescription(@NonNull AppSwitcherDescription appSwitcherDescription);

        void setClipboardData(@NonNull String str);

        void setPreferredOrientations(int i11);

        void setSystemUiChangeListener();

        void setSystemUiOverlayStyle(@NonNull SystemChromeStyle systemChromeStyle);

        void showSystemOverlays(@NonNull List<SystemUiOverlay> list);

        void showSystemUiMode(@NonNull SystemUiMode systemUiMode);

        void vibrateHapticFeedback(@NonNull HapticFeedbackType hapticFeedbackType);
    }

    public enum SoundType {
        CLICK("SystemSoundType.click"),
        ALERT("SystemSoundType.alert");
        
        @NonNull
        private final String encodedName;

        private SoundType(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static SoundType a(@NonNull String str) throws NoSuchFieldException {
            for (SoundType soundType : values()) {
                if (soundType.encodedName.equals(str)) {
                    return soundType;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }
    }

    public static class SystemChromeStyle {
        @Nullable
        public final Integer statusBarColor;
        @Nullable
        public final Brightness statusBarIconBrightness;
        @Nullable
        public final Integer systemNavigationBarColor;
        @Nullable
        public final Boolean systemNavigationBarContrastEnforced;
        @Nullable
        public final Integer systemNavigationBarDividerColor;
        @Nullable
        public final Brightness systemNavigationBarIconBrightness;
        @Nullable
        public final Boolean systemStatusBarContrastEnforced;

        public SystemChromeStyle(@Nullable Integer num, @Nullable Brightness brightness, @Nullable Boolean bool, @Nullable Integer num2, @Nullable Brightness brightness2, @Nullable Integer num3, @Nullable Boolean bool2) {
            this.statusBarColor = num;
            this.statusBarIconBrightness = brightness;
            this.systemStatusBarContrastEnforced = bool;
            this.systemNavigationBarColor = num2;
            this.systemNavigationBarIconBrightness = brightness2;
            this.systemNavigationBarDividerColor = num3;
            this.systemNavigationBarContrastEnforced = bool2;
        }
    }

    public enum SystemUiMode {
        LEAN_BACK("SystemUiMode.leanBack"),
        IMMERSIVE("SystemUiMode.immersive"),
        IMMERSIVE_STICKY("SystemUiMode.immersiveSticky"),
        EDGE_TO_EDGE("SystemUiMode.edgeToEdge");
        
        @NonNull
        private String encodedName;

        private SystemUiMode(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static SystemUiMode a(@NonNull String str) throws NoSuchFieldException {
            for (SystemUiMode systemUiMode : values()) {
                if (systemUiMode.encodedName.equals(str)) {
                    return systemUiMode;
                }
            }
            throw new NoSuchFieldException("No such SystemUiMode: " + str);
        }
    }

    public enum SystemUiOverlay {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");
        
        @NonNull
        private String encodedName;

        private SystemUiOverlay(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static SystemUiOverlay a(@NonNull String str) throws NoSuchFieldException {
            for (SystemUiOverlay systemUiOverlay : values()) {
                if (systemUiOverlay.encodedName.equals(str)) {
                    return systemUiOverlay;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }
    }

    public PlatformChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 r02 = new MethodChannel.MethodCallHandler() {
            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* JADX WARNING: Can't wrap try/catch for region: R(2:58|59) */
            /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
                r7.error("error", "No such clipboard content format: " + r6, (java.lang.Object) null);
             */
            /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x00ff */
            /* JADX WARNING: Removed duplicated region for block: B:63:0x0120 A[Catch:{ JSONException -> 0x023a }] */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x012d A[Catch:{ JSONException -> 0x023a }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onMethodCall(@androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r6, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r7) {
                /*
                    r5 = this;
                    java.lang.String r0 = "error"
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r1 = r1.platformMessageHandler
                    if (r1 != 0) goto L_0x000b
                    return
                L_0x000b:
                    java.lang.String r1 = r6.method
                    java.lang.Object r6 = r6.arguments
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Received '"
                    r2.append(r3)
                    r2.append(r1)
                    java.lang.String r3 = "' message."
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    java.lang.String r3 = "PlatformChannel"
                    io.flutter.Log.v(r3, r2)
                    r2 = 0
                    int r3 = r1.hashCode()     // Catch:{ JSONException -> 0x023a }
                    switch(r3) {
                        case -766342101: goto L_0x00b3;
                        case -720677196: goto L_0x00a8;
                        case -577225884: goto L_0x009e;
                        case -548468504: goto L_0x0094;
                        case -247230243: goto L_0x008a;
                        case -215273374: goto L_0x0080;
                        case 241845679: goto L_0x0076;
                        case 875995648: goto L_0x006b;
                        case 1128339786: goto L_0x0061;
                        case 1390477857: goto L_0x0056;
                        case 1514180520: goto L_0x004a;
                        case 1674312266: goto L_0x003f;
                        case 2119655719: goto L_0x0034;
                        default: goto L_0x0032;
                    }     // Catch:{ JSONException -> 0x023a }
                L_0x0032:
                    goto L_0x00be
                L_0x0034:
                    java.lang.String r3 = "SystemChrome.setPreferredOrientations"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x023a }
                    if (r1 == 0) goto L_0x00be
                    r1 = 2
                    goto L_0x00bf
                L_0x003f:
                    java.lang.String r3 = "SystemChrome.setEnabledSystemUIOverlays"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x023a }
                    if (r1 == 0) goto L_0x00be
                    r1 = 4
                    goto L_0x00bf
                L_0x004a:
                    java.lang.String r3 = "Clipboard.getData"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x023a }
                    if (r1 == 0) goto L_0x00be
                    r1 = 10
                    goto L_0x00bf
                L_0x0056:
                    java.lang.String r3 = "SystemChrome.setSystemUIOverlayStyle"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x023a }
                    if (r1 == 0) goto L_0x00be
                    r1 = 8
                    goto L_0x00bf
                L_0x0061:
                    java.lang.String r3 = "SystemChrome.setEnabledSystemUIMode"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x023a }
                    if (r1 == 0) goto L_0x00be
                    r1 = 5
                    goto L_0x00bf
                L_0x006b:
                    java.lang.String r3 = "Clipboard.hasStrings"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x023a }
                    if (r1 == 0) goto L_0x00be
                    r1 = 12
                    goto L_0x00bf
                L_0x0076:
                    java.lang.String r3 = "SystemChrome.restoreSystemUIOverlays"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x023a }
                    if (r1 == 0) goto L_0x00be
                    r1 = 7
                    goto L_0x00bf
                L_0x0080:
                    java.lang.String r3 = "SystemSound.play"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x023a }
                    if (r1 == 0) goto L_0x00be
                    r1 = 0
                    goto L_0x00bf
                L_0x008a:
                    java.lang.String r3 = "HapticFeedback.vibrate"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x023a }
                    if (r1 == 0) goto L_0x00be
                    r1 = 1
                    goto L_0x00bf
                L_0x0094:
                    java.lang.String r3 = "SystemChrome.setApplicationSwitcherDescription"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x023a }
                    if (r1 == 0) goto L_0x00be
                    r1 = 3
                    goto L_0x00bf
                L_0x009e:
                    java.lang.String r3 = "SystemChrome.setSystemUIChangeListener"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x023a }
                    if (r1 == 0) goto L_0x00be
                    r1 = 6
                    goto L_0x00bf
                L_0x00a8:
                    java.lang.String r3 = "Clipboard.setData"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x023a }
                    if (r1 == 0) goto L_0x00be
                    r1 = 11
                    goto L_0x00bf
                L_0x00b3:
                    java.lang.String r3 = "SystemNavigator.pop"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x023a }
                    if (r1 == 0) goto L_0x00be
                    r1 = 9
                    goto L_0x00bf
                L_0x00be:
                    r1 = -1
                L_0x00bf:
                    java.lang.String r3 = "text"
                    switch(r1) {
                        case 0: goto L_0x021e;
                        case 1: goto L_0x0202;
                        case 2: goto L_0x01e2;
                        case 3: goto L_0x01c2;
                        case 4: goto L_0x01a0;
                        case 5: goto L_0x017e;
                        case 6: goto L_0x0170;
                        case 7: goto L_0x0162;
                        case 8: goto L_0x0140;
                        case 9: goto L_0x0132;
                        case 10: goto L_0x00f6;
                        case 11: goto L_0x00e2;
                        case 12: goto L_0x00c9;
                        default: goto L_0x00c4;
                    }
                L_0x00c4:
                    r7.notImplemented()     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x00c9:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r6 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x023a }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r6 = r6.platformMessageHandler     // Catch:{ JSONException -> 0x023a }
                    boolean r6 = r6.clipboardHasStrings()     // Catch:{ JSONException -> 0x023a }
                    org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x023a }
                    r1.<init>()     // Catch:{ JSONException -> 0x023a }
                    java.lang.String r3 = "value"
                    r1.put((java.lang.String) r3, (boolean) r6)     // Catch:{ JSONException -> 0x023a }
                    r7.success(r1)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x00e2:
                    org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ JSONException -> 0x023a }
                    java.lang.String r6 = r6.getString(r3)     // Catch:{ JSONException -> 0x023a }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x023a }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r1 = r1.platformMessageHandler     // Catch:{ JSONException -> 0x023a }
                    r1.setClipboardData(r6)     // Catch:{ JSONException -> 0x023a }
                    r7.success(r2)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x00f6:
                    java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x023a }
                    if (r6 == 0) goto L_0x0113
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$ClipboardContentFormat r6 = io.flutter.embedding.engine.systemchannels.PlatformChannel.ClipboardContentFormat.a(r6)     // Catch:{ NoSuchFieldException -> 0x00ff }
                    goto L_0x0114
                L_0x00ff:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x023a }
                    r1.<init>()     // Catch:{ JSONException -> 0x023a }
                    java.lang.String r4 = "No such clipboard content format: "
                    r1.append(r4)     // Catch:{ JSONException -> 0x023a }
                    r1.append(r6)     // Catch:{ JSONException -> 0x023a }
                    java.lang.String r6 = r1.toString()     // Catch:{ JSONException -> 0x023a }
                    r7.error(r0, r6, r2)     // Catch:{ JSONException -> 0x023a }
                L_0x0113:
                    r6 = r2
                L_0x0114:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x023a }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r1 = r1.platformMessageHandler     // Catch:{ JSONException -> 0x023a }
                    java.lang.CharSequence r6 = r1.getClipboardData(r6)     // Catch:{ JSONException -> 0x023a }
                    if (r6 == 0) goto L_0x012d
                    org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x023a }
                    r1.<init>()     // Catch:{ JSONException -> 0x023a }
                    r1.put((java.lang.String) r3, (java.lang.Object) r6)     // Catch:{ JSONException -> 0x023a }
                    r7.success(r1)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x012d:
                    r7.success(r2)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x0132:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r6 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x023a }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r6 = r6.platformMessageHandler     // Catch:{ JSONException -> 0x023a }
                    r6.popSystemNavigator()     // Catch:{ JSONException -> 0x023a }
                    r7.success(r2)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x0140:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x0158, NoSuchFieldException -> 0x0156 }
                    org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ JSONException -> 0x0158, NoSuchFieldException -> 0x0156 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemChromeStyle r6 = r1.decodeSystemChromeStyle(r6)     // Catch:{ JSONException -> 0x0158, NoSuchFieldException -> 0x0156 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x0158, NoSuchFieldException -> 0x0156 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r1 = r1.platformMessageHandler     // Catch:{ JSONException -> 0x0158, NoSuchFieldException -> 0x0156 }
                    r1.setSystemUiOverlayStyle(r6)     // Catch:{ JSONException -> 0x0158, NoSuchFieldException -> 0x0156 }
                    r7.success(r2)     // Catch:{ JSONException -> 0x0158, NoSuchFieldException -> 0x0156 }
                    goto L_0x0253
                L_0x0156:
                    r6 = move-exception
                    goto L_0x0159
                L_0x0158:
                    r6 = move-exception
                L_0x0159:
                    java.lang.String r6 = r6.getMessage()     // Catch:{ JSONException -> 0x023a }
                    r7.error(r0, r6, r2)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x0162:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r6 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x023a }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r6 = r6.platformMessageHandler     // Catch:{ JSONException -> 0x023a }
                    r6.restoreSystemUiOverlays()     // Catch:{ JSONException -> 0x023a }
                    r7.success(r2)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x0170:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r6 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x023a }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r6 = r6.platformMessageHandler     // Catch:{ JSONException -> 0x023a }
                    r6.setSystemUiChangeListener()     // Catch:{ JSONException -> 0x023a }
                    r7.success(r2)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x017e:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x0196, NoSuchFieldException -> 0x0194 }
                    java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x0196, NoSuchFieldException -> 0x0194 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiMode r6 = r1.decodeSystemUiMode(r6)     // Catch:{ JSONException -> 0x0196, NoSuchFieldException -> 0x0194 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x0196, NoSuchFieldException -> 0x0194 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r1 = r1.platformMessageHandler     // Catch:{ JSONException -> 0x0196, NoSuchFieldException -> 0x0194 }
                    r1.showSystemUiMode(r6)     // Catch:{ JSONException -> 0x0196, NoSuchFieldException -> 0x0194 }
                    r7.success(r2)     // Catch:{ JSONException -> 0x0196, NoSuchFieldException -> 0x0194 }
                    goto L_0x0253
                L_0x0194:
                    r6 = move-exception
                    goto L_0x0197
                L_0x0196:
                    r6 = move-exception
                L_0x0197:
                    java.lang.String r6 = r6.getMessage()     // Catch:{ JSONException -> 0x023a }
                    r7.error(r0, r6, r2)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x01a0:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x01b8, NoSuchFieldException -> 0x01b6 }
                    org.json.JSONArray r6 = (org.json.JSONArray) r6     // Catch:{ JSONException -> 0x01b8, NoSuchFieldException -> 0x01b6 }
                    java.util.List r6 = r1.decodeSystemUiOverlays(r6)     // Catch:{ JSONException -> 0x01b8, NoSuchFieldException -> 0x01b6 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x01b8, NoSuchFieldException -> 0x01b6 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r1 = r1.platformMessageHandler     // Catch:{ JSONException -> 0x01b8, NoSuchFieldException -> 0x01b6 }
                    r1.showSystemOverlays(r6)     // Catch:{ JSONException -> 0x01b8, NoSuchFieldException -> 0x01b6 }
                    r7.success(r2)     // Catch:{ JSONException -> 0x01b8, NoSuchFieldException -> 0x01b6 }
                    goto L_0x0253
                L_0x01b6:
                    r6 = move-exception
                    goto L_0x01b9
                L_0x01b8:
                    r6 = move-exception
                L_0x01b9:
                    java.lang.String r6 = r6.getMessage()     // Catch:{ JSONException -> 0x023a }
                    r7.error(r0, r6, r2)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x01c2:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x01d8 }
                    org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ JSONException -> 0x01d8 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$AppSwitcherDescription r6 = r1.decodeAppSwitcherDescription(r6)     // Catch:{ JSONException -> 0x01d8 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x01d8 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r1 = r1.platformMessageHandler     // Catch:{ JSONException -> 0x01d8 }
                    r1.setApplicationSwitcherDescription(r6)     // Catch:{ JSONException -> 0x01d8 }
                    r7.success(r2)     // Catch:{ JSONException -> 0x01d8 }
                    goto L_0x0253
                L_0x01d8:
                    r6 = move-exception
                    java.lang.String r6 = r6.getMessage()     // Catch:{ JSONException -> 0x023a }
                    r7.error(r0, r6, r2)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x01e2:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x01f9, NoSuchFieldException -> 0x01f7 }
                    org.json.JSONArray r6 = (org.json.JSONArray) r6     // Catch:{ JSONException -> 0x01f9, NoSuchFieldException -> 0x01f7 }
                    int r6 = r1.decodeOrientations(r6)     // Catch:{ JSONException -> 0x01f9, NoSuchFieldException -> 0x01f7 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x01f9, NoSuchFieldException -> 0x01f7 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r1 = r1.platformMessageHandler     // Catch:{ JSONException -> 0x01f9, NoSuchFieldException -> 0x01f7 }
                    r1.setPreferredOrientations(r6)     // Catch:{ JSONException -> 0x01f9, NoSuchFieldException -> 0x01f7 }
                    r7.success(r2)     // Catch:{ JSONException -> 0x01f9, NoSuchFieldException -> 0x01f7 }
                    goto L_0x0253
                L_0x01f7:
                    r6 = move-exception
                    goto L_0x01fa
                L_0x01f9:
                    r6 = move-exception
                L_0x01fa:
                    java.lang.String r6 = r6.getMessage()     // Catch:{ JSONException -> 0x023a }
                    r7.error(r0, r6, r2)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x0202:
                    java.lang.String r6 = (java.lang.String) r6     // Catch:{ NoSuchFieldException -> 0x0215 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType r6 = io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.a(r6)     // Catch:{ NoSuchFieldException -> 0x0215 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException -> 0x0215 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r1 = r1.platformMessageHandler     // Catch:{ NoSuchFieldException -> 0x0215 }
                    r1.vibrateHapticFeedback(r6)     // Catch:{ NoSuchFieldException -> 0x0215 }
                    r7.success(r2)     // Catch:{ NoSuchFieldException -> 0x0215 }
                    goto L_0x0253
                L_0x0215:
                    r6 = move-exception
                    java.lang.String r6 = r6.getMessage()     // Catch:{ JSONException -> 0x023a }
                    r7.error(r0, r6, r2)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x021e:
                    java.lang.String r6 = (java.lang.String) r6     // Catch:{ NoSuchFieldException -> 0x0231 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$SoundType r6 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SoundType.a(r6)     // Catch:{ NoSuchFieldException -> 0x0231 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException -> 0x0231 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r1 = r1.platformMessageHandler     // Catch:{ NoSuchFieldException -> 0x0231 }
                    r1.playSystemSound(r6)     // Catch:{ NoSuchFieldException -> 0x0231 }
                    r7.success(r2)     // Catch:{ NoSuchFieldException -> 0x0231 }
                    goto L_0x0253
                L_0x0231:
                    r6 = move-exception
                    java.lang.String r6 = r6.getMessage()     // Catch:{ JSONException -> 0x023a }
                    r7.error(r0, r6, r2)     // Catch:{ JSONException -> 0x023a }
                    goto L_0x0253
                L_0x023a:
                    r6 = move-exception
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r3 = "JSON error: "
                    r1.append(r3)
                    java.lang.String r6 = r6.getMessage()
                    r1.append(r6)
                    java.lang.String r6 = r1.toString()
                    r7.error(r0, r6, r2)
                L_0x0253:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.PlatformChannel.AnonymousClass1.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
            }
        };
        this.f14214a = r02;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r02);
    }

    /* access modifiers changed from: private */
    @NonNull
    public AppSwitcherDescription decodeAppSwitcherDescription(@NonNull JSONObject jSONObject) throws JSONException {
        int i11 = jSONObject.getInt("primaryColor");
        if (i11 != 0) {
            i11 |= ViewCompat.MEASURED_STATE_MASK;
        }
        return new AppSwitcherDescription(i11, jSONObject.getString("label"));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0056, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int decodeOrientations(@androidx.annotation.NonNull org.json.JSONArray r10) throws org.json.JSONException, java.lang.NoSuchFieldException {
        /*
            r9 = this;
            r0 = 0
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x0004:
            int r4 = r10.length()
            r5 = 4
            r6 = 2
            r7 = 1
            if (r1 >= r4) goto L_0x0038
            java.lang.String r4 = r10.getString(r1)
            io.flutter.embedding.engine.systemchannels.PlatformChannel$DeviceOrientation r4 = io.flutter.embedding.engine.systemchannels.PlatformChannel.DeviceOrientation.a(r4)
            int[] r8 = io.flutter.embedding.engine.systemchannels.PlatformChannel.AnonymousClass2.f14216a
            int r4 = r4.ordinal()
            r4 = r8[r4]
            if (r4 == r7) goto L_0x0030
            if (r4 == r6) goto L_0x002d
            r6 = 3
            if (r4 == r6) goto L_0x002a
            if (r4 == r5) goto L_0x0027
            goto L_0x0032
        L_0x0027:
            r2 = r2 | 8
            goto L_0x0032
        L_0x002a:
            r2 = r2 | 2
            goto L_0x0032
        L_0x002d:
            r2 = r2 | 4
            goto L_0x0032
        L_0x0030:
            r2 = r2 | 1
        L_0x0032:
            if (r3 != 0) goto L_0x0035
            r3 = r2
        L_0x0035:
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0038:
            if (r2 == 0) goto L_0x0057
            r10 = 9
            r1 = 8
            switch(r2) {
                case 2: goto L_0x0056;
                case 3: goto L_0x004d;
                case 4: goto L_0x004c;
                case 5: goto L_0x004a;
                case 6: goto L_0x004d;
                case 7: goto L_0x004d;
                case 8: goto L_0x0049;
                case 9: goto L_0x004d;
                case 10: goto L_0x0046;
                case 11: goto L_0x0045;
                case 12: goto L_0x004d;
                case 13: goto L_0x004d;
                case 14: goto L_0x004d;
                case 15: goto L_0x0042;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x0053
        L_0x0042:
            r10 = 13
            return r10
        L_0x0045:
            return r6
        L_0x0046:
            r10 = 11
            return r10
        L_0x0049:
            return r1
        L_0x004a:
            r10 = 12
        L_0x004c:
            return r10
        L_0x004d:
            if (r3 == r6) goto L_0x0056
            if (r3 == r5) goto L_0x0055
            if (r3 == r1) goto L_0x0054
        L_0x0053:
            return r7
        L_0x0054:
            return r1
        L_0x0055:
            return r10
        L_0x0056:
            return r0
        L_0x0057:
            r10 = -1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.PlatformChannel.decodeOrientations(org.json.JSONArray):int");
    }

    /* access modifiers changed from: private */
    @NonNull
    public SystemChromeStyle decodeSystemChromeStyle(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
        Integer num;
        Brightness brightness;
        Boolean bool;
        Integer num2;
        Brightness brightness2;
        Integer num3;
        Boolean bool2 = null;
        if (!jSONObject.isNull("statusBarColor")) {
            num = Integer.valueOf(jSONObject.getInt("statusBarColor"));
        } else {
            num = null;
        }
        if (!jSONObject.isNull("statusBarIconBrightness")) {
            brightness = Brightness.a(jSONObject.getString("statusBarIconBrightness"));
        } else {
            brightness = null;
        }
        if (!jSONObject.isNull("systemStatusBarContrastEnforced")) {
            bool = Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced"));
        } else {
            bool = null;
        }
        if (!jSONObject.isNull("systemNavigationBarColor")) {
            num2 = Integer.valueOf(jSONObject.getInt("systemNavigationBarColor"));
        } else {
            num2 = null;
        }
        if (!jSONObject.isNull("systemNavigationBarIconBrightness")) {
            brightness2 = Brightness.a(jSONObject.getString("systemNavigationBarIconBrightness"));
        } else {
            brightness2 = null;
        }
        if (!jSONObject.isNull("systemNavigationBarDividerColor")) {
            num3 = Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor"));
        } else {
            num3 = null;
        }
        if (!jSONObject.isNull("systemNavigationBarContrastEnforced")) {
            bool2 = Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced"));
        }
        return new SystemChromeStyle(num, brightness, bool, num2, brightness2, num3, bool2);
    }

    /* access modifiers changed from: private */
    @NonNull
    public SystemUiMode decodeSystemUiMode(@NonNull String str) throws JSONException, NoSuchFieldException {
        int i11 = AnonymousClass2.f14218c[SystemUiMode.a(str).ordinal()];
        if (i11 == 1) {
            return SystemUiMode.LEAN_BACK;
        }
        if (i11 == 2) {
            return SystemUiMode.IMMERSIVE;
        }
        if (i11 == 3) {
            return SystemUiMode.IMMERSIVE_STICKY;
        }
        if (i11 != 4) {
            return SystemUiMode.EDGE_TO_EDGE;
        }
        return SystemUiMode.EDGE_TO_EDGE;
    }

    /* access modifiers changed from: private */
    @NonNull
    public List<SystemUiOverlay> decodeSystemUiOverlays(@NonNull JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            int i12 = AnonymousClass2.f14217b[SystemUiOverlay.a(jSONArray.getString(i11)).ordinal()];
            if (i12 == 1) {
                arrayList.add(SystemUiOverlay.TOP_OVERLAYS);
            } else if (i12 == 2) {
                arrayList.add(SystemUiOverlay.BOTTOM_OVERLAYS);
            }
        }
        return arrayList;
    }

    public void setPlatformMessageHandler(@Nullable PlatformMessageHandler platformMessageHandler2) {
        this.platformMessageHandler = platformMessageHandler2;
    }

    public void systemChromeChanged(boolean z11) {
        Log.v(TAG, "Sending 'systemUIChange' message.");
        this.channel.invokeMethod("SystemChrome.systemUIChange", Arrays.asList(new Boolean[]{Boolean.valueOf(z11)}));
    }
}
