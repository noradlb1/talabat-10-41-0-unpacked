package ro;

import android.view.View;
import com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders.HeroHeaderItemViewHolder;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f62878b;

    public /* synthetic */ b(Function1 function1) {
        this.f62878b = function1;
    }

    public final void onClick(View view) {
        HeroHeaderItemViewHolder.m10364bind$lambda2(this.f62878b, view);
    }
}
