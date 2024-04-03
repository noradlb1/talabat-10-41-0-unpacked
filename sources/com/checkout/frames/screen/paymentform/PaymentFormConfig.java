package com.checkout.frames.screen.paymentform;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.base.model.CardScheme;
import com.checkout.base.model.Environment;
import com.checkout.frames.api.PaymentFlowHandler;
import com.checkout.frames.style.screen.PaymentFormStyle;
import com.visa.checkout.Profile;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003JK\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Lcom/checkout/frames/screen/paymentform/PaymentFormConfig;", "", "publicKey", "", "context", "Landroid/content/Context;", "environment", "Lcom/checkout/base/model/Environment;", "style", "Lcom/checkout/frames/style/screen/PaymentFormStyle;", "paymentFlowHandler", "Lcom/checkout/frames/api/PaymentFlowHandler;", "supportedCardSchemeList", "", "Lcom/checkout/base/model/CardScheme;", "(Ljava/lang/String;Landroid/content/Context;Lcom/checkout/base/model/Environment;Lcom/checkout/frames/style/screen/PaymentFormStyle;Lcom/checkout/frames/api/PaymentFlowHandler;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getEnvironment", "()Lcom/checkout/base/model/Environment;", "getPaymentFlowHandler", "()Lcom/checkout/frames/api/PaymentFlowHandler;", "getPublicKey", "()Ljava/lang/String;", "getStyle", "()Lcom/checkout/frames/style/screen/PaymentFormStyle;", "setStyle", "(Lcom/checkout/frames/style/screen/PaymentFormStyle;)V", "getSupportedCardSchemeList", "()Ljava/util/List;", "setSupportedCardSchemeList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormConfig {
    public static final int $stable = 8;
    @NotNull
    private final Context context;
    @NotNull
    private final Environment environment;
    @NotNull
    private final PaymentFlowHandler paymentFlowHandler;
    @NotNull
    private final String publicKey;
    @NotNull
    private PaymentFormStyle style;
    @NotNull
    private List<? extends CardScheme> supportedCardSchemeList;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormConfig(@NotNull String str, @NotNull Context context2, @NotNull Environment environment2, @NotNull PaymentFormStyle paymentFormStyle, @NotNull PaymentFlowHandler paymentFlowHandler2) {
        this(str, context2, environment2, paymentFormStyle, paymentFlowHandler2, (List) null, 32, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "publicKey");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(environment2, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(paymentFormStyle, "style");
        Intrinsics.checkNotNullParameter(paymentFlowHandler2, "paymentFlowHandler");
    }

    @JvmOverloads
    public PaymentFormConfig(@NotNull String str, @NotNull Context context2, @NotNull Environment environment2, @NotNull PaymentFormStyle paymentFormStyle, @NotNull PaymentFlowHandler paymentFlowHandler2, @NotNull List<? extends CardScheme> list) {
        Intrinsics.checkNotNullParameter(str, "publicKey");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(environment2, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(paymentFormStyle, "style");
        Intrinsics.checkNotNullParameter(paymentFlowHandler2, "paymentFlowHandler");
        Intrinsics.checkNotNullParameter(list, "supportedCardSchemeList");
        this.publicKey = str;
        this.context = context2;
        this.environment = environment2;
        this.style = paymentFormStyle;
        this.paymentFlowHandler = paymentFlowHandler2;
        this.supportedCardSchemeList = list;
    }

    public static /* synthetic */ PaymentFormConfig copy$default(PaymentFormConfig paymentFormConfig, String str, Context context2, Environment environment2, PaymentFormStyle paymentFormStyle, PaymentFlowHandler paymentFlowHandler2, List<? extends CardScheme> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = paymentFormConfig.publicKey;
        }
        if ((i11 & 2) != 0) {
            context2 = paymentFormConfig.context;
        }
        Context context3 = context2;
        if ((i11 & 4) != 0) {
            environment2 = paymentFormConfig.environment;
        }
        Environment environment3 = environment2;
        if ((i11 & 8) != 0) {
            paymentFormStyle = paymentFormConfig.style;
        }
        PaymentFormStyle paymentFormStyle2 = paymentFormStyle;
        if ((i11 & 16) != 0) {
            paymentFlowHandler2 = paymentFormConfig.paymentFlowHandler;
        }
        PaymentFlowHandler paymentFlowHandler3 = paymentFlowHandler2;
        if ((i11 & 32) != 0) {
            list = paymentFormConfig.supportedCardSchemeList;
        }
        return paymentFormConfig.copy(str, context3, environment3, paymentFormStyle2, paymentFlowHandler3, list);
    }

    @NotNull
    public final String component1() {
        return this.publicKey;
    }

    @NotNull
    public final Context component2() {
        return this.context;
    }

    @NotNull
    public final Environment component3() {
        return this.environment;
    }

    @NotNull
    public final PaymentFormStyle component4() {
        return this.style;
    }

    @NotNull
    public final PaymentFlowHandler component5() {
        return this.paymentFlowHandler;
    }

    @NotNull
    public final List<CardScheme> component6() {
        return this.supportedCardSchemeList;
    }

    @NotNull
    public final PaymentFormConfig copy(@NotNull String str, @NotNull Context context2, @NotNull Environment environment2, @NotNull PaymentFormStyle paymentFormStyle, @NotNull PaymentFlowHandler paymentFlowHandler2, @NotNull List<? extends CardScheme> list) {
        Intrinsics.checkNotNullParameter(str, "publicKey");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(environment2, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(paymentFormStyle, "style");
        Intrinsics.checkNotNullParameter(paymentFlowHandler2, "paymentFlowHandler");
        Intrinsics.checkNotNullParameter(list, "supportedCardSchemeList");
        return new PaymentFormConfig(str, context2, environment2, paymentFormStyle, paymentFlowHandler2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentFormConfig)) {
            return false;
        }
        PaymentFormConfig paymentFormConfig = (PaymentFormConfig) obj;
        return Intrinsics.areEqual((Object) this.publicKey, (Object) paymentFormConfig.publicKey) && Intrinsics.areEqual((Object) this.context, (Object) paymentFormConfig.context) && this.environment == paymentFormConfig.environment && Intrinsics.areEqual((Object) this.style, (Object) paymentFormConfig.style) && Intrinsics.areEqual((Object) this.paymentFlowHandler, (Object) paymentFormConfig.paymentFlowHandler) && Intrinsics.areEqual((Object) this.supportedCardSchemeList, (Object) paymentFormConfig.supportedCardSchemeList);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final Environment getEnvironment() {
        return this.environment;
    }

    @NotNull
    public final PaymentFlowHandler getPaymentFlowHandler() {
        return this.paymentFlowHandler;
    }

    @NotNull
    public final String getPublicKey() {
        return this.publicKey;
    }

    @NotNull
    public final PaymentFormStyle getStyle() {
        return this.style;
    }

    @NotNull
    public final List<CardScheme> getSupportedCardSchemeList() {
        return this.supportedCardSchemeList;
    }

    public int hashCode() {
        return (((((((((this.publicKey.hashCode() * 31) + this.context.hashCode()) * 31) + this.environment.hashCode()) * 31) + this.style.hashCode()) * 31) + this.paymentFlowHandler.hashCode()) * 31) + this.supportedCardSchemeList.hashCode();
    }

    public final void setStyle(@NotNull PaymentFormStyle paymentFormStyle) {
        Intrinsics.checkNotNullParameter(paymentFormStyle, "<set-?>");
        this.style = paymentFormStyle;
    }

    public final void setSupportedCardSchemeList(@NotNull List<? extends CardScheme> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.supportedCardSchemeList = list;
    }

    @NotNull
    public String toString() {
        String str = this.publicKey;
        Context context2 = this.context;
        Environment environment2 = this.environment;
        PaymentFormStyle paymentFormStyle = this.style;
        PaymentFlowHandler paymentFlowHandler2 = this.paymentFlowHandler;
        List<? extends CardScheme> list = this.supportedCardSchemeList;
        return "PaymentFormConfig(publicKey=" + str + ", context=" + context2 + ", environment=" + environment2 + ", style=" + paymentFormStyle + ", paymentFlowHandler=" + paymentFlowHandler2 + ", supportedCardSchemeList=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentFormConfig(String str, Context context2, Environment environment2, PaymentFormStyle paymentFormStyle, PaymentFlowHandler paymentFlowHandler2, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, context2, environment2, paymentFormStyle, paymentFlowHandler2, (i11 & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
