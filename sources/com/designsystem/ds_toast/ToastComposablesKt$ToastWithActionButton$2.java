package com.designsystem.ds_toast;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ToastComposablesKt$ToastWithActionButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f33272g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f33273h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33274i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f33275j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f33276k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f33277l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToastComposablesKt$ToastWithActionButton$2(String str, Integer num, Function0<Unit> function0, String str2, int i11, int i12) {
        super(2);
        this.f33272g = str;
        this.f33273h = num;
        this.f33274i = function0;
        this.f33275j = str2;
        this.f33276k = i11;
        this.f33277l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ToastComposablesKt.ToastWithActionButton(this.f33272g, this.f33273h, this.f33274i, this.f33275j, composer, this.f33276k | 1, this.f33277l);
    }
}
