package com.talabat.darkstores.common.helpers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/common/helpers/Base64Helper;", "", "base64Wrapper", "Lcom/talabat/darkstores/common/helpers/Base64Wrapper;", "(Lcom/talabat/darkstores/common/helpers/Base64Wrapper;)V", "decodeFromBase64ToString", "", "value", "type", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Base64Helper {
    @NotNull
    private final Base64Wrapper base64Wrapper;

    public Base64Helper(@NotNull Base64Wrapper base64Wrapper2) {
        Intrinsics.checkNotNullParameter(base64Wrapper2, "base64Wrapper");
        this.base64Wrapper = base64Wrapper2;
    }

    public static /* synthetic */ String decodeFromBase64ToString$default(Base64Helper base64Helper, String str, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return base64Helper.decodeFromBase64ToString(str, i11);
    }

    @NotNull
    public final String decodeFromBase64ToString(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "value");
        try {
            return this.base64Wrapper.decode(str, i11);
        } catch (IllegalArgumentException unused) {
            return "";
        }
    }
}
