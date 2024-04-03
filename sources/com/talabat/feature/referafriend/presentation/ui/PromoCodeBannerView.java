package com.talabat.feature.referafriend.presentation.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.referafriend.R;
import com.talabat.feature.referafriend.domain.models.PromoCodeClickedEvent;
import com.talabat.feature.referafriend.presentation.ui.ReferAFriendReceiverFlutterActivity;
import com.talabat.growth.ui.vouchers.list.VouchersListFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/referafriend/presentation/ui/PromoCodeBannerView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatFeatureFlag$delegate", "Lkotlin/Lazy;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "talabatTracker$delegate", "onClick", "", "v", "Landroid/view/View;", "com_talabat_feature_refer-a-friend_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PromoCodeBannerView extends FrameLayout implements View.OnClickListener {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final Lazy talabatFeatureFlag$delegate;
    @NotNull
    private final Lazy talabatTracker$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PromoCodeBannerView(@NotNull Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PromoCodeBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.talabatFeatureFlag$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new PromoCodeBannerView$talabatFeatureFlag$2(this));
        this.talabatTracker$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new PromoCodeBannerView$talabatTracker$2(this));
        View.inflate(context, R.layout.get_a_code_layout, this);
        int i11 = 0;
        if (getTalabatFeatureFlag().getFeatureFlag(HomePageFeatureFlagsKeys.INCENTIVES_REFER_A_FRIEND, false)) {
            setOnClickListener(this);
        } else {
            i11 = 8;
        }
        setVisibility(i11);
    }

    private final ITalabatFeatureFlag getTalabatFeatureFlag() {
        return (ITalabatFeatureFlag) this.talabatFeatureFlag$delegate.getValue();
    }

    private final TalabatTracker getTalabatTracker() {
        return (TalabatTracker) this.talabatTracker$delegate.getValue();
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

    public void onClick(@Nullable View view) {
        Activity activity;
        getTalabatTracker().track(new PromoCodeClickedEvent(ScreenNames.VOUCHER_WALLET_SCREEN, VouchersListFragment.VOUCHER_LIST));
        ReferAFriendReceiverFlutterActivity.Companion companion = ReferAFriendReceiverFlutterActivity.Companion;
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        companion.openActivity(activity);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromoCodeBannerView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }
}
