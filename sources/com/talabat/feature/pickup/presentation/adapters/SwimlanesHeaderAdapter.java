package com.talabat.feature.pickup.presentation.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.feature.pickup.data.events.swimlanes.SwimlanesTracking;
import com.talabat.feature.pickup.presentation.PickupViewModel;
import com.talabat.feature.pickup.presentation.R;
import com.talabat.feature.pickup.presentation.SwimlanesRvItemDecorator;
import com.talabat.feature.pickup.presentation.entity.SwimlaneHeaderView;
import com.talabat.feature.pickup.presentation.entity.SwimlaneView;
import com.talabat.talabatcommon.extension.ViewKt;
import datamodels.Restaurant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/pickup/presentation/adapters/SwimlanesHeaderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/feature/pickup/presentation/adapters/SwimlanesHeaderAdapter$ViewHolder;", "headerView", "Lcom/talabat/feature/pickup/presentation/entity/SwimlaneHeaderView;", "viewModel", "Lcom/talabat/feature/pickup/presentation/PickupViewModel;", "onVendorClick", "Lkotlin/Function2;", "Ldatamodels/Restaurant;", "Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "", "(Lcom/talabat/feature/pickup/presentation/entity/SwimlaneHeaderView;Lcom/talabat/feature/pickup/presentation/PickupViewModel;Lkotlin/jvm/functions/Function2;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesHeaderAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NotNull
    private final SwimlaneHeaderView headerView;
    @NotNull
    private final Function2<Restaurant, SwimlanesTracking, Unit> onVendorClick;
    @NotNull
    private final PickupViewModel viewModel;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/pickup/presentation/adapters/SwimlanesHeaderAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "items", "", "Lcom/talabat/feature/pickup/presentation/entity/SwimlaneView;", "viewModel", "Lcom/talabat/feature/pickup/presentation/PickupViewModel;", "tracking", "Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "onVendorClick", "Lkotlin/Function2;", "Ldatamodels/Restaurant;", "", "(Landroid/view/View;Ljava/util/List;Lcom/talabat/feature/pickup/presentation/PickupViewModel;Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;Lkotlin/jvm/functions/Function2;)V", "headerTv", "Landroid/widget/TextView;", "getHeaderTv", "()Landroid/widget/TextView;", "subHeaderTv", "getSubHeaderTv", "swimlanesRv", "Landroidx/recyclerview/widget/RecyclerView;", "getSwimlanesRv", "()Landroidx/recyclerview/widget/RecyclerView;", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final TextView headerTv;
        @NotNull
        private final TextView subHeaderTv;
        @NotNull
        private final RecyclerView swimlanesRv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view, @NotNull List<SwimlaneView> list, @NotNull PickupViewModel pickupViewModel, @NotNull final SwimlanesTracking swimlanesTracking, @NotNull final Function2<? super Restaurant, ? super SwimlanesTracking, Unit> function2) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
            Intrinsics.checkNotNullParameter(pickupViewModel, "viewModel");
            Intrinsics.checkNotNullParameter(swimlanesTracking, "tracking");
            Intrinsics.checkNotNullParameter(function2, "onVendorClick");
            View findViewById = view.findViewById(R.id.headerTv);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.headerTv)");
            this.headerTv = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.subHeaderTv);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.subHeaderTv)");
            this.subHeaderTv = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.swimlanesRv);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.swimlanesRv)");
            RecyclerView recyclerView = (RecyclerView) findViewById3;
            this.swimlanesRv = recyclerView;
            recyclerView.addItemDecoration(new SwimlanesRvItemDecorator());
            recyclerView.setAdapter(new SwimlanesAdapter(list, new Function1<SwimlaneView, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SwimlaneView) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull SwimlaneView swimlaneView) {
                    Intrinsics.checkNotNullParameter(swimlaneView, "it");
                    swimlanesTracking.setVendorId(Integer.valueOf(swimlaneView.getVendor().f13872id));
                    swimlanesTracking.setBranchId(Integer.valueOf(swimlaneView.getVendor().branchId));
                    function2.invoke(swimlaneView.getVendor(), swimlanesTracking);
                }
            }));
            recyclerView.addOnScrollListener(new SwimlanesScrollListener(swimlanesTracking, pickupViewModel));
        }

        @NotNull
        public final TextView getHeaderTv() {
            return this.headerTv;
        }

        @NotNull
        public final TextView getSubHeaderTv() {
            return this.subHeaderTv;
        }

        @NotNull
        public final RecyclerView getSwimlanesRv() {
            return this.swimlanesRv;
        }
    }

    public SwimlanesHeaderAdapter(@NotNull SwimlaneHeaderView swimlaneHeaderView, @NotNull PickupViewModel pickupViewModel, @NotNull Function2<? super Restaurant, ? super SwimlanesTracking, Unit> function2) {
        Intrinsics.checkNotNullParameter(swimlaneHeaderView, "headerView");
        Intrinsics.checkNotNullParameter(pickupViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(function2, "onVendorClick");
        this.headerView = swimlaneHeaderView;
        this.viewModel = pickupViewModel;
        this.onVendorClick = function2;
    }

    public int getItemCount() {
        return 1;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        viewHolder.getHeaderTv().setText(this.headerView.getTitle());
        viewHolder.getSubHeaderTv().setText(this.headerView.getSubTitle());
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new ViewHolder(ViewKt.inflate(viewGroup, R.layout.single_swimlanes_header_view), this.headerView.getItems(), this.viewModel, this.headerView.getTracking(), this.onVendorClick);
    }
}
