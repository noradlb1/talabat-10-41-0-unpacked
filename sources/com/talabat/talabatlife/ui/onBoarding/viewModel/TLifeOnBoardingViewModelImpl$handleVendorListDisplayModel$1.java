package com.talabat.talabatlife.ui.onBoarding.viewModel;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a*\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00070\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TLifeOnBoardingViewModelImpl$handleVendorListDisplayModel$1 extends Lambda implements Function1<Either<? extends Failure, ? extends HashMap<String, String>>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TLifeOnBoardingViewModelImpl f12069g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TLifeOnBoardingViewModelImpl$handleVendorListDisplayModel$1(TLifeOnBoardingViewModelImpl tLifeOnBoardingViewModelImpl) {
        super(1);
        this.f12069g = tLifeOnBoardingViewModelImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, ? extends HashMap<String, String>>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Either<? extends Failure, ? extends HashMap<String, String>> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        AnonymousClass1 r02 = AnonymousClass1.INSTANCE;
        final TLifeOnBoardingViewModelImpl tLifeOnBoardingViewModelImpl = this.f12069g;
        either.either(r02, new Function1<HashMap<String, String>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HashMap<String, String>) (HashMap) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull HashMap<String, String> hashMap) {
                Intrinsics.checkNotNullParameter(hashMap, "eventParameters");
                tLifeOnBoardingViewModelImpl.sendFirebaseEvent(EventNames.ON_BOARDING_SCREEN_LOADED.getEventName(), hashMap);
            }
        });
    }
}
