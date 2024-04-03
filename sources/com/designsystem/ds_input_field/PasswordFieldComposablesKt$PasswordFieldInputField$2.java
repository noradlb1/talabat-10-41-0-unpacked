package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class PasswordFieldComposablesKt$PasswordFieldInputField$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31771g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31772h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31773i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31774j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31775k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31776l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ OuterState f31777m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ImeAction f31778n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f31779o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f31780p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PasswordFieldComposablesKt$PasswordFieldInputField$2(Modifier modifier, String str, String str2, String str3, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, OuterState outerState, ImeAction imeAction, int i11, int i12) {
        super(2);
        this.f31771g = modifier;
        this.f31772h = str;
        this.f31773i = str2;
        this.f31774j = str3;
        this.f31775k = function1;
        this.f31776l = function12;
        this.f31777m = outerState;
        this.f31778n = imeAction;
        this.f31779o = i11;
        this.f31780p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        PasswordFieldComposablesKt.m8443PasswordFieldInputFieldtulg0WA(this.f31771g, this.f31772h, this.f31773i, this.f31774j, this.f31775k, this.f31776l, this.f31777m, this.f31778n, composer, this.f31779o | 1, this.f31780p);
    }
}
