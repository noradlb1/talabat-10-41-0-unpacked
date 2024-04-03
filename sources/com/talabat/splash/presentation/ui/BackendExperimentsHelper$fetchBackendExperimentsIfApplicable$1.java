package com.talabat.splash.presentation.ui;

import com.talabat.helpers.GlobalDataModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isFwfTrackingEnabled", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackendExperimentsHelper$fetchBackendExperimentsIfApplicable$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BackendExperimentsHelper f61517g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackendExperimentsHelper$fetchBackendExperimentsIfApplicable$1(BackendExperimentsHelper backendExperimentsHelper) {
        super(1);
        this.f61517g = backendExperimentsHelper;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        if (z11) {
            String str = GlobalDataModel.encryptedUserId;
            Intrinsics.checkNotNullExpressionValue(str, "encryptedUserId");
            if (str.length() > 0) {
                this.f61517g.fetchExperiments();
            }
        }
    }
}
