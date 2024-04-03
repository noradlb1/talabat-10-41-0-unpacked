package pf;

import android.content.DialogInterface;
import android.view.View;
import com.talabat.busypopup.BusyPopupBottomSheet;

public final /* synthetic */ class a implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f57174a;

    public /* synthetic */ a(View view) {
        this.f57174a = view;
    }

    public final void onShow(DialogInterface dialogInterface) {
        BusyPopupBottomSheet.m9533setBottomSheetHeight$lambda5(this.f57174a, dialogInterface);
    }
}
