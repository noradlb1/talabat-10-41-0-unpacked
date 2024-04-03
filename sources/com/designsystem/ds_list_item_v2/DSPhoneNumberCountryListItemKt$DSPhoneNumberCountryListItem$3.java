package com.designsystem.ds_list_item_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSPhoneNumberCountryListItemKt$DSPhoneNumberCountryListItem$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32029g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32030h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f32031i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f32032j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32033k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f32034l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f32035m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPhoneNumberCountryListItemKt$DSPhoneNumberCountryListItem$3(String str, String str2, Modifier modifier, Integer num, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f32029g = str;
        this.f32030h = str2;
        this.f32031i = modifier;
        this.f32032j = num;
        this.f32033k = function0;
        this.f32034l = i11;
        this.f32035m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSPhoneNumberCountryListItemKt.DSPhoneNumberCountryListItem(this.f32029g, this.f32030h, this.f32031i, this.f32032j, this.f32033k, composer, this.f32034l | 1, this.f32035m);
    }
}
