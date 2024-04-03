package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.text.font.AsyncFontListLoader", f = "FontListFontFamilyTypefaceAdapter.kt", i = {0}, l = {304}, m = "loadWithTimeoutOrNull$ui_text_release", n = {"$this$loadWithTimeoutOrNull"}, s = {"L$0"})
public final class AsyncFontListLoader$loadWithTimeoutOrNull$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f10164h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f10165i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AsyncFontListLoader f10166j;

    /* renamed from: k  reason: collision with root package name */
    public int f10167k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncFontListLoader$loadWithTimeoutOrNull$1(AsyncFontListLoader asyncFontListLoader, Continuation<? super AsyncFontListLoader$loadWithTimeoutOrNull$1> continuation) {
        super(continuation);
        this.f10166j = asyncFontListLoader;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f10165i = obj;
        this.f10167k |= Integer.MIN_VALUE;
        return this.f10166j.loadWithTimeoutOrNull$ui_text_release((Font) null, this);
    }
}
