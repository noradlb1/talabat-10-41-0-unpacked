package com.braze;

import android.content.Context;
import android.content.Intent;
import bo.app.a2;
import bo.app.o1;
import com.appboy.models.push.BrazeNotificationPayload;
import com.braze.enums.BrazePushEventType;
import com.braze.events.InAppMessageEvent;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\"\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0007J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0007J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f¨\u0006$"}, d2 = {"Lcom/braze/BrazeInternal;", "", "Landroid/content/Context;", "context", "", "ignoreRateLimit", "", "requestGeofenceRefresh", "Lbo/app/a2;", "location", "", "geofenceId", "Lbo/app/o1;", "transitionType", "recordGeofenceTransition", "refreshFeatureFlags", "serializedCardJson", "userId", "addSerializedContentCardToStorage", "logLocationRecordedEvent", "Landroid/content/Intent;", "intent", "handleInAppMessageTestPush", "applyPendingRuntimeConfiguration", "Lcom/braze/events/InAppMessageEvent;", "inAppMessageEvent", "retryInAppMessage", "Lcom/braze/Braze;", "getInstance", "Lcom/braze/enums/BrazePushEventType;", "pushActionType", "Lcom/appboy/models/push/BrazeNotificationPayload;", "payload", "publishBrazePushAction", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class BrazeInternal {
    public static final BrazeInternal INSTANCE = new BrazeInternal();

    private BrazeInternal() {
    }

    @JvmStatic
    public static final void addSerializedContentCardToStorage(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "serializedCardJson");
        INSTANCE.getInstance(context).addSerializedCardJsonToStorage$android_sdk_base_release(str, str2);
    }

    @JvmStatic
    public static final void applyPendingRuntimeConfiguration(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.getInstance(context).applyPendingRuntimeConfiguration$android_sdk_base_release();
    }

    private final Braze getInstance(Context context) {
        return Braze.Companion.getInstance(context);
    }

    @JvmStatic
    public static final void handleInAppMessageTestPush(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        INSTANCE.getInstance(context).handleInAppMessageTestPush$android_sdk_base_release(intent);
    }

    @JvmStatic
    public static final void logLocationRecordedEvent(Context context, a2 a2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(a2Var, "location");
        INSTANCE.getInstance(context).logLocationRecordedEventFromLocationUpdate$android_sdk_base_release(a2Var);
    }

    @JvmStatic
    public static final void recordGeofenceTransition(Context context, String str, o1 o1Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "geofenceId");
        Intrinsics.checkNotNullParameter(o1Var, "transitionType");
        INSTANCE.getInstance(context).recordGeofenceTransition$android_sdk_base_release(str, o1Var);
    }

    @JvmStatic
    public static final void refreshFeatureFlags(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.getInstance(context).refreshFeatureFlags();
    }

    @JvmStatic
    public static final void requestGeofenceRefresh(Context context, boolean z11) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.getInstance(context).requestGeofenceRefresh$android_sdk_base_release(z11);
    }

    @JvmStatic
    public static final void retryInAppMessage(Context context, InAppMessageEvent inAppMessageEvent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inAppMessageEvent, "inAppMessageEvent");
        INSTANCE.getInstance(context).retryInAppMessage$android_sdk_base_release(inAppMessageEvent);
    }

    public final /* synthetic */ void publishBrazePushAction(Context context, BrazePushEventType brazePushEventType, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(brazePushEventType, "pushActionType");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        getInstance(context).publishBrazePushAction$android_sdk_base_release(brazePushEventType, brazeNotificationPayload);
    }

    @JvmStatic
    public static final void requestGeofenceRefresh(Context context, a2 a2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(a2Var, "location");
        INSTANCE.getInstance(context).requestGeofenceRefresh$android_sdk_base_release(a2Var);
    }
}
