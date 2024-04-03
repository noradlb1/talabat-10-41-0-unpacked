package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt$ListItemCheckbox$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f32265g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32266h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32267i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableListItemComposablesKt$ListItemCheckbox$1(boolean z11, boolean z12, int i11) {
        super(2);
        this.f32265g = z11;
        this.f32266h = z12;
        this.f32267i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SelectableListItemComposablesKt.ListItemCheckbox(this.f32265g, this.f32266h, composer, this.f32267i | 1);
    }
}
