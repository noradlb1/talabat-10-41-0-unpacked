package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt$SelectionListItem$1$2$1$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<Boolean, Composer, Integer, Unit> f32347g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f32348h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32349i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableListItemComposablesKt$SelectionListItem$1$2$1$2(Function3<? super Boolean, ? super Composer, ? super Integer, Unit> function3, MutableState<Boolean> mutableState, int i11) {
        super(2);
        this.f32347g = function3;
        this.f32348h = mutableState;
        this.f32349i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            if (this.f32347g == null) {
                composer.startReplaceableGroup(1065199709);
            } else {
                composer.startReplaceableGroup(-935470044);
                this.f32347g.invoke(this.f32348h.getValue(), composer, Integer.valueOf((this.f32349i >> 9) & 112));
            }
            composer.endReplaceableGroup();
            return;
        }
        composer.skipToGroupEnd();
    }
}
