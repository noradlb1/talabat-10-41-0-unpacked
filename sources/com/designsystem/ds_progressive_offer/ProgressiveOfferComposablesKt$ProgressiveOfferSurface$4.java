package com.designsystem.ds_progressive_offer;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ProgressiveOfferComposablesKt$ProgressiveOfferSurface$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32529g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32530h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f32531i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f32532j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Integer f32533k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Long f32534l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f32535m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32536n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f32537o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$ProgressiveOfferSurface$4(Modifier modifier, String str, float f11, String str2, Integer num, Long l11, boolean z11, int i11, int i12) {
        super(2);
        this.f32529g = modifier;
        this.f32530h = str;
        this.f32531i = f11;
        this.f32532j = str2;
        this.f32533k = num;
        this.f32534l = l11;
        this.f32535m = z11;
        this.f32536n = i11;
        this.f32537o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ProgressiveOfferComposablesKt.ProgressiveOfferSurface(this.f32529g, this.f32530h, this.f32531i, this.f32532j, this.f32533k, this.f32534l, this.f32535m, composer, this.f32536n | 1, this.f32537o);
    }
}
