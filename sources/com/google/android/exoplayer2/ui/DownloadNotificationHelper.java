package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.core.R;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.util.Util;
import java.util.List;

public final class DownloadNotificationHelper {
    @StringRes
    private static final int NULL_STRING_ID = 0;
    private final NotificationCompat.Builder notificationBuilder;

    @RequiresApi(31)
    public static final class Api31 {
        private Api31() {
        }

        @DoNotInline
        @SuppressLint({"WrongConstant"})
        public static void setForegroundServiceBehavior(NotificationCompat.Builder builder) {
            builder.setForegroundServiceBehavior(1);
        }
    }

    public DownloadNotificationHelper(Context context, String str) {
        this.notificationBuilder = new NotificationCompat.Builder(context.getApplicationContext(), str);
    }

    private Notification buildEndStateNotification(Context context, @DrawableRes int i11, @Nullable PendingIntent pendingIntent, @Nullable String str, @StringRes int i12) {
        return buildNotification(context, i11, pendingIntent, str, i12, 0, 0, false, false, true);
    }

    private Notification buildNotification(Context context, @DrawableRes int i11, @Nullable PendingIntent pendingIntent, @Nullable String str, @StringRes int i12, int i13, int i14, boolean z11, boolean z12, boolean z13) {
        String str2;
        this.notificationBuilder.setSmallIcon(i11);
        NotificationCompat.Builder builder = this.notificationBuilder;
        NotificationCompat.BigTextStyle bigTextStyle = null;
        if (i12 == 0) {
            str2 = null;
        } else {
            str2 = context.getResources().getString(i12);
        }
        builder.setContentTitle(str2);
        this.notificationBuilder.setContentIntent(pendingIntent);
        NotificationCompat.Builder builder2 = this.notificationBuilder;
        if (str != null) {
            bigTextStyle = new NotificationCompat.BigTextStyle().bigText(str);
        }
        builder2.setStyle(bigTextStyle);
        this.notificationBuilder.setProgress(i13, i14, z11);
        this.notificationBuilder.setOngoing(z12);
        this.notificationBuilder.setShowWhen(z13);
        if (Util.SDK_INT >= 31) {
            Api31.setForegroundServiceBehavior(this.notificationBuilder);
        }
        return this.notificationBuilder.build();
    }

    public Notification buildDownloadCompletedNotification(Context context, @DrawableRes int i11, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        return buildEndStateNotification(context, i11, pendingIntent, str, R.string.exo_download_completed);
    }

    public Notification buildDownloadFailedNotification(Context context, @DrawableRes int i11, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        return buildEndStateNotification(context, i11, pendingIntent, str, R.string.exo_download_failed);
    }

    @Deprecated
    public Notification buildProgressNotification(Context context, @DrawableRes int i11, @Nullable PendingIntent pendingIntent, @Nullable String str, List<Download> list) {
        return buildProgressNotification(context, i11, pendingIntent, str, list, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.app.Notification buildProgressNotification(android.content.Context r22, @androidx.annotation.DrawableRes int r23, @androidx.annotation.Nullable android.app.PendingIntent r24, @androidx.annotation.Nullable java.lang.String r25, java.util.List<com.google.android.exoplayer2.offline.Download> r26, int r27) {
        /*
            r21 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r2
        L_0x000a:
            int r10 = r26.size()
            if (r3 >= r10) goto L_0x004a
            r10 = r26
            java.lang.Object r11 = r10.get(r3)
            com.google.android.exoplayer2.offline.Download r11 = (com.google.android.exoplayer2.offline.Download) r11
            int r12 = r11.state
            if (r12 == 0) goto L_0x0046
            r13 = 2
            if (r12 == r13) goto L_0x0028
            r13 = 5
            if (r12 == r13) goto L_0x0026
            r13 = 7
            if (r12 == r13) goto L_0x0028
            goto L_0x0047
        L_0x0026:
            r7 = r2
            goto L_0x0047
        L_0x0028:
            float r4 = r11.getPercentDownloaded()
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r12 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r12 == 0) goto L_0x0034
            float r0 = r0 + r4
            r9 = r1
        L_0x0034:
            long r11 = r11.getBytesDownloaded()
            r13 = 0
            int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x0040
            r4 = r2
            goto L_0x0041
        L_0x0040:
            r4 = r1
        L_0x0041:
            r6 = r6 | r4
            int r8 = r8 + 1
            r4 = r2
            goto L_0x0047
        L_0x0046:
            r5 = r2
        L_0x0047:
            int r3 = r3 + 1
            goto L_0x000a
        L_0x004a:
            if (r4 == 0) goto L_0x0051
            int r3 = com.google.android.exoplayer2.core.R.string.exo_download_downloading
        L_0x004e:
            r15 = r3
        L_0x004f:
            r3 = r2
            goto L_0x006f
        L_0x0051:
            if (r5 == 0) goto L_0x0068
            if (r27 == 0) goto L_0x0068
            r3 = r27 & 2
            if (r3 == 0) goto L_0x005e
            int r3 = com.google.android.exoplayer2.core.R.string.exo_download_paused_for_wifi
        L_0x005b:
            r15 = r3
            r3 = r1
            goto L_0x006f
        L_0x005e:
            r3 = r27 & 1
            if (r3 == 0) goto L_0x0065
            int r3 = com.google.android.exoplayer2.core.R.string.exo_download_paused_for_network
            goto L_0x005b
        L_0x0065:
            int r3 = com.google.android.exoplayer2.core.R.string.exo_download_paused
            goto L_0x005b
        L_0x0068:
            if (r7 == 0) goto L_0x006d
            int r3 = com.google.android.exoplayer2.core.R.string.exo_download_removing
            goto L_0x004e
        L_0x006d:
            r15 = r1
            goto L_0x004f
        L_0x006f:
            if (r3 == 0) goto L_0x0089
            r3 = 100
            if (r4 == 0) goto L_0x0082
            float r4 = (float) r8
            float r0 = r0 / r4
            int r0 = (int) r0
            if (r9 == 0) goto L_0x007d
            if (r6 == 0) goto L_0x007d
            r1 = r2
        L_0x007d:
            r17 = r0
            r18 = r1
            goto L_0x0086
        L_0x0082:
            r17 = r1
            r18 = r2
        L_0x0086:
            r16 = r3
            goto L_0x008f
        L_0x0089:
            r16 = r1
            r17 = r16
            r18 = r17
        L_0x008f:
            r19 = 1
            r20 = 0
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            r14 = r25
            android.app.Notification r0 = r10.buildNotification(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DownloadNotificationHelper.buildProgressNotification(android.content.Context, int, android.app.PendingIntent, java.lang.String, java.util.List, int):android.app.Notification");
    }
}
