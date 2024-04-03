package com.talabat.talabatlife.ui.tLifeTermsAndConditions;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.integration.IntegrationGlobalDataModel;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.core.network.endpoint.TLifeEndPointProvider;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.features.UrlConstantsKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"Lcom/talabat/talabatlife/ui/tLifeTermsAndConditions/TLifeTermsAndConditionsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "createURL", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeTermsAndConditionsActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    private final String createURL() {
        Uri uri;
        Uri.Builder appendPath = Uri.parse(TLifeEndPointProvider.INSTANCE.getBaseUrl()).buildUpon().appendPath(UrlConstantsKt.TLIFE_TERMS_AND_CONDITION_PATH);
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        Uri.Builder appendPath2 = appendPath.appendPath(String.valueOf(companion.selectedCountryCode()));
        String substring = companion.selectedLanguage().substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        Uri.Builder appendPath3 = appendPath2.appendPath(substring + UrlConstantsKt.HTML_EXTENSION);
        if (appendPath3 != null) {
            uri = appendPath3.build();
        } else {
            uri = null;
        }
        return String.valueOf(uri);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("TLifeTermsAndConditionsActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "TLifeTermsAndConditionsActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TLifeTermsAndConditionsActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_tlife_terms_and_conditions);
        LogManager.debug(createURL());
        int i11 = R.id.tLife_terms_and_conditions_web_view;
        ((WebView) _$_findCachedViewById(i11)).setWebViewClient(new WebViewClient());
        ((WebView) _$_findCachedViewById(i11)).loadUrl(createURL());
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
