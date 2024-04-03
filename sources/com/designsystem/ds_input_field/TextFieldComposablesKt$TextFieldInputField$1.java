package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class TextFieldComposablesKt$TextFieldInputField$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f31908g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31909h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31910i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldComposablesKt$TextFieldInputField$1(Integer num, boolean z11, int i11) {
        super(2);
        this.f31908g = num;
        this.f31909h = z11;
        this.f31910i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Integer num = this.f31908g;
            boolean z11 = this.f31909h;
            int i12 = this.f31910i;
            LeadingComposablesKt.InputFieldLeadingIcon(num, z11, composer, ((i12 >> 15) & 112) | ((i12 >> 24) & 14), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
