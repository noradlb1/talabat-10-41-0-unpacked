package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CommonListItemComposablesKt$ListItemTopText$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32183g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32184h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32185i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32186j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonListItemComposablesKt$ListItemTopText$2(String str, String str2, boolean z11, int i11) {
        super(2);
        this.f32183g = str;
        this.f32184h = str2;
        this.f32185i = z11;
        this.f32186j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CommonListItemComposablesKt.ListItemTopText(this.f32183g, this.f32184h, this.f32185i, composer, this.f32186j | 1);
    }
}
