package ns;

import android.view.View;
import com.talabat.itemdetailsbottomsheet.ItemDetailsBottomSheet;
import datamodels.CartMenuItem;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ItemDetailsBottomSheet f62359b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CartMenuItem f62360c;

    public /* synthetic */ b(ItemDetailsBottomSheet itemDetailsBottomSheet, CartMenuItem cartMenuItem) {
        this.f62359b = itemDetailsBottomSheet;
        this.f62360c = cartMenuItem;
    }

    public final void onClick(View view) {
        ItemDetailsBottomSheet.m10674setClickListeners$lambda2(this.f62359b, this.f62360c, view);
    }
}
