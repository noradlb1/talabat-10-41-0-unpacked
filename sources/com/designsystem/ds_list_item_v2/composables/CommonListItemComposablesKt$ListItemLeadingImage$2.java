package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CommonListItemComposablesKt$ListItemLeadingImage$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32170g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f32171h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f32172i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f32173j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32174k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f32175l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonListItemComposablesKt$ListItemLeadingImage$2(Modifier modifier, Integer num, float f11, boolean z11, int i11, int i12) {
        super(2);
        this.f32170g = modifier;
        this.f32171h = num;
        this.f32172i = f11;
        this.f32173j = z11;
        this.f32174k = i11;
        this.f32175l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CommonListItemComposablesKt.m8487ListItemLeadingImage942rkJo(this.f32170g, this.f32171h, this.f32172i, this.f32173j, composer, this.f32174k | 1, this.f32175l);
    }
}
