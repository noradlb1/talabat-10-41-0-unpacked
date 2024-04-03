package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingTitleSpanningModel;", "", "text", "", "color", "(Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingTitleSpanningModel {
    @NotNull
    private final String color;
    @NotNull
    private final String text;

    public TProOnBoardingTitleSpanningModel(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "color");
        this.text = str;
        this.color = str2;
    }

    public static /* synthetic */ TProOnBoardingTitleSpanningModel copy$default(TProOnBoardingTitleSpanningModel tProOnBoardingTitleSpanningModel, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingTitleSpanningModel.text;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingTitleSpanningModel.color;
        }
        return tProOnBoardingTitleSpanningModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    @NotNull
    public final String component2() {
        return this.color;
    }

    @NotNull
    public final TProOnBoardingTitleSpanningModel copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "color");
        return new TProOnBoardingTitleSpanningModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingTitleSpanningModel)) {
            return false;
        }
        TProOnBoardingTitleSpanningModel tProOnBoardingTitleSpanningModel = (TProOnBoardingTitleSpanningModel) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) tProOnBoardingTitleSpanningModel.text) && Intrinsics.areEqual((Object) this.color, (Object) tProOnBoardingTitleSpanningModel.color);
    }

    @NotNull
    public final String getColor() {
        return this.color;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.color.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.text;
        String str2 = this.color;
        return "TProOnBoardingTitleSpanningModel(text=" + str + ", color=" + str2 + ")";
    }
}
