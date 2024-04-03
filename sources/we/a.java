package we;

import android.content.DialogInterface;
import android.view.View;
import com.talabat.NoItemsBottomSheet.NoItemsBottomSheet;

public final /* synthetic */ class a implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f57915a;

    public /* synthetic */ a(View view) {
        this.f57915a = view;
    }

    public final void onShow(DialogInterface dialogInterface) {
        NoItemsBottomSheet.m9488setBottomSheetHeight$lambda4(this.f57915a, dialogInterface);
    }
}
