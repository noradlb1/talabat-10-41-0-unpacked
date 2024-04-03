package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.formats.zzg;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblb;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbne;
import com.google.android.gms.internal.ads.zzcee;
import com.google.android.gms.internal.ads.zzcis;
import com.google.android.gms.internal.ads.zzciy;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzcjm;
import com.google.android.gms.internal.ads.zzcog;
import com.google.android.gms.internal.ads.zzcpm;
import com.google.android.gms.internal.ads.zzdwm;
import com.google.android.gms.internal.ads.zzfdn;
import com.google.android.gms.internal.ads.zzfdq;
import com.google.android.gms.internal.ads.zzfpj;
import com.google.android.gms.internal.ads.zzfwq;
import com.google.android.gms.internal.ads.zzfxa;
import com.google.android.gms.internal.ads.zzgqf;
import datamodels.TypesAliasesKt;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzt {
    public static final zzfpj zza = new zzf(Looper.getMainLooper());
    /* access modifiers changed from: private */
    @GuardedBy("AdUtil.class")
    public static boolean zzb = false;
    private final AtomicReference<Pattern> zzc = new AtomicReference<>((Object) null);
    private final AtomicReference<Pattern> zzd = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public boolean zze = true;
    /* access modifiers changed from: private */
    public final Object zzf = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("userAgentLock")
    public String zzg;
    private boolean zzh = false;
    private boolean zzi = false;
    private final Executor zzj = Executors.newSingleThreadExecutor();

    public static final long zzA(View view) {
        float f11;
        int i11;
        float f12 = Float.MAX_VALUE;
        Object obj = view;
        do {
            f11 = 0.0f;
            if (!(obj instanceof View)) {
                break;
            }
            View view2 = (View) obj;
            f12 = Math.min(f12, view2.getAlpha());
            i11 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
            obj = view2.getParent();
        } while (i11 > 0);
        if (f12 >= 0.0f) {
            f11 = f12;
        }
        return (long) Math.round(f11 * 100.0f);
    }

    @Nullable
    public static final WebResourceResponse zzB(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", com.google.android.gms.ads.internal.zzt.zzp().zzd(context, str));
            hashMap.put("Cache-Control", "max-stale=3600");
            String str3 = new zzbs(context).zzb(0, str2, hashMap, (byte[]) null).get(60, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e11) {
            zzciz.zzk("Could not fetch MRAID JS.", e11);
        }
        return null;
    }

    public static final int zzC(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (PlatformVersion.isAtLeastR()) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgl)).booleanValue()) {
                return 0;
            }
        }
        return telephonyManager.getNetworkType();
    }

    public static final String zzD() {
        Resources zzd2 = com.google.android.gms.ads.internal.zzt.zzo().zzd();
        if (zzd2 != null) {
            return zzd2.getString(R.string.f35094s7);
        }
        return "Test Ad";
    }

    public static final zzbv zzE(Context context) {
        try {
            Object newInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzciz.zzg("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            if (queryLocalInterface instanceof zzbv) {
                return (zzbv) queryLocalInterface;
            }
            return new zzbt(iBinder);
        } catch (Exception e11) {
            com.google.android.gms.ads.internal.zzt.zzo().zzs(e11, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }

    public static final boolean zzF(Context context, String str) {
        Context zza2 = zzcee.zza(context);
        if (Wrappers.packageManager(zza2).checkPermission(str, zza2.getPackageName()) == 0) {
            return true;
        }
        return false;
    }

    public static final boolean zzG(String str) {
        if (!zzciy.zzl()) {
            return false;
        }
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzdx)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzbgq.zzc().zzb(zzblj.zzdz);
        if (!str2.isEmpty()) {
            for (String equals : str2.split(TypesAliasesKt.separator)) {
                if (equals.equals(str)) {
                    return false;
                }
            }
        }
        String str3 = (String) zzbgq.zzc().zzb(zzblj.zzdy);
        if (str3.isEmpty()) {
            return true;
        }
        for (String equals2 : str3.split(TypesAliasesKt.separator)) {
            if (equals2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(16)
    public static final boolean zzH(Context context) {
        KeyguardManager zzab;
        if (context == null || !PlatformVersion.isAtLeastJellyBean() || (zzab = zzab(context)) == null || !zzab.isKeyguardLocked()) {
            return false;
        }
        return true;
    }

    public static final boolean zzI(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th2) {
            zzciz.zzh("Error loading class.", th2);
            com.google.android.gms.ads.internal.zzt.zzo().zzs(th2, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static final boolean zzJ(Context context) {
        boolean z11;
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgj)).booleanValue()) {
                synchronized (zzt.class) {
                    z11 = zzb;
                }
                return z11;
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static final boolean zzK(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager != null) {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses == null) {
                        return false;
                    }
                    for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                        if (Process.myPid() == next.pid) {
                            if (next.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                                return true;
                            }
                            PowerManager powerManager = (PowerManager) context.getSystemService("power");
                            if (powerManager == null) {
                                return true;
                            }
                            if (powerManager.isScreenOn()) {
                                return false;
                            }
                            return true;
                        }
                    }
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static final boolean zzL(Context context) {
        Bundle zzac = zzac(context);
        String string = zzac.getString("com.google.android.gms.ads.INTEGRATION_MANAGER");
        if (!TextUtils.isEmpty(zzad(zzac)) || TextUtils.isEmpty(string)) {
            return false;
        }
        return true;
    }

    public static final boolean zzM(Context context) {
        Window window;
        if (!(!(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || window.getDecorView() == null)) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, (Point) null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static final void zzN(View view, int i11, MotionEvent motionEvent) {
        int i12;
        String str;
        int i13;
        int i14;
        String str2;
        zzfdn zzF;
        View view2 = view;
        int[] iArr = new int[2];
        Rect rect = new Rect();
        try {
            String packageName = view.getContext().getPackageName();
            if (view2 instanceof zzdwm) {
                view2 = ((zzdwm) view2).getChildAt(0);
            }
            if ((view2 instanceof zzg) || (view2 instanceof NativeAdView)) {
                str = "NATIVE";
                i12 = 1;
            } else {
                str = "UNKNOWN";
                i12 = 0;
            }
            if (view2.getLocalVisibleRect(rect)) {
                i13 = rect.width();
                i14 = rect.height();
            } else {
                i14 = 0;
                i13 = 0;
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            long zzA = zzA(view2);
            view2.getLocationOnScreen(iArr);
            int i15 = iArr[0];
            int i16 = iArr[1];
            String str3 = "none";
            if (view2 instanceof zzcpm) {
                zzfdq zzR = ((zzcpm) view2).zzR();
                if (zzR != null) {
                    str2 = zzR.zzb;
                    int hashCode = view2.hashCode();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 12);
                    sb2.append(str2);
                    sb2.append(CertificateUtil.DELIMITER);
                    sb2.append(hashCode);
                    view2.setContentDescription(sb2.toString());
                    if ((view2 instanceof zzcog) && (zzF = ((zzcog) view2).zzF()) != null) {
                        str = zzfdn.zza(zzF.zzb);
                        i12 = zzF.zzf;
                        str3 = zzF.zzF;
                    }
                    zzciz.zzi(String.format(Locale.US, "<Ad hashCode=%d, package=%s, adNetCls=%s, gwsQueryId=%s, format=%s, impType=%d, class=%s, x=%d, y=%d, width=%d, height=%d, vWidth=%d, vHeight=%d, alpha=%d, state=%s>", new Object[]{Integer.valueOf(view2.hashCode()), packageName, str3, str2, str, Integer.valueOf(i12), view2.getClass().getName(), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(view2.getWidth()), Integer.valueOf(view2.getHeight()), Integer.valueOf(i13), Integer.valueOf(i14), Long.valueOf(zzA), Integer.toString(i11, 2)}));
                }
            }
            str2 = str3;
            str = zzfdn.zza(zzF.zzb);
            i12 = zzF.zzf;
            str3 = zzF.zzF;
            zzciz.zzi(String.format(Locale.US, "<Ad hashCode=%d, package=%s, adNetCls=%s, gwsQueryId=%s, format=%s, impType=%d, class=%s, x=%d, y=%d, width=%d, height=%d, vWidth=%d, vHeight=%d, alpha=%d, state=%s>", new Object[]{Integer.valueOf(view2.hashCode()), packageName, str3, str2, str, Integer.valueOf(i12), view2.getClass().getName(), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(view2.getWidth()), Integer.valueOf(view2.getHeight()), Integer.valueOf(i13), Integer.valueOf(i14), Long.valueOf(zzA), Integer.toString(i11, 2)}));
        } catch (Exception e11) {
            zzciz.zzh("Failure getting view location.", e11);
        }
    }

    public static final void zzO(Context context, String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        for (String zzcc : arrayList) {
            new zzcc(context, str, zzcc).zzb();
        }
    }

    public static final void zzP(Context context, Throwable th2) {
        if (context != null) {
            try {
                if (zzbne.zzb.zze().booleanValue()) {
                    CrashUtils.addDynamiteErrorToDropBox(context, th2);
                }
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static final void zzQ(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static final int zzR(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e11) {
            zzciz.zzj("Could not parse value:".concat(e11.toString()));
            return 0;
        }
    }

    public static final Map<String, String> zzS(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String next : uri.getQueryParameterNames()) {
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, uri.getQueryParameter(next));
            }
        }
        return hashMap;
    }

    public static final WebResourceResponse zzT(HttpURLConnection httpURLConnection) throws IOException {
        String str;
        com.google.android.gms.ads.internal.zzt.zzp();
        String contentType = httpURLConnection.getContentType();
        String str2 = "";
        if (TextUtils.isEmpty(contentType)) {
            str = str2;
        } else {
            str = contentType.split(TypesAliasesKt.separator)[0].trim();
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        String contentType2 = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType2)) {
            String[] split = contentType2.split(TypesAliasesKt.separator);
            if (split.length != 1) {
                int i11 = 1;
                while (true) {
                    if (i11 >= split.length) {
                        break;
                    }
                    if (split[i11].trim().startsWith("charset")) {
                        String[] split2 = split[i11].trim().split("=");
                        if (split2.length > 1) {
                            str2 = split2[1].trim();
                            break;
                        }
                    }
                    i11++;
                }
            }
        }
        String str3 = str2;
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        HashMap hashMap = new HashMap(headerFields.size());
        for (Map.Entry next : headerFields.entrySet()) {
            if (!(next.getKey() == null || next.getValue() == null || ((List) next.getValue()).size() <= 0)) {
                hashMap.put((String) next.getKey(), (String) ((List) next.getValue()).get(0));
            }
        }
        return com.google.android.gms.ads.internal.zzt.zzq().zzm(str, str3, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }

    public static final int[] zzU(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        if (window == null || (findViewById = window.findViewById(16908290)) == null) {
            return zzz();
        }
        return new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    @VisibleForTesting
    public static final String zzV(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return zzw();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.findViewById(16908290);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int[] zzW(android.app.Activity r6) {
        /*
            android.view.Window r0 = r6.getWindow()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0021
            r4 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r4)
            if (r0 == 0) goto L_0x0021
            int[] r4 = new int[r1]
            int r5 = r0.getTop()
            r4[r3] = r5
            int r0 = r0.getBottom()
            r4[r2] = r0
            goto L_0x0025
        L_0x0021:
            int[] r4 = zzz()
        L_0x0025:
            int[] r0 = new int[r1]
            com.google.android.gms.internal.ads.zzcis r1 = com.google.android.gms.internal.ads.zzbgo.zzb()
            r5 = r4[r3]
            int r1 = r1.zzb(r6, r5)
            r0[r3] = r1
            com.google.android.gms.internal.ads.zzcis r1 = com.google.android.gms.internal.ads.zzbgo.zzb()
            r3 = r4[r2]
            int r6 = r1.zzb(r6, r3)
            r0[r2] = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzt.zzW(android.app.Activity):int[]");
    }

    public static final boolean zzX(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z11;
        if (com.google.android.gms.ads.internal.zzt.zzp().zze || keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode() || zzt(view)) {
            z11 = true;
        } else {
            z11 = false;
        }
        long zzA = zzA(view);
        if (view.getVisibility() == 0 && view.isShown() && ((powerManager == null || powerManager.isScreenOn()) && z11)) {
            if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzaW)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzhc)).booleanValue()) {
                    return true;
                }
                if (zzA >= ((long) ((Integer) zzbgq.zzc().zzb(zzblj.zzhe)).intValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @TargetApi(18)
    public static final void zzY(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzu(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(uri2).length() + 26);
            sb2.append("Opening ");
            sb2.append(uri2);
            sb2.append(" in a new browser.");
            zzciz.zze(sb2.toString());
        } catch (ActivityNotFoundException e11) {
            zzciz.zzh("No browser is found.", e11);
        }
    }

    public static final int[] zzZ(Activity activity) {
        int[] zzU = zzU(activity);
        return new int[]{zzbgo.zzb().zzb(activity, zzU[0]), zzbgo.zzb().zzb(activity, zzU[1])};
    }

    public static int zza(int i11) {
        if (i11 >= 5000) {
            return i11;
        }
        if (i11 <= 0) {
            return 60000;
        }
        StringBuilder sb2 = new StringBuilder(97);
        sb2.append("HTTP timeout too low: ");
        sb2.append(i11);
        sb2.append(" milliseconds. Reverting to default timeout: 60000 milliseconds.");
        zzciz.zzj(sb2.toString());
        return 60000;
    }

    public static final boolean zzaa(View view, Context context) {
        PowerManager powerManager;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            powerManager = (PowerManager) applicationContext.getSystemService("power");
        } else {
            powerManager = null;
        }
        return zzX(view, powerManager, zzab(context));
    }

    @Nullable
    private static KeyguardManager zzab(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    private static Bundle zzac(Context context) {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e11) {
            zze.zzb("Error getting metadata", e11);
            return null;
        }
    }

    private static String zzad(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        if (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) {
            return string;
        }
        return "";
    }

    private final JSONArray zzae(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object zzaf : collection) {
            zzaf(jSONArray, zzaf);
        }
        return jSONArray;
    }

    private final void zzaf(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put((Object) zze((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put((Object) zzf((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put((Object) zzae((Collection) obj));
        } else if (obj instanceof Object[]) {
            JSONArray jSONArray2 = new JSONArray();
            for (Object zzaf : (Object[]) obj) {
                zzaf(jSONArray2, zzaf);
            }
            jSONArray.put((Object) jSONArray2);
        } else {
            jSONArray.put(obj);
        }
    }

    private final void zzag(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, (Object) zze((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, (Object) zzf((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, (Object) zzae((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, (Object) zzae(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private static boolean zzah(String str, AtomicReference<Pattern> atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern pattern = atomicReference.get();
            if (pattern == null || !str2.equals(pattern.pattern())) {
                pattern = Pattern.compile(str2);
                atomicReference.set(pattern);
            }
            return pattern.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public static void zzm(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzcjm.zza.execute(runnable);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean zzt(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 != 0) goto L_0x0009
        L_0x0007:
            r2 = r0
            goto L_0x0013
        L_0x0009:
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0007
            android.app.Activity r2 = (android.app.Activity) r2
        L_0x0013:
            r1 = 0
            if (r2 != 0) goto L_0x0017
            return r1
        L_0x0017:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L_0x0022:
            if (r0 == 0) goto L_0x002d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x002d
            r2 = 1
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzt.zzt(android.view.View):boolean");
    }

    @TargetApi(18)
    public static final void zzu(Context context, Intent intent) {
        Bundle bundle;
        if (intent != null && PlatformVersion.isAtLeastJellyBeanMR2()) {
            if (intent.getExtras() != null) {
                bundle = intent.getExtras();
            } else {
                bundle = new Bundle();
            }
            bundle.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(bundle);
        }
    }

    public static final String zzv(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return zzad(zzac(context));
    }

    public static final String zzw() {
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append("Mozilla/5.0 (Linux; U; Android");
        String str = Build.VERSION.RELEASE;
        if (str != null) {
            sb2.append(" ");
            sb2.append(str);
        }
        sb2.append("; ");
        sb2.append(Locale.getDefault());
        String str2 = Build.DEVICE;
        if (str2 != null) {
            sb2.append("; ");
            sb2.append(str2);
            String str3 = Build.DISPLAY;
            if (str3 != null) {
                sb2.append(" Build/");
                sb2.append(str3);
            }
        }
        sb2.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb2.toString();
    }

    public static final String zzx() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1 + str2.length());
        sb2.append(str);
        sb2.append(" ");
        sb2.append(str2);
        return sb2.toString();
    }

    public static final DisplayMetrics zzy(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static final int[] zzz() {
        return new int[]{0, 0};
    }

    public final zzfxa<Map<String, String>> zzb(Uri uri) {
        return zzfwq.zzk(new zzk(uri), this.zzj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0039, code lost:
        continue;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0043 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0023 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a A[Catch:{ Exception -> 0x00a9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzd(android.content.Context r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzf
            monitor-enter(r0)
            java.lang.String r1 = r4.zzg     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x00c3 }
            return r1
        L_0x0009:
            if (r6 != 0) goto L_0x0011
            java.lang.String r5 = zzw()     // Catch:{ all -> 0x00c3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c3 }
            return r5
        L_0x0011:
            com.google.android.gms.ads.internal.util.zzae r1 = com.google.android.gms.ads.internal.zzt.zzq()     // Catch:{ Exception -> 0x001b }
            java.lang.String r1 = r1.zzd(r5)     // Catch:{ Exception -> 0x001b }
            r4.zzg = r1     // Catch:{ Exception -> 0x001b }
        L_0x001b:
            java.lang.String r1 = r4.zzg     // Catch:{ all -> 0x00c3 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzbgo.zzb()     // Catch:{ all -> 0x00c3 }
            boolean r1 = com.google.android.gms.internal.ads.zzcis.zzp()     // Catch:{ all -> 0x00c3 }
            if (r1 != 0) goto L_0x0063
            r1 = 0
            r4.zzg = r1     // Catch:{ all -> 0x00c3 }
            com.google.android.gms.internal.ads.zzfpj r1 = zza     // Catch:{ all -> 0x00c3 }
            com.google.android.gms.ads.internal.util.zzm r2 = new com.google.android.gms.ads.internal.util.zzm     // Catch:{ all -> 0x00c3 }
            r2.<init>(r4, r5)     // Catch:{ all -> 0x00c3 }
            r1.post(r2)     // Catch:{ all -> 0x00c3 }
        L_0x0039:
            java.lang.String r1 = r4.zzg     // Catch:{ all -> 0x00c3 }
            if (r1 != 0) goto L_0x0069
            java.lang.Object r1 = r4.zzf     // Catch:{ InterruptedException -> 0x0043 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0043 }
            goto L_0x0039
        L_0x0043:
            java.lang.String r1 = zzw()     // Catch:{ all -> 0x00c3 }
            r4.zzg = r1     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = "Interrupted, use default user agent: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00c3 }
            int r3 = r1.length()     // Catch:{ all -> 0x00c3 }
            if (r3 == 0) goto L_0x005a
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x00c3 }
            goto L_0x005f
        L_0x005a:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x00c3 }
            r1.<init>(r2)     // Catch:{ all -> 0x00c3 }
        L_0x005f:
            com.google.android.gms.internal.ads.zzciz.zzj(r1)     // Catch:{ all -> 0x00c3 }
            goto L_0x0039
        L_0x0063:
            java.lang.String r1 = zzV(r5)     // Catch:{ all -> 0x00c3 }
            r4.zzg = r1     // Catch:{ all -> 0x00c3 }
        L_0x0069:
            java.lang.String r1 = r4.zzg     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00c3 }
            int r2 = r1.length()     // Catch:{ all -> 0x00c3 }
            int r2 = r2 + 10
            int r3 = r6.length()     // Catch:{ all -> 0x00c3 }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
            r3.<init>(r2)     // Catch:{ all -> 0x00c3 }
            r3.append(r1)     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = " (Mobile; "
            r3.append(r1)     // Catch:{ all -> 0x00c3 }
            r3.append(r6)     // Catch:{ all -> 0x00c3 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x00c3 }
            r4.zzg = r6     // Catch:{ all -> 0x00c3 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r5 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r5)     // Catch:{ Exception -> 0x00a9 }
            boolean r5 = r5.isCallerInstantApp()     // Catch:{ Exception -> 0x00a9 }
            if (r5 == 0) goto L_0x00b3
            java.lang.String r5 = r4.zzg     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r6 = ";aia"
            java.lang.String r5 = r5.concat(r6)     // Catch:{ Exception -> 0x00a9 }
            r4.zzg = r5     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00b3
        L_0x00a9:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzcik r6 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = "AdUtil.getUserAgent"
            r6.zzs(r5, r1)     // Catch:{ all -> 0x00c3 }
        L_0x00b3:
            java.lang.String r5 = r4.zzg     // Catch:{ all -> 0x00c3 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00c3 }
            java.lang.String r6 = ")"
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x00c3 }
            r4.zzg = r5     // Catch:{ all -> 0x00c3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c3 }
            return r5
        L_0x00c3:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c3 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzt.zzd(android.content.Context, java.lang.String):java.lang.String");
    }

    public final JSONObject zze(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String next : bundle.keySet()) {
            zzag(jSONObject, next, bundle.get(next));
        }
        return jSONObject;
    }

    public final JSONObject zzf(Map<String, ?> map) throws JSONException {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            for (String next : map.keySet()) {
                zzag(jSONObject, next, map.get(next));
            }
            return jSONObject;
        } catch (ClassCastException e11) {
            String valueOf = String.valueOf(e11.getMessage());
            if (valueOf.length() != 0) {
                str = "Could not convert map to JSON: ".concat(valueOf);
            } else {
                str = new String("Could not convert map to JSON: ");
            }
            throw new JSONException(str);
        }
    }

    public final JSONObject zzg(@Nullable Bundle bundle, JSONObject jSONObject) {
        if (bundle == null) {
            return null;
        }
        try {
            return zze(bundle);
        } catch (JSONException e11) {
            zzciz.zzh("Error converting Bundle to JSON", e11);
            return null;
        }
    }

    public final void zzk(Context context, String str, boolean z11, HttpURLConnection httpURLConnection, boolean z12, int i11) {
        int zza2 = zza(i11);
        StringBuilder sb2 = new StringBuilder(39);
        sb2.append("HTTP timeout: ");
        sb2.append(zza2);
        sb2.append(" milliseconds.");
        zzciz.zzi(sb2.toString());
        httpURLConnection.setConnectTimeout(zza2);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(zza2);
        httpURLConnection.setRequestProperty("User-Agent", zzd(context, str));
        httpURLConnection.setUseCaches(false);
    }

    @TargetApi(26)
    public final void zzl(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgj)).booleanValue()) {
                ((ConnectivityManager) context.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzo(this));
            }
        }
    }

    public final void zzn(Context context, @Nullable String str, String str2, Bundle bundle, boolean z11) {
        com.google.android.gms.ads.internal.zzt.zzp();
        bundle.putString("device", zzx());
        bundle.putString("eids", TextUtils.join(",", zzblj.zza()));
        zzbgo.zzb();
        zzcis.zzr(context, str, "gmob-apps", bundle, true, new zzn(this, context, str));
    }

    public final boolean zzo(String str) {
        return zzah(str, this.zzc, (String) zzbgq.zzc().zzb(zzblj.zzW));
    }

    public final boolean zzp(String str) {
        return zzah(str, this.zzd, (String) zzbgq.zzc().zzb(zzblj.zzX));
    }

    public final boolean zzq(Context context) {
        if (this.zzi) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new zzq(this, (zzp) null), intentFilter);
        this.zzi = true;
        return true;
    }

    public final boolean zzr(Context context) {
        if (this.zzh) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zzs(this, (zzr) null), intentFilter);
        this.zzh = true;
        return true;
    }

    @TargetApi(18)
    public final int zzs(Context context, Uri uri) {
        int i11;
        if (context == null) {
            zze.zza("Trying to open chrome custom tab on a null context");
            return 3;
        }
        if (!PlatformVersion.isAtLeastJellyBeanMR2()) {
            zze.zza("Chrome Custom Tabs can only work with version Jellybean onwards.");
            i11 = 1;
        } else if (!(context instanceof Activity)) {
            zze.zza("Chrome Custom Tabs can only work with Activity context.");
            i11 = 2;
        } else {
            i11 = 0;
        }
        zzblb zzblb = zzblj.zzdd;
        zzblb zzblb2 = zzblj.zzde;
        if (true == ((Boolean) zzbgq.zzc().zzb(zzblb)).equals(zzbgq.zzc().zzb(zzblb2))) {
            i11 = 9;
        }
        if (i11 != 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return i11;
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblb)).booleanValue()) {
            zzbmh zzbmh = new zzbmh();
            zzbmh.zze(new zzl(this, zzbmh, context, uri));
            zzbmh.zzb((Activity) context);
        }
        if (!((Boolean) zzbgq.zzc().zzb(zzblb2)).booleanValue()) {
            return 5;
        }
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setPackage(zzgqf.zza(context));
        build.launchUrl(context, uri);
        return 5;
    }
}
