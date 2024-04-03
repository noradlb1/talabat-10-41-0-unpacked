package hv;

import android.view.View;
import com.talabat.talabatcommon.views.TalabatStarRating;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TalabatStarRating f14102b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f14103c;

    public /* synthetic */ f(TalabatStarRating talabatStarRating, Function1 function1) {
        this.f14102b = talabatStarRating;
        this.f14103c = function1;
    }

    public final void onClick(View view) {
        TalabatStarRating.m5747setOnRatingChangedListener$lambda1(this.f14102b, this.f14103c, view);
    }
}
