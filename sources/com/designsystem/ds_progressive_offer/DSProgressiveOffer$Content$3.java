package com.designsystem.ds_progressive_offer;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSProgressiveOffer$Content$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSProgressiveOffer f32466g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32467h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSProgressiveOffer$Content$3(DSProgressiveOffer dSProgressiveOffer, int i11) {
        super(2);
        this.f32466g = dSProgressiveOffer;
        this.f32467h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f32466g.Content(composer, this.f32467h | 1);
    }
}
