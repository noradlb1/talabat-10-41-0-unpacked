package com.talabat.wallet.screens.walletDashboard.interactor;

import JsonModels.Response.WalletTransactionListDataItem;
import JsonModels.Response.WalletTransactionListDataModel;
import JsonModels.Response.WalletTransactionListResponse;
import androidx.webkit.ProxyConfig;
import com.talabat.configuration.country.Country;
import com.talabat.talabatcommon.utils.DateConstants;
import com.talabat.wallet.helpers.WalletFormatterInterface;
import com.talabat.wallet.network.WalletApiService;
import com.talabat.wallet.network.WalletApiUrls;
import com.talabat.wallet.screens.walletDashboard.WalletTransactionDashboardScreenListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;
import xx.a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J:\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/interactor/WalletTransactionDashboardScreenInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "Lcom/talabat/wallet/screens/walletDashboard/interactor/IWalletTransactionDashboardScreenInteractor;", "Lcom/talabat/wallet/helpers/WalletFormatterInterface;", "walletTransactionDashboardScreenListener", "Lcom/talabat/wallet/screens/walletDashboard/WalletTransactionDashboardScreenListener;", "(Lcom/talabat/wallet/screens/walletDashboard/WalletTransactionDashboardScreenListener;)V", "EMPTY_STRING", "", "getEMPTY_STRING", "()Ljava/lang/String;", "INPUT_DATE_FORMAT", "getINPUT_DATE_FORMAT", "OUT_DATE_FORMAT", "getOUT_DATE_FORMAT", "getAllowCountryListForSendGift", "", "", "getWalletCreditTransactionList", "", "countryCode", "skip", "numberOfItemsPerPage", "selectedLanguage", "lastTransactionModel", "LJsonModels/Response/WalletTransactionListDataItem$TransactionModel;", "getWalletTransactionListDataModel", "LJsonModels/Response/WalletTransactionListDataModel;", "response", "LJsonModels/Response/WalletTransactionListResponse;", "transactionModel", "unregister", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDashboardScreenInteractor implements IGlobalInteractor, IWalletTransactionDashboardScreenInteractor, WalletFormatterInterface {
    @NotNull
    private final String EMPTY_STRING = "";
    @NotNull
    private final String INPUT_DATE_FORMAT = DateConstants.DEFAULT_UTC_FORMAT;
    @NotNull
    private final String OUT_DATE_FORMAT = "yyyy-MM";
    /* access modifiers changed from: private */
    @Nullable
    public WalletTransactionDashboardScreenListener walletTransactionDashboardScreenListener;

    public WalletTransactionDashboardScreenInteractor(@Nullable WalletTransactionDashboardScreenListener walletTransactionDashboardScreenListener2) {
        this.walletTransactionDashboardScreenListener = walletTransactionDashboardScreenListener2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getWalletCreditTransactionList$lambda-0  reason: not valid java name */
    public static final WalletTransactionListDataModel m5969getWalletCreditTransactionList$lambda0(WalletTransactionDashboardScreenInteractor walletTransactionDashboardScreenInteractor, WalletTransactionListDataItem.TransactionModel transactionModel, WalletTransactionListResponse walletTransactionListResponse) {
        Intrinsics.checkNotNullParameter(walletTransactionDashboardScreenInteractor, "this$0");
        Intrinsics.checkNotNullParameter(walletTransactionListResponse, "t");
        return walletTransactionDashboardScreenInteractor.getWalletTransactionListDataModel(walletTransactionListResponse, transactionModel);
    }

    @NotNull
    public String dateFormatter(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        return WalletFormatterInterface.DefaultImpls.dateFormatter(this, str, str2, str3);
    }

    @NotNull
    public String formatAmountWithSign(@Nullable Float f11, boolean z11, boolean z12) {
        return WalletFormatterInterface.DefaultImpls.formatAmountWithSign(this, f11, z11, z12);
    }

    @NotNull
    public Set<Integer> getAllowCountryListForSendGift() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(Integer.valueOf(Country.BAHRAIN.getCountryId()));
        linkedHashSet.add(Integer.valueOf(Country.KUWAIT.getCountryId()));
        return linkedHashSet;
    }

    @NotNull
    public String getAmountSign(@Nullable Float f11) {
        return WalletFormatterInterface.DefaultImpls.getAmountSign(this, f11);
    }

    @NotNull
    public String getAmountWithoutCurrency(@Nullable Float f11) {
        return WalletFormatterInterface.DefaultImpls.getAmountWithoutCurrency(this, f11);
    }

    @NotNull
    public String getAmountWithoutCurrencyWithSign(@Nullable Float f11) {
        return WalletFormatterInterface.DefaultImpls.getAmountWithoutCurrencyWithSign(this, f11);
    }

    @NotNull
    public String getCurrencyLocale() {
        return WalletFormatterInterface.DefaultImpls.getCurrencyLocale(this);
    }

    @NotNull
    public String getEMPTY_STRING() {
        return this.EMPTY_STRING;
    }

    @NotNull
    public String getINPUT_DATE_FORMAT() {
        return this.INPUT_DATE_FORMAT;
    }

    @NotNull
    public String getMonthAndYearForMapingAndGrouping(@Nullable String str) {
        return WalletFormatterInterface.DefaultImpls.getMonthAndYearForMapingAndGrouping(this, str);
    }

    @NotNull
    public String getOUT_DATE_FORMAT() {
        return this.OUT_DATE_FORMAT;
    }

    public void getWalletCreditTransactionList(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable WalletTransactionListDataItem.TransactionModel transactionModel) {
        ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).getWalletTransactionList(CreateApiUrl.createWithParameters(WalletApiUrls.Companion.getWALLET_CREDIT_TRANSACTION_URL(), new String[]{"{countryCode}", String.valueOf(str), "{numberPerPage}", String.valueOf(str3), "{skip}", String.valueOf(str2), "{selectedLanguage}", String.valueOf(str4)})).map(new a(this, transactionModel)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletTransactionDashboardScreenInteractor$getWalletCreditTransactionList$2(this, ProxyConfig.MATCH_HTTP));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        if ((!r2.isEmpty()) == true) goto L_0x0026;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JsonModels.Response.WalletTransactionListDataModel getWalletTransactionListDataModel(@org.jetbrains.annotations.Nullable JsonModels.Response.WalletTransactionListResponse r7, @org.jetbrains.annotations.Nullable JsonModels.Response.WalletTransactionListDataItem.TransactionModel r8) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            if (r7 == 0) goto L_0x0013
            JsonModels.Response.WalletTransactionListResult r2 = r7.getResult()
            if (r2 == 0) goto L_0x0013
            java.util.List r2 = r2.getTransactionList()
            goto L_0x0014
        L_0x0013:
            r2 = r1
        L_0x0014:
            if (r8 != 0) goto L_0x004a
            r3 = 0
            if (r2 == 0) goto L_0x0025
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r5 = 1
            r4 = r4 ^ r5
            if (r4 != r5) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r5 = r3
        L_0x0026:
            if (r5 == 0) goto L_0x004a
            JsonModels.Response.WalletTransactionListDataItem$Header r8 = new JsonModels.Response.WalletTransactionListDataItem$Header
            if (r2 == 0) goto L_0x0039
            java.lang.Object r4 = r2.get(r3)
            JsonModels.Response.WalletTransactionListDataItem$TransactionModel r4 = (JsonModels.Response.WalletTransactionListDataItem.TransactionModel) r4
            if (r4 == 0) goto L_0x0039
            java.lang.String r4 = r4.getDate()
            goto L_0x003a
        L_0x0039:
            r4 = r1
        L_0x003a:
            r8.<init>(r4)
            r0.add(r8)
            if (r2 == 0) goto L_0x0049
            java.lang.Object r8 = r2.get(r3)
            JsonModels.Response.WalletTransactionListDataItem$TransactionModel r8 = (JsonModels.Response.WalletTransactionListDataItem.TransactionModel) r8
            goto L_0x004a
        L_0x0049:
            r8 = r1
        L_0x004a:
            if (r2 == 0) goto L_0x008d
            java.util.Iterator r2 = r2.iterator()
        L_0x0050:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x008d
            java.lang.Object r3 = r2.next()
            JsonModels.Response.WalletTransactionListDataItem$TransactionModel r3 = (JsonModels.Response.WalletTransactionListDataItem.TransactionModel) r3
            java.lang.String r4 = r3.getDate()
            if (r4 == 0) goto L_0x0089
            java.lang.String r4 = r3.getDate()
            java.lang.String r4 = r6.getMonthAndYearForMapingAndGrouping(r4)
            if (r8 == 0) goto L_0x0071
            java.lang.String r5 = r8.getDate()
            goto L_0x0072
        L_0x0071:
            r5 = r1
        L_0x0072:
            java.lang.String r5 = r6.getMonthAndYearForMapingAndGrouping(r5)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x0089
            JsonModels.Response.WalletTransactionListDataItem$Header r8 = new JsonModels.Response.WalletTransactionListDataItem$Header
            java.lang.String r4 = r3.getDate()
            r8.<init>(r4)
            r0.add(r8)
            r8 = r3
        L_0x0089:
            r0.add(r3)
            goto L_0x0050
        L_0x008d:
            JsonModels.Response.WalletTransactionListDataModel r8 = new JsonModels.Response.WalletTransactionListDataModel
            if (r7 == 0) goto L_0x009b
            JsonModels.Response.WalletTransactionListResult r7 = r7.getResult()
            if (r7 == 0) goto L_0x009b
            java.util.List r1 = r7.getSpendPerMonthList()
        L_0x009b:
            r8.<init>(r0, r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.screens.walletDashboard.interactor.WalletTransactionDashboardScreenInteractor.getWalletTransactionListDataModel(JsonModels.Response.WalletTransactionListResponse, JsonModels.Response.WalletTransactionListDataItem$TransactionModel):JsonModels.Response.WalletTransactionListDataModel");
    }

    public void unregister() {
        this.walletTransactionDashboardScreenListener = null;
    }
}
