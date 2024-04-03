package com.talabat.feature.tpro.presentation.benefits.adapter.carousel.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.tpro.presentation.benefits.adapter.carousel.viewholder.CarouselImageViewHolder;
import com.talabat.feature.tpro.presentation.databinding.ItemCarouselViewBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/carousel/adapter/CarouselAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/carousel/viewholder/CarouselImageViewHolder;", "()V", "listOfUrls", "", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "urlList", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CarouselAdapter extends RecyclerView.Adapter<CarouselImageViewHolder> {
    @NotNull
    private final List<String> listOfUrls = new ArrayList();

    public int getItemCount() {
        return this.listOfUrls.isEmpty() ? 0 : Integer.MAX_VALUE;
    }

    public final void updateData(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "urlList");
        this.listOfUrls.clear();
        this.listOfUrls.addAll(list);
    }

    public void onBindViewHolder(@NotNull CarouselImageViewHolder carouselImageViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(carouselImageViewHolder, "holder");
        List<String> list = this.listOfUrls;
        carouselImageViewHolder.bind(list.get(i11 % list.size()));
    }

    @NotNull
    public CarouselImageViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemCarouselViewBinding inflate = ItemCarouselViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …      false\n            )");
        return new CarouselImageViewHolder(inflate);
    }
}
