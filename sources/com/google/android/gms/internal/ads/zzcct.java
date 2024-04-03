package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcct implements zzccv {
    @VisibleForTesting
    static zzccv zza;
    @VisibleForTesting
    static zzccv zzb;
    private static final Object zzc = new Object();
    private final Object zzd = new Object();
    private final Context zze;
    private final WeakHashMap<Thread, Boolean> zzf = new WeakHashMap<>();
    private final ExecutorService zzg;
    private final zzcjf zzh;

    public zzcct(Context context, zzcjf zzcjf) {
        zzfpi.zza();
        this.zzg = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        this.zze = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzh = zzcjf;
    }

    public static zzccv zza(Context context) {
        synchronized (zzc) {
            if (zza == null) {
                if (zzbne.zze.zze().booleanValue()) {
                    if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfG)).booleanValue()) {
                        zza = new zzcct(context, zzcjf.zza());
                    }
                }
                zza = new zzccu();
            }
        }
        return zza;
    }

    public static zzccv zzb(Context context, zzcjf zzcjf) {
        synchronized (zzc) {
            if (zzb == null) {
                if (zzbne.zze.zze().booleanValue()) {
                    if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfG)).booleanValue()) {
                        zzcct zzcct = new zzcct(context, zzcjf);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzcct.zzd) {
                                zzcct.zzf.put(thread, Boolean.TRUE);
                            }
                            thread.setUncaughtExceptionHandler(new zzccs(zzcct, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new zzccr(zzcct, Thread.getDefaultUncaughtExceptionHandler()));
                        zzb = zzcct;
                    }
                }
                zzb = new zzccu();
            }
        }
        return zzb;
    }

    public final void zzc(Thread thread, Throwable th2) {
        if (th2 != null) {
            boolean z11 = false;
            boolean z12 = false;
            for (Throwable th3 = th2; th3 != null; th3 = th3.getCause()) {
                for (StackTraceElement stackTraceElement : th3.getStackTrace()) {
                    z11 |= zzcis.zzj(stackTraceElement.getClassName());
                    z12 |= zzcct.class.getName().equals(stackTraceElement.getClassName());
                }
            }
            if (z11 && !z12) {
                zze(th2, "", 1.0f);
            }
        }
    }

    public final void zzd(Throwable th2, String str) {
        zze(th2, str, 1.0f);
    }

    public final void zze(Throwable th2, String str, float f11) {
        int i11;
        boolean z11;
        String str2;
        String str3;
        if (zzcis.zzf(th2) != null) {
            String name2 = th2.getClass().getName();
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            double d11 = (double) f11;
            double random = Math.random();
            if (f11 > 0.0f) {
                i11 = (int) (1.0f / f11);
            } else {
                i11 = 1;
            }
            if (random < d11) {
                ArrayList<String> arrayList = new ArrayList<>();
                try {
                    z11 = Wrappers.packageManager(this.zze).isCallerInstantApp();
                } catch (Throwable th3) {
                    zzciz.zzh("Error fetching instant app info", th3);
                    z11 = false;
                }
                try {
                    str2 = this.zze.getPackageName();
                } catch (Throwable unused) {
                    zzciz.zzj("Cannot obtain package name, proceeding.");
                    str2 = "unknown";
                }
                Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z11)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
                String str4 = Build.MANUFACTURER;
                String str5 = Build.MODEL;
                if (!str5.startsWith(str4)) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str4).length() + 1 + str5.length());
                    sb2.append(str4);
                    sb2.append(" ");
                    sb2.append(str5);
                    str5 = sb2.toString();
                }
                Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("device", str5).appendQueryParameter("js", this.zzh.zza).appendQueryParameter(HiAnalyticsConstant.HaKey.BI_KEY_APPID, str2).appendQueryParameter("exceptiontype", name2).appendQueryParameter("stacktrace", stringWriter2).appendQueryParameter("eids", TextUtils.join(",", zzblj.zza())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "428884702").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i11)).appendQueryParameter("pb_tm", String.valueOf(zzbne.zzc.zze())).appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze)));
                if (true != this.zzh.zze) {
                    str3 = "0";
                } else {
                    str3 = "1";
                }
                arrayList.add(appendQueryParameter2.appendQueryParameter("lite", str3).toString());
                for (String zzccq : arrayList) {
                    this.zzg.execute(new zzccq(new zzcje((String) null), zzccq));
                }
            }
        }
    }
}
