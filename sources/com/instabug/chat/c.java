package com.instabug.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import com.instabug.chat.cache.d;
import com.instabug.chat.cache.k;
import com.instabug.chat.network.i;
import com.instabug.chat.settings.a;
import com.instabug.chat.synchronization.SynchronizationManager;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.invocation.InvocationManager;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

abstract class c {
    public static long a() {
        return a.b();
    }

    private static PluginPromptOption a(Context context) {
        PluginPromptOption pluginPromptOption = new PluginPromptOption();
        pluginPromptOption.setOrder(-1);
        pluginPromptOption.setInvocationMode(4);
        pluginPromptOption.setInitialScreenshotRequired(false);
        pluginPromptOption.setNotificationCount(k.h());
        pluginPromptOption.setPromptOptionIdentifier(2);
        pluginPromptOption.setIcon(R.drawable.ibg_core_ic_talk_to_us);
        pluginPromptOption.setOnInvocationListener(new a(context));
        return pluginPromptOption;
    }

    public static Disposable b(Consumer consumer) {
        return SDKCoreEventSubscriber.subscribe(consumer);
    }

    public static void b() {
        InvocationManager.getInstance().notifyInvocationOptionChanged();
    }

    public static void c(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    private static boolean c() {
        return InstabugCore.getFeatureState(Feature.IN_APP_MESSAGING) == Feature.State.ENABLED;
    }

    private static void d(Context context) {
        SynchronizationManager.init(context);
    }

    public static Consumer e(Context context) {
        return new b(context);
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    private static void e() {
        SynchronizationManager.getInstance().release();
    }

    public static ArrayList f(Context context) {
        ArrayList arrayList = new ArrayList();
        if (c() && InstabugCore.isFeatureEnabled(Feature.REPLIES) && f.b()) {
            arrayList.add(a(context));
        }
        return arrayList;
    }

    public static void f() {
        String pushNotificationToken = InstabugCore.getPushNotificationToken();
        if (!InstabugCore.isPushNotificationTokenSent() && pushNotificationToken != null && !pushNotificationToken.isEmpty() && Instabug.getApplicationContext() != null) {
            i.a().start();
        }
    }

    public static void g() {
        e();
        d.b();
        a.l();
    }

    public static void h(Context context) {
        a.b(context);
        d.a(context);
        d.a();
        d(context);
    }
}
