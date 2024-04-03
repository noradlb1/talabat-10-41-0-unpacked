package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.text.input.TextInputServiceAndroid", f = "TextInputServiceAndroid.android.kt", i = {0}, l = {204}, m = "textInputCommandEventLoop", n = {"this"}, s = {"L$0"})
public final class TextInputServiceAndroid$textInputCommandEventLoop$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f10215h;

    /* renamed from: i  reason: collision with root package name */
    public Object f10216i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f10217j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TextInputServiceAndroid f10218k;

    /* renamed from: l  reason: collision with root package name */
    public int f10219l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextInputServiceAndroid$textInputCommandEventLoop$1(TextInputServiceAndroid textInputServiceAndroid, Continuation<? super TextInputServiceAndroid$textInputCommandEventLoop$1> continuation) {
        super(continuation);
        this.f10218k = textInputServiceAndroid;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f10217j = obj;
        this.f10219l |= Integer.MIN_VALUE;
        return this.f10218k.textInputCommandEventLoop(this);
    }
}
