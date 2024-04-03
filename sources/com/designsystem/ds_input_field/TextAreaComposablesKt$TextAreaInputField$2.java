package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class TextAreaComposablesKt$TextAreaInputField$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31894g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31895h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31896i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31897j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31898k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31899l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31900m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ OuterState f31901n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Integer f31902o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ KeyboardType f31903p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ ImeAction f31904q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f31905r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f31906s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f31907t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextAreaComposablesKt$TextAreaInputField$2(Modifier modifier, String str, String str2, String str3, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z11, OuterState outerState, Integer num, KeyboardType keyboardType, ImeAction imeAction, int i11, int i12, int i13) {
        super(2);
        this.f31894g = modifier;
        this.f31895h = str;
        this.f31896i = str2;
        this.f31897j = str3;
        this.f31898k = function1;
        this.f31899l = function12;
        this.f31900m = z11;
        this.f31901n = outerState;
        this.f31902o = num;
        this.f31903p = keyboardType;
        this.f31904q = imeAction;
        this.f31905r = i11;
        this.f31906s = i12;
        this.f31907t = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TextAreaComposablesKt.m8469TextAreaInputFieldJIo6yoo(this.f31894g, this.f31895h, this.f31896i, this.f31897j, this.f31898k, this.f31899l, this.f31900m, this.f31901n, this.f31902o, this.f31903p, this.f31904q, composer, this.f31905r | 1, this.f31906s, this.f31907t);
    }
}
