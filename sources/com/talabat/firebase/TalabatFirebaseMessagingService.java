package com.talabat.firebase;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.braze.push.BrazeFirebaseMessagingService;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.R;
import com.talabat.chat.api.ChatApi;
import com.talabat.chat.di.ChatFactory;
import com.talabat.chat.domain.ChatPushData;
import com.talabat.splash.presentation.ui.SplashActivity;
import com.talabat.talabatcore.logger.LogManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import xp.c;

@Instrumented
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0016"}, d2 = {"Lcom/talabat/firebase/TalabatFirebaseMessagingService;", "Lcom/braze/push/BrazeFirebaseMessagingService;", "()V", "getLargeIcon", "Landroid/graphics/Bitmap;", "getSmallIcon", "", "getTalabatAppIntent", "Landroid/app/PendingIntent;", "handleMessageFromChatProvider", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "notifyUserAboutNewChatMessage", "chatPushData", "Lcom/talabat/chat/domain/ChatPushData;", "onMessageReceived", "onNewToken", "newFcmToken", "", "registerFcmTokenToChatProvider", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatFirebaseMessagingService extends BrazeFirebaseMessagingService {
    @NotNull
    public static final Companion Companion;
    /* access modifiers changed from: private */
    @NotNull
    public static final ChatApi chatApi;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J=\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\tJ\u0006\u0010\u0010\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/firebase/TalabatFirebaseMessagingService$Companion;", "", "()V", "chatApi", "Lcom/talabat/chat/api/ChatApi;", "getChatProvider", "getFCMToken", "", "onSuccess", "Lkotlin/Function1;", "", "onError", "", "Lkotlin/ParameterName;", "name", "throwable", "unregisterToken", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final ChatApi getChatProvider() {
            return ChatFactory.Companion.getInstance$default(ChatFactory.Companion, (ChatApi) null, 1, (Object) null).initializeChatProvider();
        }

        /* access modifiers changed from: private */
        /* renamed from: getFCMToken$lambda-0  reason: not valid java name */
        public static final void m10443getFCMToken$lambda0(Function1 function1, Function1 function12, Task task) {
            boolean z11;
            Intrinsics.checkNotNullParameter(function1, "$onError");
            Intrinsics.checkNotNullParameter(function12, "$onSuccess");
            Intrinsics.checkNotNullParameter(task, "task");
            if (!task.isSuccessful()) {
                LogManager.error(task.getException(), "getInstanceId Failed!");
                Exception exception = task.getException();
                if (exception == null) {
                    exception = new Exception();
                }
                function1.invoke(exception);
                return;
            }
            String str = (String) task.getResult();
            LogManager.debug("FCM registration token is: " + str);
            if (str == null || str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                Intrinsics.checkNotNullExpressionValue(str, "fcmToken");
                function12.invoke(str);
                return;
            }
            function1.invoke(new Exception("FCM token was null or empty"));
        }

        public final void getFCMToken(@NotNull Function1<? super String, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
            Intrinsics.checkNotNullParameter(function1, "onSuccess");
            Intrinsics.checkNotNullParameter(function12, "onError");
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new c(function12, function1));
        }

        public final void unregisterToken() {
            LogManager.debug("Un-registering from chat provider.");
            ChatApi.DefaultImpls.unregisterToken$default(TalabatFirebaseMessagingService.chatApi, (Function0) null, (Function1) null, 3, (Object) null);
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        chatApi = companion.getChatProvider();
    }

    private final Bitmap getLargeIcon() {
        return BitmapFactoryInstrumentation.decodeResource(getResources(), R.mipmap.ic_launcher);
    }

    private final int getSmallIcon() {
        return R.mipmap.talabat_notification_small_white;
    }

    private final PendingIntent getTalabatAppIntent() {
        Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
        intent.addFlags(335577088);
        PendingIntent activity = PendingIntent.getActivity(this, Random.Default.nextInt(), intent, 67108864);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(\n           ….FLAG_IMMUTABLE\n        )");
        return activity;
    }

    private final void handleMessageFromChatProvider(RemoteMessage remoteMessage) {
        ChatApi chatApi2 = chatApi;
        boolean isChatMessage = chatApi2.isChatMessage(remoteMessage.getData());
        LogManager.debug("onMessageReceived:isMessageFromChatProvider: " + isChatMessage);
        if (isChatMessage) {
            Map<String, String> data = remoteMessage.getData();
            Intrinsics.checkNotNullExpressionValue(data, "remoteMessage.data");
            ChatPushData parseChatMessage = chatApi2.parseChatMessage(data);
            LogManager.debug(parseChatMessage.toString());
            notifyUserAboutNewChatMessage(parseChatMessage);
        }
    }

    private final void notifyUserAboutNewChatMessage(ChatPushData chatPushData) {
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder((Context) this, getString(R.string.chat_channel_id)).setSmallIcon(getSmallIcon()).setLargeIcon(getLargeIcon()).setContentTitle(getString(R.string.rider_chat_message_notification_title)).setContentText(chatPushData.getMessage()).setPriority(0).setAutoCancel(true).setContentIntent(getTalabatAppIntent());
        Intrinsics.checkNotNullExpressionValue(contentIntent, "Builder(this, getString(…nt(getTalabatAppIntent())");
        NotificationManagerCompat.from(this).notify(Random.Default.nextInt(), contentIntent.build());
    }

    private final void registerFcmTokenToChatProvider(String str) {
        ChatApi.DefaultImpls.registerToken$default(chatApi, str, (Function0) null, (Function1) null, 6, (Object) null);
    }

    public void onMessageReceived(@NotNull RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        LogManager.debug("onMessageReceived");
        super.onMessageReceived(remoteMessage);
        if (!BrazeFirebaseMessagingService.Companion.handleBrazeRemoteMessage(this, remoteMessage)) {
            handleMessageFromChatProvider(remoteMessage);
        }
    }

    public void onNewToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "newFcmToken");
        super.onNewToken(str);
        LogManager.debug("onNewToken: " + str);
        registerFcmTokenToChatProvider(str);
    }
}
