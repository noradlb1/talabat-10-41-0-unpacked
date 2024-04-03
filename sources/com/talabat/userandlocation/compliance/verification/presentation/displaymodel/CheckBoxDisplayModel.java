package com.talabat.userandlocation.compliance.verification.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/CheckBoxDisplayModel;", "", "()V", "DontShow", "MarkAsError", "Show", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/CheckBoxDisplayModel$DontShow;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/CheckBoxDisplayModel$Show;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/CheckBoxDisplayModel$MarkAsError;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CheckBoxDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/CheckBoxDisplayModel$DontShow;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/CheckBoxDisplayModel;", "()V", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DontShow extends CheckBoxDisplayModel {
        @NotNull
        public static final DontShow INSTANCE = new DontShow();

        private DontShow() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/CheckBoxDisplayModel$MarkAsError;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/CheckBoxDisplayModel;", "()V", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MarkAsError extends CheckBoxDisplayModel {
        @NotNull
        public static final MarkAsError INSTANCE = new MarkAsError();

        private MarkAsError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/CheckBoxDisplayModel$Show;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/CheckBoxDisplayModel;", "message", "", "checked", "", "(Ljava/lang/String;Z)V", "getChecked", "()Z", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Show extends CheckBoxDisplayModel {
        private final boolean checked;
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Show(@NotNull String str, boolean z11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
            this.checked = z11;
        }

        public static /* synthetic */ Show copy$default(Show show, String str, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = show.message;
            }
            if ((i11 & 2) != 0) {
                z11 = show.checked;
            }
            return show.copy(str, z11);
        }

        @NotNull
        public final String component1() {
            return this.message;
        }

        public final boolean component2() {
            return this.checked;
        }

        @NotNull
        public final Show copy(@NotNull String str, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new Show(str, z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Show)) {
                return false;
            }
            Show show = (Show) obj;
            return Intrinsics.areEqual((Object) this.message, (Object) show.message) && this.checked == show.checked;
        }

        public final boolean getChecked() {
            return this.checked;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            int hashCode = this.message.hashCode() * 31;
            boolean z11 = this.checked;
            if (z11) {
                z11 = true;
            }
            return hashCode + (z11 ? 1 : 0);
        }

        @NotNull
        public String toString() {
            String str = this.message;
            boolean z11 = this.checked;
            return "Show(message=" + str + ", checked=" + z11 + ")";
        }
    }

    private CheckBoxDisplayModel() {
    }

    public /* synthetic */ CheckBoxDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
