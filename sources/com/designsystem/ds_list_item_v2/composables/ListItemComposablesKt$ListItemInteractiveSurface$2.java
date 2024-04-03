package com.designsystem.ds_list_item_v2.composables;

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
public final class ListItemComposablesKt$ListItemInteractiveSurface$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32243g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f32244h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32245i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32246j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemComposablesKt$ListItemInteractiveSurface$2(Modifier modifier, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f32243g = modifier;
        this.f32244h = function3;
        this.f32245i = i11;
        this.f32246j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ListItemComposablesKt.ListItemInteractiveSurface(this.f32243g, this.f32244h, composer, this.f32245i | 1, this.f32246j);
    }
}
