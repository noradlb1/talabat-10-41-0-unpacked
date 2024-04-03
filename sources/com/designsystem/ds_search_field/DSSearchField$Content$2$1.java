package com.designsystem.ds_search_field;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSearchField$Content$2$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSSearchField f32570g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSearchField$Content$2$1(DSSearchField dSSearchField) {
        super(0);
        this.f32570g = dSSearchField;
    }

    public final void invoke() {
        this.f32570g.setText("");
        Function0<Unit> onClearButtonTap = this.f32570g.getOnClearButtonTap();
        if (onClearButtonTap != null) {
            onClearButtonTap.invoke();
        }
    }
}
