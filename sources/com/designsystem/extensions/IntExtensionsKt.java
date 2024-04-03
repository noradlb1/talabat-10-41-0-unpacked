package com.designsystem.extensions;

import android.content.res.Resources;
import kotlin.Metadata;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"toPx", "", "getToPx", "(I)I", "toCountString", "", "maxValue", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class IntExtensionsKt {
    public static final int getToPx(int i11) {
        return (int) (((float) i11) * Resources.getSystem().getDisplayMetrics().density);
    }

    @NotNull
    public static final String toCountString(int i11, int i12) {
        if (i11 < 0) {
            return "0";
        }
        if (i11 <= i12) {
            return String.valueOf(i11);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i12);
        sb2.append(SignatureVisitor.EXTENDS);
        return sb2.toString();
    }

    public static /* synthetic */ String toCountString$default(int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i12 = 99;
        }
        return toCountString(i11, i12);
    }
}
