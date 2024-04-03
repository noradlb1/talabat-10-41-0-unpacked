package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class LeadingComposablesKt$PhoneInputLeadingComposable$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f31763g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31764h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31765i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f31766j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f31767k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LeadingComposablesKt$PhoneInputLeadingComposable$3(Integer num, boolean z11, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f31763g = num;
        this.f31764h = z11;
        this.f31765i = function0;
        this.f31766j = i11;
        this.f31767k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LeadingComposablesKt.PhoneInputLeadingComposable(this.f31763g, this.f31764h, this.f31765i, composer, this.f31766j | 1, this.f31767k);
    }
}
