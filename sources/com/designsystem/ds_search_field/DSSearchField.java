package com.designsystem.ds_search_field;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AbstractComposeView;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u00106\u001a\u00020\u001aH\u0017¢\u0006\u0002\u00107R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R;\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198F@FX\u0002¢\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR;\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198F@FX\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0011\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fRG\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001a\u0018\u00010%2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001a\u0018\u00010%8F@FX\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0011\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R+\u0010,\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0011\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R+\u00100\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0011\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/designsystem/ds_search_field/DSSearchField;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "delay", "getDelay", "()J", "setDelay", "(J)V", "delay$delegate", "Landroidx/compose/runtime/MutableState;", "", "hint", "getHint", "()Ljava/lang/String;", "setHint", "(Ljava/lang/String;)V", "hint$delegate", "Lkotlin/Function0;", "", "onClearButtonTap", "getOnClearButtonTap", "()Lkotlin/jvm/functions/Function0;", "setOnClearButtonTap", "(Lkotlin/jvm/functions/Function0;)V", "onClearButtonTap$delegate", "onKeyboardSearchButtonTap", "getOnKeyboardSearchButtonTap", "setOnKeyboardSearchButtonTap", "onKeyboardSearchButtonTap$delegate", "Lkotlin/Function1;", "onTextChange", "getOnTextChange", "()Lkotlin/jvm/functions/Function1;", "setOnTextChange", "(Lkotlin/jvm/functions/Function1;)V", "onTextChange$delegate", "text", "getText", "setText", "text$delegate", "thresholdLetterCount", "getThresholdLetterCount", "()I", "setThresholdLetterCount", "(I)V", "thresholdLetterCount$delegate", "Content", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSSearchField extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState delay$delegate;
    @NotNull
    private final MutableState hint$delegate;
    @NotNull
    private final MutableState onClearButtonTap$delegate;
    @NotNull
    private final MutableState onKeyboardSearchButtonTap$delegate;
    @NotNull
    private final MutableState onTextChange$delegate;
    @NotNull
    private final MutableState text$delegate;
    @NotNull
    private final MutableState thresholdLetterCount$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSearchField(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSearchField(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSSearchField(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Content(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r14, int r15) {
        /*
            r13 = this;
            r0 = 469370964(0x1bfa0854, float:4.1364413E-22)
            androidx.compose.runtime.Composer r14 = r14.startRestartGroup(r0)
            r0 = r15 & 14
            r1 = 2
            if (r0 != 0) goto L_0x0017
            boolean r0 = r14.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x0014
            r0 = 4
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            r0 = r0 | r15
            goto L_0x0018
        L_0x0017:
            r0 = r15
        L_0x0018:
            r0 = r0 & 11
            r0 = r0 ^ r1
            if (r0 != 0) goto L_0x0028
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x0024
            goto L_0x0028
        L_0x0024:
            r14.skipToGroupEnd()
            goto L_0x008b
        L_0x0028:
            r1 = 0
            java.lang.String r2 = r13.getText()
            r0 = -3686930(0xffffffffffc7bdee, float:NaN)
            r14.startReplaceableGroup(r0)
            boolean r3 = r14.changed((java.lang.Object) r13)
            java.lang.Object r4 = r14.rememberedValue()
            if (r3 != 0) goto L_0x0045
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x004d
        L_0x0045:
            com.designsystem.ds_search_field.DSSearchField$Content$1$1 r4 = new com.designsystem.ds_search_field.DSSearchField$Content$1$1
            r4.<init>(r13)
            r14.updateRememberedValue(r4)
        L_0x004d:
            r14.endReplaceableGroup()
            r3 = r4
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            kotlin.jvm.functions.Function0 r4 = r13.getOnKeyboardSearchButtonTap()
            r14.startReplaceableGroup(r0)
            boolean r0 = r14.changed((java.lang.Object) r13)
            java.lang.Object r5 = r14.rememberedValue()
            if (r0 != 0) goto L_0x006c
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r5 != r0) goto L_0x0074
        L_0x006c:
            com.designsystem.ds_search_field.DSSearchField$Content$2$1 r5 = new com.designsystem.ds_search_field.DSSearchField$Content$2$1
            r5.<init>(r13)
            r14.updateRememberedValue(r5)
        L_0x0074:
            r14.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.String r6 = r13.getHint()
            long r7 = r13.getDelay()
            int r9 = r13.getThresholdLetterCount()
            r11 = 0
            r12 = 1
            r10 = r14
            com.designsystem.ds_search_field.DSSearchFieldKt.DSSearchField(r1, r2, r3, r4, r5, r6, r7, r9, r10, r11, r12)
        L_0x008b:
            androidx.compose.runtime.ScopeUpdateScope r14 = r14.endRestartGroup()
            if (r14 != 0) goto L_0x0092
            goto L_0x009a
        L_0x0092:
            com.designsystem.ds_search_field.DSSearchField$Content$3 r0 = new com.designsystem.ds_search_field.DSSearchField$Content$3
            r0.<init>(r13, r15)
            r14.updateScope(r0)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_search_field.DSSearchField.Content(androidx.compose.runtime.Composer, int):void");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final long getDelay() {
        return ((Number) this.delay$delegate.getValue()).longValue();
    }

    @Nullable
    public final String getHint() {
        return (String) this.hint$delegate.getValue();
    }

    @Nullable
    public final Function0<Unit> getOnClearButtonTap() {
        return (Function0) this.onClearButtonTap$delegate.getValue();
    }

    @Nullable
    public final Function0<Unit> getOnKeyboardSearchButtonTap() {
        return (Function0) this.onKeyboardSearchButtonTap$delegate.getValue();
    }

    @Nullable
    public final Function1<String, Unit> getOnTextChange() {
        return (Function1) this.onTextChange$delegate.getValue();
    }

    @NotNull
    public final String getText() {
        return (String) this.text$delegate.getValue();
    }

    public final int getThresholdLetterCount() {
        return ((Number) this.thresholdLetterCount$delegate.getValue()).intValue();
    }

    public final void setDelay(long j11) {
        this.delay$delegate.setValue(Long.valueOf(j11));
    }

    public final void setHint(@Nullable String str) {
        this.hint$delegate.setValue(str);
    }

    public final void setOnClearButtonTap(@Nullable Function0<Unit> function0) {
        this.onClearButtonTap$delegate.setValue(function0);
    }

    public final void setOnKeyboardSearchButtonTap(@Nullable Function0<Unit> function0) {
        this.onKeyboardSearchButtonTap$delegate.setValue(function0);
    }

    public final void setOnTextChange(@Nullable Function1<? super String, Unit> function1) {
        this.onTextChange$delegate.setValue(function1);
    }

    public final void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text$delegate.setValue(str);
    }

    public final void setThresholdLetterCount(int i11) {
        this.thresholdLetterCount$delegate.setValue(Integer.valueOf(i11));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSearchField(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "";
        this.text$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onTextChange$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onKeyboardSearchButtonTap$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onClearButtonTap$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.hint$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.delay$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.thresholdLetterCount$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSSearchField, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…able.DSSearchField, 0, 0)");
            String string = obtainStyledAttributes.getString(R.styleable.DSSearchField_sf_text);
            setText(string != null ? string : str);
            setHint(obtainStyledAttributes.getString(R.styleable.DSSearchField_sf_hint));
            setDelay((long) obtainStyledAttributes.getInt(R.styleable.DSSearchField_sf_delay, 0));
            setThresholdLetterCount(obtainStyledAttributes.getInt(R.styleable.DSSearchField_sf_threshold_letter_count, 0));
            obtainStyledAttributes.recycle();
        }
    }
}
