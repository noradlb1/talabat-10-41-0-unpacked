package com.talabat.talabatcommon.views.vouchers.applyVoucherView.views;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.talabat.talabatcommon.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/talabat/talabatcommon/views/vouchers/applyVoucherView/views/AddVoucherCodeView$handleVoucherCodeSubmitButton$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddVoucherCodeView$handleVoucherCodeSubmitButton$1 implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddVoucherCodeView f11881b;

    public AddVoucherCodeView$handleVoucherCodeSubmitButton$1(AddVoucherCodeView addVoucherCodeView) {
        this.f11881b = addVoucherCodeView;
    }

    public void afterTextChanged(@NotNull Editable editable) {
        boolean z11;
        float f11;
        Intrinsics.checkNotNullParameter(editable, "s");
        String obj = editable.toString();
        if (obj == null || StringsKt__StringsJVMKt.isBlank(obj)) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z12 = !z11;
        AddVoucherCodeView addVoucherCodeView = this.f11881b;
        int i11 = R.id.voucherCodeSubmitButton;
        ((TextView) addVoucherCodeView._$_findCachedViewById(i11)).setClickable(z12);
        TextView textView = (TextView) this.f11881b._$_findCachedViewById(i11);
        if (z12) {
            f11 = 1.0f;
        } else {
            f11 = 0.4f;
        }
        textView.setAlpha(f11);
    }

    public void beforeTextChanged(@NotNull CharSequence charSequence, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
    }

    public void onTextChanged(@NotNull CharSequence charSequence, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
    }
}
