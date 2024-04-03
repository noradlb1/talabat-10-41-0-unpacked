package com.talabat.darkstores.feature.home.categories;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.load.Transformation;
import com.designsystem.marshmallow.R;
import com.google.android.material.card.MaterialCardView;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.common.bindingAdapters.ResizeStrategy;
import com.talabat.darkstores.data.discovery.model.ImageUrl;
import com.talabat.darkstores.databinding.CategoriesMissionItemViewBinding;
import com.talabat.darkstores.model.Category;
import fj.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJR\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072:\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\f0\u0011j\u0002`\u0015R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/feature/home/categories/CategoriesMissionItemView;", "Lcom/google/android/material/card/MaterialCardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/darkstores/databinding/CategoriesMissionItemViewBinding;", "setContent", "", "category", "Lcom/talabat/darkstores/model/Category;", "position", "onCategoryClicked", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "Lcom/talabat/darkstores/feature/home/OnCategoryClicked;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoriesMissionItemView extends MaterialCardView {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final CategoriesMissionItemViewBinding binding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CategoriesMissionItemView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CategoriesMissionItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CategoriesMissionItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        CategoriesMissionItemViewBinding inflate = CategoriesMissionItemViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
        setCardElevation(0.0f);
        setRadius(getResources().getDimension(R.dimen.ds_xs));
    }

    /* access modifiers changed from: private */
    /* renamed from: setContent$lambda-0  reason: not valid java name */
    public static final void m9976setContent$lambda0(Function2 function2, Category category, int i11, View view) {
        Intrinsics.checkNotNullParameter(function2, "$onCategoryClicked");
        Intrinsics.checkNotNullParameter(category, "$category");
        function2.invoke(category, Integer.valueOf(i11));
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

    public final void setContent(@NotNull Category category, int i11, @NotNull Function2<? super Category, ? super Integer, Unit> function2) {
        String str;
        ImageUrl imageUrl;
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(function2, "onCategoryClicked");
        this.binding.title.setText(category.getName());
        AppCompatImageView appCompatImageView = this.binding.image;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.image");
        List<ImageUrl> imageUrls = category.getImageUrls();
        if (imageUrls == null || (imageUrl = (ImageUrl) CollectionsKt___CollectionsKt.firstOrNull(imageUrls)) == null) {
            str = null;
        } else {
            str = imageUrl.getUrl();
        }
        BindingAdaptersKt.loadImageWithGlide$default(appCompatImageView, str, (Integer) null, (ResizeStrategy) null, (Transformation) null, (Integer) null, 28, (Object) null);
        this.binding.containerView.setOnClickListener(new a(function2, category, i11));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoriesMissionItemView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
