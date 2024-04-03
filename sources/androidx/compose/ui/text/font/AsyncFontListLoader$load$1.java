package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.text.font.AsyncFontListLoader", f = "FontListFontFamilyTypefaceAdapter.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {272, 285}, m = "load", n = {"this", "$this$fastForEach$iv", "font", "index$iv", "this", "$this$fastForEach$iv", "index$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
public final class AsyncFontListLoader$load$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f10153h;

    /* renamed from: i  reason: collision with root package name */
    public Object f10154i;

    /* renamed from: j  reason: collision with root package name */
    public Object f10155j;

    /* renamed from: k  reason: collision with root package name */
    public int f10156k;

    /* renamed from: l  reason: collision with root package name */
    public int f10157l;

    /* renamed from: m  reason: collision with root package name */
    public /* synthetic */ Object f10158m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ AsyncFontListLoader f10159n;

    /* renamed from: o  reason: collision with root package name */
    public int f10160o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncFontListLoader$load$1(AsyncFontListLoader asyncFontListLoader, Continuation<? super AsyncFontListLoader$load$1> continuation) {
        super(continuation);
        this.f10159n = asyncFontListLoader;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f10158m = obj;
        this.f10160o |= Integer.MIN_VALUE;
        return this.f10159n.load(this);
    }
}
