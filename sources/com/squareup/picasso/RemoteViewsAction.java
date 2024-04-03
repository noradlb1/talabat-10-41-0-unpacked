package com.squareup.picasso;

import android.app.Notification;
import android.app.NotificationManager;
import android.appwidget.AppWidgetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.squareup.picasso.Picasso;

abstract class RemoteViewsAction extends Action<RemoteViewsTarget> {

    /* renamed from: m  reason: collision with root package name */
    public final RemoteViews f53453m;

    /* renamed from: n  reason: collision with root package name */
    public final int f53454n;

    /* renamed from: o  reason: collision with root package name */
    public Callback f53455o;
    private RemoteViewsTarget target;

    public static class AppWidgetAction extends RemoteViewsAction {
        private final int[] appWidgetIds;

        public AppWidgetAction(Picasso picasso, Request request, RemoteViews remoteViews, int i11, int[] iArr, int i12, int i13, String str, Object obj, int i14, Callback callback) {
            super(picasso, request, remoteViews, i11, i14, i12, i13, obj, str, callback);
            this.appWidgetIds = iArr;
        }

        public /* bridge */ /* synthetic */ Object i() {
            return RemoteViewsAction.super.i();
        }

        public void n() {
            AppWidgetManager.getInstance(this.f53358a.f53433a).updateAppWidget(this.appWidgetIds, this.f53453m);
        }
    }

    public static class NotificationAction extends RemoteViewsAction {
        private final Notification notification;
        private final int notificationId;
        private final String notificationTag;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotificationAction(Picasso picasso, Request request, RemoteViews remoteViews, int i11, int i12, Notification notification2, String str, int i13, int i14, String str2, Object obj, int i15, Callback callback) {
            super(picasso, request, remoteViews, i11, i15, i13, i14, obj, str2, callback);
            this.notificationId = i12;
            this.notificationTag = str;
            this.notification = notification2;
        }

        public /* bridge */ /* synthetic */ Object i() {
            return RemoteViewsAction.super.i();
        }

        public void n() {
            ((NotificationManager) Utils.o(this.f53358a.f53433a, RemoteMessageConst.NOTIFICATION)).notify(this.notificationTag, this.notificationId, this.notification);
        }
    }

    public static class RemoteViewsTarget {

        /* renamed from: a  reason: collision with root package name */
        public final RemoteViews f53456a;

        /* renamed from: b  reason: collision with root package name */
        public final int f53457b;

        public RemoteViewsTarget(RemoteViews remoteViews, int i11) {
            this.f53456a = remoteViews;
            this.f53457b = i11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            RemoteViewsTarget remoteViewsTarget = (RemoteViewsTarget) obj;
            if (this.f53457b != remoteViewsTarget.f53457b || !this.f53456a.equals(remoteViewsTarget.f53456a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f53456a.hashCode() * 31) + this.f53457b;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteViewsAction(Picasso picasso, Request request, RemoteViews remoteViews, int i11, int i12, int i13, int i14, Object obj, String str, Callback callback) {
        super(picasso, null, request, i13, i14, i12, (Drawable) null, str, obj, false);
        this.f53453m = remoteViews;
        this.f53454n = i11;
        this.f53455o = callback;
    }

    public void a() {
        super.a();
        if (this.f53455o != null) {
            this.f53455o = null;
        }
    }

    public void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        this.f53453m.setImageViewBitmap(this.f53454n, bitmap);
        n();
        Callback callback = this.f53455o;
        if (callback != null) {
            callback.onSuccess();
        }
    }

    public void error(Exception exc) {
        int i11 = this.f53364g;
        if (i11 != 0) {
            m(i11);
        }
        Callback callback = this.f53455o;
        if (callback != null) {
            callback.onError(exc);
        }
    }

    /* renamed from: l */
    public RemoteViewsTarget i() {
        if (this.target == null) {
            this.target = new RemoteViewsTarget(this.f53453m, this.f53454n);
        }
        return this.target;
    }

    public void m(int i11) {
        this.f53453m.setImageViewResource(this.f53454n, i11);
        n();
    }

    public abstract void n();
}
