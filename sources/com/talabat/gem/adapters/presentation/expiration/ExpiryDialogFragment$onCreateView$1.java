package com.talabat.gem.adapters.presentation.expiration;

import android.app.Dialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExpiryDialogFragment$onCreateView$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ExpiryDialogFragment f60053g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpiryDialogFragment$onCreateView$1(ExpiryDialogFragment expiryDialogFragment) {
        super(0);
        this.f60053g = expiryDialogFragment;
    }

    public final void invoke() {
        if (this.f60053g.isCollectionGemRestaurant) {
            Function0 access$getOnCloseView$p = this.f60053g.onCloseView;
            if (access$getOnCloseView$p != null) {
                access$getOnCloseView$p.invoke();
                return;
            }
            return;
        }
        Dialog dialog = this.f60053g.getDialog();
        if (dialog != null) {
            dialog.cancel();
        }
    }
}
