package com.talabat.feature.rating.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelLazy;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import com.talabat.feature.rating.presentation.di.DaggerRatingFeedbackActivityComponent;
import com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModel;
import com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModelFactory;
import com.talabat.talabatcore.logger.LogManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048@X\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/rating/presentation/RatingFeedbackActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "viewModel", "Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModel;", "getViewModel$com_talabat_feature_rating_presentation_presentation", "()Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModelFactory;", "getViewModelFactory", "()Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModelFactory;", "setViewModelFactory", "(Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModelFactory;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingFeedbackActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(RatingFeedBackViewModel.class), new RatingFeedbackActivity$special$$inlined$viewModels$default$2(this), new RatingFeedbackActivity$viewModel$2(this), new RatingFeedbackActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    @Inject
    public RatingFeedBackViewModelFactory viewModelFactory;

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

    @NotNull
    public final RatingFeedBackViewModel getViewModel$com_talabat_feature_rating_presentation_presentation() {
        return (RatingFeedBackViewModel) this.viewModel$delegate.getValue();
    }

    @NotNull
    public final RatingFeedBackViewModelFactory getViewModelFactory() {
        RatingFeedBackViewModelFactory ratingFeedBackViewModelFactory = this.viewModelFactory;
        if (ratingFeedBackViewModelFactory != null) {
            return ratingFeedBackViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("RatingFeedbackActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "RatingFeedbackActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "RatingFeedbackActivity#onCreate", (ArrayList<String>) null);
        }
        DaggerRatingFeedbackActivityComponent.factory().create(this, (RatingFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(RatingFeatureApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_rating_feedback);
        getWindow().setLayout(-1, -1);
        int hashCode = getViewModel$com_talabat_feature_rating_presentation_presentation().hashCode();
        LogManager.info("vm " + hashCode);
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

    public final void setViewModelFactory(@NotNull RatingFeedBackViewModelFactory ratingFeedBackViewModelFactory) {
        Intrinsics.checkNotNullParameter(ratingFeedBackViewModelFactory, "<set-?>");
        this.viewModelFactory = ratingFeedBackViewModelFactory;
    }
}
