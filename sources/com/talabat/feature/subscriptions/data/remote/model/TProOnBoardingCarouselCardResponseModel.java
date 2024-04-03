package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCarouselCardResponseModel;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCardResponseModel;", "content", "", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCarouselContentResponseModel;", "(Ljava/util/List;)V", "getContent", "()Ljava/util/List;", "setContent", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingCarouselCardResponseModel extends TProOnBoardingCardResponseModel {
    @Nullable
    private List<TProOnBoardingCarouselContentResponseModel> content;

    public TProOnBoardingCarouselCardResponseModel() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TProOnBoardingCarouselCardResponseModel(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list);
    }

    public static /* synthetic */ TProOnBoardingCarouselCardResponseModel copy$default(TProOnBoardingCarouselCardResponseModel tProOnBoardingCarouselCardResponseModel, List<TProOnBoardingCarouselContentResponseModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = tProOnBoardingCarouselCardResponseModel.content;
        }
        return tProOnBoardingCarouselCardResponseModel.copy(list);
    }

    @Nullable
    public final List<TProOnBoardingCarouselContentResponseModel> component1() {
        return this.content;
    }

    @NotNull
    public final TProOnBoardingCarouselCardResponseModel copy(@Nullable @Json(name = "content") List<TProOnBoardingCarouselContentResponseModel> list) {
        return new TProOnBoardingCarouselCardResponseModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TProOnBoardingCarouselCardResponseModel) && Intrinsics.areEqual((Object) this.content, (Object) ((TProOnBoardingCarouselCardResponseModel) obj).content);
    }

    @Nullable
    public final List<TProOnBoardingCarouselContentResponseModel> getContent() {
        return this.content;
    }

    public int hashCode() {
        List<TProOnBoardingCarouselContentResponseModel> list = this.content;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setContent(@Nullable List<TProOnBoardingCarouselContentResponseModel> list) {
        this.content = list;
    }

    @NotNull
    public String toString() {
        List<TProOnBoardingCarouselContentResponseModel> list = this.content;
        return "TProOnBoardingCarouselCardResponseModel(content=" + list + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TProOnBoardingCarouselCardResponseModel(@org.jetbrains.annotations.Nullable @com.squareup.moshi.Json(name = "content") java.util.List<com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCarouselContentResponseModel> r12) {
        /*
            r11 = this;
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCardTypeResponse r0 = com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCardTypeResponse.CAROUSEL
            java.lang.String r0 = r0.name()
            java.util.Locale r8 = java.util.Locale.ROOT
            java.lang.String r8 = r0.toLowerCase(r8)
            java.lang.String r0 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            r9 = 127(0x7f, float:1.78E-43)
            r10 = 0
            r0 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.content = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCarouselCardResponseModel.<init>(java.util.List):void");
    }
}
