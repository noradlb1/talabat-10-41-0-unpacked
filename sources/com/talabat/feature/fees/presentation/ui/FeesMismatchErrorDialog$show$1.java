package com.talabat.feature.fees.presentation.ui;

import android.view.View;
import com.designsystem.ds_dialog.DSDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FeesMismatchErrorDialog$show$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f58537g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSDialog f58538h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeesMismatchErrorDialog$show$1(View.OnClickListener onClickListener, DSDialog dSDialog) {
        super(0);
        this.f58537g = onClickListener;
        this.f58538h = dSDialog;
    }

    public final void invoke() {
        this.f58537g.onClick((View) null);
        this.f58538h.close();
    }
}
