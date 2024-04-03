package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;
import com.huawei.hms.push.constant.RemoteMessageConst;

public class NotificationTarget extends CustomTarget<Bitmap> {
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final String notificationTag;
    private final RemoteViews remoteViews;
    private final int viewId;

    public NotificationTarget(Context context2, int i11, RemoteViews remoteViews2, Notification notification2, int i12) {
        this(context2, i11, remoteViews2, notification2, i12, (String) null);
    }

    private void setBitmap(@Nullable Bitmap bitmap) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }

    private void update() {
        ((NotificationManager) Preconditions.checkNotNull((NotificationManager) this.context.getSystemService(RemoteMessageConst.NOTIFICATION))).notify(this.notificationTag, this.notificationId, this.notification);
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
        setBitmap((Bitmap) null);
    }

    public NotificationTarget(Context context2, int i11, RemoteViews remoteViews2, Notification notification2, int i12, String str) {
        this(context2, Integer.MIN_VALUE, Integer.MIN_VALUE, i11, remoteViews2, notification2, i12, str);
    }

    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        setBitmap(bitmap);
    }

    public NotificationTarget(Context context2, int i11, int i12, int i13, RemoteViews remoteViews2, Notification notification2, int i14, String str) {
        super(i11, i12);
        this.context = (Context) Preconditions.checkNotNull(context2, "Context must not be null!");
        this.notification = (Notification) Preconditions.checkNotNull(notification2, "Notification object can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(remoteViews2, "RemoteViews object can not be null!");
        this.viewId = i13;
        this.notificationId = i14;
        this.notificationTag = str;
    }
}
