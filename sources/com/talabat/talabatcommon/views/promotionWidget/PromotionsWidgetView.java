package com.talabat.talabatcommon.views.promotionWidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.extentions.ImageViewForTalabatKt;
import com.talabat.talabatcommon.feature.promotionWidget.model.response.WidgetInfo;
import com.talabat.talabatcommon.views.customMvvmView.MvvmLinearLayout;
import com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel;
import com.talabat.talabatcommon.views.promotionWidget.viewModel.PromotionsWidgetViewModel;
import com.talabat.talabatcommon.views.promotionWidget.viewModel.PromotionsWidgetViewModelBuilder;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import io.supercharge.shimmerlayout.ShimmerLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ov.a;
import ov.b;
import ov.c;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\fJ\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020\u0002H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/talabatcommon/views/promotionWidget/PromotionsWidgetView;", "Lcom/talabat/talabatcommon/views/customMvvmView/MvvmLinearLayout;", "Lcom/talabat/talabatcommon/views/promotionWidget/viewModel/PromotionsWidgetViewModel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "promotionsWidgetListener", "Lcom/talabat/talabatcommon/views/promotionWidget/PromotionsWidgetView$PromotionsWidgetListener;", "failureHere", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getData", "tag", "", "module", "getLayoutId", "getViewModelClass", "Ljava/lang/Class;", "observatory", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onLifecycleOwnerAttached", "populateViews", "displayModel", "Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetDisplayModel;", "setListener", "listener", "startShimmer", "stopShimmer", "viewModelBuilder", "PromotionsWidgetListener", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PromotionsWidgetView extends MvvmLinearLayout<PromotionsWidgetViewModel> {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private PromotionsWidgetListener promotionsWidgetListener;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/promotionWidget/PromotionsWidgetView$PromotionsWidgetListener;", "", "onClicked", "", "id", "", "deeplink", "restaurantInfo", "onCloseClicked", "onFallback", "onLoaded", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface PromotionsWidgetListener {
        void onClicked(@NotNull String str, @NotNull String str2, @NotNull String str3);

        void onCloseClicked(@NotNull String str);

        void onFallback();

        void onLoaded(@NotNull String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromotionsWidgetView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void getData$default(PromotionsWidgetView promotionsWidgetView, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        if ((i11 & 2) != 0) {
            str2 = "";
        }
        promotionsWidgetView.getData(str, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: observatory$lambda-2  reason: not valid java name */
    public static final void m5768observatory$lambda2(PromotionsWidgetView promotionsWidgetView, PromotionsWidgetDisplayModel promotionsWidgetDisplayModel) {
        PromotionsWidgetListener promotionsWidgetListener2;
        Intrinsics.checkNotNullParameter(promotionsWidgetView, "this$0");
        if (promotionsWidgetDisplayModel != null) {
            if (promotionsWidgetDisplayModel.getWidgetInfo() != null) {
                promotionsWidgetView.stopShimmer();
                promotionsWidgetView.populateViews(promotionsWidgetDisplayModel);
            } else {
                promotionsWidgetView.stopShimmer();
                PromotionsWidgetListener promotionsWidgetListener3 = promotionsWidgetView.promotionsWidgetListener;
                if (promotionsWidgetListener3 != null) {
                    promotionsWidgetListener3.onFallback();
                }
            }
            Object vendorInfo = promotionsWidgetDisplayModel.getVendorInfo();
            if (vendorInfo != null && (promotionsWidgetListener2 = promotionsWidgetView.promotionsWidgetListener) != null) {
                promotionsWidgetListener2.onLoaded(((PromotionsWidgetViewModel) promotionsWidgetView.getViewModel()).getRawRestaurant(vendorInfo));
            }
        }
    }

    private final void populateViews(PromotionsWidgetDisplayModel promotionsWidgetDisplayModel) {
        WidgetInfo widgetInfo = promotionsWidgetDisplayModel.getWidgetInfo();
        if (widgetInfo != null) {
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.promotion_logo);
            Intrinsics.checkNotNullExpressionValue(imageView, "promotion_logo");
            ImageViewForTalabatKt.setImageResizeUrl$default(imageView, widgetInfo.getLogo(), 0, 0, false, 14, (Object) null);
            ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.promo_img);
            Intrinsics.checkNotNullExpressionValue(imageView2, "promo_img");
            ImageViewForTalabatKt.setImageResizeUrl$default(imageView2, widgetInfo.getImgUrl(), 0, 0, false, 14, (Object) null);
            ((AppCompatTextView) _$_findCachedViewById(R.id.promo_title)).setText(widgetInfo.getHeadline());
            ((AppCompatTextView) _$_findCachedViewById(R.id.promo_body)).setText(widgetInfo.getTagLine());
            ((AppCompatTextView) _$_findCachedViewById(R.id.promo_view)).setText(widgetInfo.getBtnTitle());
            ((ConstraintLayout) _$_findCachedViewById(R.id.promoWidget)).setOnClickListener(new a(this, widgetInfo, promotionsWidgetDisplayModel));
            ((ImageView) _$_findCachedViewById(R.id.btn_promo_close)).setOnClickListener(new b(this, promotionsWidgetDisplayModel));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: populateViews$lambda-5$lambda-3  reason: not valid java name */
    public static final void m5769populateViews$lambda5$lambda3(PromotionsWidgetView promotionsWidgetView, WidgetInfo widgetInfo, PromotionsWidgetDisplayModel promotionsWidgetDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(promotionsWidgetView, "this$0");
        Intrinsics.checkNotNullParameter(widgetInfo, "$info");
        Intrinsics.checkNotNullParameter(promotionsWidgetDisplayModel, "$displayModel");
        PromotionsWidgetListener promotionsWidgetListener2 = promotionsWidgetView.promotionsWidgetListener;
        if (promotionsWidgetListener2 != null) {
            promotionsWidgetListener2.onClicked(widgetInfo.getCampaignId(), widgetInfo.getDeeplink(), ((PromotionsWidgetViewModel) promotionsWidgetView.getViewModel()).getRawRestaurant(promotionsWidgetDisplayModel.getVendorInfo()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: populateViews$lambda-5$lambda-4  reason: not valid java name */
    public static final void m5770populateViews$lambda5$lambda4(PromotionsWidgetView promotionsWidgetView, PromotionsWidgetDisplayModel promotionsWidgetDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(promotionsWidgetView, "this$0");
        Intrinsics.checkNotNullParameter(promotionsWidgetDisplayModel, "$displayModel");
        PromotionsWidgetListener promotionsWidgetListener2 = promotionsWidgetView.promotionsWidgetListener;
        if (promotionsWidgetListener2 != null) {
            promotionsWidgetListener2.onCloseClicked(((PromotionsWidgetViewModel) promotionsWidgetView.getViewModel()).getRawRestaurant(promotionsWidgetDisplayModel.getVendorInfo()));
        }
    }

    private final void startShimmer() {
        int i11 = R.id.promoWidgetShimmerLayout;
        ((ShimmerLayout) _$_findCachedViewById(i11)).startShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(i11)).setVisibility(0);
        ((ConstraintLayout) _$_findCachedViewById(R.id.promoWidget)).setVisibility(8);
    }

    private final void stopShimmer() {
        int i11 = R.id.promoWidgetShimmerLayout;
        ((ShimmerLayout) _$_findCachedViewById(i11)).stopShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(i11)).setVisibility(8);
        ((ConstraintLayout) _$_findCachedViewById(R.id.promoWidget)).setVisibility(0);
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

    public void failureHere(@Nullable Failure failure) {
        setVisibility(8);
        PromotionsWidgetListener promotionsWidgetListener2 = this.promotionsWidgetListener;
        if (promotionsWidgetListener2 != null) {
            promotionsWidgetListener2.onFallback();
        }
    }

    public final void getData(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "module");
        startShimmer();
        ((PromotionsWidgetViewModel) getViewModel()).getPromotionData(str, str2);
    }

    public int getLayoutId(@Nullable AttributeSet attributeSet) {
        return R.layout.layout_promotions_widget;
    }

    @NotNull
    public Class<PromotionsWidgetViewModel> getViewModelClass() {
        return PromotionsWidgetViewModel.class;
    }

    public void observatory(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        ((PromotionsWidgetViewModel) getViewModel()).getDisplayModel().observe(lifecycleOwner, new c(this));
        LifecycleKt.failure(lifecycleOwner, ((PromotionsWidgetViewModel) getViewModel()).getFailureData(), new PromotionsWidgetView$observatory$2(this));
    }

    public void onLifecycleOwnerAttached(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        observatory(lifecycleOwner);
    }

    public final void setListener(@NotNull PromotionsWidgetListener promotionsWidgetListener2) {
        Intrinsics.checkNotNullParameter(promotionsWidgetListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.promotionsWidgetListener = promotionsWidgetListener2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromotionsWidgetView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public PromotionsWidgetViewModel viewModelBuilder() {
        PromotionsWidgetViewModelBuilder.Companion companion = PromotionsWidgetViewModelBuilder.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return companion.getMyViewModel(context, getCoroutineScope());
    }
}
