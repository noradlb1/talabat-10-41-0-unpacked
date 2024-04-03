package com.designsystem.ds_chip;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ChipComposablesKt$ChipTrailingIcon$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f30928g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30929h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f30930i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipComposablesKt$ChipTrailingIcon$2(Integer num, boolean z11, int i11) {
        super(2);
        this.f30928g = num;
        this.f30929h = z11;
        this.f30930i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ChipComposablesKt.ChipTrailingIcon(this.f30928g, this.f30929h, composer, this.f30930i | 1);
    }
}
