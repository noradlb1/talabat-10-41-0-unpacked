package com.talabat.talabatlife.ui.vendorList.views;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Filter;
import com.talabat.talabatcommon.extentions.BooleanKt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"com/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterFragment$addEditTextListener$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "charString", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLocationFilterFragment$addEditTextListener$1 implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorLocationFilterFragment f12100b;

    public VendorLocationFilterFragment$addEditTextListener$1(VendorLocationFilterFragment vendorLocationFilterFragment) {
        this.f12100b = vendorLocationFilterFragment;
    }

    public void afterTextChanged(@Nullable Editable editable) {
        boolean z11;
        Filter filter;
        if (editable == null || editable.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (BooleanKt.orFalse(Boolean.valueOf(z11))) {
            this.f12100b.removeClearButton();
        } else {
            this.f12100b.showClearButton();
        }
        VendorLocationFilterAdapter access$getListAdapter$p = this.f12100b.listAdapter;
        if (access$getListAdapter$p != null && (filter = access$getListAdapter$p.getFilter()) != null) {
            filter.filter(String.valueOf(editable));
        }
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }
}
