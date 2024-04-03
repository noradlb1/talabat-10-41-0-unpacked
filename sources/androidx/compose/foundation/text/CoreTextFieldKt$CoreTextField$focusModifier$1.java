package androidx.compose.foundation.text;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$CoreTextField$focusModifier$1 extends Lambda implements Function1<FocusState, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3439g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextInputService f3440h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f3441i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ImeOptions f3442j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3443k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f3444l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BringIntoViewRequester f3445m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ OffsetMapping f3446n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$focusModifier$1(TextFieldState textFieldState, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope, BringIntoViewRequester bringIntoViewRequester, OffsetMapping offsetMapping) {
        super(1);
        this.f3439g = textFieldState;
        this.f3440h = textInputService;
        this.f3441i = textFieldValue;
        this.f3442j = imeOptions;
        this.f3443k = textFieldSelectionManager;
        this.f3444l = coroutineScope;
        this.f3445m = bringIntoViewRequester;
        this.f3446n = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FocusState focusState) {
        TextLayoutResultProxy layoutResult;
        Intrinsics.checkNotNullParameter(focusState, "it");
        if (this.f3439g.getHasFocus() != focusState.isFocused()) {
            this.f3439g.setHasFocus(focusState.isFocused());
            TextInputService textInputService = this.f3440h;
            if (textInputService != null) {
                CoreTextFieldKt.notifyTextInputServiceOnFocusChange(textInputService, this.f3439g, this.f3441i, this.f3442j);
                if (focusState.isFocused() && (layoutResult = this.f3439g.getLayoutResult()) != null) {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.f3444l, (CoroutineContext) null, (CoroutineStart) null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(this.f3445m, this.f3441i, this.f3439g, layoutResult, this.f3446n, (Continuation<? super CoreTextFieldKt$CoreTextField$focusModifier$1$1$1>) null), 3, (Object) null);
                }
            }
            if (!focusState.isFocused()) {
                TextFieldSelectionManager.m1045deselect_kEHs6E$foundation_release$default(this.f3443k, (Offset) null, 1, (Object) null);
            }
        }
    }
}
