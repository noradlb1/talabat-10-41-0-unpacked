package com.designsystem.ds_button_v2.composables;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ButtonComposablesKt$ButtonLeadingIcon$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f30814g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f30815h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f30816i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonComposablesKt$ButtonLeadingIcon$4(int i11, float f11, int i12) {
        super(2);
        this.f30814g = i11;
        this.f30815h = f11;
        this.f30816i = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ButtonComposablesKt.ButtonLeadingIcon(this.f30814g, this.f30815h, composer, this.f30816i | 1);
    }
}
