package com.adyen.checkout.core.internal;

import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.LogoApi;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.NetworkingState;
import com.adyen.checkout.core.Observable;
import com.adyen.checkout.core.PaymentHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.PaymentResult;
import com.adyen.checkout.core.handler.AdditionalDetailsHandler;
import com.adyen.checkout.core.handler.AuthenticationHandler;
import com.adyen.checkout.core.handler.ErrorHandler;
import com.adyen.checkout.core.handler.RedirectHandler;
import com.adyen.checkout.core.internal.BaseManager;
import com.adyen.checkout.core.internal.model.AdditionalPaymentMethodDetails;
import com.adyen.checkout.core.internal.model.AppResponseDetails;
import com.adyen.checkout.core.internal.model.PaymentInitiation;
import com.adyen.checkout.core.internal.model.PaymentInitiationResponse;
import com.adyen.checkout.core.internal.model.PaymentMethodDeletionResponse;
import com.adyen.checkout.core.internal.model.PaymentMethodImpl;
import com.adyen.checkout.core.internal.model.PaymentSessionImpl;
import com.adyen.checkout.core.internal.persistence.PaymentInitiationResponseEntity;
import com.adyen.checkout.core.internal.persistence.PaymentRepository;
import com.adyen.checkout.core.internal.persistence.PaymentSessionEntity;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentMethodDetails;
import com.adyen.checkout.core.model.PaymentSession;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public final class PaymentHandlerImpl implements PaymentHandler {
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final AdditionalDetailsManager mAdditionalDetailsManager;
    private final Application mApplication;
    /* access modifiers changed from: private */
    public final AuthenticationManager mAuthenticationManager;
    /* access modifiers changed from: private */
    public final ErrorManager mErrorManager;
    private final ExecutorService mExecutorService = Executors.newFixedThreadPool(3);
    /* access modifiers changed from: private */
    public NetworkingStateImpl mNetworkingStateImpl;
    /* access modifiers changed from: private */
    public final ObservableImpl<NetworkingState> mNetworkingStateObservable;
    /* access modifiers changed from: private */
    public PaymentInitiationResponseEntity mPaymentInitiationResponseEntity;
    /* access modifiers changed from: private */
    public final PaymentRepository mPaymentRepository;
    /* access modifiers changed from: private */
    public final ObservableImpl<PaymentResult> mPaymentResultObservable;
    private PaymentSessionEntity mPaymentSessionEntity;
    /* access modifiers changed from: private */
    public final ObservableImpl<PaymentSession> mPaymentSessionObservable;
    /* access modifiers changed from: private */
    public final RedirectManager mRedirectManager;

    /* renamed from: com.adyen.checkout.core.internal.PaymentHandlerImpl$10  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40094a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type[] r0 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40094a = r0
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type r1 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.REDIRECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40094a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type r1 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.IDENTIFY_SHOPPER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f40094a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type r1 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.CHALLENGE_SHOPPER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f40094a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type r1 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.DETAILS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f40094a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type r1 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.COMPLETE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.core.internal.PaymentHandlerImpl.AnonymousClass10.<clinit>():void");
        }
    }

    private PaymentHandlerImpl(@NonNull Application application, @NonNull PaymentSessionEntity paymentSessionEntity, @Nullable PaymentInitiationResponseEntity paymentInitiationResponseEntity) {
        this.mApplication = application;
        this.mPaymentRepository = PaymentRepository.getInstance(application);
        NetworkingStateImpl networkingStateImpl = new NetworkingStateImpl();
        this.mNetworkingStateImpl = networkingStateImpl;
        this.mPaymentSessionEntity = paymentSessionEntity;
        this.mPaymentInitiationResponseEntity = paymentInitiationResponseEntity;
        this.mNetworkingStateObservable = new ObservableImpl<>(networkingStateImpl);
        this.mPaymentSessionObservable = new ObservableImpl<>(this.mPaymentSessionEntity.paymentSession);
        this.mPaymentResultObservable = new ObservableImpl<>(null);
        AnonymousClass1 r22 = new BaseManager.Listener() {
            public void onHandled() {
                if (PaymentHandlerImpl.this.mPaymentInitiationResponseEntity != null) {
                    PaymentHandlerImpl.this.mPaymentInitiationResponseEntity.handled = true;
                    PaymentHandlerImpl.this.mPaymentRepository.updatePaymentInitiationResponseEntity(PaymentHandlerImpl.this.mPaymentInitiationResponseEntity);
                }
            }
        };
        this.mAuthenticationManager = new AuthenticationManager(r22);
        this.mRedirectManager = new RedirectManager(r22);
        this.mAdditionalDetailsManager = new AdditionalDetailsManager(r22);
        this.mErrorManager = new ErrorManager(new BaseManager.Listener() {
            public void onHandled() {
            }
        });
        PaymentInitiationResponseEntity paymentInitiationResponseEntity2 = this.mPaymentInitiationResponseEntity;
        if (paymentInitiationResponseEntity2 != null) {
            handlePaymentInitiationResponseEntity(paymentInitiationResponseEntity2);
        }
    }

    @NonNull
    public static PaymentReferenceImpl createPaymentReference(@NonNull Activity activity, @NonNull PaymentSessionImpl paymentSessionImpl) {
        String uuid = UUID.randomUUID().toString();
        PaymentSessionEntity paymentSessionEntity = new PaymentSessionEntity();
        paymentSessionEntity.uuid = uuid;
        paymentSessionEntity.paymentSession = paymentSessionImpl;
        paymentSessionEntity.generationTime = paymentSessionImpl.getGenerationTime();
        PaymentRepository.getInstance(activity).insertPaymentSessionEntity(paymentSessionEntity);
        PaymentReferenceImpl paymentReferenceImpl = new PaymentReferenceImpl(uuid);
        PaymentHandlerStore.getInstance().storePaymentHandler(paymentReferenceImpl, new PaymentHandlerImpl(activity.getApplication(), paymentSessionEntity, (PaymentInitiationResponseEntity) null));
        return paymentReferenceImpl;
    }

    private void deletePaymentMethod(@NonNull final PaymentSessionImpl paymentSessionImpl, @NonNull final PaymentMethodImpl paymentMethodImpl) {
        final Callable<PaymentMethodDeletionResponse> deletePaymentMethod = CheckoutApi.getInstance(this.mApplication).deletePaymentMethod(paymentSessionImpl, paymentMethodImpl);
        this.mExecutorService.submit(new Runnable() {
            public void run() {
                PaymentHandlerImpl.this.handleRequestStarted();
                try {
                    if (((PaymentMethodDeletionResponse) deletePaymentMethod.call()).getResultCode() == PaymentMethodDeletionResponse.ResultCode.SUCCESS) {
                        PaymentHandlerImpl.this.handleUpdatedPaymentSession(paymentSessionImpl.copyByRemovingOneClickPaymentMethod(paymentMethodImpl));
                    } else {
                        PaymentHandlerImpl.this.handleCheckoutException(new CheckoutException.Builder("Could not delete PaymentMethod.", (Throwable) null).build());
                    }
                } catch (Exception e11) {
                    PaymentHandlerImpl.this.handleException(e11, "An error occurred while deleting the payment method.");
                } catch (Throwable th2) {
                    PaymentHandlerImpl.this.handleRequestFinished();
                    throw th2;
                }
                PaymentHandlerImpl.this.handleRequestFinished();
            }
        });
    }

    @NonNull
    public static PaymentHandler getPaymentHandler(@NonNull Activity activity, @NonNull PaymentReference paymentReference) {
        PaymentHandlerImpl paymentHandler = PaymentHandlerStore.getInstance().getPaymentHandler(paymentReference);
        if (paymentHandler != null) {
            return paymentHandler;
        }
        PaymentRepository instance = PaymentRepository.getInstance(activity);
        String uuid = paymentReference.getUuid();
        PaymentSessionEntity findPaymentSessionEntityByUuid = instance.findPaymentSessionEntityByUuid(uuid);
        if (findPaymentSessionEntityByUuid != null) {
            PaymentHandlerImpl paymentHandlerImpl = new PaymentHandlerImpl(activity.getApplication(), findPaymentSessionEntityByUuid, instance.findLatestPaymentInitiationResponseEntityByPaymentSessionEntityUuid(uuid));
            PaymentHandlerStore.getInstance().storePaymentHandler(paymentReference, paymentHandlerImpl);
            return paymentHandlerImpl;
        }
        throw new RuntimeException();
    }

    /* access modifiers changed from: private */
    public void handleCheckoutException(@NonNull final CheckoutException checkoutException) {
        runOnUiThread(new Runnable() {
            public void run() {
                PaymentHandlerImpl.this.mErrorManager.e(checkoutException);
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleException(@NonNull Exception exc, @NonNull String str) {
        CheckoutException checkoutException;
        if (exc instanceof CheckoutException) {
            checkoutException = (CheckoutException) exc;
        } else {
            checkoutException = new CheckoutException.Builder(str, exc).build();
        }
        handleCheckoutException(checkoutException);
    }

    /* access modifiers changed from: private */
    public void handlePaymentInitiationResponse(@NonNull PaymentMethodImpl paymentMethodImpl, @NonNull PaymentInitiationResponse paymentInitiationResponse) {
        boolean z11;
        PaymentInitiationResponse.ErrorFields errorFields = paymentInitiationResponse.getErrorFields();
        if (errorFields != null) {
            CheckoutException.Builder payload = new CheckoutException.Builder(errorFields.getErrorMessage(), (Throwable) null).setPayload(errorFields.getPayload());
            if (errorFields.getErrorCode() == PaymentInitiationResponse.ErrorCode.PAYMENT_SESSION_EXPIRED) {
                z11 = true;
            } else {
                z11 = false;
            }
            handleCheckoutException(payload.setFatal(z11).build());
            return;
        }
        PaymentInitiationResponseEntity paymentInitiationResponseEntity = new PaymentInitiationResponseEntity();
        paymentInitiationResponseEntity.paymentSessionUuid = this.mPaymentSessionEntity.uuid;
        paymentInitiationResponseEntity.paymentMethod = paymentMethodImpl;
        paymentInitiationResponseEntity.paymentInitiationResponse = paymentInitiationResponse;
        handlePaymentInitiationResponseEntity(paymentInitiationResponseEntity);
        this.mPaymentInitiationResponseEntity = paymentInitiationResponseEntity;
        this.mPaymentRepository.insertPaymentInitiationResponseEntity(paymentInitiationResponseEntity);
    }

    private void handlePaymentInitiationResponseEntity(@NonNull final PaymentInitiationResponseEntity paymentInitiationResponseEntity) {
        runOnUiThread(new Runnable() {
            public void run() {
                PaymentInitiationResponse paymentInitiationResponse = paymentInitiationResponseEntity.paymentInitiationResponse;
                int i11 = AnonymousClass10.f40094a[paymentInitiationResponse.getType().ordinal()];
                if (i11 != 1) {
                    if (i11 == 2 || i11 == 3) {
                        if (!paymentInitiationResponseEntity.handled) {
                            PaymentHandlerImpl.this.mAuthenticationManager.e(paymentInitiationResponse.getAuthenticationFields());
                        }
                    } else if (i11 != 4) {
                        if (i11 == 5) {
                            PaymentHandlerImpl.this.mPaymentResultObservable.setValue(paymentInitiationResponse.getCompleteFields());
                        }
                    } else if (!paymentInitiationResponseEntity.handled) {
                        PaymentHandlerImpl.this.mAdditionalDetailsManager.e(paymentInitiationResponse.getDetailFields());
                    }
                } else if (!paymentInitiationResponseEntity.handled) {
                    PaymentHandlerImpl.this.mRedirectManager.e(paymentInitiationResponse.getRedirectFields());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleRequestFinished() {
        this.mNetworkingStateImpl.onRequestFinished();
        runOnUiThread(new Runnable() {
            public void run() {
                PaymentHandlerImpl.this.mNetworkingStateObservable.setValue(PaymentHandlerImpl.this.mNetworkingStateImpl);
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleRequestStarted() {
        this.mNetworkingStateImpl.onRequestStarted();
        runOnUiThread(new Runnable() {
            public void run() {
                PaymentHandlerImpl.this.mNetworkingStateObservable.setValue(PaymentHandlerImpl.this.mNetworkingStateImpl);
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleUpdatedPaymentSession(@NonNull final PaymentSessionImpl paymentSessionImpl) {
        runOnUiThread(new Runnable() {
            public void run() {
                PaymentHandlerImpl.this.mPaymentSessionObservable.setValue(paymentSessionImpl);
            }
        });
        PaymentSessionEntity paymentSessionEntity = new PaymentSessionEntity();
        paymentSessionEntity.uuid = this.mPaymentSessionEntity.uuid;
        paymentSessionEntity.paymentSession = paymentSessionImpl;
        paymentSessionEntity.generationTime = paymentSessionImpl.getGenerationTime();
        this.mPaymentSessionEntity = paymentSessionEntity;
        this.mPaymentRepository.updatePaymentSessionEntity(paymentSessionEntity);
    }

    private void runOnUiThread(@NonNull Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            MAIN_HANDLER.post(runnable);
        }
    }

    public void deleteOneClickPaymentMethod(@NonNull PaymentMethod paymentMethod) {
        int i11;
        PaymentSessionImpl paymentSessionImpl = this.mPaymentSessionEntity.paymentSession;
        List<PaymentMethodImpl> oneClickPaymentMethodImpls = paymentSessionImpl.getOneClickPaymentMethodImpls();
        if (oneClickPaymentMethodImpls != null) {
            i11 = oneClickPaymentMethodImpls.indexOf(paymentMethod);
        } else {
            i11 = -1;
        }
        if (i11 >= 0) {
            deletePaymentMethod(paymentSessionImpl, oneClickPaymentMethodImpls.get(i11));
        } else {
            handleCheckoutException(new CheckoutException.Builder("Cannot delete payment method that is not a one click payment method.", (Throwable) null).build());
        }
    }

    @NonNull
    public LogoApi getLogoApi() {
        return LogoApi.getInstance(this.mApplication, this.mPaymentSessionEntity.paymentSession.getLogoApiHostProvider());
    }

    @NonNull
    public Observable<NetworkingState> getNetworkingStateObservable() {
        return this.mNetworkingStateObservable;
    }

    @NonNull
    public Observable<PaymentResult> getPaymentResultObservable() {
        return this.mPaymentResultObservable;
    }

    @NonNull
    public Observable<PaymentSession> getPaymentSessionObservable() {
        return this.mPaymentSessionObservable;
    }

    public void handleRedirectResult(@NonNull Uri uri) {
        PaymentSessionImpl paymentSessionImpl = this.mPaymentSessionEntity.paymentSession;
        PaymentInitiationResponse.RedirectFields redirectFields = this.mPaymentInitiationResponseEntity.paymentInitiationResponse.getRedirectFields();
        if (redirectFields == null) {
            handleCheckoutException(new CheckoutException.Builder("Could not handle redirect result, RedirectFields == null.", (Throwable) null).build());
            return;
        }
        PaymentMethodImpl paymentMethodImpl = this.mPaymentInitiationResponseEntity.paymentMethod;
        if (redirectFields.isSubmitPaymentMethodReturnData()) {
            initiatePayment(paymentSessionImpl, paymentMethodImpl, new AppResponseDetails.Builder(uri.getQuery()).build());
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String next : uri.getQueryParameterNames()) {
                jSONObject.put(next, (Object) uri.getQueryParameter(next));
            }
            handlePaymentInitiationResponse(paymentMethodImpl, (PaymentInitiationResponse) JsonObject.parseFrom(jSONObject, PaymentInitiationResponse.class));
        } catch (JSONException e11) {
            handleCheckoutException(new CheckoutException.Builder("Could not parse PaymentInitiationResponse.", e11).build());
        }
    }

    public void initiatePayment(@NonNull PaymentMethod paymentMethod, @Nullable PaymentMethodDetails paymentMethodDetails) {
        initiatePayment(this.mPaymentSessionEntity.paymentSession, (PaymentMethodImpl) paymentMethod, paymentMethodDetails);
    }

    public void setAdditionalDetailsHandler(@NonNull Activity activity, @NonNull AdditionalDetailsHandler additionalDetailsHandler) {
        this.mAdditionalDetailsManager.c(activity, additionalDetailsHandler);
    }

    public void setAuthenticationHandler(@NonNull Activity activity, @NonNull AuthenticationHandler authenticationHandler) {
        this.mAuthenticationManager.c(activity, authenticationHandler);
    }

    public void setErrorHandler(@NonNull Activity activity, @NonNull ErrorHandler errorHandler) {
        this.mErrorManager.c(activity, errorHandler);
    }

    public void setRedirectHandler(@NonNull Activity activity, @NonNull RedirectHandler redirectHandler) {
        this.mRedirectManager.c(activity, redirectHandler);
    }

    public void submitAdditionalDetails(@NonNull PaymentMethodDetails paymentMethodDetails) {
        PaymentSessionImpl paymentSessionImpl = this.mPaymentSessionEntity.paymentSession;
        PaymentInitiationResponse.DetailFields detailFields = this.mPaymentInitiationResponseEntity.paymentInitiationResponse.getDetailFields();
        if (detailFields == null) {
            handleCheckoutException(new CheckoutException.Builder("Could not submit additional details, DetailFields == null.", (Throwable) null).build());
            return;
        }
        PaymentMethodImpl paymentMethodImpl = this.mPaymentInitiationResponseEntity.paymentMethod;
        if (paymentMethodDetails instanceof AdditionalPaymentMethodDetails) {
            try {
                AdditionalPaymentMethodDetails.finalize((AdditionalPaymentMethodDetails) paymentMethodDetails, detailFields);
            } catch (CheckoutException e11) {
                handleCheckoutException(e11);
                return;
            }
        }
        initiatePayment(paymentSessionImpl, paymentMethodImpl, paymentMethodDetails);
    }

    public void submitAuthenticationDetails(@NonNull PaymentMethodDetails paymentMethodDetails) {
        PaymentSessionImpl paymentSessionImpl = this.mPaymentSessionEntity.paymentSession;
        PaymentInitiationResponse.AuthenticationFields authenticationFields = this.mPaymentInitiationResponseEntity.paymentInitiationResponse.getAuthenticationFields();
        if (authenticationFields == null) {
            handleCheckoutException(new CheckoutException.Builder("Could not submit authentication details, AuthenticationFields == null.", (Throwable) null).build());
            return;
        }
        initiatePayment(paymentSessionImpl, authenticationFields.getPaymentData(), this.mPaymentInitiationResponseEntity.paymentMethod, paymentMethodDetails);
    }

    private void initiatePayment(@NonNull PaymentSessionImpl paymentSessionImpl, @NonNull PaymentMethodImpl paymentMethodImpl, @Nullable PaymentMethodDetails paymentMethodDetails) {
        initiatePayment(paymentSessionImpl, paymentSessionImpl.getPaymentData(), paymentMethodImpl, paymentMethodDetails);
    }

    private void initiatePayment(@NonNull PaymentSessionImpl paymentSessionImpl, @NonNull String str, @NonNull final PaymentMethodImpl paymentMethodImpl, @Nullable PaymentMethodDetails paymentMethodDetails) {
        final Callable<PaymentInitiationResponse> initiatePayment = CheckoutApi.getInstance(this.mApplication).initiatePayment(paymentSessionImpl, new PaymentInitiation.Builder(str, paymentMethodImpl.getPaymentMethodData()).setPaymentMethodDetails(paymentMethodDetails).build());
        handleRequestStarted();
        this.mExecutorService.submit(new Runnable() {
            public void run() {
                try {
                    PaymentHandlerImpl.this.handlePaymentInitiationResponse(paymentMethodImpl, (PaymentInitiationResponse) initiatePayment.call());
                } catch (Exception e11) {
                    PaymentHandlerImpl.this.handleException(e11, "An error occurred while initiating the payment.");
                } catch (Throwable th2) {
                    PaymentHandlerImpl.this.handleRequestFinished();
                    throw th2;
                }
                PaymentHandlerImpl.this.handleRequestFinished();
            }
        });
    }
}
