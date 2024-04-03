package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldKeyInputKt$textFieldKeyInput$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3574g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3575h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f3576i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f3577j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f3578k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ OffsetMapping f3579l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ UndoManager f3580m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function1<TextFieldValue, Unit> f3581n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldKeyInputKt$textFieldKeyInput$2(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z11, boolean z12, OffsetMapping offsetMapping, UndoManager undoManager, Function1<? super TextFieldValue, Unit> function1) {
        super(3);
        this.f3574g = textFieldState;
        this.f3575h = textFieldSelectionManager;
        this.f3576i = textFieldValue;
        this.f3577j = z11;
        this.f3578k = z12;
        this.f3579l = offsetMapping;
        this.f3580m = undoManager;
        this.f3581n = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer2.startReplaceableGroup(58482146);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(58482146, i11, -1, "androidx.compose.foundation.text.textFieldKeyInput.<anonymous> (TextFieldKeyInput.kt:241)");
        }
        composer2.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TextPreparedSelectionState();
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(Modifier.Companion, new Function1<KeyEvent, Boolean>(new TextFieldKeyInput(this.f3574g, this.f3575h, this.f3576i, this.f3577j, this.f3578k, (TextPreparedSelectionState) rememberedValue, this.f3579l, this.f3580m, (KeyMapping) null, this.f3581n, 256, (DefaultConstructorMarker) null)) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m914invokeZmokQxo(((KeyEvent) obj).m4172unboximpl());
            }

            @NotNull
            /* renamed from: invoke-ZmokQxo  reason: not valid java name */
            public final Boolean m914invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
                Intrinsics.checkNotNullParameter(keyEvent, "p0");
                return Boolean.valueOf(((TextFieldKeyInput) this.receiver).m913processZmokQxo(keyEvent));
            }
        });
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return onKeyEvent;
    }
}
