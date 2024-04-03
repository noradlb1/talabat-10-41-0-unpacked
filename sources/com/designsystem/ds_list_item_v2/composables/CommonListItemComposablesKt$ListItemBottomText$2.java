package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CommonListItemComposablesKt$ListItemBottomText$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32161g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f32162h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32163i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32164j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonListItemComposablesKt$ListItemBottomText$2(String str, Integer num, boolean z11, int i11) {
        super(2);
        this.f32161g = str;
        this.f32162h = num;
        this.f32163i = z11;
        this.f32164j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CommonListItemComposablesKt.ListItemBottomText(this.f32161g, this.f32162h, this.f32163i, composer, this.f32164j | 1);
    }
}
