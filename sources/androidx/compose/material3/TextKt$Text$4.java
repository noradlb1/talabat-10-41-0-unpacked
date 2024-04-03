package androidx.compose.material3;

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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextKt$Text$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnnotatedString f8984g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f8985h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f8986i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f8987j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FontStyle f8988k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FontWeight f8989l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FontFamily f8990m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f8991n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ TextDecoration f8992o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ TextAlign f8993p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ long f8994q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f8995r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ boolean f8996s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f8997t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Map<String, InlineTextContent> f8998u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f8999v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ TextStyle f9000w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f9001x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f9002y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ int f9003z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextKt$Text$4(AnnotatedString annotatedString, Modifier modifier, long j11, long j12, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j13, TextDecoration textDecoration, TextAlign textAlign, long j14, int i11, boolean z11, int i12, Map<String, InlineTextContent> map, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, int i13, int i14, int i15) {
        super(2);
        this.f8984g = annotatedString;
        this.f8985h = modifier;
        this.f8986i = j11;
        this.f8987j = j12;
        this.f8988k = fontStyle;
        this.f8989l = fontWeight;
        this.f8990m = fontFamily;
        this.f8991n = j13;
        this.f8992o = textDecoration;
        this.f8993p = textAlign;
        this.f8994q = j14;
        this.f8995r = i11;
        this.f8996s = z11;
        this.f8997t = i12;
        this.f8998u = map;
        this.f8999v = function1;
        this.f9000w = textStyle;
        this.f9001x = i13;
        this.f9002y = i14;
        this.f9003z = i15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        AnnotatedString annotatedString = this.f8984g;
        AnnotatedString annotatedString2 = annotatedString;
        TextKt.m1937Text4IGK_g(annotatedString2, this.f8985h, this.f8986i, this.f8987j, this.f8988k, this.f8989l, this.f8990m, this.f8991n, this.f8992o, this.f8993p, this.f8994q, this.f8995r, this.f8996s, this.f8997t, this.f8998u, this.f8999v, this.f9000w, composer2, this.f9001x | 1, this.f9002y, this.f9003z);
    }
}
