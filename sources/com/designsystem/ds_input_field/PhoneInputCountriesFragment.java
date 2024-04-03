package com.designsystem.ds_input_field;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import com.designsystem.ds_bottom_sheet_v2.BottomSheet;
import com.designsystem.ds_empty_state_v2.EmptyStateComposablesKt;
import com.designsystem.ds_empty_state_v2.EmptyStateIcon;
import com.designsystem.ds_input_field.country.DSCountryModel;
import com.designsystem.ds_list_item_v2.DSPhoneNumberCountryListItemKt;
import com.designsystem.ds_search_field.DSSearchFieldKt;
import com.designsystem.ds_theme.DSTheme;
import com.designsystem.marshmallow.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 82\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\"\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010&J\u000f\u0010'\u001a\u00020\u001bH\u0001¢\u0006\u0004\b(\u0010#J\r\u0010)\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010#J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020,2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0012H\u0002J\u0012\u0010/\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u000101H\u0016J$\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00100\u001a\u0004\u0018\u000101H\u0016R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R7\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0014R'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b \u0010\u0014¨\u00069"}, d2 = {"Lcom/designsystem/ds_input_field/PhoneInputCountriesFragment;", "Landroidx/fragment/app/Fragment;", "()V", "countries", "", "Lcom/designsystem/ds_input_field/country/DSCountryModel;", "getCountries", "()Ljava/util/List;", "countries$delegate", "Lkotlin/Lazy;", "<set-?>", "displayedCountries", "getDisplayedCountries", "setDisplayedCountries", "(Ljava/util/List;)V", "displayedCountries$delegate", "Landroidx/compose/runtime/MutableState;", "emptyStateDetails", "", "getEmptyStateDetails", "()Ljava/lang/String;", "emptyStateDetails$delegate", "emptyStateTitle", "getEmptyStateTitle", "emptyStateTitle$delegate", "onCountrySelected", "Lkotlin/Function1;", "", "getOnCountrySelected", "()Lkotlin/jvm/functions/Function1;", "onCountrySelected$delegate", "searchHint", "getSearchHint", "searchHint$delegate", "CountriesEmptyState", "(Landroidx/compose/runtime/Composer;I)V", "CountryListItem", "country", "(Lcom/designsystem/ds_input_field/country/DSCountryModel;Landroidx/compose/runtime/Composer;I)V", "CountryPicker", "CountryPicker$marshmallow_release", "CountrySearchField", "allowSheetDrag", "allow", "", "countryMatchQuery", "query", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PhoneInputCountriesFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String PHONE_INPUT_COUNTRIES = "PHONE_INPUT_COUNTRIES";
    @NotNull
    private static final String PHONE_INPUT_EMPTY_STATE_DETAILS = "PHONE_INPUT_EMPTY_STATE_DETAILS";
    @NotNull
    private static final String PHONE_INPUT_EMPTY_STATE_TITLE = "PHONE_INPUT_EMPTY_STATE_TITLE";
    @NotNull
    private static final String PHONE_INPUT_ON_COUNTRY_SELECTED = "PHONE_INPUT_ON_COUNTRY_SELECTED";
    @NotNull
    private static final String PHONE_INPUT_SEARCH_HINT = "PHONE_INPUT_SEARCH_HINT";
    public Trace _nr_trace;
    @NotNull
    private final Lazy countries$delegate = LazyKt__LazyJVMKt.lazy(new PhoneInputCountriesFragment$countries$2(this));
    @NotNull
    private final MutableState displayedCountries$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt__CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final Lazy emptyStateDetails$delegate = LazyKt__LazyJVMKt.lazy(new PhoneInputCountriesFragment$emptyStateDetails$2(this));
    @NotNull
    private final Lazy emptyStateTitle$delegate = LazyKt__LazyJVMKt.lazy(new PhoneInputCountriesFragment$emptyStateTitle$2(this));
    @NotNull
    private final Lazy onCountrySelected$delegate = LazyKt__LazyJVMKt.lazy(new PhoneInputCountriesFragment$onCountrySelected$2(this));
    @NotNull
    private final Lazy searchHint$delegate = LazyKt__LazyJVMKt.lazy(new PhoneInputCountriesFragment$searchHint$2(this));

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/designsystem/ds_input_field/PhoneInputCountriesFragment$Companion;", "", "()V", "PHONE_INPUT_COUNTRIES", "", "PHONE_INPUT_EMPTY_STATE_DETAILS", "PHONE_INPUT_EMPTY_STATE_TITLE", "PHONE_INPUT_ON_COUNTRY_SELECTED", "PHONE_INPUT_SEARCH_HINT", "newInstance", "Lcom/designsystem/ds_input_field/PhoneInputCountriesFragment;", "countries", "", "Lcom/designsystem/ds_input_field/country/DSCountryModel;", "onCountrySelected", "Lkotlin/Function1;", "", "prefixSearchHint", "prefixSearchEmptyStateTitle", "prefixSearchEmptyStateDetails", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PhoneInputCountriesFragment newInstance(@NotNull List<DSCountryModel> list, @NotNull Function1<? super DSCountryModel, Unit> function1, @NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(list, "countries");
            Intrinsics.checkNotNullParameter(function1, "onCountrySelected");
            Intrinsics.checkNotNullParameter(str, "prefixSearchHint");
            Intrinsics.checkNotNullParameter(str2, "prefixSearchEmptyStateTitle");
            Intrinsics.checkNotNullParameter(str3, "prefixSearchEmptyStateDetails");
            PhoneInputCountriesFragment phoneInputCountriesFragment = new PhoneInputCountriesFragment();
            phoneInputCountriesFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(PhoneInputCountriesFragment.PHONE_INPUT_COUNTRIES, new ArrayList(list)), TuplesKt.to(PhoneInputCountriesFragment.PHONE_INPUT_ON_COUNTRY_SELECTED, function1), TuplesKt.to(PhoneInputCountriesFragment.PHONE_INPUT_SEARCH_HINT, str), TuplesKt.to(PhoneInputCountriesFragment.PHONE_INPUT_EMPTY_STATE_TITLE, str2), TuplesKt.to(PhoneInputCountriesFragment.PHONE_INPUT_EMPTY_STATE_DETAILS, str3)));
            return phoneInputCountriesFragment;
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public final void CountriesEmptyState(Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(1443781286);
        Modifier.Companion companion = Modifier.Companion;
        DSTheme dSTheme = DSTheme.INSTANCE;
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m487paddingVpY3zN4(companion, dSTheme.getDimens(startRestartGroup, 0).m8842getDsSD9Ej5fM(), dSTheme.getDimens(startRestartGroup, 0).m8840getDsLD9Ej5fM()), 0.0f, 1, (Object) null);
        Alignment center = Alignment.Companion.getCenter();
        startRestartGroup.startReplaceableGroup(-1990474327);
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(1376089335);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxWidth$default);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r72 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r72, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m2543setimpl(r72, density, companion2.getSetDensity());
        Updater.m2543setimpl(r72, layoutDirection, companion2.getSetLayoutDirection());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1253629305);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        EmptyStateComposablesKt.EmptyState(getEmptyStateTitle(), companion, getEmptyStateDetails(), (EmptyStateIcon) null, (String) null, (Function0<Unit>) null, false, startRestartGroup, 1797168, 0);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PhoneInputCountriesFragment$CountriesEmptyState$2(this, i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public final void CountryListItem(DSCountryModel dSCountryModel, Composer composer, int i11) {
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(592743063);
        String str = dSCountryModel.getNameTranslations().get(Locale.Companion.getCurrent().getLanguage());
        if (str == null) {
            str = dSCountryModel.getName();
        }
        String str2 = str;
        Integer image$marshmallow_release = dSCountryModel.getImage$marshmallow_release();
        if (image$marshmallow_release == null) {
            i12 = R.drawable.ds_country;
        } else {
            i12 = image$marshmallow_release.intValue();
        }
        DSPhoneNumberCountryListItemKt.DSPhoneNumberCountryListItem(str2, dSCountryModel.getPrefix(), (Modifier) null, Integer.valueOf(i12), new PhoneInputCountriesFragment$CountryListItem$1(this, dSCountryModel), startRestartGroup, 0, 4);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PhoneInputCountriesFragment$CountryListItem$2(this, dSCountryModel, i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public final void CountrySearchField(Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-897156600);
        Modifier.Companion companion = Modifier.Companion;
        DSTheme dSTheme = DSTheme.INSTANCE;
        Modifier r02 = PaddingKt.m490paddingqDBjuR0$default(companion, dSTheme.getDimens(startRestartGroup, 0).m8842getDsSD9Ej5fM(), 0.0f, dSTheme.getDimens(startRestartGroup, 0).m8842getDsSD9Ej5fM(), dSTheme.getDimens(startRestartGroup, 0).m8846getDsXxsD9Ej5fM(), 2, (Object) null);
        startRestartGroup.startReplaceableGroup(-1990474327);
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(1376089335);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r02);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r52 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r52, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m2543setimpl(r52, density, companion2.getSetDensity());
        Updater.m2543setimpl(r52, layoutDirection, companion2.getSetLayoutDirection());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1253629305);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        DSSearchFieldKt.DSSearchField((Modifier) null, (String) null, new PhoneInputCountriesFragment$CountrySearchField$1$1(this), (Function0<Unit>) null, (Function0<Unit>) null, getSearchHint(), 0, 0, startRestartGroup, 0, 219);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PhoneInputCountriesFragment$CountrySearchField$2(this, i11));
        }
    }

    /* access modifiers changed from: private */
    public final void allowSheetDrag(boolean z11) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            Dialog dialog = ((BottomSheet) parentFragment).getDialog();
            if (dialog != null) {
                ((BottomSheetDialog) dialog).getBehavior().setDraggable(z11);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.designsystem.ds_bottom_sheet_v2.BottomSheet");
    }

    /* access modifiers changed from: private */
    public final boolean countryMatchQuery(DSCountryModel dSCountryModel, String str) {
        Boolean bool;
        boolean z11;
        String language = Locale.Companion.getCurrent().getLanguage();
        if (language != null) {
            String lowerCase = language.toLowerCase(java.util.Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
            String str2 = dSCountryModel.getNameTranslations().get(lowerCase);
            if (str2 == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(StringsKt__StringsKt.contains((CharSequence) str2, (CharSequence) str, true));
            }
            if (bool == null) {
                z11 = StringsKt__StringsKt.contains((CharSequence) dSCountryModel.getName(), (CharSequence) str, true);
            } else {
                z11 = bool.booleanValue();
            }
            if (z11 || StringsKt__StringsKt.contains((CharSequence) dSCountryModel.getPrefix(), (CharSequence) str, true)) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* access modifiers changed from: private */
    public final List<DSCountryModel> getCountries() {
        return (List) this.countries$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final List<DSCountryModel> getDisplayedCountries() {
        return (List) this.displayedCountries$delegate.getValue();
    }

    private final String getEmptyStateDetails() {
        return (String) this.emptyStateDetails$delegate.getValue();
    }

    private final String getEmptyStateTitle() {
        return (String) this.emptyStateTitle$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Function1<DSCountryModel, Unit> getOnCountrySelected() {
        return (Function1) this.onCountrySelected$delegate.getValue();
    }

    private final String getSearchHint() {
        return (String) this.searchHint$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setDisplayedCountries(List<DSCountryModel> list) {
        this.displayedCountries$delegate.setValue(list);
    }

    @Composable
    public final void CountryPicker$marshmallow_release(@Nullable Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(644000327);
        LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
        EffectsKt.LaunchedEffect((Object) rememberLazyListState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new PhoneInputCountriesFragment$CountryPicker$1(rememberLazyListState, this, (Continuation<? super PhoneInputCountriesFragment$CountryPicker$1>) null), startRestartGroup, 0);
        PhoneInputCountriesFragment$CountryPicker$scrollConnection$1 phoneInputCountriesFragment$CountryPicker$scrollConnection$1 = new PhoneInputCountriesFragment$CountryPicker$scrollConnection$1(this);
        Modifier.Companion companion = Modifier.Companion;
        Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion, phoneInputCountriesFragment$CountryPicker$scrollConnection$1, (NestedScrollDispatcher) null, 2, (Object) null);
        startRestartGroup.startReplaceableGroup(-1113031299);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(1376089335);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(nestedScroll$default);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r82 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r82, columnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m2543setimpl(r82, density, companion2.getSetDensity());
        Updater.m2543setimpl(r82, layoutDirection, companion2.getSetLayoutDirection());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(276693241);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        CountrySearchField(startRestartGroup, 8);
        LazyDslKt.LazyColumn(companion, rememberLazyListState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, new PhoneInputCountriesFragment$CountryPicker$2$1(this), startRestartGroup, 6, 124);
        if (getDisplayedCountries().isEmpty()) {
            startRestartGroup.startReplaceableGroup(1821019828);
            CountriesEmptyState(startRestartGroup, 8);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(1821019881);
            startRestartGroup.endReplaceableGroup();
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PhoneInputCountriesFragment$CountryPicker$3(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("PhoneInputCountriesFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "PhoneInputCountriesFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "PhoneInputCountriesFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setDisplayedCountries(getCountries());
        TraceMachine.exitMethod();
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "PhoneInputCountriesFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "PhoneInputCountriesFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ComposeView composeView = new ComposeView(requireContext, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-985530991, true, new PhoneInputCountriesFragment$onCreateView$1$1(this)));
        TraceMachine.exitMethod();
        return composeView;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
