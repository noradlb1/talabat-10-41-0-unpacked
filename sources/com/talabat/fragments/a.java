package com.talabat.fragments;

import android.view.View;
import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliverySlotContent;
import com.talabat.fragments.DeliverySlotPickerFragment;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeliverySlotPickerFragment.DeliverySlotViewHolder f59827b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DeliverySlotContent f59828c;

    public /* synthetic */ a(DeliverySlotPickerFragment.DeliverySlotViewHolder deliverySlotViewHolder, DeliverySlotContent deliverySlotContent) {
        this.f59827b = deliverySlotViewHolder;
        this.f59828c = deliverySlotContent;
    }

    public final void onClick(View view) {
        DeliverySlotPickerFragment.DeliverySlotViewHolder.m10486bind$lambda0(this.f59827b, this.f59828c, view);
    }
}
