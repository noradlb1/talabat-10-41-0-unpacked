package com.designsystem.ds_button_v2.composables;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_button_v2.DSButtonStyle;
import com.designsystem.ds_button_v2.DSButtonTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSButtonContentKt$DSButtonContent$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSButtonTheme f30852g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30853h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f30854i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f30855j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Integer f30856k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f30857l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f30858m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f30859n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f30860o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ DSButtonStyle f30861p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30862q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f30863r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f30864s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSButtonContentKt$DSButtonContent$3(DSButtonTheme dSButtonTheme, String str, Modifier modifier, String str2, Integer num, boolean z11, boolean z12, boolean z13, MutableInteractionSource mutableInteractionSource, DSButtonStyle dSButtonStyle, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f30852g = dSButtonTheme;
        this.f30853h = str;
        this.f30854i = modifier;
        this.f30855j = str2;
        this.f30856k = num;
        this.f30857l = z11;
        this.f30858m = z12;
        this.f30859n = z13;
        this.f30860o = mutableInteractionSource;
        this.f30861p = dSButtonStyle;
        this.f30862q = function0;
        this.f30863r = i11;
        this.f30864s = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSButtonContentKt.DSButtonContent(this.f30852g, this.f30853h, this.f30854i, this.f30855j, this.f30856k, this.f30857l, this.f30858m, this.f30859n, this.f30860o, this.f30861p, this.f30862q, composer, this.f30863r | 1, this.f30864s);
    }
}
