package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;

public final class zzcis {
    public static final Handler zza = new zzfpj(Looper.getMainLooper());
    private static final String zzb = AdView.class.getName();
    private static final String zzc = InterstitialAd.class.getName();
    private static final String zzd = AdManagerAdView.class.getName();
    private static final String zze = AdManagerInterstitialAd.class.getName();
    private static final String zzf = SearchAdView.class.getName();
    private static final String zzg = AdLoader.class.getName();
    private float zzh = -1.0f;

    public static int zza(Context context, int i11) {
        DisplayMetrics displayMetrics;
        Configuration configuration;
        if (context == null) {
            return -1;
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null || (configuration = resources.getConfiguration()) == null) {
            return -1;
        }
        int i12 = configuration.orientation;
        if (i11 == 0) {
            i11 = i12;
        }
        if (i11 == i12) {
            return Math.round(((float) displayMetrics.heightPixels) / displayMetrics.density);
        }
        return Math.round(((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    public static AdSize zzc(Context context, int i11, int i12, int i13) {
        int i14;
        int zza2 = zza(context, i13);
        if (zza2 == -1) {
            return AdSize.INVALID;
        }
        int min = Math.min(90, Math.round(((float) zza2) * 0.15f));
        if (i11 > 655) {
            i14 = Math.round((((float) i11) / 728.0f) * 90.0f);
        } else if (i11 > 632) {
            i14 = 81;
        } else if (i11 > 526) {
            i14 = Math.round((((float) i11) / 468.0f) * 60.0f);
        } else if (i11 > 432) {
            i14 = 68;
        } else {
            i14 = Math.round((((float) i11) / 320.0f) * 50.0f);
        }
        return new AdSize(i11, Math.max(Math.min(i14, min), 50));
    }

    public static String zzd() {
        UUID randomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, byteArray).toString();
        for (int i11 = 0; i11 < 2; i11++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(byteArray);
                instance.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(instance.digest(), 0, bArr, 0, 8);
                bigInteger = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return bigInteger;
    }

    @Nullable
    public static String zze(String str) {
        int i11 = 0;
        while (i11 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, instance.digest())});
            } catch (NoSuchAlgorithmException unused) {
                i11++;
            } catch (ArithmeticException unused2) {
                return null;
            }
        }
        return null;
    }

    @Nullable
    public static Throwable zzf(Throwable th2) {
        if (zzbne.zzf.zze().booleanValue()) {
            return th2;
        }
        LinkedList linkedList = new LinkedList();
        while (th2 != null) {
            linkedList.push(th2);
            th2 = th2.getCause();
        }
        Throwable th3 = null;
        while (!linkedList.isEmpty()) {
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            boolean z11 = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (zzj(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    z11 = true;
                } else {
                    String className = stackTraceElement.getClassName();
                    if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                        arrayList.add(stackTraceElement);
                    } else {
                        arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                    }
                }
            }
            if (z11) {
                if (th3 == null) {
                    th3 = new Throwable(th4.getMessage());
                } else {
                    th3 = new Throwable(th4.getMessage(), th3);
                }
                th3.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            }
        }
        return th3;
    }

    @VisibleForTesting
    public static boolean zzj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(zzbne.zzd.zze());
    }

    public static final int zzk(DisplayMetrics displayMetrics, int i11) {
        return (int) TypedValue.applyDimension(1, (float) i11, displayMetrics);
    }

    @Nullable
    @VisibleForTesting
    public static final String zzl(StackTraceElement[] stackTraceElementArr, String str) {
        int i11;
        String str2;
        int i12 = 0;
        while (true) {
            i11 = i12 + 1;
            if (i11 >= stackTraceElementArr.length) {
                str2 = null;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i12];
            String className = stackTraceElement.getClassName();
            if (!"loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) || (!zzb.equalsIgnoreCase(className) && !zzc.equalsIgnoreCase(className) && !zzd.equalsIgnoreCase(className) && !zze.equalsIgnoreCase(className) && !zzf.equalsIgnoreCase(className) && !zzg.equalsIgnoreCase(className))) {
                i12 = i11;
            }
        }
        str2 = stackTraceElementArr[i11].getClassName();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            StringBuilder sb2 = new StringBuilder();
            if (stringTokenizer.hasMoreElements()) {
                sb2.append(stringTokenizer.nextToken());
                int i13 = 2;
                while (true) {
                    int i14 = i13 - 1;
                    if (i13 <= 0 || !stringTokenizer.hasMoreElements()) {
                        str = sb2.toString();
                    } else {
                        sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                        sb2.append(stringTokenizer.nextToken());
                        i13 = i14;
                    }
                }
                str = sb2.toString();
            }
            if (str2 == null || str2.contains(str)) {
                return null;
            }
            return str2;
        }
        return null;
    }

    public static final boolean zzm() {
        if (Build.VERSION.SDK_INT < 31) {
            return Build.DEVICE.startsWith("generic");
        }
        String str = Build.FINGERPRINT;
        if (str.contains("generic") || str.contains(DeviceInfoUtil.DeviceProperty.EMULATOR)) {
            return true;
        }
        return false;
    }

    public static final boolean zzn(Context context, int i11) {
        if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i11) == 0) {
            return true;
        }
        return false;
    }

    public static final boolean zzo(Context context) {
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        if (isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2) {
            return true;
        }
        return false;
    }

    public static final boolean zzp() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static final int zzq(DisplayMetrics displayMetrics, int i11) {
        return Math.round(((float) i11) / displayMetrics.density);
    }

    public static final void zzr(Context context, @Nullable String str, String str2, Bundle bundle, boolean z11, zzcir zzcir) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        bundle.putString("os", Build.VERSION.RELEASE);
        bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
        bundle.putString(HiAnalyticsConstant.HaKey.BI_KEY_APPID, applicationContext.getPackageName());
        if (str == null) {
            int apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(context);
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append(apkVersion);
            sb2.append(".214106000");
            str = sb2.toString();
        }
        bundle.putString("js", str);
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps");
        for (String next : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(next, bundle.getString(next));
        }
        zzcir.zza(appendQueryParameter.toString());
    }

    public static final int zzs(Context context, int i11) {
        return zzk(context.getResources().getDisplayMetrics(), i11);
    }

    @Nullable
    public static final String zzt(Context context) {
        String str;
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            str = null;
        } else {
            str = Settings.Secure.getString(contentResolver, "android_id");
        }
        if (str == null || zzm()) {
            str = DeviceInfoUtil.DeviceProperty.EMULATOR;
        }
        return zze(str);
    }

    private static final void zzu(ViewGroup viewGroup, zzbfi zzbfi, @Nullable String str, int i11, int i12) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            TextView textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i11);
            textView.setBackgroundColor(i12);
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i11);
            int zzs = zzs(context, 3);
            frameLayout.addView(textView, new FrameLayout.LayoutParams(zzbfi.zzf - zzs, zzbfi.zzc - zzs, 17));
            viewGroup.addView(frameLayout, zzbfi.zzf, zzbfi.zzc);
        }
    }

    public final int zzb(Context context, int i11) {
        if (this.zzh < 0.0f) {
            synchronized (this) {
                if (this.zzh < 0.0f) {
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    if (windowManager == null) {
                        return 0;
                    }
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    defaultDisplay.getMetrics(displayMetrics);
                    this.zzh = displayMetrics.density;
                }
            }
        }
        return Math.round(((float) i11) / this.zzh);
    }

    public final void zzg(ViewGroup viewGroup, zzbfi zzbfi, @Nullable String str, @Nullable String str2) {
        if (str2 != null) {
            zzciz.zzj(str2);
        }
        zzu(viewGroup, zzbfi, str, -65536, ViewCompat.MEASURED_STATE_MASK);
    }

    public final void zzh(ViewGroup viewGroup, zzbfi zzbfi, @Nullable String str) {
        zzu(viewGroup, zzbfi, "Ads by Google", ViewCompat.MEASURED_STATE_MASK, -1);
    }

    public final void zzi(Context context, @Nullable String str, String str2, Bundle bundle, boolean z11) {
        zzr(context, str, "gmob-apps", bundle, true, new zzciq(this));
    }
}
