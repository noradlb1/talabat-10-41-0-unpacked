package com.appboy.models.cards;

import bo.app.b2;
import bo.app.d2;
import com.appboy.enums.CardKey;
import com.appboy.enums.CardType;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/appboy/models/cards/BannerImageCard;", "Lcom/appboy/models/cards/Card;", "", "toString", "imageUrl", "Ljava/lang/String;", "getImageUrl", "()Ljava/lang/String;", "url", "getUrl", "domain", "getDomain", "", "aspectRatio", "F", "getAspectRatio", "()F", "Lcom/appboy/enums/CardType;", "cardType", "Lcom/appboy/enums/CardType;", "getCardType", "()Lcom/appboy/enums/CardType;", "Lorg/json/JSONObject;", "jsonObject", "Lcom/appboy/enums/CardKey$Provider;", "cardKeyProvider", "Lbo/app/b2;", "manager", "Lcom/braze/storage/ICardStorageProvider;", "cardStorageProvider", "Lbo/app/d2;", "cardAnalyticsProvider", "<init>", "(Lorg/json/JSONObject;Lcom/appboy/enums/CardKey$Provider;Lbo/app/b2;Lcom/braze/storage/ICardStorageProvider;Lbo/app/d2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class BannerImageCard extends Card {
    private final float aspectRatio;
    private final CardType cardType;
    private final String domain;
    private final String imageUrl;
    private final String url;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BannerImageCard(JSONObject jSONObject, CardKey.Provider provider) {
        this(jSONObject, provider, (b2) null, (ICardStorageProvider) null, (d2) null, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BannerImageCard(JSONObject jSONObject, CardKey.Provider provider, b2 b2Var) {
        this(jSONObject, provider, b2Var, (ICardStorageProvider) null, (d2) null, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BannerImageCard(JSONObject jSONObject, CardKey.Provider provider, b2 b2Var, ICardStorageProvider<?> iCardStorageProvider) {
        this(jSONObject, provider, b2Var, iCardStorageProvider, (d2) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BannerImageCard(JSONObject jSONObject, CardKey.Provider provider, b2 b2Var, ICardStorageProvider iCardStorageProvider, d2 d2Var, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject, provider, (i11 & 4) != 0 ? null : b2Var, (i11 & 8) != 0 ? null : iCardStorageProvider, (i11 & 16) != 0 ? null : d2Var);
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public CardType getCardType() {
        return this.cardType;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return StringsKt__IndentKt.trimIndent("\n            BannerImageCard{imageUrl='" + this.imageUrl + "'\n            url='" + getUrl() + "'\n            domain='" + this.domain + "'\n            aspectRatio=" + this.aspectRatio + "\n            " + super.toString() + "}\n            \n        ");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerImageCard(JSONObject jSONObject, CardKey.Provider provider, b2 b2Var, ICardStorageProvider<?> iCardStorageProvider, d2 d2Var) {
        super(jSONObject, provider, b2Var, iCardStorageProvider, d2Var);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
        String string = jSONObject.getString(provider.getKey(CardKey.BANNER_IMAGE_IMAGE));
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(car…dKey.BANNER_IMAGE_IMAGE))");
        this.imageUrl = string;
        this.url = JsonUtils.getOptionalString(jSONObject, provider.getKey(CardKey.BANNER_IMAGE_URL));
        this.domain = JsonUtils.getOptionalString(jSONObject, provider.getKey(CardKey.BANNER_IMAGE_DOMAIN));
        this.aspectRatio = (float) jSONObject.optDouble(provider.getKey(CardKey.BANNER_IMAGE_ASPECT_RATIO), 0.0d);
        this.cardType = CardType.BANNER;
    }
}
