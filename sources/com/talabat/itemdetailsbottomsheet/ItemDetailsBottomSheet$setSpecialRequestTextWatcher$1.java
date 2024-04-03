package com.talabat.itemdetailsbottomsheet;

import android.text.Editable;
import android.text.TextWatcher;
import datamodels.CartMenuItem;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/talabat/itemdetailsbottomsheet/ItemDetailsBottomSheet$setSpecialRequestTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemDetailsBottomSheet$setSpecialRequestTextWatcher$1 implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartMenuItem f61003b;

    public ItemDetailsBottomSheet$setSpecialRequestTextWatcher$1(CartMenuItem cartMenuItem) {
        this.f61003b = cartMenuItem;
    }

    public void afterTextChanged(@Nullable Editable editable) {
        boolean z11;
        if (editable != null) {
            CartMenuItem cartMenuItem = this.f61003b;
            if (StringsKt__StringsKt.trim((CharSequence) editable.toString()).toString().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                cartMenuItem.specialRequest = StringsKt__StringsKt.trim((CharSequence) editable.toString()).toString();
            }
        }
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }
}
