package com.designsystem.ds_search_field;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSearchField$Content$1$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSSearchField f32569g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSearchField$Content$1$1(DSSearchField dSSearchField) {
        super(1);
        this.f32569g = dSSearchField;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.f32569g.setText(str);
        Function1<String, Unit> onTextChange = this.f32569g.getOnTextChange();
        if (onTextChange != null) {
            onTextChange.invoke(str);
        }
    }
}
