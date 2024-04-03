package com.talabat.wallet.ui.walletDashboard.model;

import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.wallet.features.walletTransactionList.model.response.TransactionModel;
import com.talabat.wallet.features.walletTransactionList.model.response.WalletTransactionSpentPerMonthModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListMapper;", "", "()V", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionListMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\tJ \u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListMapper$Companion;", "", "()V", "mapListOfAmountSpentInMonthToDisplayModel", "", "Lcom/talabat/wallet/ui/walletDashboard/model/MonthlySpentDisplayModel;", "listOfSpentPerMonth", "Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionSpentPerMonthModel;", "mapTransactionModelToDisplayModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;", "transactionModel", "Lcom/talabat/wallet/features/walletTransactionList/model/response/TransactionModel;", "mapTransactionsToDisplayModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel;", "transactionList", "lastTransactionModel", "mapWalletTransactionListToDisplayModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDisplayModel;", "response", "Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionListResponse;", "isFirstResponse", "", "lastDisplayModel", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<MonthlySpentDisplayModel> mapListOfAmountSpentInMonthToDisplayModel(@Nullable List<WalletTransactionSpentPerMonthModel> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (WalletTransactionSpentPerMonthModel next : list) {
                    MonthlySpentDisplayModel monthlySpentDisplayModel = new MonthlySpentDisplayModel();
                    String month = next.getMonth();
                    if (month == null) {
                        month = "";
                    }
                    monthlySpentDisplayModel.setMonth(month);
                    monthlySpentDisplayModel.setAmount(FloatKt.orZero(next.getSpendAmount()));
                    arrayList.add(monthlySpentDisplayModel);
                }
            }
            return arrayList;
        }

        @NotNull
        public final WalletTransactionListDataItemDisplayModel.TransactionDisplayModel mapTransactionModelToDisplayModel(@Nullable TransactionModel transactionModel) {
            Integer num;
            Integer num2;
            String str;
            String str2;
            String str3;
            Integer num3;
            String str4;
            Float f11;
            Float f12;
            WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel = new WalletTransactionListDataItemDisplayModel.TransactionDisplayModel();
            String str5 = null;
            if (transactionModel != null) {
                num = transactionModel.getId();
            } else {
                num = null;
            }
            transactionDisplayModel.setId(IntKt.orZero(num));
            if (transactionModel != null) {
                num2 = transactionModel.getTransactionId();
            } else {
                num2 = null;
            }
            transactionDisplayModel.setTransactionId(IntKt.orZero(num2));
            if (transactionModel != null) {
                str = transactionModel.getName();
            } else {
                str = null;
            }
            String str6 = "";
            if (str == null) {
                str = str6;
            }
            transactionDisplayModel.setName(str);
            if (transactionModel != null) {
                str2 = transactionModel.getImageUrl();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = str6;
            }
            transactionDisplayModel.setImageUrl(str2);
            if (transactionModel != null) {
                str3 = transactionModel.getDescription();
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = str6;
            }
            transactionDisplayModel.setDescription(str3);
            if (transactionModel != null) {
                num3 = transactionModel.getTransactionTypeId();
            } else {
                num3 = null;
            }
            transactionDisplayModel.setTransactionTypeId(IntKt.orZero(num3));
            if (transactionModel != null) {
                str4 = transactionModel.getTransactionTypeName();
            } else {
                str4 = null;
            }
            if (str4 == null) {
                str4 = str6;
            }
            transactionDisplayModel.setTransactionTypeName(str4);
            if (transactionModel != null) {
                f11 = transactionModel.getAmount();
            } else {
                f11 = null;
            }
            transactionDisplayModel.setAmount(FloatKt.orZero(f11));
            if (transactionModel != null) {
                f12 = transactionModel.getCashbackAmount();
            } else {
                f12 = null;
            }
            transactionDisplayModel.setCashBackAmount(FloatKt.orZero(f12));
            if (transactionModel != null) {
                str5 = transactionModel.getDate();
            }
            if (str5 != null) {
                str6 = str5;
            }
            transactionDisplayModel.setDate(str6);
            return transactionDisplayModel;
        }

        @NotNull
        public final List<WalletTransactionListDataItemDisplayModel> mapTransactionsToDisplayModel(@Nullable List<TransactionModel> list, @NotNull WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel) {
            Intrinsics.checkNotNullParameter(transactionDisplayModel, "lastTransactionModel");
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (TransactionModel next : list) {
                    String date = next.getDate();
                    if (date != null) {
                        DateUtils.Companion companion = DateUtils.Companion;
                        if (!Intrinsics.areEqual((Object) companion.getFormattedDateString(date, "yyyy-MM"), (Object) companion.getFormattedDateString(transactionDisplayModel.getDate(), "yyyy-MM"))) {
                            WalletTransactionListDataItemDisplayModel.TransactionGroupHeaderModel transactionGroupHeaderModel = new WalletTransactionListDataItemDisplayModel.TransactionGroupHeaderModel();
                            String date2 = next.getDate();
                            if (date2 == null) {
                                date2 = "";
                            }
                            transactionGroupHeaderModel.setDate(date2);
                            arrayList.add(transactionGroupHeaderModel);
                            transactionDisplayModel = WalletTransactionListMapper.Companion.mapTransactionModelToDisplayModel(next);
                        }
                        arrayList.add(WalletTransactionListMapper.Companion.mapTransactionModelToDisplayModel(next));
                    }
                }
            }
            return arrayList;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel$TransactionDisplayModel} */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDisplayModel mapWalletTransactionListToDisplayModel(@org.jetbrains.annotations.Nullable com.talabat.wallet.features.walletTransactionList.model.response.WalletTransactionListResponse r7, boolean r8, @org.jetbrains.annotations.NotNull com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel.TransactionDisplayModel r9) {
            /*
                r6 = this;
                java.lang.String r0 = "lastDisplayModel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r1 = 0
                if (r7 == 0) goto L_0x0018
                com.talabat.wallet.features.walletTransactionList.model.response.WalletTransactionListResult r2 = r7.getResult()
                if (r2 == 0) goto L_0x0018
                java.util.List r2 = r2.getTransactionList()
                goto L_0x0019
            L_0x0018:
                r2 = r1
            L_0x0019:
                r3 = 1
                r4 = 0
                if (r8 == 0) goto L_0x0051
                r8 = r2
                java.util.Collection r8 = (java.util.Collection) r8
                if (r8 == 0) goto L_0x002b
                boolean r8 = r8.isEmpty()
                if (r8 == 0) goto L_0x0029
                goto L_0x002b
            L_0x0029:
                r8 = r4
                goto L_0x002c
            L_0x002b:
                r8 = r3
            L_0x002c:
                if (r8 != 0) goto L_0x0051
                com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel$TransactionGroupHeaderModel r8 = new com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel$TransactionGroupHeaderModel
                r8.<init>()
                java.lang.Object r9 = r2.get(r4)
                com.talabat.wallet.features.walletTransactionList.model.response.TransactionModel r9 = (com.talabat.wallet.features.walletTransactionList.model.response.TransactionModel) r9
                java.lang.String r9 = r9.getDate()
                if (r9 != 0) goto L_0x0041
                java.lang.String r9 = ""
            L_0x0041:
                r8.setDate(r9)
                r0.add(r8)
                java.lang.Object r8 = r2.get(r4)
                com.talabat.wallet.features.walletTransactionList.model.response.TransactionModel r8 = (com.talabat.wallet.features.walletTransactionList.model.response.TransactionModel) r8
                com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel$TransactionDisplayModel r9 = r6.mapTransactionModelToDisplayModel(r8)
            L_0x0051:
                java.util.List r8 = r6.mapTransactionsToDisplayModel(r2, r9)
                r2 = r8
                java.util.Collection r2 = (java.util.Collection) r2
                if (r2 == 0) goto L_0x0060
                boolean r5 = r2.isEmpty()
                if (r5 == 0) goto L_0x0061
            L_0x0060:
                r4 = r3
            L_0x0061:
                if (r4 != 0) goto L_0x006d
                java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.last(r8)
                r9 = r8
                com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel$TransactionDisplayModel r9 = (com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel.TransactionDisplayModel) r9
                r0.addAll(r2)
            L_0x006d:
                if (r7 == 0) goto L_0x0079
                com.talabat.wallet.features.walletTransactionList.model.response.WalletTransactionListResult r7 = r7.getResult()
                if (r7 == 0) goto L_0x0079
                java.util.List r1 = r7.getSpendPerMonthList()
            L_0x0079:
                java.util.List r7 = r6.mapListOfAmountSpentInMonthToDisplayModel(r1)
                com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDisplayModel r8 = new com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDisplayModel
                r8.<init>()
                r8.setWalletTransactionListLoaded(r3)
                r8.setWalletTransactionList(r0)
                r8.setSpendPerMonthList(r7)
                r8.setLastTransactionDisplayModel(r9)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListMapper.Companion.mapWalletTransactionListToDisplayModel(com.talabat.wallet.features.walletTransactionList.model.response.WalletTransactionListResponse, boolean, com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel$TransactionDisplayModel):com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDisplayModel");
        }
    }
}
