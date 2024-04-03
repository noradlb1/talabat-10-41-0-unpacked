package com.designsystem.ds_progressive_offer;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ProgressiveOfferComposablesKt$OfferTier$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f32502g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f32503h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f32504i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f32505j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f32506k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f32507l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f32508m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32509n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f32510o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$OfferTier$2(boolean z11, long j11, String str, Integer num, float f11, float f12, boolean z12, int i11, int i12) {
        super(2);
        this.f32502g = z11;
        this.f32503h = j11;
        this.f32504i = str;
        this.f32505j = num;
        this.f32506k = f11;
        this.f32507l = f12;
        this.f32508m = z12;
        this.f32509n = i11;
        this.f32510o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ProgressiveOfferComposablesKt.OfferTier(this.f32502g, this.f32503h, this.f32504i, this.f32505j, this.f32506k, this.f32507l, this.f32508m, composer, this.f32509n | 1, this.f32510o);
    }
}
