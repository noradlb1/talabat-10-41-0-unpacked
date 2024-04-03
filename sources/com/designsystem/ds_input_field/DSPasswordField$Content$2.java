package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSPasswordField$Content$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSPasswordField f31417g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31418h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPasswordField$Content$2(DSPasswordField dSPasswordField, int i11) {
        super(2);
        this.f31417g = dSPasswordField;
        this.f31418h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f31417g.Content(composer, this.f31418h | 1);
    }
}
