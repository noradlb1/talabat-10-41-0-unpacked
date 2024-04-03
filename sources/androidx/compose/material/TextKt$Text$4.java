package androidx.compose.material;

import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextKt$Text$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnnotatedString f6131g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6132h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f6133i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f6134j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FontStyle f6135k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FontWeight f6136l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FontFamily f6137m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f6138n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ TextDecoration f6139o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ TextAlign f6140p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ long f6141q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6142r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ boolean f6143s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f6144t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Map<String, InlineTextContent> f6145u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f6146v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6147w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f6148x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f6149y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ int f6150z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextKt$Text$4(AnnotatedString annotatedString, Modifier modifier, long j11, long j12, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j13, TextDecoration textDecoration, TextAlign textAlign, long j14, int i11, boolean z11, int i12, Map<String, InlineTextContent> map, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, int i13, int i14, int i15) {
        super(2);
        this.f6131g = annotatedString;
        this.f6132h = modifier;
        this.f6133i = j11;
        this.f6134j = j12;
        this.f6135k = fontStyle;
        this.f6136l = fontWeight;
        this.f6137m = fontFamily;
        this.f6138n = j13;
        this.f6139o = textDecoration;
        this.f6140p = textAlign;
        this.f6141q = j14;
        this.f6142r = i11;
        this.f6143s = z11;
        this.f6144t = i12;
        this.f6145u = map;
        this.f6146v = function1;
        this.f6147w = textStyle;
        this.f6148x = i13;
        this.f6149y = i14;
        this.f6150z = i15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        AnnotatedString annotatedString = this.f6131g;
        AnnotatedString annotatedString2 = annotatedString;
        TextKt.m1460Text4IGK_g(annotatedString2, this.f6132h, this.f6133i, this.f6134j, this.f6135k, this.f6136l, this.f6137m, this.f6138n, this.f6139o, this.f6140p, this.f6141q, this.f6142r, this.f6143s, this.f6144t, this.f6145u, this.f6146v, this.f6147w, composer2, this.f6148x | 1, this.f6149y, this.f6150z);
    }
}
