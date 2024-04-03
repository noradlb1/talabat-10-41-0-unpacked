package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldImplKt$CommonDecorationBox$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldType f8782g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f8783h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8784i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f8785j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8786k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8787l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8788m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8789n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8790o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f8791p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f8792q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f8793r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f8794s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f8795t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f8796u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8797v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f8798w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f8799x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f8800y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$CommonDecorationBox$4(TextFieldType textFieldType, String str, Function2<? super Composer, ? super Integer, Unit> function2, VisualTransformation visualTransformation, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z11, boolean z12, boolean z13, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, Function2<? super Composer, ? super Integer, Unit> function27, int i11, int i12, int i13) {
        super(2);
        this.f8782g = textFieldType;
        this.f8783h = str;
        this.f8784i = function2;
        this.f8785j = visualTransformation;
        this.f8786k = function22;
        this.f8787l = function23;
        this.f8788m = function24;
        this.f8789n = function25;
        this.f8790o = function26;
        this.f8791p = z11;
        this.f8792q = z12;
        this.f8793r = z13;
        this.f8794s = interactionSource;
        this.f8795t = paddingValues;
        this.f8796u = textFieldColors;
        this.f8797v = function27;
        this.f8798w = i11;
        this.f8799x = i12;
        this.f8800y = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        TextFieldType textFieldType = this.f8782g;
        TextFieldType textFieldType2 = textFieldType;
        TextFieldImplKt.CommonDecorationBox(textFieldType2, this.f8783h, this.f8784i, this.f8785j, this.f8786k, this.f8787l, this.f8788m, this.f8789n, this.f8790o, this.f8791p, this.f8792q, this.f8793r, this.f8794s, this.f8795t, this.f8796u, this.f8797v, composer2, this.f8798w | 1, this.f8799x, this.f8800y);
    }
}
