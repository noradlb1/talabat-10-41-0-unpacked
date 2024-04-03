package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.AddAddressScreen2;
import com.talabat.configuration.country.Country;

public final /* synthetic */ class d0 implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAddressScreen2 f57479b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Country f57480c;

    public /* synthetic */ d0(AddAddressScreen2 addAddressScreen2, Country country) {
        this.f57479b = addAddressScreen2;
        this.f57480c = country;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57479b.lambda$onCreate$5(this.f57480c, textView, i11, keyEvent);
    }
}
