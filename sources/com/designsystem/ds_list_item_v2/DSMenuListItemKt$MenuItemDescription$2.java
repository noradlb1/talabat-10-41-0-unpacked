package com.designsystem.ds_list_item_v2;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSMenuListItemKt$MenuItemDescription$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32021g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32022h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSMenuListItemKt$MenuItemDescription$2(String str, int i11) {
        super(2);
        this.f32021g = str;
        this.f32022h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSMenuListItemKt.MenuItemDescription(this.f32021g, composer, this.f32022h | 1);
    }
}
