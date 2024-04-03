package com.talabat.splash.core.interactor;

import com.talabat.splash.core.exception.Failure;
import com.talabat.splash.core.functional.Either;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002 \u0001*\u00020\u0003\"\u0006\b\u0001\u0010\u0004 \u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "Type", "", "Params", "it", "Lcom/talabat/splash/core/functional/Either;", "Lcom/talabat/splash/core/exception/Failure;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UseCase$invoke$1 extends Lambda implements Function1<Either<? extends Failure, ? extends Object>, Unit> {
    public static final UseCase$invoke$1 INSTANCE = new UseCase$invoke$1();

    public UseCase$invoke$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, ? extends Object>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Either<? extends Failure, ? extends Object> either) {
        Intrinsics.checkNotNullParameter(either, "it");
    }
}
