package com.adyen.checkout.ui.internal.openinvoice.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.model.FieldSetConfiguration;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.Item;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.util.Adapter;
import com.adyen.checkout.ui.internal.openinvoice.control.InputDetailController;
import com.adyen.checkout.ui.internal.openinvoice.control.SimpleEditTextValidator;
import com.adyen.checkout.ui.internal.openinvoice.control.ValidationChanger;
import com.adyen.checkout.ui.internal.openinvoice.control.ValidationCheckDelegate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class InputDetailsGroupLayout extends LinearLayout implements ValidationChanger, ValidationChanger.ValidationChangeListener {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public LinkedHashMap<String, InputDetailController> f40313b = new LinkedHashMap<>();
    private FieldSetConfiguration.FieldVisibility mFormVisibility = FieldSetConfiguration.FieldVisibility.EDITABLE;
    private boolean mIsValid;
    private HashSet<ValidationChanger.ValidationChangeListener> mListeners = new HashSet<>();
    private TextView mReadOnlyDetails;
    private TextView mTitle;

    /* renamed from: com.adyen.checkout.ui.internal.openinvoice.view.InputDetailsGroupLayout$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40315a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility[] r0 = com.adyen.checkout.core.model.FieldSetConfiguration.FieldVisibility.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40315a = r0
                com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r1 = com.adyen.checkout.core.model.FieldSetConfiguration.FieldVisibility.HIDDEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40315a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r1 = com.adyen.checkout.core.model.FieldSetConfiguration.FieldVisibility.READ_ONLY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f40315a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r1 = com.adyen.checkout.core.model.FieldSetConfiguration.FieldVisibility.EDITABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.ui.internal.openinvoice.view.InputDetailsGroupLayout.AnonymousClass3.<clinit>():void");
        }
    }

    public InputDetailsGroupLayout(@NonNull Context context) {
        super(context);
    }

    @Nullable
    public static String a(@Nullable Spinner spinner) {
        if (!(spinner == null || spinner.getSelectedItem() == null || spinner.getVisibility() != 0)) {
            Item item = (Item) spinner.getSelectedItem();
            if (!TextUtils.isEmpty(item.getId())) {
                return item.getId();
            }
        }
        return null;
    }

    @Nullable
    public static String b(@Nullable TextView textView) {
        if (textView == null || textView.getVisibility() != 0 || TextUtils.isEmpty(textView.getText())) {
            return null;
        }
        return textView.getText().toString();
    }

    public static void h(@NonNull final Spinner spinner, @NonNull InputDetail inputDetail) {
        Adapter forSpinner = Adapter.forSpinner(new Adapter.TextDelegate<Item>() {
            @NonNull
            public String getText(@NonNull Item item) {
                return item.getName();
            }
        });
        forSpinner.setViewCustomizationDelegate(new Adapter.ViewCustomizationDelegate() {
            public void customizeView(@NonNull CheckedTextView checkedTextView) {
                checkedTextView.setTextSize(0, spinner.getContext().getResources().getDimension(R.dimen.primarySpinnerTextSize));
            }
        });
        forSpinner.setItems(inputDetail.getItems());
        spinner.setAdapter(forSpinner);
        if (!TextUtils.isEmpty(inputDetail.getValue())) {
            for (int i11 = 0; i11 < forSpinner.getCount(); i11++) {
                if (inputDetail.getValue().equals(((Item) forSpinner.getItem(i11)).getId())) {
                    spinner.setSelection(i11);
                    return;
                }
            }
        }
    }

    public synchronized void addValidationChangeListener(@NonNull ValidationChanger.ValidationChangeListener validationChangeListener) {
        this.mListeners.add(validationChangeListener);
    }

    public abstract void c(@NonNull List<InputDetail> list) throws CheckoutException;

    public void d(@NonNull EditText editText, @NonNull ViewGroup viewGroup, @NonNull InputDetail inputDetail, @NonNull ValidationCheckDelegate validationCheckDelegate) {
        InputDetailController inputDetailController = new InputDetailController(inputDetail, editText, viewGroup, validationCheckDelegate);
        inputDetailController.addValidationChangeListener(this);
        this.f40313b.put(inputDetail.getKey(), inputDetailController);
        if (!TextUtils.isEmpty(inputDetail.getValue())) {
            editText.setText(inputDetail.getValue());
        }
    }

    public void e(@NonNull EditText editText, @NonNull ViewGroup viewGroup, @NonNull InputDetail inputDetail) {
        d(editText, viewGroup, inputDetail, new SimpleEditTextValidator(inputDetail, editText));
    }

    public synchronized void f(boolean z11) {
        Iterator<ValidationChanger.ValidationChangeListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onValidationChanged(z11);
        }
    }

    public abstract void g(@Nullable List<InputDetail> list) throws CheckoutException;

    @NonNull
    public FieldSetConfiguration.FieldVisibility getFormVisibility() {
        return this.mFormVisibility;
    }

    @NonNull
    public TextView getReadOnlyDetails() {
        return this.mReadOnlyDetails;
    }

    public boolean isValid() {
        if (getFormVisibility() != FieldSetConfiguration.FieldVisibility.EDITABLE) {
            return true;
        }
        for (InputDetailController isValid : this.f40313b.values()) {
            if (!isValid.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mTitle = (TextView) findViewById(R.id.textView_title);
        this.mReadOnlyDetails = (TextView) findViewById(R.id.textView_readOnlyDetails);
    }

    public void onValidationChanged(boolean z11) {
        boolean isValid = isValid();
        if (this.mIsValid != isValid) {
            this.mIsValid = isValid;
            f(isValid);
        }
    }

    public void populateInputDetailGroup(@NonNull InputDetail inputDetail) throws CheckoutException {
        setFormVisibility(inputDetail);
    }

    public void removeValidationChangeListener(@NonNull ValidationChanger.ValidationChangeListener validationChangeListener) {
        this.mListeners.remove(validationChangeListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setFormVisibility(@androidx.annotation.NonNull com.adyen.checkout.core.model.InputDetail r4) throws com.adyen.checkout.core.CheckoutException {
        /*
            r3 = this;
            r0 = 0
            java.lang.Class<com.adyen.checkout.core.model.FieldSetConfiguration> r1 = com.adyen.checkout.core.model.FieldSetConfiguration.class
            com.adyen.checkout.core.model.Configuration r1 = r4.getConfiguration(r1)     // Catch:{ CheckoutException -> 0x0010 }
            com.adyen.checkout.core.model.FieldSetConfiguration r1 = (com.adyen.checkout.core.model.FieldSetConfiguration) r1     // Catch:{ CheckoutException -> 0x0010 }
            if (r1 == 0) goto L_0x0010
            com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r1 = r1.getFieldVisibility()     // Catch:{ CheckoutException -> 0x0010 }
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            if (r1 == 0) goto L_0x0057
            r3.mFormVisibility = r1
            int[] r2 = com.adyen.checkout.ui.internal.openinvoice.view.InputDetailsGroupLayout.AnonymousClass3.f40315a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L_0x004b
            r2 = 2
            if (r1 == r2) goto L_0x003d
            java.util.List r1 = r4.getChildInputDetails()
            if (r1 == 0) goto L_0x0031
            java.util.List r4 = r4.getChildInputDetails()
            r3.c(r4)
            goto L_0x0057
        L_0x0031:
            com.adyen.checkout.core.CheckoutException$Builder r4 = new com.adyen.checkout.core.CheckoutException$Builder
            java.lang.String r1 = "InputDetail form has no child data"
            r4.<init>(r1, r0)
            com.adyen.checkout.core.CheckoutException r4 = r4.build()
            throw r4
        L_0x003d:
            android.widget.TextView r0 = r3.mReadOnlyDetails
            r1 = 0
            r0.setVisibility(r1)
            java.util.List r4 = r4.getChildInputDetails()
            r3.g(r4)
            goto L_0x0057
        L_0x004b:
            r0 = 8
            r3.setVisibility(r0)
            java.util.List r4 = r4.getChildInputDetails()
            r3.g(r4)
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.ui.internal.openinvoice.view.InputDetailsGroupLayout.setFormVisibility(com.adyen.checkout.core.model.InputDetail):void");
    }

    public void setTitle(@StringRes int i11) {
        TextView textView = this.mTitle;
        if (textView != null) {
            textView.setText(i11);
        }
    }

    public InputDetailsGroupLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InputDetailsGroupLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
