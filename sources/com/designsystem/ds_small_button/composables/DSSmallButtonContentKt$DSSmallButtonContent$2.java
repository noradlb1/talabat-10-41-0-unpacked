package com.designsystem.ds_small_button.composables;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_button_v2.DSButtonTheme;
import com.designsystem.ds_small_button.DSSmallButtonStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSmallButtonContentKt$DSSmallButtonContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSButtonTheme f32753g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32754h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f32755i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f32756j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f32757k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f32758l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f32759m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f32760n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ DSSmallButtonStyle f32761o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32762p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f32763q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSmallButtonContentKt$DSSmallButtonContent$2(DSButtonTheme dSButtonTheme, String str, Modifier modifier, Integer num, boolean z11, boolean z12, boolean z13, MutableInteractionSource mutableInteractionSource, DSSmallButtonStyle dSSmallButtonStyle, Function0<Unit> function0, int i11) {
        super(2);
        this.f32753g = dSButtonTheme;
        this.f32754h = str;
        this.f32755i = modifier;
        this.f32756j = num;
        this.f32757k = z11;
        this.f32758l = z12;
        this.f32759m = z13;
        this.f32760n = mutableInteractionSource;
        this.f32761o = dSSmallButtonStyle;
        this.f32762p = function0;
        this.f32763q = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSSmallButtonContentKt.DSSmallButtonContent(this.f32753g, this.f32754h, this.f32755i, this.f32756j, this.f32757k, this.f32758l, this.f32759m, this.f32760n, this.f32761o, this.f32762p, composer, this.f32763q | 1);
    }
}
