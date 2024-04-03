package com.talabat.feature.tpro.presentation.benefits;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.feature.tpro.presentation.benefits.inferface.IChangeStatusBarColor;
import com.talabat.feature.tpro.presentation.di.DaggerTproPresentationComponent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/TproBenefitsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/talabat/feature/tpro/presentation/benefits/inferface/IChangeStatusBarColor;", "()V", "changeStatusBarColor", "", "drawable", "Landroid/graphics/drawable/Drawable;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproBenefitsActivity extends AppCompatActivity implements IChangeStatusBarColor, TraceFieldInterface {
    public Trace _nr_trace;

    public void changeStatusBarColor(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, 17170445));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, 17170445));
        getWindow().setBackgroundDrawable(drawable);
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("TproBenefitsActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "TproBenefitsActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TproBenefitsActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_layout);
        ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi = (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class);
        DaggerTproPresentationComponent.factory().create(this, (ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), configurationRemoteCoreLibApi, (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(SubscriptionsFeatureApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DeepLinkCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
        if (bundle == null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            int i11 = R.id.fragmentContainer;
            TproBenefitsFragment tproBenefitsFragment = new TproBenefitsFragment();
            tproBenefitsFragment.setArguments(getIntent().getExtras());
            Unit unit = Unit.INSTANCE;
            beginTransaction.add(i11, (Fragment) tproBenefitsFragment).commit();
        }
        TraceMachine.exitMethod();
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
