package a6;

import android.content.DialogInterface;
import com.designsystem.ds_bottom_sheet_v2.BottomSheet;

public final /* synthetic */ class b implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomSheet f29308a;

    public /* synthetic */ b(BottomSheet bottomSheet) {
        this.f29308a = bottomSheet;
    }

    public final void onShow(DialogInterface dialogInterface) {
        BottomSheet.m8263onViewCreated$lambda4(this.f29308a, dialogInterface);
    }
}
