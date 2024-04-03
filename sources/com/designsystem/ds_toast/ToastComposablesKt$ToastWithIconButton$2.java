package com.designsystem.ds_toast;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ToastComposablesKt$ToastWithIconButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f33281g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f33282h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33283i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f33284j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f33285k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f33286l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToastComposablesKt$ToastWithIconButton$2(String str, Integer num, Function0<Unit> function0, Integer num2, int i11, int i12) {
        super(2);
        this.f33281g = str;
        this.f33282h = num;
        this.f33283i = function0;
        this.f33284j = num2;
        this.f33285k = i11;
        this.f33286l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ToastComposablesKt.ToastWithIconButton(this.f33281g, this.f33282h, this.f33283i, this.f33284j, composer, this.f33285k | 1, this.f33286l);
    }
}
