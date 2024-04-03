package com.afollestad.materialdialogs.internal.button;

import android.view.View;
import com.afollestad.materialdialogs.WhichButton;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 15})
public final class DialogActionButtonLayout$onFinishInflate$1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogActionButtonLayout f40400b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WhichButton f40401c;

    public DialogActionButtonLayout$onFinishInflate$1(DialogActionButtonLayout dialogActionButtonLayout, WhichButton whichButton) {
        this.f40400b = dialogActionButtonLayout;
        this.f40401c = whichButton;
    }

    public final void onClick(View view) {
        this.f40400b.getDialog().onActionButtonClicked$com_afollestad_material_dialogs_core(this.f40401c);
    }
}
