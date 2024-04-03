package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

public class AppWidgetTarget extends CustomTarget<Bitmap> {
    private final ComponentName componentName;
    private final Context context;
    private final RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;

    public AppWidgetTarget(Context context2, int i11, int i12, int i13, RemoteViews remoteViews2, int... iArr) {
        super(i11, i12);
        if (iArr.length != 0) {
            this.context = (Context) Preconditions.checkNotNull(context2, "Context can not be null!");
            this.remoteViews = (RemoteViews) Preconditions.checkNotNull(remoteViews2, "RemoteViews object can not be null!");
            this.widgetIds = (int[]) Preconditions.checkNotNull(iArr, "WidgetIds can not be null!");
            this.viewId = i13;
            this.componentName = null;
            return;
        }
        throw new IllegalArgumentException("WidgetIds must have length > 0");
    }

    private void setBitmap(@Nullable Bitmap bitmap) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }

    private void update() {
        AppWidgetManager instance = AppWidgetManager.getInstance(this.context);
        ComponentName componentName2 = this.componentName;
        if (componentName2 != null) {
            instance.updateAppWidget(componentName2, this.remoteViews);
        } else {
            instance.updateAppWidget(this.widgetIds, this.remoteViews);
        }
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
        setBitmap((Bitmap) null);
    }

    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        setBitmap(bitmap);
    }

    public AppWidgetTarget(Context context2, int i11, RemoteViews remoteViews2, int... iArr) {
        this(context2, Integer.MIN_VALUE, Integer.MIN_VALUE, i11, remoteViews2, iArr);
    }

    public AppWidgetTarget(Context context2, int i11, int i12, int i13, RemoteViews remoteViews2, ComponentName componentName2) {
        super(i11, i12);
        this.context = (Context) Preconditions.checkNotNull(context2, "Context can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(remoteViews2, "RemoteViews object can not be null!");
        this.componentName = (ComponentName) Preconditions.checkNotNull(componentName2, "ComponentName can not be null!");
        this.viewId = i13;
        this.widgetIds = null;
    }

    public AppWidgetTarget(Context context2, int i11, RemoteViews remoteViews2, ComponentName componentName2) {
        this(context2, Integer.MIN_VALUE, Integer.MIN_VALUE, i11, remoteViews2, componentName2);
    }
}
