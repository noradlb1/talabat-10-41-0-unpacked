package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.fragment.app.FragmentManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DateFieldComposablesKt$DateInputField$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31545g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Long f31546h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31547i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31548j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f31549k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<Long, Unit> f31550l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31551m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ OuterState f31552n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f31553o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Locale f31554p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Long f31555q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Long f31556r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f31557s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f31558t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f31559u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DateFieldComposablesKt$DateInputField$3(Modifier modifier, Long l11, String str, String str2, String str3, Function1<? super Long, Unit> function1, boolean z11, OuterState outerState, FragmentManager fragmentManager, Locale locale, Long l12, Long l13, int i11, int i12, int i13) {
        super(2);
        this.f31545g = modifier;
        this.f31546h = l11;
        this.f31547i = str;
        this.f31548j = str2;
        this.f31549k = str3;
        this.f31550l = function1;
        this.f31551m = z11;
        this.f31552n = outerState;
        this.f31553o = fragmentManager;
        this.f31554p = locale;
        this.f31555q = l12;
        this.f31556r = l13;
        this.f31557s = i11;
        this.f31558t = i12;
        this.f31559u = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DateFieldComposablesKt.DateInputField(this.f31545g, this.f31546h, this.f31547i, this.f31548j, this.f31549k, this.f31550l, this.f31551m, this.f31552n, this.f31553o, this.f31554p, this.f31555q, this.f31556r, composer, this.f31557s | 1, this.f31558t, this.f31559u);
    }
}
