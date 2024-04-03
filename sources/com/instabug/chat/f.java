package com.instabug.chat;

import android.os.Bundle;
import com.instabug.chat.cache.k;
import com.instabug.chat.notification.v;
import com.instabug.chat.settings.a;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.invocation.InvocationManager;
import java.util.Map;

public abstract class f {
    public static int a() {
        return ChatsDelegate.getUnreadMessagesCount();
    }

    public static void a(int i11) {
        if (d()) {
            a.a(i11);
        }
    }

    public static void a(Feature.State state) {
        InstabugCore.setRepliesState(state);
        InstabugCore.setPushNotificationState(state);
    }

    public static void a(Runnable runnable) {
        if (d()) {
            ChatsDelegate.setNewMessageHandler(runnable);
        }
    }

    public static void a(String str) {
        if (d()) {
            a.a(str);
        }
    }

    public static void a(boolean z11) {
        if (d()) {
            a.a(z11);
        }
    }

    public static boolean a(Bundle bundle) {
        return v.a().a(bundle);
    }

    public static boolean a(Map map) {
        return v.a().a(map);
    }

    public static void b(Bundle bundle) {
        if (d()) {
            ChatsDelegate.showNotification(bundle);
        }
    }

    public static void b(Feature.State state) {
        a(state);
        InvocationManager.getInstance().notifyInvocationOptionChanged();
    }

    public static void b(String str) {
        if (d()) {
            ChatsDelegate.setPushNotificationRegistrationToken(str);
        }
    }

    public static void b(Map map) {
        if (d()) {
            ChatsDelegate.showNotification((Map<String, String>) map);
        }
    }

    public static void b(boolean z11) {
        if (d()) {
            ChatsDelegate.enableInAppNotificationSound(z11);
        }
    }

    public static boolean b() {
        return k.i().size() > 0;
    }

    public static void c(boolean z11) {
        if (d()) {
            ChatsDelegate.enableNotification(z11);
        }
    }

    public static boolean c() {
        return InstabugCore.getFeatureState(Feature.IN_APP_MESSAGING) == Feature.State.ENABLED && (InstabugCore.isFeatureEnabled(Feature.CHATS) || InstabugCore.isFeatureEnabled(Feature.REPLIES));
    }

    public static void d(boolean z11) {
        if (d()) {
            a.d(z11);
        }
    }

    private static boolean d() {
        return InstabugCore.isFeatureEnabled(Feature.REPLIES);
    }

    public static void e() {
        if (d() && k.i().size() > 0) {
            ChatsDelegate.showChats();
        }
    }
}
