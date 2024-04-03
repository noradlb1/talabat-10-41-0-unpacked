package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/graphics/Typeface;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.ui.text.font.AndroidFontLoader_androidKt$loadAsync$2", f = "AndroidFontLoader.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidFontLoader_androidKt$loadAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Typeface>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f10150h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ResourceFont f10151i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Context f10152j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidFontLoader_androidKt$loadAsync$2(ResourceFont resourceFont, Context context, Continuation<? super AndroidFontLoader_androidKt$loadAsync$2> continuation) {
        super(2, continuation);
        this.f10151i = resourceFont;
        this.f10152j = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AndroidFontLoader_androidKt$loadAsync$2(this.f10151i, this.f10152j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Typeface> continuation) {
        return ((AndroidFontLoader_androidKt$loadAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f10150h == 0) {
            ResultKt.throwOnFailure(obj);
            return AndroidFontLoader_androidKt.load(this.f10151i, this.f10152j);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
