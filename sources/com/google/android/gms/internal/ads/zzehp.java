package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import androidx.webkit.ProxyConfig;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import java.util.Map;

public final class zzehp extends zzcbf {
    private final Context zza;
    private final zzdyz zzb;
    private final zzcje zzc;
    private final zzehh zzd;
    private final zzfio zze;

    public zzehp(Context context, zzehh zzehh, zzcje zzcje, zzdyz zzdyz, zzfio zzfio) {
        this.zza = context;
        this.zzb = zzdyz;
        this.zzc = zzcje;
        this.zzd = zzehh;
        this.zze = zzfio;
    }

    public static void zzc(Context context, zzdyz zzdyz, zzfio zzfio, zzehh zzehh, String str, String str2) {
        zzd(context, zzdyz, zzfio, zzehh, str, str2, new HashMap());
    }

    public static void zzd(Context context, zzdyz zzdyz, zzfio zzfio, zzehh zzehh, String str, String str2, Map<String, String> map) {
        String str3;
        String str4 = "offline";
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgq)).booleanValue()) {
            zzfin zzb2 = zzfin.zzb(str2);
            zzb2.zza("gqi", str);
            zzt.zzp();
            if (true == com.google.android.gms.ads.internal.util.zzt.zzJ(context)) {
                str4 = CustomTabsCallback.ONLINE_EXTRAS_KEY;
            }
            zzb2.zza("device_connectivity", str4);
            zzb2.zza("event_timestamp", String.valueOf(zzt.zzA().currentTimeMillis()));
            for (Map.Entry next : map.entrySet()) {
                zzb2.zza((String) next.getKey(), (String) next.getValue());
            }
            str3 = zzfio.zza(zzb2);
        } else {
            zzdyy zza2 = zzdyz.zza();
            zza2.zzb("gqi", str);
            zza2.zzb(NativeProtocol.WEB_DIALOG_ACTION, str2);
            zzt.zzp();
            if (true == com.google.android.gms.ads.internal.util.zzt.zzJ(context)) {
                str4 = CustomTabsCallback.ONLINE_EXTRAS_KEY;
            }
            zza2.zzb("device_connectivity", str4);
            zza2.zzb("event_timestamp", String.valueOf(zzt.zzA().currentTimeMillis()));
            for (Map.Entry next2 : map.entrySet()) {
                zza2.zzb((String) next2.getKey(), (String) next2.getValue());
            }
            str3 = zza2.zze();
        }
        zzehh.zzd(new zzehj(zzt.zzA().currentTimeMillis(), str, str3, 2));
    }

    public static void zzh(Activity activity, @Nullable zzl zzl, zzbv zzbv, zzehh zzehh, zzdyz zzdyz, zzfio zzfio, String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        zzt.zzp();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, zzt.zzq().zzk());
        Resources zzd2 = zzt.zzo().zzd();
        if (zzd2 == null) {
            str3 = "Open ad when you're back online.";
        } else {
            str3 = zzd2.getString(R.string.offline_opt_in_title);
        }
        AlertDialog.Builder title = builder.setTitle(str3);
        if (zzd2 == null) {
            str4 = "We'll send you a notification with a link to the advertiser site.";
        } else {
            str4 = zzd2.getString(R.string.offline_opt_in_message);
        }
        AlertDialog.Builder message = title.setMessage(str4);
        if (zzd2 == null) {
            str5 = "OK";
        } else {
            str5 = zzd2.getString(R.string.offline_opt_in_confirm);
        }
        AlertDialog.Builder positiveButton = message.setPositiveButton(str5, new zzehm(zzdyz, activity, zzfio, zzehh, str, zzbv, str2, zzd2, zzl));
        if (zzd2 == null) {
            str6 = "No thanks";
        } else {
            str6 = zzd2.getString(R.string.offline_opt_in_decline);
        }
        zzehh zzehh2 = zzehh;
        String str7 = str;
        zzdyz zzdyz2 = zzdyz;
        Activity activity2 = activity;
        zzfio zzfio2 = zzfio;
        zzl zzl2 = zzl;
        positiveButton.setNegativeButton(str6, new zzehn(zzehh2, str7, zzdyz2, activity2, zzfio2, zzl2)).setOnCancelListener(new zzehl(zzehh2, str7, zzdyz2, activity2, zzfio2, zzl2));
        builder.create().show();
    }

    private final void zzi(String str, String str2, Map<String, String> map) {
        zzd(this.zza, this.zzb, this.zze, this.zzd, str, str2, map);
    }

    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            zzt.zzp();
            boolean zzJ = com.google.android.gms.ads.internal.util.zzt.zzJ(this.zza);
            HashMap hashMap = new HashMap();
            char c11 = 2;
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (true == zzJ) {
                    c11 = 1;
                }
                hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("olaih", String.valueOf(stringExtra3.startsWith(ProxyConfig.MATCH_HTTP)));
                try {
                    Context context = this.zza;
                    Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(268435456);
                    context.startActivity(launchIntentForPackage);
                    hashMap.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    hashMap.put("olaa", "olaf");
                }
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            zzi(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.zzd.getWritableDatabase();
                if (c11 == 1) {
                    this.zzd.zzg(writableDatabase, this.zzc, stringExtra2);
                } else {
                    zzehh.zzi(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e11) {
                zzciz.zzg("Failed to get writable offline buffering database: ".concat(e11.toString()));
            }
        }
    }

    public final void zzf() {
        this.zzd.zze(new zzeha(this.zzc));
    }

    public final void zzg(IObjectWrapper iObjectWrapper, String str, String str2) {
        String str3;
        String str4;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzt.zzp();
        if (PlatformVersion.isAtLeastO()) {
            NotificationChannel notificationChannel = new NotificationChannel("offline_notification_channel", "AdMob Offline Notifications", 2);
            notificationChannel.setShowBadge(false);
            ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
        Intent intent = new Intent();
        Class<AdService> cls = AdService.class;
        intent.setClass(context, cls);
        intent.setAction("offline_notification_clicked");
        intent.putExtra("offline_notification_action", "offline_notification_clicked");
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str);
        int i11 = zzfpl.zza;
        PendingIntent zza2 = zzfpl.zza(context, 0, intent, i11 | 1073741824, 0);
        Intent intent2 = new Intent();
        intent2.setClass(context, cls);
        intent2.setAction("offline_notification_dismissed");
        intent2.putExtra("offline_notification_action", "offline_notification_dismissed");
        intent2.putExtra("gws_query_id", str2);
        PendingIntent zza3 = zzfpl.zza(context, 0, intent2, i11 | 1073741824, 0);
        Resources zzd2 = zzt.zzo().zzd();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "offline_notification_channel");
        if (zzd2 == null) {
            str3 = "View the ad you saved when you were offline";
        } else {
            str3 = zzd2.getString(R.string.offline_notification_title);
        }
        NotificationCompat.Builder contentTitle = builder.setContentTitle(str3);
        if (zzd2 == null) {
            str4 = "Tap to open ad";
        } else {
            str4 = zzd2.getString(R.string.offline_notification_text);
        }
        ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).notify(str2, 54321, contentTitle.setContentText(str4).setAutoCancel(true).setDeleteIntent(zza3).setContentIntent(zza2).setSmallIcon(context.getApplicationInfo().icon).build());
        zzi(str2, "offline_notification_impression", new HashMap());
    }
}
