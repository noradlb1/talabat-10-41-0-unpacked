package com.designsystem.ds_list_item_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSPhoneNumberCountryListItemKt$PhoneNumberCountryFlag$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32036g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f32037h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32038i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32039j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPhoneNumberCountryListItemKt$PhoneNumberCountryFlag$2(Modifier modifier, Integer num, int i11, int i12) {
        super(2);
        this.f32036g = modifier;
        this.f32037h = num;
        this.f32038i = i11;
        this.f32039j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSPhoneNumberCountryListItemKt.PhoneNumberCountryFlag(this.f32036g, this.f32037h, composer, this.f32038i | 1, this.f32039j);
    }
}
