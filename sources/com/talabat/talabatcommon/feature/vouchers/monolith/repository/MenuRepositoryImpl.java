package com.talabat.talabatcommon.feature.vouchers.monolith.repository;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.feature.vouchers.monolith.model.response.GroceryItemDetails;
import com.talabat.talabatcommon.feature.vouchers.monolith.model.response.GroceryItemDetailsResponse;
import com.talabat.talabatcommon.feature.vouchers.monolith.network.GroceryService;
import com.talabat.talabatcommon.feature.vouchers.monolith.network.MonolithService;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.exception.SystemError;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Response;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/monolith/repository/MenuRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/repository/MenuRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "service", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/network/MonolithService;", "groceryService", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/network/GroceryService;", "(Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatcommon/feature/vouchers/monolith/network/MonolithService;Lcom/talabat/talabatcommon/feature/vouchers/monolith/network/GroceryService;)V", "getFoodMenuItemDetails", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsDisplayModel;", "itemId", "", "branchId", "getGroceryItemDetails", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/GroceryItemDetails;", "groceryVendorId", "sku", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MenuRepositoryImpl implements MenuRepository {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final GroceryService groceryService;
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final MonolithService f61693service;

    public MenuRepositoryImpl(@NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull NetworkHandler networkHandler2, @NotNull MonolithService monolithService, @NotNull GroceryService groceryService2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(monolithService, "service");
        Intrinsics.checkNotNullParameter(groceryService2, "groceryService");
        this.configurationLocalRepository = configurationLocalRepository2;
        this.networkHandler = networkHandler2;
        this.f61693service = monolithService;
        this.groceryService = groceryService2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.talabat.talabatcommon.feature.vouchers.monolith.model.response.VoucherItemsRootResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: com.talabat.talabatcommon.feature.vouchers.monolith.model.response.VoucherItemsRootResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: com.talabat.talabatcommon.feature.vouchers.monolith.model.response.VoucherItemsRootResponse} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.talabatcore.functional.Either<com.talabat.talabatcore.exception.Failure, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModel> getFoodMenuItemDetails(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "itemId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "branchId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            com.talabat.talabatcore.platform.NetworkHandler r0 = r8.networkHandler
            boolean r0 = r0.isConnected()
            r1 = 1
            if (r0 != r1) goto L_0x0084
            com.talabat.talabatcommon.feature.vouchers.monolith.network.MonolithService r2 = r8.f61693service
            r3 = 0
            r6 = 1
            r7 = 0
            r4 = r9
            r5 = r10
            retrofit2.Call r9 = com.talabat.talabatcommon.feature.vouchers.monolith.network.MonolithApi.DefaultImpls.getMenuItems$default(r2, r3, r4, r5, r6, r7)
            com.talabat.talabatcommon.feature.vouchers.monolith.model.response.VoucherItemsRootResponse r10 = new com.talabat.talabatcommon.feature.vouchers.monolith.model.response.VoucherItemsRootResponse
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 7
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            retrofit2.Call r9 = r9.clone()     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            retrofit2.Response r9 = r9.execute()     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            boolean r0 = r9.isSuccessful()     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            if (r0 != r1) goto L_0x004c
            java.lang.Object r9 = r9.body()     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            if (r9 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r10 = r9
        L_0x003e:
            com.talabat.talabatcommon.feature.vouchers.monolith.model.response.VoucherItemsRootResponse r10 = (com.talabat.talabatcommon.feature.vouchers.monolith.model.response.VoucherItemsRootResponse) r10     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModelMapper r9 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModelMapper.INSTANCE     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModel r9 = r9.fromVoucherItemsRootResponse(r10)     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            com.talabat.talabatcore.functional.Either$Right r10 = new com.talabat.talabatcore.functional.Either$Right     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            r10.<init>(r9)     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            goto L_0x008d
        L_0x004c:
            if (r0 != 0) goto L_0x005d
            com.talabat.talabatcore.functional.Either$Left r10 = new com.talabat.talabatcore.functional.Either$Left     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            com.talabat.talabatcore.exception.ServerError r9 = com.talabat.talabatcommon.extentions.network.RequestKt.parseTheServerError(r9)     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            r10.<init>(r9)     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            goto L_0x008d
        L_0x005d:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            r9.<init>()     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
            throw r9     // Catch:{ Failure -> 0x007a, all -> 0x0063 }
        L_0x0063:
            r9 = move-exception
            com.talabat.talabatcore.logger.LogManager.logException(r9)
            com.talabat.talabatcore.functional.Either$Left r10 = new com.talabat.talabatcore.functional.Either$Left
            com.talabat.talabatcore.exception.SystemError r0 = new com.talabat.talabatcore.exception.SystemError
            java.lang.String r9 = r9.getMessage()
            if (r9 != 0) goto L_0x0073
            java.lang.String r9 = ""
        L_0x0073:
            r0.<init>(r9)
            r10.<init>(r0)
            goto L_0x008d
        L_0x007a:
            r9 = move-exception
            com.talabat.talabatcore.logger.LogManager.logException(r9)
            com.talabat.talabatcore.functional.Either$Left r10 = new com.talabat.talabatcore.functional.Either$Left
            r10.<init>(r9)
            goto L_0x008d
        L_0x0084:
            if (r0 != 0) goto L_0x008e
            com.talabat.talabatcore.functional.Either$Left r10 = new com.talabat.talabatcore.functional.Either$Left
            com.talabat.talabatcore.exception.Failure$NetworkConnection r9 = com.talabat.talabatcore.exception.Failure.NetworkConnection.INSTANCE
            r10.<init>(r9)
        L_0x008d:
            return r10
        L_0x008e:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.monolith.repository.MenuRepositoryImpl.getFoodMenuItemDetails(java.lang.String, java.lang.String):com.talabat.talabatcore.functional.Either");
    }

    @NotNull
    public Either<Failure, GroceryItemDetails> getGroceryItemDetails(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "groceryVendorId");
        Intrinsics.checkNotNullParameter(str2, "sku");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            Call<GroceryItemDetailsResponse> groceryItemDetails = this.groceryService.getGroceryItemDetails(str, str2, this.configurationLocalRepository.selectedCountry().getTwoLetterCode(), this.configurationLocalRepository.selectedLanguage().getLanguageCode());
            GroceryItemDetailsResponse groceryItemDetailsResponse = new GroceryItemDetailsResponse((GroceryItemDetails) null, 1, (DefaultConstructorMarker) null);
            try {
                Response<GroceryItemDetailsResponse> execute = groceryItemDetails.clone().execute();
                boolean isSuccessful = execute.isSuccessful();
                if (isSuccessful) {
                    GroceryItemDetailsResponse body = execute.body();
                    if (body != null) {
                        groceryItemDetailsResponse = body;
                    }
                    GroceryItemDetails data = groceryItemDetailsResponse.getData();
                    if (data == null) {
                        data = new GroceryItemDetails((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
                    }
                    return new Either.Right(data);
                } else if (!isSuccessful) {
                    Intrinsics.checkNotNullExpressionValue(execute, "response");
                    return new Either.Left(RequestKt.parseTheServerError(execute));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } catch (Failure e11) {
                LogManager.logException(e11);
                return new Either.Left(e11);
            } catch (Throwable th2) {
                LogManager.logException(th2);
                String message = th2.getMessage();
                if (message == null) {
                    message = "";
                }
                return new Either.Left(new SystemError(message));
            }
        } else if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
