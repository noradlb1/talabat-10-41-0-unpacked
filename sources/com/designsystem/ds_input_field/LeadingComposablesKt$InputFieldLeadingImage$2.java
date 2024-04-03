package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class LeadingComposablesKt$InputFieldLeadingImage$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f31758g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31759h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31760i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f31761j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LeadingComposablesKt$InputFieldLeadingImage$2(Integer num, boolean z11, int i11, int i12) {
        super(2);
        this.f31758g = num;
        this.f31759h = z11;
        this.f31760i = i11;
        this.f31761j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LeadingComposablesKt.InputFieldLeadingImage(this.f31758g, this.f31759h, composer, this.f31760i | 1, this.f31761j);
    }
}
