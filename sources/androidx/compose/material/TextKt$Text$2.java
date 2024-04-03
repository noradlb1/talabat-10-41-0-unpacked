package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextKt$Text$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f6112g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6113h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f6114i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f6115j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FontStyle f6116k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FontWeight f6117l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FontFamily f6118m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f6119n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ TextDecoration f6120o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ TextAlign f6121p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ long f6122q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6123r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ boolean f6124s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f6125t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f6126u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6127v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f6128w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f6129x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f6130y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextKt$Text$2(String str, Modifier modifier, long j11, long j12, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j13, TextDecoration textDecoration, TextAlign textAlign, long j14, int i11, boolean z11, int i12, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, int i13, int i14, int i15) {
        super(2);
        this.f6112g = str;
        this.f6113h = modifier;
        this.f6114i = j11;
        this.f6115j = j12;
        this.f6116k = fontStyle;
        this.f6117l = fontWeight;
        this.f6118m = fontFamily;
        this.f6119n = j13;
        this.f6120o = textDecoration;
        this.f6121p = textAlign;
        this.f6122q = j14;
        this.f6123r = i11;
        this.f6124s = z11;
        this.f6125t = i12;
        this.f6126u = function1;
        this.f6127v = textStyle;
        this.f6128w = i13;
        this.f6129x = i14;
        this.f6130y = i15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        String str = this.f6112g;
        String str2 = str;
        TextKt.m1461TextfLXpl1I(str2, this.f6113h, this.f6114i, this.f6115j, this.f6116k, this.f6117l, this.f6118m, this.f6119n, this.f6120o, this.f6121p, this.f6122q, this.f6123r, this.f6124s, this.f6125t, this.f6126u, this.f6127v, composer2, this.f6128w | 1, this.f6129x, this.f6130y);
    }
}
