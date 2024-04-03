package com.designsystem.ds_toast;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ToastComposablesKt$ToastSurface$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f33263g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f33264h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f33265i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f33266j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f33267k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToastComposablesKt$ToastSurface$2(String str, Integer num, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f33263g = str;
        this.f33264h = num;
        this.f33265i = function2;
        this.f33266j = i11;
        this.f33267k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ToastComposablesKt.ToastSurface(this.f33263g, this.f33264h, this.f33265i, composer, this.f33266j | 1, this.f33267k);
    }
}
