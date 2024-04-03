package com.designsystem.ds_progressive_offer;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTieredProgressiveOfferKt$DSTieredProgressiveOffer$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32475g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f32476h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f32477i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f32478j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Integer f32479k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Long f32480l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f32481m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32482n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTieredProgressiveOfferKt$DSTieredProgressiveOffer$1(String str, float f11, Modifier modifier, String str2, Integer num, Long l11, int i11, int i12) {
        super(2);
        this.f32475g = str;
        this.f32476h = f11;
        this.f32477i = modifier;
        this.f32478j = str2;
        this.f32479k = num;
        this.f32480l = l11;
        this.f32481m = i11;
        this.f32482n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSTieredProgressiveOfferKt.DSTieredProgressiveOffer(this.f32475g, this.f32476h, this.f32477i, this.f32478j, this.f32479k, this.f32480l, composer, this.f32481m | 1, this.f32482n);
    }
}
