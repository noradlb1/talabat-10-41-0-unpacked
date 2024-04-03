package hv;

import android.view.View;
import com.talabat.talabatcommon.views.TalabatStarRating;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TalabatStarRating f14104b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f14105c;

    public /* synthetic */ g(TalabatStarRating talabatStarRating, Function1 function1) {
        this.f14104b = talabatStarRating;
        this.f14105c = function1;
    }

    public final void onClick(View view) {
        TalabatStarRating.m5748setOnRatingChangedListener$lambda2(this.f14104b, this.f14105c, view);
    }
}
