package po;

import android.view.View;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsFragment f62794b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TProPlanDisplayModel f62795c;

    public /* synthetic */ b(TproBenefitsFragment tproBenefitsFragment, TProPlanDisplayModel tProPlanDisplayModel) {
        this.f62794b = tproBenefitsFragment;
        this.f62795c = tProPlanDisplayModel;
    }

    public final void onClick(View view) {
        TproBenefitsFragment.m10351bindContent$lambda26(this.f62794b, this.f62795c, view);
    }
}
