package jp;

import android.view.View;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragment;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TProPaymentBottomSheetFragment f62194b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TProPlanDisplayModel f62195c;

    public /* synthetic */ c(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment, TProPlanDisplayModel tProPlanDisplayModel) {
        this.f62194b = tProPaymentBottomSheetFragment;
        this.f62195c = tProPlanDisplayModel;
    }

    public final void onClick(View view) {
        TProPaymentBottomSheetFragment.m10419updateUi$lambda8$lambda7(this.f62194b, this.f62195c, view);
    }
}
