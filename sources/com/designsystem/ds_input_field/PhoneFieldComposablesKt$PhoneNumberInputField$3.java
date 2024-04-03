package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_input_field.country.DSCountryModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class PhoneFieldComposablesKt$PhoneNumberInputField$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31840g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31841h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31842i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<DSCountryModel, String, Unit> f31843j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<DSCountryModel, String, Unit> f31844k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f31845l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31846m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ OuterState f31847n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ ImeAction f31848o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f31849p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ String f31850q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ String f31851r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ String f31852s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f31853t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f31854u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f31855v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneFieldComposablesKt$PhoneNumberInputField$3(Modifier modifier, String str, String str2, Function2<? super DSCountryModel, ? super String, Unit> function2, Function2<? super DSCountryModel, ? super String, Unit> function22, String str3, boolean z11, OuterState outerState, ImeAction imeAction, FragmentManager fragmentManager, String str4, String str5, String str6, int i11, int i12, int i13) {
        super(2);
        this.f31840g = modifier;
        this.f31841h = str;
        this.f31842i = str2;
        this.f31843j = function2;
        this.f31844k = function22;
        this.f31845l = str3;
        this.f31846m = z11;
        this.f31847n = outerState;
        this.f31848o = imeAction;
        this.f31849p = fragmentManager;
        this.f31850q = str4;
        this.f31851r = str5;
        this.f31852s = str6;
        this.f31853t = i11;
        this.f31854u = i12;
        this.f31855v = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Modifier modifier = this.f31840g;
        Modifier modifier2 = modifier;
        PhoneFieldComposablesKt.m8448PhoneNumberInputField4mkn5s(modifier2, this.f31841h, this.f31842i, this.f31843j, this.f31844k, this.f31845l, this.f31846m, this.f31847n, this.f31848o, this.f31849p, this.f31850q, this.f31851r, this.f31852s, composer, this.f31853t | 1, this.f31854u, this.f31855v);
    }
}
