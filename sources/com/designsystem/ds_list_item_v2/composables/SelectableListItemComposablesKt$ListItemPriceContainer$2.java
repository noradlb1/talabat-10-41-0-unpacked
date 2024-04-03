package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt$ListItemPriceContainer$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32273g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32274h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32275i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32276j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32277k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableListItemComposablesKt$ListItemPriceContainer$2(String str, String str2, boolean z11, int i11, int i12) {
        super(2);
        this.f32273g = str;
        this.f32274h = str2;
        this.f32275i = z11;
        this.f32276j = i11;
        this.f32277k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SelectableListItemComposablesKt.ListItemPriceContainer(this.f32273g, this.f32274h, this.f32275i, composer, this.f32276j | 1, this.f32277k);
    }
}
