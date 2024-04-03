package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$CharacterCounterText$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f31574g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31575h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f31576i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f31577j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$CharacterCounterText$1(int i11, int i12, long j11, int i13) {
        super(2);
        this.f31574g = i11;
        this.f31575h = i12;
        this.f31576i = j11;
        this.f31577j = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InputFieldCommonComposablesKt.m8410CharacterCounterTextXOJAsU(this.f31574g, this.f31575h, this.f31576i, composer, this.f31577j | 1);
    }
}
