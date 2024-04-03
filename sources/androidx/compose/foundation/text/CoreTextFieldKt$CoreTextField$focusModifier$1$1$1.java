package androidx.compose.foundation.text;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1$1", f = "CoreTextField.kt", i = {}, l = {302}, m = "invokeSuspend", n = {}, s = {})
public final class CoreTextFieldKt$CoreTextField$focusModifier$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f3447h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BringIntoViewRequester f3448i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f3449j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3450k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextLayoutResultProxy f3451l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ OffsetMapping f3452m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextFieldState textFieldState, TextLayoutResultProxy textLayoutResultProxy, OffsetMapping offsetMapping, Continuation<? super CoreTextFieldKt$CoreTextField$focusModifier$1$1$1> continuation) {
        super(2, continuation);
        this.f3448i = bringIntoViewRequester;
        this.f3449j = textFieldValue;
        this.f3450k = textFieldState;
        this.f3451l = textLayoutResultProxy;
        this.f3452m = offsetMapping;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(this.f3448i, this.f3449j, this.f3450k, this.f3451l, this.f3452m, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CoreTextFieldKt$CoreTextField$focusModifier$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f3447h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            BringIntoViewRequester bringIntoViewRequester = this.f3448i;
            TextFieldValue textFieldValue = this.f3449j;
            TextDelegate textDelegate = this.f3450k.getTextDelegate();
            TextLayoutResult value = this.f3451l.getValue();
            OffsetMapping offsetMapping = this.f3452m;
            this.f3447h = 1;
            if (CoreTextFieldKt.bringSelectionEndIntoView(bringIntoViewRequester, textFieldValue, textDelegate, value, offsetMapping, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
