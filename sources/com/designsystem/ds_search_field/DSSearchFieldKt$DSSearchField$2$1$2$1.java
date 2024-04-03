package com.designsystem.ds_search_field;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSearchFieldKt$DSSearchField$2$1$2$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<String> f32600g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<String> f32601h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSearchFieldKt$DSSearchField$2$1$2$1(MutableState<String> mutableState, MutableState<String> mutableState2) {
        super(1);
        this.f32600g = mutableState;
        this.f32601h = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        DSSearchFieldKt.m8554DSSearchField$lambda2(this.f32600g, str);
        DSSearchFieldKt.m8556DSSearchField$lambda5(this.f32601h, str);
    }
}
