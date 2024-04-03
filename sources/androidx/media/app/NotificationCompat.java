package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media.R;

public class NotificationCompat {

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        private void setBackgroundColor(RemoteViews remoteViews) {
            int i11;
            if (this.mBuilder.getColor() != 0) {
                i11 = this.mBuilder.getColor();
            } else {
                i11 = this.mBuilder.mContext.getResources().getColor(R.color.notification_material_background_media_default_color);
            }
            remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", i11);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(a(new Notification.DecoratedMediaCustomViewStyle()));
            } else {
                super.apply(notificationBuilderWithBuilderAccessor);
            }
        }

        public int d(int i11) {
            return i11 <= 3 ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_custom;
        }

        public int e() {
            if (this.mBuilder.getContentView() != null) {
                return R.layout.notification_template_media_custom;
            }
            return super.e();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews remoteViews;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            if (this.mBuilder.getBigContentView() != null) {
                remoteViews = this.mBuilder.getBigContentView();
            } else {
                remoteViews = this.mBuilder.getContentView();
            }
            if (remoteViews == null) {
                return null;
            }
            RemoteViews b11 = b();
            buildIntoRemoteViews(b11, remoteViews);
            setBackgroundColor(b11);
            return b11;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            boolean z11;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z12 = true;
            if (this.mBuilder.getContentView() != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && this.mBuilder.getBigContentView() == null) {
                z12 = false;
            }
            if (!z12) {
                return null;
            }
            RemoteViews c11 = c();
            if (z11) {
                buildIntoRemoteViews(c11, this.mBuilder.getContentView());
            }
            setBackgroundColor(c11);
            return c11;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews remoteViews;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            if (this.mBuilder.getHeadsUpContentView() != null) {
                remoteViews = this.mBuilder.getHeadsUpContentView();
            } else {
                remoteViews = this.mBuilder.getContentView();
            }
            if (remoteViews == null) {
                return null;
            }
            RemoteViews b11 = b();
            buildIntoRemoteViews(b11, remoteViews);
            setBackgroundColor(b11);
            return b11;
        }
    }

    private NotificationCompat() {
    }

    public static class MediaStyle extends NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;

        /* renamed from: a  reason: collision with root package name */
        public int[] f36290a = null;

        /* renamed from: b  reason: collision with root package name */
        public MediaSessionCompat.Token f36291b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36292c;

        /* renamed from: d  reason: collision with root package name */
        public PendingIntent f36293d;

        public MediaStyle() {
        }

        private RemoteViews generateMediaActionButton(NotificationCompat.Action action) {
            boolean z11;
            if (action.getActionIntent() == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), R.layout.notification_media_action);
            int i11 = R.id.action0;
            remoteViews.setImageViewResource(i11, action.getIcon());
            if (!z11) {
                remoteViews.setOnClickPendingIntent(i11, action.getActionIntent());
            }
            remoteViews.setContentDescription(i11, action.getTitle());
            return remoteViews;
        }

        public static MediaSessionCompat.Token getMediaSession(Notification notification) {
            Parcelable parcelable;
            Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
            if (extras == null || (parcelable = extras.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION)) == null) {
                return null;
            }
            return MediaSessionCompat.Token.fromToken(parcelable);
        }

        @RequiresApi(21)
        public Notification.MediaStyle a(Notification.MediaStyle mediaStyle) {
            int[] iArr = this.f36290a;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            MediaSessionCompat.Token token = this.f36291b;
            if (token != null) {
                mediaStyle.setMediaSession((MediaSession.Token) token.getToken());
            }
            return mediaStyle;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            notificationBuilderWithBuilderAccessor.getBuilder().setStyle(a(new Notification.MediaStyle()));
        }

        public RemoteViews b() {
            int min = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, d(min), false);
            applyStandardTemplate.removeAllViews(R.id.media_actions);
            if (min > 0) {
                for (int i11 = 0; i11 < min; i11++) {
                    applyStandardTemplate.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(i11)));
                }
            }
            if (this.f36292c) {
                int i12 = R.id.cancel_action;
                applyStandardTemplate.setViewVisibility(i12, 0);
                applyStandardTemplate.setInt(i12, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
                applyStandardTemplate.setOnClickPendingIntent(i12, this.f36293d);
            } else {
                applyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        public RemoteViews c() {
            int i11;
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, e(), true);
            int size = this.mBuilder.mActions.size();
            int[] iArr = this.f36290a;
            if (iArr == null) {
                i11 = 0;
            } else {
                i11 = Math.min(iArr.length, 3);
            }
            applyStandardTemplate.removeAllViews(R.id.media_actions);
            if (i11 > 0) {
                int i12 = 0;
                while (i12 < i11) {
                    if (i12 < size) {
                        applyStandardTemplate.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(this.f36290a[i12])));
                        i12++;
                    } else {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i12), Integer.valueOf(size - 1)}));
                    }
                }
            }
            if (this.f36292c) {
                applyStandardTemplate.setViewVisibility(R.id.end_padder, 8);
                int i13 = R.id.cancel_action;
                applyStandardTemplate.setViewVisibility(i13, 0);
                applyStandardTemplate.setOnClickPendingIntent(i13, this.f36293d);
                applyStandardTemplate.setInt(i13, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            } else {
                applyStandardTemplate.setViewVisibility(R.id.end_padder, 0);
                applyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        public int d(int i11) {
            return i11 <= 3 ? R.layout.notification_template_big_media_narrow : R.layout.notification_template_big_media;
        }

        public int e() {
            return R.layout.notification_template_media;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.f36293d = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.f36291b = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.f36290a = iArr;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z11) {
            return this;
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }
    }
}
