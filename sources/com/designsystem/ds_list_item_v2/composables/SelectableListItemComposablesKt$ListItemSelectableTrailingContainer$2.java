package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt$ListItemSelectableTrailingContainer$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32301g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32302h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f32303i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f32304j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f32305k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f32306l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f32307m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableListItemComposablesKt$ListItemSelectableTrailingContainer$2(String str, String str2, float f11, boolean z11, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f32301g = str;
        this.f32302h = str2;
        this.f32303i = f11;
        this.f32304j = z11;
        this.f32305k = function2;
        this.f32306l = i11;
        this.f32307m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SelectableListItemComposablesKt.m8491ListItemSelectableTrailingContainerTN_CM5M(this.f32301g, this.f32302h, this.f32303i, this.f32304j, this.f32305k, composer, this.f32306l | 1, this.f32307m);
    }
}
