package com.talabat.talabatlife.ui.vendorList.views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.talabatcommon.extentions.ImageViewForTalabatKt;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.views.branch.VendorBranchBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/views/VendorsListViewHolderImpl;", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorsListViewHolder;", "Lcom/talabat/talabatlife/ui/vendorOffers/views/branch/VendorBranchBase;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "populate", "", "model", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "clickListener", "Landroid/view/View$OnClickListener;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListViewHolderImpl extends VendorsListViewHolder implements VendorBranchBase {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public VendorsListViewHolderImpl(@org.jetbrains.annotations.NotNull android.view.ViewGroup r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r0 = r4.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = com.talabat.talabatlife.R.layout.view_holder_vendors
            r2 = 0
            android.view.View r4 = r0.inflate(r1, r4, r2)
            java.lang.String r0 = "from(parent.context)\n   …r_vendors, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.<init>(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.ui.vendorList.views.VendorsListViewHolderImpl.<init>(android.view.ViewGroup):void");
    }

    @NotNull
    public String getDistance(@NotNull View view, double d11) {
        return VendorBranchBase.DefaultImpls.getDistance(this, view, d11);
    }

    public void populate(@NotNull VendorDisplayModel vendorDisplayModel, @NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(vendorDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
        View view = this.itemView;
        int i11 = 0;
        if (vendorDisplayModel.isNew()) {
            int i12 = R.id.newTag;
            ((TextView) view.findViewById(i12)).setVisibility(0);
            ((TextView) view.findViewById(i12)).setText(vendorDisplayModel.getNewTagText());
        } else {
            ((TextView) view.findViewById(R.id.newTag)).setVisibility(8);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.vendorOfferViewListImageView);
        String imageUrl = vendorDisplayModel.getImageUrl();
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.vendor_item_image_height);
        int i13 = view.getResources().getDisplayMetrics().widthPixels;
        Intrinsics.checkNotNullExpressionValue(imageView, "vendorOfferViewListImageView");
        ImageViewForTalabatKt.setImageResizeUrl$default(imageView, imageUrl, i13, dimensionPixelSize, false, 8, (Object) null);
        ((TextView) view.findViewById(R.id.vendorOfferViewListTitleTextView)).setText(vendorDisplayModel.getName());
        int i14 = R.id.vendorViewDistanceTextView;
        Intrinsics.checkNotNullExpressionValue(view, "this");
        ((TextView) view.findViewById(i14)).setText(getDistance(view, vendorDisplayModel.getMinimumDistanceFromCustomer()));
        if (vendorDisplayModel.getMinimumDistanceFromCustomer() >= 0.0d) {
            ((TextView) view.findViewById(i14)).setText(getDistance(view, vendorDisplayModel.getMinimumDistanceFromCustomer()));
            ((LinearLayout) view.findViewById(R.id.vendorViewDistanceLinearLayout)).setVisibility(0);
        } else {
            ((LinearLayout) view.findViewById(R.id.vendorViewDistanceLinearLayout)).setVisibility(4);
        }
        ((TextView) view.findViewById(R.id.vendorOfferViewListCousinTextView)).setText(vendorDisplayModel.getCuisines());
        ((LinearLayout) view.findViewById(R.id.vendorOfferViewPromoLinerLayout)).removeAllViews();
        for (Object next : vendorDisplayModel.getOffers()) {
            int i15 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) next;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.vendorOfferViewPromoLinerLayout);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            VendorPromoView vendorPromoView = new VendorPromoView(context);
            if (i11 != 0) {
                vendorPromoView.showSeparator();
            }
            vendorPromoView.setPromoText(str);
            linearLayout.addView(vendorPromoView);
            i11 = i15;
        }
        view.setOnClickListener(onClickListener);
    }

    public void setMapsOnClickListener(@NotNull View view, @NotNull VendorBranchDisplayModel vendorBranchDisplayModel) {
        VendorBranchBase.DefaultImpls.setMapsOnClickListener(this, view, vendorBranchDisplayModel);
    }
}
