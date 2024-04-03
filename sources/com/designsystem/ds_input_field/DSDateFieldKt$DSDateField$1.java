package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
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
public final class DSDateFieldKt$DSDateField$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31387g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Long f31388h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31389i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31390j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f31391k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<Long, Unit> f31392l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31393m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ DSInputFieldState f31394n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f31395o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Locale f31396p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Long f31397q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Long f31398r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f31399s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f31400t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSDateFieldKt$DSDateField$1(Modifier modifier, Long l11, String str, String str2, String str3, Function1<? super Long, Unit> function1, boolean z11, DSInputFieldState dSInputFieldState, FragmentManager fragmentManager, Locale locale, Long l12, Long l13, int i11, int i12) {
        super(2);
        this.f31387g = modifier;
        this.f31388h = l11;
        this.f31389i = str;
        this.f31390j = str2;
        this.f31391k = str3;
        this.f31392l = function1;
        this.f31393m = z11;
        this.f31394n = dSInputFieldState;
        this.f31395o = fragmentManager;
        this.f31396p = locale;
        this.f31397q = l12;
        this.f31398r = l13;
        this.f31399s = i11;
        this.f31400t = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f31387g;
            Long l11 = this.f31388h;
            String str = this.f31389i;
            String str2 = this.f31390j;
            String str3 = this.f31391k;
            Function1<Long, Unit> function1 = this.f31392l;
            boolean z11 = this.f31393m;
            DSInputFieldState dSInputFieldState = this.f31394n;
            FragmentManager fragmentManager = this.f31395o;
            Locale locale = this.f31396p;
            Long l12 = this.f31397q;
            Long l13 = this.f31398r;
            int i12 = this.f31399s;
            int i13 = (i12 & 14) | 1207959552 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (i12 & 29360128);
            int i14 = this.f31400t;
            DateFieldComposablesKt.DateInputField(modifier, l11, str, str2, str3, function1, z11, dSInputFieldState, fragmentManager, locale, l12, l13, composer, i13, (i14 & 14) | (i14 & 112), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
