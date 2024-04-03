package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class LeadingComposablesKt$CountryFlagImage$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f31751g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31752h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31753i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LeadingComposablesKt$CountryFlagImage$2(int i11, boolean z11, int i12) {
        super(2);
        this.f31751g = i11;
        this.f31752h = z11;
        this.f31753i = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LeadingComposablesKt.CountryFlagImage(this.f31751g, this.f31752h, composer, this.f31753i | 1);
    }
}
