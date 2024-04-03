package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.text.font.AsyncTypefaceCache", f = "FontListFontFamilyTypefaceAdapter.kt", i = {0, 0, 0}, l = {399}, m = "runCached", n = {"this", "key", "forever"}, s = {"L$0", "L$1", "Z$0"})
public final class AsyncTypefaceCache$runCached$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f10171h;

    /* renamed from: i  reason: collision with root package name */
    public Object f10172i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f10173j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f10174k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ AsyncTypefaceCache f10175l;

    /* renamed from: m  reason: collision with root package name */
    public int f10176m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncTypefaceCache$runCached$1(AsyncTypefaceCache asyncTypefaceCache, Continuation<? super AsyncTypefaceCache$runCached$1> continuation) {
        super(continuation);
        this.f10175l = asyncTypefaceCache;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f10174k = obj;
        this.f10176m |= Integer.MIN_VALUE;
        return this.f10175l.runCached((Font) null, (PlatformFontLoader) null, false, (Function1<? super Continuation<Object>, ? extends Object>) null, this);
    }
}
