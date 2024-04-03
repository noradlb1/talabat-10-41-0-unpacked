package com.afollestad.materialdialogs.message;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.navigation.compose.DialogNavigator;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.message.LinkTransformationMethod;
import com.afollestad.materialdialogs.utils.MDUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J-\u0010\u000b\u001a\u00020\u00002%\b\u0002\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J%\u0010\u0016\u001a\u00020\u00122\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a*\u0004\u0018\u00010\u001a2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/afollestad/materialdialogs/message/DialogMessageSettings;", "", "dialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "messageTextView", "Landroid/widget/TextView;", "(Lcom/afollestad/materialdialogs/MaterialDialog;Landroid/widget/TextView;)V", "isHtml", "", "getMessageTextView", "()Landroid/widget/TextView;", "html", "onLinkClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "link", "", "lineSpacing", "multiplier", "", "setText", "res", "", "text", "", "setText$com_afollestad_material_dialogs_core", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "maybeWrapHtml", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
public final class DialogMessageSettings {
    private final MaterialDialog dialog;
    private boolean isHtml;
    @NotNull
    private final TextView messageTextView;

    public DialogMessageSettings(@NotNull MaterialDialog materialDialog, @NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(materialDialog, DialogNavigator.NAME);
        Intrinsics.checkParameterIsNotNull(textView, "messageTextView");
        this.dialog = materialDialog;
        this.messageTextView = textView;
    }

    public static /* synthetic */ DialogMessageSettings html$default(DialogMessageSettings dialogMessageSettings, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = null;
        }
        return dialogMessageSettings.html(function1);
    }

    private final CharSequence maybeWrapHtml(@Nullable CharSequence charSequence, boolean z11) {
        if (charSequence == null) {
            return null;
        }
        return z11 ? Html.fromHtml(charSequence.toString()) : charSequence;
    }

    @NotNull
    public final TextView getMessageTextView() {
        return this.messageTextView;
    }

    @NotNull
    public final DialogMessageSettings html(@Nullable Function1<? super String, Unit> function1) {
        this.isHtml = true;
        if (function1 != null) {
            this.messageTextView.setTransformationMethod(new LinkTransformationMethod(function1));
        }
        this.messageTextView.setMovementMethod(LinkMovementMethod.getInstance());
        return this;
    }

    @NotNull
    public final DialogMessageSettings lineSpacing(float f11) {
        this.messageTextView.setLineSpacing(0.0f, f11);
        return this;
    }

    public final void setText$com_afollestad_material_dialogs_core(@Nullable @StringRes Integer num, @Nullable CharSequence charSequence) {
        TextView textView = this.messageTextView;
        CharSequence maybeWrapHtml = maybeWrapHtml(charSequence, this.isHtml);
        if (maybeWrapHtml == null) {
            maybeWrapHtml = MDUtil.resolveString$default(MDUtil.INSTANCE, this.dialog, num, (Integer) null, this.isHtml, 4, (Object) null);
        }
        textView.setText(maybeWrapHtml);
    }
}
