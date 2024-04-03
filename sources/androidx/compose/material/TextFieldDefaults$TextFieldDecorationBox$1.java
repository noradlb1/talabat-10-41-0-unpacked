package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldDefaults$TextFieldDecorationBox$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldDefaults f5908g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f5909h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5910i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5911j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f5912k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f5913l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f5914m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f5915n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5916o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5917p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5918q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5919r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f5920s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f5921t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f5922u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f5923v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f5924w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$TextFieldDecorationBox$1(TextFieldDefaults textFieldDefaults, String str, Function2<? super Composer, ? super Integer, Unit> function2, boolean z11, boolean z12, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z13, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, TextFieldColors textFieldColors, PaddingValues paddingValues, int i11, int i12, int i13) {
        super(2);
        this.f5908g = textFieldDefaults;
        this.f5909h = str;
        this.f5910i = function2;
        this.f5911j = z11;
        this.f5912k = z12;
        this.f5913l = visualTransformation;
        this.f5914m = interactionSource;
        this.f5915n = z13;
        this.f5916o = function22;
        this.f5917p = function23;
        this.f5918q = function24;
        this.f5919r = function25;
        this.f5920s = textFieldColors;
        this.f5921t = paddingValues;
        this.f5922u = i11;
        this.f5923v = i12;
        this.f5924w = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        TextFieldDefaults textFieldDefaults = this.f5908g;
        TextFieldDefaults textFieldDefaults2 = textFieldDefaults;
        textFieldDefaults2.TextFieldDecorationBox(this.f5909h, this.f5910i, this.f5911j, this.f5912k, this.f5913l, this.f5914m, this.f5915n, this.f5916o, this.f5917p, this.f5918q, this.f5919r, this.f5920s, this.f5921t, composer2, this.f5922u | 1, this.f5923v, this.f5924w);
    }
}
