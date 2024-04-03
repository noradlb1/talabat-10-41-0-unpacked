package com.talabat.userandlocation.compliance.verification.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/EditFieldDisplayModel;", "", "()V", "DontShow", "MarkAsError", "Show", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/EditFieldDisplayModel$DontShow;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/EditFieldDisplayModel$Show;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/EditFieldDisplayModel$MarkAsError;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class EditFieldDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/EditFieldDisplayModel$DontShow;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/EditFieldDisplayModel;", "()V", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DontShow extends EditFieldDisplayModel {
        @NotNull
        public static final DontShow INSTANCE = new DontShow();

        private DontShow() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/EditFieldDisplayModel$MarkAsError;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/EditFieldDisplayModel;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MarkAsError extends EditFieldDisplayModel {
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MarkAsError(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public static /* synthetic */ MarkAsError copy$default(MarkAsError markAsError, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = markAsError.message;
            }
            return markAsError.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.message;
        }

        @NotNull
        public final MarkAsError copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new MarkAsError(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MarkAsError) && Intrinsics.areEqual((Object) this.message, (Object) ((MarkAsError) obj).message);
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.message;
            return "MarkAsError(message=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/EditFieldDisplayModel$Show;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/EditFieldDisplayModel;", "value", "", "editable", "", "(Ljava/lang/String;Z)V", "getEditable", "()Z", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Show extends EditFieldDisplayModel {
        private final boolean editable;
        @NotNull
        private final String value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Show(@NotNull String str, boolean z11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "value");
            this.value = str;
            this.editable = z11;
        }

        public static /* synthetic */ Show copy$default(Show show, String str, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = show.value;
            }
            if ((i11 & 2) != 0) {
                z11 = show.editable;
            }
            return show.copy(str, z11);
        }

        @NotNull
        public final String component1() {
            return this.value;
        }

        public final boolean component2() {
            return this.editable;
        }

        @NotNull
        public final Show copy(@NotNull String str, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "value");
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
            return Intrinsics.areEqual((Object) this.value, (Object) show.value) && this.editable == show.editable;
        }

        public final boolean getEditable() {
            return this.editable;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            int hashCode = this.value.hashCode() * 31;
            boolean z11 = this.editable;
            if (z11) {
                z11 = true;
            }
            return hashCode + (z11 ? 1 : 0);
        }

        @NotNull
        public String toString() {
            String str = this.value;
            boolean z11 = this.editable;
            return "Show(value=" + str + ", editable=" + z11 + ")";
        }
    }

    private EditFieldDisplayModel() {
    }

    public /* synthetic */ EditFieldDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
