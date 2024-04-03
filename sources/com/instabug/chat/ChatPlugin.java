package com.instabug.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.chat.model.k;
import com.instabug.chat.notification.v;
import com.instabug.library.Feature;
import com.instabug.library.PresentationManager;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class ChatPlugin extends Plugin implements com.instabug.chat.synchronization.b {
    private Disposable coreEventsDisposable;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f45984b;

        public a(Context context) {
            this.f45984b = context;
        }

        public void run() {
            ChatPlugin.this.subscribeOnCoreEvents();
            com.instabug.chat.synchronization.a.b().a((com.instabug.chat.synchronization.b) ChatPlugin.this);
            c.h(this.f45984b);
            ChatPlugin.this.sendPushNotificationToken();
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f45986b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f45987c;

        public b(ChatPlugin chatPlugin, Context context, List list) {
            this.f45986b = context;
            this.f45987c = list;
        }

        public void run() {
            v.a().a(this.f45986b, this.f45987c);
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NULL_DEREFERENCE"})
    public void sendPushNotificationToken() {
        c.f();
    }

    private void unSubscribeFromCoreEvents() {
        c.c(this.coreEventsDisposable);
    }

    public long getLastActivityTime() {
        return c.a();
    }

    @Nullable
    public ArrayList<PluginPromptOption> getPluginOptions(boolean z11) {
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return c.f(this.contextWeakReference.get());
    }

    @Nullable
    public ArrayList<PluginPromptOption> getPromptOptions() {
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return c.f(this.contextWeakReference.get());
    }

    public void init(Context context) {
        super.init(context);
    }

    public void initDefaultPromptOptionAvailabilityState() {
        c.b();
    }

    public boolean isFeatureEnabled() {
        return InstabugCore.isFeatureEnabled(Feature.CHATS);
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_RETURN_ANNOTATION"})
    @Nullable
    public List<k> onNewMessagesReceived(@NonNull List<k> list) {
        Context context;
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return null;
        }
        if (InstabugCore.isAppOnForeground()) {
            PresentationManager.getInstance().show(new b(this, context, list));
            return null;
        }
        v.a().a(context, (List) list);
        return null;
    }

    public void sleep() {
    }

    public void start(Context context) {
        PoolProvider.postIOTaskWithCheck(new a(context));
    }

    public void stop() {
        unSubscribeFromCoreEvents();
        c.g();
        com.instabug.chat.synchronization.a.b().b((com.instabug.chat.synchronization.b) this);
    }

    @VisibleForTesting
    public void subscribeOnCoreEvents() {
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference != null && weakReference.get() != null) {
            this.coreEventsDisposable = c.b(c.e(this.contextWeakReference.get()));
        }
    }

    public void wake() {
    }
}
