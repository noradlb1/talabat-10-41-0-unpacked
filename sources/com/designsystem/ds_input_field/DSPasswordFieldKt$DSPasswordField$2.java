package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSPasswordFieldKt$DSPasswordField$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31428g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31429h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31430i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31431j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31432k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31433l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ DSInputFieldState f31434m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f31435n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f31436o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f31437p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPasswordFieldKt$DSPasswordField$2(Modifier modifier, String str, String str2, String str3, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, DSInputFieldState dSInputFieldState, int i11, int i12, int i13) {
        super(2);
        this.f31428g = modifier;
        this.f31429h = str;
        this.f31430i = str2;
        this.f31431j = str3;
        this.f31432k = function1;
        this.f31433l = function12;
        this.f31434m = dSInputFieldState;
        this.f31435n = i11;
        this.f31436o = i12;
        this.f31437p = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSPasswordFieldKt.m8376DSPasswordFieldt0ssOgc(this.f31428g, this.f31429h, this.f31430i, this.f31431j, this.f31432k, this.f31433l, this.f31434m, this.f31435n, composer, this.f31436o | 1, this.f31437p);
    }
}
