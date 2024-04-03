package com.instabug.library.util.threading;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class j {
    @NotNull
    public static final String a(@Nullable String str, int i11) {
        return "IBG-" + str + SignatureVisitor.SUPER + i11;
    }
}
