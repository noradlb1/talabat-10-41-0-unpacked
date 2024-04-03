package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$CoreTextField$semanticsModifier$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImeOptions f3462g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TransformedText f3463h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f3464i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f3465j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f3466k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f3467l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3468m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ OffsetMapping f3469n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3470o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ FocusRequester f3471p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$semanticsModifier$1(ImeOptions imeOptions, TransformedText transformedText, TextFieldValue textFieldValue, boolean z11, boolean z12, boolean z13, TextFieldState textFieldState, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, FocusRequester focusRequester) {
        super(1);
        this.f3462g = imeOptions;
        this.f3463h = transformedText;
        this.f3464i = textFieldValue;
        this.f3465j = z11;
        this.f3466k = z12;
        this.f3467l = z13;
        this.f3468m = textFieldState;
        this.f3469n = offsetMapping;
        this.f3470o = textFieldSelectionManager;
        this.f3471p = focusRequester;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.m4922setImeAction4L7nppU(semanticsPropertyReceiver, this.f3462g.m5198getImeActioneUduSuo());
        SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, this.f3463h.getText());
        SemanticsPropertiesKt.m4925setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, this.f3464i.m5234getSelectiond9O1mEE());
        if (!this.f3465j) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        if (this.f3466k) {
            SemanticsPropertiesKt.password(semanticsPropertyReceiver);
        }
        final TextFieldState textFieldState = this.f3468m;
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, (String) null, new Function1<List<TextLayoutResult>, Boolean>() {
            @NotNull
            public final Boolean invoke(@NotNull List<TextLayoutResult> list) {
                boolean z11;
                Intrinsics.checkNotNullParameter(list, "it");
                if (textFieldState.getLayoutResult() != null) {
                    TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                    Intrinsics.checkNotNull(layoutResult);
                    list.add(layoutResult.getValue());
                    z11 = true;
                } else {
                    z11 = false;
                }
                return Boolean.valueOf(z11);
            }
        }, 1, (Object) null);
        final TextFieldState textFieldState2 = this.f3468m;
        SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, (String) null, new Function1<AnnotatedString, Boolean>() {
            @NotNull
            public final Boolean invoke(@NotNull AnnotatedString annotatedString) {
                Intrinsics.checkNotNullParameter(annotatedString, "it");
                textFieldState2.getOnValueChange().invoke(new TextFieldValue(annotatedString.getText(), TextRangeKt.TextRange(annotatedString.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                return Boolean.TRUE;
            }
        }, 1, (Object) null);
        final OffsetMapping offsetMapping = this.f3469n;
        final boolean z11 = this.f3465j;
        final TextFieldValue textFieldValue = this.f3464i;
        final TextFieldSelectionManager textFieldSelectionManager = this.f3470o;
        final TextFieldState textFieldState3 = this.f3468m;
        SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, (String) null, new Function3<Integer, Integer, Boolean, Boolean>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Boolean) obj3).booleanValue());
            }

            @NotNull
            public final Boolean invoke(int i11, int i12, boolean z11) {
                if (!z11) {
                    i11 = offsetMapping.transformedToOriginal(i11);
                }
                if (!z11) {
                    i12 = offsetMapping.transformedToOriginal(i12);
                }
                boolean z12 = false;
                if (z11 && !(i11 == TextRange.m5038getStartimpl(textFieldValue.m5234getSelectiond9O1mEE()) && i12 == TextRange.m5033getEndimpl(textFieldValue.m5234getSelectiond9O1mEE()))) {
                    if (RangesKt___RangesKt.coerceAtMost(i11, i12) < 0 || RangesKt___RangesKt.coerceAtLeast(i11, i12) > textFieldValue.getAnnotatedString().length()) {
                        textFieldSelectionManager.exitSelectionMode$foundation_release();
                    } else {
                        if (z11 || i11 == i12) {
                            textFieldSelectionManager.exitSelectionMode$foundation_release();
                        } else {
                            textFieldSelectionManager.enterSelectionMode$foundation_release();
                        }
                        textFieldState3.getOnValueChange().invoke(new TextFieldValue(textFieldValue.getAnnotatedString(), TextRangeKt.TextRange(i11, i12), (TextRange) null, 4, (DefaultConstructorMarker) null));
                        z12 = true;
                    }
                }
                return Boolean.valueOf(z12);
            }
        }, 1, (Object) null);
        final TextFieldState textFieldState4 = this.f3468m;
        final FocusRequester focusRequester = this.f3471p;
        final boolean z12 = this.f3467l;
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
            @NotNull
            public final Boolean invoke() {
                CoreTextFieldKt.tapToFocus(textFieldState4, focusRequester, !z12);
                return Boolean.TRUE;
            }
        }, 1, (Object) null);
        final TextFieldSelectionManager textFieldSelectionManager2 = this.f3470o;
        SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
            @NotNull
            public final Boolean invoke() {
                textFieldSelectionManager2.enterSelectionMode$foundation_release();
                return Boolean.TRUE;
            }
        }, 1, (Object) null);
        if (!TextRange.m5032getCollapsedimpl(this.f3464i.m5234getSelectiond9O1mEE()) && !this.f3466k) {
            final TextFieldSelectionManager textFieldSelectionManager3 = this.f3470o;
            SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
                @NotNull
                public final Boolean invoke() {
                    TextFieldSelectionManager.copy$foundation_release$default(textFieldSelectionManager3, false, 1, (Object) null);
                    return Boolean.TRUE;
                }
            }, 1, (Object) null);
            if (this.f3465j && !this.f3467l) {
                final TextFieldSelectionManager textFieldSelectionManager4 = this.f3470o;
                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
                    @NotNull
                    public final Boolean invoke() {
                        textFieldSelectionManager4.cut$foundation_release();
                        return Boolean.TRUE;
                    }
                }, 1, (Object) null);
            }
        }
        if (this.f3465j && !this.f3467l) {
            final TextFieldSelectionManager textFieldSelectionManager5 = this.f3470o;
            SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
                @NotNull
                public final Boolean invoke() {
                    textFieldSelectionManager5.paste$foundation_release();
                    return Boolean.TRUE;
                }
            }, 1, (Object) null);
        }
    }
}
