package com.adyen.checkout.ui.internal.common.activity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.Observer;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.PaymentResult;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.fragment.CheckoutDetailsFragment;
import com.adyen.checkout.ui.internal.common.fragment.PreselectedCheckoutMethodFragment;
import com.adyen.checkout.ui.internal.common.model.CheckoutHandler;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodPickerListener;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodsModel;
import com.adyen.checkout.ui.internal.common.model.CheckoutViewModel;
import com.adyen.checkout.ui.internal.common.util.ThemeUtil;
import com.adyen.checkout.ui.internal.picker.CheckoutMethodPickerFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.List;

public class CheckoutActivity extends CheckoutSessionActivity implements CheckoutMethodPickerListener, CheckoutHandler {
    private static final int BOTTOM_SHEET_ANIMATION_DURATION = 150;
    private static final int REQUEST_CODE_PAYMENT_METHOD_DETAILS = 1;
    @VisibleForTesting
    @Nullable
    public BottomSheetBehavior mBottomSheetBehavior;
    private ValueAnimator mBottomSheetValueAnimator;
    /* access modifiers changed from: private */
    public View mBottomSheetView;
    /* access modifiers changed from: private */
    public CheckoutViewModel mCheckoutViewModel;
    /* access modifiers changed from: private */
    public ContentLoadingProgressBar mProgressBar;
    /* access modifiers changed from: private */
    public int mTargetPeekHeight;

    public final class BottomSheetCallback extends BottomSheetBehavior.BottomSheetCallback {
        private BottomSheetCallback() {
        }

        public void onSlide(@NonNull View view, float f11) {
        }

        public void onStateChanged(@NonNull View view, int i11) {
            if (i11 == 3) {
                CheckoutActivity checkoutActivity = CheckoutActivity.this;
                checkoutActivity.mBottomSheetBehavior.setPeekHeight(checkoutActivity.mTargetPeekHeight);
            } else if (i11 == 4) {
                int peekHeight = CheckoutActivity.this.mBottomSheetBehavior.getPeekHeight();
                if (peekHeight != CheckoutActivity.this.mTargetPeekHeight) {
                    CheckoutActivity checkoutActivity2 = CheckoutActivity.this;
                    checkoutActivity2.startBottomSheetAnimation(peekHeight, checkoutActivity2.mTargetPeekHeight);
                }
            } else if (i11 == 5) {
                CheckoutActivity.this.cancelCheckoutActivity();
            }
        }
    }

    private void cancelBottomSheetAnimation() {
        ValueAnimator valueAnimator = this.mBottomSheetValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mBottomSheetValueAnimator = null;
        }
    }

    /* access modifiers changed from: private */
    public void cancelCheckoutActivity() {
        setResult(0);
        finish();
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context, @NonNull PaymentReference paymentReference) {
        Intent intent = new Intent(context, CheckoutActivity.class);
        intent.putExtra(CheckoutSessionActivity.EXTRA_PAYMENT_REFERENCE, paymentReference);
        return intent;
    }

    /* access modifiers changed from: private */
    public void showRequiredFragment() {
        PaymentReference paymentReference = getPaymentReference();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.executePendingTransactions();
        CheckoutMethodPickerFragment newInstance = CheckoutMethodPickerFragment.newInstance(paymentReference);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        int i11 = R.id.frameLayout_fragmentContainer;
        beginTransaction.replace(i11, (Fragment) newInstance, CheckoutMethodPickerFragment.TAG).commit();
        if (this.mCheckoutViewModel.getCheckoutMethodsLiveData().getPreselectedCheckoutMethod() != null) {
            supportFragmentManager.beginTransaction().replace(i11, (Fragment) PreselectedCheckoutMethodFragment.newInstance(paymentReference), PreselectedCheckoutMethodFragment.TAG).addToBackStack(PreselectedCheckoutMethodFragment.TAG).commit();
        }
    }

    /* access modifiers changed from: private */
    public void startBottomSheetAnimation(int i11, int i12) {
        cancelBottomSheetAnimation();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        this.mBottomSheetValueAnimator = ofInt;
        ofInt.setDuration(150);
        this.mBottomSheetValueAnimator.setInterpolator(new DecelerateInterpolator());
        this.mBottomSheetValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CheckoutActivity.this.mBottomSheetBehavior.setPeekHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.mBottomSheetValueAnimator.start();
    }

    /* access modifiers changed from: private */
    public void transitionToPeekHeight(int i11) {
        if (i11 > 0 && i11 != this.mTargetPeekHeight) {
            int state = this.mBottomSheetBehavior.getState();
            if (state == 1 || state == 2) {
                this.mTargetPeekHeight = i11;
            } else if (state == 3) {
                this.mBottomSheetBehavior.setPeekHeight(i11);
                this.mTargetPeekHeight = i11;
            } else if (state == 4) {
                startBottomSheetAnimation(Math.max(0, this.mBottomSheetBehavior.getPeekHeight()), i11);
                this.mTargetPeekHeight = i11;
            } else if (state == 5) {
                this.mBottomSheetBehavior.setPeekHeight(i11);
                this.mBottomSheetView.post(new Runnable() {
                    public void run() {
                        CheckoutActivity.this.mBottomSheetBehavior.setState(4);
                    }
                });
                this.mTargetPeekHeight = i11;
            } else {
                throw new RuntimeException("Unknown state.");
            }
        }
    }

    public void Q(@NonNull final PaymentResult paymentResult) {
        this.mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            public void onSlide(@NonNull View view, float f11) {
            }

            public void onStateChanged(@NonNull View view, int i11) {
                if (i11 == 5) {
                    CheckoutActivity.super.Q(paymentResult);
                }
            }
        });
        this.mBottomSheetView.post(new Runnable() {
            public void run() {
                CheckoutActivity.this.mBottomSheetBehavior.setState(5);
            }
        });
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public void handleWithPaymentMethodHandler(@NonNull PaymentMethodHandler paymentMethodHandler) {
        paymentMethodHandler.handlePaymentMethodDetails(this, 1);
    }

    public boolean isCheckoutMethodDeletable(@NonNull CheckoutMethod checkoutMethod) {
        List<PaymentMethod> oneClickPaymentMethods;
        PaymentSession O = O();
        if (O == null || (oneClickPaymentMethods = O.getOneClickPaymentMethods()) == null || !oneClickPaymentMethods.contains(checkoutMethod.getPaymentMethod())) {
            return false;
        }
        return true;
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        CheckoutException checkoutException;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 1 && i12 == 1 && (checkoutException = PaymentMethodHandler.Util.getCheckoutException(intent)) != null && checkoutException.isFatal()) {
            P(checkoutException);
        }
    }

    public void onBackPressed() {
        if (!getSupportFragmentManager().popBackStackImmediate()) {
            if (this.mBottomSheetBehavior.getState() != 5) {
                this.mBottomSheetBehavior.setState(5);
            } else {
                cancelCheckoutActivity();
            }
        }
    }

    public void onCheckoutMethodDelete(@NonNull CheckoutMethod checkoutMethod) {
        getPaymentHandler().deleteOneClickPaymentMethod(checkoutMethod.getPaymentMethod());
    }

    public void onCheckoutMethodSelected(@NonNull CheckoutMethod checkoutMethod) {
        checkoutMethod.onSelected(this);
    }

    public void onClearSelection() {
        this.mBottomSheetBehavior.setState(4);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.popBackStack(CheckoutDetailsFragment.TAG, 1);
        supportFragmentManager.popBackStack(PreselectedCheckoutMethodFragment.TAG, 1);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_checkout);
        overridePendingTransition(0, 0);
        this.mCheckoutViewModel = (CheckoutViewModel) ViewModelProviders.of((FragmentActivity) this).get(CheckoutViewModel.class);
        View findViewById = findViewById(R.id.frameLayout_bottomSheet);
        this.mBottomSheetView = findViewById;
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                CheckoutMethodPickerFragment checkoutMethodPickerFragment = (CheckoutMethodPickerFragment) CheckoutActivity.this.getSupportFragmentManager().findFragmentByTag(CheckoutMethodPickerFragment.TAG);
                if (checkoutMethodPickerFragment == null || !checkoutMethodPickerFragment.isVisible()) {
                    CheckoutActivity.this.transitionToPeekHeight(CheckoutActivity.this.mBottomSheetView.getMeasuredHeight());
                    return;
                }
                CheckoutActivity.this.transitionToPeekHeight(checkoutMethodPickerFragment.getDesiredPeekHeight());
            }
        });
        getPaymentHandler().getPaymentSessionObservable().observe(this, new Observer<PaymentSession>() {
            public void onChanged(@NonNull PaymentSession paymentSession) {
                CheckoutActivity.this.mCheckoutViewModel.updateCheckoutMethodsViewModel(paymentSession);
            }
        });
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) findViewById(R.id.progressBar);
        this.mProgressBar = contentLoadingProgressBar;
        ThemeUtil.applyPrimaryThemeColor(this, contentLoadingProgressBar.getProgressDrawable(), this.mProgressBar.getIndeterminateDrawable());
        BottomSheetBehavior from = BottomSheetBehavior.from(this.mBottomSheetView);
        this.mBottomSheetBehavior = from;
        from.setState(5);
        if (bundle == null) {
            this.mBottomSheetView.post(new Runnable() {
                public void run() {
                    CheckoutActivity.this.mProgressBar.show();
                }
            });
            this.mCheckoutViewModel.getCheckoutMethodsLiveData().observeOnce(this, new androidx.lifecycle.Observer<CheckoutMethodsModel>() {
                public void onChanged(@Nullable CheckoutMethodsModel checkoutMethodsModel) {
                    CheckoutActivity.this.mBottomSheetView.post(new Runnable() {
                        public void run() {
                            CheckoutActivity.this.mProgressBar.hide();
                        }
                    });
                    CheckoutActivity.this.showRequiredFragment();
                }
            });
        }
        this.mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetCallback());
    }

    public void presentDetailsActivity(@NonNull Intent intent) {
        startActivity(intent);
    }

    public void presentDetailsFragment(@NonNull CheckoutDetailsFragment checkoutDetailsFragment) {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.frameLayout_fragmentContainer, (Fragment) checkoutDetailsFragment, CheckoutDetailsFragment.TAG).addToBackStack(CheckoutDetailsFragment.TAG).commit();
    }
}
