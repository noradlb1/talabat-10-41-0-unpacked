package com.talabat.darkstores.feature.home.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.rd.PageIndicatorView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.data.tracking.impression.TrackingData;
import com.talabat.darkstores.model.Banner;
import com.talabat.talabatcommon.extentions.StringUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0010H\u0014J\b\u0010\u0017\u001a\u00020\u0010H\u0014J\u0006\u0010\u0018\u001a\u00020\u0010JB\u0010\u0019\u001a\u00020\u00102:\u0010\u001a\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\nj\u0002`\u0011J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dJX\u0010\u001e\u001a\u00020\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0 2:\u0010!\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\nj\u0002`\u00112\u0006\u0010\"\u001a\u00020\u001dJ\"\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&RF\u0010\t\u001a:\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nj\u0004\u0018\u0001`\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/talabat/darkstores/feature/home/banner/BannerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bannerShownListener", "Lkotlin/Function2;", "Lcom/talabat/darkstores/model/Banner;", "Lkotlin/ParameterName;", "name", "banner", "position", "", "Lcom/talabat/darkstores/feature/home/banner/BannerActionListener;", "impressionTracker", "Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "trackingData", "Lcom/talabat/darkstores/data/tracking/impression/TrackingData;", "onAttachedToWindow", "onDetachedFromWindow", "onParentScrolled", "setOnBannerShownListener", "listener", "setTitle", "title", "", "setupAdapter", "bannersList", "", "clickListener", "bannerType", "setupImpressionTracking", "productImpressionTracker", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    /* access modifiers changed from: private */
    @Nullable
    public Function2<? super Banner, ? super Integer, Unit> bannerShownListener;
    @Nullable
    private ProductImpressionTracker impressionTracker;
    @Nullable
    private TrackingData trackingData;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.darkstores_banner_view, this);
        setOrientation(1);
        setVisibility(8);
    }

    public static /* synthetic */ void setupImpressionTracking$default(BannerView bannerView, ProductImpressionTracker productImpressionTracker, TrackingData trackingData2, LifecycleOwner lifecycleOwner, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            lifecycleOwner = null;
        }
        bannerView.setupImpressionTracking(productImpressionTracker, trackingData2, lifecycleOwner);
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

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((LoopingViewPager) _$_findCachedViewById(R.id.viewpager)).resumeAutoScroll();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((LoopingViewPager) _$_findCachedViewById(R.id.viewpager)).pauseAutoScroll();
    }

    public final void onParentScrolled() {
        ProductImpressionTracker productImpressionTracker = this.impressionTracker;
        if (productImpressionTracker != null) {
            productImpressionTracker.reCalculate();
        }
    }

    public final void setOnBannerShownListener(@NotNull Function2<? super Banner, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.bannerShownListener = function2;
    }

    public final void setTitle(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "title");
        int i11 = R.id.banner_title;
        ((TextView) _$_findCachedViewById(i11)).setText(str);
        TextView textView = (TextView) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(textView, "banner_title");
        int i12 = 0;
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            i12 = 8;
        }
        textView.setVisibility(i12);
    }

    public final void setupAdapter(@NotNull List<Banner> list, @NotNull Function2<? super Banner, ? super Integer, Unit> function2, @NotNull String str) {
        int i11;
        String str2;
        String str3;
        Function2<? super Banner, ? super Integer, Unit> function22;
        Intrinsics.checkNotNullParameter(list, "bannersList");
        Intrinsics.checkNotNullParameter(function2, "clickListener");
        Intrinsics.checkNotNullParameter(str, "bannerType");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        BannerPagerAdapter bannerPagerAdapter = new BannerPagerAdapter(context, list, true);
        bannerPagerAdapter.setOnBannerClickedListener(function2);
        if (!list.isEmpty()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        int i12 = R.id.viewpager;
        ((LoopingViewPager) _$_findCachedViewById(i12)).setAdapter(bannerPagerAdapter);
        ((LoopingViewPager) _$_findCachedViewById(i12)).setOffscreenPageLimit(2);
        ((LoopingViewPager) _$_findCachedViewById(i12)).reset();
        ((PageIndicatorView) _$_findCachedViewById(R.id.pageIndicatorView)).setCount(((LoopingViewPager) _$_findCachedViewById(i12)).getIndicatorCount());
        Banner banner = (Banner) CollectionsKt___CollectionsKt.firstOrNull(list);
        if (!(banner == null || (function22 = this.bannerShownListener) == null)) {
            function22.invoke(banner, 0);
        }
        ((LoopingViewPager) _$_findCachedViewById(i12)).setIndicatorPageChangeListener(new BannerView$setupAdapter$2(this, list));
        ProductImpressionTracker productImpressionTracker = this.impressionTracker;
        if (productImpressionTracker != null) {
            TrackingData trackingData2 = this.trackingData;
            if (trackingData2 == null || (str2 = trackingData2.getScreenName()) == null) {
                str2 = StringUtils.notAvailable(StringCompanionObject.INSTANCE);
            }
            TrackingData trackingData3 = this.trackingData;
            if (trackingData3 == null || (str3 = trackingData3.getEventOrigin()) == null) {
                str3 = StringUtils.notAvailable(StringCompanionObject.INSTANCE);
            }
            productImpressionTracker.updateBannerItems(list, str2, str3, str);
        }
    }

    public final void setupImpressionTracking(@NotNull ProductImpressionTracker productImpressionTracker, @NotNull TrackingData trackingData2, @Nullable LifecycleOwner lifecycleOwner) {
        ProductImpressionTracker productImpressionTracker2;
        Intrinsics.checkNotNullParameter(productImpressionTracker, "productImpressionTracker");
        Intrinsics.checkNotNullParameter(trackingData2, "trackingData");
        this.impressionTracker = productImpressionTracker;
        this.trackingData = trackingData2;
        if (lifecycleOwner == null) {
            LifecycleOwner findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(this);
            if (findViewTreeLifecycleOwner != null && (productImpressionTracker2 = this.impressionTracker) != null) {
                LoopingViewPager loopingViewPager = (LoopingViewPager) _$_findCachedViewById(R.id.viewpager);
                Intrinsics.checkNotNullExpressionValue(loopingViewPager, "viewpager");
                productImpressionTracker2.register(loopingViewPager, findViewTreeLifecycleOwner);
            }
        } else if (productImpressionTracker != null) {
            LoopingViewPager loopingViewPager2 = (LoopingViewPager) _$_findCachedViewById(R.id.viewpager);
            Intrinsics.checkNotNullExpressionValue(loopingViewPager2, "viewpager");
            productImpressionTracker.register(loopingViewPager2, lifecycleOwner);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BannerView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
