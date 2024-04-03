package ns;

import android.content.DialogInterface;
import android.view.View;
import com.talabat.itemdetailsbottomsheet.ItemDetailsBottomSheet;

public final /* synthetic */ class a implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f62358a;

    public /* synthetic */ a(View view) {
        this.f62358a = view;
    }

    public final void onShow(DialogInterface dialogInterface) {
        ItemDetailsBottomSheet.m10673setBottomSheetHeight$lambda13(this.f62358a, dialogInterface);
    }
}
