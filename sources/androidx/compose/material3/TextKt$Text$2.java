package androidx.compose.material3;

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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextKt$Text$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f8965g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f8966h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f8967i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f8968j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FontStyle f8969k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FontWeight f8970l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FontFamily f8971m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f8972n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ TextDecoration f8973o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ TextAlign f8974p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ long f8975q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f8976r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ boolean f8977s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f8978t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f8979u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ TextStyle f8980v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f8981w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f8982x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f8983y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextKt$Text$2(String str, Modifier modifier, long j11, long j12, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j13, TextDecoration textDecoration, TextAlign textAlign, long j14, int i11, boolean z11, int i12, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, int i13, int i14, int i15) {
        super(2);
        this.f8965g = str;
        this.f8966h = modifier;
        this.f8967i = j11;
        this.f8968j = j12;
        this.f8969k = fontStyle;
        this.f8970l = fontWeight;
        this.f8971m = fontFamily;
        this.f8972n = j13;
        this.f8973o = textDecoration;
        this.f8974p = textAlign;
        this.f8975q = j14;
        this.f8976r = i11;
        this.f8977s = z11;
        this.f8978t = i12;
        this.f8979u = function1;
        this.f8980v = textStyle;
        this.f8981w = i13;
        this.f8982x = i14;
        this.f8983y = i15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        String str = this.f8965g;
        String str2 = str;
        TextKt.m1938TextfLXpl1I(str2, this.f8966h, this.f8967i, this.f8968j, this.f8969k, this.f8970l, this.f8971m, this.f8972n, this.f8973o, this.f8974p, this.f8975q, this.f8976r, this.f8977s, this.f8978t, this.f8979u, this.f8980v, composer2, this.f8981w | 1, this.f8982x, this.f8983y);
    }
}
