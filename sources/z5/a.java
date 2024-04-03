package z5;

import android.content.DialogInterface;
import com.designsystem.ds_bottom_sheet.DSBottomSheet;

public final /* synthetic */ class a implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DSBottomSheet f34850a;

    public /* synthetic */ a(DSBottomSheet dSBottomSheet) {
        this.f34850a = dSBottomSheet;
    }

    public final void onShow(DialogInterface dialogInterface) {
        DSBottomSheet.m8258onViewCreated$lambda1(this.f34850a, dialogInterface);
    }
}
