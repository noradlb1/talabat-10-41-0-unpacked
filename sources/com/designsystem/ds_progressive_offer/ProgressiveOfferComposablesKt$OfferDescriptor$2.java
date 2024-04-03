package com.designsystem.ds_progressive_offer;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ProgressiveOfferComposablesKt$OfferDescriptor$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32492g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32493h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f32494i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f32495j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32496k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$OfferDescriptor$2(String str, boolean z11, float f11, boolean z12, int i11) {
        super(2);
        this.f32492g = str;
        this.f32493h = z11;
        this.f32494i = f11;
        this.f32495j = z12;
        this.f32496k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ProgressiveOfferComposablesKt.OfferDescriptor(this.f32492g, this.f32493h, this.f32494i, this.f32495j, composer, this.f32496k | 1);
    }
}
