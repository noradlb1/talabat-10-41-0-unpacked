package com.designsystem.ds_list_item_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSMenuListItemKt$DSMenuListItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32014g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32015h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f32016i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f32017j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f32018k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f32019l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f32020m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSMenuListItemKt$DSMenuListItem$2(String str, boolean z11, Modifier modifier, String str2, Function1<? super Boolean, Unit> function1, int i11, int i12) {
        super(2);
        this.f32014g = str;
        this.f32015h = z11;
        this.f32016i = modifier;
        this.f32017j = str2;
        this.f32018k = function1;
        this.f32019l = i11;
        this.f32020m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSMenuListItemKt.DSMenuListItem(this.f32014g, this.f32015h, this.f32016i, this.f32017j, this.f32018k, composer, this.f32019l | 1, this.f32020m);
    }
}
