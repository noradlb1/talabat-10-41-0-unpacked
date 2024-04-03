package com.talabat.userandlocation.compliance.verification.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/ButtonDisplayModel;", "", "()V", "Show", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/ButtonDisplayModel$Show;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ButtonDisplayModel {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/ButtonDisplayModel$Show;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/ButtonDisplayModel;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Show extends ButtonDisplayModel {
        @NotNull
        private final String text;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Show(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
        }

        public static /* synthetic */ Show copy$default(Show show, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = show.text;
            }
            return show.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.text;
        }

        @NotNull
        public final Show copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new Show(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Show) && Intrinsics.areEqual((Object) this.text, (Object) ((Show) obj).text);
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.text;
            return "Show(text=" + str + ")";
        }
    }

    private ButtonDisplayModel() {
    }

    public /* synthetic */ ButtonDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
