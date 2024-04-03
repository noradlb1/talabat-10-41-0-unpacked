package com.talabat.talabatcommon.views.wallet.dsalert;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u001b\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/dsalert/DSAlertType;", "", "color", "", "icon", "(Ljava/lang/String;III)V", "getColor", "()I", "getIcon", "ERROR", "WARNING", "INFO", "SUCCESS", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum DSAlertType {
    ERROR(R.color.ds_danger_10, com.talabat.talabatcommon.R.drawable.ic_ds_error),
    WARNING(R.color.ds_alert_10, com.talabat.talabatcommon.R.drawable.ic_ds_warning),
    INFO(R.color.ds_secondary_10, com.talabat.talabatcommon.R.drawable.ic_ds_info),
    SUCCESS(R.color.ds_success_10, com.talabat.talabatcommon.R.drawable.ic_ds_success);
    
    @NotNull
    public static final Companion Companion = null;
    private final int color;
    private final int icon;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/dsalert/DSAlertType$Companion;", "", "()V", "valueOf", "Lcom/talabat/talabatcommon/views/wallet/dsalert/DSAlertType;", "value", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DSAlertType valueOf(int i11) {
            return DSAlertType.values()[i11];
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private DSAlertType(@ColorRes int i11, @DrawableRes int i12) {
        this.color = i11;
        this.icon = i12;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getIcon() {
        return this.icon;
    }
}
