package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatSpinner;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarButton;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;

public final class AddAddressNicknameAtBottomBinding implements ViewBinding {
    @NonNull
    public final LinearLayout addAddressFormParent;
    @NonNull
    public final LinearLayout addAreaView;
    @NonNull
    public final LinearLayout addCityView;
    @NonNull
    public final LinearLayout additionalDirectionsView;
    @NonNull
    public final FrameLayout addressFormContainer;
    @NonNull
    public final MaterialEditText addressNameOptionalField;
    @NonNull
    public final TalabatTextView addressNameOptionalFieldHint;
    @NonNull
    public final TalabatSpinner addressTypeSpinner;
    @NonNull
    public final LinearLayout addressTypeSpinnerView;
    @NonNull
    public final LinearLayout autofillAddressMainLayout;
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final MaterialEditText countryCodePhone;
    @NonNull
    public final TalabatToolBarButton deleteAddress;
    @NonNull
    public final MaterialEditText directionsEditText;
    @NonNull
    public final MaterialEditText etAddressType;
    @NonNull
    public final MaterialEditText etArea;
    @NonNull
    public final MaterialEditText etCity;
    @NonNull
    public final TalabatTextView field10Text;
    @NonNull
    public final LinearLayout field1View;
    @NonNull
    public final MaterialEditText field2;
    @NonNull
    public final TalabatTextView field2Text;
    @NonNull
    public final LinearLayout field2View;
    @NonNull
    public final MaterialEditText field3;
    @NonNull
    public final TalabatTextView field3Text;
    @NonNull
    public final LinearLayout field3View;
    @NonNull
    public final MaterialEditText field4;
    @NonNull
    public final TalabatTextView field4Text;
    @NonNull
    public final LinearLayout field4View;
    @NonNull
    public final MaterialEditText field5;
    @NonNull
    public final TalabatTextView field5Text;
    @NonNull
    public final LinearLayout field5View;
    @NonNull
    public final MaterialEditText field6;
    @NonNull
    public final TalabatTextView field6Text;
    @NonNull
    public final LinearLayout field6View;
    @NonNull
    public final MaterialEditText field7;
    @NonNull
    public final TalabatTextView field7Text;
    @NonNull
    public final LinearLayout field7View;
    @NonNull
    public final TalabatTextView field8Text;
    @NonNull
    public final TalabatTextView field9Text;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final RelativeLayout gemRemainderView;
    @NonNull
    public final TalabatTextView gemRemainderViewTxt;
    @NonNull
    public final LinearLayout gpsView;
    @NonNull
    public final MaterialEditText hiddenPhoneField;
    @NonNull
    public final LinearLayout mobileView;
    @NonNull
    public final RelativeLayout parentView;
    @NonNull
    public final MaterialEditText phoneEditText;
    @NonNull
    public final LinearLayout phoneView;
    @NonNull
    public final TalabatStrokeButton refineBtn;
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final TalabatFillButton saveAddressBtn;
    @NonNull
    public final TalabatButton saveAddressToolbar;
    @NonNull
    public final Button showcaseDummyBtn;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private AddAddressNicknameAtBottomBinding(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull FrameLayout frameLayout2, @NonNull MaterialEditText materialEditText, @NonNull TalabatTextView talabatTextView, @NonNull TalabatSpinner talabatSpinner, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull MaterialEditText materialEditText2, @NonNull TalabatToolBarButton talabatToolBarButton, @NonNull MaterialEditText materialEditText3, @NonNull MaterialEditText materialEditText4, @NonNull MaterialEditText materialEditText5, @NonNull MaterialEditText materialEditText6, @NonNull TalabatTextView talabatTextView2, @NonNull LinearLayout linearLayout7, @NonNull MaterialEditText materialEditText7, @NonNull TalabatTextView talabatTextView3, @NonNull LinearLayout linearLayout8, @NonNull MaterialEditText materialEditText8, @NonNull TalabatTextView talabatTextView4, @NonNull LinearLayout linearLayout9, @NonNull MaterialEditText materialEditText9, @NonNull TalabatTextView talabatTextView5, @NonNull LinearLayout linearLayout10, @NonNull MaterialEditText materialEditText10, @NonNull TalabatTextView talabatTextView6, @NonNull LinearLayout linearLayout11, @NonNull MaterialEditText materialEditText11, @NonNull TalabatTextView talabatTextView7, @NonNull LinearLayout linearLayout12, @NonNull MaterialEditText materialEditText12, @NonNull TalabatTextView talabatTextView8, @NonNull LinearLayout linearLayout13, @NonNull TalabatTextView talabatTextView9, @NonNull TalabatTextView talabatTextView10, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView11, @NonNull LinearLayout linearLayout14, @NonNull MaterialEditText materialEditText13, @NonNull LinearLayout linearLayout15, @NonNull RelativeLayout relativeLayout3, @NonNull MaterialEditText materialEditText14, @NonNull LinearLayout linearLayout16, @NonNull TalabatStrokeButton talabatStrokeButton, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatButton talabatButton, @NonNull Button button, @NonNull RelativeLayout relativeLayout4, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = frameLayout;
        this.addAddressFormParent = linearLayout;
        this.addAreaView = linearLayout2;
        this.addCityView = linearLayout3;
        this.additionalDirectionsView = linearLayout4;
        this.addressFormContainer = frameLayout2;
        this.addressNameOptionalField = materialEditText;
        this.addressNameOptionalFieldHint = talabatTextView;
        this.addressTypeSpinner = talabatSpinner;
        this.addressTypeSpinnerView = linearLayout5;
        this.autofillAddressMainLayout = linearLayout6;
        this.back = talabatToolBarImageButton;
        this.countryCodePhone = materialEditText2;
        this.deleteAddress = talabatToolBarButton;
        this.directionsEditText = materialEditText3;
        this.etAddressType = materialEditText4;
        this.etArea = materialEditText5;
        this.etCity = materialEditText6;
        this.field10Text = talabatTextView2;
        this.field1View = linearLayout7;
        this.field2 = materialEditText7;
        this.field2Text = talabatTextView3;
        this.field2View = linearLayout8;
        this.field3 = materialEditText8;
        this.field3Text = talabatTextView4;
        this.field3View = linearLayout9;
        this.field4 = materialEditText9;
        this.field4Text = talabatTextView5;
        this.field4View = linearLayout10;
        this.field5 = materialEditText10;
        this.field5Text = talabatTextView6;
        this.field5View = linearLayout11;
        this.field6 = materialEditText11;
        this.field6Text = talabatTextView7;
        this.field6View = linearLayout12;
        this.field7 = materialEditText12;
        this.field7Text = talabatTextView8;
        this.field7View = linearLayout13;
        this.field8Text = talabatTextView9;
        this.field9Text = talabatTextView10;
        this.gemFooterView = relativeLayout;
        this.gemRemainderView = relativeLayout2;
        this.gemRemainderViewTxt = talabatTextView11;
        this.gpsView = linearLayout14;
        this.hiddenPhoneField = materialEditText13;
        this.mobileView = linearLayout15;
        this.parentView = relativeLayout3;
        this.phoneEditText = materialEditText14;
        this.phoneView = linearLayout16;
        this.refineBtn = talabatStrokeButton;
        this.saveAddressBtn = talabatFillButton;
        this.saveAddressToolbar = talabatButton;
        this.showcaseDummyBtn = button;
        this.talabatToolbar = relativeLayout4;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static AddAddressNicknameAtBottomBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.add_address_form_parent;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.add_address_form_parent);
        if (linearLayout != null) {
            i11 = R.id.add_areaView;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.add_areaView);
            if (linearLayout2 != null) {
                i11 = R.id.add_cityView;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.add_cityView);
                if (linearLayout3 != null) {
                    i11 = R.id.additional_directions_view;
                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.additional_directions_view);
                    if (linearLayout4 != null) {
                        FrameLayout frameLayout = (FrameLayout) view2;
                        i11 = R.id.address_name_optional_field;
                        MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.address_name_optional_field);
                        if (materialEditText != null) {
                            i11 = R.id.address_name_optional_field_hint;
                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.address_name_optional_field_hint);
                            if (talabatTextView != null) {
                                i11 = R.id.address_type_spinner;
                                TalabatSpinner talabatSpinner = (TalabatSpinner) ViewBindings.findChildViewById(view2, R.id.address_type_spinner);
                                if (talabatSpinner != null) {
                                    i11 = R.id.address_type_spinner_view;
                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.address_type_spinner_view);
                                    if (linearLayout5 != null) {
                                        i11 = R.id.autofill_address_mainLayout;
                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.autofill_address_mainLayout);
                                        if (linearLayout6 != null) {
                                            i11 = R.id.back;
                                            TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
                                            if (talabatToolBarImageButton != null) {
                                                i11 = R.id.country_code_phone;
                                                MaterialEditText materialEditText2 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.country_code_phone);
                                                if (materialEditText2 != null) {
                                                    i11 = R.id.delete_address;
                                                    TalabatToolBarButton talabatToolBarButton = (TalabatToolBarButton) ViewBindings.findChildViewById(view2, R.id.delete_address);
                                                    if (talabatToolBarButton != null) {
                                                        i11 = R.id.directionsEditText;
                                                        MaterialEditText materialEditText3 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.directionsEditText);
                                                        if (materialEditText3 != null) {
                                                            i11 = R.id.etAddressType;
                                                            MaterialEditText materialEditText4 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.etAddressType);
                                                            if (materialEditText4 != null) {
                                                                i11 = R.id.etArea;
                                                                MaterialEditText materialEditText5 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.etArea);
                                                                if (materialEditText5 != null) {
                                                                    i11 = R.id.etCity;
                                                                    MaterialEditText materialEditText6 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.etCity);
                                                                    if (materialEditText6 != null) {
                                                                        i11 = R.id.field10_text;
                                                                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.field10_text);
                                                                        if (talabatTextView2 != null) {
                                                                            i11 = R.id.field1_view;
                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.field1_view);
                                                                            if (linearLayout7 != null) {
                                                                                i11 = R.id.field2;
                                                                                MaterialEditText materialEditText7 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.field2);
                                                                                if (materialEditText7 != null) {
                                                                                    i11 = R.id.field2_text;
                                                                                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.field2_text);
                                                                                    if (talabatTextView3 != null) {
                                                                                        i11 = R.id.field2_view;
                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.field2_view);
                                                                                        if (linearLayout8 != null) {
                                                                                            i11 = R.id.field3;
                                                                                            MaterialEditText materialEditText8 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.field3);
                                                                                            if (materialEditText8 != null) {
                                                                                                i11 = R.id.field3_text;
                                                                                                TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.field3_text);
                                                                                                if (talabatTextView4 != null) {
                                                                                                    i11 = R.id.field3_view;
                                                                                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.field3_view);
                                                                                                    if (linearLayout9 != null) {
                                                                                                        i11 = R.id.field4;
                                                                                                        MaterialEditText materialEditText9 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.field4);
                                                                                                        if (materialEditText9 != null) {
                                                                                                            i11 = R.id.field4_text;
                                                                                                            TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.field4_text);
                                                                                                            if (talabatTextView5 != null) {
                                                                                                                i11 = R.id.field4_view;
                                                                                                                LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.field4_view);
                                                                                                                if (linearLayout10 != null) {
                                                                                                                    i11 = R.id.field5;
                                                                                                                    MaterialEditText materialEditText10 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.field5);
                                                                                                                    if (materialEditText10 != null) {
                                                                                                                        i11 = R.id.field5_text;
                                                                                                                        TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.field5_text);
                                                                                                                        if (talabatTextView6 != null) {
                                                                                                                            i11 = R.id.field5_view;
                                                                                                                            LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.field5_view);
                                                                                                                            if (linearLayout11 != null) {
                                                                                                                                i11 = R.id.field6;
                                                                                                                                MaterialEditText materialEditText11 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.field6);
                                                                                                                                if (materialEditText11 != null) {
                                                                                                                                    i11 = R.id.field6_text;
                                                                                                                                    TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.field6_text);
                                                                                                                                    if (talabatTextView7 != null) {
                                                                                                                                        i11 = R.id.field6_view;
                                                                                                                                        LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.field6_view);
                                                                                                                                        if (linearLayout12 != null) {
                                                                                                                                            i11 = R.id.field7;
                                                                                                                                            MaterialEditText materialEditText12 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.field7);
                                                                                                                                            if (materialEditText12 != null) {
                                                                                                                                                i11 = R.id.field7_text;
                                                                                                                                                TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.field7_text);
                                                                                                                                                if (talabatTextView8 != null) {
                                                                                                                                                    i11 = R.id.field7_view;
                                                                                                                                                    LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.field7_view);
                                                                                                                                                    if (linearLayout13 != null) {
                                                                                                                                                        i11 = R.id.field8_text;
                                                                                                                                                        TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.field8_text);
                                                                                                                                                        if (talabatTextView9 != null) {
                                                                                                                                                            i11 = R.id.field9_text;
                                                                                                                                                            TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.field9_text);
                                                                                                                                                            if (talabatTextView10 != null) {
                                                                                                                                                                i11 = R.id.gem_footer_view;
                                                                                                                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view);
                                                                                                                                                                if (relativeLayout != null) {
                                                                                                                                                                    i11 = R.id.gem_remainder_view;
                                                                                                                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_remainder_view);
                                                                                                                                                                    if (relativeLayout2 != null) {
                                                                                                                                                                        i11 = R.id.gem_remainder_view_txt;
                                                                                                                                                                        TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.gem_remainder_view_txt);
                                                                                                                                                                        if (talabatTextView11 != null) {
                                                                                                                                                                            i11 = R.id.gps_view;
                                                                                                                                                                            LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.gps_view);
                                                                                                                                                                            if (linearLayout14 != null) {
                                                                                                                                                                                i11 = R.id.hidden_phone_field;
                                                                                                                                                                                MaterialEditText materialEditText13 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.hidden_phone_field);
                                                                                                                                                                                if (materialEditText13 != null) {
                                                                                                                                                                                    i11 = R.id.mobile_view;
                                                                                                                                                                                    LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.mobile_view);
                                                                                                                                                                                    if (linearLayout15 != null) {
                                                                                                                                                                                        i11 = R.id.parent_view;
                                                                                                                                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.parent_view);
                                                                                                                                                                                        if (relativeLayout3 != null) {
                                                                                                                                                                                            i11 = R.id.phoneEditText;
                                                                                                                                                                                            MaterialEditText materialEditText14 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.phoneEditText);
                                                                                                                                                                                            if (materialEditText14 != null) {
                                                                                                                                                                                                i11 = R.id.phone_view;
                                                                                                                                                                                                LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.phone_view);
                                                                                                                                                                                                if (linearLayout16 != null) {
                                                                                                                                                                                                    i11 = R.id.refine_btn;
                                                                                                                                                                                                    TalabatStrokeButton talabatStrokeButton = (TalabatStrokeButton) ViewBindings.findChildViewById(view2, R.id.refine_btn);
                                                                                                                                                                                                    if (talabatStrokeButton != null) {
                                                                                                                                                                                                        i11 = R.id.save_address_btn;
                                                                                                                                                                                                        TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.save_address_btn);
                                                                                                                                                                                                        if (talabatFillButton != null) {
                                                                                                                                                                                                            i11 = R.id.save_address_toolbar;
                                                                                                                                                                                                            TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.save_address_toolbar);
                                                                                                                                                                                                            if (talabatButton != null) {
                                                                                                                                                                                                                i11 = R.id.showcase_dummy_btn;
                                                                                                                                                                                                                Button button = (Button) ViewBindings.findChildViewById(view2, R.id.showcase_dummy_btn);
                                                                                                                                                                                                                if (button != null) {
                                                                                                                                                                                                                    i11 = R.id.talabat_toolbar;
                                                                                                                                                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                                                                                                                                                                                                    if (relativeLayout4 != null) {
                                                                                                                                                                                                                        i11 = R.id.title;
                                                                                                                                                                                                                        TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                                                                                                                                                        if (talabatToolBarTextView != null) {
                                                                                                                                                                                                                            i11 = R.id.toolbar;
                                                                                                                                                                                                                            TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                                                                                                                                            if (talabatToolBar != null) {
                                                                                                                                                                                                                                return new AddAddressNicknameAtBottomBinding(frameLayout, linearLayout, linearLayout2, linearLayout3, linearLayout4, frameLayout, materialEditText, talabatTextView, talabatSpinner, linearLayout5, linearLayout6, talabatToolBarImageButton, materialEditText2, talabatToolBarButton, materialEditText3, materialEditText4, materialEditText5, materialEditText6, talabatTextView2, linearLayout7, materialEditText7, talabatTextView3, linearLayout8, materialEditText8, talabatTextView4, linearLayout9, materialEditText9, talabatTextView5, linearLayout10, materialEditText10, talabatTextView6, linearLayout11, materialEditText11, talabatTextView7, linearLayout12, materialEditText12, talabatTextView8, linearLayout13, talabatTextView9, talabatTextView10, relativeLayout, relativeLayout2, talabatTextView11, linearLayout14, materialEditText13, linearLayout15, relativeLayout3, materialEditText14, linearLayout16, talabatStrokeButton, talabatFillButton, talabatButton, button, relativeLayout4, talabatToolBarTextView, talabatToolBar);
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static AddAddressNicknameAtBottomBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static AddAddressNicknameAtBottomBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.add_address_nickname_at_bottom, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
