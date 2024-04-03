package com.instabug.library.networkv2;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class RequestException extends Exception {
    private final int requestCode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RequestException(int i11, @NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
        this.requestCode = i11;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    @NotNull
    public String toString() {
        boolean z11;
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("RequestException(requestCode = ");
        sb2.append(this.requestCode);
        String message = getMessage();
        if (message == null || message.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str = "";
        } else {
            str = Intrinsics.stringPlus(", message= ", getMessage());
        }
        sb2.append(str);
        sb2.append(") ");
        return sb2.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RequestException(int i11, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? "" : str);
    }
}
