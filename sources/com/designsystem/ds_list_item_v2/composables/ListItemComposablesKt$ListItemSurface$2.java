package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ListItemComposablesKt$ListItemSurface$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32254g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32255h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f32256i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f32257j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f32258k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f32259l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f32260m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemComposablesKt$ListItemSurface$2(Modifier modifier, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource, boolean z11, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f32254g = modifier;
        this.f32255h = function0;
        this.f32256i = mutableInteractionSource;
        this.f32257j = z11;
        this.f32258k = function3;
        this.f32259l = i11;
        this.f32260m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ListItemComposablesKt.ListItemSurface(this.f32254g, this.f32255h, this.f32256i, this.f32257j, this.f32258k, composer, this.f32259l | 1, this.f32260m);
    }
}
