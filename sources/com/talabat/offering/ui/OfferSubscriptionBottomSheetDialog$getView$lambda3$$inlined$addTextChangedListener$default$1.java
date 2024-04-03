package com.talabat.offering.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.designsystem.ds_button.DSPrimaryButton;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.talabat.offering.ui.OfferSubscriptionBottomSheetDialog$getView$lambda-3$$inlined$addTextChangedListener$default$1  reason: invalid class name */
public final class OfferSubscriptionBottomSheetDialog$getView$lambda3$$inlined$addTextChangedListener$default$1 implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OfferSubscriptionBottomSheetDialog f61166b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DSPrimaryButton f61167c;

    public OfferSubscriptionBottomSheetDialog$getView$lambda3$$inlined$addTextChangedListener$default$1(OfferSubscriptionBottomSheetDialog offerSubscriptionBottomSheetDialog, DSPrimaryButton dSPrimaryButton) {
        this.f61166b = offerSubscriptionBottomSheetDialog;
        this.f61167c = dSPrimaryButton;
    }

    public void afterTextChanged(@Nullable Editable editable) {
        boolean z11;
        this.f61166b.mobileNumber = String.valueOf(editable);
        DSPrimaryButton dSPrimaryButton = this.f61167c;
        String access$getMobileNumber$p = this.f61166b.mobileNumber;
        if (access$getMobileNumber$p == null || StringsKt__StringsJVMKt.isBlank(access$getMobileNumber$p)) {
            z11 = true;
        } else {
            z11 = false;
        }
        dSPrimaryButton.setDsIsEnabled(!z11);
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }
}
