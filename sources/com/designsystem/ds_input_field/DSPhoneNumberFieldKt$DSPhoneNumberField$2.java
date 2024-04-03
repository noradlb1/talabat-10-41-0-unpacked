package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_input_field.country.DSCountryModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSPhoneNumberFieldKt$DSPhoneNumberField$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31456g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31457h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31458i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<DSCountryModel, String, Unit> f31459j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<DSCountryModel, String, Unit> f31460k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f31461l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31462m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ DSInputFieldState f31463n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f31464o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f31465p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ String f31466q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ String f31467r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ String f31468s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f31469t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f31470u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f31471v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPhoneNumberFieldKt$DSPhoneNumberField$2(Modifier modifier, String str, String str2, Function2<? super DSCountryModel, ? super String, Unit> function2, Function2<? super DSCountryModel, ? super String, Unit> function22, String str3, boolean z11, DSInputFieldState dSInputFieldState, int i11, FragmentManager fragmentManager, String str4, String str5, String str6, int i12, int i13, int i14) {
        super(2);
        this.f31456g = modifier;
        this.f31457h = str;
        this.f31458i = str2;
        this.f31459j = function2;
        this.f31460k = function22;
        this.f31461l = str3;
        this.f31462m = z11;
        this.f31463n = dSInputFieldState;
        this.f31464o = i11;
        this.f31465p = fragmentManager;
        this.f31466q = str4;
        this.f31467r = str5;
        this.f31468s = str6;
        this.f31469t = i12;
        this.f31470u = i13;
        this.f31471v = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Modifier modifier = this.f31456g;
        Modifier modifier2 = modifier;
        DSPhoneNumberFieldKt.m8379DSPhoneNumberFieldMmlCLH8(modifier2, this.f31457h, this.f31458i, this.f31459j, this.f31460k, this.f31461l, this.f31462m, this.f31463n, this.f31464o, this.f31465p, this.f31466q, this.f31467r, this.f31468s, composer, this.f31469t | 1, this.f31470u, this.f31471v);
    }
}
