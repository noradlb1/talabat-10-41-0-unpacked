package com.instabug.featuresrequest;

import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.featuresrequest.network.service.l;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class FeaturesRequestPlugin extends Plugin {
    private CompositeDisposable disposables = new CompositeDisposable();

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f46512b;

        public a(Context context) {
            this.f46512b = context;
        }

        public void run() {
            c.d(this.f46512b);
            FeaturesRequestPlugin.this.subscribeOnSDKEvents();
        }
    }

    public class b implements Consumer {
        public b() {
        }

        /* renamed from: a */
        public void accept(SDKCoreEvent sDKCoreEvent) {
            if (SDKCoreEvent.Network.TYPE_NETWORK.equals(sDKCoreEvent.getType()) && sDKCoreEvent.getValue().equals(SDKCoreEvent.Network.VALUE_ACTIVATED)) {
                FeaturesRequestPlugin.this.submitPendingVotes();
            }
        }
    }

    public class c implements Runnable {
        public c(FeaturesRequestPlugin featuresRequestPlugin) {
        }

        public void run() {
            try {
                List a11 = com.instabug.featuresrequest.cache.a.a();
                if (a11 != null && !a11.isEmpty()) {
                    l.b().start();
                }
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-FR", "Error occurred during Feature Requests retrieval from DB: " + e11.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void submitPendingVotes() {
        String str;
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference == null) {
            str = "Context WeakReference is null.";
        } else if (weakReference.get() != null) {
            PoolProvider.postIOTask(new c(this));
            return;
        } else {
            str = "Context is null.";
        }
        InstabugSDKLogger.e("IBG-FR", str);
    }

    /* access modifiers changed from: private */
    public void subscribeOnSDKEvents() {
        this.disposables.add(SDKCoreEventSubscriber.subscribe(new b()));
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
        return c.b(this.contextWeakReference.get());
    }

    @Nullable
    public ArrayList<PluginPromptOption> getPromptOptions() {
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return c.b(this.contextWeakReference.get());
    }

    public void init(Context context) {
        super.init(context);
    }

    public boolean isFeatureEnabled() {
        return InstabugCore.isFeatureEnabled(Feature.FEATURE_REQUESTS);
    }

    public void sleep() {
    }

    public void start(Context context) {
        PoolProvider.postIOTaskWithCheck(new a(context));
    }

    public void stop() {
        c.b();
    }

    public void wake() {
    }
}
