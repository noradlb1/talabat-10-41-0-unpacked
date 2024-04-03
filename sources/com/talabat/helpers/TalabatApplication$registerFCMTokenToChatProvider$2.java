package com.talabat.helpers;

import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "e", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$registerFCMTokenToChatProvider$2 extends Lambda implements Function1<Throwable, Unit> {
    public static final TalabatApplication$registerFCMTokenToChatProvider$2 INSTANCE = new TalabatApplication$registerFCMTokenToChatProvider$2();

    public TalabatApplication$registerFCMTokenToChatProvider$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        String message = th2.getMessage();
        LogManager.error(th2, "Couldn't register fcm token to the chat provider because of " + message);
        LogManager.logException(th2);
    }
}
