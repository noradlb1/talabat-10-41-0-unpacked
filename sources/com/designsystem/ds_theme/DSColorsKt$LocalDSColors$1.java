package com.designsystem.ds_theme;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/designsystem/ds_theme/DSColors;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DSColorsKt$LocalDSColors$1 extends Lambda implements Function0<DSColors> {
    public static final DSColorsKt$LocalDSColors$1 INSTANCE = new DSColorsKt$LocalDSColors$1();

    public DSColorsKt$LocalDSColors$1() {
        super(0);
    }

    @NotNull
    public final DSColors invoke() {
        return DSColorsKt.getDefaultDSColors();
    }
}
