package com.talabat.feature.darkstores.presentation.viewmodel;

import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.darkstores.presentation.viewmodel.DarkStoresDeepLinkViewModel$fetchDarkStoreInfo$1", f = "DarkStoresDeepLinkViewModel.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
public final class DarkStoresDeepLinkViewModel$fetchDarkStoreInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f58397h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DarkStoresDeepLinkViewModel f58398i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkStoresDeepLinkViewModel$fetchDarkStoreInfo$1(DarkStoresDeepLinkViewModel darkStoresDeepLinkViewModel, Continuation<? super DarkStoresDeepLinkViewModel$fetchDarkStoreInfo$1> continuation) {
        super(2, continuation);
        this.f58398i = darkStoresDeepLinkViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DarkStoresDeepLinkViewModel$fetchDarkStoreInfo$1(this.f58398i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DarkStoresDeepLinkViewModel$fetchDarkStoreInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58397h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f58398i.showLoading();
            DarkstoresRepository access$getDarkStoresRepository$p = this.f58398i.darkStoresRepository;
            this.f58397h = 1;
            obj = access$getDarkStoresRepository$p.getNearestDarkstoreVendor(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e11) {
                LogManager.logException(e11);
                this.f58398i.showErrorMessage();
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f58398i.hideLoading();
        this.f58398i.navigateToDarkStore((Restaurant) obj);
        return Unit.INSTANCE;
    }
}
