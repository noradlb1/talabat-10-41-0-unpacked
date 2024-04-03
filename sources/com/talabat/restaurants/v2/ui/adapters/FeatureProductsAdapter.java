package com.talabat.restaurants.v2.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.restaurants.v2.ui.adapters.viewholders.FeatureProductItemViewHolder;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/restaurants/v2/ui/adapters/FeatureProductsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductItemViewHolder;", "featureProducts", "", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "onFeatureProductClick", "Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductItemViewHolder$OnFeatureProductClick;", "(Ljava/util/List;Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductItemViewHolder$OnFeatureProductClick;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureProductsAdapter extends RecyclerView.Adapter<FeatureProductItemViewHolder> {
    @NotNull
    private final List<FeatureProductDisplayModel> featureProducts;
    @Nullable
    private final FeatureProductItemViewHolder.OnFeatureProductClick onFeatureProductClick;

    public FeatureProductsAdapter(@NotNull List<FeatureProductDisplayModel> list, @Nullable FeatureProductItemViewHolder.OnFeatureProductClick onFeatureProductClick2) {
        Intrinsics.checkNotNullParameter(list, "featureProducts");
        this.featureProducts = list;
        this.onFeatureProductClick = onFeatureProductClick2;
    }

    public int getItemCount() {
        return this.featureProducts.size();
    }

    public void onBindViewHolder(@NotNull FeatureProductItemViewHolder featureProductItemViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(featureProductItemViewHolder, "holder");
        featureProductItemViewHolder.bind(this.featureProducts.get(i11), i11, this.featureProducts.size());
    }

    @NotNull
    public FeatureProductItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_feature_product, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new FeatureProductItemViewHolder(inflate, this.onFeatureProductClick);
    }
}
