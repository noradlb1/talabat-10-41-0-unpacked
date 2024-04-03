package ns;

import android.view.View;
import com.talabat.itemdetailsbottomsheet.ItemDetailsBottomSheet;
import datamodels.CartMenuItem;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ItemDetailsBottomSheet f62363b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CartMenuItem f62364c;

    public /* synthetic */ d(ItemDetailsBottomSheet itemDetailsBottomSheet, CartMenuItem cartMenuItem) {
        this.f62363b = itemDetailsBottomSheet;
        this.f62364c = cartMenuItem;
    }

    public final void onClick(View view) {
        ItemDetailsBottomSheet.m10676setClickListeners$lambda4(this.f62363b, this.f62364c, view);
    }
}
