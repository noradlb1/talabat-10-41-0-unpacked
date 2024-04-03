package com.designsystem.ds_tag_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTag2ComposablesKt$DSTag2Surface$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f33086g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f33087h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DSTagPriority f33088i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSTagSize f33089j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DSTagColor f33090k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Integer f33091l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f33092m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f33093n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTag2ComposablesKt$DSTag2Surface$3(Modifier modifier, String str, DSTagPriority dSTagPriority, DSTagSize dSTagSize, DSTagColor dSTagColor, Integer num, int i11, int i12) {
        super(2);
        this.f33086g = modifier;
        this.f33087h = str;
        this.f33088i = dSTagPriority;
        this.f33089j = dSTagSize;
        this.f33090k = dSTagColor;
        this.f33091l = num;
        this.f33092m = i11;
        this.f33093n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSTag2ComposablesKt.DSTag2Surface(this.f33086g, this.f33087h, this.f33088i, this.f33089j, this.f33090k, this.f33091l, composer, this.f33092m | 1, this.f33093n);
    }
}
