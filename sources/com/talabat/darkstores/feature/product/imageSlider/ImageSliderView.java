package com.talabat.darkstores.feature.product.imageSlider;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.rd.PageIndicatorView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.extensions.ContextExtensionsKt;
import com.talabat.darkstores.feature.home.banner.LoopingViewPager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\fH\u0014J&\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/feature/product/imageSlider/ImageSliderView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/talabat/darkstores/feature/product/imageSlider/ImageSliderPagerAdapter;", "onAttachedToWindow", "", "onDetachedFromWindow", "onFinishInflate", "setItemsList", "imagesList", "", "", "zoomEnabled", "", "showTextIndicator", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageSliderView extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final ImageSliderPagerAdapter adapter;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ImageSliderView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ImageSliderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ImageSliderView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.adapter = new ImageSliderPagerAdapter(context, CollectionsKt__CollectionsKt.emptyList(), true);
        View.inflate(context, R.layout.layout_darkstores_image_slider, this);
        ((FrameLayout) _$_findCachedViewById(R.id.viewPagerContainer)).setForeground(new ColorDrawable(ContextExtensionsKt.getColorCompat(context, R.color.darkstoresProductTileOverlay)));
    }

    public static /* synthetic */ void setItemsList$default(ImageSliderView imageSliderView, List list, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        imageSliderView.setItemsList(list, z11, z12);
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

    public void onFinishInflate() {
        super.onFinishInflate();
        ((LoopingViewPager) _$_findCachedViewById(R.id.viewpager)).setAdapter(this.adapter);
    }

    public final void setItemsList(@NotNull List<String> list, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(list, "imagesList");
        this.adapter.isZoomEnabled(z11);
        this.adapter.setItemList(list);
        int i11 = R.id.viewpager;
        ((LoopingViewPager) _$_findCachedViewById(i11)).setOffscreenPageLimit(2);
        ((LoopingViewPager) _$_findCachedViewById(i11)).reset();
        if (z12) {
            int indicatorCount = ((LoopingViewPager) _$_findCachedViewById(i11)).getIndicatorCount();
            ((TextView) _$_findCachedViewById(R.id.pageNumberText)).setText("1/" + indicatorCount);
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.bottomContainer);
            Intrinsics.checkNotNullExpressionValue(frameLayout, "bottomContainer");
            frameLayout.setVisibility(0);
            PageIndicatorView pageIndicatorView = (PageIndicatorView) _$_findCachedViewById(R.id.pageIndicatorView);
            Intrinsics.checkNotNullExpressionValue(pageIndicatorView, "pageIndicatorView");
            pageIndicatorView.setVisibility(8);
        } else {
            int i12 = R.id.pageIndicatorView;
            ((PageIndicatorView) _$_findCachedViewById(i12)).setCount(((LoopingViewPager) _$_findCachedViewById(i11)).getIndicatorCount());
            FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(R.id.bottomContainer);
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "bottomContainer");
            frameLayout2.setVisibility(8);
            PageIndicatorView pageIndicatorView2 = (PageIndicatorView) _$_findCachedViewById(i12);
            Intrinsics.checkNotNullExpressionValue(pageIndicatorView2, "pageIndicatorView");
            pageIndicatorView2.setVisibility(0);
        }
        ((LoopingViewPager) _$_findCachedViewById(i11)).setIndicatorPageChangeListener(new ImageSliderView$setItemsList$1(z12, this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageSliderView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
