package com.talabat.darkstores.feature.product.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.designsystem.marshmallow.R;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lj.j;
import lj.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/ProductTagsContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "areTagsExpended", "", "setProductTags", "", "productTags", "", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$Tag;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductTagsContainer extends ConstraintLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    private boolean areTagsExpended;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProductTagsContainer(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProductTagsContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProductTagsContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* access modifiers changed from: private */
    /* renamed from: setProductTags$lambda-3  reason: not valid java name */
    public static final void m10055setProductTags$lambda3(ProductTagsContainer productTagsContainer, List list, View view) {
        Intrinsics.checkNotNullParameter(productTagsContainer, "this$0");
        Intrinsics.checkNotNullParameter(list, "$productTags");
        productTagsContainer.areTagsExpended = !productTagsContainer.areTagsExpended;
        productTagsContainer.removeAllViews();
        productTagsContainer.setProductTags(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: setProductTags$lambda-4  reason: not valid java name */
    public static final void m10056setProductTags$lambda4(ProductTagsContainer productTagsContainer) {
        Intrinsics.checkNotNullParameter(productTagsContainer, "this$0");
        productTagsContainer.requestLayout();
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

    public final void setProductTags(@NotNull List<ProductExtendedInfo.Tag> list) {
        List<ProductExtendedInfo.Tag> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "productTags");
        Context context = getContext();
        if (context != null && (!list2.isEmpty())) {
            int i11 = getResources().getDisplayMetrics().widthPixels;
            TextPaint paint = new ProductTagView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null).getBinding().txtProductTag.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "ProductTagView(context).…nding.txtProductTag.paint");
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            TagsLayoutConfig tagsLayoutConfig = new TagsLayoutConfig(list2, i11, paint, resources);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds_xxs);
            Flow flow = new Flow(context);
            flow.setId(View.generateViewId());
            flow.setWrapMode(1);
            flow.setHorizontalStyle(2);
            flow.setHorizontalAlign(0);
            flow.setHorizontalBias(0.0f);
            flow.setVerticalGap(dimensionPixelOffset);
            flow.setHorizontalGap(dimensionPixelOffset);
            flow.setOrientation(0);
            flow.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
            addView(flow);
            List<ProductExtendedInfo.Tag> tags = tagsLayoutConfig.getTags(this.areTagsExpended);
            int[] iArr = new int[tags.size()];
            ProductTagView productTagView = null;
            int i12 = 0;
            for (Object next : tags) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Context context2 = context;
                Context context3 = context;
                ProductTagView productTagView2 = r3;
                ProductTagView productTagView3 = new ProductTagView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                productTagView2.setId(View.generateViewId());
                addView(productTagView2);
                productTagView2.setProductTag((ProductExtendedInfo.Tag) next);
                iArr[i12] = productTagView2.getId();
                productTagView = productTagView2;
                i12 = i13;
                context = context3;
            }
            if (tagsLayoutConfig.isExpendable()) {
                if (productTagView != null) {
                    productTagView.showAsMoreLessTag();
                }
                if (productTagView != null) {
                    productTagView.setOnClickListener(new j(this, list2));
                }
            }
            flow.setReferencedIds(iArr);
            post(new k(this));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductTagsContainer(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
