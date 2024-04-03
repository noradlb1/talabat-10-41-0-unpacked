package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CommonListItemComposablesKt$ListItemLeadingWidget$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32176g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f32177h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Integer f32178i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f32179j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f32180k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f32181l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f32182m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonListItemComposablesKt$ListItemLeadingWidget$2(Modifier modifier, Integer num, Integer num2, float f11, boolean z11, int i11, int i12) {
        super(2);
        this.f32176g = modifier;
        this.f32177h = num;
        this.f32178i = num2;
        this.f32179j = f11;
        this.f32180k = z11;
        this.f32181l = i11;
        this.f32182m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CommonListItemComposablesKt.m8488ListItemLeadingWidgethGBTI10(this.f32176g, this.f32177h, this.f32178i, this.f32179j, this.f32180k, composer, this.f32181l | 1, this.f32182m);
    }
}
