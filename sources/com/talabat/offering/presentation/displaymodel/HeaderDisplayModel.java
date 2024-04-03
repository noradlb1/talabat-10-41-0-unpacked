package com.talabat.offering.presentation.displaymodel;

import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel;", "", "()V", "BackgroundColor", "BackgroundImage", "ForegroundImage", "HeaderData", "Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel$HeaderData;", "Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel$ForegroundImage;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class HeaderDisplayModel {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel$BackgroundColor;", "Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel$ForegroundImage;", "color", "", "foregroundImage", "(Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BackgroundColor extends ForegroundImage {
        @NotNull
        private final String color;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BackgroundColor(@NotNull String str, @NotNull String str2) {
            super(str2);
            Intrinsics.checkNotNullParameter(str, "color");
            Intrinsics.checkNotNullParameter(str2, "foregroundImage");
            this.color = str;
        }

        @NotNull
        public final String getColor() {
            return this.color;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel$BackgroundImage;", "Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel$ForegroundImage;", "imageUrl", "", "foregroundImage", "(Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BackgroundImage extends ForegroundImage {
        @NotNull
        private final String imageUrl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BackgroundImage(@NotNull String str, @NotNull String str2) {
            super(str2);
            Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
            Intrinsics.checkNotNullParameter(str2, "foregroundImage");
            this.imageUrl = str;
        }

        @NotNull
        public final String getImageUrl() {
            return this.imageUrl;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel$ForegroundImage;", "Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel;", "foregroundImage", "", "(Ljava/lang/String;)V", "getForegroundImage", "()Ljava/lang/String;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class ForegroundImage extends HeaderDisplayModel {
        @NotNull
        private final String foregroundImage;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ForegroundImage(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "foregroundImage");
            this.foregroundImage = str;
        }

        @NotNull
        public final String getForegroundImage() {
            return this.foregroundImage;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel$HeaderData;", "Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel;", "headerText", "", "secondaryText", "callToActionText", "textColor", "showTermsCondition", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCallToActionText", "()Ljava/lang/String;", "getHeaderText", "getSecondaryText", "getShowTermsCondition", "()Z", "getTextColor", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class HeaderData extends HeaderDisplayModel {
        @Nullable
        private final String callToActionText;
        @Nullable
        private final String headerText;
        @Nullable
        private final String secondaryText;
        private final boolean showTermsCondition;
        @Nullable
        private final String textColor;

        public HeaderData() {
            this((String) null, (String) null, (String) null, (String) null, false, 31, (DefaultConstructorMarker) null);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ HeaderData(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, boolean r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
            /*
                r3 = this;
                r10 = r9 & 1
                r0 = 0
                if (r10 == 0) goto L_0x0007
                r10 = r0
                goto L_0x0008
            L_0x0007:
                r10 = r4
            L_0x0008:
                r4 = r9 & 2
                if (r4 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r5
            L_0x000f:
                r4 = r9 & 4
                if (r4 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r6
            L_0x0016:
                r4 = r9 & 8
                if (r4 == 0) goto L_0x001b
                goto L_0x001c
            L_0x001b:
                r0 = r7
            L_0x001c:
                r4 = r9 & 16
                if (r4 == 0) goto L_0x0021
                r8 = 0
            L_0x0021:
                r9 = r8
                r4 = r3
                r5 = r10
                r6 = r1
                r7 = r2
                r8 = r0
                r4.<init>(r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.presentation.displaymodel.HeaderDisplayModel.HeaderData.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        @Nullable
        public final String getCallToActionText() {
            return this.callToActionText;
        }

        @Nullable
        public final String getHeaderText() {
            return this.headerText;
        }

        @Nullable
        public final String getSecondaryText() {
            return this.secondaryText;
        }

        public final boolean getShowTermsCondition() {
            return this.showTermsCondition;
        }

        @Nullable
        public final String getTextColor() {
            return this.textColor;
        }

        public HeaderData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z11) {
            super((DefaultConstructorMarker) null);
            this.headerText = str;
            this.secondaryText = str2;
            this.callToActionText = str3;
            this.textColor = str4;
            this.showTermsCondition = z11;
        }
    }

    private HeaderDisplayModel() {
    }

    public /* synthetic */ HeaderDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
