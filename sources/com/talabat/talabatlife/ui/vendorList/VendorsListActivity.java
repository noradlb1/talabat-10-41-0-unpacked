package com.talabat.talabatlife.ui.vendorList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcore.BaseActivity;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatlife.ui.vendorList.di.DaggerVendorsListActivityComponent;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\fH\u0014J#\u0010\u0015\u001a\u00020\f2\u0019\b\u0002\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u0017¢\u0006\u0002\b\u0018H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/VendorsListActivity;", "Lcom/talabat/talabatcore/BaseActivity;", "()V", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "fragment", "Lcom/talabat/talabatcore/BaseFragment;", "inject", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "openHomeScreen", "init", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_IS_COFFEE_MODE = "isCoffeeMode";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/VendorsListActivity$Companion;", "", "()V", "EXTRA_IS_COFFEE_MODE", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void g(VendorsListActivity vendorsListActivity, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = VendorsListActivity$openHomeScreen$1.INSTANCE;
        }
        vendorsListActivity.openHomeScreen(function1);
    }

    private final void inject() {
        DaggerVendorsListActivityComponent.factory().create((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    private final void openHomeScreen(Function1<? super Intent, Unit> function1) {
        Navigator.Companion.navigate((Context) this, new NavigatorModel("talabat.action.homeScreen", (Bundle) null, function1, 2, (DefaultConstructorMarker) null));
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

    @NotNull
    public BaseFragment fragment() {
        return VendorsListFragment.Companion.getInstance(getIntent().getBooleanExtra("isCoffeeMode", false));
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlag");
        return null;
    }

    public void onBackPressed() {
        if (isTaskRoot()) {
            g(this, (Function1) null, 1, (Object) null);
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        inject();
        super.onCreate(bundle);
    }

    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public void onResume() {
        super.onResume();
        if (getIntent().getBooleanExtra(TLifeNavigationActions.EXTRA_IS_EXIT_FREE_COFFEE, false)) {
            finish();
        }
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }
}
