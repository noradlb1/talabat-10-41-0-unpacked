package com.adyen.checkout.ui.internal.card;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.adyen.checkout.ui.R;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class NfcCardReaderTutorialFragment extends AppCompatDialogFragment implements TraceFieldInterface {
    @NonNull
    public static final String TAG = "NfcCardReaderTutorialFragment";
    public Trace _nr_trace;
    private final AnimationCallbackDelegate mAnimationCallbackDelegate = new AnimationCallbackDelegate();
    private Button mDismissButton;
    private View mEnableNfcButton;
    private Listener mListener;
    private final ReverseAnimationCallbackDelegate mReverseAnimationCallbackDelegate = new ReverseAnimationCallbackDelegate();
    private ImageView mTutorialAnimImageView;

    public final class AnimationCallbackDelegate {
        private final Animatable2.AnimationCallback mAnimationCallback;
        private final Animatable2Compat.AnimationCallback mAnimationCallbackCompat;

        /* access modifiers changed from: private */
        public void register(@NonNull Drawable drawable) {
            NfcCardReaderTutorialFragment.this.registerAnimationCallback(drawable, this.mAnimationCallbackCompat, this.mAnimationCallback);
        }

        private AnimationCallbackDelegate() {
            this.mAnimationCallbackCompat = new Animatable2Compat.AnimationCallback() {
                public void onAnimationEnd(Drawable drawable) {
                    NfcCardReaderTutorialFragment.this.startReverseAnimation();
                }
            };
            this.mAnimationCallback = new Animatable2.AnimationCallback(NfcCardReaderTutorialFragment.this) {
                public void onAnimationEnd(Drawable drawable) {
                    NfcCardReaderTutorialFragment.this.startReverseAnimation();
                }
            };
        }
    }

    public interface Listener {
        boolean isNfcEnabledOnDevice();
    }

    public final class ReverseAnimationCallbackDelegate {
        private final Animatable2.AnimationCallback mAnimationCallback;
        private final Animatable2Compat.AnimationCallback mAnimationCallbackCompat;

        /* access modifiers changed from: private */
        public void register(@NonNull Drawable drawable) {
            NfcCardReaderTutorialFragment.this.registerAnimationCallback(drawable, this.mAnimationCallbackCompat, this.mAnimationCallback);
        }

        private ReverseAnimationCallbackDelegate() {
            this.mAnimationCallbackCompat = new Animatable2Compat.AnimationCallback() {
                public void onAnimationEnd(Drawable drawable) {
                    NfcCardReaderTutorialFragment.this.startAnimation();
                }
            };
            this.mAnimationCallback = new Animatable2.AnimationCallback(NfcCardReaderTutorialFragment.this) {
                public void onAnimationEnd(Drawable drawable) {
                    NfcCardReaderTutorialFragment.this.startAnimation();
                }
            };
        }
    }

    @NonNull
    public static NfcCardReaderTutorialFragment newInstance() {
        return new NfcCardReaderTutorialFragment();
    }

    /* access modifiers changed from: private */
    public void onEnableNfc(@NonNull Context context) {
        Intent intent = new Intent("android.settings.NFC_SETTINGS");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(getContext(), R.string.checkout_nfc_settings_redirect_failed_toast, 1).show();
        }
    }

    /* access modifiers changed from: private */
    public void registerAnimationCallback(@NonNull Drawable drawable, @NonNull Animatable2Compat.AnimationCallback animationCallback, @NonNull Animatable2.AnimationCallback animationCallback2) {
        if (drawable instanceof Animatable2Compat) {
            ((Animatable2Compat) drawable).registerAnimationCallback(animationCallback);
        } else if (drawable instanceof Animatable2) {
            ((Animatable2) drawable).registerAnimationCallback(animationCallback2);
        } else {
            throw new RuntimeException("Invalid drawable.");
        }
    }

    /* access modifiers changed from: private */
    public void startAnimation() {
        Context context = getContext();
        if (context != null) {
            Drawable drawable = AppCompatResources.getDrawable(context, R.drawable.card_reader_tutorial_animation);
            this.mTutorialAnimImageView.setImageDrawable(drawable);
            this.mAnimationCallbackDelegate.register(drawable);
            ((Animatable) drawable).start();
        }
    }

    /* access modifiers changed from: private */
    public void startReverseAnimation() {
        Context context = getContext();
        if (context != null) {
            Drawable drawable = AppCompatResources.getDrawable(context, R.drawable.card_reader_tutorial_animation_reverse);
            this.mTutorialAnimImageView.setImageDrawable(drawable);
            this.mReverseAnimationCallbackDelegate.register(drawable);
            ((Animatable) drawable).start();
        }
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Listener) {
            this.mListener = (Listener) context;
            return;
        }
        throw new IllegalStateException(context.getClass().getName() + " must implement " + Listener.class.getName());
    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        AppCompatDialog appCompatDialog = (AppCompatDialog) super.onCreateDialog(bundle);
        appCompatDialog.supportRequestWindowFeature(1);
        return appCompatDialog;
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "NfcCardReaderTutorialFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "NfcCardReaderTutorialFragment#onCreateView", (ArrayList<String>) null);
        }
        View inflate = layoutInflater.inflate(R.layout.fragment_nfc_card_reader_tutorial, viewGroup, false);
        this.mTutorialAnimImageView = (ImageView) inflate.findViewById(R.id.imageView_tutorialAnim);
        Button button = (Button) inflate.findViewById(R.id.button_dismiss);
        this.mDismissButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NfcCardReaderTutorialFragment.this.dismissAllowingStateLoss();
            }
        });
        View findViewById = inflate.findViewById(R.id.button_enableNfc);
        this.mEnableNfcButton = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NfcCardReaderTutorialFragment.this.onEnableNfc(view.getContext());
            }
        });
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        Drawable drawable = this.mTutorialAnimImageView.getDrawable();
        if (drawable instanceof Animatable2Compat) {
            ((Animatable2Compat) drawable).clearAnimationCallbacks();
        } else if (drawable instanceof Animatable2) {
            ((Animatable2) drawable).clearAnimationCallbacks();
        }
    }

    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        FragmentActivity activity = getActivity();
        if (activity instanceof DialogInterface.OnDismissListener) {
            ((DialogInterface.OnDismissListener) activity).onDismiss(dialogInterface);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.mListener.isNfcEnabledOnDevice()) {
            this.mDismissButton.setText(R.string.checkout_ok);
            this.mEnableNfcButton.setVisibility(8);
            return;
        }
        this.mDismissButton.setText(R.string.checkout_skip);
        this.mEnableNfcButton.setVisibility(0);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        startAnimation();
    }
}
