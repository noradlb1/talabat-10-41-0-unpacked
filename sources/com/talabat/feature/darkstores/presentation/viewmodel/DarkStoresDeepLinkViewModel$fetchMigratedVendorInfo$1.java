package com.talabat.feature.darkstores.presentation.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.darkstores.presentation.viewmodel.DarkStoresDeepLinkViewModel$fetchMigratedVendorInfo$1", f = "DarkStoresDeepLinkViewModel.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class DarkStoresDeepLinkViewModel$fetchMigratedVendorInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f58399h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DarkStoresDeepLinkViewModel f58400i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f58401j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkStoresDeepLinkViewModel$fetchMigratedVendorInfo$1(DarkStoresDeepLinkViewModel darkStoresDeepLinkViewModel, String str, Continuation<? super DarkStoresDeepLinkViewModel$fetchMigratedVendorInfo$1> continuation) {
        super(2, continuation);
        this.f58400i = darkStoresDeepLinkViewModel;
        this.f58401j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DarkStoresDeepLinkViewModel$fetchMigratedVendorInfo$1(this.f58400i, this.f58401j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DarkStoresDeepLinkViewModel$fetchMigratedVendorInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031 A[Catch:{ Exception -> 0x000f }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058 A[Catch:{ Exception -> 0x000f }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r3.f58399h
            r2 = 1
            if (r1 == 0) goto L_0x0019
            if (r1 != r2) goto L_0x0011
            kotlin.ResultKt.throwOnFailure(r4)     // Catch:{ Exception -> 0x000f }
            goto L_0x0042
        L_0x000f:
            r4 = move-exception
            goto L_0x0060
        L_0x0011:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L_0x0019:
            kotlin.ResultKt.throwOnFailure(r4)
            com.talabat.feature.darkstores.presentation.viewmodel.DarkStoresDeepLinkViewModel r4 = r3.f58400i     // Catch:{ Exception -> 0x000f }
            r4.showLoading()     // Catch:{ Exception -> 0x000f }
            java.lang.String r4 = r3.f58401j     // Catch:{ Exception -> 0x000f }
            if (r4 == 0) goto L_0x002e
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r4)     // Catch:{ Exception -> 0x000f }
            if (r4 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r4 = 0
            goto L_0x002f
        L_0x002e:
            r4 = r2
        L_0x002f:
            if (r4 != 0) goto L_0x0058
            com.talabat.feature.darkstores.presentation.viewmodel.DarkStoresDeepLinkViewModel r4 = r3.f58400i     // Catch:{ Exception -> 0x000f }
            com.talabat.feature.darkstores.domain.repository.DarkstoresRepository r4 = r4.darkStoresRepository     // Catch:{ Exception -> 0x000f }
            java.lang.String r1 = r3.f58401j     // Catch:{ Exception -> 0x000f }
            r3.f58399h = r2     // Catch:{ Exception -> 0x000f }
            java.lang.Object r4 = r4.getMigratedVendor(r1, r3)     // Catch:{ Exception -> 0x000f }
            if (r4 != r0) goto L_0x0042
            return r0
        L_0x0042:
            JsonModels.Response.MenuItemResponse r4 = (JsonModels.Response.MenuItemResponse) r4     // Catch:{ Exception -> 0x000f }
            com.talabat.feature.darkstores.presentation.viewmodel.DarkStoresDeepLinkViewModel r0 = r3.f58400i     // Catch:{ Exception -> 0x000f }
            r0.hideLoading()     // Catch:{ Exception -> 0x000f }
            com.talabat.feature.darkstores.presentation.viewmodel.DarkStoresDeepLinkViewModel r0 = r3.f58400i     // Catch:{ Exception -> 0x000f }
            JsonModels.MenuItemsResponseModel r4 = r4.result     // Catch:{ Exception -> 0x000f }
            datamodels.Restaurant r4 = r4.restaurant     // Catch:{ Exception -> 0x000f }
            java.lang.String r1 = "response.result.restaurant"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)     // Catch:{ Exception -> 0x000f }
            r0.navigateToDarkStore(r4)     // Catch:{ Exception -> 0x000f }
            goto L_0x0068
        L_0x0058:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x000f }
            java.lang.String r0 = "bid is not provided in the migrated vendor deeplink"
            r4.<init>(r0)     // Catch:{ Exception -> 0x000f }
            throw r4     // Catch:{ Exception -> 0x000f }
        L_0x0060:
            com.talabat.talabatcore.logger.LogManager.logException(r4)
            com.talabat.feature.darkstores.presentation.viewmodel.DarkStoresDeepLinkViewModel r4 = r3.f58400i
            r4.showErrorMessage()
        L_0x0068:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstores.presentation.viewmodel.DarkStoresDeepLinkViewModel$fetchMigratedVendorInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
