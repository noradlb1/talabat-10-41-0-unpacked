package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt$ListItemSelectableSurface$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32294g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f32295h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f32296i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f32297j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f32298k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f32299l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f32300m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableListItemComposablesKt$ListItemSelectableSurface$2(Modifier modifier, Function1<? super Boolean, Unit> function1, MutableInteractionSource mutableInteractionSource, boolean z11, MutableState<Boolean> mutableState, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f32294g = modifier;
        this.f32295h = function1;
        this.f32296i = mutableInteractionSource;
        this.f32297j = z11;
        this.f32298k = mutableState;
        this.f32299l = function3;
        this.f32300m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SelectableListItemComposablesKt.ListItemSelectableSurface(this.f32294g, this.f32295h, this.f32296i, this.f32297j, this.f32298k, this.f32299l, composer, this.f32300m | 1);
    }
}
