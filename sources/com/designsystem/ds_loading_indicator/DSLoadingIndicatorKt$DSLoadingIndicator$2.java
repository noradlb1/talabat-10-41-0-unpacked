package com.designsystem.ds_loading_indicator;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSLoadingIndicatorKt$DSLoadingIndicator$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32377g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32378h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32379i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32380j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSLoadingIndicatorKt$DSLoadingIndicator$2(Modifier modifier, boolean z11, int i11, int i12) {
        super(2);
        this.f32377g = modifier;
        this.f32378h = z11;
        this.f32379i = i11;
        this.f32380j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSLoadingIndicatorKt.DSLoadingIndicator(this.f32377g, this.f32378h, composer, this.f32379i | 1, this.f32380j);
    }
}
