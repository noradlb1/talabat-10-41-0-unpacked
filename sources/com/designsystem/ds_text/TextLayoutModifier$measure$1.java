package com.designsystem.ds_text;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class TextLayoutModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f33131g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f33132h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f33133i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextLayoutModifier$measure$1(Placeable placeable, int i11, float f11) {
        super(1);
        this.f33131g = placeable;
        this.f33132h = i11;
        this.f33133i = f11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(placementScope, this.f33131g, 0, (int) (((float) this.f33132h) - this.f33133i), 0.0f, 4, (Object) null);
    }
}
