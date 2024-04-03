package com.talabat.talabatcommon.views.ridersTip;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.RiderTipFunWithFragHelper;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.enums.OrderStatus;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderBottomSheetState;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderSource;
import com.talabat.talabatcommon.utils.DateConstants;
import com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipBottomSheetDialogFragment;
import com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipStatusListener;
import com.talabat.talabatcommon.views.ridersTip.di.DaggerRiderTipButtonComponent;
import com.talabat.talabatcommon.views.ridersTip.model.RiderTipMapper;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/RiderTipButton;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "initDagger", "", "showRiderTipButton", "isTalabatGo", "", "orderReceivedTime", "", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipButton extends LinearLayout {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/RiderTipButton$Companion;", "", "()V", "showRiderTipBottomSheet", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "encryptedOrderId", "", "orderId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void showRiderTipBottomSheet(@NotNull FragmentManager fragmentManager, @NotNull String str, @NotNull String str2) {
            String str3 = str;
            String str4 = str2;
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(str3, "encryptedOrderId");
            Intrinsics.checkNotNullParameter(str4, "orderId");
            TipRiderBottomSheetState tipRiderBottomSheetState = TipRiderBottomSheetState.OPEN_PAYMENT_WIDGET;
            TipRiderSource tipRiderSource = TipRiderSource.HOME_SCREEN;
            RiderTipBottomSheetDialogFragment riderTipBottomSheetDialogFragment = r1;
            RiderTipBottomSheetDialogFragment riderTipBottomSheetDialogFragment2 = new RiderTipBottomSheetDialogFragment((RiderTipStatusListener) null, tipRiderBottomSheetState, tipRiderSource, OrderStatus.DELIVERED, str2, str, tipRiderSource.getScreenName(), (Float) null, 129, (DefaultConstructorMarker) null);
            Bundle bundle = new Bundle();
            bundle.putString("encryptedOrderId", str3);
            bundle.putString("orderId", str4);
            bundle.putString("screen_type", tipRiderSource.getScreenName());
            riderTipBottomSheetDialogFragment.setArguments(bundle);
            fragmentManager.beginTransaction();
            riderTipBottomSheetDialogFragment.show(fragmentManager, "");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipButton(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initDagger();
        View.inflate(getContext(), R.layout.view_rider_tip, this);
    }

    private final void initDagger() {
        DaggerRiderTipButtonComponent.factory().create((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
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
    public final ITalabatFeatureFlag getFeatureFlagRepo() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepo;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepo");
        return null;
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public final void showRiderTipButton(boolean z11, @Nullable String str) {
        RiderTipMapper.Companion companion = RiderTipMapper.Companion;
        if (str == null) {
            str = "";
        }
        boolean isRiderTipWithinExpiryTime = companion.isRiderTipWithinExpiryTime(str, DateConstants.DEFAULT_UTC_FORMAT, 14);
        int i11 = 0;
        if (!getFeatureFlagRepo().getFeatureFlag(RiderTipFunWithFragHelper.Companion.getFwfKeyForThisCountry(), false) || !z11 || !isRiderTipWithinExpiryTime) {
            i11 = 8;
        }
        setVisibility(i11);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initDagger();
        View.inflate(getContext(), R.layout.view_rider_tip, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        initDagger();
        View.inflate(getContext(), R.layout.view_rider_tip, this);
    }
}
