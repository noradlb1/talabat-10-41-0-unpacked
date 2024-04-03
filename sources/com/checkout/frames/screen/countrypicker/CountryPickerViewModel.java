package com.checkout.frames.screen.countrypicker;

import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.checkout.base.mapper.Mapper;
import com.checkout.base.model.Country;
import com.checkout.frames.R;
import com.checkout.frames.di.base.InjectionClient;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.di.component.CountryPickerViewModelSubComponent;
import com.checkout.frames.mapper.ImageStyleToDynamicComposableImageMapper;
import com.checkout.frames.model.request.ImageStyleToDynamicImageRequest;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.screen.CountryPickerStyle;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.utils.extensions.CountryExtensionsKt;
import com.checkout.frames.view.InputFieldState;
import com.checkout.frames.view.TextLabelState;
import com.checkout.tokenization.model.Address;
import d2.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001:\u0001CB\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0005\u0012\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u000e0\u0005\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\b\u00104\u001a\u000205H\u0007J\u000e\u00106\u001a\u0002052\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020\u001cJ\r\u0010;\u001a\u000205H\u0001¢\u0006\u0002\b<J\b\u0010=\u001a\u000205H\u0007J\u000e\u0010>\u001a\u0002052\u0006\u0010?\u001a\u000208J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0010\u0010A\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010B\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001d\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u001b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0011\u0010,\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010)R\u001c\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/checkout/frames/screen/countrypicker/CountryPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "paymentStateManager", "Lcom/checkout/frames/screen/manager/PaymentStateManager;", "inputFieldStyleMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/InputFieldStyle;", "Lcom/checkout/frames/style/view/InputFieldViewStyle;", "inputFieldStateMapper", "Lcom/checkout/frames/view/InputFieldState;", "textLabelStyleMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "textLabelStateMapper", "Lcom/checkout/frames/view/TextLabelState;", "containerMapper", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Landroidx/compose/ui/Modifier;", "imageMapper", "Lcom/checkout/frames/mapper/ImageStyleToDynamicComposableImageMapper;", "style", "Lcom/checkout/frames/style/screen/CountryPickerStyle;", "(Lcom/checkout/frames/screen/manager/PaymentStateManager;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/frames/mapper/ImageStyleToDynamicComposableImageMapper;Lcom/checkout/frames/style/screen/CountryPickerStyle;)V", "allCountries", "", "Lcom/checkout/frames/screen/countrypicker/CountryItem;", "goBack", "Landroidx/compose/runtime/MutableState;", "", "getGoBack", "()Landroidx/compose/runtime/MutableState;", "isInputFocused", "isSearchActive", "screenModifier", "getScreenModifier", "()Landroidx/compose/ui/Modifier;", "screenTitleState", "getScreenTitleState", "()Lcom/checkout/frames/view/TextLabelState;", "screenTitleStyle", "getScreenTitleStyle", "()Lcom/checkout/frames/style/view/TextLabelViewStyle;", "searchCountries", "getSearchCountries", "searchFieldState", "getSearchFieldState", "()Lcom/checkout/frames/view/InputFieldState;", "searchFieldStyle", "getSearchFieldStyle", "()Lcom/checkout/frames/style/view/InputFieldViewStyle;", "searchItemStyle", "getSearchItemStyle", "onClear", "", "onCountryChosen", "iso2", "", "onFocusChanged", "isFocused", "onLeaveScreen", "onLeaveScreen$frames_release", "onReset", "onSearchChange", "text", "provideAllCountryItems", "provideScreenTitleState", "provideSearchFieldState", "Factory", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CountryPickerViewModel extends ViewModel {
    @NotNull
    private final List<CountryItem> allCountries;
    @NotNull
    private final MutableState<Boolean> goBack;
    @NotNull
    private final ImageStyleToDynamicComposableImageMapper imageMapper;
    @NotNull
    private final Mapper<InputFieldStyle, InputFieldState> inputFieldStateMapper;
    private boolean isInputFocused;
    @NotNull
    private final MutableState<Boolean> isSearchActive;
    @NotNull
    private final PaymentStateManager paymentStateManager;
    @NotNull
    private final Modifier screenModifier;
    @NotNull
    private final TextLabelState screenTitleState;
    @NotNull
    private final TextLabelViewStyle screenTitleStyle;
    @NotNull
    private final MutableState<List<CountryItem>> searchCountries;
    @NotNull
    private final InputFieldState searchFieldState;
    @NotNull
    private final InputFieldViewStyle searchFieldStyle;
    @NotNull
    private final TextLabelViewStyle searchItemStyle;
    @NotNull
    private final Mapper<TextLabelStyle, TextLabelState> textLabelStateMapper;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/checkout/frames/screen/countrypicker/CountryPickerViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/checkout/frames/di/base/InjectionClient;", "injector", "Lcom/checkout/frames/di/base/Injector;", "style", "Lcom/checkout/frames/style/screen/CountryPickerStyle;", "(Lcom/checkout/frames/di/base/Injector;Lcom/checkout/frames/style/screen/CountryPickerStyle;)V", "subComponentProvider", "Ljavax/inject/Provider;", "Lcom/checkout/frames/di/component/CountryPickerViewModelSubComponent$Builder;", "getSubComponentProvider", "()Ljavax/inject/Provider;", "setSubComponentProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory implements ViewModelProvider.Factory, InjectionClient {
        @NotNull
        private final Injector injector;
        @NotNull
        private final CountryPickerStyle style;
        @Inject
        public Provider<CountryPickerViewModelSubComponent.Builder> subComponentProvider;

        public Factory(@NotNull Injector injector2, @NotNull CountryPickerStyle countryPickerStyle) {
            Intrinsics.checkNotNullParameter(injector2, "injector");
            Intrinsics.checkNotNullParameter(countryPickerStyle, "style");
            this.injector = injector2;
            this.style = countryPickerStyle;
        }

        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            this.injector.inject(this);
            T countryPickerViewModel = getSubComponentProvider().get().style(this.style).build().getCountryPickerViewModel();
            Intrinsics.checkNotNull(countryPickerViewModel, "null cannot be cast to non-null type T of com.checkout.frames.screen.countrypicker.CountryPickerViewModel.Factory.create");
            return countryPickerViewModel;
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return h.b(this, cls, creationExtras);
        }

        @NotNull
        public final Provider<CountryPickerViewModelSubComponent.Builder> getSubComponentProvider() {
            Provider<CountryPickerViewModelSubComponent.Builder> provider = this.subComponentProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentProvider");
            return null;
        }

        public final void setSubComponentProvider(@NotNull Provider<CountryPickerViewModelSubComponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentProvider = provider;
        }
    }

    @Inject
    public CountryPickerViewModel(@NotNull PaymentStateManager paymentStateManager2, @NotNull Mapper<InputFieldStyle, InputFieldViewStyle> mapper, @NotNull Mapper<InputFieldStyle, InputFieldState> mapper2, @NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper3, @NotNull Mapper<TextLabelStyle, TextLabelState> mapper4, @NotNull Mapper<ContainerStyle, Modifier> mapper5, @NotNull ImageStyleToDynamicComposableImageMapper imageStyleToDynamicComposableImageMapper, @NotNull CountryPickerStyle countryPickerStyle) {
        Intrinsics.checkNotNullParameter(paymentStateManager2, "paymentStateManager");
        Intrinsics.checkNotNullParameter(mapper, "inputFieldStyleMapper");
        Intrinsics.checkNotNullParameter(mapper2, "inputFieldStateMapper");
        Intrinsics.checkNotNullParameter(mapper3, "textLabelStyleMapper");
        Intrinsics.checkNotNullParameter(mapper4, "textLabelStateMapper");
        Intrinsics.checkNotNullParameter(mapper5, "containerMapper");
        Intrinsics.checkNotNullParameter(imageStyleToDynamicComposableImageMapper, "imageMapper");
        Intrinsics.checkNotNullParameter(countryPickerStyle, "style");
        this.paymentStateManager = paymentStateManager2;
        this.inputFieldStateMapper = mapper2;
        this.textLabelStateMapper = mapper4;
        this.imageMapper = imageStyleToDynamicComposableImageMapper;
        this.screenTitleStyle = mapper3.map(countryPickerStyle.getScreenTitleStyle());
        this.screenTitleState = provideScreenTitleState(countryPickerStyle.getScreenTitleStyle());
        this.searchFieldStyle = mapper.map(countryPickerStyle.getSearchFieldStyle());
        this.searchFieldState = provideSearchFieldState(countryPickerStyle.getSearchFieldStyle());
        this.searchItemStyle = mapper3.map(countryPickerStyle.getSearchItemStyle());
        this.screenModifier = mapper5.map(countryPickerStyle.getContainerStyle());
        List<CountryItem> provideAllCountryItems = provideAllCountryItems();
        this.allCountries = provideAllCountryItems;
        this.searchCountries = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(provideAllCountryItems, (SnapshotMutationPolicy) null, 2, (Object) null);
        Boolean bool = Boolean.FALSE;
        this.isSearchActive = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.goBack = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private final List<CountryItem> provideAllCountryItems() {
        boolean z11;
        Iterable<Country> list = ArraysKt___ArraysKt.toList((T[]) Country.values());
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Country country : list) {
            String displayCountry = new Locale(Locale.getDefault().getLanguage(), country.getIso3166Alpha2()).getDisplayCountry();
            Intrinsics.checkNotNullExpressionValue(displayCountry, "Locale(Locale.getDefault…166Alpha2).displayCountry");
            arrayList.add(new CountryItem(displayCountry, CountryExtensionsKt.emojiFlag(country), country.getIso3166Alpha2()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object next : arrayList) {
            if (((CountryItem) next).getName().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    private final TextLabelState provideScreenTitleState(TextLabelStyle textLabelStyle) {
        TextLabelState map = this.textLabelStateMapper.map(textLabelStyle);
        map.getTextId().setValue(Integer.valueOf(R.string.cko_country_picker_screen_title));
        map.getLeadingIcon().setValue(this.imageMapper.map(new ImageStyleToDynamicImageRequest(textLabelStyle.getLeadingIconStyle(), FlowKt.flowOf(Integer.valueOf(R.drawable.cko_ic_cross_close)), FlowKt.flowOf(new CountryPickerViewModel$provideScreenTitleState$1(this)))));
        return map;
    }

    private final InputFieldState provideSearchFieldState(InputFieldStyle inputFieldStyle) {
        InputFieldState map = this.inputFieldStateMapper.map(inputFieldStyle);
        map.getLeadingIcon().setValue(this.imageMapper.map(new ImageStyleToDynamicImageRequest(inputFieldStyle.getLeadingIconStyle(), new CountryPickerViewModel$provideSearchFieldState$$inlined$map$1(SnapshotStateKt.snapshotFlow(new CountryPickerViewModel$provideSearchFieldState$1(this))), new CountryPickerViewModel$provideSearchFieldState$$inlined$map$2(SnapshotStateKt.snapshotFlow(new CountryPickerViewModel$provideSearchFieldState$3(this)), this))));
        map.getTrailingIcon().setValue(this.imageMapper.map(new ImageStyleToDynamicImageRequest(inputFieldStyle.getTrailingIconStyle(), new CountryPickerViewModel$provideSearchFieldState$$inlined$map$3(SnapshotStateKt.snapshotFlow(new CountryPickerViewModel$provideSearchFieldState$5(map))), FlowKt.flowOf(new CountryPickerViewModel$provideSearchFieldState$7(this)))));
        return map;
    }

    @NotNull
    public final MutableState<Boolean> getGoBack() {
        return this.goBack;
    }

    @NotNull
    public final Modifier getScreenModifier() {
        return this.screenModifier;
    }

    @NotNull
    public final TextLabelState getScreenTitleState() {
        return this.screenTitleState;
    }

    @NotNull
    public final TextLabelViewStyle getScreenTitleStyle() {
        return this.screenTitleStyle;
    }

    @NotNull
    public final MutableState<List<CountryItem>> getSearchCountries() {
        return this.searchCountries;
    }

    @NotNull
    public final InputFieldState getSearchFieldState() {
        return this.searchFieldState;
    }

    @NotNull
    public final InputFieldViewStyle getSearchFieldStyle() {
        return this.searchFieldStyle;
    }

    @NotNull
    public final TextLabelViewStyle getSearchItemStyle() {
        return this.searchItemStyle;
    }

    @NotNull
    public final MutableState<Boolean> isSearchActive() {
        return this.isSearchActive;
    }

    @VisibleForTesting
    public final void onClear() {
        if (this.isInputFocused) {
            onSearchChange("");
        } else {
            onReset();
        }
    }

    public final void onCountryChosen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "iso2");
        Address address = this.paymentStateManager.getBillingAddress().getValue().getAddress();
        if (address != null) {
            address.setCountry(Country.Companion.from(str));
        }
        onLeaveScreen$frames_release();
    }

    public final void onFocusChanged(boolean z11) {
        this.isInputFocused = z11;
        if (z11) {
            this.isSearchActive.setValue(Boolean.TRUE);
        }
    }

    @VisibleForTesting
    public final void onLeaveScreen$frames_release() {
        Boolean value;
        Boolean bool;
        MutableStateFlow<Boolean> visitedCountryPicker = this.paymentStateManager.getVisitedCountryPicker();
        do {
            value = visitedCountryPicker.getValue();
            value.booleanValue();
            bool = Boolean.TRUE;
        } while (!visitedCountryPicker.compareAndSet(value, bool));
        this.goBack.setValue(bool);
    }

    @VisibleForTesting
    public final void onReset() {
        this.isSearchActive.setValue(Boolean.FALSE);
        onSearchChange("");
    }

    public final void onSearchChange(@NotNull String str) {
        boolean z11;
        List<CountryItem> list;
        Intrinsics.checkNotNullParameter(str, "text");
        this.searchFieldState.getText().setValue(str);
        MutableState<List<CountryItem>> mutableState = this.searchCountries;
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            list = this.allCountries;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object next : this.allCountries) {
                if (StringsKt__StringsKt.contains((CharSequence) ((CountryItem) next).getName(), (CharSequence) str, true)) {
                    arrayList.add(next);
                }
            }
            list = arrayList;
        }
        mutableState.setValue(list);
    }
}
