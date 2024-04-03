package com.afollestad.materialdialogs.bottomsheets;

import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 15})
public final class BottomSheet$onPreShow$1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomSheet f40367b;

    public BottomSheet$onPreShow$1(BottomSheet bottomSheet) {
        this.f40367b = bottomSheet;
    }

    public final void onClick(View view) {
        MaterialDialog access$getDialog$p = this.f40367b.dialog;
        if (access$getDialog$p != null) {
            access$getDialog$p.dismiss();
        }
    }
}
