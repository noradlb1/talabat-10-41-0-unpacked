package com.designsystem.ds_search_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SearchFieldComposablesKt$SearchFieldTrailingIcon$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32633g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32634h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchFieldComposablesKt$SearchFieldTrailingIcon$2(Function0<Unit> function0, int i11) {
        super(2);
        this.f32633g = function0;
        this.f32634h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SearchFieldComposablesKt.SearchFieldTrailingIcon(this.f32633g, composer, this.f32634h | 1);
    }
}
