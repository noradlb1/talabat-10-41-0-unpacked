package com.talabat.gem.samples;

import android.text.Editable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¨\u0006\u0004"}, d2 = {"calculateSubTotal", "", "it", "Landroid/text/Editable;", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SampleGemMenuActivityKt {
    public static final double calculateSubTotal(@Nullable Editable editable) {
        Double doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(String.valueOf(editable));
        if (doubleOrNull != null) {
            return doubleOrNull.doubleValue();
        }
        return 0.0d;
    }
}
