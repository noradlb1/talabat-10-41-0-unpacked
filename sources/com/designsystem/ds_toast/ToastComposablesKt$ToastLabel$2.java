package com.designsystem.ds_toast;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ToastComposablesKt$ToastLabel$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f33250g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f33251h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Integer f33252i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f33253j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f33254k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f33255l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToastComposablesKt$ToastLabel$2(Modifier modifier, String str, Integer num, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f33250g = modifier;
        this.f33251h = str;
        this.f33252i = num;
        this.f33253j = function2;
        this.f33254k = i11;
        this.f33255l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ToastComposablesKt.ToastLabel(this.f33250g, this.f33251h, this.f33252i, this.f33253j, composer, this.f33254k | 1, this.f33255l);
    }
}
