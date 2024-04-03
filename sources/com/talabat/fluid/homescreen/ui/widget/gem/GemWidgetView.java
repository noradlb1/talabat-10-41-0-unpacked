package com.talabat.fluid.homescreen.ui.widget.gem;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.gem.adapters.presentation.home.entrypoint.GemHomeEntryPointView;
import com.talabat.homescreen.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/widget/gem/GemWidgetView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gemExpirationCallback", "Lcom/talabat/fluid/homescreen/ui/widget/gem/GemExpirationCallback;", "onGemAvailabilityCallback", "Lkotlin/Function1;", "", "", "bind", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemWidgetView extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    @Nullable
    public final GemExpirationCallback gemExpirationCallback;
    @NotNull
    private final Function1<Boolean, Unit> onGemAvailabilityCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemWidgetView(@NotNull Context context) {
        super(context);
        GemExpirationCallback gemExpirationCallback2;
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof GemExpirationCallback) {
            gemExpirationCallback2 = (GemExpirationCallback) context;
        } else {
            gemExpirationCallback2 = null;
        }
        this.gemExpirationCallback = gemExpirationCallback2;
        this.onGemAvailabilityCallback = new GemWidgetView$onGemAvailabilityCallback$1(this);
        View.inflate(context, R.layout.layout_gem_widget, this);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setId(View.generateViewId());
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

    public final void bind() {
        GemHomeEntryPointView gemHomeEntryPointView = (GemHomeEntryPointView) findViewById(R.id.gemHomeEntryPoint);
        if (gemHomeEntryPointView != null) {
            gemHomeEntryPointView.setAvailabilityCallBack(this.onGemAvailabilityCallback);
        }
        if (!TalabatExperiment.INSTANCE.getBooleanVariant(TalabatFeatureFlagConstants.GEM_NEW_HOME, false, TalabatExperimentDataSourceStrategy.FWF)) {
            this.onGemAvailabilityCallback.invoke(Boolean.FALSE);
        }
    }
}
