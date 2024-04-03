package com.instabug.chat;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import com.instabug.chat.cache.k;
import com.instabug.chat.network.i;
import com.instabug.chat.notification.v;
import com.instabug.chat.settings.AttachmentTypesState;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.OnSdkDismissCallback;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.util.threading.PoolProvider;
import java.util.Map;

public class ChatsDelegate {

    public class a implements Runnable {
        public void run() {
            ChatPlugin chatPlugin;
            Context appContext;
            if (ChatsDelegate.isReadyToRun() && (chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class)) != null && (appContext = chatPlugin.getAppContext()) != null) {
                appContext.startActivity(com.instabug.chat.ui.a.a(appContext));
            }
        }
    }

    public static void dismissSystemNotification() {
        v.a().a(Instabug.getApplicationContext());
    }

    @Deprecated
    public static void enableConversationSound(boolean z11) {
        if (isReadyToRun()) {
            com.instabug.chat.settings.a.a(z11);
        }
    }

    public static void enableInAppNotificationSound(boolean z11) {
        if (isReadyToRun()) {
            com.instabug.chat.settings.a.b(z11);
        }
    }

    public static void enableNotification(boolean z11) {
        if (isReadyToRun()) {
            com.instabug.chat.settings.a.c(z11);
        }
    }

    @Deprecated
    public static void enableSystemNotificationSound(boolean z11) {
        if (isReadyToRun()) {
            Replies.setSystemReplyNotificationSoundEnabled(z11);
        }
    }

    public static int getUnreadMessagesCount() {
        if (isReadyToRun()) {
            return k.h();
        }
        return 0;
    }

    private static boolean isChatFeatureEnabled() {
        return InstabugCore.getFeatureState(Feature.IN_APP_MESSAGING) == Feature.State.ENABLED;
    }

    @Deprecated
    public static boolean isInstabugNotification(Bundle bundle) {
        if (isReadyToRun()) {
            return Replies.isInstabugNotification(bundle);
        }
        return false;
    }

    @Deprecated
    public static boolean isInstabugNotification(Map<String, String> map) {
        if (isReadyToRun()) {
            return Replies.isInstabugNotification(map);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean isReadyToRun() {
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        return chatPlugin != null && chatPlugin.isAppContextAvailable() && isChatFeatureEnabled();
    }

    @Deprecated
    public static void openNewChat() {
        if (isReadyToRun()) {
            InvocationManager.getInstance().forceInvoke(3);
        }
    }

    public static void setAttachmentTypesEnabled(boolean z11, boolean z12, boolean z13) {
        com.instabug.chat.settings.a.a(new AttachmentTypesState(z11, z12, z13));
    }

    public static void setNewMessageHandler(Runnable runnable) {
        com.instabug.chat.settings.a.a(runnable);
    }

    @Deprecated
    public static void setNotificationIcon(@DrawableRes int i11) {
        if (isReadyToRun()) {
            Replies.setNotificationIcon(i11);
        }
    }

    public static void setOnSdkDismissCallback(OnSdkDismissCallback onSdkDismissCallback) {
        com.instabug.chat.settings.a.a(onSdkDismissCallback);
    }

    @RequiresApi(api = 26)
    public static void setPushNotificationChannelId(String str) {
        Replies.setPushNotificationChannelId(str);
    }

    public static void setPushNotificationRegistrationToken(String str) {
        if (isReadyToRun() && str != null && !str.isEmpty() && !str.equalsIgnoreCase(InstabugCore.getPushNotificationToken())) {
            InstabugCore.setPushNotificationToken(str);
            InstabugCore.setPushNotificationTokenSent(false);
            ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
            if (chatPlugin != null && chatPlugin.getAppContext() != null && InstabugCore.getFeatureState(Feature.PUSH_NOTIFICATION) == Feature.State.ENABLED) {
                i.a().start();
            }
        }
    }

    public static void showChats() {
        PoolProvider.postMainThreadTask(new a());
    }

    public static void showNotification(Bundle bundle) {
        if (isReadyToRun()) {
            v.a().b(bundle);
        }
    }

    public static void showNotification(Map<String, String> map) {
        if (isReadyToRun()) {
            v.a().b((Map) map);
        }
    }

    public static void skipImageAttachmentAnnotation(boolean z11) {
        if (isReadyToRun()) {
            com.instabug.chat.settings.a.e(z11);
        }
    }
}
