package com.talabat.userandlocation.compliance.verification.ui.fragment;

import com.talabat.helpers.CustomDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/helpers/CustomDialog;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UserVerificationFragment$progressDialog$2 extends Lambda implements Function0<CustomDialog> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f12325g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserVerificationFragment$progressDialog$2(UserVerificationFragment userVerificationFragment) {
        super(0);
        this.f12325g = userVerificationFragment;
    }

    @NotNull
    public final CustomDialog invoke() {
        return new CustomDialog(this.f12325g.requireContext());
    }
}
