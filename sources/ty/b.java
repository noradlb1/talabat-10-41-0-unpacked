package ty;

import android.content.DialogInterface;
import com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f24122b;

    public /* synthetic */ b(Function0 function0) {
        this.f24122b = function0;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        SubscriptionDetailFragment.m6037showAlertDialog$lambda21$lambda19(this.f24122b, dialogInterface, i11);
    }
}
