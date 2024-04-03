package jp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragment;

public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TProPaymentBottomSheetFragment f62192a;

    public /* synthetic */ a(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment) {
        this.f62192a = tProPaymentBottomSheetFragment;
    }

    public final void onActivityResult(Object obj) {
        TProPaymentBottomSheetFragment.m10417launcher$lambda0(this.f62192a, (ActivityResult) obj);
    }
}
