package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CommonListItemComposablesKt$ListItemLeadingIcon$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32165g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f32166h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32167i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32168j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32169k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonListItemComposablesKt$ListItemLeadingIcon$2(Modifier modifier, Integer num, boolean z11, int i11, int i12) {
        super(2);
        this.f32165g = modifier;
        this.f32166h = num;
        this.f32167i = z11;
        this.f32168j = i11;
        this.f32169k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CommonListItemComposablesKt.ListItemLeadingIcon(this.f32165g, this.f32166h, this.f32167i, composer, this.f32168j | 1, this.f32169k);
    }
}
