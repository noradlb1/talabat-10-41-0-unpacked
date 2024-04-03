package com.talabat.talabatlife.ui.redeemAndPay;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.FilterEngine;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.views.offers.PaymentOfferViewHolder;
import com.talabat.talabatlife.ui.vendorOffers.views.offers.VendorsOfferListAdaptor;
import iw.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\nH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/talabat/talabatlife/ui/redeemAndPay/PaymentOfferListAdaptor;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/talabatlife/ui/vendorOffers/views/offers/PaymentOfferViewHolder;", "offers", "", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel;", "(Ljava/util/List;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "selectedItemIndex", "", "vendorClickListener", "Lcom/talabat/talabatlife/ui/vendorOffers/views/offers/VendorsOfferListAdaptor$VendorOfferSelectedListener;", "getVendorClickListener", "()Lcom/talabat/talabatlife/ui/vendorOffers/views/offers/VendorsOfferListAdaptor$VendorOfferSelectedListener;", "setVendorClickListener", "(Lcom/talabat/talabatlife/ui/vendorOffers/views/offers/VendorsOfferListAdaptor$VendorOfferSelectedListener;)V", "getItemCount", "onAttachedToRecyclerView", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "preSelectItemIfNotSelectedYet", "setSelectedItemIndex", "value", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentOfferListAdaptor extends RecyclerView.Adapter<PaymentOfferViewHolder> {
    @NotNull
    private List<VendorOfferDisplayModel> offers;
    @Nullable
    private RecyclerView recyclerView;
    private int selectedItemIndex;
    @Nullable
    private VendorsOfferListAdaptor.VendorOfferSelectedListener vendorClickListener;

    public PaymentOfferListAdaptor() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentOfferListAdaptor(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new ArrayList() : list);
    }

    private final void preSelectItemIfNotSelectedYet() {
        int i11 = 0;
        while (this.selectedItemIndex == -1 && i11 < this.offers.size()) {
            if (this.offers.get(i11).isEnabled()) {
                setSelectedItemIndex(i11);
            }
            i11++;
        }
    }

    /* access modifiers changed from: private */
    public final void setSelectedItemIndex(int i11) {
        int i12;
        if (i11 != -1 && i11 != (i12 = this.selectedItemIndex)) {
            if (i12 != -1) {
                this.offers.get(i12).setSelected(!this.offers.get(this.selectedItemIndex).isSelected());
            }
            this.offers.get(i11).setSelected(!this.offers.get(i11).isSelected());
            VendorsOfferListAdaptor.VendorOfferSelectedListener vendorOfferSelectedListener = this.vendorClickListener;
            if (vendorOfferSelectedListener != null) {
                vendorOfferSelectedListener.onVendorSelected(this.offers.get(i11), i11);
            }
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.post(new a(this));
            }
            this.selectedItemIndex = i11;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setSelectedItemIndex$lambda-1  reason: not valid java name */
    public static final void m5838setSelectedItemIndex$lambda1(PaymentOfferListAdaptor paymentOfferListAdaptor) {
        Intrinsics.checkNotNullParameter(paymentOfferListAdaptor, "this$0");
        paymentOfferListAdaptor.notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.offers.size();
    }

    @Nullable
    public final VendorsOfferListAdaptor.VendorOfferSelectedListener getVendorClickListener() {
        return this.vendorClickListener;
    }

    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView2);
        this.recyclerView = recyclerView2;
    }

    public final void setVendorClickListener(@Nullable VendorsOfferListAdaptor.VendorOfferSelectedListener vendorOfferSelectedListener) {
        this.vendorClickListener = vendorOfferSelectedListener;
    }

    public void onBindViewHolder(@NotNull PaymentOfferViewHolder paymentOfferViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(paymentOfferViewHolder, "holder");
        if (this.offers.size() - 1 == i11) {
            preSelectItemIfNotSelectedYet();
        }
        paymentOfferViewHolder.populate(this.offers.get(i11), new PaymentOfferListAdaptor$onBindViewHolder$1$1(this, i11));
    }

    @NotNull
    public PaymentOfferViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new PaymentOfferViewHolder(viewGroup);
    }

    public PaymentOfferListAdaptor(@NotNull List<VendorOfferDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, FilterEngine.DEEPLINKFILER.OFFERS);
        this.offers = list;
        this.selectedItemIndex = -1;
    }
}
