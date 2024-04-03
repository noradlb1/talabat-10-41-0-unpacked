package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt$ListItemPriceText$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32279g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32280h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32281i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32282j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableListItemComposablesKt$ListItemPriceText$3(Modifier modifier, String str, boolean z11, int i11) {
        super(2);
        this.f32279g = modifier;
        this.f32280h = str;
        this.f32281i = z11;
        this.f32282j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SelectableListItemComposablesKt.ListItemPriceText(this.f32279g, this.f32280h, this.f32281i, composer, this.f32282j | 1);
    }
}
