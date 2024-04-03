package com.talabat.darkstores.common.helpers;

import android.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/common/helpers/Base64Wrapper;", "", "()V", "decode", "", "value", "type", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Base64Wrapper {
    @NotNull
    public final String decode(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "value");
        byte[] decode = Base64.decode(str, i11);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(value, type)");
        return new String(decode, Charsets.UTF_8);
    }
}
