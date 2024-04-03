package hv;

import android.view.View;
import com.talabat.talabatcommon.views.TalabatStarRating;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TalabatStarRating f14100b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f14101c;

    public /* synthetic */ e(TalabatStarRating talabatStarRating, Function1 function1) {
        this.f14100b = talabatStarRating;
        this.f14101c = function1;
    }

    public final void onClick(View view) {
        TalabatStarRating.m5746setOnRatingChangedListener$lambda0(this.f14100b, this.f14101c, view);
    }
}
