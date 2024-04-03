package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001Bm\b\u0004\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013\u0001\u0006()*+,-¨\u0006."}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCardResponseModel;", "", "trackingId", "", "topImage", "cardBackgroundColor", "cardBackgroundImage", "titleSpanning", "", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingTitleSpanningResponseModel;", "haveMore", "", "moreContent", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingMoreContentResponseModel;", "cardType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingMoreContentResponseModel;Ljava/lang/String;)V", "getCardBackgroundColor", "()Ljava/lang/String;", "setCardBackgroundColor", "(Ljava/lang/String;)V", "getCardBackgroundImage", "setCardBackgroundImage", "getCardType", "getHaveMore", "()Ljava/lang/Boolean;", "setHaveMore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMoreContent", "()Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingMoreContentResponseModel;", "setMoreContent", "(Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingMoreContentResponseModel;)V", "getTitleSpanning", "()Ljava/util/List;", "setTitleSpanning", "(Ljava/util/List;)V", "getTopImage", "setTopImage", "getTrackingId", "setTrackingId", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCapsuleCardResponseModel;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCardDefaultResponseModel;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCardLotteResponseModel;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingTagsCardResponseModel;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCarouselCardResponseModel;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingGridCardResponseModel;", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TProOnBoardingCardResponseModel {
    @Nullable
    private String cardBackgroundColor;
    @Nullable
    private String cardBackgroundImage;
    @Nullable
    private final String cardType;
    @Nullable
    private Boolean haveMore;
    @Nullable
    private TProOnBoardingMoreContentResponseModel moreContent;
    @Nullable
    private List<TProOnBoardingTitleSpanningResponseModel> titleSpanning;
    @Nullable
    private String topImage;
    @Nullable
    private String trackingId;

    private TProOnBoardingCardResponseModel(@Json(name = "trackingId") String str, @Json(name = "topImage") String str2, @Json(name = "cardBackgroundColor") String str3, @Json(name = "cardBackgroundImage") String str4, @Json(name = "titleSpanning") List<TProOnBoardingTitleSpanningResponseModel> list, @Json(name = "haveMore") Boolean bool, @Json(name = "moreContent") TProOnBoardingMoreContentResponseModel tProOnBoardingMoreContentResponseModel, @Json(name = "cardType") String str5) {
        this.trackingId = str;
        this.topImage = str2;
        this.cardBackgroundColor = str3;
        this.cardBackgroundImage = str4;
        this.titleSpanning = list;
        this.haveMore = bool;
        this.moreContent = tProOnBoardingMoreContentResponseModel;
        this.cardType = str5;
    }

    public /* synthetic */ TProOnBoardingCardResponseModel(String str, String str2, String str3, String str4, List list, Boolean bool, TProOnBoardingMoreContentResponseModel tProOnBoardingMoreContentResponseModel, String str5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, list, bool, tProOnBoardingMoreContentResponseModel, str5);
    }

    @Nullable
    public final String getCardBackgroundColor() {
        return this.cardBackgroundColor;
    }

    @Nullable
    public final String getCardBackgroundImage() {
        return this.cardBackgroundImage;
    }

    @Nullable
    public final String getCardType() {
        return this.cardType;
    }

    @Nullable
    public final Boolean getHaveMore() {
        return this.haveMore;
    }

    @Nullable
    public final TProOnBoardingMoreContentResponseModel getMoreContent() {
        return this.moreContent;
    }

    @Nullable
    public final List<TProOnBoardingTitleSpanningResponseModel> getTitleSpanning() {
        return this.titleSpanning;
    }

    @Nullable
    public final String getTopImage() {
        return this.topImage;
    }

    @Nullable
    public final String getTrackingId() {
        return this.trackingId;
    }

    public final void setCardBackgroundColor(@Nullable String str) {
        this.cardBackgroundColor = str;
    }

    public final void setCardBackgroundImage(@Nullable String str) {
        this.cardBackgroundImage = str;
    }

    public final void setHaveMore(@Nullable Boolean bool) {
        this.haveMore = bool;
    }

    public final void setMoreContent(@Nullable TProOnBoardingMoreContentResponseModel tProOnBoardingMoreContentResponseModel) {
        this.moreContent = tProOnBoardingMoreContentResponseModel;
    }

    public final void setTitleSpanning(@Nullable List<TProOnBoardingTitleSpanningResponseModel> list) {
        this.titleSpanning = list;
    }

    public final void setTopImage(@Nullable String str) {
        this.topImage = str;
    }

    public final void setTrackingId(@Nullable String str) {
        this.trackingId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TProOnBoardingCardResponseModel(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.util.List r14, java.lang.Boolean r15, com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingMoreContentResponseModel r16, java.lang.String r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r0 = 0
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r19 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCardResponseModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.Boolean, com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingMoreContentResponseModel, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
