package com.talabat.talabatlife.ui.vendorList.views;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nw.f;
import nw.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u001f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u001c\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016J\u001c\u0010$\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/views/VendorsListAdaptor;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorsListViewHolder;", "loyaltyEnabled", "", "vendors", "", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "(ZLjava/util/List;)V", "currentArea", "", "getCurrentArea", "()Ljava/lang/String;", "setCurrentArea", "(Ljava/lang/String;)V", "vendorClickListener", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorsListAdaptor$VendorsItemClickListener;", "getVendorClickListener", "()Lcom/talabat/talabatlife/ui/vendorList/views/VendorsListAdaptor$VendorsItemClickListener;", "setVendorClickListener", "(Lcom/talabat/talabatlife/ui/vendorList/views/VendorsListAdaptor$VendorsItemClickListener;)V", "addToVendorsItems", "", "items", "bindLoyaltyView", "holder", "bindVendorView", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateVendorList", "VendorsItemClickListener", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListAdaptor extends RecyclerView.Adapter<VendorsListViewHolder> {
    @NotNull
    private String currentArea;
    private boolean loyaltyEnabled;
    @Nullable
    private VendorsItemClickListener vendorClickListener;
    @NotNull
    private List<VendorDisplayModel> vendors;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/views/VendorsListAdaptor$VendorsItemClickListener;", "", "onLoyaltyViewClicked", "", "onVendorClicked", "model", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface VendorsItemClickListener {
        void onLoyaltyViewClicked();

        void onVendorClicked(@NotNull VendorDisplayModel vendorDisplayModel);
    }

    public VendorsListAdaptor() {
        this(false, (List) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorsListAdaptor(boolean z11, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? new ArrayList() : list);
    }

    private final void bindLoyaltyView(VendorsListViewHolder vendorsListViewHolder) {
        VendorDisplayModel vendorDisplayModel = r0;
        VendorDisplayModel vendorDisplayModel2 = new VendorDisplayModel(0, (String) null, (String) null, (String) null, (String) null, 0, 0.0d, (String) null, (String) null, 0.0f, (List) null, false, false, (String) null, 16383, (DefaultConstructorMarker) null);
        vendorsListViewHolder.populate(vendorDisplayModel, new g(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindLoyaltyView$lambda-3$lambda-2  reason: not valid java name */
    public static final void m5860bindLoyaltyView$lambda3$lambda2(VendorsListAdaptor vendorsListAdaptor, View view) {
        Intrinsics.checkNotNullParameter(vendorsListAdaptor, "this$0");
        VendorsItemClickListener vendorsItemClickListener = vendorsListAdaptor.vendorClickListener;
        if (vendorsItemClickListener != null) {
            vendorsItemClickListener.onLoyaltyViewClicked();
        }
    }

    private final void bindVendorView(VendorsListViewHolder vendorsListViewHolder) {
        int i11;
        if (this.loyaltyEnabled) {
            i11 = vendorsListViewHolder.getAdapterPosition() - 1;
        } else {
            i11 = vendorsListViewHolder.getAdapterPosition();
        }
        vendorsListViewHolder.populate(this.vendors.get(i11), new f(this, i11));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindVendorView$lambda-1$lambda-0  reason: not valid java name */
    public static final void m5861bindVendorView$lambda1$lambda0(VendorsListAdaptor vendorsListAdaptor, int i11, View view) {
        Intrinsics.checkNotNullParameter(vendorsListAdaptor, "this$0");
        VendorsItemClickListener vendorsItemClickListener = vendorsListAdaptor.vendorClickListener;
        if (vendorsItemClickListener != null) {
            vendorsItemClickListener.onVendorClicked(vendorsListAdaptor.vendors.get(i11));
        }
    }

    public final void addToVendorsItems(@NotNull List<VendorDisplayModel> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(str, "currentArea");
        this.currentArea = str;
        int size = this.vendors.size();
        int size2 = list.size();
        this.vendors.addAll(list);
        notifyItemRangeChanged(size, size2);
    }

    @NotNull
    public final String getCurrentArea() {
        return this.currentArea;
    }

    public int getItemCount() {
        return this.loyaltyEnabled ? this.vendors.size() + 1 : this.vendors.size();
    }

    public int getItemViewType(int i11) {
        if (this.loyaltyEnabled && i11 == 0) {
            return 1;
        }
        if (this.vendors.get(i11).getViewTypeIsVendor()) {
            return 2;
        }
        return 3;
    }

    @Nullable
    public final VendorsItemClickListener getVendorClickListener() {
        return this.vendorClickListener;
    }

    public final void setCurrentArea(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentArea = str;
    }

    public final void setVendorClickListener(@Nullable VendorsItemClickListener vendorsItemClickListener) {
        this.vendorClickListener = vendorsItemClickListener;
    }

    public final void updateVendorList(@NotNull List<VendorDisplayModel> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(str, "currentArea");
        this.currentArea = str;
        this.vendors = list;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull VendorsListViewHolder vendorsListViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(vendorsListViewHolder, "holder");
        if (this.loyaltyEnabled && i11 == 0) {
            bindLoyaltyView(vendorsListViewHolder);
        } else if (getItemViewType(i11) == 3) {
            vendorsListViewHolder.populate(this.currentArea);
        } else {
            bindVendorView(vendorsListViewHolder);
        }
    }

    @NotNull
    public VendorsListViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == 1) {
            return new LoyaltyViewHolder(viewGroup);
        }
        if (i11 != 3) {
            return new VendorsListViewHolderImpl(viewGroup);
        }
        return new VendorListViewHolderOutSideArea(viewGroup);
    }

    public VendorsListAdaptor(boolean z11, @NotNull List<VendorDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "vendors");
        this.loyaltyEnabled = z11;
        this.vendors = list;
        this.currentArea = "";
    }
}
