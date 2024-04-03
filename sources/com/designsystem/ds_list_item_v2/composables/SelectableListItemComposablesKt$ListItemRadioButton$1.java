package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt$ListItemRadioButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f32283g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32284h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32285i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableListItemComposablesKt$ListItemRadioButton$1(boolean z11, boolean z12, int i11) {
        super(2);
        this.f32283g = z11;
        this.f32284h = z12;
        this.f32285i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SelectableListItemComposablesKt.ListItemRadioButton(this.f32283g, this.f32284h, composer, this.f32285i | 1);
    }
}
