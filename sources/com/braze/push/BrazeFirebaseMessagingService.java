package com.braze.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.push.BrazePushReceiver;
import com.braze.support.BrazeLogger;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/braze/push/BrazeFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "onMessageReceived", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "newToken", "", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BrazeFirebaseMessagingService extends FirebaseMessagingService {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\n"}, d2 = {"Lcom/braze/push/BrazeFirebaseMessagingService$Companion;", "", "()V", "handleBrazeRemoteMessage", "", "context", "Landroid/content/Context;", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "isBrazePushNotification", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean handleBrazeRemoteMessage(@NotNull Context context, @NotNull RemoteMessage remoteMessage) {
            RemoteMessage remoteMessage2 = remoteMessage;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(remoteMessage2, "remoteMessage");
            if (!isBrazePushNotification(remoteMessage2)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$1(remoteMessage2), 6, (Object) null);
                return false;
            }
            Map<String, String> data = remoteMessage.getData();
            Intrinsics.checkNotNullExpressionValue(data, "remoteMessage.data");
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$2(data), 6, (Object) null);
            Intent intent = new Intent(BrazePushReceiver.FIREBASE_MESSAGING_SERVICE_ROUTING_ACTION);
            Bundle bundle = new Bundle();
            for (Map.Entry next : data.entrySet()) {
                String str = (String) next.getKey();
                String str2 = (String) next.getValue();
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$3(str, str2), 6, (Object) null);
                bundle.putString(str, str2);
            }
            intent.putExtras(bundle);
            BrazePushReceiver.Companion.handleReceivedIntent$default(BrazePushReceiver.Companion, context, intent, false, 4, (Object) null);
            return true;
        }

        @JvmStatic
        public final boolean isBrazePushNotification(@NotNull RemoteMessage remoteMessage) {
            Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
            Map<String, String> data = remoteMessage.getData();
            Intrinsics.checkNotNullExpressionValue(data, "remoteMessage.data");
            return Intrinsics.areEqual((Object) "true", (Object) data.get("_ab"));
        }
    }

    @JvmStatic
    public static final boolean handleBrazeRemoteMessage(@NotNull Context context, @NotNull RemoteMessage remoteMessage) {
        return Companion.handleBrazeRemoteMessage(context, remoteMessage);
    }

    @JvmStatic
    public static final boolean isBrazePushNotification(@NotNull RemoteMessage remoteMessage) {
        return Companion.isBrazePushNotification(remoteMessage);
    }

    public void onMessageReceived(@NotNull RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        super.onMessageReceived(remoteMessage);
        Companion.handleBrazeRemoteMessage(this, remoteMessage);
    }

    public void onNewToken(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "newToken");
        super.onNewToken(str);
        BrazeInternal.applyPendingRuntimeConfiguration(this);
        BrazeConfigurationProvider brazeConfigurationProvider = new BrazeConfigurationProvider(this);
        Braze.Companion companion = Braze.Companion;
        String configuredApiKey = companion.getConfiguredApiKey(brazeConfigurationProvider);
        if (configuredApiKey == null || configuredApiKey.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeFirebaseMessagingService$onNewToken$1(str), 6, (Object) null);
        } else if (!brazeConfigurationProvider.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeFirebaseMessagingService$onNewToken$2(str), 6, (Object) null);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeFirebaseMessagingService$onNewToken$3(str), 6, (Object) null);
            companion.getInstance(this).setRegisteredPushToken(str);
        }
    }
}
