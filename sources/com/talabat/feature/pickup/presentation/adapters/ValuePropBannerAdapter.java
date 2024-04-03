package com.talabat.feature.pickup.presentation.adapters;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.pickup.presentation.R;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/pickup/presentation/adapters/ValuePropBannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/feature/pickup/presentation/adapters/BannerViewHolder;", "onLearnMoreClicked", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "title", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateTitle", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ValuePropBannerAdapter extends RecyclerView.Adapter<BannerViewHolder> {
    @NotNull
    private final Function0<Unit> onLearnMoreClicked;
    @Nullable
    private String title;

    public ValuePropBannerAdapter(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onLearnMoreClicked");
        this.onLearnMoreClicked = function0;
    }

    public int getItemCount() {
        return 1;
    }

    public final void updateTitle(@Nullable String str) {
        this.title = str;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull BannerViewHolder bannerViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(bannerViewHolder, "holder");
        String str = this.title;
        if (!(str == null || str.length() == 0)) {
            bannerViewHolder.getBannerTitleTv().setText(this.title);
        }
    }

    @NotNull
    public BannerViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new BannerViewHolder(ViewKt.inflate(viewGroup, R.layout.header_value_prop_banner), this.onLearnMoreClicked);
    }
}
