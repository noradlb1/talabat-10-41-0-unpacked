package hv;

import android.view.View;
import com.talabat.talabatcommon.views.TalabatStarRating;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TalabatStarRating f14106b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f14107c;

    public /* synthetic */ h(TalabatStarRating talabatStarRating, Function1 function1) {
        this.f14106b = talabatStarRating;
        this.f14107c = function1;
    }

    public final void onClick(View view) {
        TalabatStarRating.m5749setOnRatingChangedListener$lambda3(this.f14106b, this.f14107c, view);
    }
}
