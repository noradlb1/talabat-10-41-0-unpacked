package com.designsystem.ds_toast;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ToastComposablesKt$BaseToast$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f33246g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f33247h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f33248i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f33249j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToastComposablesKt$BaseToast$1(String str, Integer num, int i11, int i12) {
        super(2);
        this.f33246g = str;
        this.f33247h = num;
        this.f33248i = i11;
        this.f33249j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ToastComposablesKt.BaseToast(this.f33246g, this.f33247h, composer, this.f33248i | 1, this.f33249j);
    }
}
