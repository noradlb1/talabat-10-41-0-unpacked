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
public final class TextFieldDefaults$OutlinedTextFieldDecorationBox$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldDefaults f8682g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f8683h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8684i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f8685j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f8686k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f8687l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f8688m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f8689n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8690o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8691p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8692q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8693r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8694s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f8695t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f8696u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8697v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f8698w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f8699x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f8700y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$OutlinedTextFieldDecorationBox$2(TextFieldDefaults textFieldDefaults, String str, Function2<? super Composer, ? super Integer, Unit> function2, boolean z11, boolean z12, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z13, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function27, int i11, int i12, int i13) {
        super(2);
        this.f8682g = textFieldDefaults;
        this.f8683h = str;
        this.f8684i = function2;
        this.f8685j = z11;
        this.f8686k = z12;
        this.f8687l = visualTransformation;
        this.f8688m = interactionSource;
        this.f8689n = z13;
        this.f8690o = function22;
        this.f8691p = function23;
        this.f8692q = function24;
        this.f8693r = function25;
        this.f8694s = function26;
        this.f8695t = textFieldColors;
        this.f8696u = paddingValues;
        this.f8697v = function27;
        this.f8698w = i11;
        this.f8699x = i12;
        this.f8700y = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        TextFieldDefaults textFieldDefaults = this.f8682g;
        TextFieldDefaults textFieldDefaults2 = textFieldDefaults;
        textFieldDefaults2.OutlinedTextFieldDecorationBox(this.f8683h, this.f8684i, this.f8685j, this.f8686k, this.f8687l, this.f8688m, this.f8689n, this.f8690o, this.f8691p, this.f8692q, this.f8693r, this.f8694s, this.f8695t, this.f8696u, this.f8697v, composer2, this.f8698w | 1, this.f8699x, this.f8700y);
    }
}
