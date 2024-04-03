package a6;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.designsystem.ds_bottom_sheet_v2.BottomSheet;

public final /* synthetic */ class a implements DialogInterface.OnKeyListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomSheet f29307b;

    public /* synthetic */ a(BottomSheet bottomSheet) {
        this.f29307b = bottomSheet;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        return BottomSheet.m8262onCreateDialog$lambda3$lambda2(this.f29307b, dialogInterface, i11, keyEvent);
    }
}
