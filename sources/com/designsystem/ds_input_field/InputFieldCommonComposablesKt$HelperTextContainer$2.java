package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$HelperTextContainer$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f31582g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f31583h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Integer f31584i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ContainerState f31585j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ OuterState f31586k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31587l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$HelperTextContainer$2(String str, Integer num, Integer num2, ContainerState containerState, OuterState outerState, int i11) {
        super(2);
        this.f31582g = str;
        this.f31583h = num;
        this.f31584i = num2;
        this.f31585j = containerState;
        this.f31586k = outerState;
        this.f31587l = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InputFieldCommonComposablesKt.HelperTextContainer(this.f31582g, this.f31583h, this.f31584i, this.f31585j, this.f31586k, composer, this.f31587l | 1);
    }
}
