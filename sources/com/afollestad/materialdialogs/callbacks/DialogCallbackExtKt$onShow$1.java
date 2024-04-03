package com.afollestad.materialdialogs.callbacks;

import android.content.DialogInterface;
import com.afollestad.materialdialogs.MaterialDialog;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"}, k = 3, mv = {1, 1, 15})
public final class DialogCallbackExtKt$onShow$1 implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialDialog f40390a;

    public DialogCallbackExtKt$onShow$1(MaterialDialog materialDialog) {
        this.f40390a = materialDialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        DialogCallbackExtKt.invokeAll(this.f40390a.getShowListeners$com_afollestad_material_dialogs_core(), this.f40390a);
    }
}
