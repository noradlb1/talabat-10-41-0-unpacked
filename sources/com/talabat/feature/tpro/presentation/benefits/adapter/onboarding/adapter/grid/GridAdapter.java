package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.adapter.grid;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.tpro.presentation.databinding.ItemImageBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/adapter/grid/GridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/adapter/grid/ImageViewHolder;", "listOfUrls", "", "", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GridAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    @NotNull
    private final List<String> listOfUrls;

    public GridAdapter(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "listOfUrls");
        this.listOfUrls = list;
    }

    public int getItemCount() {
        return this.listOfUrls.size();
    }

    public void onBindViewHolder(@NotNull ImageViewHolder imageViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(imageViewHolder, "holder");
        imageViewHolder.bind(this.listOfUrls.get(i11));
    }

    @NotNull
    public ImageViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemImageBinding inflate = ItemImageBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …      false\n            )");
        return new ImageViewHolder(inflate);
    }
}
