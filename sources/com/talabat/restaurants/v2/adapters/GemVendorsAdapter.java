package com.talabat.restaurants.v2.adapters;

import JsonModels.Response.GEMResponse.GemAdapterRestaurant;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.restaurants.v2.adapters.viewholders.VendorViewHolder;
import datamodels.Restaurant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/restaurants/v2/adapters/GemVendorsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/restaurants/v2/adapters/viewholders/VendorViewHolder;", "vendors", "", "LJsonModels/Response/GEMResponse/GemAdapterRestaurant;", "mListener", "Lcom/talabat/geminterfaces/OnGemAlertDialogClickListener;", "(Ljava/util/List;Lcom/talabat/geminterfaces/OnGemAlertDialogClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemVendorsAdapter extends RecyclerView.Adapter<VendorViewHolder> {
    @NotNull
    private final OnGemAlertDialogClickListener mListener;
    @NotNull
    private final List<GemAdapterRestaurant> vendors;

    public GemVendorsAdapter(@NotNull List<? extends GemAdapterRestaurant> list, @NotNull OnGemAlertDialogClickListener onGemAlertDialogClickListener) {
        Intrinsics.checkNotNullParameter(list, "vendors");
        Intrinsics.checkNotNullParameter(onGemAlertDialogClickListener, "mListener");
        this.vendors = list;
        this.mListener = onGemAlertDialogClickListener;
    }

    public int getItemCount() {
        return this.vendors.size();
    }

    public void onBindViewHolder(@NotNull VendorViewHolder vendorViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(vendorViewHolder, "holder");
        Restaurant restaurant = this.vendors.get(i11).restaurant;
        Intrinsics.checkNotNullExpressionValue(restaurant, "vendors[position].restaurant");
        vendorViewHolder.bind(restaurant);
    }

    @NotNull
    public VendorViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gem_restaurants, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new VendorViewHolder(inflate, this.mListener);
    }
}
