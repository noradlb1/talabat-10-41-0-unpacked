package com.instabug.bug;

import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.bug.di.a;
import com.instabug.bug.network.i;
import com.instabug.bug.settings.b;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class BugPlugin extends Plugin {
    @Nullable
    private Disposable coreEventsDisposable;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0(Context context) {
        t.c(context);
        subscribeOnCoreEvents();
        runInterruptedMigrations();
        i.b().start();
    }

    private void runInterruptedMigrations() {
        WeakReference<Context> weakReference;
        if (!b.f().b() && (weakReference = this.contextWeakReference) != null && weakReference.get() != null) {
            a.b().a(this.contextWeakReference.get(), InstabugCore.isDbEncryptionEnabled() ? "encrypt_db" : "decrypt_db");
        }
    }

    private void subscribeOnCoreEvents() {
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference != null && weakReference.get() != null) {
            this.coreEventsDisposable = t.a(t.a(this.contextWeakReference.get()));
        }
    }

    private void unSubscribeFromCoreEvents() {
        t.j(this.coreEventsDisposable);
    }

    public long getLastActivityTime() {
        return b.f().g();
    }

    @Nullable
    public ArrayList<PluginPromptOption> getPluginOptions(boolean z11) {
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return t.i(z11, this.contextWeakReference.get());
    }

    public ArrayList<PluginPromptOption> getPromptOptions() {
        WeakReference<Context> weakReference = this.contextWeakReference;
        return (weakReference == null || weakReference.get() == null) ? new ArrayList<>() : t.k(this.contextWeakReference.get());
    }

    public void init(Context context) {
        a.e().a();
        super.init(context);
    }

    public void initDefaultPromptOptionAvailabilityState() {
        t.c();
    }

    public boolean isFeatureEnabled() {
        return InstabugCore.isFeatureEnabled(Feature.BUG_REPORTING);
    }

    public void sleep() {
    }

    public void start(Context context) {
        PoolProvider.postIOTaskWithCheck(new xb.a(this, context));
    }

    public void stop() {
        t.g();
        unSubscribeFromCoreEvents();
    }

    public void wake() {
    }
}
