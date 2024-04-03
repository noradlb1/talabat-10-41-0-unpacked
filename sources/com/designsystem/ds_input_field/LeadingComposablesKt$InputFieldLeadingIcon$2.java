package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class LeadingComposablesKt$InputFieldLeadingIcon$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f31754g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31755h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31756i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f31757j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LeadingComposablesKt$InputFieldLeadingIcon$2(Integer num, boolean z11, int i11, int i12) {
        super(2);
        this.f31754g = num;
        this.f31755h = z11;
        this.f31756i = i11;
        this.f31757j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LeadingComposablesKt.InputFieldLeadingIcon(this.f31754g, this.f31755h, composer, this.f31756i | 1, this.f31757j);
    }
}
