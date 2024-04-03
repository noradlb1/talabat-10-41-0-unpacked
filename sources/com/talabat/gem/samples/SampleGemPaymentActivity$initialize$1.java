package com.talabat.gem.samples;

import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemApprovalCallbacks;
import com.talabat.gem.adapters.presentation.GemOfferProcessingConfigurations;
import com.talabat.gem.adapters.presentation.payment.GemOfferProcessingKt;
import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleGemPaymentActivity$initialize$1 extends Lambda implements Function1<AppCompatActivity, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SampleGemPaymentActivity f60536g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SampleGemPaymentActivity$initialize$1(SampleGemPaymentActivity sampleGemPaymentActivity) {
        super(1);
        this.f60536g = sampleGemPaymentActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppCompatActivity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$withLayout");
        final SampleGemPaymentActivity sampleGemPaymentActivity = this.f60536g;
        RouterKt.withNavigationData(appCompatActivity, new Function1<NavigationData, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((NavigationData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull final NavigationData navigationData) {
                Intrinsics.checkNotNullParameter(navigationData, "$this$withNavigationData");
                TextView textView = (TextView) appCompatActivity.findViewById(R.id.paymentTextView);
                Intrinsics.checkNotNullExpressionValue(textView, "paymentTextView");
                int restaurantId = navigationData.getRestaurantId();
                double subTotal = navigationData.getSubTotal();
                ViewKt.plusAssign(textView, "Restaurant Id : " + restaurantId + " \n Subtotal : " + subTotal);
                Button button = (Button) appCompatActivity.findViewById(R.id.finishFlowButton);
                Intrinsics.checkNotNullExpressionValue(button, "finishFlowButton");
                final AppCompatActivity appCompatActivity = appCompatActivity;
                final SampleGemPaymentActivity sampleGemPaymentActivity = sampleGemPaymentActivity;
                GemOfferProcessingKt.withGemOfferProcessing(button, new Function1<GemOfferProcessingConfigurations, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GemOfferProcessingConfigurations) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull GemOfferProcessingConfigurations gemOfferProcessingConfigurations) {
                        Intrinsics.checkNotNullParameter(gemOfferProcessingConfigurations, "$this$null");
                        gemOfferProcessingConfigurations.getWith().restaurantId(Integer.valueOf(navigationData.getRestaurantId()));
                        GemApprovalCallbacks on2 = gemOfferProcessingConfigurations.getOn();
                        final AppCompatActivity appCompatActivity = appCompatActivity;
                        on2.processing(new Function1<Boolean, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Boolean) obj).booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z11) {
                                ProgressBar progressBar = (ProgressBar) appCompatActivity.findViewById(R.id.paymentProgressBar);
                                Intrinsics.checkNotNullExpressionValue(progressBar, "paymentProgressBar");
                                ViewKt.get$default(progressBar, Boolean.valueOf(z11), 0, 2, (Object) null);
                            }
                        });
                        GemApprovalCallbacks on3 = gemOfferProcessingConfigurations.getOn();
                        final AppCompatActivity appCompatActivity2 = appCompatActivity;
                        on3.error(new Function1<Throwable, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Throwable) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull Throwable th2) {
                                Intrinsics.checkNotNullParameter(th2, "it");
                                TextView textView = (TextView) appCompatActivity2.findViewById(R.id.flowResultTextView);
                                Intrinsics.checkNotNullExpressionValue(textView, "flowResultTextView");
                                ViewKt.plusAssign(textView, Param.ERROR);
                            }
                        });
                        GemApprovalCallbacks on4 = gemOfferProcessingConfigurations.getOn();
                        final SampleGemPaymentActivity sampleGemPaymentActivity = sampleGemPaymentActivity;
                        final AppCompatActivity appCompatActivity3 = appCompatActivity;
                        on4.processed(new Function1<GemOfferAcceptance, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((GemOfferAcceptance) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull GemOfferAcceptance gemOfferAcceptance) {
                                Intrinsics.checkNotNullParameter(gemOfferAcceptance, "it");
                                if (gemOfferAcceptance instanceof GemOfferAcceptance.Accepted) {
                                    sampleGemPaymentActivity.resetGemFlow();
                                }
                                TextView textView = (TextView) appCompatActivity3.findViewById(R.id.flowResultTextView);
                                Intrinsics.checkNotNullExpressionValue(textView, "flowResultTextView");
                                ViewKt.plusAssign(textView, gemOfferAcceptance.toString());
                            }
                        });
                    }
                });
            }
        });
    }
}
