package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ClickableTextKt$ClickableText$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnnotatedString f3342g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3343h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextStyle f3344i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f3345j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f3346k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f3347l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f3348m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f3349n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f3350o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f3351p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableTextKt$ClickableText$3(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, boolean z11, int i11, int i12, Function1<? super TextLayoutResult, Unit> function1, Function1<? super Integer, Unit> function12, int i13, int i14) {
        super(2);
        this.f3342g = annotatedString;
        this.f3343h = modifier;
        this.f3344i = textStyle;
        this.f3345j = z11;
        this.f3346k = i11;
        this.f3347l = i12;
        this.f3348m = function1;
        this.f3349n = function12;
        this.f3350o = i13;
        this.f3351p = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ClickableTextKt.m835ClickableText4YKlhWE(this.f3342g, this.f3343h, this.f3344i, this.f3345j, this.f3346k, this.f3347l, this.f3348m, this.f3349n, composer, this.f3350o | 1, this.f3351p);
    }
}
