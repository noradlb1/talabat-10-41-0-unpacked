package com.talabat.gem.adapters.flutter.channel;

import JsonModels.Response.GEMResponse.GemOfferResponse;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.data.GemMappersKt;
import com.talabat.gem.adapters.data.GemOfferRawResponse;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.domain.usecases.BusinessRulesKt;
import com.talabat.gem.domain.usecases.GemOfferRequester;
import com.talabat.gem.domain.usecases.SaveUpToAmountText;
import com.talabat.gem.domain.usecases.SubTotalLineTwo;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.gem.integration.GemAnalyticsAccessor;
import com.talabat.gem.ports.analytics.AnalyticsPort;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.DoubleKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.GsonKt;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qq.a;
import xq.b;

@Instrumented
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J!\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016Ju\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0002J\"\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010\u0011H\u0002J,\u0010+\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010%\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010\u0011H\u0002J0\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070/2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u00162\u0006\u00101\u001a\u000202H\u0002J\u001a\u00104\u001a\u00020\u00162\u0006\u00101\u001a\u0002022\b\u00105\u001a\u0004\u0018\u00010\u0019H\u0002J\u0018\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u0002082\u0006\u00101\u001a\u000202H\u0016J\u000e\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u000bJ\u000e\u0010;\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/talabat/gem/adapters/flutter/channel/GemMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/gem/integration/GemAccessor;", "()V", "canMakeRequest", "", "checkFilledImagePath", "", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "gemMethodCallback", "Lcom/talabat/gem/adapters/flutter/channel/IGemMethodCallback;", "shouldUseFixedAmountText", "beforeFirstTier", "subTotalAmount", "", "baseTier", "Lcom/talabat/gem/domain/entities/GemTier;", "calculateProgress", "maxTier", "(Lcom/talabat/gem/domain/entities/GemTier;D)Ljava/lang/Double;", "clearDisposable", "", "generateGemDataMap", "", "", "savingAmountText", "nextDiscountAmountText", "originalSubtotal", "discountedSubtotal", "shouldAnimate", "imagePath", "buttonIsEnabled", "discountProgress", "hideProgressBar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Boolean;)Ljava/util/Map;", "generateNextDiscountAmountText", "subTitleLineTwo", "Lcom/talabat/gem/domain/usecases/SubTotalLineTwo;", "generatePercentageSubTitle", "generatePercentageTitle", "subTotalIsZero", "currentTier", "generateSavingAmountText", "savingAmount", "Lcom/talabat/gem/domain/usecases/SaveUpToAmountText;", "generateSubtotals", "Lkotlin/Pair;", "handleGenerateGemData", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "handleOrganicListingData", "handleSyncOffers", "arguments", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "setCallback", "callback", "setShouldUseFixedAmountText", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class GemMethodChannel implements MethodChannel.MethodCallHandler, GemAccessor {
    private boolean canMakeRequest = true;
    @NotNull
    private final String checkFilledImagePath = "packages/design_system/lib/assets/images/ds_check_circle_filled/ds_check_circle_filled.svg";
    @NotNull
    private final CompositeDisposable disposable = new CompositeDisposable();
    private IGemMethodCallback gemMethodCallback;
    private boolean shouldUseFixedAmountText;

    private final boolean beforeFirstTier(double d11, GemTier gemTier) {
        Double onTotalAmount = gemTier.getOnTotalAmount();
        return d11 < (onTotalAmount != null ? onTotalAmount.doubleValue() : 0.0d);
    }

    private final Double calculateProgress(GemTier gemTier, double d11) {
        Double d12;
        Double d13 = null;
        if (gemTier != null) {
            d12 = gemTier.getOnTotalAmount();
        } else {
            d12 = null;
        }
        Intrinsics.checkNotNull(d12);
        if (d11 > d12.doubleValue() && !BusinessRulesKt.isPercentage(BusinessRulesKt.getGemPercentageVariant())) {
            return Double.valueOf(1.0d);
        }
        if (BusinessRulesKt.isPercentage(BusinessRulesKt.getGemPercentageVariant())) {
            return Double.valueOf(RangesKt___RangesKt.coerceAtMost((d11 * ((double) FloatKt.orZero(gemTier.getDiscountPercentage()))) / DoubleKt.orZero(gemTier.getOnTotalAmount()), 1.0d));
        }
        if (gemTier != null) {
            d13 = gemTier.getOnTotalAmount();
        }
        Intrinsics.checkNotNull(d13);
        return Double.valueOf(d11 / d13.doubleValue());
    }

    private final Map<String, Object> generateGemDataMap(String str, String str2, String str3, String str4, Boolean bool, String str5, Boolean bool2, Double d11, Boolean bool3) {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("savingAmountText", str), TuplesKt.to("nextDiscountAmountNext", str2), TuplesKt.to("originalSubtotal", str3), TuplesKt.to("discountedSubtotal", str4), TuplesKt.to("shouldAnimate", bool), TuplesKt.to("imagePath", str5), TuplesKt.to("buttonIsEnabled", bool2), TuplesKt.to("discountProgress", d11), TuplesKt.to("hideProgressBar", bool3));
    }

    private final String generateNextDiscountAmountText(double d11, SubTotalLineTwo subTotalLineTwo) {
        boolean z11;
        if (d11 == 0.0d) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return DynamicLocalizationKt.toLocalizedString$default(R.string.Let_s_start_adding_items_to_basket, (String) null, 1, (Object) null);
        }
        if (subTotalLineTwo.getMaximumTierReached()) {
            return "";
        }
        return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(R.string.gem_add_more, (String) null, 1, (Object) null), "{addAmount}", subTotalLineTwo.getAddAmount(), false, 4, (Object) null), "{currency}", subTotalLineTwo.getCurrency(), false, 4, (Object) null), "{saveAmount}", subTotalLineTwo.getSaveAmount(), false, 4, (Object) null);
    }

    private final String generatePercentageSubTitle(double d11, SubTotalLineTwo subTotalLineTwo) {
        boolean z11;
        String str;
        if (d11 == 0.0d) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return DynamicLocalizationKt.toLocalizedString$default(R.string.start_saving_adding_items, (String) null, 1, (Object) null);
        }
        if (subTotalLineTwo.getMaximumTierReached()) {
            return "";
        }
        if (BusinessRulesKt.isPercentageWithoutProgressBarVariantA(BusinessRulesKt.getGemPercentageVariant())) {
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(R.string.gem_swimlane_title, (String) null, 1, (Object) null), "{currency}", subTotalLineTwo.getCurrency(), false, 4, (Object) null), "{saveAmount}", subTotalLineTwo.getSaveAmount(), false, 4, (Object) null);
        }
        String localizedString$default = DynamicLocalizationKt.toLocalizedString$default(R.string.save_pct_all_order, (String) null, 1, (Object) null);
        String discountPercentage = subTotalLineTwo.getDiscountPercentage();
        if (discountPercentage == null) {
            str = "";
        } else {
            str = discountPercentage;
        }
        return StringsKt__StringsJVMKt.replace$default(localizedString$default, "{percentage}", str, false, 4, (Object) null);
    }

    private final String generatePercentageTitle(boolean z11, SubTotalLineTwo subTotalLineTwo, GemTier gemTier) {
        Double d11;
        String str;
        String str2;
        String str3 = null;
        if (z11) {
            String localizedString$default = DynamicLocalizationKt.toLocalizedString$default(R.string.get_pct_all_order, (String) null, 1, (Object) null);
            String discountPercentage = subTotalLineTwo.getDiscountPercentage();
            if (discountPercentage == null) {
                str2 = "";
            } else {
                str2 = discountPercentage;
            }
            return StringsKt__StringsJVMKt.replace$default(localizedString$default, "{percentage}", str2, false, 4, (Object) null);
        } else if (subTotalLineTwo.getMaximumTierReached()) {
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(R.string.gem_awesome_saved, (String) null, 1, (Object) null), "{saveAmount}", subTotalLineTwo.getSaveAmount(), false, 4, (Object) null), "{currency}", subTotalLineTwo.getCurrency(), false, 4, (Object) null);
        } else {
            if (BusinessRulesKt.isPercentageWithoutProgressBarVariantA(BusinessRulesKt.getGemPercentageVariant())) {
                String localizedString$default2 = DynamicLocalizationKt.toLocalizedString$default(R.string.get_pct_all_order, (String) null, 1, (Object) null);
                String discountPercentage2 = subTotalLineTwo.getDiscountPercentage();
                if (discountPercentage2 == null) {
                    str = "";
                } else {
                    str = discountPercentage2;
                }
                return StringsKt__StringsJVMKt.replace$default(localizedString$default2, "{percentage}", str, false, 4, (Object) null);
            }
            String localizedString$default3 = DynamicLocalizationKt.toLocalizedString$default(R.string.add_more_save_up_to, (String) null, 1, (Object) null);
            if (gemTier != null) {
                d11 = Double.valueOf(BusinessRulesKt.savedAmount(gemTier));
            } else {
                d11 = null;
            }
            String replace$default = StringsKt__StringsJVMKt.replace$default(localizedString$default3, "{saveAmount}", String.valueOf(d11), false, 4, (Object) null);
            if (gemTier != null) {
                str3 = gemTier.getCurrency();
            }
            return StringsKt__StringsJVMKt.replace$default(replace$default, "{currency}", String.valueOf(str3), false, 4, (Object) null);
        }
    }

    private final String generateSavingAmountText(boolean z11, SaveUpToAmountText saveUpToAmountText, SubTotalLineTwo subTotalLineTwo, GemTier gemTier) {
        Double d11;
        String str;
        String str2 = null;
        if (z11) {
            String localizedString$default = DynamicLocalizationKt.toLocalizedString$default(R.string.gem_swimlane_title, (String) null, 1, (Object) null);
            if (saveUpToAmountText != null) {
                str = saveUpToAmountText.getSaveAmount();
            } else {
                str = null;
            }
            String replace$default = StringsKt__StringsJVMKt.replace$default(localizedString$default, "{saveAmount}", String.valueOf(str), false, 4, (Object) null);
            if (saveUpToAmountText != null) {
                str2 = saveUpToAmountText.getCurrency();
            }
            return StringsKt__StringsJVMKt.replace$default(replace$default, "{currency}", String.valueOf(str2), false, 4, (Object) null);
        } else if (subTotalLineTwo.getMaximumTierReached()) {
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(R.string.gem_awesome_saved, (String) null, 1, (Object) null), "{saveAmount}", subTotalLineTwo.getSaveAmount(), false, 4, (Object) null), "{currency}", subTotalLineTwo.getCurrency(), false, 4, (Object) null);
        } else {
            String localizedString$default2 = DynamicLocalizationKt.toLocalizedString$default(R.string.gem_awesome_saved, (String) null, 1, (Object) null);
            if (gemTier != null) {
                d11 = Double.valueOf(BusinessRulesKt.savedAmount(gemTier));
            } else {
                d11 = null;
            }
            String replace$default2 = StringsKt__StringsJVMKt.replace$default(localizedString$default2, "{saveAmount}", String.valueOf(d11), false, 4, (Object) null);
            if (gemTier != null) {
                str2 = gemTier.getCurrency();
            }
            return StringsKt__StringsJVMKt.replace$default(replace$default2, "{currency}", String.valueOf(str2), false, 4, (Object) null);
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.Pair<java.lang.String, java.lang.String> generateSubtotals(boolean r3, double r4, com.talabat.gem.domain.entities.GemTier r6) {
        /*
            r2 = this;
            r0 = 0
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0008
            r0 = 1
            goto L_0x0009
        L_0x0008:
            r0 = 0
        L_0x0009:
            if (r0 != 0) goto L_0x0058
            java.lang.String r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentage(r0)
            if (r0 != 0) goto L_0x0018
            if (r3 == 0) goto L_0x0018
            goto L_0x0058
        L_0x0018:
            buisnessmodels.Cart r3 = buisnessmodels.Cart.getInstance()
            java.lang.String r3 = r3.getCartSubTotalDisplayPrice()
            java.lang.String r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentage(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0042
            buisnessmodels.TalabatFormatter r0 = buisnessmodels.TalabatFormatter.getInstance()
            if (r6 == 0) goto L_0x0039
            float r4 = com.talabat.gem.domain.usecases.BusinessRulesKt.calculatePercentageTotal(r6, r4)
            java.lang.Float r1 = java.lang.Float.valueOf(r4)
        L_0x0039:
            float r4 = com.talabat.talabatcommon.extentions.FloatKt.orZero((java.lang.Float) r1)
            java.lang.String r1 = r0.getFormattedCurrency(r4)
            goto L_0x0052
        L_0x0042:
            if (r6 == 0) goto L_0x0052
            double r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.savedAmount(r6)
            double r4 = r4 - r0
            float r4 = (float) r4
            buisnessmodels.TalabatFormatter r5 = buisnessmodels.TalabatFormatter.getInstance()
            java.lang.String r1 = r5.getFormattedCurrency(r4)
        L_0x0052:
            kotlin.Pair r4 = new kotlin.Pair
            r4.<init>(r3, r1)
            goto L_0x0067
        L_0x0058:
            kotlin.Pair r4 = new kotlin.Pair
            buisnessmodels.Cart r3 = buisnessmodels.Cart.getInstance()
            java.lang.String r3 = r3.getCartSubTotalDisplayPrice()
            java.lang.String r5 = ""
            r4.<init>(r5, r3)
        L_0x0067:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.adapters.flutter.channel.GemMethodChannel.generateSubtotals(boolean, double, com.talabat.gem.domain.entities.GemTier):kotlin.Pair");
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0219  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleGenerateGemData(io.flutter.plugin.common.MethodChannel.Result r33) {
        /*
            r32 = this;
            r10 = r32
            com.talabat.gem.ports.data.DataSourcesPort r0 = com.talabat.gem.IntegrationKt.getDataSources()
            kotlin.jvm.functions.Function1 r0 = r0.loadGemOffer()
            r1 = 0
            r11 = 1
            io.reactivex.Single r0 = com.talabat.talabatcommon.extentions.KotlinResultKt.toSingle$default(r0, r1, r11, r1)
            java.lang.Object r0 = r0.blockingGet()
            com.talabat.gem.domain.entities.GemOffer r0 = (com.talabat.gem.domain.entities.GemOffer) r0
            buisnessmodels.Cart r2 = buisnessmodels.Cart.getInstance()
            float r2 = r2.getCartSubTotal()
            double r12 = (double) r2
            java.util.List r2 = r0.getTiers()
            r14 = 0
            if (r2 == 0) goto L_0x002e
            java.lang.Object r2 = r2.get(r14)
            com.talabat.gem.domain.entities.GemTier r2 = (com.talabat.gem.domain.entities.GemTier) r2
            if (r2 != 0) goto L_0x0042
        L_0x002e:
            com.talabat.gem.domain.entities.GemTier r2 = new com.talabat.gem.domain.entities.GemTier
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 31
            r22 = 0
            r15 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
        L_0x0042:
            java.lang.String r3 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r3 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentage(r3)
            if (r3 == 0) goto L_0x0056
            boolean r2 = com.talabat.gem.domain.usecases.BusinessRulesKt.reachPercentage(r2, r12)
            if (r2 != 0) goto L_0x0054
            r2 = r11
            goto L_0x005a
        L_0x0054:
            r2 = r14
            goto L_0x005a
        L_0x0056:
            boolean r2 = r10.beforeFirstTier(r12, r2)
        L_0x005a:
            if (r2 == 0) goto L_0x0067
            java.lang.String r3 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r3 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentage(r3)
            if (r3 != 0) goto L_0x0067
            goto L_0x0081
        L_0x0067:
            java.util.List r3 = r0.getTiers()
            if (r3 == 0) goto L_0x0081
            java.lang.String r4 = r32.getGemSelectedTierIndexText()
            java.lang.String r5 = "gemSelectedTierIndexText"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Object r3 = r3.get(r4)
            com.talabat.gem.domain.entities.GemTier r3 = (com.talabat.gem.domain.entities.GemTier) r3
            goto L_0x0082
        L_0x0081:
            r3 = r1
        L_0x0082:
            java.util.List r4 = r0.getTiers()
            if (r4 == 0) goto L_0x008f
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.last(r4)
            com.talabat.gem.domain.entities.GemTier r4 = (com.talabat.gem.domain.entities.GemTier) r4
            goto L_0x0090
        L_0x008f:
            r4 = r1
        L_0x0090:
            kotlin.Triple r5 = new kotlin.Triple
            r6 = 0
            java.lang.Double r8 = java.lang.Double.valueOf(r6)
            java.util.List r9 = r0.getTiers()
            java.lang.String r15 = "null cannot be cast to non-null type kotlin.collections.List<com.talabat.gem.domain.entities.GemTier>{ com.talabat.gem.domain.entities.AliasesKt.GemTiers }"
            if (r9 == 0) goto L_0x0260
            java.lang.String r1 = ""
            r5.<init>(r1, r8, r9)
            com.talabat.gem.domain.entities.GemTier r5 = com.talabat.gem.domain.usecases.GemSubTotalBusinessRulesKt.nextGemTier(r12, r5)
            com.talabat.gem.domain.usecases.SubTotalLineTwo r8 = new com.talabat.gem.domain.usecases.SubTotalLineTwo
            java.lang.String r9 = r5.getCurrency()
            java.lang.String r18 = java.lang.String.valueOf(r9)
            java.lang.String r9 = com.talabat.gem.domain.usecases.GemSubTotalBusinessRulesKt.addAmount(r5, r12)
            java.lang.String r14 = "addAmount(nextTier, subTotalAmount)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r14)
            java.text.DecimalFormat r14 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
            double r6 = com.talabat.gem.domain.usecases.BusinessRulesKt.savedAmount(r5)
            java.lang.String r6 = r14.format(r6)
            java.lang.String r7 = "DecimalFormat.format(nextTier.savedAmount())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.util.List r7 = r0.getTiers()
            if (r7 == 0) goto L_0x025a
            boolean r21 = com.talabat.gem.domain.usecases.GemSubTotalBusinessRulesKt.isMaximumTierReached(r12, r7)
            java.text.DecimalFormat r7 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
            java.lang.Float r5 = r5.getDiscountPercentage()
            float r5 = com.talabat.talabatcommon.extentions.FloatKt.orZero((java.lang.Float) r5)
            r14 = 100
            float r14 = (float) r14
            float r5 = r5 * r14
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.String r22 = r7.format(r5)
            r17 = r8
            r19 = r9
            r20 = r6
            r17.<init>(r18, r19, r20, r21, r22)
            java.util.List r5 = r0.getTiers()
            if (r5 == 0) goto L_0x01ad
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
            boolean r6 = r5.hasNext()
            if (r6 != 0) goto L_0x010e
            r18 = r12
            r6 = 0
            goto L_0x015b
        L_0x010e:
            java.lang.Object r6 = r5.next()
            boolean r7 = r5.hasNext()
            if (r7 != 0) goto L_0x011b
            r18 = r12
            goto L_0x015b
        L_0x011b:
            r7 = r6
            com.talabat.gem.domain.entities.GemTier r7 = (com.talabat.gem.domain.entities.GemTier) r7
            java.lang.Double r7 = r7.getOnTotalAmount()
            if (r7 == 0) goto L_0x0129
            double r17 = r7.doubleValue()
            goto L_0x012b
        L_0x0129:
            r17 = 0
        L_0x012b:
            r30 = r12
            r11 = r17
            r18 = r30
        L_0x0131:
            java.lang.Object r7 = r5.next()
            r9 = r7
            com.talabat.gem.domain.entities.GemTier r9 = (com.talabat.gem.domain.entities.GemTier) r9
            java.lang.Double r9 = r9.getOnTotalAmount()
            if (r9 == 0) goto L_0x0147
            double r20 = r9.doubleValue()
            r9 = r6
            r13 = r7
            r6 = r20
            goto L_0x014b
        L_0x0147:
            r9 = r6
            r13 = r7
            r6 = 0
        L_0x014b:
            int r15 = java.lang.Double.compare(r11, r6)
            if (r15 >= 0) goto L_0x0154
            r11 = r6
            r6 = r13
            goto L_0x0155
        L_0x0154:
            r6 = r9
        L_0x0155:
            boolean r7 = r5.hasNext()
            if (r7 != 0) goto L_0x0131
        L_0x015b:
            com.talabat.gem.domain.entities.GemTier r6 = (com.talabat.gem.domain.entities.GemTier) r6
            if (r6 == 0) goto L_0x01af
            com.talabat.gem.domain.usecases.SaveUpToAmountText r5 = new com.talabat.gem.domain.usecases.SaveUpToAmountText
            java.text.DecimalFormat r7 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
            double r11 = com.talabat.gem.domain.usecases.BusinessRulesKt.savedAmount(r6)
            java.lang.String r7 = r7.format(r11)
            java.lang.String r9 = "DecimalFormat.format(it.savedAmount())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            java.lang.String r9 = r6.getCurrency()
            if (r9 != 0) goto L_0x017b
            r25 = r1
            goto L_0x017d
        L_0x017b:
            r25 = r9
        L_0x017d:
            java.text.DecimalFormat r1 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
            java.lang.Float r6 = r6.getDiscountPercentage()
            float r6 = com.talabat.talabatcommon.extentions.FloatKt.orZero((java.lang.Float) r6)
            float r6 = r6 * r14
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            java.lang.String r1 = r1.format(r6)
            java.lang.String r6 = "DecimalFormat.format(it.…Zero().times(PERCENTAGE))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            java.lang.String r27 = r0.getBrandingMessage()
            java.lang.String r28 = r0.getCollectionTitle()
            java.lang.String r29 = r0.getCollectionSubtitle()
            r23 = r5
            r24 = r7
            r26 = r1
            r23.<init>(r24, r25, r26, r27, r28, r29)
            goto L_0x01b0
        L_0x01ad:
            r18 = r12
        L_0x01af:
            r5 = 0
        L_0x01b0:
            boolean r0 = r10.shouldUseFixedAmountText
            if (r0 == 0) goto L_0x01bb
            if (r5 == 0) goto L_0x01bb
            java.lang.String r0 = com.talabat.gem.domain.usecases.GemEntryBusinessRulesKt.getTitle(r5)
            goto L_0x01d7
        L_0x01bb:
            java.lang.String r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentage(r0)
            if (r0 == 0) goto L_0x01d3
            r0 = 0
            int r5 = (r18 > r0 ? 1 : (r18 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x01cd
            r0 = 1
            goto L_0x01ce
        L_0x01cd:
            r0 = 0
        L_0x01ce:
            java.lang.String r0 = r10.generatePercentageTitle(r0, r8, r3)
            goto L_0x01d7
        L_0x01d3:
            java.lang.String r0 = r10.generateSavingAmountText(r2, r5, r8, r3)
        L_0x01d7:
            r1 = r0
            java.lang.String r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentage(r0)
            if (r0 == 0) goto L_0x01e9
            r11 = r18
            java.lang.String r0 = r10.generatePercentageSubTitle(r11, r8)
            goto L_0x01ef
        L_0x01e9:
            r11 = r18
            java.lang.String r0 = r10.generateNextDiscountAmountText(r11, r8)
        L_0x01ef:
            r5 = r0
            kotlin.Pair r0 = r10.generateSubtotals(r2, r11, r3)
            java.lang.Object r2 = r0.component1()
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r0 = r0.component2()
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
            boolean r0 = r8.getMaximumTierReached()
            if (r0 == 0) goto L_0x020f
            java.lang.String r0 = r10.checkFilledImagePath
            r16 = r0
            r7 = 0
            goto L_0x0213
        L_0x020f:
            r7 = 0
            r16 = 0
        L_0x0213:
            int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0219
            r0 = 1
            goto L_0x021a
        L_0x0219:
            r0 = 0
        L_0x021a:
            r2 = 1
            r0 = r0 ^ r2
            java.lang.Double r8 = r10.calculateProgress(r4, r11)
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r0)
            java.lang.String r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentageWithoutProgressBarVariantA(r0)
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r0)
            r0 = r32
            r2 = r5
            r4 = r6
            r5 = r7
            r6 = r16
            r7 = r9
            r9 = r13
            java.util.Map r0 = r0.generateGemDataMap(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = r33
            r1.success(r0)
            r0 = 1
            kotlin.Pair[] r0 = new kotlin.Pair[r0]
            java.lang.String r1 = "com.talabat.gem.domain.usecases.KEY_SUBTOTAL"
            java.lang.Double r2 = java.lang.Double.valueOf(r11)
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r2)
            r2 = 0
            r0[r2] = r1
            java.lang.String r1 = "com.talabat.gem.domain.usecases.ACTION_UPDATE_SUBTOTAL"
            com.talabat.talabatcommon.extentions.BroadcastsKt.sendBroadcast(r1, r0)
            return
        L_0x025a:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r15)
            throw r0
        L_0x0260:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.adapters.flutter.channel.GemMethodChannel.handleGenerateGemData(io.flutter.plugin.common.MethodChannel$Result):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleOrganicListingData(io.flutter.plugin.common.MethodChannel.Result r15) {
        /*
            r14 = this;
            com.talabat.gem.ports.data.DataSourcesPort r0 = com.talabat.gem.IntegrationKt.getDataSources()
            kotlin.jvm.functions.Function1 r0 = r0.loadGemOffer()
            r1 = 0
            r2 = 1
            io.reactivex.Single r0 = com.talabat.talabatcommon.extentions.KotlinResultKt.toSingle$default(r0, r1, r2, r1)
            java.lang.Object r0 = r0.blockingGet()
            com.talabat.gem.domain.entities.GemOffer r0 = (com.talabat.gem.domain.entities.GemOffer) r0
            java.util.List r3 = r0.getTiers()
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x00b5
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
            boolean r5 = r3.hasNext()
            if (r5 != 0) goto L_0x002a
            r5 = r1
            goto L_0x0067
        L_0x002a:
            java.lang.Object r5 = r3.next()
            boolean r6 = r3.hasNext()
            if (r6 != 0) goto L_0x0035
            goto L_0x0067
        L_0x0035:
            r6 = r5
            com.talabat.gem.domain.entities.GemTier r6 = (com.talabat.gem.domain.entities.GemTier) r6
            java.lang.Double r6 = r6.getOnTotalAmount()
            r7 = 0
            if (r6 == 0) goto L_0x0045
            double r9 = r6.doubleValue()
            goto L_0x0046
        L_0x0045:
            r9 = r7
        L_0x0046:
            java.lang.Object r6 = r3.next()
            r11 = r6
            com.talabat.gem.domain.entities.GemTier r11 = (com.talabat.gem.domain.entities.GemTier) r11
            java.lang.Double r11 = r11.getOnTotalAmount()
            if (r11 == 0) goto L_0x0058
            double r11 = r11.doubleValue()
            goto L_0x0059
        L_0x0058:
            r11 = r7
        L_0x0059:
            int r13 = java.lang.Double.compare(r9, r11)
            if (r13 >= 0) goto L_0x0061
            r5 = r6
            r9 = r11
        L_0x0061:
            boolean r6 = r3.hasNext()
            if (r6 != 0) goto L_0x0046
        L_0x0067:
            com.talabat.gem.domain.entities.GemTier r5 = (com.talabat.gem.domain.entities.GemTier) r5
            if (r5 == 0) goto L_0x00b5
            com.talabat.gem.domain.usecases.SaveUpToAmountText r3 = new com.talabat.gem.domain.usecases.SaveUpToAmountText
            java.text.DecimalFormat r6 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
            double r7 = com.talabat.gem.domain.usecases.BusinessRulesKt.savedAmount(r5)
            java.lang.String r7 = r6.format(r7)
            java.lang.String r6 = "DecimalFormat.format(it.savedAmount())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            java.lang.String r6 = r5.getCurrency()
            if (r6 != 0) goto L_0x0086
            r8 = r4
            goto L_0x0087
        L_0x0086:
            r8 = r6
        L_0x0087:
            java.text.DecimalFormat r6 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
            java.lang.Float r5 = r5.getDiscountPercentage()
            float r5 = com.talabat.talabatcommon.extentions.FloatKt.orZero((java.lang.Float) r5)
            r9 = 100
            float r9 = (float) r9
            float r5 = r5 * r9
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.String r9 = r6.format(r5)
            java.lang.String r5 = "DecimalFormat.format(it.…Zero().times(PERCENTAGE))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)
            java.lang.String r10 = r0.getBrandingMessage()
            java.lang.String r11 = r0.getCollectionTitle()
            java.lang.String r12 = r0.getCollectionSubtitle()
            r6 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            goto L_0x00b6
        L_0x00b5:
            r3 = r1
        L_0x00b6:
            if (r3 == 0) goto L_0x00c0
            java.lang.String r0 = com.talabat.gem.domain.usecases.GemEntryBusinessRulesKt.getOrganicListingMessage(r3)
            if (r0 != 0) goto L_0x00bf
            goto L_0x00c0
        L_0x00bf:
            r4 = r0
        L_0x00c0:
            boolean r0 = r14.isGemOffersActive()
            if (r0 == 0) goto L_0x0109
            com.talabat.gem.ports.data.DataSourcesPort r0 = com.talabat.gem.IntegrationKt.getDataSources()
            kotlin.jvm.functions.Function1 r0 = r0.loadGemOffer()
            com.talabat.gem.adapters.flutter.channel.GemMethodChannel$handleOrganicListingData$branchIds$1 r3 = new com.talabat.gem.adapters.flutter.channel.GemMethodChannel$handleOrganicListingData$branchIds$1
            r3.<init>(r1)
            kotlin.jvm.functions.Function1 r0 = com.talabat.talabatcommon.extentions.KotlinResultKt.mapNonNull(r0, r3)
            io.reactivex.Maybe r0 = com.talabat.talabatcommon.extentions.KotlinResultKt.toMaybe$default(r0, r1, r2, r1)
            java.lang.Object r0 = r0.blockingGet()
            java.lang.String r1 = "DataSources.loadGemOffer…           .blockingGet()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r3)
            r1.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
        L_0x00f5:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x010d
            java.lang.Object r3 = r0.next()
            com.talabat.gem.domain.entities.GemRestaurant r3 = (com.talabat.gem.domain.entities.GemRestaurant) r3
            java.lang.Integer r3 = r3.getBranchId()
            r1.add(r3)
            goto L_0x00f5
        L_0x0109:
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x010d:
            r0 = 2
            kotlin.Pair[] r0 = new kotlin.Pair[r0]
            java.lang.String r3 = "discountMessage"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            r4 = 0
            r0[r4] = r3
            java.lang.String r3 = "vendorIds"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r3, r1)
            r0[r2] = r1
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.mapOf(r0)
            r15.success(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.adapters.flutter.channel.GemMethodChannel.handleOrganicListingData(io.flutter.plugin.common.MethodChannel$Result):void");
    }

    private final void handleSyncOffers(MethodChannel.Result result, Object obj) {
        Object obj2;
        GemOffer gemOffer;
        boolean z11;
        if (obj == null) {
            IntegrationKt.getAnalytics().observeGemSyncOffers("Wrong arguments from flutter");
            result.error("1002", "Wrong arguments from flutter", (Object) null);
            return;
        }
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(obj, (Gson) null, 1, (Object) null);
        Class cls = GemOfferRawResponse.class;
        if (!(gson instanceof Gson)) {
            obj2 = gson.fromJson(json$default, cls);
        } else {
            obj2 = GsonInstrumentation.fromJson(gson, json$default, cls);
        }
        GemOfferResponse response = ((GemOfferRawResponse) obj2).getResponse();
        if (response != null && (gemOffer = GemMappersKt.toGemOffer(response)) != null && !BusinessRulesKt.isExpired$default(gemOffer, 0, 1, (Object) null)) {
            Collection restaurants = gemOffer.getRestaurants();
            if (restaurants == null || restaurants.isEmpty()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                CompositeDisposable compositeDisposable = this.disposable;
                Single doOnError = KotlinResultKt.toSingle$default(IntegrationKt.getDataSources().saveGemOffer(gemOffer), (Function1) null, 1, (Object) null).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).doOnError(new a());
                Intrinsics.checkNotNullExpressionValue(doOnError, "DataSources.saveGemOffer…sage}\")\n                }");
                compositeDisposable.add(SubscribersKt.subscribeBy(doOnError, (Function1<? super Throwable, Unit>) GemMethodChannel$handleSyncOffers$2.INSTANCE, GemMethodChannel$handleSyncOffers$3.INSTANCE));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleSyncOffers$lambda-7  reason: not valid java name */
    public static final void m10533handleSyncOffers$lambda7(Throwable th2) {
        AnalyticsPort analytics = IntegrationKt.getAnalytics();
        String message = th2.getMessage();
        analytics.observeGemSyncOffers("Error while saving the offer: " + message);
    }

    public final void clearDisposable() {
        this.disposable.clear();
    }

    public /* synthetic */ Map getGemComponentState() {
        return b.a(this);
    }

    public /* synthetic */ String getGemRemainingSecondsText() {
        return b.b(this);
    }

    public /* synthetic */ String getGemSelectedRestaurantPositionText() {
        return b.c(this);
    }

    public /* synthetic */ String getGemSelectedTierIndexText() {
        return b.d(this);
    }

    public /* synthetic */ boolean isGemActive() {
        return b.e(this);
    }

    public /* synthetic */ boolean isGemOffersActive() {
        return b.f(this);
    }

    public /* synthetic */ void onGemSessionChanged() {
        b.g(this);
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Boolean bool;
        long j11;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            boolean z11 = false;
            IGemMethodCallback iGemMethodCallback = null;
            switch (str.hashCode()) {
                case -1770835523:
                    if (str.equals("gemOffersStatusCallback")) {
                        if (isGemOffersActive()) {
                            result.success(Boolean.TRUE);
                            return;
                        } else if (isGemOffersActive() || !this.canMakeRequest) {
                            result.success(Boolean.FALSE);
                            return;
                        } else {
                            this.canMakeRequest = false;
                            CompositeDisposable compositeDisposable = this.disposable;
                            Single<GemOffer> observeOn = GemOfferRequester.Refresh.INSTANCE.invoke().subscribeOn(Schedulers.io()).observeOn(Schedulers.io());
                            Intrinsics.checkNotNullExpressionValue(observeOn, "Refresh()\n              …bserveOn(Schedulers.io())");
                            compositeDisposable.add(SubscribersKt.subscribeBy(observeOn, (Function1<? super Throwable, Unit>) new GemMethodChannel$onMethodCall$1(result), new GemMethodChannel$onMethodCall$2(result, this)));
                            return;
                        }
                    } else {
                        return;
                    }
                case -1620170874:
                    if (str.equals("gemStatusCallback")) {
                        Integer num = (Integer) methodCall.arguments;
                        if (num != null) {
                            BusinessRulesKt.selectIfGemRestaurantBranch(num.intValue());
                            bool = b.k(num.intValue());
                        } else {
                            bool = Boolean.valueOf(isGemActive());
                        }
                        result.success(bool);
                        return;
                    }
                    return;
                case -82070631:
                    if (str.equals("gemData")) {
                        handleGenerateGemData(result);
                        return;
                    }
                    return;
                case -32861796:
                    if (str.equals("navigateToGEMsPopup")) {
                        Object obj = methodCall.arguments;
                        if (obj != null) {
                            Object obj2 = ((Map) obj).get("fromFlutterHoF");
                            if (obj2 != null) {
                                boolean booleanValue = ((Boolean) obj2).booleanValue();
                                IGemMethodCallback iGemMethodCallback2 = this.gemMethodCallback;
                                if (iGemMethodCallback2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("gemMethodCallback");
                                } else {
                                    iGemMethodCallback = iGemMethodCallback2;
                                }
                                iGemMethodCallback.navigateToGemPopup(booleanValue);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    }
                    return;
                case 265723038:
                    if (str.equals("gemRemainingTimeData")) {
                        String gemRemainingSecondsText = getGemRemainingSecondsText();
                        Intrinsics.checkNotNullExpressionValue(gemRemainingSecondsText, "gemRemainingSecondsText");
                        String gemRemainingSecondsText2 = getGemRemainingSecondsText();
                        Intrinsics.checkNotNullExpressionValue(gemRemainingSecondsText2, "gemRemainingSecondsText");
                        if (gemRemainingSecondsText2.length() == 0) {
                            z11 = true;
                        }
                        if (z11) {
                            j11 = 0;
                        } else {
                            j11 = Long.parseLong(gemRemainingSecondsText);
                        }
                        result.success(MapsKt__MapsJVMKt.mapOf(TuplesKt.to("remainingTimeInSeconds", Long.valueOf(j11))));
                        return;
                    }
                    return;
                case 1446024291:
                    if (str.equals("organicListingData")) {
                        handleOrganicListingData(result);
                        return;
                    }
                    return;
                case 1630635627:
                    if (str.equals("gemExpirationDialogShown")) {
                        IntegrationKt.getDataSources().setExpirationAlertShown(true);
                        result.success((Object) null);
                        return;
                    }
                    return;
                case 1975293970:
                    if (str.equals("syncOffers")) {
                        handleSyncOffers(result, methodCall.arguments);
                        return;
                    }
                    return;
                case 2134165217:
                    if (str.equals("navigateToGemCollection")) {
                        IGemMethodCallback iGemMethodCallback3 = this.gemMethodCallback;
                        if (iGemMethodCallback3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gemMethodCallback");
                        } else {
                            iGemMethodCallback = iGemMethodCallback3;
                        }
                        iGemMethodCallback.navigateToGemCollection();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public /* synthetic */ void resetGemFlow() {
        b.h(this);
    }

    public final void setCallback(@NotNull IGemMethodCallback iGemMethodCallback) {
        Intrinsics.checkNotNullParameter(iGemMethodCallback, "callback");
        this.gemMethodCallback = iGemMethodCallback;
    }

    public final void setShouldUseFixedAmountText(boolean z11) {
        this.shouldUseFixedAmountText = z11;
    }

    public /* synthetic */ GemAnalyticsAccessor withGemAnalytics() {
        return b.i(this);
    }
}
