package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.push.TransActivity;
import com.huawei.hms.support.log.HMSLog;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static int f49749a;

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x019f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01a4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r9, com.huawei.hms.push.m r10) {
        /*
            java.lang.Class<com.huawei.hms.push.l> r0 = com.huawei.hms.push.l.class
            monitor-enter(r0)
            if (r9 == 0) goto L_0x01a3
            boolean r1 = a((com.huawei.hms.push.m) r10)     // Catch:{ all -> 0x01a0 }
            if (r1 == 0) goto L_0x000d
            goto L_0x01a3
        L_0x000d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a0 }
            r1.<init>()     // Catch:{ all -> 0x01a0 }
            java.lang.String r2 = "showNotification, the msg id = "
            r1.append(r2)     // Catch:{ all -> 0x01a0 }
            java.lang.String r2 = r10.p()     // Catch:{ all -> 0x01a0 }
            r1.append(r2)     // Catch:{ all -> 0x01a0 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01a0 }
            java.lang.String r2 = "PushSelfShowLog"
            com.huawei.hms.support.log.HMSLog.d(r2, r1)     // Catch:{ all -> 0x01a0 }
            int r1 = f49749a     // Catch:{ all -> 0x01a0 }
            if (r1 != 0) goto L_0x0048
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a0 }
            r1.<init>()     // Catch:{ all -> 0x01a0 }
            java.lang.String r2 = r9.getPackageName()     // Catch:{ all -> 0x01a0 }
            r1.append(r2)     // Catch:{ all -> 0x01a0 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01a0 }
            r1.append(r2)     // Catch:{ all -> 0x01a0 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01a0 }
            int r1 = r1.hashCode()     // Catch:{ all -> 0x01a0 }
            f49749a = r1     // Catch:{ all -> 0x01a0 }
        L_0x0048:
            java.lang.String r1 = r10.l()     // Catch:{ all -> 0x01a0 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01a0 }
            r2 = 1
            if (r1 == 0) goto L_0x00d1
            java.lang.String r1 = r10.q()     // Catch:{ all -> 0x01a0 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01a0 }
            if (r3 != 0) goto L_0x007a
            int r1 = r1.hashCode()     // Catch:{ all -> 0x01a0 }
            r10.a((int) r1)     // Catch:{ all -> 0x01a0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a0 }
            r3.<init>()     // Catch:{ all -> 0x01a0 }
            java.lang.String r4 = "notification msgTag = "
            r3.append(r4)     // Catch:{ all -> 0x01a0 }
            r3.append(r1)     // Catch:{ all -> 0x01a0 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x01a0 }
            java.lang.String r3 = "PushSelfShowLog"
            com.huawei.hms.support.log.HMSLog.d(r3, r1)     // Catch:{ all -> 0x01a0 }
        L_0x007a:
            int r1 = r10.s()     // Catch:{ all -> 0x01a0 }
            r3 = -1
            if (r1 == r3) goto L_0x00c5
            int r1 = r10.s()     // Catch:{ all -> 0x01a0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a0 }
            r3.<init>()     // Catch:{ all -> 0x01a0 }
            java.lang.String r4 = r10.k()     // Catch:{ all -> 0x01a0 }
            r3.append(r4)     // Catch:{ all -> 0x01a0 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01a0 }
            r3.append(r4)     // Catch:{ all -> 0x01a0 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01a0 }
            int r3 = r3.hashCode()     // Catch:{ all -> 0x01a0 }
            int r4 = r3 + 1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a0 }
            r5.<init>()     // Catch:{ all -> 0x01a0 }
            int r6 = r10.s()     // Catch:{ all -> 0x01a0 }
            r5.append(r6)     // Catch:{ all -> 0x01a0 }
            java.lang.String r6 = r10.k()     // Catch:{ all -> 0x01a0 }
            r5.append(r6)     // Catch:{ all -> 0x01a0 }
            java.lang.String r6 = r9.getPackageName()     // Catch:{ all -> 0x01a0 }
            r5.append(r6)     // Catch:{ all -> 0x01a0 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01a0 }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x01a0 }
            goto L_0x0115
        L_0x00c5:
            int r1 = f49749a     // Catch:{ all -> 0x01a0 }
            int r1 = r1 + r2
            int r3 = r1 + 1
            int r4 = r3 + 1
            int r5 = r4 + 1
            f49749a = r5     // Catch:{ all -> 0x01a0 }
            goto L_0x0115
        L_0x00d1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a0 }
            r1.<init>()     // Catch:{ all -> 0x01a0 }
            java.lang.String r3 = r10.l()     // Catch:{ all -> 0x01a0 }
            r1.append(r3)     // Catch:{ all -> 0x01a0 }
            java.lang.String r3 = r10.k()     // Catch:{ all -> 0x01a0 }
            r1.append(r3)     // Catch:{ all -> 0x01a0 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01a0 }
            int r1 = r1.hashCode()     // Catch:{ all -> 0x01a0 }
            int r3 = f49749a     // Catch:{ all -> 0x01a0 }
            int r3 = r3 + r2
            int r4 = r3 + 1
            f49749a = r4     // Catch:{ all -> 0x01a0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a0 }
            r5.<init>()     // Catch:{ all -> 0x01a0 }
            java.lang.String r6 = r10.l()     // Catch:{ all -> 0x01a0 }
            r5.append(r6)     // Catch:{ all -> 0x01a0 }
            java.lang.String r6 = r10.k()     // Catch:{ all -> 0x01a0 }
            r5.append(r6)     // Catch:{ all -> 0x01a0 }
            java.lang.String r6 = r9.getPackageName()     // Catch:{ all -> 0x01a0 }
            r5.append(r6)     // Catch:{ all -> 0x01a0 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01a0 }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x01a0 }
        L_0x0115:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a0 }
            r6.<init>()     // Catch:{ all -> 0x01a0 }
            java.lang.String r7 = "notifyId:"
            r6.append(r7)     // Catch:{ all -> 0x01a0 }
            r6.append(r1)     // Catch:{ all -> 0x01a0 }
            java.lang.String r7 = ",openNotifyId:"
            r6.append(r7)     // Catch:{ all -> 0x01a0 }
            r6.append(r3)     // Catch:{ all -> 0x01a0 }
            java.lang.String r7 = ",delNotifyId:"
            r6.append(r7)     // Catch:{ all -> 0x01a0 }
            r6.append(r4)     // Catch:{ all -> 0x01a0 }
            java.lang.String r7 = ",alarmNotifyId:"
            r6.append(r7)     // Catch:{ all -> 0x01a0 }
            r6.append(r5)     // Catch:{ all -> 0x01a0 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x01a0 }
            java.lang.String r7 = "PushSelfShowLog"
            com.huawei.hms.support.log.HMSLog.d(r7, r6)     // Catch:{ all -> 0x01a0 }
            r6 = 4
            int[] r6 = new int[r6]     // Catch:{ all -> 0x01a0 }
            r7 = 0
            r6[r7] = r1     // Catch:{ all -> 0x01a0 }
            r6[r2] = r3     // Catch:{ all -> 0x01a0 }
            r2 = 2
            r6[r2] = r4     // Catch:{ all -> 0x01a0 }
            int r2 = r10.f()     // Catch:{ all -> 0x01a0 }
            if (r2 <= 0) goto L_0x0155
            goto L_0x0156
        L_0x0155:
            r5 = r7
        L_0x0156:
            r2 = 3
            r6[r2] = r5     // Catch:{ all -> 0x01a0 }
            boolean r3 = com.huawei.hms.push.d.f()     // Catch:{ all -> 0x01a0 }
            if (r3 == 0) goto L_0x0164
            android.app.Notification r3 = a((android.content.Context) r9, (com.huawei.hms.push.m) r10, (int[]) r6)     // Catch:{ all -> 0x01a0 }
            goto L_0x0165
        L_0x0164:
            r3 = 0
        L_0x0165:
            java.lang.String r4 = "notification"
            java.lang.Object r4 = r9.getSystemService(r4)     // Catch:{ all -> 0x01a0 }
            android.app.NotificationManager r4 = (android.app.NotificationManager) r4     // Catch:{ all -> 0x01a0 }
            if (r4 == 0) goto L_0x019e
            if (r3 == 0) goto L_0x019e
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01a0 }
            r7 = 26
            if (r5 < r7) goto L_0x018b
            java.lang.String r5 = "hms_push_channel"
            int r5 = com.huawei.hms.utils.ResourceLoaderUtil.getStringId(r5)     // Catch:{ all -> 0x01a0 }
            java.lang.String r5 = r9.getString(r5)     // Catch:{ all -> 0x01a0 }
            android.app.NotificationChannel r7 = new android.app.NotificationChannel     // Catch:{ all -> 0x01a0 }
            java.lang.String r8 = "HwPushChannelID"
            r7.<init>(r8, r5, r2)     // Catch:{ all -> 0x01a0 }
            r4.createNotificationChannel(r7)     // Catch:{ all -> 0x01a0 }
        L_0x018b:
            r4.notify(r1, r3)     // Catch:{ all -> 0x01a0 }
            d(r9, r10, r6)     // Catch:{ all -> 0x01a0 }
            java.lang.String r1 = r10.p()     // Catch:{ all -> 0x01a0 }
            java.lang.String r10 = r10.b()     // Catch:{ all -> 0x01a0 }
            java.lang.String r2 = "100"
            com.huawei.hms.push.j.a(r9, r1, r10, r2)     // Catch:{ all -> 0x01a0 }
        L_0x019e:
            monitor-exit(r0)
            return
        L_0x01a0:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        L_0x01a3:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.l.a(android.content.Context, com.huawei.hms.push.m):void");
    }

    private static PendingIntent b(Context context, m mVar, int[] iArr) {
        return PendingIntent.getBroadcast(context, iArr[2], a(context, mVar, iArr, ExifInterface.GPS_MEASUREMENT_2D, 268435456), d.b());
    }

    private static PendingIntent c(Context context, m mVar, int[] iArr) {
        Intent a11 = a(context, mVar, iArr, "1", 268435456);
        if (!a()) {
            return PendingIntent.getBroadcast(context, iArr[1], a11, d.b());
        }
        a11.setClass(context, TransActivity.class);
        a11.setFlags(268468224);
        return PendingIntent.getActivity(context, iArr[1], a11, d.b());
    }

    private static void d(Context context, m mVar, int[] iArr) {
        HMSLog.i("PushSelfShowLog", "setAutoClear time is: " + mVar.f());
        if (mVar.f() > 0) {
            a(context, a(context, mVar, iArr, "-1", 32), (long) mVar.f(), iArr[3]);
        }
    }

    @SuppressLint({"NewApi"})
    private static void b(Context context, Notification.Builder builder, m mVar) {
        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
            Bundle bundle = new Bundle();
            String k11 = mVar.k();
            if (!TextUtils.isEmpty(k11)) {
                bundle.putString("hw_origin_sender_package_name", k11);
                builder.setExtras(bundle);
            }
        }
    }

    private static void d(m mVar, Notification.Builder builder) {
        String u11 = mVar.u();
        String j11 = mVar.j();
        if (TextUtils.isEmpty(j11)) {
            builder.setContentText(u11);
            return;
        }
        builder.setContentText(j11);
        if (!TextUtils.isEmpty(u11)) {
            builder.setContentTitle(u11);
        }
    }

    private static void c(m mVar, Notification.Builder builder) {
        builder.setTicker(mVar.x());
    }

    private static void b(m mVar, Notification.Builder builder) {
        String t11 = mVar.t();
        if (!TextUtils.isEmpty(t11)) {
            builder.setSubText(t11);
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    private static Intent a(Context context, m mVar, int[] iArr, String str, int i11) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", mVar.o()).putExtra("selfshow_token", mVar.y()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i11);
        return intent;
    }

    private static Notification a(Context context, m mVar, int[] iArr) {
        Notification.Builder builder = new Notification.Builder(context);
        if (h.a(mVar) == i.STYLE_BIGTEXT) {
            h.a(builder, mVar.g(), mVar);
        }
        f.a(context, builder, mVar);
        b(mVar, builder);
        d(mVar, builder);
        a(context, mVar, builder);
        a(builder);
        a(mVar, builder);
        c(mVar, builder);
        builder.setContentIntent(c(context, mVar, iArr));
        builder.setDeleteIntent(b(context, mVar, iArr));
        if (Build.VERSION.SDK_INT >= 26) {
            Notification.Builder unused = builder.setChannelId("HwPushChannelID");
        }
        b(context, builder, mVar);
        a(context, builder, mVar);
        return builder.build();
    }

    @SuppressLint({"NewApi"})
    private static void a(Context context, Notification.Builder builder, m mVar) {
        if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11 && d.a(context)) {
            Bundle bundle = new Bundle();
            String k11 = mVar.k();
            HMSLog.i("PushSelfShowLog", "the package name of notification is:" + k11);
            if (!TextUtils.isEmpty(k11)) {
                String a11 = d.a(context, k11);
                HMSLog.i("PushSelfShowLog", "the app name is:" + a11);
                if (a11 != null) {
                    bundle.putCharSequence("android.extraAppName", a11);
                }
            }
            builder.setExtras(bundle);
        }
    }

    private static void a(Context context, Intent intent, long j11, int i11) {
        try {
            HMSLog.d("PushSelfShowLog", "enter setDelayAlarm(interval:" + j11 + "ms.");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                alarmManager.set(0, System.currentTimeMillis() + j11, PendingIntent.getBroadcast(context, i11, intent, d.b()));
            }
        } catch (Exception e11) {
            HMSLog.w("PushSelfShowLog", "set DelayAlarm error." + e11.toString());
        }
    }

    private static void a(Context context, m mVar, Notification.Builder builder) {
        Bitmap a11 = f.a(context, mVar);
        if (a11 != null) {
            builder.setLargeIcon(a11);
        }
    }

    private static void a(Notification.Builder builder) {
        builder.setShowWhen(true);
        builder.setWhen(System.currentTimeMillis());
    }

    private static void a(m mVar, Notification.Builder builder) {
        boolean z11 = true;
        if (mVar.e() != 1) {
            z11 = false;
        }
        builder.setAutoCancel(z11);
        builder.setOngoing(false);
    }

    private static boolean a(m mVar) {
        return mVar == null || (TextUtils.isEmpty(mVar.u()) && TextUtils.isEmpty(mVar.j()));
    }
}
