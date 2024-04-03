package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.tagmanager.ModuleDescriptor;
import com.huawei.hms.flutter.map.constants.Param;
import com.newrelic.agent.android.Agent;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzfn {
    public static final int zza;
    public static final String zzb;
    public static final String zzc;
    public static final String zzd;
    public static final String zze;
    public static final byte[] zzf = new byte[0];
    private static final Pattern zzg = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
    private static final Pattern zzh = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final Pattern zzi = Pattern.compile("%([A-Fa-f0-9]{2})");
    private static final Pattern zzj = Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
    @Nullable
    private static HashMap<String, String> zzk;
    private static final String[] zzl = {"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
    private static final String[] zzm = {"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
    private static final int[] zzn = {0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    private static final int[] zzo = {0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, ModuleDescriptor.MODULE_VERSION, 209, 196, Opcodes.MONITOREXIT, 202, 205, Opcodes.D2F, Opcodes.DCMPL, Opcodes.IFLE, Opcodes.IFEQ, Opcodes.F2L, Opcodes.F2I, 130, Opcodes.I2L, Opcodes.JSR, Opcodes.DRETURN, Opcodes.IF_ACMPNE, Opcodes.IF_ICMPLT, 180, Opcodes.PUTSTATIC, Opcodes.INVOKEDYNAMIC, 189, Opcodes.IFNONNULL, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, Opcodes.INVOKESPECIAL, Opcodes.ARETURN, Opcodes.INVOKEINTERFACE, 190, Opcodes.LOOKUPSWITCH, 172, Opcodes.IF_ACMPEQ, Opcodes.IF_ICMPGE, Opcodes.D2L, Opcodes.L2I, 129, 134, Opcodes.I2S, 148, Opcodes.IFGT, Opcodes.IFNE, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, Opcodes.L2F, Opcodes.D2I, 135, 128, Opcodes.FCMPL, Opcodes.I2C, 155, Opcodes.IFGE, Opcodes.RETURN, Opcodes.INVOKEVIRTUAL, Opcodes.ATHROW, Opcodes.INVOKESTATIC, Opcodes.LRETURN, Opcodes.TABLESWITCH, Opcodes.IF_ICMPGT, Opcodes.IF_ICMPLE, 249, 254, 247, PsExtractor.VIDEO_STREAM_MASK, 229, 226, 235, 236, Opcodes.INSTANCEOF, Opcodes.IFNULL, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, Opcodes.FRETURN, Opcodes.RET, Opcodes.IF_ICMPNE, Opcodes.GOTO, Opcodes.GETSTATIC, Opcodes.PUTFIELD, 188, Opcodes.NEW, 150, Opcodes.I2B, Opcodes.DCMPG, Opcodes.IF_ICMPEQ, 138, Opcodes.F2D, Opcodes.IINC, 131, 222, 217, 208, 215, Opcodes.MONITORENTER, Opcodes.MULTIANEWARRAY, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};

    static {
        int i11 = Build.VERSION.SDK_INT;
        zza = i11;
        String str = Build.DEVICE;
        zzb = str;
        String str2 = Build.MANUFACTURER;
        zzc = str2;
        String str3 = Build.MODEL;
        zzd = str3;
        int length = String.valueOf(str).length();
        StringBuilder sb2 = new StringBuilder(length + 17 + String.valueOf(str3).length() + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(str3);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(str2);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(i11);
        zze = sb2.toString();
    }

    public static Looper zzA() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return myLooper;
        }
        return Looper.getMainLooper();
    }

    public static zzab zzB(int i11, int i12, int i13) {
        zzz zzz = new zzz();
        zzz.zzS(MimeTypes.AUDIO_RAW);
        zzz.zzw(i12);
        zzz.zzT(i13);
        zzz.zzN(i11);
        return zzz.zzY();
    }

    @EnsuresNonNull({"#1"})
    public static <T> T zzC(@Nullable T t11) {
        return t11;
    }

    public static String zzD(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String zzE(byte[] bArr, int i11, int i12) {
        return new String(bArr, i11, i12, zzfpt.zzc);
    }

    public static String zzF(Object[] objArr) {
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        while (true) {
            int length = objArr.length;
            if (i11 >= length) {
                return sb2.toString();
            }
            sb2.append(objArr[i11].getClass().getSimpleName());
            if (i11 < length - 1) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            i11++;
        }
    }

    public static String zzG(@Nullable Context context) {
        TelephonyManager telephonyManager;
        if (!(context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null)) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return zzfpn.zzb(networkCountryIso);
            }
        }
        return zzfpn.zzb(Locale.getDefault().getCountry());
    }

    public static String zzH(int i11) {
        if (i11 == 0) {
            return Agent.MONO_INSTRUMENTATION_FLAG;
        }
        if (i11 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i11 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i11 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i11 == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    public static String zzI(Locale locale) {
        if (zza >= 21) {
            return locale.toLanguageTag();
        }
        return locale.toString();
    }

    public static String zzJ(int i11) {
        switch (i11) {
            case 0:
                return "default";
            case 1:
                return MimeTypes.BASE_TYPE_AUDIO;
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return TtmlNode.TAG_METADATA;
            case 6:
                return "camera motion";
            default:
                return TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
    }

    public static String zzK(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', SignatureVisitor.SUPER);
        if (!replace.isEmpty() && !replace.equals(C.LANGUAGE_UNDETERMINED)) {
            str = replace;
        }
        String zza2 = zzfpn.zza(str);
        int i11 = 0;
        String str2 = zza2.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, 2)[0];
        if (zzk == null) {
            zzk = zzaf();
        }
        String str3 = zzk.get(str2);
        if (str3 != null) {
            String valueOf = String.valueOf(zza2.substring(str2.length()));
            if (valueOf.length() != 0) {
                zza2 = str3.concat(valueOf);
            } else {
                zza2 = new String(str3);
            }
            str2 = str3;
        }
        if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
            return zza2;
        }
        while (true) {
            String[] strArr = zzm;
            int length = strArr.length;
            if (i11 >= 18) {
                return zza2;
            }
            if (zza2.startsWith(strArr[i11])) {
                String valueOf2 = String.valueOf(strArr[i11 + 1]);
                String valueOf3 = String.valueOf(zza2.substring(strArr[i11].length()));
                if (valueOf3.length() != 0) {
                    return valueOf2.concat(valueOf3);
                }
                return new String(valueOf2);
            }
            i11 += 2;
        }
    }

    public static ExecutorService zzL(String str) {
        return Executors.newSingleThreadExecutor(new zzfm("ExoPlayer:Loader:ProgressiveMediaPeriod"));
    }

    public static void zzM(@Nullable zzdi zzdi) {
        try {
            zzdi.zzj();
        } catch (IOException unused) {
        }
    }

    public static void zzN(long[] jArr, long j11, long j12) {
        int i11 = (j12 > 1000000 ? 1 : (j12 == 1000000 ? 0 : -1));
        int i12 = 0;
        if (i11 >= 0 && j12 % 1000000 == 0) {
            long j13 = j12 / 1000000;
            while (i12 < jArr.length) {
                jArr[i12] = jArr[i12] / j13;
                i12++;
            }
        } else if (i11 >= 0 || 1000000 % j12 != 0) {
            double d11 = 1000000.0d / ((double) j12);
            while (i12 < jArr.length) {
                jArr[i12] = (long) (((double) jArr[i12]) * d11);
                i12++;
            }
        } else {
            long j14 = 1000000 / j12;
            while (i12 < jArr.length) {
                jArr[i12] = jArr[i12] * j14;
                i12++;
            }
        }
    }

    public static void zzO(Parcel parcel, boolean z11) {
        parcel.writeInt(z11 ? 1 : 0);
    }

    public static boolean zzP(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static boolean zzQ(int i11) {
        return i11 == 536870912 || i11 == 805306368 || i11 == 4;
    }

    public static boolean zzR(int i11) {
        return i11 == 3 || i11 == 2 || i11 == 268435456 || i11 == 536870912 || i11 == 805306368 || i11 == 4;
    }

    public static boolean zzS(Uri uri) {
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || "file".equals(scheme)) {
            return true;
        }
        return false;
    }

    public static boolean zzT(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        if (uiModeManager == null || uiModeManager.getCurrentModeType() != 4) {
            return false;
        }
        return true;
    }

    public static boolean zzU(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static boolean zzV(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static byte[] zzW(String str) {
        return str.getBytes(zzfpt.zzc);
    }

    public static byte[] zzX(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[] zzY(T[] tArr) {
        return tArr;
    }

    public static <T> T[] zzZ(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] copyOf = Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, copyOf, length, length2);
        return copyOf;
    }

    public static float zza(float f11, float f12, float f13) {
        return Math.max(f12, Math.min(f11, f13));
    }

    public static <T> T[] zzaa(T[] tArr, int i11) {
        boolean z11;
        if (i11 <= tArr.length) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzd(z11);
        return Arrays.copyOf(tArr, i11);
    }

    public static String[] zzab() {
        String[] strArr;
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (zza >= 24) {
            strArr = configuration.getLocales().toLanguageTags().split(",", -1);
        } else {
            strArr = new String[]{zzI(configuration.locale)};
        }
        for (int i11 = 0; i11 < strArr.length; i11++) {
            strArr[i11] = zzK(strArr[i11]);
        }
        return strArr;
    }

    public static String[] zzac(String str, String str2) {
        return str.split(str2, -1);
    }

    public static String[] zzad(String str, String str2) {
        return str.split(str2, 2);
    }

    @Nullable
    private static String zzae(String str) {
        String str2;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e11) {
            if (str.length() != 0) {
                str2 = "Failed to read system property ".concat(str);
            } else {
                str2 = new String("Failed to read system property ");
            }
            zzep.zza("Util", str2, e11);
            return null;
        }
    }

    private static HashMap<String, String> zzaf() {
        int length = zzl.length;
        HashMap<String, String> hashMap = new HashMap<>(r2 + 86);
        int i11 = 0;
        for (String str : Locale.getISOLanguages()) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = zzl;
            int length2 = strArr.length;
            if (i11 >= 86) {
                return hashMap;
            }
            hashMap.put(strArr[i11], strArr[i11 + 1]);
            i11 += 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(long[] r2, long r3, boolean r5, boolean r6) {
        /*
            int r6 = java.util.Arrays.binarySearch(r2, r3)
            if (r6 >= 0) goto L_0x0008
            int r2 = ~r6
            goto L_0x0016
        L_0x0008:
            int r6 = r6 + 1
            int r0 = r2.length
            if (r6 >= r0) goto L_0x0013
            r0 = r2[r6]
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0008
        L_0x0013:
            if (r5 != 0) goto L_0x0017
            r2 = r6
        L_0x0016:
            return r2
        L_0x0017:
            int r6 = r6 + -1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfn.zzb(long[], long, boolean, boolean):int");
    }

    public static int zzc(int[] iArr, int i11, boolean z11, boolean z12) {
        int binarySearch = Arrays.binarySearch(iArr, i11);
        if (binarySearch < 0) {
            return -(binarySearch + 2);
        }
        do {
            binarySearch--;
            if (binarySearch < 0 || iArr[binarySearch] != i11) {
            }
            binarySearch--;
            break;
        } while (iArr[binarySearch] != i11);
        return binarySearch;
    }

    public static int zzd(long[] jArr, long j11, boolean z11, boolean z12) {
        int i11;
        int binarySearch = Arrays.binarySearch(jArr, j11);
        if (binarySearch < 0) {
            i11 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0 || jArr[binarySearch] != j11) {
                    i11 = binarySearch + 1;
                }
                binarySearch--;
                break;
            } while (jArr[binarySearch] != j11);
            i11 = binarySearch + 1;
        }
        if (z12) {
            return Math.max(0, i11);
        }
        return i11;
    }

    public static int zze(int i11, int i12) {
        return ((i11 + i12) - 1) / i12;
    }

    public static int zzf(int i11, int i12, int i13) {
        return Math.max(i12, Math.min(i11, i13));
    }

    public static int zzg(byte[] bArr, int i11, int i12, int i13) {
        int i14 = -1;
        for (int i15 = 0; i15 < i12; i15++) {
            i14 = zzn[(i14 >>> 24) ^ (bArr[i15] & 255)] ^ (i14 << 8);
        }
        return i14;
    }

    public static int zzh(byte[] bArr, int i11, int i12, int i13) {
        int i14 = 0;
        while (i11 < i12) {
            i14 = zzo[i14 ^ (bArr[i11] & 255)];
            i11++;
        }
        return i14;
    }

    @RequiresApi(21)
    public static int zzi(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static int zzj(int i11) {
        switch (i11) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int i12 = zza;
                return (i12 < 23 && i12 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int zzk(int i11) {
        if (i11 == 2 || i11 == 4) {
            return 6005;
        }
        if (i11 == 10) {
            return 6004;
        }
        if (i11 == 7) {
            return 6005;
        }
        if (i11 == 8) {
            return 6003;
        }
        switch (i11) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i11) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static int zzl(int i11) {
        if (i11 == 8) {
            return 3;
        }
        if (i11 == 16) {
            return 2;
        }
        if (i11 != 24) {
            return i11 != 32 ? 0 : 805306368;
        }
        return 536870912;
    }

    public static int zzm(int i11, int i12) {
        if (i11 != 2) {
            if (i11 == 3) {
                return i12;
            }
            if (i11 != 4) {
                if (i11 != 268435456) {
                    if (i11 == 536870912) {
                        return i12 * 3;
                    }
                    if (i11 != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i12 * 4;
        }
        return i12 + i12;
    }

    public static long zzn(long j11, long j12, long j13) {
        long j14 = j11 + j12;
        if (((j11 ^ j14) & (j12 ^ j14)) < 0) {
            return Long.MAX_VALUE;
        }
        return j14;
    }

    public static long zzo(long j11, long j12, long j13) {
        return Math.max(j12, Math.min(j11, j13));
    }

    public static long zzp(long j11, float f11) {
        return f11 == 1.0f ? j11 : Math.round(((double) j11) * ((double) f11));
    }

    public static long zzq(long j11) {
        if (j11 == C.TIME_UNSET) {
            return System.currentTimeMillis();
        }
        return j11 + SystemClock.elapsedRealtime();
    }

    public static long zzr(long j11, float f11) {
        return f11 == 1.0f ? j11 : Math.round(((double) j11) / ((double) f11));
    }

    public static long zzs(long j11) {
        return (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? j11 : j11 * 1000;
    }

    public static long zzt(long j11, long j12, long j13) {
        int i11 = (j13 > j12 ? 1 : (j13 == j12 ? 0 : -1));
        if (i11 >= 0 && j13 % j12 == 0) {
            return j11 / (j13 / j12);
        }
        if (i11 >= 0 || j12 % j13 != 0) {
            return (long) (((double) j11) * (((double) j12) / ((double) j13)));
        }
        return j11 * (j12 / j13);
    }

    public static long zzu(long j11, long j12, long j13) {
        long j14 = j11 - j12;
        if (((j11 ^ j14) & (j12 ^ j11)) < 0) {
            return Long.MIN_VALUE;
        }
        return j14;
    }

    public static long zzv(int i11, int i12) {
        return (((long) i12) & 4294967295L) | ((((long) i11) & 4294967295L) << 32);
    }

    public static long zzw(long j11) {
        return (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? j11 : j11 / 1000;
    }

    public static Point zzx(Context context) {
        String str;
        String str2;
        DisplayManager displayManager;
        int i11 = zza;
        Display display = null;
        if (i11 >= 17 && (displayManager = (DisplayManager) context.getSystemService("display")) != null) {
            display = displayManager.getDisplay(0);
        }
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getClass();
            display = windowManager.getDefaultDisplay();
        }
        if (display.getDisplayId() == 0 && zzT(context)) {
            if (i11 < 28) {
                str = zzae("sys.display-size");
            } else {
                str = zzae("vendor.display-size");
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    String[] split = str.trim().split(Param.X, -1);
                    if (split.length == 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str2 = "Invalid display size: ".concat(valueOf);
                } else {
                    str2 = new String("Invalid display size: ");
                }
                Log.e("Util", str2);
            }
            if ("Sony".equals(zzc) && zzd.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        int i12 = zza;
        if (i12 >= 23) {
            Display.Mode mode = display.getMode();
            point.x = mode.getPhysicalWidth();
            point.y = mode.getPhysicalHeight();
            return point;
        } else if (i12 >= 17) {
            display.getRealSize(point);
            return point;
        } else {
            display.getSize(point);
            return point;
        }
    }

    public static Handler zzy(Looper looper, @Nullable Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static Handler zzz(@Nullable Handler.Callback callback) {
        Looper myLooper = Looper.myLooper();
        zzdy.zzb(myLooper);
        return new Handler(myLooper, (Handler.Callback) null);
    }
}
