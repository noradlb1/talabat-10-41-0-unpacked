package com.designsystem.ds_list_item_v2;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSwitchListItem$Content$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSSwitchListItem f32119g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32120h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSwitchListItem$Content$2(DSSwitchListItem dSSwitchListItem, int i11) {
        super(2);
        this.f32119g = dSSwitchListItem;
        this.f32120h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f32119g.Content(composer, this.f32120h | 1);
    }
}
