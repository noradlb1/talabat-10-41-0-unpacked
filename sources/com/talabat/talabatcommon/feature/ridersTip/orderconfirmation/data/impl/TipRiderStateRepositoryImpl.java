package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.data.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.repository.TipRiderStateRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/data/impl/TipRiderStateRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/repository/TipRiderStateRepository;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "getTipRiderStatus", "", "encryptedOrderId", "", "setTipRiderStatus", "", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TipRiderStateRepositoryImpl implements TipRiderStateRepository {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String ENCRYPTED_ORDER_ID = "encryptedOrderId";
    @NotNull
    @Deprecated
    public static final String PREF_NAME = "TipRiderPref";
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/data/impl/TipRiderStateRepositoryImpl$Companion;", "", "()V", "ENCRYPTED_ORDER_ID", "", "PREF_NAME", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TipRiderStateRepositoryImpl() {
        this((Context) null, 1, (DefaultConstructorMarker) null);
    }

    public TipRiderStateRepositoryImpl(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final SharedPreferences getSharedPreferences() {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(PREF_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    public boolean getTipRiderStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        return Intrinsics.areEqual((Object) getSharedPreferences().getString("encryptedOrderId", StringUtils.empty(StringCompanionObject.INSTANCE)), (Object) str);
    }

    public void setTipRiderStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        getSharedPreferences().edit().putString("encryptedOrderId", str).apply();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TipRiderStateRepositoryImpl(android.content.Context r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x0013
            com.talabat.talabatcore.application.BaseApplication$Companion r1 = com.talabat.talabatcore.application.BaseApplication.Companion
            com.talabat.talabatcore.application.BaseApplication r1 = r1.getInstance()
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r2 = "BaseApplication.instance.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x0013:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.data.impl.TipRiderStateRepositoryImpl.<init>(android.content.Context, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
