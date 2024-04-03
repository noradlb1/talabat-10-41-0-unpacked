package ns;

import android.view.View;
import com.talabat.itemdetailsbottomsheet.ItemDetailsBottomSheet;
import datamodels.CartMenuItem;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ItemDetailsBottomSheet f62361b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CartMenuItem f62362c;

    public /* synthetic */ c(ItemDetailsBottomSheet itemDetailsBottomSheet, CartMenuItem cartMenuItem) {
        this.f62361b = itemDetailsBottomSheet;
        this.f62362c = cartMenuItem;
    }

    public final void onClick(View view) {
        ItemDetailsBottomSheet.m10675setClickListeners$lambda3(this.f62361b, this.f62362c, view);
    }
}
