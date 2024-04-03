package hv;

import android.view.View;
import com.talabat.talabatcommon.views.TalabatStarRating;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TalabatStarRating f14108b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f14109c;

    public /* synthetic */ i(TalabatStarRating talabatStarRating, Function1 function1) {
        this.f14108b = talabatStarRating;
        this.f14109c = function1;
    }

    public final void onClick(View view) {
        TalabatStarRating.m5750setOnRatingChangedListener$lambda4(this.f14108b, this.f14109c, view);
    }
}
