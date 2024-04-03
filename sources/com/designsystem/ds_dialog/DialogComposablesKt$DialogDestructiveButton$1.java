package com.designsystem.ds_dialog;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DialogComposablesKt$DialogDestructiveButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f31097g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31098h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31099i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogComposablesKt$DialogDestructiveButton$1(String str, Function0<Unit> function0, int i11) {
        super(2);
        this.f31097g = str;
        this.f31098h = function0;
        this.f31099i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DialogComposablesKt.DialogDestructiveButton(this.f31097g, this.f31098h, composer, this.f31099i | 1);
    }
}
