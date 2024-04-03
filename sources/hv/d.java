package hv;

import android.widget.RadioGroup;
import com.talabat.talabatcommon.views.TalabatSmileyRating;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TalabatSmileyRating f14098b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f14099c;

    public /* synthetic */ d(TalabatSmileyRating talabatSmileyRating, Function1 function1) {
        this.f14098b = talabatSmileyRating;
        this.f14099c = function1;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i11) {
        TalabatSmileyRating.m5745setOnRatingChangedListener$lambda1(this.f14098b, this.f14099c, radioGroup, i11);
    }
}
