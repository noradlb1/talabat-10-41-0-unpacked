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
public final class DSDateFieldKt$DSDateField$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31401g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Long f31402h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31403i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31404j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f31405k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<Long, Unit> f31406l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31407m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ DSInputFieldState f31408n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f31409o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Locale f31410p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Long f31411q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Long f31412r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f31413s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f31414t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f31415u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSDateFieldKt$DSDateField$2(Modifier modifier, Long l11, String str, String str2, String str3, Function1<? super Long, Unit> function1, boolean z11, DSInputFieldState dSInputFieldState, FragmentManager fragmentManager, Locale locale, Long l12, Long l13, int i11, int i12, int i13) {
        super(2);
        this.f31401g = modifier;
        this.f31402h = l11;
        this.f31403i = str;
        this.f31404j = str2;
        this.f31405k = str3;
        this.f31406l = function1;
        this.f31407m = z11;
        this.f31408n = dSInputFieldState;
        this.f31409o = fragmentManager;
        this.f31410p = locale;
        this.f31411q = l12;
        this.f31412r = l13;
        this.f31413s = i11;
        this.f31414t = i12;
        this.f31415u = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSDateFieldKt.DSDateField(this.f31401g, this.f31402h, this.f31403i, this.f31404j, this.f31405k, this.f31406l, this.f31407m, this.f31408n, this.f31409o, this.f31410p, this.f31411q, this.f31412r, composer, this.f31413s | 1, this.f31414t, this.f31415u);
    }
}
