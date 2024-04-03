package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import net.bytebuddy.jar.asm.Opcodes;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    private static final String IME_OPTION_NO_MICROPHONE = "nm";

    /* renamed from: k  reason: collision with root package name */
    public static final PreQAutoCompleteTextViewReflector f864k = (Build.VERSION.SDK_INT < 29 ? new PreQAutoCompleteTextViewReflector() : null);

    /* renamed from: b  reason: collision with root package name */
    public final SearchAutoComplete f865b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f866c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f867d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f868e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f869f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnFocusChangeListener f870g;

    /* renamed from: h  reason: collision with root package name */
    public CursorAdapter f871h;

    /* renamed from: i  reason: collision with root package name */
    public SearchableInfo f872i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnKeyListener f873j;
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    private final ImageView mCollapsedIcon;
    private int mCollapsedImeOptions;
    private final CharSequence mDefaultQueryHint;
    private final View mDropDownAnchor;
    private boolean mExpandedInActionView;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final View.OnClickListener mOnClickListener;
    private OnCloseListener mOnCloseListener;
    private final TextView.OnEditorActionListener mOnEditorActionListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private final AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private OnQueryTextListener mOnQueryChangeListener;
    private View.OnClickListener mOnSearchClickListener;
    private OnSuggestionListener mOnSuggestionListener;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private Runnable mReleaseCursorRunnable;
    private final View mSearchEditFrame;
    private final Drawable mSearchHintIcon;
    private final View mSearchPlate;
    private Rect mSearchSrcTextViewBounds;
    private Rect mSearchSrtTextViewBoundsExpanded;
    private final View mSubmitArea;
    private boolean mSubmitButtonEnabled;
    private final int mSuggestionCommitIconResId;
    private final int mSuggestionRowLayout;
    private int[] mTemp;
    private int[] mTemp2;
    private TextWatcher mTextWatcher;
    private UpdatableTouchDelegate mTouchDelegate;
    private final Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        @DoNotInline
        public static void b(SearchAutoComplete searchAutoComplete, int i11) {
            searchAutoComplete.setInputMethodMode(i11);
        }
    }

    public interface OnCloseListener {
        boolean onClose();
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i11);

        boolean onSuggestionSelect(int i11);
    }

    public static class PreQAutoCompleteTextViewReflector {
        private Method mDoAfterTextChanged = null;
        private Method mDoBeforeTextChanged = null;
        private Method mEnsureImeVisible = null;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public PreQAutoCompleteTextViewReflector() {
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            preApi29Check();
            try {
                Method declaredMethod = cls.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.mDoBeforeTextChanged = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = cls.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.mDoAfterTextChanged = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.mEnsureImeVisible = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void preApi29Check() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        public void a(AutoCompleteTextView autoCompleteTextView) {
            preApi29Check();
            Method method = this.mDoAfterTextChanged;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void b(AutoCompleteTextView autoCompleteTextView) {
            preApi29Check();
            Method method = this.mDoBeforeTextChanged;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void c(AutoCompleteTextView autoCompleteTextView) {
            preApi29Check();
            Method method = this.mEnsureImeVisible;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.TRUE});
                } catch (Exception unused) {
                }
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public boolean f884b;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f884b + "}";
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeValue(Boolean.valueOf(this.f884b));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f884b = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f885b;
        private boolean mHasPendingShowSoftInputRequest;
        private SearchView mSearchView;
        private int mThreshold;

        public SearchAutoComplete(Context context) {
            this(context, (AttributeSet) null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i11 = configuration.screenWidthDp;
            int i12 = configuration.screenHeightDp;
            if (i11 >= 960 && i12 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i11 >= 600) {
                return 192;
            }
            if (i11 < 640 || i12 < 480) {
                return Opcodes.IF_ICMPNE;
            }
            return 192;
        }

        public void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.f864k.c(this);
        }

        public boolean b() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void c() {
            if (this.mHasPendingShowSoftInputRequest) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.mHasPendingShowSoftInputRequest = false;
            }
        }

        public boolean enoughToFilter() {
            return this.mThreshold <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.mHasPendingShowSoftInputRequest) {
                removeCallbacks(this.f885b);
                post(this.f885b);
            }
            return onCreateInputConnection;
        }

        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        public void onFocusChanged(boolean z11, int i11, Rect rect) {
            super.onFocusChanged(z11, i11, rect);
            this.mSearchView.m();
        }

        public boolean onKeyPreIme(int i11, KeyEvent keyEvent) {
            if (i11 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.mSearchView.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i11, keyEvent);
        }

        public void onWindowFocusChanged(boolean z11) {
            super.onWindowFocusChanged(z11);
            if (z11 && this.mSearchView.hasFocus() && getVisibility() == 0) {
                this.mHasPendingShowSoftInputRequest = true;
                if (SearchView.c(getContext())) {
                    a();
                }
            }
        }

        public void performCompletion() {
        }

        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z11) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z11) {
                this.mHasPendingShowSoftInputRequest = false;
                removeCallbacks(this.f885b);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.mHasPendingShowSoftInputRequest = false;
                removeCallbacks(this.f885b);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.mHasPendingShowSoftInputRequest = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.mSearchView = searchView;
        }

        public void setThreshold(int i11) {
            super.setThreshold(i11);
            this.mThreshold = i11;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i11) {
            super(context, attributeSet, i11);
            this.f885b = new Runnable() {
                public void run() {
                    SearchAutoComplete.this.c();
                }
            };
            this.mThreshold = getThreshold();
        }
    }

    public static class UpdatableTouchDelegate extends TouchDelegate {
        private final Rect mActualBounds = new Rect();
        private boolean mDelegateTargeted;
        private final View mDelegateView;
        private final int mSlop;
        private final Rect mSlopBounds = new Rect();
        private final Rect mTargetBounds = new Rect();

        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.mSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            setBounds(rect, rect2);
            this.mDelegateView = view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r9) {
            /*
                r8 = this;
                float r0 = r9.getX()
                int r0 = (int) r0
                float r1 = r9.getY()
                int r1 = (int) r1
                int r2 = r9.getAction()
                r3 = 2
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L_0x0033
                if (r2 == r5) goto L_0x0020
                if (r2 == r3) goto L_0x0020
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003f
            L_0x001b:
                boolean r2 = r8.mDelegateTargeted
                r8.mDelegateTargeted = r4
                goto L_0x002f
            L_0x0020:
                boolean r2 = r8.mDelegateTargeted
                if (r2 == 0) goto L_0x002f
                android.graphics.Rect r6 = r8.mSlopBounds
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x002f
                r5 = r2
                r2 = r4
                goto L_0x0041
            L_0x002f:
                r7 = r5
                r5 = r2
                r2 = r7
                goto L_0x0041
            L_0x0033:
                android.graphics.Rect r2 = r8.mTargetBounds
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003f
                r8.mDelegateTargeted = r5
                r2 = r5
                goto L_0x0041
            L_0x003f:
                r2 = r5
                r5 = r4
            L_0x0041:
                if (r5 == 0) goto L_0x0074
                if (r2 == 0) goto L_0x0061
                android.graphics.Rect r2 = r8.mActualBounds
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x0061
                android.view.View r0 = r8.mDelegateView
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r8.mDelegateView
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                float r1 = (float) r1
                r9.setLocation(r0, r1)
                goto L_0x006e
            L_0x0061:
                android.graphics.Rect r2 = r8.mActualBounds
                int r3 = r2.left
                int r0 = r0 - r3
                float r0 = (float) r0
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r9.setLocation(r0, r1)
            L_0x006e:
                android.view.View r0 = r8.mDelegateView
                boolean r4 = r0.dispatchTouchEvent(r9)
            L_0x0074:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.UpdatableTouchDelegate.onTouchEvent(android.view.MotionEvent):boolean");
        }

        public void setBounds(Rect rect, Rect rect2) {
            this.mTargetBounds.set(rect);
            this.mSlopBounds.set(rect);
            Rect rect3 = this.mSlopBounds;
            int i11 = this.mSlop;
            rect3.inset(-i11, -i11);
            this.mActualBounds.set(rect2);
        }
    }

    public SearchView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public static boolean c(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private Intent createIntent(String str, Uri uri, String str2, String str3, int i11, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.mUserQuery);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.mAppSearchData;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i11 != 0) {
            intent.putExtra("action_key", i11);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f872i.getSearchActivity());
        return intent;
    }

    private Intent createIntentFromSuggestion(Cursor cursor, int i11, String str) {
        int i12;
        Uri uri;
        String columnString;
        try {
            String columnString2 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_action");
            if (columnString2 == null) {
                columnString2 = this.f872i.getSuggestIntentAction();
            }
            if (columnString2 == null) {
                columnString2 = "android.intent.action.SEARCH";
            }
            String str2 = columnString2;
            String columnString3 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data");
            if (columnString3 == null) {
                columnString3 = this.f872i.getSuggestIntentData();
            }
            if (!(columnString3 == null || (columnString = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data_id")) == null)) {
                columnString3 = columnString3 + "/" + Uri.encode(columnString);
            }
            if (columnString3 == null) {
                uri = null;
            } else {
                uri = Uri.parse(columnString3);
            }
            return createIntent(str2, uri, SuggestionsAdapter.getColumnString(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(cursor, "suggest_intent_query"), i11, str);
        } catch (RuntimeException e11) {
            try {
                i12 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i12 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i12 + " returned exception.", e11);
            return null;
        }
    }

    private Intent createVoiceAppSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        int i11;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.mAppSearchData;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        } else {
            str = "free_form";
        }
        String str4 = null;
        if (searchableInfo.getVoicePromptTextId() != 0) {
            str2 = resources.getString(searchableInfo.getVoicePromptTextId());
        } else {
            str2 = null;
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            str3 = resources.getString(searchableInfo.getVoiceLanguageId());
        } else {
            str3 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i11 = searchableInfo.getVoiceMaxResults();
        } else {
            i11 = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i11);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent createVoiceWebSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        String str;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        if (searchActivity == null) {
            str = null;
        } else {
            str = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", str);
        return intent2;
    }

    private void dismissSuggestions() {
        this.f865b.dismissDropDown();
    }

    private void getChildBoundsWithinSearchView(View view, Rect rect) {
        view.getLocationInWindow(this.mTemp);
        getLocationInWindow(this.mTemp2);
        int[] iArr = this.mTemp;
        int i11 = iArr[1];
        int[] iArr2 = this.mTemp2;
        int i12 = i11 - iArr2[1];
        int i13 = iArr[0] - iArr2[0];
        rect.set(i13, i12, view.getWidth() + i13, view.getHeight() + i12);
    }

    private CharSequence getDecoratedHint(CharSequence charSequence) {
        if (!this.mIconifiedByDefault || this.mSearchHintIcon == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f865b.getTextSize()) * 1.25d);
        this.mSearchHintIcon.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private boolean hasVoiceSearch() {
        Intent intent;
        SearchableInfo searchableInfo = this.f872i;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        if (this.f872i.getVoiceSearchLaunchWebSearch()) {
            intent = this.mVoiceWebSearchIntent;
        } else if (this.f872i.getVoiceSearchLaunchRecognizer()) {
            intent = this.mVoiceAppSearchIntent;
        } else {
            intent = null;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    private boolean isSubmitAreaEnabled() {
        return (this.mSubmitButtonEnabled || this.mVoiceButtonEnabled) && !isIconified();
    }

    private void launchIntent(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e11) {
                Log.e("SearchView", "Failed launch activity: " + intent, e11);
            }
        }
    }

    private boolean launchSuggestion(int i11, int i12, String str) {
        Cursor cursor = this.f871h.getCursor();
        if (cursor == null || !cursor.moveToPosition(i11)) {
            return false;
        }
        launchIntent(createIntentFromSuggestion(cursor, i12, str));
        return true;
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    private void rewriteQueryFromSuggestion(int i11) {
        Editable text = this.f865b.getText();
        Cursor cursor = this.f871h.getCursor();
        if (cursor != null) {
            if (cursor.moveToPosition(i11)) {
                CharSequence convertToString = this.f871h.convertToString(cursor);
                if (convertToString != null) {
                    setQuery(convertToString);
                } else {
                    setQuery(text);
                }
            } else {
                setQuery(text);
            }
        }
    }

    private void updateCloseButton() {
        int[] iArr;
        boolean z11 = true;
        boolean z12 = !TextUtils.isEmpty(this.f865b.getText());
        int i11 = 0;
        if (!z12 && (!this.mIconifiedByDefault || this.mExpandedInActionView)) {
            z11 = false;
        }
        ImageView imageView = this.f868e;
        if (!z11) {
            i11 = 8;
        }
        imageView.setVisibility(i11);
        Drawable drawable = this.f868e.getDrawable();
        if (drawable != null) {
            if (z12) {
                iArr = ViewGroup.ENABLED_STATE_SET;
            } else {
                iArr = ViewGroup.EMPTY_STATE_SET;
            }
            drawable.setState(iArr);
        }
    }

    private void updateQueryHint() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f865b;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(getDecoratedHint(queryHint));
    }

    private void updateSearchAutoComplete() {
        this.f865b.setThreshold(this.f872i.getSuggestThreshold());
        this.f865b.setImeOptions(this.f872i.getImeOptions());
        int inputType = this.f872i.getInputType();
        int i11 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f872i.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f865b.setInputType(inputType);
        CursorAdapter cursorAdapter = this.f871h;
        if (cursorAdapter != null) {
            cursorAdapter.changeCursor((Cursor) null);
        }
        if (this.f872i.getSuggestAuthority() != null) {
            SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.f872i, this.mOutsideDrawablesCache);
            this.f871h = suggestionsAdapter;
            this.f865b.setAdapter(suggestionsAdapter);
            SuggestionsAdapter suggestionsAdapter2 = (SuggestionsAdapter) this.f871h;
            if (this.mQueryRefinement) {
                i11 = 2;
            }
            suggestionsAdapter2.setQueryRefinement(i11);
        }
    }

    private void updateSubmitArea() {
        int i11;
        if (!isSubmitAreaEnabled() || !(this.f867d.getVisibility() == 0 || this.f869f.getVisibility() == 0)) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        this.mSubmitArea.setVisibility(i11);
    }

    private void updateSubmitButton(boolean z11) {
        int i11;
        if (!this.mSubmitButtonEnabled || !isSubmitAreaEnabled() || !hasFocus() || (!z11 && this.mVoiceButtonEnabled)) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        this.f867d.setVisibility(i11);
    }

    private void updateViewsVisibility(boolean z11) {
        int i11;
        int i12;
        this.mIconified = z11;
        int i13 = 0;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        boolean z12 = !TextUtils.isEmpty(this.f865b.getText());
        this.f866c.setVisibility(i11);
        updateSubmitButton(z12);
        View view = this.mSearchEditFrame;
        if (z11) {
            i12 = 8;
        } else {
            i12 = 0;
        }
        view.setVisibility(i12);
        if (this.mCollapsedIcon.getDrawable() == null || this.mIconifiedByDefault) {
            i13 = 8;
        }
        this.mCollapsedIcon.setVisibility(i13);
        updateCloseButton();
        updateVoiceButton(!z12);
        updateSubmitArea();
    }

    private void updateVoiceButton(boolean z11) {
        int i11 = 8;
        if (this.mVoiceButtonEnabled && !isIconified() && z11) {
            this.f867d.setVisibility(8);
            i11 = 0;
        }
        this.f869f.setVisibility(i11);
    }

    public void a() {
        int i11;
        int i12;
        if (this.mDropDownAnchor.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.mSearchPlate.getPaddingLeft();
            Rect rect = new Rect();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            if (this.mIconifiedByDefault) {
                i11 = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left);
            } else {
                i11 = 0;
            }
            this.f865b.getDropDownBackground().getPadding(rect);
            if (isLayoutRtl) {
                i12 = -rect.left;
            } else {
                i12 = paddingLeft - (rect.left + i11);
            }
            this.f865b.setDropDownHorizontalOffset(i12);
            this.f865b.setDropDownWidth((((this.mDropDownAnchor.getWidth() + rect.left) + rect.right) + i11) - paddingLeft);
        }
    }

    public void b() {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.a(this.f865b);
            return;
        }
        PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = f864k;
        preQAutoCompleteTextViewReflector.b(this.f865b);
        preQAutoCompleteTextViewReflector.a(this.f865b);
    }

    public void clearFocus() {
        this.mClearingFocus = true;
        super.clearFocus();
        this.f865b.clearFocus();
        this.f865b.setImeVisibility(false);
        this.mClearingFocus = false;
    }

    public void d(int i11, String str, String str2) {
        getContext().startActivity(createIntent("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i11, str));
    }

    public void e() {
        if (!TextUtils.isEmpty(this.f865b.getText())) {
            this.f865b.setText("");
            this.f865b.requestFocus();
            this.f865b.setImeVisibility(true);
        } else if (this.mIconifiedByDefault) {
            OnCloseListener onCloseListener = this.mOnCloseListener;
            if (onCloseListener == null || !onCloseListener.onClose()) {
                clearFocus();
                updateViewsVisibility(true);
            }
        }
    }

    public boolean f(int i11, int i12, String str) {
        OnSuggestionListener onSuggestionListener = this.mOnSuggestionListener;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionClick(i11)) {
            return false;
        }
        launchSuggestion(i11, 0, (String) null);
        this.f865b.setImeVisibility(false);
        dismissSuggestions();
        return true;
    }

    public boolean g(int i11) {
        OnSuggestionListener onSuggestionListener = this.mOnSuggestionListener;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionSelect(i11)) {
            return false;
        }
        rewriteQueryFromSuggestion(i11);
        return true;
    }

    public int getImeOptions() {
        return this.f865b.getImeOptions();
    }

    public int getInputType() {
        return this.f865b.getInputType();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public CharSequence getQuery() {
        return this.f865b.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.mQueryHint;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f872i;
        if (searchableInfo == null || searchableInfo.getHintId() == 0) {
            return this.mDefaultQueryHint;
        }
        return getContext().getText(this.f872i.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }

    public int getSuggestionRowLayout() {
        return this.mSuggestionRowLayout;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.f871h;
    }

    public void h(@Nullable CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void i() {
        updateViewsVisibility(false);
        this.f865b.requestFocus();
        this.f865b.setImeVisibility(true);
        View.OnClickListener onClickListener = this.mOnSearchClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    public boolean isIconified() {
        return this.mIconified;
    }

    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    public void j() {
        Editable text = this.f865b.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            OnQueryTextListener onQueryTextListener = this.mOnQueryChangeListener;
            if (onQueryTextListener == null || !onQueryTextListener.onQueryTextSubmit(text.toString())) {
                if (this.f872i != null) {
                    d(0, (String) null, text.toString());
                }
                this.f865b.setImeVisibility(false);
                dismissSuggestions();
            }
        }
    }

    public boolean k(View view, int i11, KeyEvent keyEvent) {
        int i12;
        if (this.f872i != null && this.f871h != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i11 == 66 || i11 == 84 || i11 == 61) {
                return f(this.f865b.getListSelection(), 0, (String) null);
            }
            if (i11 == 21 || i11 == 22) {
                if (i11 == 21) {
                    i12 = 0;
                } else {
                    i12 = this.f865b.length();
                }
                this.f865b.setSelection(i12);
                this.f865b.setListSelection(0);
                this.f865b.clearListSelection();
                this.f865b.a();
                return true;
            } else if (i11 == 19) {
                this.f865b.getListSelection();
                return false;
            }
        }
        return false;
    }

    public void l(CharSequence charSequence) {
        Editable text = this.f865b.getText();
        this.mUserQuery = text;
        boolean z11 = !TextUtils.isEmpty(text);
        updateSubmitButton(z11);
        updateVoiceButton(!z11);
        updateCloseButton();
        updateSubmitArea();
        if (this.mOnQueryChangeListener != null && !TextUtils.equals(charSequence, this.mOldQueryText)) {
            this.mOnQueryChangeListener.onQueryTextChange(charSequence.toString());
        }
        this.mOldQueryText = charSequence.toString();
    }

    public void m() {
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        if (this.f865b.hasFocus()) {
            b();
        }
    }

    public void n() {
        SearchableInfo searchableInfo = this.f872i;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, searchableInfo));
                }
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    public void o() {
        int[] iArr;
        if (this.f865b.hasFocus()) {
            iArr = ViewGroup.FOCUSED_STATE_SET;
        } else {
            iArr = ViewGroup.EMPTY_STATE_SET;
        }
        Drawable background = this.mSearchPlate.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.mSubmitArea.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        updateViewsVisibility(true);
        this.f865b.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = false;
    }

    public void onActionViewExpanded() {
        if (!this.mExpandedInActionView) {
            this.mExpandedInActionView = true;
            int imeOptions = this.f865b.getImeOptions();
            this.mCollapsedImeOptions = imeOptions;
            this.f865b.setImeOptions(imeOptions | 33554432);
            this.f865b.setText("");
            setIconified(false);
        }
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (z11) {
            getChildBoundsWithinSearchView(this.f865b, this.mSearchSrcTextViewBounds);
            Rect rect = this.mSearchSrtTextViewBoundsExpanded;
            Rect rect2 = this.mSearchSrcTextViewBounds;
            rect.set(rect2.left, 0, rect2.right, i14 - i12);
            UpdatableTouchDelegate updatableTouchDelegate = this.mTouchDelegate;
            if (updatableTouchDelegate == null) {
                UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.f865b);
                this.mTouchDelegate = updatableTouchDelegate2;
                setTouchDelegate(updatableTouchDelegate2);
                return;
            }
            updatableTouchDelegate.setBounds(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        if (isIconified()) {
            super.onMeasure(i11, i12);
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE) {
            int i14 = this.mMaxWidth;
            size = i14 > 0 ? Math.min(i14, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.mMaxWidth;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i13 = this.mMaxWidth) > 0) {
            size = Math.min(i13, size);
        }
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        updateViewsVisibility(savedState.f884b);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f884b = isIconified();
        return savedState;
    }

    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        postUpdateFocusedState();
    }

    public boolean requestFocus(int i11, Rect rect) {
        if (this.mClearingFocus || !isFocusable()) {
            return false;
        }
        if (isIconified()) {
            return super.requestFocus(i11, rect);
        }
        boolean requestFocus = this.f865b.requestFocus(i11, rect);
        if (requestFocus) {
            updateViewsVisibility(false);
        }
        return requestFocus;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle bundle) {
        this.mAppSearchData = bundle;
    }

    public void setIconified(boolean z11) {
        if (z11) {
            e();
        } else {
            i();
        }
    }

    public void setIconifiedByDefault(boolean z11) {
        if (this.mIconifiedByDefault != z11) {
            this.mIconifiedByDefault = z11;
            updateViewsVisibility(z11);
            updateQueryHint();
        }
    }

    public void setImeOptions(int i11) {
        this.f865b.setImeOptions(i11);
    }

    public void setInputType(int i11) {
        this.f865b.setInputType(i11);
    }

    public void setMaxWidth(int i11) {
        this.mMaxWidth = i11;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f870g = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.mOnQueryChangeListener = onQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.mOnSearchClickListener = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.mOnSuggestionListener = onSuggestionListener;
    }

    public void setQuery(CharSequence charSequence, boolean z11) {
        this.f865b.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f865b;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.mUserQuery = charSequence;
        }
        if (z11 && !TextUtils.isEmpty(charSequence)) {
            j();
        }
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        this.mQueryHint = charSequence;
        updateQueryHint();
    }

    public void setQueryRefinementEnabled(boolean z11) {
        int i11;
        this.mQueryRefinement = z11;
        CursorAdapter cursorAdapter = this.f871h;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) cursorAdapter;
            if (z11) {
                i11 = 2;
            } else {
                i11 = 1;
            }
            suggestionsAdapter.setQueryRefinement(i11);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f872i = searchableInfo;
        if (searchableInfo != null) {
            updateSearchAutoComplete();
            updateQueryHint();
        }
        boolean hasVoiceSearch = hasVoiceSearch();
        this.mVoiceButtonEnabled = hasVoiceSearch;
        if (hasVoiceSearch) {
            this.f865b.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
        }
        updateViewsVisibility(isIconified());
    }

    public void setSubmitButtonEnabled(boolean z11) {
        this.mSubmitButtonEnabled = z11;
        updateViewsVisibility(isIconified());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.f871h = cursorAdapter;
        this.f865b.setAdapter(cursorAdapter);
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mSearchSrcTextViewBounds = new Rect();
        this.mSearchSrtTextViewBoundsExpanded = new Rect();
        this.mTemp = new int[2];
        this.mTemp2 = new int[2];
        this.mUpdateDrawableStateRunnable = new Runnable() {
            public void run() {
                SearchView.this.o();
            }
        };
        this.mReleaseCursorRunnable = new Runnable() {
            public void run() {
                CursorAdapter cursorAdapter = SearchView.this.f871h;
                if (cursorAdapter instanceof SuggestionsAdapter) {
                    cursorAdapter.changeCursor((Cursor) null);
                }
            }
        };
        this.mOutsideDrawablesCache = new WeakHashMap<>();
        AnonymousClass5 r82 = new View.OnClickListener() {
            public void onClick(View view) {
                SearchView searchView = SearchView.this;
                if (view == searchView.f866c) {
                    searchView.i();
                } else if (view == searchView.f868e) {
                    searchView.e();
                } else if (view == searchView.f867d) {
                    searchView.j();
                } else if (view == searchView.f869f) {
                    searchView.n();
                } else if (view == searchView.f865b) {
                    searchView.b();
                }
            }
        };
        this.mOnClickListener = r82;
        this.f873j = new View.OnKeyListener() {
            public boolean onKey(View view, int i11, KeyEvent keyEvent) {
                SearchView searchView = SearchView.this;
                if (searchView.f872i == null) {
                    return false;
                }
                if (searchView.f865b.isPopupShowing() && SearchView.this.f865b.getListSelection() != -1) {
                    return SearchView.this.k(view, i11, keyEvent);
                }
                if (SearchView.this.f865b.b() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i11 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView searchView2 = SearchView.this;
                searchView2.d(0, (String) null, searchView2.f865b.getText().toString());
                return true;
            }
        };
        AnonymousClass7 r92 = new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                SearchView.this.j();
                return true;
            }
        };
        this.mOnEditorActionListener = r92;
        AnonymousClass8 r102 = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                SearchView.this.f(i11, 0, (String) null);
            }
        };
        this.mOnItemClickListener = r102;
        AnonymousClass9 r11 = new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
                SearchView.this.g(i11);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.mOnItemSelectedListener = r11;
        this.mTextWatcher = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                SearchView.this.l(charSequence);
            }
        };
        int[] iArr = R.styleable.SearchView;
        AttributeSet attributeSet2 = attributeSet;
        int i12 = i11;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet2, iArr, i12, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet2, obtainStyledAttributes.getWrappedTypeArray(), i12, 0);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f865b = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.mSearchEditFrame = findViewById(R.id.search_edit_frame);
        View findViewById = findViewById(R.id.search_plate);
        this.mSearchPlate = findViewById;
        View findViewById2 = findViewById(R.id.submit_area);
        this.mSubmitArea = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f866c = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.f867d = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.f868e = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.f869f = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.mCollapsedIcon = imageView5;
        ViewCompat.setBackground(findViewById, obtainStyledAttributes.getDrawable(R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(findViewById2, obtainStyledAttributes.getDrawable(R.styleable.SearchView_submitBackground));
        int i13 = R.styleable.SearchView_searchIcon;
        imageView.setImageDrawable(obtainStyledAttributes.getDrawable(i13));
        imageView2.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_goIcon));
        imageView3.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(obtainStyledAttributes.getDrawable(i13));
        this.mSearchHintIcon = obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchHintIcon);
        TooltipCompat.setTooltipText(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.mSuggestionRowLayout = obtainStyledAttributes.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.mSuggestionCommitIconResId = obtainStyledAttributes.getResourceId(R.styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(r82);
        imageView3.setOnClickListener(r82);
        imageView2.setOnClickListener(r82);
        imageView4.setOnClickListener(r82);
        searchAutoComplete.setOnClickListener(r82);
        searchAutoComplete.addTextChangedListener(this.mTextWatcher);
        searchAutoComplete.setOnEditorActionListener(r92);
        searchAutoComplete.setOnItemClickListener(r102);
        searchAutoComplete.setOnItemSelectedListener(r11);
        searchAutoComplete.setOnKeyListener(this.f873j);
        searchAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                SearchView searchView = SearchView.this;
                View.OnFocusChangeListener onFocusChangeListener = searchView.f870g;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(searchView, z11);
                }
            }
        });
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.mDefaultQueryHint = obtainStyledAttributes.getText(R.styleable.SearchView_defaultQueryHint);
        this.mQueryHint = obtainStyledAttributes.getText(R.styleable.SearchView_queryHint);
        int i14 = obtainStyledAttributes.getInt(R.styleable.SearchView_android_imeOptions, -1);
        if (i14 != -1) {
            setImeOptions(i14);
        }
        int i15 = obtainStyledAttributes.getInt(R.styleable.SearchView_android_inputType, -1);
        if (i15 != -1) {
            setInputType(i15);
        }
        setFocusable(obtainStyledAttributes.getBoolean(R.styleable.SearchView_android_focusable, true));
        obtainStyledAttributes.recycle();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.mDropDownAnchor = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                    SearchView.this.a();
                }
            });
        }
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
    }

    private void setQuery(CharSequence charSequence) {
        this.f865b.setText(charSequence);
        this.f865b.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }
}
