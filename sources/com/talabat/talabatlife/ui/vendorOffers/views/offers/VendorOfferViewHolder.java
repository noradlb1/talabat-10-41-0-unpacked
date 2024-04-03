package com.talabat.talabatlife.ui.vendorOffers.views.offers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.talabatcore.BaseViewHolder;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferDisplayModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qw.b;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nJ\f\u0010\u000b\u001a\u00020\u0007*\u00020\fH\u0002J$\u0010\r\u001a\u00020\u0007*\u00020\f2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/views/offers/VendorOfferViewHolder;", "Lcom/talabat/talabatcore/BaseViewHolder;", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "populate", "", "model", "clickListener", "Lkotlin/Function0;", "setItemDisabled", "Landroid/view/View;", "setItemEnabled", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorOfferViewHolder extends BaseViewHolder<VendorOfferDisplayModel> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorOfferViewHolder(@NotNull ViewGroup viewGroup) {
        super(viewGroup, R.layout.view_holder_vendor_offer);
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    private final void setItemDisabled(View view) {
        ((ImageView) view.findViewById(R.id.vendorOfferIconImageView)).setAlpha(0.4f);
        ((TextView) view.findViewById(R.id.vendorOfferTitleTextView)).setAlpha(0.4f);
        ((LinearLayout) view.findViewById(R.id.vendorOfferSubTitle)).setAlpha(0.4f);
    }

    private final void setItemEnabled(View view, Function0<Unit> function0, VendorOfferDisplayModel vendorOfferDisplayModel) {
        this.itemView.setOnClickListener(new b(function0));
        view.setSelected(vendorOfferDisplayModel.isSelected());
    }

    /* access modifiers changed from: private */
    /* renamed from: setItemEnabled$lambda-3  reason: not valid java name */
    public static final void m5869setItemEnabled$lambda3(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void populate(@NotNull VendorOfferDisplayModel vendorOfferDisplayModel) {
        Intrinsics.checkNotNullParameter(vendorOfferDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        populate(vendorOfferDisplayModel, (Function0<Unit>) null);
    }

    public final void populate(@NotNull VendorOfferDisplayModel vendorOfferDisplayModel, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(vendorOfferDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        View view = this.itemView;
        ((LinearLayout) view.findViewById(R.id.vendorOfferSubTitle)).removeAllViews();
        ((TextView) view.findViewById(R.id.vendorOfferTitleTextView)).setText(vendorOfferDisplayModel.getTitle());
        Iterable<String> split$default = StringsKt__StringsKt.split$default((CharSequence) vendorOfferDisplayModel.getSubtitle(), new String[]{","}, false, 0, 6, (Object) null);
        ArrayList<String> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(split$default, 10));
        for (String trim : split$default) {
            arrayList.add(StringsKt__StringsKt.trim((CharSequence) trim).toString());
        }
        for (String text : arrayList) {
            View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.view_offer_subtitle_view, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.vendorOfferSubTitleTextView)).setText(text);
            ((LinearLayout) view.findViewById(R.id.vendorOfferSubTitle)).addView(inflate);
        }
        if (vendorOfferDisplayModel.getInfo().length() == 0) {
            ((TextView) view.findViewById(R.id.vendorOfferRedemptionCountTextView)).setVisibility(8);
        } else {
            int i11 = R.id.vendorOfferRedemptionCountTextView;
            ((TextView) view.findViewById(i11)).setVisibility(0);
            ((TextView) view.findViewById(i11)).setText(vendorOfferDisplayModel.getInfo());
        }
        if (vendorOfferDisplayModel.isEnabled()) {
            Intrinsics.checkNotNullExpressionValue(view, "");
            setItemEnabled(view, function0, vendorOfferDisplayModel);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(view, "");
        setItemDisabled(view);
    }
}
