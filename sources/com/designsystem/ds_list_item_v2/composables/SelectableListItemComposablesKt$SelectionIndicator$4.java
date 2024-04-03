package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt$SelectionIndicator$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32312g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32313h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32314i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32315j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32316k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableListItemComposablesKt$SelectionIndicator$4(Modifier modifier, boolean z11, boolean z12, int i11, int i12) {
        super(2);
        this.f32312g = modifier;
        this.f32313h = z11;
        this.f32314i = z12;
        this.f32315j = i11;
        this.f32316k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SelectableListItemComposablesKt.SelectionIndicator(this.f32312g, this.f32313h, this.f32314i, composer, this.f32315j | 1, this.f32316k);
    }
}
