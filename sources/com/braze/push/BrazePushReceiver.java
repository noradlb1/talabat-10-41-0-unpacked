package com.braze.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.appboy.models.push.BrazeNotificationPayload;
import com.braze.Braze;
import com.braze.Constants;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/braze/push/BrazePushReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BrazePushReceiver extends BroadcastReceiver {
    @NotNull
    private static final String ADM_ERROR_DESCRIPTION_KEY = "error_description";
    @NotNull
    private static final String ADM_ERROR_KEY = "error";
    @NotNull
    private static final String ADM_RECEIVE_INTENT_ACTION = "com.amazon.device.messaging.intent.RECEIVE";
    @NotNull
    private static final String ADM_REGISTRATION_ID_KEY = "registration_id";
    @NotNull
    private static final String ADM_REGISTRATION_INTENT_ACTION = "com.amazon.device.messaging.intent.REGISTRATION";
    @NotNull
    private static final String ADM_UNREGISTERED_KEY = "unregistered";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DELETED_MESSAGES_KEY = "deleted_messages";
    @NotNull
    public static final String FIREBASE_MESSAGING_SERVICE_ROUTING_ACTION = "firebase_messaging_service_routing_action";
    @NotNull
    public static final String HMS_PUSH_SERVICE_ROUTING_ACTION = "hms_push_service_routing_action";
    @NotNull
    private static final String MESSAGE_TYPE_KEY = "message_type";
    @NotNull
    private static final String NUMBER_OF_MESSAGES_DELETED_KEY = "total_deleted";

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\"\u0010 \u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/braze/push/BrazePushReceiver$Companion;", "", "()V", "ADM_ERROR_DESCRIPTION_KEY", "", "ADM_ERROR_KEY", "ADM_RECEIVE_INTENT_ACTION", "ADM_REGISTRATION_ID_KEY", "ADM_REGISTRATION_INTENT_ACTION", "ADM_UNREGISTERED_KEY", "DELETED_MESSAGES_KEY", "FIREBASE_MESSAGING_SERVICE_ROUTING_ACTION", "HMS_PUSH_SERVICE_ROUTING_ACTION", "MESSAGE_TYPE_KEY", "NUMBER_OF_MESSAGES_DELETED_KEY", "createPayload", "Lcom/appboy/models/push/BrazeNotificationPayload;", "context", "Landroid/content/Context;", "appConfigurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "notificationExtras", "Landroid/os/Bundle;", "brazeExtras", "handleAdmRegistrationEventIfEnabled", "", "intent", "Landroid/content/Intent;", "handleAdmRegistrationIntent", "handlePush", "", "handlePushNotificationPayload", "handleReceivedIntent", "runOnThread", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final void handlePush(Context context, Intent intent) {
            Context applicationContext = context.getApplicationContext();
            String action = intent.getAction();
            try {
                handlePush$performWork(action, applicationContext, intent, context);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new BrazePushReceiver$Companion$handlePush$1(action, intent), 4, (Object) null);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
            if (r10.equals(com.braze.push.BrazePushReceiver.HMS_PUSH_SERVICE_ROUTING_ACTION) == false) goto L_0x00c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0063, code lost:
            if (r10.equals(com.braze.push.BrazePushReceiver.ADM_RECEIVE_INTENT_ACTION) == false) goto L_0x00c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0087, code lost:
            if (r10.equals("com.appboy.action.STORY_TRAVERSE") == false) goto L_0x00c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bc, code lost:
            if (r10.equals(com.braze.push.BrazePushReceiver.FIREBASE_MESSAGING_SERVICE_ROUTING_ACTION) == false) goto L_0x00c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bf, code lost:
            r9.handlePushNotificationPayload(r11, r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c3, code lost:
            com.braze.support.BrazeLogger.brazelog$default(r8, (java.lang.Object) r9, com.braze.support.BrazeLogger.Priority.W, (java.lang.Throwable) null, false, (kotlin.jvm.functions.Function0) com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$3.INSTANCE, 6, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static final void handlePush$performWork(java.lang.String r10, android.content.Context r11, android.content.Intent r12, android.content.Context r13) {
            /*
                com.braze.support.BrazeLogger r8 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.push.BrazePushReceiver$Companion r9 = com.braze.push.BrazePushReceiver.Companion
                com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.I
                r3 = 0
                r4 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$1 r5 = new com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$1
                r5.<init>(r12)
                r6 = 6
                r7 = 0
                r0 = r8
                r1 = r9
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
                if (r10 == 0) goto L_0x001f
                int r0 = r10.length()
                if (r0 != 0) goto L_0x001d
                goto L_0x001f
            L_0x001d:
                r0 = 0
                goto L_0x0020
            L_0x001f:
                r0 = 1
            L_0x0020:
                if (r0 == 0) goto L_0x0033
                com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.W
                r3 = 0
                r4 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$2 r5 = new com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$2
                r5.<init>(r12)
                r6 = 6
                r7 = 0
                r0 = r8
                r1 = r9
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
                return
            L_0x0033:
                java.lang.String r0 = "applicationContext"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
                com.braze.BrazeInternal.applyPendingRuntimeConfiguration(r11)
                int r0 = r10.hashCode()
                switch(r0) {
                    case -1584985748: goto L_0x00b6;
                    case -1189411212: goto L_0x00a9;
                    case -743092218: goto L_0x0097;
                    case -499472794: goto L_0x008a;
                    case -478038018: goto L_0x0081;
                    case 431884654: goto L_0x0074;
                    case 465410320: goto L_0x0067;
                    case 1060266838: goto L_0x005d;
                    case 1740454061: goto L_0x0053;
                    case 1908841035: goto L_0x0044;
                    default: goto L_0x0042;
                }
            L_0x0042:
                goto L_0x00c3
            L_0x0044:
                java.lang.String r11 = "com.appboy.action.APPBOY_STORY_CLICKED"
                boolean r10 = r10.equals(r11)
                if (r10 != 0) goto L_0x004e
                goto L_0x00c3
            L_0x004e:
                com.braze.push.BrazeNotificationUtils.handlePushStoryPageClicked(r13, r12)
                goto L_0x00d0
            L_0x0053:
                java.lang.String r13 = "hms_push_service_routing_action"
                boolean r10 = r10.equals(r13)
                if (r10 != 0) goto L_0x00bf
                goto L_0x00c3
            L_0x005d:
                java.lang.String r13 = "com.amazon.device.messaging.intent.RECEIVE"
                boolean r10 = r10.equals(r13)
                if (r10 != 0) goto L_0x00bf
                goto L_0x00c3
            L_0x0067:
                java.lang.String r11 = "com.appboy.action.APPBOY_ACTION_CLICKED"
                boolean r10 = r10.equals(r11)
                if (r10 != 0) goto L_0x0070
                goto L_0x00c3
            L_0x0070:
                com.braze.push.BrazeNotificationActionUtils.handleNotificationActionClicked(r13, r12)
                goto L_0x00d0
            L_0x0074:
                java.lang.String r13 = "com.appboy.action.CANCEL_NOTIFICATION"
                boolean r10 = r10.equals(r13)
                if (r10 != 0) goto L_0x007d
                goto L_0x00c3
            L_0x007d:
                com.braze.push.BrazeNotificationUtils.handleCancelNotificationAction(r11, r12)
                goto L_0x00d0
            L_0x0081:
                java.lang.String r13 = "com.appboy.action.STORY_TRAVERSE"
                boolean r10 = r10.equals(r13)
                if (r10 != 0) goto L_0x00bf
                goto L_0x00c3
            L_0x008a:
                java.lang.String r13 = "com.appboy.action.APPBOY_PUSH_DELETED"
                boolean r10 = r10.equals(r13)
                if (r10 != 0) goto L_0x0093
                goto L_0x00c3
            L_0x0093:
                com.braze.push.BrazeNotificationUtils.handleNotificationDeleted(r11, r12)
                goto L_0x00d0
            L_0x0097:
                java.lang.String r13 = "com.amazon.device.messaging.intent.REGISTRATION"
                boolean r10 = r10.equals(r13)
                if (r10 != 0) goto L_0x00a0
                goto L_0x00c3
            L_0x00a0:
                com.braze.configuration.BrazeConfigurationProvider r10 = new com.braze.configuration.BrazeConfigurationProvider
                r10.<init>(r11)
                r9.handleAdmRegistrationEventIfEnabled(r10, r11, r12)
                goto L_0x00d0
            L_0x00a9:
                java.lang.String r11 = "com.appboy.action.APPBOY_PUSH_CLICKED"
                boolean r10 = r10.equals(r11)
                if (r10 != 0) goto L_0x00b2
                goto L_0x00c3
            L_0x00b2:
                com.braze.push.BrazeNotificationUtils.handleNotificationOpened(r13, r12)
                goto L_0x00d0
            L_0x00b6:
                java.lang.String r13 = "firebase_messaging_service_routing_action"
                boolean r10 = r10.equals(r13)
                if (r10 != 0) goto L_0x00bf
                goto L_0x00c3
            L_0x00bf:
                r9.handlePushNotificationPayload(r11, r12)
                goto L_0x00d0
            L_0x00c3:
                com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.W
                r3 = 0
                r4 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$3 r5 = com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$3.INSTANCE
                r6 = 6
                r7 = 0
                r0 = r8
                r1 = r9
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            L_0x00d0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.push.BrazePushReceiver.Companion.handlePush$performWork(java.lang.String, android.content.Context, android.content.Intent, android.content.Context):void");
        }

        public static /* synthetic */ void handleReceivedIntent$default(Companion companion, Context context, Intent intent, boolean z11, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z11 = true;
            }
            companion.handleReceivedIntent(context, intent, z11);
        }

        @JvmStatic
        @NotNull
        @VisibleForTesting
        public final BrazeNotificationPayload createPayload(@NotNull Context context, @NotNull BrazeConfigurationProvider brazeConfigurationProvider, @NotNull Bundle bundle, @NotNull Bundle bundle2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "appConfigurationProvider");
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Intrinsics.checkNotNullParameter(bundle2, "brazeExtras");
            if (Constants.isAmazonDevice()) {
                return new BrazeNotificationPayload(bundle, BrazeNotificationPayload.Companion.getAttachedBrazeExtras(bundle), context, brazeConfigurationProvider);
            }
            return new BrazeNotificationPayload(bundle, bundle2, context, brazeConfigurationProvider);
        }

        @JvmStatic
        @VisibleForTesting
        public final boolean handleAdmRegistrationEventIfEnabled(@NotNull BrazeConfigurationProvider brazeConfigurationProvider, @NotNull Context context, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "appConfigurationProvider");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$1(intent), 6, (Object) null);
            if (!Constants.isAmazonDevice() || !brazeConfigurationProvider.isAdmMessagingRegistrationEnabled()) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$3.INSTANCE, 6, (Object) null);
                return false;
            }
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$2.INSTANCE, 7, (Object) null);
            handleAdmRegistrationIntent(context, intent);
            return true;
        }

        @JvmStatic
        @VisibleForTesting
        public final boolean handleAdmRegistrationIntent(@NotNull Context context, @NotNull Intent intent) {
            Context context2 = context;
            Intent intent2 = intent;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(intent2, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            String stringExtra = intent2.getStringExtra("error");
            String stringExtra2 = intent2.getStringExtra("error_description");
            String stringExtra3 = intent2.getStringExtra(BrazePushReceiver.ADM_REGISTRATION_ID_KEY);
            String stringExtra4 = intent2.getStringExtra(BrazePushReceiver.ADM_UNREGISTERED_KEY);
            if (stringExtra != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new BrazePushReceiver$Companion$handleAdmRegistrationIntent$1(stringExtra, stringExtra2), 6, (Object) null);
                return true;
            } else if (stringExtra3 != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new BrazePushReceiver$Companion$handleAdmRegistrationIntent$2(stringExtra3), 6, (Object) null);
                Braze.Companion.getInstance(context2).setRegisteredPushToken(stringExtra3);
                return true;
            } else if (stringExtra4 != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new BrazePushReceiver$Companion$handleAdmRegistrationIntent$3(stringExtra4), 6, (Object) null);
                return true;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BrazePushReceiver$Companion$handleAdmRegistrationIntent$4.INSTANCE, 6, (Object) null);
                return false;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x0142  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0151  */
        @kotlin.jvm.JvmStatic
        @androidx.annotation.VisibleForTesting
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean handlePushNotificationPayload(@org.jetbrains.annotations.NotNull android.content.Context r19, @org.jetbrains.annotations.NotNull android.content.Intent r20) {
            /*
                r18 = this;
                r0 = r19
                r1 = r20
                java.lang.String r2 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
                java.lang.String r2 = "intent"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                boolean r2 = com.braze.push.BrazeNotificationUtils.isBrazePushMessage(r20)
                r3 = 0
                if (r2 != 0) goto L_0x0024
                com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE
                r6 = 0
                r7 = 0
                r8 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$1 r9 = com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$1.INSTANCE
                r10 = 7
                r11 = 0
                r5 = r18
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                return r3
            L_0x0024:
                java.lang.String r2 = "message_type"
                java.lang.String r2 = r1.getStringExtra(r2)
                java.lang.String r4 = "deleted_messages"
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r2)
                if (r2 == 0) goto L_0x004c
                java.lang.String r0 = "total_deleted"
                r2 = -1
                int r0 = r1.getIntExtra(r0, r2)
                com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.I
                r7 = 0
                r8 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$2 r9 = new com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$2
                r9.<init>(r0)
                r10 = 6
                r11 = 0
                r5 = r18
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                return r3
            L_0x004c:
                android.os.Bundle r2 = r20.getExtras()
                if (r2 != 0) goto L_0x0053
                return r3
            L_0x0053:
                com.braze.support.BrazeLogger r12 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.support.BrazeLogger$Priority r13 = com.braze.support.BrazeLogger.Priority.I
                r7 = 0
                r8 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$3 r9 = new com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$3
                r9.<init>(r2)
                r10 = 6
                r11 = 0
                r4 = r12
                r5 = r18
                r6 = r13
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                com.appboy.models.push.BrazeNotificationPayload$Companion r4 = com.appboy.models.push.BrazeNotificationPayload.Companion
                android.os.Bundle r4 = r4.getAttachedBrazeExtras(r2)
                java.lang.String r5 = "extra"
                r2.putBundle(r5, r4)
                java.lang.String r5 = "appboy_push_received_timestamp"
                boolean r6 = r2.containsKey(r5)
                if (r6 != 0) goto L_0x0081
                long r6 = java.lang.System.currentTimeMillis()
                r2.putLong(r5, r6)
            L_0x0081:
                com.braze.configuration.BrazeConfigurationProvider r14 = new com.braze.configuration.BrazeConfigurationProvider
                r14.<init>(r0)
                r15 = r18
                com.appboy.models.push.BrazeNotificationPayload r11 = r15.createPayload(r0, r14, r2, r4)
                boolean r4 = r11.isUninstallTrackingPush()
                if (r4 == 0) goto L_0x00a0
                r7 = 0
                r8 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$4 r9 = com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$4.INSTANCE
                r10 = 6
                r11 = 0
                r4 = r12
                r5 = r18
                r6 = r13
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                return r3
            L_0x00a0:
                com.braze.push.BrazeNotificationUtils.handleContentCardsSerializedCardIfPresent(r11)
                boolean r4 = r11.getShouldFetchTestTriggers()
                if (r4 == 0) goto L_0x00cc
                boolean r4 = r14.isInAppMessageTestPushEagerDisplayEnabled()
                if (r4 == 0) goto L_0x00cc
                com.braze.ui.inappmessage.BrazeInAppMessageManager$Companion r4 = com.braze.ui.inappmessage.BrazeInAppMessageManager.Companion
                com.braze.ui.inappmessage.BrazeInAppMessageManager r4 = r4.getInstance()
                android.app.Activity r4 = r4.getActivity()
                if (r4 == 0) goto L_0x00cc
                r6 = 0
                r7 = 0
                r8 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$5 r9 = com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$5.INSTANCE
                r10 = 7
                r11 = 0
                r4 = r12
                r5 = r18
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                com.braze.BrazeInternal.handleInAppMessageTestPush(r19, r20)
                return r3
            L_0x00cc:
                boolean r1 = com.braze.push.BrazeNotificationUtils.isNotificationMessage(r20)
                if (r1 == 0) goto L_0x018a
                r6 = 0
                r7 = 0
                r8 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$6 r9 = com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$6.INSTANCE
                r10 = 7
                r1 = 0
                r4 = r12
                r5 = r18
                r13 = r11
                r11 = r1
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                int r1 = com.braze.push.BrazeNotificationUtils.getNotificationId(r13)
                java.lang.String r4 = "nid"
                r2.putInt(r4, r1)
                boolean r4 = r13.isPushStory()
                r11 = 1
                if (r4 == 0) goto L_0x0126
                boolean r4 = com.braze.Constants.isAmazonDevice()
                if (r4 == 0) goto L_0x0105
                r6 = 0
                r7 = 0
                r8 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$7 r9 = com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$7.INSTANCE
                r10 = 7
                r11 = 0
                r4 = r12
                r5 = r18
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                return r3
            L_0x0105:
                java.lang.String r10 = "appboy_story_newly_received"
                boolean r4 = r2.containsKey(r10)
                if (r4 != 0) goto L_0x0126
                r6 = 0
                r7 = 0
                r8 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$8 r9 = com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$8.INSTANCE
                r16 = 7
                r17 = 0
                r4 = r12
                r5 = r18
                r3 = r10
                r10 = r16
                r15 = r11
                r11 = r17
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                r2.putBoolean(r3, r15)
                goto L_0x0127
            L_0x0126:
                r15 = r11
            L_0x0127:
                com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.V
                r7 = 0
                r8 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$9 r9 = new com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$9
                r9.<init>(r13)
                r10 = 6
                r11 = 0
                r4 = r12
                r5 = r18
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                com.braze.IBrazeNotificationFactory r3 = com.braze.push.BrazeNotificationUtils.getActiveNotificationFactory()
                android.app.Notification r3 = r3.createNotification(r13)
                if (r3 != 0) goto L_0x0151
                r6 = 0
                r7 = 0
                r8 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$10 r9 = com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$10.INSTANCE
                r10 = 7
                r11 = 0
                r4 = r12
                r5 = r18
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
            L_0x014f:
                r0 = 0
                return r0
            L_0x0151:
                androidx.core.app.NotificationManagerCompat r11 = androidx.core.app.NotificationManagerCompat.from(r19)
                java.lang.String r4 = "from(context)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r4)
                r6 = 0
                r7 = 0
                r8 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$11 r9 = new com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$11
                r9.<init>(r11)
                r10 = 7
                r16 = 0
                r4 = r12
                r5 = r18
                r12 = r11
                r11 = r16
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                java.lang.String r4 = "appboy_notification"
                r12.notify(r4, r1, r3)
                com.braze.push.BrazeNotificationUtils.sendPushMessageReceivedBroadcast(r0, r2, r13)
                com.braze.push.BrazeNotificationUtils.wakeScreenIfAppropriate(r0, r14, r2)
                java.lang.Integer r2 = r13.getPushDuration()
                if (r2 != 0) goto L_0x0180
                goto L_0x0189
            L_0x0180:
                int r2 = r2.intValue()
                java.lang.Class<com.braze.push.BrazePushReceiver> r3 = com.braze.push.BrazePushReceiver.class
                com.braze.push.BrazeNotificationUtils.setNotificationDurationAlarm(r0, r3, r1, r2)
            L_0x0189:
                return r15
            L_0x018a:
                r13 = r11
                r6 = 0
                r7 = 0
                r8 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$13 r9 = com.braze.push.BrazePushReceiver$Companion$handlePushNotificationPayload$13.INSTANCE
                r10 = 7
                r11 = 0
                r4 = r12
                r5 = r18
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                com.braze.push.BrazeNotificationUtils.sendPushMessageReceivedBroadcast(r0, r2, r13)
                com.braze.push.BrazeNotificationUtils.requestGeofenceRefreshIfAppropriate(r13)
                com.braze.push.BrazeNotificationUtils.refreshFeatureFlagsIfAppropriate(r13)
                goto L_0x014f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.push.BrazePushReceiver.Companion.handlePushNotificationPayload(android.content.Context, android.content.Intent):boolean");
        }

        @JvmStatic
        @JvmOverloads
        public final void handleReceivedIntent(@NotNull Context context, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            handleReceivedIntent$default(this, context, intent, false, 4, (Object) null);
        }

        @JvmStatic
        @JvmOverloads
        public final void handleReceivedIntent(@NotNull Context context, @NotNull Intent intent, boolean z11) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            if (z11) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new BrazePushReceiver$Companion$handleReceivedIntent$1(context, intent, (Continuation<? super BrazePushReceiver$Companion$handleReceivedIntent$1>) null), 3, (Object) null);
            } else {
                handlePush(context, intent);
            }
        }
    }

    @JvmStatic
    @NotNull
    @VisibleForTesting
    public static final BrazeNotificationPayload createPayload(@NotNull Context context, @NotNull BrazeConfigurationProvider brazeConfigurationProvider, @NotNull Bundle bundle, @NotNull Bundle bundle2) {
        return Companion.createPayload(context, brazeConfigurationProvider, bundle, bundle2);
    }

    @JvmStatic
    @VisibleForTesting
    public static final boolean handleAdmRegistrationEventIfEnabled(@NotNull BrazeConfigurationProvider brazeConfigurationProvider, @NotNull Context context, @NotNull Intent intent) {
        return Companion.handleAdmRegistrationEventIfEnabled(brazeConfigurationProvider, context, intent);
    }

    @JvmStatic
    @VisibleForTesting
    public static final boolean handleAdmRegistrationIntent(@NotNull Context context, @NotNull Intent intent) {
        return Companion.handleAdmRegistrationIntent(context, intent);
    }

    @JvmStatic
    @VisibleForTesting
    public static final boolean handlePushNotificationPayload(@NotNull Context context, @NotNull Intent intent) {
        return Companion.handlePushNotificationPayload(context, intent);
    }

    @JvmStatic
    @JvmOverloads
    public static final void handleReceivedIntent(@NotNull Context context, @NotNull Intent intent) {
        Companion.handleReceivedIntent(context, intent);
    }

    @JvmStatic
    @JvmOverloads
    public static final void handleReceivedIntent(@NotNull Context context, @NotNull Intent intent, boolean z11) {
        Companion.handleReceivedIntent(context, intent, z11);
    }

    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        Companion.handleReceivedIntent$default(Companion, context, intent, false, 4, (Object) null);
    }
}
