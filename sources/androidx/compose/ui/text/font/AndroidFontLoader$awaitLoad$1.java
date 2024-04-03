package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.text.font.AndroidFontLoader", f = "AndroidFontLoader.android.kt", i = {1, 1}, l = {61, 62}, m = "awaitLoad", n = {"this", "font"}, s = {"L$0", "L$1"})
public final class AndroidFontLoader$awaitLoad$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f10145h;

    /* renamed from: i  reason: collision with root package name */
    public Object f10146i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f10147j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AndroidFontLoader f10148k;

    /* renamed from: l  reason: collision with root package name */
    public int f10149l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidFontLoader$awaitLoad$1(AndroidFontLoader androidFontLoader, Continuation<? super AndroidFontLoader$awaitLoad$1> continuation) {
        super(continuation);
        this.f10148k = androidFontLoader;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f10147j = obj;
        this.f10149l |= Integer.MIN_VALUE;
        return this.f10148k.awaitLoad((Font) null, this);
    }
}
