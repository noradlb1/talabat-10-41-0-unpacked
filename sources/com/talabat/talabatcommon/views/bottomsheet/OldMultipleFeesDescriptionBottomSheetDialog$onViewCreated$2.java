package com.talabat.talabatcommon.views.bottomsheet;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OldMultipleFeesDescriptionBottomSheetDialog$onViewCreated$2 extends Lambda implements Function0<CharSequence> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OldMultipleFeesDescriptionBottomSheetDialog f11712g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OldMultipleFeesDescriptionBottomSheetDialog$onViewCreated$2(OldMultipleFeesDescriptionBottomSheetDialog oldMultipleFeesDescriptionBottomSheetDialog) {
        super(0);
        this.f11712g = oldMultipleFeesDescriptionBottomSheetDialog;
    }

    @Nullable
    public final CharSequence invoke() {
        OldMultipleFeesDescriptionBottomSheetDialog oldMultipleFeesDescriptionBottomSheetDialog = this.f11712g;
        return oldMultipleFeesDescriptionBottomSheetDialog.getFeeDescriptionText(oldMultipleFeesDescriptionBottomSheetDialog.getFeesDescription().getServiceFee());
    }
}
