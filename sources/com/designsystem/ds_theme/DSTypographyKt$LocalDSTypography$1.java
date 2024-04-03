package com.designsystem.ds_theme;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/designsystem/ds_theme/DSTypography;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DSTypographyKt$LocalDSTypography$1 extends Lambda implements Function0<DSTypography> {
    public static final DSTypographyKt$LocalDSTypography$1 INSTANCE = new DSTypographyKt$LocalDSTypography$1();

    public DSTypographyKt$LocalDSTypography$1() {
        super(0);
    }

    @NotNull
    public final DSTypography invoke() {
        return DSTypographyKt.getEnglishDSTypography();
    }
}
