package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt$ListItemOldPriceText$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32269g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32270h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32271i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32272j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableListItemComposablesKt$ListItemOldPriceText$3(Modifier modifier, String str, boolean z11, int i11) {
        super(2);
        this.f32269g = modifier;
        this.f32270h = str;
        this.f32271i = z11;
        this.f32272j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SelectableListItemComposablesKt.ListItemOldPriceText(this.f32269g, this.f32270h, this.f32271i, composer, this.f32272j | 1);
    }
}
