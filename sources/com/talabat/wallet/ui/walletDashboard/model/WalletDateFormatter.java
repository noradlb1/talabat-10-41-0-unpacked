package com.talabat.wallet.ui.walletDashboard.model;

import com.talabat.talabatcommon.utils.DateConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletDateFormatter;", "", "()V", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDateFormatter {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletDateFormatter$Companion;", "", "()V", "getMonthAndYearForTransactionListGrouping", "", "date", "datePattern", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getMonthAndYearForTransactionListGrouping(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "date");
            Intrinsics.checkNotNullParameter(str2, "datePattern");
            try {
                Locale locale = Locale.ENGLISH;
                Date parse = new SimpleDateFormat(DateConstants.DEFAULT_UTC_FORMAT, locale).parse(str);
                Calendar instance = Calendar.getInstance();
                instance.setTime(parse);
                String format = new SimpleDateFormat(str2, locale).format(instance.getTime());
                Intrinsics.checkNotNullExpressionValue(format, "{\n                val d …t(cal.time)\n            }");
                return format;
            } catch (Exception unused) {
                return "";
            }
        }
    }
}
