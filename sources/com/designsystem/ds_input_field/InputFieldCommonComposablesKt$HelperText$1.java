package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$HelperText$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31578g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31579h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f31580i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f31581j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$HelperText$1(Modifier modifier, String str, long j11, int i11) {
        super(2);
        this.f31578g = modifier;
        this.f31579h = str;
        this.f31580i = j11;
        this.f31581j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InputFieldCommonComposablesKt.m8411HelperTextXOJAsU(this.f31578g, this.f31579h, this.f31580i, composer, this.f31581j | 1);
    }
}
