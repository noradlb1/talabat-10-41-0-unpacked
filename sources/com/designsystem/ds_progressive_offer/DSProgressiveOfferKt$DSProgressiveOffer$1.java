package com.designsystem.ds_progressive_offer;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSProgressiveOfferKt$DSProgressiveOffer$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32468g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f32469h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f32470i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32471j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32472k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSProgressiveOfferKt$DSProgressiveOffer$1(String str, float f11, Modifier modifier, int i11, int i12) {
        super(2);
        this.f32468g = str;
        this.f32469h = f11;
        this.f32470i = modifier;
        this.f32471j = i11;
        this.f32472k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSProgressiveOfferKt.DSProgressiveOffer(this.f32468g, this.f32469h, this.f32470i, composer, this.f32471j | 1, this.f32472k);
    }
}
