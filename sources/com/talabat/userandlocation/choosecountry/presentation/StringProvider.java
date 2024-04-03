package com.talabat.userandlocation.choosecountry.presentation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001:\u0001\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/presentation/StringProvider;", "", "clearCartConfirmationStrings", "Lcom/talabat/userandlocation/choosecountry/presentation/StringProvider$ClearCartConfirmationStrings;", "getClearCartConfirmationStrings", "()Lcom/talabat/userandlocation/choosecountry/presentation/StringProvider$ClearCartConfirmationStrings;", "genericErrorMessage", "", "getGenericErrorMessage", "()Ljava/lang/String;", "screenTitle", "getScreenTitle", "ClearCartConfirmationStrings", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface StringProvider {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/presentation/StringProvider$ClearCartConfirmationStrings;", "", "title", "", "message", "positiveButton", "negativeButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getNegativeButton", "getPositiveButton", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ClearCartConfirmationStrings {
        @NotNull
        private final String message;
        @NotNull
        private final String negativeButton;
        @NotNull
        private final String positiveButton;
        @NotNull
        private final String title;

        public ClearCartConfirmationStrings(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "message");
            Intrinsics.checkNotNullParameter(str3, "positiveButton");
            Intrinsics.checkNotNullParameter(str4, "negativeButton");
            this.title = str;
            this.message = str2;
            this.positiveButton = str3;
            this.negativeButton = str4;
        }

        public static /* synthetic */ ClearCartConfirmationStrings copy$default(ClearCartConfirmationStrings clearCartConfirmationStrings, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = clearCartConfirmationStrings.title;
            }
            if ((i11 & 2) != 0) {
                str2 = clearCartConfirmationStrings.message;
            }
            if ((i11 & 4) != 0) {
                str3 = clearCartConfirmationStrings.positiveButton;
            }
            if ((i11 & 8) != 0) {
                str4 = clearCartConfirmationStrings.negativeButton;
            }
            return clearCartConfirmationStrings.copy(str, str2, str3, str4);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final String component2() {
            return this.message;
        }

        @NotNull
        public final String component3() {
            return this.positiveButton;
        }

        @NotNull
        public final String component4() {
            return this.negativeButton;
        }

        @NotNull
        public final ClearCartConfirmationStrings copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "message");
            Intrinsics.checkNotNullParameter(str3, "positiveButton");
            Intrinsics.checkNotNullParameter(str4, "negativeButton");
            return new ClearCartConfirmationStrings(str, str2, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClearCartConfirmationStrings)) {
                return false;
            }
            ClearCartConfirmationStrings clearCartConfirmationStrings = (ClearCartConfirmationStrings) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) clearCartConfirmationStrings.title) && Intrinsics.areEqual((Object) this.message, (Object) clearCartConfirmationStrings.message) && Intrinsics.areEqual((Object) this.positiveButton, (Object) clearCartConfirmationStrings.positiveButton) && Intrinsics.areEqual((Object) this.negativeButton, (Object) clearCartConfirmationStrings.negativeButton);
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @NotNull
        public final String getNegativeButton() {
            return this.negativeButton;
        }

        @NotNull
        public final String getPositiveButton() {
            return this.positiveButton;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((((this.title.hashCode() * 31) + this.message.hashCode()) * 31) + this.positiveButton.hashCode()) * 31) + this.negativeButton.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.title;
            String str2 = this.message;
            String str3 = this.positiveButton;
            String str4 = this.negativeButton;
            return "ClearCartConfirmationStrings(title=" + str + ", message=" + str2 + ", positiveButton=" + str3 + ", negativeButton=" + str4 + ")";
        }
    }

    @NotNull
    ClearCartConfirmationStrings getClearCartConfirmationStrings();

    @NotNull
    String getGenericErrorMessage();

    @NotNull
    String getScreenTitle();
}
