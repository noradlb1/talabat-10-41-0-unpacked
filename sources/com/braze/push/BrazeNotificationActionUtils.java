package com.braze.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.appboy.models.push.BrazeNotificationPayload;
import com.braze.Braze;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.support.BrazeLogger;
import com.braze.support.IntentUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¨\u0006\u0014"}, d2 = {"Lcom/braze/push/BrazeNotificationActionUtils;", "", "()V", "addNotificationAction", "", "notificationBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "payload", "Lcom/appboy/models/push/BrazeNotificationPayload;", "actionButton", "Lcom/appboy/models/push/BrazeNotificationPayload$ActionButton;", "addNotificationActions", "handleNotificationActionClicked", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "logNotificationActionClicked", "actionType", "", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeNotificationActionUtils {
    @NotNull
    public static final BrazeNotificationActionUtils INSTANCE = new BrazeNotificationActionUtils();

    private BrazeNotificationActionUtils() {
    }

    @JvmStatic
    public static final void addNotificationActions(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        if (brazeNotificationPayload.getContext() == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationActionUtils$addNotificationActions$1.INSTANCE, 7, (Object) null);
            return;
        }
        List<BrazeNotificationPayload.ActionButton> actionButtons = brazeNotificationPayload.getActionButtons();
        if (actionButtons.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationActionUtils$addNotificationActions$2.INSTANCE, 7, (Object) null);
            return;
        }
        for (BrazeNotificationPayload.ActionButton next : actionButtons) {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeNotificationActionUtils brazeNotificationActionUtils = INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationActionUtils, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeNotificationActionUtils$addNotificationActions$3(next), 6, (Object) null);
            brazeNotificationActionUtils.addNotificationAction(builder, brazeNotificationPayload, next);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020 A[Catch:{ Exception -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030 A[Catch:{ Exception -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093 A[Catch:{ Exception -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c7 A[Catch:{ Exception -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00cb A[Catch:{ Exception -> 0x00e7 }] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void handleNotificationActionClicked(@org.jetbrains.annotations.NotNull android.content.Context r12, @org.jetbrains.annotations.NotNull android.content.Intent r13) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "appboy_action_type"
            java.lang.String r0 = r13.getStringExtra(r0)     // Catch:{ Exception -> 0x00e7 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001d
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)     // Catch:{ Exception -> 0x00e7 }
            if (r3 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r3 = r1
            goto L_0x001e
        L_0x001d:
            r3 = r2
        L_0x001e:
            if (r3 == 0) goto L_0x0030
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00e7 }
            com.braze.push.BrazeNotificationActionUtils r5 = INSTANCE     // Catch:{ Exception -> 0x00e7 }
            com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x00e7 }
            r7 = 0
            r8 = 0
            com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$1 r9 = com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$1.INSTANCE     // Catch:{ Exception -> 0x00e7 }
            r10 = 6
            r11 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)     // Catch:{ Exception -> 0x00e7 }
            return
        L_0x0030:
            java.lang.String r3 = "nid"
            r4 = -1
            int r3 = r13.getIntExtra(r3, r4)     // Catch:{ Exception -> 0x00e7 }
            com.braze.push.BrazeNotificationActionUtils r5 = INSTANCE     // Catch:{ Exception -> 0x00e7 }
            r5.logNotificationActionClicked(r12, r13, r0)     // Catch:{ Exception -> 0x00e7 }
            if (r0 == 0) goto L_0x00d9
            int r4 = r0.hashCode()     // Catch:{ Exception -> 0x00e7 }
            r6 = -1424488370(0xffffffffab18084e, float:-5.4012773E-13)
            java.lang.String r7 = "ab_uri"
            if (r4 == r6) goto L_0x006e
            r6 = -1209677674(0xffffffffb7e5c896, float:-2.7392332E-5)
            if (r4 == r6) goto L_0x005f
            r6 = -1209647192(0xffffffffb7e63fa8, float:-2.7447779E-5)
            if (r4 == r6) goto L_0x0055
            goto L_0x00d9
        L_0x0055:
            java.lang.String r4 = "ab_open"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x00e7 }
            if (r4 != 0) goto L_0x0075
            goto L_0x00d9
        L_0x005f:
            java.lang.String r13 = "ab_none"
            boolean r13 = r0.equals(r13)     // Catch:{ Exception -> 0x00e7 }
            if (r13 != 0) goto L_0x0069
            goto L_0x00d9
        L_0x0069:
            com.braze.push.BrazeNotificationUtils.cancelNotification(r12, r3)     // Catch:{ Exception -> 0x00e7 }
            goto L_0x00f7
        L_0x006e:
            boolean r4 = r0.equals(r7)     // Catch:{ Exception -> 0x00e7 }
            if (r4 != 0) goto L_0x0075
            goto L_0x00d9
        L_0x0075:
            com.braze.push.BrazeNotificationUtils.cancelNotification(r12, r3)     // Catch:{ Exception -> 0x00e7 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r3 = "uri"
            if (r0 == 0) goto L_0x00b6
            android.os.Bundle r0 = r13.getExtras()     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r4 = "appboy_action_uri"
            if (r0 != 0) goto L_0x008a
        L_0x0088:
            r0 = r1
            goto L_0x0091
        L_0x008a:
            boolean r0 = r0.containsKey(r4)     // Catch:{ Exception -> 0x00e7 }
            if (r0 != r2) goto L_0x0088
            r0 = r2
        L_0x0091:
            if (r0 == 0) goto L_0x00b6
            java.lang.String r0 = r13.getStringExtra(r4)     // Catch:{ Exception -> 0x00e7 }
            r13.putExtra(r3, r0)     // Catch:{ Exception -> 0x00e7 }
            android.os.Bundle r0 = r13.getExtras()     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r3 = "appboy_action_use_webview"
            if (r0 != 0) goto L_0x00a3
            goto L_0x00aa
        L_0x00a3:
            boolean r0 = r0.containsKey(r3)     // Catch:{ Exception -> 0x00e7 }
            if (r0 != r2) goto L_0x00aa
            r1 = r2
        L_0x00aa:
            if (r1 == 0) goto L_0x00b9
            java.lang.String r0 = "ab_use_webview"
            java.lang.String r1 = r13.getStringExtra(r3)     // Catch:{ Exception -> 0x00e7 }
            r13.putExtra(r0, r1)     // Catch:{ Exception -> 0x00e7 }
            goto L_0x00b9
        L_0x00b6:
            r13.removeExtra(r3)     // Catch:{ Exception -> 0x00e7 }
        L_0x00b9:
            com.braze.push.BrazeNotificationUtils.sendNotificationOpenedBroadcast(r12, r13)     // Catch:{ Exception -> 0x00e7 }
            com.braze.configuration.BrazeConfigurationProvider r0 = new com.braze.configuration.BrazeConfigurationProvider     // Catch:{ Exception -> 0x00e7 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x00e7 }
            boolean r0 = r0.getDoesHandlePushDeepLinksAutomatically()     // Catch:{ Exception -> 0x00e7 }
            if (r0 == 0) goto L_0x00cb
            com.braze.push.BrazeNotificationUtils.routeUserWithNotificationOpenedIntent(r12, r13)     // Catch:{ Exception -> 0x00e7 }
            goto L_0x00f7
        L_0x00cb:
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00e7 }
            com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.I     // Catch:{ Exception -> 0x00e7 }
            r7 = 0
            r8 = 0
            com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$2 r9 = com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$2.INSTANCE     // Catch:{ Exception -> 0x00e7 }
            r10 = 6
            r11 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)     // Catch:{ Exception -> 0x00e7 }
            goto L_0x00f7
        L_0x00d9:
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00e7 }
            com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x00e7 }
            r7 = 0
            r8 = 0
            com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$3 r9 = com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$3.INSTANCE     // Catch:{ Exception -> 0x00e7 }
            r10 = 6
            r11 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)     // Catch:{ Exception -> 0x00e7 }
            goto L_0x00f7
        L_0x00e7:
            r12 = move-exception
            r3 = r12
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.push.BrazeNotificationActionUtils r1 = INSTANCE
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.E
            r4 = 0
            com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$4 r5 = com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$4.INSTANCE
            r6 = 4
            r7 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.push.BrazeNotificationActionUtils.handleNotificationActionClicked(android.content.Context, android.content.Intent):void");
    }

    public final void addNotificationAction(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload, @NotNull BrazeNotificationPayload.ActionButton actionButton) {
        PendingIntent pendingIntent;
        NotificationCompat.Builder builder2 = builder;
        BrazeNotificationPayload.ActionButton actionButton2 = actionButton;
        Intrinsics.checkNotNullParameter(builder2, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Intrinsics.checkNotNullParameter(actionButton2, "actionButton");
        Context context = brazeNotificationPayload.getContext();
        if (context == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationActionUtils$addNotificationAction$1.INSTANCE, 7, (Object) null);
            return;
        }
        Bundle bundle = new Bundle(brazeNotificationPayload.getNotificationExtras());
        actionButton2.putIntoBundle(bundle);
        String type = actionButton.getType();
        int immutablePendingIntentFlags = 134217728 | IntentUtils.getImmutablePendingIntentFlags();
        if (Intrinsics.areEqual((Object) "ab_none", (Object) type)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeNotificationActionUtils$addNotificationAction$2(type), 6, (Object) null);
            Intent intent = new Intent("com.appboy.action.APPBOY_ACTION_CLICKED").setClass(context, BrazeNotificationUtils.getNotificationReceiverClass());
            Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_A…ceiverClass\n            )");
            intent.putExtras(bundle);
            pendingIntent = PendingIntent.getBroadcast(context, IntentUtils.getRequestCode(), intent, immutablePendingIntentFlags);
            Intrinsics.checkNotNullExpressionValue(pendingIntent, "getBroadcast(\n          …IntentFlags\n            )");
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeNotificationActionUtils$addNotificationAction$3(type), 6, (Object) null);
            Intent intent2 = new Intent("com.appboy.action.APPBOY_ACTION_CLICKED").setClass(context, NotificationTrampolineActivity.class);
            Intrinsics.checkNotNullExpressionValue(intent2, "Intent(Constants.BRAZE_A…lineActivity::class.java)");
            intent2.setFlags(intent2.getFlags() | BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.NOTIFICATION_ACTION_WITH_DEEPLINK));
            intent2.putExtras(bundle);
            pendingIntent = PendingIntent.getActivity(context, IntentUtils.getRequestCode(), intent2, immutablePendingIntentFlags);
            Intrinsics.checkNotNullExpressionValue(pendingIntent, "getActivity(\n           …IntentFlags\n            )");
        }
        NotificationCompat.Action.Builder builder3 = new NotificationCompat.Action.Builder(0, (CharSequence) actionButton.getText(), pendingIntent);
        builder3.addExtras(new Bundle(bundle));
        builder2.addAction(builder3.build());
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeNotificationActionUtils$addNotificationAction$4(bundle), 6, (Object) null);
    }

    public final void logNotificationActionClicked(@NotNull Context context, @NotNull Intent intent, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        Braze.Companion.getInstance(context).logPushNotificationActionClicked(intent.getStringExtra("cid"), intent.getStringExtra("appboy_action_id"), str);
    }
}
