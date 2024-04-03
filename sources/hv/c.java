package hv;

import android.widget.RadioGroup;
import com.talabat.talabatcommon.views.TalabatSmileyRating;

public final /* synthetic */ class c implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TalabatSmileyRating f14097b;

    public /* synthetic */ c(TalabatSmileyRating talabatSmileyRating) {
        this.f14097b = talabatSmileyRating;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i11) {
        TalabatSmileyRating.m5744onAttachedToWindow$lambda0(this.f14097b, radioGroup, i11);
    }
}
