package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class SelectableListItemComposablesKt$selectable$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f32368g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f32369h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableListItemComposablesKt$selectable$1(MutableState<Boolean> mutableState, Function1<? super Boolean, Unit> function1) {
        super(0);
        this.f32368g = mutableState;
        this.f32369h = function1;
    }

    public final void invoke() {
        MutableState<Boolean> mutableState = this.f32368g;
        mutableState.setValue(Boolean.valueOf(!mutableState.getValue().booleanValue()));
        this.f32369h.invoke(this.f32368g.getValue());
    }
}
