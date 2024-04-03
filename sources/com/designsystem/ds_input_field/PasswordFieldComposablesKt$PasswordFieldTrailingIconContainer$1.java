package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class PasswordFieldComposablesKt$PasswordFieldTrailingIconContainer$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f31781g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31782h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31783i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f31784j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PasswordFieldComposablesKt$PasswordFieldTrailingIconContainer$1(int i11, Function0<Unit> function0, int i12, int i13) {
        super(2);
        this.f31781g = i11;
        this.f31782h = function0;
        this.f31783i = i12;
        this.f31784j = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        PasswordFieldComposablesKt.PasswordFieldTrailingIconContainer(this.f31781g, this.f31782h, composer, this.f31783i | 1, this.f31784j);
    }
}
