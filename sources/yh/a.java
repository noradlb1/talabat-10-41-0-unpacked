package yh;

import android.content.DialogInterface;
import com.talabat.darkstores.common.base.BaseBottomSheet;

public final /* synthetic */ class a implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseBottomSheet f58021a;

    public /* synthetic */ a(BaseBottomSheet baseBottomSheet) {
        this.f58021a = baseBottomSheet;
    }

    public final void onShow(DialogInterface dialogInterface) {
        BaseBottomSheet.m9631setupBehavior$lambda2(this.f58021a, dialogInterface);
    }
}
