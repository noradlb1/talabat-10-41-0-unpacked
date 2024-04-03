package com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl;

import com.talabat.userandlocation.compliance.verification.domain.usecase.business.UpdateUserProfileUseCase;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "status", "", "message", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UpdateUserProfileUseCaseImpl$updateDetails$2$2 extends Lambda implements Function2<Integer, String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Continuation<UpdateUserProfileUseCase.Result> f12307g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpdateUserProfileUseCaseImpl$updateDetails$2$2(Continuation<? super UpdateUserProfileUseCase.Result> continuation) {
        super(2);
        this.f12307g = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (i11 == -19) {
            Continuation<UpdateUserProfileUseCase.Result> continuation = this.f12307g;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m6329constructorimpl(new UpdateUserProfileUseCase.Result.InvalidCharacterError(str)));
            return;
        }
        Continuation<UpdateUserProfileUseCase.Result> continuation2 = this.f12307g;
        Result.Companion companion2 = Result.Companion;
        continuation2.resumeWith(Result.m6329constructorimpl(UpdateUserProfileUseCase.Result.Success.INSTANCE));
    }
}
