package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class TextAreaComposablesKt$TextAreaInputField$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OuterState f31891g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31892h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31893i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextAreaComposablesKt$TextAreaInputField$1(OuterState outerState, boolean z11, int i11) {
        super(2);
        this.f31891g = outerState;
        this.f31892h = z11;
        this.f31893i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            OuterState outerState = this.f31891g;
            boolean z11 = this.f31892h;
            int i12 = this.f31893i;
            InputFieldCommonComposablesKt.InputFieldTrailingIconContainer((Integer) null, outerState, z11, (Function0<Unit>) null, false, composer, ((i12 >> 18) & 112) | ((i12 >> 12) & 896), 25);
            return;
        }
        composer.skipToGroupEnd();
    }
}
