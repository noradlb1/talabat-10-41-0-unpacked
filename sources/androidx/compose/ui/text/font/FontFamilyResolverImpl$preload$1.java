package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.text.font.FontFamilyResolverImpl", f = "FontFamilyResolver.kt", i = {0, 0}, l = {47}, m = "preload", n = {"this", "fontFamily"}, s = {"L$0", "L$1"})
public final class FontFamilyResolverImpl$preload$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f10180h;

    /* renamed from: i  reason: collision with root package name */
    public Object f10181i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f10182j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FontFamilyResolverImpl f10183k;

    /* renamed from: l  reason: collision with root package name */
    public int f10184l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FontFamilyResolverImpl$preload$1(FontFamilyResolverImpl fontFamilyResolverImpl, Continuation<? super FontFamilyResolverImpl$preload$1> continuation) {
        super(continuation);
        this.f10183k = fontFamilyResolverImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f10182j = obj;
        this.f10184l |= Integer.MIN_VALUE;
        return this.f10183k.preload((FontFamily) null, this);
    }
}
