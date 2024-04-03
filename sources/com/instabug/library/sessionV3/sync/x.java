package com.instabug.library.sessionV3.sync;

import com.instabug.library.model.v3Session.IBGSessionData;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class x extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final x f51858a = new x();

    public x() {
        super(1);
    }

    @NotNull
    /* renamed from: a */
    public final String invoke(@NotNull IBGSessionData iBGSessionData) {
        Intrinsics.checkNotNullParameter(iBGSessionData, "it");
        return iBGSessionData.getFeatureKey();
    }
}
