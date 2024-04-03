package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId = -1;
    private boolean mCancelable = true;
    private boolean mCreatingDialog;
    /* access modifiers changed from: private */
    @Nullable
    public Dialog mDialog;
    private boolean mDialogCreated = false;
    private Runnable mDismissRunnable = new Runnable() {
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            DialogFragment.this.mOnDismissListener.onDismiss(DialogFragment.this.mDialog);
        }
    };
    private boolean mDismissed;
    private Handler mHandler;
    private Observer<LifecycleOwner> mObserver = new Observer<LifecycleOwner>() {
        @SuppressLint({"SyntheticAccessor"})
        public void onChanged(LifecycleOwner lifecycleOwner) {
            if (lifecycleOwner != null && DialogFragment.this.mShowsDialog) {
                View requireView = DialogFragment.this.requireView();
                if (requireView.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                } else if (DialogFragment.this.mDialog != null) {
                    if (FragmentManager.isLoggingEnabled(3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("DialogFragment ");
                        sb2.append(this);
                        sb2.append(" setting the content view on ");
                        sb2.append(DialogFragment.this.mDialog);
                    }
                    DialogFragment.this.mDialog.setContentView(requireView);
                }
            }
        }
    };
    private DialogInterface.OnCancelListener mOnCancelListener = new DialogInterface.OnCancelListener() {
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(@Nullable DialogInterface dialogInterface) {
            if (DialogFragment.this.mDialog != null) {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.onCancel(dialogFragment.mDialog);
            }
        }
    };
    /* access modifiers changed from: private */
    public DialogInterface.OnDismissListener mOnDismissListener = new DialogInterface.OnDismissListener() {
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(@Nullable DialogInterface dialogInterface) {
            if (DialogFragment.this.mDialog != null) {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.onDismiss(dialogFragment.mDialog);
            }
        }
    };
    private boolean mShownByMe;
    /* access modifiers changed from: private */
    public boolean mShowsDialog = true;
    private int mStyle = 0;
    private int mTheme = 0;
    private boolean mViewDestroyed;

    public DialogFragment() {
    }

    private void dismissInternal(boolean z11, boolean z12, boolean z13) {
        if (!this.mDismissed) {
            this.mDismissed = true;
            this.mShownByMe = false;
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
                this.mDialog.dismiss();
                if (!z12) {
                    if (Looper.myLooper() == this.mHandler.getLooper()) {
                        onDismiss(this.mDialog);
                    } else {
                        this.mHandler.post(this.mDismissRunnable);
                    }
                }
            }
            this.mViewDestroyed = true;
            if (this.mBackStackId >= 0) {
                if (z13) {
                    getParentFragmentManager().popBackStackImmediate(this.mBackStackId, 1);
                } else {
                    getParentFragmentManager().popBackStack(this.mBackStackId, 1, z11);
                }
                this.mBackStackId = -1;
                return;
            }
            FragmentTransaction beginTransaction = getParentFragmentManager().beginTransaction();
            beginTransaction.setReorderingAllowed(true);
            beginTransaction.remove(this);
            if (z13) {
                beginTransaction.commitNow();
            } else if (z11) {
                beginTransaction.commitAllowingStateLoss();
            } else {
                beginTransaction.commit();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private void prepareDialog(@Nullable Bundle bundle) {
        if (this.mShowsDialog && !this.mDialogCreated) {
            try {
                this.mCreatingDialog = true;
                Dialog onCreateDialog = onCreateDialog(bundle);
                this.mDialog = onCreateDialog;
                if (this.mShowsDialog) {
                    setupDialog(onCreateDialog, this.mStyle);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.mDialog.setOwnerActivity((Activity) context);
                    }
                    this.mDialog.setCancelable(this.mCancelable);
                    this.mDialog.setOnCancelListener(this.mOnCancelListener);
                    this.mDialog.setOnDismissListener(this.mOnDismissListener);
                    this.mDialogCreated = true;
                } else {
                    this.mDialog = null;
                }
                this.mCreatingDialog = false;
            } catch (Throwable th2) {
                this.mCreatingDialog = false;
                throw th2;
            }
        }
    }

    @NonNull
    public FragmentContainer createFragmentContainer() {
        final FragmentContainer createFragmentContainer = super.createFragmentContainer();
        return new FragmentContainer() {
            @Nullable
            public View onFindViewById(int i11) {
                if (createFragmentContainer.onHasView()) {
                    return createFragmentContainer.onFindViewById(i11);
                }
                return DialogFragment.this.onFindViewById(i11);
            }

            public boolean onHasView() {
                return createFragmentContainer.onHasView() || DialogFragment.this.onHasView();
            }
        };
    }

    public void dismiss() {
        dismissInternal(false, false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false, false);
    }

    @MainThread
    public void dismissNow() {
        dismissInternal(false, false, true);
    }

    @Nullable
    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    @StyleRes
    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    @MainThread
    @Deprecated
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @MainThread
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().observeForever(this.mObserver);
        if (!this.mShownByMe) {
            this.mDismissed = false;
        }
    }

    public void onCancel(@NonNull DialogInterface dialogInterface) {
    }

    @MainThread
    public void onCreate(@Nullable Bundle bundle) {
        boolean z11;
        super.onCreate(bundle);
        this.mHandler = new Handler();
        if (this.mContainerId == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.mShowsDialog = z11;
        if (bundle != null) {
            this.mStyle = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = bundle.getInt(SAVED_THEME, 0);
            this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
            this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    @MainThread
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCreateDialog called for DialogFragment ");
            sb2.append(this);
        }
        return new ComponentDialog(requireContext(), getTheme());
    }

    @MainThread
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
            this.mDialogCreated = false;
        }
    }

    @MainThread
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        getViewLifecycleOwnerLiveData().removeObserver(this.mObserver);
    }

    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        if (!this.mViewDestroyed) {
            if (FragmentManager.isLoggingEnabled(3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onDismiss called for DialogFragment ");
                sb2.append(this);
            }
            dismissInternal(true, true, false);
        }
    }

    @Nullable
    public View onFindViewById(int i11) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return dialog.findViewById(i11);
        }
        return null;
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (!this.mShowsDialog || this.mCreatingDialog) {
            if (FragmentManager.isLoggingEnabled(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                if (!this.mShowsDialog) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("mShowsDialog = false: ");
                    sb2.append(str);
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("mCreatingDialog = true: ");
                    sb3.append(str);
                }
            }
            return onGetLayoutInflater;
        }
        prepareDialog(bundle);
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("get layout inflater for DialogFragment ");
            sb4.append(this);
            sb4.append(" from dialog context");
        }
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return onGetLayoutInflater.cloneInContext(dialog.getContext());
        }
        return onGetLayoutInflater;
    }

    public boolean onHasView() {
        return this.mDialogCreated;
    }

    @MainThread
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, onSaveInstanceState);
        }
        int i11 = this.mStyle;
        if (i11 != 0) {
            bundle.putInt(SAVED_STYLE, i11);
        }
        int i12 = this.mTheme;
        if (i12 != 0) {
            bundle.putInt(SAVED_THEME, i12);
        }
        boolean z11 = this.mCancelable;
        if (!z11) {
            bundle.putBoolean(SAVED_CANCELABLE, z11);
        }
        boolean z12 = this.mShowsDialog;
        if (!z12) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, z12);
        }
        int i13 = this.mBackStackId;
        if (i13 != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, i13);
        }
    }

    @MainThread
    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
            View decorView = this.mDialog.getWindow().getDecorView();
            ViewTreeLifecycleOwner.set(decorView, this);
            ViewTreeViewModelStoreOwner.set(decorView, this);
            ViewTreeSavedStateRegistryOwner.set(decorView, this);
        }
    }

    @MainThread
    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @MainThread
    public void onViewStateRestored(@Nullable Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.mDialog != null && bundle != null && (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
            this.mDialog.onRestoreInstanceState(bundle2);
        }
    }

    public void performCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView == null && this.mDialog != null && bundle != null && (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
            this.mDialog.onRestoreInstanceState(bundle2);
        }
    }

    @NonNull
    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean z11) {
        this.mCancelable = z11;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z11);
        }
    }

    public void setShowsDialog(boolean z11) {
        this.mShowsDialog = z11;
    }

    public void setStyle(int i11, @StyleRes int i12) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting style and theme for DialogFragment ");
            sb2.append(this);
            sb2.append(" to ");
            sb2.append(i11);
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb2.append(i12);
        }
        this.mStyle = i11;
        if (i11 == 2 || i11 == 3) {
            this.mTheme = 16973913;
        }
        if (i12 != 0) {
            this.mTheme = i12;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog dialog, int i11) {
        if (!(i11 == 1 || i11 == 2)) {
            if (i11 == 3) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                }
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void show(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.setReorderingAllowed(true);
        beginTransaction.add((Fragment) this, str);
        beginTransaction.commit();
    }

    public void showNow(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.setReorderingAllowed(true);
        beginTransaction.add((Fragment) this, str);
        beginTransaction.commitNow();
    }

    public int show(@NonNull FragmentTransaction fragmentTransaction, @Nullable String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        fragmentTransaction.add((Fragment) this, str);
        this.mViewDestroyed = false;
        int commit = fragmentTransaction.commit();
        this.mBackStackId = commit;
        return commit;
    }

    public DialogFragment(@LayoutRes int i11) {
        super(i11);
    }
}
