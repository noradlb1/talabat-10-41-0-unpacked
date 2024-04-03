package com.talabat.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.adapters.RatePagerAdapter;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.squads.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mq.l;
import mq.m;
import mq.n;
import mq.o;
import mq.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Instrumented
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/talabat/fragments/RateFeedbackFragment;", "Landroidx/fragment/app/Fragment;", "()V", "deliveryTimeTag", "Landroid/widget/TextView;", "packingTag", "qualityFoodTag", "ratingFragmentCallbacksListener", "Lcom/talabat/adapters/RatePagerAdapter$RatingFragmentCallbacksListener;", "reviewEdt", "Landroid/widget/EditText;", "suggestionContainer", "Landroid/widget/LinearLayout;", "valueOfMoneyTag", "getReview", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setCallbackListener", "listener", "setDeliveryRate", "deliveryRate", "", "setRestaurantRate", "restaurantRate", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RateFeedbackFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    private TextView deliveryTimeTag;
    private TextView packingTag;
    private TextView qualityFoodTag;
    private RatePagerAdapter.RatingFragmentCallbacksListener ratingFragmentCallbacksListener;
    private EditText reviewEdt;
    private LinearLayout suggestionContainer;
    private TextView valueOfMoneyTag;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/fragments/RateFeedbackFragment$Companion;", "", "()V", "getInstance", "Lcom/talabat/fragments/RateFeedbackFragment;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RateFeedbackFragment getInstance() {
            return new RateFeedbackFragment();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m10490onCreateView$lambda0(RateFeedbackFragment rateFeedbackFragment, View view) {
        boolean z11;
        Intrinsics.checkNotNullParameter(rateFeedbackFragment, "this$0");
        EditText editText = rateFeedbackFragment.reviewEdt;
        LinearLayout linearLayout = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText = null;
        }
        if (editText.getText().toString().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            EditText editText2 = rateFeedbackFragment.reviewEdt;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
                editText2 = null;
            }
            EditText editText3 = rateFeedbackFragment.reviewEdt;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
                editText3 = null;
            }
            editText2.setText(editText3.getText().append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR));
        }
        EditText editText4 = rateFeedbackFragment.reviewEdt;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText4 = null;
        }
        EditText editText5 = rateFeedbackFragment.reviewEdt;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText5 = null;
        }
        Editable text = editText5.getText();
        TextView textView = rateFeedbackFragment.packingTag;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packingTag");
            textView = null;
        }
        editText4.setText(text.append(textView.getText().toString()));
        EditText editText6 = rateFeedbackFragment.reviewEdt;
        if (editText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText6 = null;
        }
        EditText editText7 = rateFeedbackFragment.reviewEdt;
        if (editText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText7 = null;
        }
        editText6.setSelection(editText7.getText().length());
        TextView textView2 = rateFeedbackFragment.packingTag;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packingTag");
            textView2 = null;
        }
        textView2.setVisibility(8);
        TextView textView3 = rateFeedbackFragment.qualityFoodTag;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qualityFoodTag");
            textView3 = null;
        }
        if (textView3.getVisibility() == 8) {
            TextView textView4 = rateFeedbackFragment.packingTag;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packingTag");
                textView4 = null;
            }
            if (textView4.getVisibility() == 8) {
                TextView textView5 = rateFeedbackFragment.valueOfMoneyTag;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("valueOfMoneyTag");
                    textView5 = null;
                }
                if (textView5.getVisibility() == 8) {
                    TextView textView6 = rateFeedbackFragment.deliveryTimeTag;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("deliveryTimeTag");
                        textView6 = null;
                    }
                    if (textView6.getVisibility() == 8) {
                        LinearLayout linearLayout2 = rateFeedbackFragment.suggestionContainer;
                        if (linearLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("suggestionContainer");
                        } else {
                            linearLayout = linearLayout2;
                        }
                        linearLayout.setVisibility(8);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-1  reason: not valid java name */
    public static final void m10491onCreateView$lambda1(RateFeedbackFragment rateFeedbackFragment, View view) {
        boolean z11;
        Intrinsics.checkNotNullParameter(rateFeedbackFragment, "this$0");
        EditText editText = rateFeedbackFragment.reviewEdt;
        LinearLayout linearLayout = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText = null;
        }
        if (editText.getText().toString().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            EditText editText2 = rateFeedbackFragment.reviewEdt;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
                editText2 = null;
            }
            EditText editText3 = rateFeedbackFragment.reviewEdt;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
                editText3 = null;
            }
            editText2.setText(editText3.getText().append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR));
        }
        EditText editText4 = rateFeedbackFragment.reviewEdt;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText4 = null;
        }
        EditText editText5 = rateFeedbackFragment.reviewEdt;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText5 = null;
        }
        Editable text = editText5.getText();
        TextView textView = rateFeedbackFragment.deliveryTimeTag;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryTimeTag");
            textView = null;
        }
        editText4.setText(text.append(textView.getText().toString()));
        EditText editText6 = rateFeedbackFragment.reviewEdt;
        if (editText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText6 = null;
        }
        EditText editText7 = rateFeedbackFragment.reviewEdt;
        if (editText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText7 = null;
        }
        editText6.setSelection(editText7.getText().length());
        TextView textView2 = rateFeedbackFragment.deliveryTimeTag;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryTimeTag");
            textView2 = null;
        }
        textView2.setVisibility(8);
        TextView textView3 = rateFeedbackFragment.qualityFoodTag;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qualityFoodTag");
            textView3 = null;
        }
        if (textView3.getVisibility() == 8) {
            TextView textView4 = rateFeedbackFragment.packingTag;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packingTag");
                textView4 = null;
            }
            if (textView4.getVisibility() == 8) {
                TextView textView5 = rateFeedbackFragment.valueOfMoneyTag;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("valueOfMoneyTag");
                    textView5 = null;
                }
                if (textView5.getVisibility() == 8) {
                    TextView textView6 = rateFeedbackFragment.deliveryTimeTag;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("deliveryTimeTag");
                        textView6 = null;
                    }
                    if (textView6.getVisibility() == 8) {
                        LinearLayout linearLayout2 = rateFeedbackFragment.suggestionContainer;
                        if (linearLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("suggestionContainer");
                        } else {
                            linearLayout = linearLayout2;
                        }
                        linearLayout.setVisibility(8);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-2  reason: not valid java name */
    public static final void m10492onCreateView$lambda2(RateFeedbackFragment rateFeedbackFragment, View view) {
        boolean z11;
        Intrinsics.checkNotNullParameter(rateFeedbackFragment, "this$0");
        EditText editText = rateFeedbackFragment.reviewEdt;
        LinearLayout linearLayout = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText = null;
        }
        if (editText.getText().toString().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            EditText editText2 = rateFeedbackFragment.reviewEdt;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
                editText2 = null;
            }
            EditText editText3 = rateFeedbackFragment.reviewEdt;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
                editText3 = null;
            }
            editText2.setText(editText3.getText().append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR));
        }
        EditText editText4 = rateFeedbackFragment.reviewEdt;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText4 = null;
        }
        EditText editText5 = rateFeedbackFragment.reviewEdt;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText5 = null;
        }
        Editable text = editText5.getText();
        TextView textView = rateFeedbackFragment.valueOfMoneyTag;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueOfMoneyTag");
            textView = null;
        }
        editText4.setText(text.append(textView.getText().toString()));
        EditText editText6 = rateFeedbackFragment.reviewEdt;
        if (editText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText6 = null;
        }
        EditText editText7 = rateFeedbackFragment.reviewEdt;
        if (editText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText7 = null;
        }
        editText6.setSelection(editText7.getText().length());
        TextView textView2 = rateFeedbackFragment.valueOfMoneyTag;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueOfMoneyTag");
            textView2 = null;
        }
        textView2.setVisibility(8);
        TextView textView3 = rateFeedbackFragment.qualityFoodTag;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qualityFoodTag");
            textView3 = null;
        }
        if (textView3.getVisibility() == 8) {
            TextView textView4 = rateFeedbackFragment.packingTag;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packingTag");
                textView4 = null;
            }
            if (textView4.getVisibility() == 8) {
                TextView textView5 = rateFeedbackFragment.valueOfMoneyTag;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("valueOfMoneyTag");
                    textView5 = null;
                }
                if (textView5.getVisibility() == 8) {
                    TextView textView6 = rateFeedbackFragment.deliveryTimeTag;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("deliveryTimeTag");
                        textView6 = null;
                    }
                    if (textView6.getVisibility() == 8) {
                        LinearLayout linearLayout2 = rateFeedbackFragment.suggestionContainer;
                        if (linearLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("suggestionContainer");
                        } else {
                            linearLayout = linearLayout2;
                        }
                        linearLayout.setVisibility(8);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-3  reason: not valid java name */
    public static final void m10493onCreateView$lambda3(RateFeedbackFragment rateFeedbackFragment, View view) {
        boolean z11;
        Intrinsics.checkNotNullParameter(rateFeedbackFragment, "this$0");
        EditText editText = rateFeedbackFragment.reviewEdt;
        LinearLayout linearLayout = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText = null;
        }
        if (editText.getText().toString().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            EditText editText2 = rateFeedbackFragment.reviewEdt;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
                editText2 = null;
            }
            EditText editText3 = rateFeedbackFragment.reviewEdt;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
                editText3 = null;
            }
            editText2.setText(editText3.getText().append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR));
        }
        EditText editText4 = rateFeedbackFragment.reviewEdt;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText4 = null;
        }
        EditText editText5 = rateFeedbackFragment.reviewEdt;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText5 = null;
        }
        Editable text = editText5.getText();
        TextView textView = rateFeedbackFragment.qualityFoodTag;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qualityFoodTag");
            textView = null;
        }
        editText4.setText(text.append(textView.getText().toString()));
        EditText editText6 = rateFeedbackFragment.reviewEdt;
        if (editText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText6 = null;
        }
        EditText editText7 = rateFeedbackFragment.reviewEdt;
        if (editText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText7 = null;
        }
        editText6.setSelection(editText7.getText().length());
        TextView textView2 = rateFeedbackFragment.qualityFoodTag;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qualityFoodTag");
            textView2 = null;
        }
        textView2.setVisibility(8);
        TextView textView3 = rateFeedbackFragment.qualityFoodTag;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qualityFoodTag");
            textView3 = null;
        }
        if (textView3.getVisibility() == 8) {
            TextView textView4 = rateFeedbackFragment.packingTag;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packingTag");
                textView4 = null;
            }
            if (textView4.getVisibility() == 8) {
                TextView textView5 = rateFeedbackFragment.valueOfMoneyTag;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("valueOfMoneyTag");
                    textView5 = null;
                }
                if (textView5.getVisibility() == 8) {
                    TextView textView6 = rateFeedbackFragment.deliveryTimeTag;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("deliveryTimeTag");
                        textView6 = null;
                    }
                    if (textView6.getVisibility() == 8) {
                        LinearLayout linearLayout2 = rateFeedbackFragment.suggestionContainer;
                        if (linearLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("suggestionContainer");
                        } else {
                            linearLayout = linearLayout2;
                        }
                        linearLayout.setVisibility(8);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m10494onViewCreated$lambda4(RateFeedbackFragment rateFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(rateFeedbackFragment, "this$0");
        RatePagerAdapter.RatingFragmentCallbacksListener ratingFragmentCallbacksListener2 = rateFeedbackFragment.ratingFragmentCallbacksListener;
        if (ratingFragmentCallbacksListener2 != null) {
            if (ratingFragmentCallbacksListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingFragmentCallbacksListener");
                ratingFragmentCallbacksListener2 = null;
            }
            ratingFragmentCallbacksListener2.onCloseClicked();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @NotNull
    public final String getReview() {
        EditText editText = this.reviewEdt;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewEdt");
            editText = null;
        }
        return editText.getText().toString();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        TextView textView = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "RateFeedbackFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "RateFeedbackFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = getLayoutInflater().inflate(R.layout.fragment_rate_feedback, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.editText_review);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.editText_review)");
        this.reviewEdt = (EditText) findViewById;
        View findViewById2 = inflate.findViewById(R.id.packingTag);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.packingTag)");
        this.packingTag = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.deliveryTimeTag);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.deliveryTimeTag)");
        this.deliveryTimeTag = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.valueOfMoneyTag);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.valueOfMoneyTag)");
        this.valueOfMoneyTag = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.qualityFoodTag);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.qualityFoodTag)");
        this.qualityFoodTag = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.linearLayout_suggestionContainer);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.l…yout_suggestionContainer)");
        this.suggestionContainer = (LinearLayout) findViewById6;
        TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
        TalabatExperimentConstants talabatExperimentConstants = TalabatExperimentConstants.CAN_SHOW_NEW_RATE_SUGGESTIONS;
        Boolean bool = BuildConfig.IS_ALPHA;
        Intrinsics.checkNotNullExpressionValue(bool, "IS_ALPHA");
        if (talabatExperiment.getBooleanVariant(talabatExperimentConstants, bool.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            LinearLayout linearLayout = this.suggestionContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestionContainer");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
        } else {
            LinearLayout linearLayout2 = this.suggestionContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestionContainer");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
        }
        TextView textView2 = this.packingTag;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packingTag");
            textView2 = null;
        }
        textView2.setOnClickListener(new m(this));
        TextView textView3 = this.deliveryTimeTag;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryTimeTag");
            textView3 = null;
        }
        textView3.setOnClickListener(new n(this));
        TextView textView4 = this.valueOfMoneyTag;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueOfMoneyTag");
            textView4 = null;
        }
        textView4.setOnClickListener(new o(this));
        TextView textView5 = this.qualityFoodTag;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qualityFoodTag");
        } else {
            textView = textView5;
        }
        textView.setOnClickListener(new p(this));
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((ImageView) _$_findCachedViewById(R.id.btn_rating_close)).setOnClickListener(new l(this));
    }

    public final void setCallbackListener(@NotNull RatePagerAdapter.RatingFragmentCallbacksListener ratingFragmentCallbacksListener2) {
        Intrinsics.checkNotNullParameter(ratingFragmentCallbacksListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.ratingFragmentCallbacksListener = ratingFragmentCallbacksListener2;
    }

    public final void setDeliveryRate(float f11) {
        int i11 = (int) f11;
        TextView textView = null;
        if (i11 == 1 || i11 == 2) {
            TextView textView2 = this.deliveryTimeTag;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deliveryTimeTag");
            } else {
                textView = textView2;
            }
            textView.setText(getString(R.string.time_bad));
        } else if (i11 == 3) {
            TextView textView3 = this.deliveryTimeTag;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deliveryTimeTag");
            } else {
                textView = textView3;
            }
            textView.setText(getString(R.string.time_expected));
        } else if (i11 == 4) {
            TextView textView4 = this.deliveryTimeTag;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deliveryTimeTag");
            } else {
                textView = textView4;
            }
            textView.setText(getString(R.string.time_fast));
        } else if (i11 == 5) {
            TextView textView5 = this.deliveryTimeTag;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deliveryTimeTag");
            } else {
                textView = textView5;
            }
            textView.setText(getString(R.string.super_fast));
        }
    }

    public final void setRestaurantRate(float f11) {
        int i11 = (int) f11;
        TextView textView = null;
        if (i11 == 1 || i11 == 2) {
            TextView textView2 = this.packingTag;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packingTag");
                textView2 = null;
            }
            textView2.setText(getString(R.string.bad_packed));
            TextView textView3 = this.valueOfMoneyTag;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueOfMoneyTag");
                textView3 = null;
            }
            textView3.setText(getString(R.string.was_not_greate_money));
            TextView textView4 = this.qualityFoodTag;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qualityFoodTag");
            } else {
                textView = textView4;
            }
            textView.setText(getString(R.string.food_not_quality));
        } else if (i11 == 3) {
            TextView textView5 = this.packingTag;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packingTag");
                textView5 = null;
            }
            textView5.setText(getString(R.string.pack_average));
            TextView textView6 = this.valueOfMoneyTag;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueOfMoneyTag");
                textView6 = null;
            }
            textView6.setText(getString(R.string.average_money));
            TextView textView7 = this.qualityFoodTag;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qualityFoodTag");
            } else {
                textView = textView7;
            }
            textView.setText(getString(R.string.food_quality_better));
        } else if (i11 == 4) {
            TextView textView8 = this.packingTag;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packingTag");
                textView8 = null;
            }
            textView8.setText(getString(R.string.love_pack));
            TextView textView9 = this.valueOfMoneyTag;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueOfMoneyTag");
                textView9 = null;
            }
            textView9.setText(getString(R.string.quality_money));
            TextView textView10 = this.qualityFoodTag;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qualityFoodTag");
            } else {
                textView = textView10;
            }
            textView.setText(getString(R.string.food_good));
        } else if (i11 == 5) {
            TextView textView11 = this.packingTag;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packingTag");
                textView11 = null;
            }
            textView11.setText(getString(R.string.prefect_pack));
            TextView textView12 = this.valueOfMoneyTag;
            if (textView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueOfMoneyTag");
                textView12 = null;
            }
            textView12.setText(getString(R.string.greate_quality));
            TextView textView13 = this.qualityFoodTag;
            if (textView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qualityFoodTag");
            } else {
                textView = textView13;
            }
            textView.setText(getString(R.string.food_very_good));
        }
    }
}
