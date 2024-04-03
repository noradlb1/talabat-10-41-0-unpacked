package com.designsystem.ds_search_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SearchFieldComposablesKt$SearchFieldDecorationBox$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32625g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32626h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f32627i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32628j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32629k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchFieldComposablesKt$SearchFieldDecorationBox$2(String str, String str2, Function2<? super Composer, ? super Integer, Unit> function2, Function0<Unit> function0, int i11) {
        super(2);
        this.f32625g = str;
        this.f32626h = str2;
        this.f32627i = function2;
        this.f32628j = function0;
        this.f32629k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SearchFieldComposablesKt.SearchFieldDecorationBox(this.f32625g, this.f32626h, this.f32627i, this.f32628j, composer, this.f32629k | 1);
    }
}
