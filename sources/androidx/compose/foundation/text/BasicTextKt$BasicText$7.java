package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BasicTextKt$BasicText$7 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnnotatedString f3327g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3328h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextStyle f3329i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f3330j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f3331k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f3332l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f3333m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Map<String, InlineTextContent> f3334n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f3335o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f3336p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasicTextKt$BasicText$7(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i11, boolean z11, int i12, Map<String, InlineTextContent> map, int i13, int i14) {
        super(2);
        this.f3327g = annotatedString;
        this.f3328h = modifier;
        this.f3329i = textStyle;
        this.f3330j = function1;
        this.f3331k = i11;
        this.f3332l = z11;
        this.f3333m = i12;
        this.f3334n = map;
        this.f3335o = i13;
        this.f3336p = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BasicTextKt.m833BasicText4YKlhWE(this.f3327g, this.f3328h, this.f3329i, this.f3330j, this.f3331k, this.f3332l, this.f3333m, this.f3334n, composer, this.f3335o | 1, this.f3336p);
    }
}
