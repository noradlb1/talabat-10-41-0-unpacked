package com.designsystem.ds_dialog;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DialogComposablesKt$DialogButtons$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31093g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31094h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogComposablesKt$DialogButtons$2(Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f31093g = function2;
        this.f31094h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DialogComposablesKt.DialogButtons(this.f31093g, composer, this.f31094h | 1);
    }
}
