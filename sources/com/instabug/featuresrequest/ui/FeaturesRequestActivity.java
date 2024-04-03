package com.instabug.featuresrequest.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.instabug.featuresrequest.FeaturesRequestPlugin;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.ui.custom.b;
import com.instabug.featuresrequest.ui.custom.v;
import com.instabug.featuresrequest.ui.featuredetails.c;
import com.instabug.featuresrequest.ui.featuresmain.f;
import com.instabug.library.Instabug;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.util.LocaleUtils;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Iterator;

@Instrumented
@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class FeaturesRequestActivity extends AppCompatActivity implements _InstabugActivity, TraceFieldInterface {
    public Trace _nr_trace;

    /* renamed from: i  reason: collision with root package name */
    public b f46595i;

    public void a() {
        b bVar = this.f46595i;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @VisibleForTesting
    public void a(boolean z11) {
        FeaturesRequestPlugin featuresRequestPlugin = (FeaturesRequestPlugin) InstabugCore.getXPlugin(FeaturesRequestPlugin.class);
        if (featuresRequestPlugin == null) {
            return;
        }
        if (z11) {
            featuresRequestPlugin.setState(1);
            return;
        }
        featuresRequestPlugin.setState(0);
        SDKCoreEventPublisher.post(new SDKCoreEvent(SDKCoreEvent.ForegroundStatus.TYPE_FOREGROUNDS_STATUS, SDKCoreEvent.ForegroundStatus.VALUE_AVAILABLE));
    }

    public void b() {
        for (Fragment next : getSupportFragmentManager().getFragments()) {
            if (next instanceof c) {
                ((c) next).P();
                return;
            }
        }
    }

    public void c() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        b a11 = b.a();
        this.f46595i = a11;
        a11.show(supportFragmentManager, "progress_dialog_fragment");
    }

    public void d() {
        onBackPressed();
        Iterator<Fragment> it = getSupportFragmentManager().getFragments().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Fragment next = it.next();
            if (next instanceof f) {
                ((f) next).Q();
                break;
            }
        }
        v.a().show(getSupportFragmentManager(), "thanks_dialog_fragment");
    }

    @SuppressLint({"STARVATION"})
    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("FeaturesRequestActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "FeaturesRequestActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FeaturesRequestActivity#onCreate", (ArrayList<String>) null);
        }
        LocaleUtils.setLocale(this, InstabugCore.getLocale(this));
        if (Instabug.getTheme() != null) {
            setTheme(com.instabug.featuresrequest.utils.c.b(Instabug.getTheme()));
        }
        super.onCreate(bundle);
        setContentView(R.layout.instabug_activity);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.instabug_fragment_container, new f()).commit();
        }
        a(true);
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        super.onDestroy();
        a(false);
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        ApplicationStateMonitor.getInstance().activityStopped();
        LocaleUtils.setAppLocale(this);
        super.onStop();
    }
}
