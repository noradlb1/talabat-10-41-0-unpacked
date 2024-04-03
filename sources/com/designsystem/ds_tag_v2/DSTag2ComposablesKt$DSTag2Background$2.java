package com.designsystem.ds_tag_v2;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTag2ComposablesKt$DSTag2Background$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f33074g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSTagPriority f33075h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DSTagSize f33076i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSTagColor f33077j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f33078k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f33079l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTag2ComposablesKt$DSTag2Background$2(Modifier modifier, DSTagPriority dSTagPriority, DSTagSize dSTagSize, DSTagColor dSTagColor, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f33074g = modifier;
        this.f33075h = dSTagPriority;
        this.f33076i = dSTagSize;
        this.f33077j = dSTagColor;
        this.f33078k = function3;
        this.f33079l = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSTag2ComposablesKt.DSTag2Background(this.f33074g, this.f33075h, this.f33076i, this.f33077j, this.f33078k, composer, this.f33079l | 1);
    }
}
