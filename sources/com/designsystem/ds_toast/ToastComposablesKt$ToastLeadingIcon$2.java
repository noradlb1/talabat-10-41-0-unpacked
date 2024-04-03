package com.designsystem.ds_toast;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ToastComposablesKt$ToastLeadingIcon$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f33256g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f33257h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f33258i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToastComposablesKt$ToastLeadingIcon$2(Integer num, int i11, int i12) {
        super(2);
        this.f33256g = num;
        this.f33257h = i11;
        this.f33258i = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ToastComposablesKt.ToastLeadingIcon(this.f33256g, composer, this.f33257h | 1, this.f33258i);
    }
}
