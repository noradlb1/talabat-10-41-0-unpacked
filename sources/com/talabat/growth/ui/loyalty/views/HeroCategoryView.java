package com.talabat.growth.ui.loyalty.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.growth.databinding.ViewHeroCardBurnCategoryBinding;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/talabat/growth/ui/loyalty/views/HeroCategoryView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/growth/databinding/ViewHeroCardBurnCategoryBinding;", "value", "Landroid/view/View$OnClickListener;", "viewAllOnClickListener", "getViewAllOnClickListener", "()Landroid/view/View$OnClickListener;", "setViewAllOnClickListener", "(Landroid/view/View$OnClickListener;)V", "populate", "", "model", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeroCategoryView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final ViewHeroCardBurnCategoryBinding binding;
    @Nullable
    private View.OnClickListener viewAllOnClickListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HeroCategoryView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HeroCategoryView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HeroCategoryView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        ViewHeroCardBurnCategoryBinding inflate = ViewHeroCardBurnCategoryBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…           true\n        )");
        this.binding = inflate;
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

    @Nullable
    public final View.OnClickListener getViewAllOnClickListener() {
        return this.viewAllOnClickListener;
    }

    public final void populate(@NotNull BurnItemCategoryDisplayModel burnItemCategoryDisplayModel) {
        Intrinsics.checkNotNullParameter(burnItemCategoryDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        ViewHeroCardBurnCategoryBinding viewHeroCardBurnCategoryBinding = this.binding;
        viewHeroCardBurnCategoryBinding.categoryHeroImageView.setImageUrl(burnItemCategoryDisplayModel.getImageURL());
        viewHeroCardBurnCategoryBinding.categoryHeroTitleTextView.setText(burnItemCategoryDisplayModel.getCategoryName());
        viewHeroCardBurnCategoryBinding.categoryHeroPointTextView.setText(burnItemCategoryDisplayModel.getSubtitle().toString());
    }

    public final void setViewAllOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.viewAllOnClickListener = onClickListener;
        TextView textView = this.binding.categoryHeroViewAllTextView;
        textView.setVisibility(0);
        textView.setOnClickListener(this.viewAllOnClickListener);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeroCategoryView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
