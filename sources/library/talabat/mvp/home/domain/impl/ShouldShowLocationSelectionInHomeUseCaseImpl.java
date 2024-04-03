package library.talabat.mvp.home.domain.impl;

import buisnessmodels.Cart;
import i10.a;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.domain.ShouldShowLocationSelectionInHomeUseCase;
import library.talabat.mvp.home.domain.repository.ShowLocationSelectionRepository;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Llibrary/talabat/mvp/home/domain/impl/ShouldShowLocationSelectionInHomeUseCaseImpl;", "Llibrary/talabat/mvp/home/domain/ShouldShowLocationSelectionInHomeUseCase;", "isLocationAvailable", "Lkotlin/Function0;", "", "cart", "Lbuisnessmodels/Cart;", "showLocationSelectionRepository", "Llibrary/talabat/mvp/home/domain/repository/ShowLocationSelectionRepository;", "(Lkotlin/jvm/functions/Function0;Lbuisnessmodels/Cart;Llibrary/talabat/mvp/home/domain/repository/ShowLocationSelectionRepository;)V", "shouldShowLocationSelection", "Lio/reactivex/Single;", "Llibrary/talabat/mvp/home/domain/ShouldShowLocationSelectionInHomeUseCase$Result;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShouldShowLocationSelectionInHomeUseCaseImpl implements ShouldShowLocationSelectionInHomeUseCase {
    @NotNull
    private final Cart cart;
    @NotNull
    private final Function0<Boolean> isLocationAvailable;
    @NotNull
    private final ShowLocationSelectionRepository showLocationSelectionRepository;

    public ShouldShowLocationSelectionInHomeUseCaseImpl(@NotNull Function0<Boolean> function0, @NotNull Cart cart2, @NotNull ShowLocationSelectionRepository showLocationSelectionRepository2) {
        Intrinsics.checkNotNullParameter(function0, "isLocationAvailable");
        Intrinsics.checkNotNullParameter(cart2, "cart");
        Intrinsics.checkNotNullParameter(showLocationSelectionRepository2, "showLocationSelectionRepository");
        this.isLocationAvailable = function0;
        this.cart = cart2;
        this.showLocationSelectionRepository = showLocationSelectionRepository2;
    }

    /* access modifiers changed from: private */
    /* renamed from: shouldShowLocationSelection$lambda-0  reason: not valid java name */
    public static final void m7884shouldShowLocationSelection$lambda0(ShouldShowLocationSelectionInHomeUseCaseImpl shouldShowLocationSelectionInHomeUseCaseImpl, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(shouldShowLocationSelectionInHomeUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "it");
        boolean z11 = !shouldShowLocationSelectionInHomeUseCaseImpl.isLocationAvailable.invoke().booleanValue();
        boolean z12 = !shouldShowLocationSelectionInHomeUseCaseImpl.cart.hasItems();
        if (!shouldShowLocationSelectionInHomeUseCaseImpl.showLocationSelectionRepository.getShouldShowLocationSelectionOnHomeScreen() || !z11 || !z12) {
            singleEmitter.onSuccess(ShouldShowLocationSelectionInHomeUseCase.Result.DontShow.INSTANCE);
            return;
        }
        shouldShowLocationSelectionInHomeUseCaseImpl.showLocationSelectionRepository.setShouldShowLocationSelectionOnHomeScreen(false);
        singleEmitter.onSuccess(ShouldShowLocationSelectionInHomeUseCase.Result.ShouldShow.INSTANCE);
    }

    @NotNull
    public Single<ShouldShowLocationSelectionInHomeUseCase.Result> shouldShowLocationSelection() {
        Single<ShouldShowLocationSelectionInHomeUseCase.Result> create = Single.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "create {\n        val isL…DontShow)\n        }\n    }");
        return create;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShouldShowLocationSelectionInHomeUseCaseImpl(kotlin.jvm.functions.Function0 r1, buisnessmodels.Cart r2, library.talabat.mvp.home.domain.repository.ShowLocationSelectionRepository r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000d
            buisnessmodels.Cart r2 = buisnessmodels.Cart.getInstance()
            java.lang.String r5 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
        L_0x000d:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0013
            library.talabat.mvp.home.data.repository.impl.ShowLocationSelectionRepositoryImpl r3 = library.talabat.mvp.home.data.repository.impl.ShowLocationSelectionRepositoryImpl.INSTANCE
        L_0x0013:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.home.domain.impl.ShouldShowLocationSelectionInHomeUseCaseImpl.<init>(kotlin.jvm.functions.Function0, buisnessmodels.Cart, library.talabat.mvp.home.domain.repository.ShowLocationSelectionRepository, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
