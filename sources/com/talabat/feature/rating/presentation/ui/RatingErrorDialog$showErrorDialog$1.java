package com.talabat.feature.rating.presentation.ui;

import android.app.Activity;
import com.designsystem.ds_dialog.DSDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RatingErrorDialog$showErrorDialog$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSDialog f58709g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Activity f58710h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatingErrorDialog$showErrorDialog$1(DSDialog dSDialog, Activity activity) {
        super(0);
        this.f58709g = dSDialog;
        this.f58710h = activity;
    }

    public final void invoke() {
        this.f58709g.close();
        this.f58710h.finish();
    }
}
