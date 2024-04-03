package com.talabat.feature.darkstores.vendorlanding.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/model/ImageUrl;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageUrl {
    @NotNull
    private final String url;

    public ImageUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.url = str;
    }

    public static /* synthetic */ ImageUrl copy$default(ImageUrl imageUrl, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = imageUrl.url;
        }
        return imageUrl.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final ImageUrl copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return new ImageUrl(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageUrl) && Intrinsics.areEqual((Object) this.url, (Object) ((ImageUrl) obj).url);
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.url;
        return "ImageUrl(url=" + str + ")";
    }
}
