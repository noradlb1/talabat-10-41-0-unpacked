package com.braze.push;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.appboy.enums.Channel;
import com.appboy.models.push.BrazeNotificationPayload;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.Constants;
import com.braze.IBrazeNotificationFactory;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.BrazePushEventType;
import com.braze.enums.BrazeViewBounds;
import com.braze.push.support.HtmlUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.IntentUtils;
import com.braze.support.JsonUtils;
import com.braze.support.PermissionUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.UriAction;
import com.braze.ui.support.UriUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001_B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0007J\"\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u001c\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u0018\u0010,\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.H\u0007J\u0010\u0010/\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u00100\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.H\u0007J\u0018\u00101\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.H\u0007J\u0018\u00102\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.H\u0007J\u0010\u00103\u001a\u0002042\u0006\u0010-\u001a\u00020.H\u0007J\u0010\u00105\u001a\u0002042\u0006\u0010-\u001a\u00020.H\u0007J\u0010\u00106\u001a\u0002042\u0006\u0010&\u001a\u00020'H\u0007J\u0010\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u001dH\u0007J\u001c\u00109\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010:\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010;\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010<\u001a\u0002042\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010=\u001a\u0002042\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010>\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.H\u0007J\u0018\u0010?\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.H\u0007J\"\u0010@\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020.2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J.\u0010@\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020C2\b\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J \u0010D\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u00020G2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010H\u001a\u00020\u00192\u0006\u0010F\u001a\u00020G2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010I\u001a\u00020\u00192\u0006\u0010F\u001a\u00020G2\u0006\u0010\u001f\u001a\u00020 H\u0007J\"\u0010J\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020G2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J\"\u0010K\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020G2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u0018\u0010L\u001a\u0002042\u0006\u0010F\u001a\u00020G2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010M\u001a\u00020\u00192\u0006\u0010F\u001a\u00020G2\u0006\u0010\u001f\u001a\u00020 H\u0007J.\u0010N\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010O\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020\u001dH\u0007J\u0018\u0010Q\u001a\u00020\u00192\u0006\u0010F\u001a\u00020G2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010R\u001a\u00020\u00192\u0006\u0010F\u001a\u00020G2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010S\u001a\u00020\u00192\u0006\u0010F\u001a\u00020G2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010T\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020V2\u0006\u0010F\u001a\u00020GH\u0007J\u0018\u0010W\u001a\u00020\u00192\u0006\u0010F\u001a\u00020G2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010X\u001a\u00020\u00192\u0006\u0010F\u001a\u00020G2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010Y\u001a\u00020\u00192\u0006\u0010F\u001a\u00020G2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010Z\u001a\u00020\u00192\u0006\u0010F\u001a\u00020G2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010[\u001a\u00020\u00192\u0006\u0010F\u001a\u00020G2\u0006\u0010\u001f\u001a\u00020 H\u0007J\"\u0010\\\u001a\u0002042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020V2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u0010\u0010\\\u001a\u0002042\u0006\u0010\u001f\u001a\u00020 H\u0007J\f\u0010^\u001a\u000204*\u00020.H\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00158G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006`"}, d2 = {"Lcom/braze/push/BrazeNotificationUtils;", "", "()V", "APPBOY_NOTIFICATION_DELETED_SUFFIX", "", "getAPPBOY_NOTIFICATION_DELETED_SUFFIX$annotations", "getAPPBOY_NOTIFICATION_DELETED_SUFFIX", "()Ljava/lang/String;", "APPBOY_NOTIFICATION_OPENED_SUFFIX", "getAPPBOY_NOTIFICATION_OPENED_SUFFIX$annotations", "getAPPBOY_NOTIFICATION_OPENED_SUFFIX", "APPBOY_NOTIFICATION_RECEIVED_SUFFIX", "getAPPBOY_NOTIFICATION_RECEIVED_SUFFIX$annotations", "getAPPBOY_NOTIFICATION_RECEIVED_SUFFIX", "SOURCE_KEY", "TAG", "activeNotificationFactory", "Lcom/braze/IBrazeNotificationFactory;", "getActiveNotificationFactory", "()Lcom/braze/IBrazeNotificationFactory;", "notificationReceiverClass", "Ljava/lang/Class;", "getNotificationReceiverClass", "()Ljava/lang/Class;", "cancelNotification", "", "context", "Landroid/content/Context;", "notificationId", "", "getNotificationId", "payload", "Lcom/appboy/models/push/BrazeNotificationPayload;", "getNotificationPriority", "getOrCreateNotificationChannelId", "getPushActionPendingIntent", "Landroid/app/PendingIntent;", "action", "notificationExtras", "Landroid/os/Bundle;", "getValidNotificationChannel", "Landroid/app/NotificationChannel;", "notificationManager", "Landroid/app/NotificationManager;", "handleCancelNotificationAction", "intent", "Landroid/content/Intent;", "handleContentCardsSerializedCardIfPresent", "handleNotificationDeleted", "handleNotificationOpened", "handlePushStoryPageClicked", "isAppboyPushMessage", "", "isNotificationMessage", "isUninstallTrackingPush", "isValidNotificationVisibility", "visibility", "logBaiduNotificationClick", "customContentString", "prefetchBitmapsIfNewlyReceivedStoryPush", "refreshFeatureFlagsIfAppropriate", "requestGeofenceRefreshIfAppropriate", "routeUserWithNotificationOpenedIntent", "sendNotificationOpenedBroadcast", "sendPushActionIntent", "pushIntent", "broadcastType", "Lcom/braze/push/BrazeNotificationUtils$BrazeNotificationBroadcastType;", "sendPushMessageReceivedBroadcast", "setAccentColorIfPresentAndSupported", "notificationBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "setCategoryIfPresentAndSupported", "setContentIfPresent", "setContentIntentIfPresent", "setDeleteIntent", "setLargeIconIfPresentAndSupported", "setNotificationBadgeNumberIfPresent", "setNotificationDurationAlarm", "thisClass", "durationInMillis", "setPriorityIfPresentAndSupported", "setPublicVersionIfPresentAndSupported", "setSetShowWhen", "setSmallIcon", "appConfigurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "setSoundIfPresentAndSupported", "setSummaryTextIfPresentAndSupported", "setTickerIfPresent", "setTitleIfPresent", "setVisibilityIfPresentAndSupported", "wakeScreenIfAppropriate", "configurationProvider", "isBrazePushMessage", "BrazeNotificationBroadcastType", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeNotificationUtils {
    @NotNull
    private static final String APPBOY_NOTIFICATION_DELETED_SUFFIX = ".intent.APPBOY_PUSH_DELETED";
    @NotNull
    private static final String APPBOY_NOTIFICATION_OPENED_SUFFIX = ".intent.APPBOY_NOTIFICATION_OPENED";
    @NotNull
    private static final String APPBOY_NOTIFICATION_RECEIVED_SUFFIX = ".intent.APPBOY_PUSH_RECEIVED";
    @NotNull
    public static final BrazeNotificationUtils INSTANCE = new BrazeNotificationUtils();
    @NotNull
    private static final String SOURCE_KEY = "source";
    @NotNull
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) BrazeNotificationUtils.class);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/braze/push/BrazeNotificationUtils$BrazeNotificationBroadcastType;", "", "brazePushEventType", "Lcom/braze/enums/BrazePushEventType;", "(Ljava/lang/String;ILcom/braze/enums/BrazePushEventType;)V", "getBrazePushEventType", "()Lcom/braze/enums/BrazePushEventType;", "OPENED", "RECEIVED", "DELETED", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum BrazeNotificationBroadcastType {
        OPENED(BrazePushEventType.NOTIFICATION_OPENED),
        RECEIVED(BrazePushEventType.NOTIFICATION_RECEIVED),
        DELETED(BrazePushEventType.NOTIFICATION_DELETED);
        
        @NotNull
        private final BrazePushEventType brazePushEventType;

        private BrazeNotificationBroadcastType(BrazePushEventType brazePushEventType2) {
            this.brazePushEventType = brazePushEventType2;
        }

        @NotNull
        public final BrazePushEventType getBrazePushEventType() {
            return this.brazePushEventType;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BrazeNotificationBroadcastType.values().length];
            iArr[BrazeNotificationBroadcastType.OPENED.ordinal()] = 1;
            iArr[BrazeNotificationBroadcastType.RECEIVED.ordinal()] = 2;
            iArr[BrazeNotificationBroadcastType.DELETED.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private BrazeNotificationUtils() {
    }

    public static /* synthetic */ void a(BrazeNotificationUtils brazeNotificationUtils, Context context, BrazeNotificationBroadcastType brazeNotificationBroadcastType, Bundle bundle, BrazeNotificationPayload brazeNotificationPayload, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            brazeNotificationPayload = null;
        }
        brazeNotificationUtils.sendPushActionIntent(context, brazeNotificationBroadcastType, bundle, brazeNotificationPayload);
    }

    @JvmStatic
    public static final void cancelNotification(@NotNull Context context, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$cancelNotification$1(i11), 7, (Object) null);
            Intent intent = new Intent("com.appboy.action.CANCEL_NOTIFICATION").setClass(context, getNotificationReceiverClass());
            Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_C…otificationReceiverClass)");
            intent.setPackage(context.getPackageName());
            intent.putExtra("nid", i11);
            IntentUtils.addComponentAndSendBroadcast(context, intent);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) BrazeNotificationUtils$cancelNotification$2.INSTANCE, 4, (Object) null);
        }
    }

    @NotNull
    public static final String getAPPBOY_NOTIFICATION_DELETED_SUFFIX() {
        return APPBOY_NOTIFICATION_DELETED_SUFFIX;
    }

    @JvmStatic
    @Deprecated(message = "Please {@link Constants#BRAZE_PUSH_INTENT_NOTIFICATION_DELETED}. Deprecated since 6/25/21")
    public static /* synthetic */ void getAPPBOY_NOTIFICATION_DELETED_SUFFIX$annotations() {
    }

    @NotNull
    public static final String getAPPBOY_NOTIFICATION_OPENED_SUFFIX() {
        return APPBOY_NOTIFICATION_OPENED_SUFFIX;
    }

    @JvmStatic
    @Deprecated(message = "Please see {@link Constants#BRAZE_PUSH_INTENT_NOTIFICATION_OPENED}. Deprecated since 6/25/21")
    public static /* synthetic */ void getAPPBOY_NOTIFICATION_OPENED_SUFFIX$annotations() {
    }

    @NotNull
    public static final String getAPPBOY_NOTIFICATION_RECEIVED_SUFFIX() {
        return APPBOY_NOTIFICATION_RECEIVED_SUFFIX;
    }

    @JvmStatic
    @Deprecated(message = "Please {@link Constants#BRAZE_PUSH_INTENT_NOTIFICATION_RECEIVED}. Deprecated since 6/25/21")
    public static /* synthetic */ void getAPPBOY_NOTIFICATION_RECEIVED_SUFFIX$annotations() {
    }

    @JvmStatic
    @NotNull
    public static final IBrazeNotificationFactory getActiveNotificationFactory() {
        IBrazeNotificationFactory customBrazeNotificationFactory = Braze.Companion.getCustomBrazeNotificationFactory();
        return customBrazeNotificationFactory == null ? BrazeNotificationFactory.Companion.getInstance() : customBrazeNotificationFactory;
    }

    @JvmStatic
    public static final int getNotificationId(@NotNull BrazeNotificationPayload brazeNotificationPayload) {
        int i11;
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Integer customNotificationId = brazeNotificationPayload.getCustomNotificationId();
        if (customNotificationId != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$getNotificationId$1(customNotificationId), 7, (Object) null);
            return customNotificationId.intValue();
        }
        String titleText = brazeNotificationPayload.getTitleText();
        String str = "";
        if (titleText != null) {
            str = Intrinsics.stringPlus(str, titleText);
        }
        String contentText = brazeNotificationPayload.getContentText();
        if (contentText != null) {
            str = Intrinsics.stringPlus(str, contentText);
        }
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$getNotificationId$4(i11), 7, (Object) null);
        return i11;
    }

    @JvmStatic
    public static final int getNotificationPriority(@NotNull BrazeNotificationPayload brazeNotificationPayload) {
        boolean z11;
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Integer notificationPriorityInt = brazeNotificationPayload.getNotificationPriorityInt();
        Integer notificationPriorityInt2 = brazeNotificationPayload.getNotificationPriorityInt();
        if (notificationPriorityInt2 != null) {
            int intValue = notificationPriorityInt2.intValue();
            if (-2 > intValue || intValue >= 3) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return intValue;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new BrazeNotificationUtils$getNotificationPriority$1$1(notificationPriorityInt), 6, (Object) null);
        }
        return 0;
    }

    @JvmStatic
    @NotNull
    public static final Class<?> getNotificationReceiverClass() {
        return Constants.isAmazonDevice() ? BrazeAmazonDeviceMessagingReceiver.class : BrazePushReceiver.class;
    }

    @JvmStatic
    @NotNull
    public static final String getOrCreateNotificationChannelId(@NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Object obj;
        String str;
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        String notificationChannelId = brazeNotificationPayload.getNotificationChannelId();
        if (Build.VERSION.SDK_INT >= 26) {
            Context context = brazeNotificationPayload.getContext();
            BrazeConfigurationProvider configurationProvider = brazeNotificationPayload.getConfigurationProvider();
            String str2 = null;
            if (context == null) {
                obj = null;
            } else {
                obj = context.getSystemService(RemoteMessageConst.NOTIFICATION);
            }
            if (obj != null) {
                NotificationManager notificationManager = (NotificationManager) obj;
                if (notificationChannelId != null) {
                    if (notificationManager.getNotificationChannel(notificationChannelId) != null) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$getOrCreateNotificationChannelId$1(notificationChannelId), 7, (Object) null);
                        return notificationChannelId;
                    }
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$getOrCreateNotificationChannelId$2(notificationChannelId), 7, (Object) null);
                }
                if (notificationManager.getNotificationChannel("com_appboy_default_notification_channel") == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$getOrCreateNotificationChannelId$3.INSTANCE, 7, (Object) null);
                    if (configurationProvider == null) {
                        str = null;
                    } else {
                        str = configurationProvider.getDefaultNotificationChannelName();
                    }
                    NotificationChannel notificationChannel = new NotificationChannel("com_appboy_default_notification_channel", str, 3);
                    if (configurationProvider != null) {
                        str2 = configurationProvider.getDefaultNotificationChannelDescription();
                    }
                    notificationChannel.setDescription(str2);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                return "com_appboy_default_notification_channel";
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        } else if (notificationChannelId == null) {
            return "com_appboy_default_notification_channel";
        } else {
            return notificationChannelId;
        }
    }

    private final PendingIntent getPushActionPendingIntent(Context context, String str, Bundle bundle) {
        Intent intent = new Intent(str).setClass(context, NotificationTrampolineActivity.class);
        Intrinsics.checkNotNullExpressionValue(intent, "Intent(action).setClass(…lineActivity::class.java)");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        PendingIntent activity = PendingIntent.getActivity(context, IntentUtils.getRequestCode(), intent, 1073741824 | IntentUtils.getImmutablePendingIntentFlags());
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(context, get… pushActionIntent, flags)");
        return activity;
    }

    @JvmStatic
    @Nullable
    @TargetApi(26)
    public static final NotificationChannel getValidNotificationChannel(@NotNull NotificationManager notificationManager, @Nullable Bundle bundle) {
        boolean z11;
        NotificationManager notificationManager2 = notificationManager;
        Bundle bundle2 = bundle;
        Intrinsics.checkNotNullParameter(notificationManager2, "notificationManager");
        if (bundle2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$getValidNotificationChannel$1.INSTANCE, 7, (Object) null);
            return null;
        }
        String string = bundle2.getString("ab_nc", (String) null);
        if (string == null || StringsKt__StringsJVMKt.isBlank(string)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            NotificationChannel a11 = notificationManager2.getNotificationChannel(string);
            if (a11 != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$getValidNotificationChannel$2(string), 7, (Object) null);
                return a11;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$getValidNotificationChannel$3(string), 7, (Object) null);
        }
        NotificationChannel a12 = notificationManager2.getNotificationChannel("com_appboy_default_notification_channel");
        if (a12 != null) {
            return a12;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$getValidNotificationChannel$4.INSTANCE, 7, (Object) null);
        return null;
    }

    @JvmStatic
    public static final void handleCancelNotificationAction(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        try {
            if (intent.hasExtra("nid")) {
                int intExtra = intent.getIntExtra("nid", -1);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$handleCancelNotificationAction$1(intExtra), 7, (Object) null);
                Object systemService = context.getSystemService(RemoteMessageConst.NOTIFICATION);
                if (systemService != null) {
                    ((NotificationManager) systemService).cancel("appboy_notification", intExtra);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) BrazeNotificationUtils$handleCancelNotificationAction$2.INSTANCE, 4, (Object) null);
        }
    }

    @JvmStatic
    public static final void handleContentCardsSerializedCardIfPresent(@NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        String contentCardSyncData = brazeNotificationPayload.getContentCardSyncData();
        String contentCardSyncUserId = brazeNotificationPayload.getContentCardSyncUserId();
        Context context = brazeNotificationPayload.getContext();
        if (contentCardSyncData != null && context != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$handleContentCardsSerializedCardIfPresent$1(contentCardSyncUserId, contentCardSyncData), 7, (Object) null);
            BrazeInternal.addSerializedContentCardToStorage(context, contentCardSyncData, contentCardSyncUserId);
        }
    }

    @JvmStatic
    public static final void handleNotificationDeleted(@NotNull Context context, @NotNull Intent intent) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        try {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$handleNotificationDeleted$1.INSTANCE, 7, (Object) null);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                brazeNotificationUtils.sendPushActionIntent(context2, BrazeNotificationBroadcastType.DELETED, extras, new BrazeNotificationPayload(extras, (Bundle) null, context, (BrazeConfigurationProvider) null, 10, (DefaultConstructorMarker) null));
                return;
            }
            a(brazeNotificationUtils, context, BrazeNotificationBroadcastType.DELETED, extras, (BrazeNotificationPayload) null, 8, (Object) null);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) BrazeNotificationUtils$handleNotificationDeleted$2.INSTANCE, 4, (Object) null);
        }
    }

    @JvmStatic
    public static final void handleNotificationOpened(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        try {
            Braze.Companion.getInstance(context).logPushNotificationOpened(intent);
            sendNotificationOpenedBroadcast(context, intent);
            if (new BrazeConfigurationProvider(context).getDoesHandlePushDeepLinksAutomatically()) {
                routeUserWithNotificationOpenedIntent(context, intent);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) BrazeNotificationUtils$handleNotificationOpened$1.INSTANCE, 6, (Object) null);
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) BrazeNotificationUtils$handleNotificationOpened$2.INSTANCE, 4, (Object) null);
        }
    }

    @JvmStatic
    public static final void handlePushStoryPageClicked(@NotNull Context context, @NotNull Intent intent) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        try {
            Braze.Companion.getInstance(context).logPushStoryPageClicked(intent.getStringExtra("appboy_campaign_id"), intent.getStringExtra("appboy_story_page_id"));
            String stringExtra = intent.getStringExtra("appboy_action_uri");
            boolean z12 = false;
            if (stringExtra == null || StringsKt__StringsJVMKt.isBlank(stringExtra)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                intent.putExtra("uri", intent.getStringExtra("appboy_action_uri"));
                String stringExtra2 = intent.getStringExtra("appboy_action_use_webview");
                if (stringExtra2 == null || StringsKt__StringsJVMKt.isBlank(stringExtra2)) {
                    z12 = true;
                }
                if (!z12) {
                    intent.putExtra("ab_use_webview", stringExtra2);
                }
            } else {
                intent.removeExtra("uri");
            }
            sendNotificationOpenedBroadcast(context, intent);
            if (new BrazeConfigurationProvider(context).getDoesHandlePushDeepLinksAutomatically()) {
                routeUserWithNotificationOpenedIntent(context, intent);
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new BrazeNotificationUtils$handlePushStoryPageClicked$1(stringExtra), 6, (Object) null);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) BrazeNotificationUtils$handlePushStoryPageClicked$2.INSTANCE, 4, (Object) null);
        }
    }

    @JvmStatic
    @Deprecated(message = "Please use isBrazePushMessage() instead. Deprecated since 3/2022", replaceWith = @ReplaceWith(expression = "isBrazePushMessage(intent)", imports = {}))
    public static final boolean isAppboyPushMessage(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        return isBrazePushMessage(intent);
    }

    @JvmStatic
    public static final boolean isBrazePushMessage(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        return StringsKt__StringsJVMKt.equals("true", extras.getString("_ab"), true);
    }

    @JvmStatic
    public static final boolean isNotificationMessage(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("t") && extras.containsKey("a")) {
            return true;
        }
        return false;
    }

    @JvmStatic
    @Deprecated(message = "Please use BrazeNotificationPayload().isUninstallTracking instead")
    public static final boolean isUninstallTrackingPush(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
        try {
            if (bundle.containsKey("appboy_uninstall_tracking")) {
                return true;
            }
            Bundle bundle2 = bundle.getBundle("extra");
            if (bundle2 != null) {
                return bundle2.containsKey("appboy_uninstall_tracking");
            }
            return false;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) BrazeNotificationUtils$isUninstallTrackingPush$1.INSTANCE, 4, (Object) null);
            return false;
        }
    }

    @JvmStatic
    @TargetApi(21)
    public static final boolean isValidNotificationVisibility(int i11) {
        return i11 == -1 || i11 == 0 || i11 == 1;
    }

    @JvmStatic
    public static final void logBaiduNotificationClick(@Nullable Context context, @Nullable String str) {
        Context context2 = context;
        String str2 = str;
        if (str2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BrazeNotificationUtils$logBaiduNotificationClick$1.INSTANCE, 6, (Object) null);
        } else if (context2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BrazeNotificationUtils$logBaiduNotificationClick$2.INSTANCE, 6, (Object) null);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optionalString = JsonUtils.getOptionalString(jSONObject, "source");
                String optionalString2 = JsonUtils.getOptionalString(jSONObject, "cid");
                if (optionalString != null && Intrinsics.areEqual((Object) optionalString, (Object) "Appboy") && optionalString2 != null) {
                    Braze.Companion.getInstance(context2).logPushNotificationOpened(optionalString2);
                }
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new BrazeNotificationUtils$logBaiduNotificationClick$3(str2), 4, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void prefetchBitmapsIfNewlyReceivedStoryPush(@NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Context context = brazeNotificationPayload.getContext();
        if (context != null && brazeNotificationPayload.isPushStory() && brazeNotificationPayload.isNewlyReceivedPushStory()) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (BrazeNotificationPayload.PushStoryPage bitmapUrl : brazeNotificationPayload.getPushStoryPages()) {
                String bitmapUrl2 = bitmapUrl.getBitmapUrl();
                if (bitmapUrl2 != null) {
                    arrayList.add(bitmapUrl2);
                }
            }
            for (String str : arrayList) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeNotificationUtils$prefetchBitmapsIfNewlyReceivedStoryPush$2$1(str), 6, (Object) null);
                Braze.Companion.getInstance(context).getImageLoader().getPushBitmapFromUrl(context, brazeNotificationPayload.getBrazeExtras(), str, BrazeViewBounds.NOTIFICATION_ONE_IMAGE_STORY);
            }
            brazeNotificationPayload.setNewlyReceivedPushStory(false);
        }
    }

    @JvmStatic
    public static final boolean refreshFeatureFlagsIfAppropriate(@NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Context context = brazeNotificationPayload.getContext();
        if (!brazeNotificationPayload.getShouldRefreshFeatureFlags() || context == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) BrazeNotificationUtils$refreshFeatureFlagsIfAppropriate$2.INSTANCE, 6, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$refreshFeatureFlagsIfAppropriate$1.INSTANCE, 7, (Object) null);
        BrazeInternal.refreshFeatureFlags(context);
        return true;
    }

    @JvmStatic
    public static final boolean requestGeofenceRefreshIfAppropriate(@NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Context context = brazeNotificationPayload.getContext();
        if (!brazeNotificationPayload.getShouldSyncGeofences() || context == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$requestGeofenceRefreshIfAppropriate$2.INSTANCE, 7, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$requestGeofenceRefreshIfAppropriate$1.INSTANCE, 7, (Object) null);
        BrazeInternal.requestGeofenceRefresh(context, true);
        return true;
    }

    @JvmStatic
    public static final void routeUserWithNotificationOpenedIntent(@NotNull Context context, @NotNull Intent intent) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        Bundle bundleExtra = intent.getBundleExtra("extra");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        bundleExtra.putString("cid", intent.getStringExtra("cid"));
        bundleExtra.putString("source", "Appboy");
        String stringExtra = intent.getStringExtra("uri");
        if (stringExtra == null || StringsKt__StringsJVMKt.isBlank(stringExtra)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            boolean equals = StringsKt__StringsJVMKt.equals("true", intent.getStringExtra("ab_use_webview"), true);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$routeUserWithNotificationOpenedIntent$1(stringExtra, equals), 7, (Object) null);
            bundleExtra.putString("uri", stringExtra);
            bundleExtra.putBoolean("ab_use_webview", equals);
            BrazeDeeplinkHandler.Companion companion = BrazeDeeplinkHandler.Companion;
            UriAction createUriActionFromUrlString = companion.getInstance().createUriActionFromUrlString(stringExtra, bundleExtra, equals, Channel.PUSH);
            if (createUriActionFromUrlString != null) {
                companion.getInstance().gotoUri(context, createUriActionFromUrlString);
                return;
            }
            return;
        }
        Intent mainActivityIntent = UriUtils.getMainActivityIntent(context, bundleExtra);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$routeUserWithNotificationOpenedIntent$3(mainActivityIntent), 7, (Object) null);
        context.startActivity(mainActivityIntent);
    }

    @JvmStatic
    public static final void sendNotificationOpenedBroadcast(@NotNull Context context, @NotNull Intent intent) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$sendNotificationOpenedBroadcast$1.INSTANCE, 7, (Object) null);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            brazeNotificationUtils.sendPushActionIntent(context2, BrazeNotificationBroadcastType.OPENED, extras, new BrazeNotificationPayload(extras, (Bundle) null, context, (BrazeConfigurationProvider) null, 10, (DefaultConstructorMarker) null));
            return;
        }
        a(brazeNotificationUtils, context, BrazeNotificationBroadcastType.OPENED, extras, (BrazeNotificationPayload) null, 8, (Object) null);
    }

    private final void sendPushActionIntent(Context context, BrazeNotificationBroadcastType brazeNotificationBroadcastType, Bundle bundle, BrazeNotificationPayload brazeNotificationPayload) {
        Intent intent;
        Intent intent2;
        Context context2 = context;
        BrazeNotificationBroadcastType brazeNotificationBroadcastType2 = brazeNotificationBroadcastType;
        Bundle bundle2 = bundle;
        BrazeNotificationPayload brazeNotificationPayload2 = brazeNotificationPayload;
        int i11 = WhenMappings.$EnumSwitchMapping$0[brazeNotificationBroadcastType.ordinal()];
        if (i11 == 1) {
            intent2 = new Intent(Intrinsics.stringPlus(context.getPackageName(), APPBOY_NOTIFICATION_OPENED_SUFFIX));
            intent = new Intent("com.braze.push.intent.NOTIFICATION_OPENED").setPackage(context.getPackageName());
            Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_P…kage(context.packageName)");
        } else if (i11 == 2) {
            intent2 = new Intent(Intrinsics.stringPlus(context.getPackageName(), APPBOY_NOTIFICATION_RECEIVED_SUFFIX));
            intent = new Intent("com.braze.push.intent.NOTIFICATION_RECEIVED").setPackage(context.getPackageName());
            Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_P…kage(context.packageName)");
        } else if (i11 == 3) {
            intent2 = new Intent(Intrinsics.stringPlus(context.getPackageName(), APPBOY_NOTIFICATION_DELETED_SUFFIX));
            intent = new Intent("com.braze.push.intent.NOTIFICATION_DELETED").setPackage(context.getPackageName());
            Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_P…kage(context.packageName)");
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Intent intent3 = intent2;
        Intent intent4 = intent;
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger brazeLogger2 = brazeLogger;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) new BrazeNotificationUtils$sendPushActionIntent$1(brazeNotificationBroadcastType2), 6, (Object) null);
        sendPushActionIntent(context2, intent3, bundle2);
        BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) new BrazeNotificationUtils$sendPushActionIntent$2(brazeNotificationBroadcastType2), 6, (Object) null);
        sendPushActionIntent(context2, intent4, bundle2);
        if (brazeNotificationPayload2 != null) {
            BrazeInternal.INSTANCE.publishBrazePushAction(context2, brazeNotificationBroadcastType.getBrazePushEventType(), brazeNotificationPayload2);
        }
    }

    @JvmStatic
    public static final void sendPushMessageReceivedBroadcast(@NotNull Context context, @NotNull Bundle bundle, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$sendPushMessageReceivedBroadcast$1.INSTANCE, 7, (Object) null);
        brazeNotificationUtils.sendPushActionIntent(context, BrazeNotificationBroadcastType.RECEIVED, bundle, brazeNotificationPayload);
    }

    @JvmStatic
    public static final void setAccentColorIfPresentAndSupported(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Integer accentColor = brazeNotificationPayload.getAccentColor();
        if (accentColor != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setAccentColorIfPresentAndSupported$1.INSTANCE, 7, (Object) null);
            builder.setColor(accentColor.intValue());
            return;
        }
        BrazeConfigurationProvider configurationProvider = brazeNotificationPayload.getConfigurationProvider();
        if (configurationProvider != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setAccentColorIfPresentAndSupported$2$1.INSTANCE, 7, (Object) null);
            builder.setColor(configurationProvider.getDefaultNotificationAccentColor());
        }
    }

    @JvmStatic
    public static final void setCategoryIfPresentAndSupported(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        NotificationCompat.Builder builder2 = builder;
        Intrinsics.checkNotNullParameter(builder2, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        String notificationCategory = brazeNotificationPayload.getNotificationCategory();
        if (notificationCategory != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setCategoryIfPresentAndSupported$2.INSTANCE, 7, (Object) null);
            builder2.setCategory(notificationCategory);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setCategoryIfPresentAndSupported$3.INSTANCE, 7, (Object) null);
    }

    @JvmStatic
    public static final void setContentIfPresent(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        BrazeConfigurationProvider configurationProvider;
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setContentIfPresent$1.INSTANCE, 7, (Object) null);
        String contentText = brazeNotificationPayload.getContentText();
        if (contentText != null && (configurationProvider = brazeNotificationPayload.getConfigurationProvider()) != null) {
            builder.setContentText(HtmlUtils.getHtmlSpannedTextIfEnabled(contentText, configurationProvider));
        }
    }

    @JvmStatic
    public static final void setContentIntentIfPresent(@NotNull Context context, @NotNull NotificationCompat.Builder builder, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        try {
            builder.setContentIntent(INSTANCE.getPushActionPendingIntent(context, "com.appboy.action.APPBOY_PUSH_CLICKED", bundle));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) BrazeNotificationUtils$setContentIntentIfPresent$1.INSTANCE, 4, (Object) null);
        }
    }

    @JvmStatic
    public static final void setDeleteIntent(@NotNull Context context, @NotNull NotificationCompat.Builder builder, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        try {
            Intent intent = new Intent("com.appboy.action.APPBOY_PUSH_DELETED").setClass(context, getNotificationReceiverClass());
            Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_P…otificationReceiverClass)");
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            builder.setDeleteIntent(PendingIntent.getBroadcast(context, IntentUtils.getRequestCode(), intent, IntentUtils.getImmutablePendingIntentFlags() | 1073741824));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) BrazeNotificationUtils$setDeleteIntent$1.INSTANCE, 4, (Object) null);
        }
    }

    @JvmStatic
    public static final boolean setLargeIconIfPresentAndSupported(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        BrazeConfigurationProvider configurationProvider;
        NotificationCompat.Builder builder2 = builder;
        Intrinsics.checkNotNullParameter(builder2, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        if (brazeNotificationPayload.isPushStory()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setLargeIconIfPresentAndSupported$1.INSTANCE, 7, (Object) null);
            return false;
        }
        Context context = brazeNotificationPayload.getContext();
        if (context == null || (configurationProvider = brazeNotificationPayload.getConfigurationProvider()) == null) {
            return false;
        }
        try {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setLargeIconIfPresentAndSupported$2.INSTANCE, 7, (Object) null);
            String largeIcon = brazeNotificationPayload.getLargeIcon();
            if (largeIcon == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setLargeIconIfPresentAndSupported$4.INSTANCE, 7, (Object) null);
                int largeNotificationIconResourceId = configurationProvider.getLargeNotificationIconResourceId();
                if (largeNotificationIconResourceId != 0) {
                    builder2.setLargeIcon(BitmapFactoryInstrumentation.decodeResource(context.getResources(), largeNotificationIconResourceId));
                    return true;
                }
                BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setLargeIconIfPresentAndSupported$5.INSTANCE, 7, (Object) null);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setLargeIconIfPresentAndSupported$7.INSTANCE, 7, (Object) null);
                return false;
            }
            builder2.setLargeIcon(Braze.Companion.getInstance(context).getImageLoader().getPushBitmapFromUrl(context, (Bundle) null, largeIcon, BrazeViewBounds.NOTIFICATION_LARGE_ICON));
            return true;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) BrazeNotificationUtils$setLargeIconIfPresentAndSupported$6.INSTANCE, 4, (Object) null);
        }
    }

    @JvmStatic
    public static final void setNotificationBadgeNumberIfPresent(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        if (Build.VERSION.SDK_INT < 26) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setNotificationBadgeNumberIfPresent$1.INSTANCE, 7, (Object) null);
            return;
        }
        Integer notificationBadgeNumber = brazeNotificationPayload.getNotificationBadgeNumber();
        if (notificationBadgeNumber != null) {
            builder.setNumber(notificationBadgeNumber.intValue());
        }
    }

    @JvmStatic
    public static final void setNotificationDurationAlarm(@NotNull Context context, @Nullable Class<?> cls, int i11, int i12) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, cls);
        intent.setAction("com.appboy.action.CANCEL_NOTIFICATION");
        intent.putExtra("nid", i11);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728 | IntentUtils.getImmutablePendingIntentFlags());
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (systemService != null) {
            AlarmManager alarmManager = (AlarmManager) systemService;
            if (i12 >= 1000) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$setNotificationDurationAlarm$1(i12), 7, (Object) null);
                alarmManager.set(3, SystemClock.elapsedRealtime() + ((long) i12), broadcast);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.AlarmManager");
    }

    @JvmStatic
    public static final void setPriorityIfPresentAndSupported(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setPriorityIfPresentAndSupported$1.INSTANCE, 7, (Object) null);
        builder.setPriority(getNotificationPriority(brazeNotificationPayload));
    }

    @JvmStatic
    public static final void setPublicVersionIfPresentAndSupported(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        NotificationCompat.Builder builder2 = builder;
        Intrinsics.checkNotNullParameter(builder2, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Context context = brazeNotificationPayload.getContext();
        BrazeConfigurationProvider configurationProvider = brazeNotificationPayload.getConfigurationProvider();
        if (context != null && brazeNotificationPayload.getPublicNotificationExtras() != null && configurationProvider != null) {
            String orCreateNotificationChannelId = getOrCreateNotificationChannelId(brazeNotificationPayload);
            Bundle parseJsonObjectIntoBundle = JsonUtils.parseJsonObjectIntoBundle(brazeNotificationPayload.getPublicNotificationExtras());
            if (!parseJsonObjectIntoBundle.isEmpty()) {
                BrazeNotificationPayload brazeNotificationPayload2 = new BrazeNotificationPayload(parseJsonObjectIntoBundle, (Bundle) null, context, configurationProvider, 2, (DefaultConstructorMarker) null);
                NotificationCompat.Builder builder3 = new NotificationCompat.Builder(context, orCreateNotificationChannelId);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$setPublicVersionIfPresentAndSupported$2(brazeNotificationPayload2), 7, (Object) null);
                setContentIfPresent(builder3, brazeNotificationPayload2);
                setTitleIfPresent(builder3, brazeNotificationPayload2);
                setSummaryTextIfPresentAndSupported(builder3, brazeNotificationPayload2);
                setSmallIcon(configurationProvider, builder3);
                setAccentColorIfPresentAndSupported(builder3, brazeNotificationPayload2);
                builder2.setPublicVersion(builder3.build());
            }
        }
    }

    @JvmStatic
    public static final void setSetShowWhen(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        if (brazeNotificationPayload.isPushStory()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setSetShowWhen$1.INSTANCE, 7, (Object) null);
            builder.setShowWhen(false);
        }
    }

    @JvmStatic
    public static final int setSmallIcon(@NotNull BrazeConfigurationProvider brazeConfigurationProvider, @NotNull NotificationCompat.Builder builder) {
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "appConfigurationProvider");
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        int smallNotificationIconResourceId = brazeConfigurationProvider.getSmallNotificationIconResourceId();
        if (smallNotificationIconResourceId == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setSmallIcon$1.INSTANCE, 7, (Object) null);
            smallNotificationIconResourceId = brazeConfigurationProvider.getApplicationIconResourceId();
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setSmallIcon$2.INSTANCE, 7, (Object) null);
        }
        builder.setSmallIcon(smallNotificationIconResourceId);
        return smallNotificationIconResourceId;
    }

    @JvmStatic
    public static final void setSoundIfPresentAndSupported(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        String notificationSound = brazeNotificationPayload.getNotificationSound();
        if (notificationSound != null) {
            if (Intrinsics.areEqual((Object) notificationSound, (Object) "d")) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setSoundIfPresentAndSupported$1.INSTANCE, 7, (Object) null);
                builder.setDefaults(1);
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setSoundIfPresentAndSupported$2.INSTANCE, 7, (Object) null);
            builder.setSound(Uri.parse(notificationSound));
        }
    }

    @JvmStatic
    public static final void setSummaryTextIfPresentAndSupported(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        NotificationCompat.Builder builder2 = builder;
        Intrinsics.checkNotNullParameter(builder2, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        String summaryText = brazeNotificationPayload.getSummaryText();
        if (summaryText != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setSummaryTextIfPresentAndSupported$1.INSTANCE, 7, (Object) null);
            builder2.setSubText(summaryText);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setSummaryTextIfPresentAndSupported$2.INSTANCE, 7, (Object) null);
    }

    @JvmStatic
    public static final void setTickerIfPresent(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setTickerIfPresent$1.INSTANCE, 7, (Object) null);
        String titleText = brazeNotificationPayload.getTitleText();
        if (titleText != null) {
            builder.setTicker(titleText);
        }
    }

    @JvmStatic
    public static final void setTitleIfPresent(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        BrazeConfigurationProvider configurationProvider;
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setTitleIfPresent$1.INSTANCE, 7, (Object) null);
        String titleText = brazeNotificationPayload.getTitleText();
        if (titleText != null && (configurationProvider = brazeNotificationPayload.getConfigurationProvider()) != null) {
            builder.setContentTitle(HtmlUtils.getHtmlSpannedTextIfEnabled(titleText, configurationProvider));
        }
    }

    @JvmStatic
    public static final void setVisibilityIfPresentAndSupported(@NotNull NotificationCompat.Builder builder, @NotNull BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Integer notificationVisibility = brazeNotificationPayload.getNotificationVisibility();
        if (notificationVisibility == null) {
            return;
        }
        if (isValidNotificationVisibility(notificationVisibility.intValue())) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$setVisibilityIfPresentAndSupported$2.INSTANCE, 7, (Object) null);
            builder.setVisibility(notificationVisibility.intValue());
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new BrazeNotificationUtils$setVisibilityIfPresentAndSupported$3(notificationVisibility), 6, (Object) null);
    }

    @JvmStatic
    public static final boolean wakeScreenIfAppropriate(@NotNull Context context, @NotNull BrazeConfigurationProvider brazeConfigurationProvider, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        return wakeScreenIfAppropriate(new BrazeNotificationPayload(bundle, (Bundle) null, context, brazeConfigurationProvider, 2, (DefaultConstructorMarker) null));
    }

    @JvmStatic
    @SuppressLint({"WakelockTimeout"})
    public static final boolean wakeScreenIfAppropriate(@NotNull BrazeNotificationPayload brazeNotificationPayload) {
        BrazeConfigurationProvider configurationProvider;
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Context context = brazeNotificationPayload.getContext();
        if (context == null || (configurationProvider = brazeNotificationPayload.getConfigurationProvider()) == null) {
            return false;
        }
        Bundle notificationExtras = brazeNotificationPayload.getNotificationExtras();
        if (!PermissionUtils.hasPermission(context, "android.permission.WAKE_LOCK") || !configurationProvider.isPushWakeScreenForNotificationEnabled()) {
            return false;
        }
        try {
            Object systemService = context.getSystemService("uimode");
            if (systemService != null) {
                if (((UiModeManager) systemService).getCurrentModeType() == 4) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$wakeScreenIfAppropriate$1.INSTANCE, 7, (Object) null);
                    return false;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    Object systemService2 = context.getSystemService(RemoteMessageConst.NOTIFICATION);
                    if (systemService2 != null) {
                        NotificationChannel validNotificationChannel = getValidNotificationChannel((NotificationManager) systemService2, notificationExtras);
                        if (validNotificationChannel == null) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$wakeScreenIfAppropriate$3.INSTANCE, 7, (Object) null);
                            return false;
                        } else if (validNotificationChannel.getImportance() == 1) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeNotificationUtils$wakeScreenIfAppropriate$4(validNotificationChannel), 7, (Object) null);
                            return false;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
                    }
                } else if (getNotificationPriority(brazeNotificationPayload) == -2) {
                    return false;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeNotificationUtils$wakeScreenIfAppropriate$5.INSTANCE, 7, (Object) null);
                Object systemService3 = context.getSystemService("power");
                if (systemService3 != null) {
                    PowerManager.WakeLock newWakeLock = ((PowerManager) systemService3).newWakeLock(268435482, TAG);
                    newWakeLock.acquire();
                    newWakeLock.release();
                    return true;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.UiModeManager");
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) BrazeNotificationUtils$wakeScreenIfAppropriate$2.INSTANCE, 4, (Object) null);
        }
    }

    private final void sendPushActionIntent(Context context, Intent intent, Bundle bundle) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeNotificationUtils$sendPushActionIntent$3(intent), 6, (Object) null);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        IntentUtils.addComponentAndSendBroadcast(context, intent);
    }
}
