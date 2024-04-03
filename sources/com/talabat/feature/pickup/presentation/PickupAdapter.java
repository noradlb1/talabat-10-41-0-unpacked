package com.talabat.feature.pickup.presentation;

import android.view.ViewGroup;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\"\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/pickup/presentation/PickupAdapter;", "Landroidx/paging/PagingDataAdapter;", "Ldatamodels/Restaurant;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onVendorClickListener", "Lkotlin/Function2;", "", "", "(Lkotlin/jvm/functions/Function2;)V", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "Lcom/talabat/collectiondetails/ui/restaurantlist/FreshRestaurantUiViewHolderExperiment;", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupAdapter extends PagingDataAdapter<Restaurant, RecyclerView.ViewHolder> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final PickupAdapter$Companion$PICKUP_COMPARATOR$1 PICKUP_COMPARATOR = new PickupAdapter$Companion$PICKUP_COMPARATOR$1();
    @NotNull
    private final Function2<Restaurant, Integer, Unit> onVendorClickListener;

    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/pickup/presentation/PickupAdapter$Companion;", "", "()V", "PICKUP_COMPARATOR", "com/talabat/feature/pickup/presentation/PickupAdapter$Companion$PICKUP_COMPARATOR$1", "Lcom/talabat/feature/pickup/presentation/PickupAdapter$Companion$PICKUP_COMPARATOR$1;", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PickupAdapter(@NotNull Function2<? super Restaurant, ? super Integer, Unit> function2) {
        super(PICKUP_COMPARATOR, (CoroutineDispatcher) null, (CoroutineDispatcher) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(function2, "onVendorClickListener");
        this.onVendorClickListener = function2;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment = (FreshRestaurantUiViewHolderExperiment) viewHolder;
        Restaurant restaurant = (Restaurant) getItem(i11);
        if (restaurant != null) {
            FreshRestaurantUiViewHolderExperiment.bind$default(freshRestaurantUiViewHolderExperiment, restaurant, i11, this.onVendorClickListener, (String) null, 8, (Object) null);
        }
    }

    @NotNull
    public FreshRestaurantUiViewHolderExperiment onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return FreshRestaurantUiViewHolderExperiment.Companion.getInstance$default(FreshRestaurantUiViewHolderExperiment.Companion, viewGroup, false, 2, (Object) null);
    }
}
