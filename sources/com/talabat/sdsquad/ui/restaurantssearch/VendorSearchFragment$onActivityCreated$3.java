package com.talabat.sdsquad.ui.restaurantssearch;

import android.text.Editable;
import android.text.TextWatcher;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsFragment;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/talabat/sdsquad/ui/restaurantssearch/VendorSearchFragment$onActivityCreated$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "searchTerm", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorSearchFragment$onActivityCreated$3 implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorSearchFragment f61334b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61335c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f61336d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f61337e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f61338f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f61339g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f61340h;

    public VendorSearchFragment$onActivityCreated$3(VendorSearchFragment vendorSearchFragment, String str, String str2, int i11, int i12, int i13, int i14) {
        this.f61334b = vendorSearchFragment;
        this.f61335c = str;
        this.f61336d = str2;
        this.f61337e = i11;
        this.f61338f = i12;
        this.f61339g = i13;
        this.f61340h = i14;
    }

    public void afterTextChanged(@Nullable Editable editable) {
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
        boolean z11;
        if (charSequence != null) {
            VendorSearchFragment vendorSearchFragment = this.f61334b;
            String str = this.f61335c;
            String str2 = this.f61336d;
            int i14 = this.f61337e;
            int i15 = this.f61338f;
            int i16 = this.f61339g;
            int i17 = this.f61340h;
            if (charSequence.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                vendorSearchFragment.getChildFragmentManager().beginTransaction().replace(R.id.vendorSearchContainer, SuggestionsFragment.Companion.newInstance(charSequence.toString(), str, str2, i14, i15, i16, i17)).commitNow();
            }
        }
    }
}
