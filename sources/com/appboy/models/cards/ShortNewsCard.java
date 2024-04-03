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

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/appboy/models/cards/ShortNewsCard;", "Lcom/appboy/models/cards/Card;", "", "toString", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "imageUrl", "getImageUrl", "title", "getTitle", "url", "getUrl", "domain", "getDomain", "Lcom/appboy/enums/CardType;", "cardType", "Lcom/appboy/enums/CardType;", "getCardType", "()Lcom/appboy/enums/CardType;", "Lorg/json/JSONObject;", "jsonObject", "Lcom/appboy/enums/CardKey$Provider;", "cardKeyProvider", "Lbo/app/b2;", "manager", "Lcom/braze/storage/ICardStorageProvider;", "cardStorageProvider", "Lbo/app/d2;", "cardAnalyticsProvider", "<init>", "(Lorg/json/JSONObject;Lcom/appboy/enums/CardKey$Provider;Lbo/app/b2;Lcom/braze/storage/ICardStorageProvider;Lbo/app/d2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class ShortNewsCard extends Card {
    private final CardType cardType;
    private final String description;
    private final String domain;
    private final String imageUrl;
    private final String title;
    private final String url;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShortNewsCard(JSONObject jSONObject, CardKey.Provider provider) {
        this(jSONObject, provider, (b2) null, (ICardStorageProvider) null, (d2) null, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShortNewsCard(JSONObject jSONObject, CardKey.Provider provider, b2 b2Var) {
        this(jSONObject, provider, b2Var, (ICardStorageProvider) null, (d2) null, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShortNewsCard(JSONObject jSONObject, CardKey.Provider provider, b2 b2Var, ICardStorageProvider<?> iCardStorageProvider) {
        this(jSONObject, provider, b2Var, iCardStorageProvider, (d2) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShortNewsCard(JSONObject jSONObject, CardKey.Provider provider, b2 b2Var, ICardStorageProvider iCardStorageProvider, d2 d2Var, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject, provider, (i11 & 4) != 0 ? null : b2Var, (i11 & 8) != 0 ? null : iCardStorageProvider, (i11 & 16) != 0 ? null : d2Var);
    }

    public CardType getCardType() {
        return this.cardType;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return StringsKt__IndentKt.trimIndent("\n            ShortNewsCard{description='" + this.description + "'\n            imageUrl='" + this.imageUrl + "'\n            title='" + this.title + "'\n            url='" + getUrl() + "'\n            domain='" + this.domain + "\n            " + super.toString() + "}\n\n        ");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortNewsCard(JSONObject jSONObject, CardKey.Provider provider, b2 b2Var, ICardStorageProvider<?> iCardStorageProvider, d2 d2Var) {
        super(jSONObject, provider, b2Var, iCardStorageProvider, d2Var);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
        String string = jSONObject.getString(provider.getKey(CardKey.SHORT_NEWS_DESCRIPTION));
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(car….SHORT_NEWS_DESCRIPTION))");
        this.description = string;
        String string2 = jSONObject.getString(provider.getKey(CardKey.SHORT_NEWS_IMAGE));
        Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(car…ardKey.SHORT_NEWS_IMAGE))");
        this.imageUrl = string2;
        this.title = JsonUtils.getOptionalString(jSONObject, provider.getKey(CardKey.SHORT_NEWS_TITLE));
        this.url = JsonUtils.getOptionalString(jSONObject, provider.getKey(CardKey.SHORT_NEWS_URL));
        this.domain = JsonUtils.getOptionalString(jSONObject, provider.getKey(CardKey.SHORT_NEWS_DOMAIN));
        this.cardType = CardType.SHORT_NEWS;
    }
}
