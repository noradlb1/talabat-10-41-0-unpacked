package com.talabat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.databinding.FragmentDeliverySlotPickerDialogBinding;
import com.talabat.databinding.ItemDeliverySlotBinding;
import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliverySlotContent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mq.f;
import mq.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0005\u001b\u001c\u001d\u001e\u001fB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0002R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/fragments/DeliverySlotPickerFragment;", "Landroidx/fragment/app/Fragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "deliverySlots", "", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlotContent;", "selectedDeliverySlot", "deliverySlotPickerFragmentListener", "Lcom/talabat/fragments/DeliverySlotPickerFragment$DeliverySlotPickerFragmentListener;", "deliverySlotPickerFragmentCloseListener", "Lcom/talabat/fragments/DeliverySlotPickerFragment$DeliverySlotPickerFragmentCloseListener;", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;Ljava/util/List;Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlotContent;Lcom/talabat/fragments/DeliverySlotPickerFragment$DeliverySlotPickerFragmentListener;Lcom/talabat/fragments/DeliverySlotPickerFragment$DeliverySlotPickerFragmentCloseListener;)V", "binding", "Lcom/talabat/databinding/FragmentDeliverySlotPickerDialogBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "refreshButtonState", "Companion", "DeliverySlotAdapter", "DeliverySlotPickerFragmentCloseListener", "DeliverySlotPickerFragmentListener", "DeliverySlotViewHolder", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliverySlotPickerFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    private FragmentDeliverySlotPickerDialogBinding binding;
    @NotNull
    private final DeliverySlotPickerFragmentCloseListener deliverySlotPickerFragmentCloseListener;
    @NotNull
    private final DeliverySlotPickerFragmentListener deliverySlotPickerFragmentListener;
    @NotNull
    private final List<DeliverySlotContent> deliverySlots;
    @NotNull
    private final DSBottomSheet dsBottomSheet;
    /* access modifiers changed from: private */
    @Nullable
    public DeliverySlotContent selectedDeliverySlot;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/talabat/fragments/DeliverySlotPickerFragment$Companion;", "", "()V", "newInstance", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "deliverySlots", "", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlotContent;", "selectedDeliverySlot", "deliverySlotPickerFragmentListener", "Lcom/talabat/fragments/DeliverySlotPickerFragment$DeliverySlotPickerFragmentListener;", "deliverySlotPickerFragmentCloseListener", "Lcom/talabat/fragments/DeliverySlotPickerFragment$DeliverySlotPickerFragmentCloseListener;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DSBottomSheet newInstance(@NotNull List<DeliverySlotContent> list, @Nullable DeliverySlotContent deliverySlotContent, @NotNull DeliverySlotPickerFragmentListener deliverySlotPickerFragmentListener, @NotNull DeliverySlotPickerFragmentCloseListener deliverySlotPickerFragmentCloseListener) {
            Intrinsics.checkNotNullParameter(list, "deliverySlots");
            Intrinsics.checkNotNullParameter(deliverySlotPickerFragmentListener, "deliverySlotPickerFragmentListener");
            Intrinsics.checkNotNullParameter(deliverySlotPickerFragmentCloseListener, "deliverySlotPickerFragmentCloseListener");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(new DeliverySlotPickerFragment(dSBottomSheet, list, deliverySlotContent, deliverySlotPickerFragmentListener, deliverySlotPickerFragmentCloseListener));
            return dSBottomSheet;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B@\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\r2\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/fragments/DeliverySlotPickerFragment$DeliverySlotAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/fragments/DeliverySlotPickerFragment$DeliverySlotViewHolder;", "Lcom/talabat/fragments/DeliverySlotPickerFragment;", "slots", "", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlotContent;", "currentSelectedSlot", "onSlotSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "deliverySlot", "", "(Lcom/talabat/fragments/DeliverySlotPickerFragment;Ljava/util/List;Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlotContent;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class DeliverySlotAdapter extends RecyclerView.Adapter<DeliverySlotViewHolder> {
        /* access modifiers changed from: private */
        @Nullable
        public DeliverySlotContent currentSelectedSlot;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DeliverySlotPickerFragment f59796i;
        /* access modifiers changed from: private */
        @NotNull
        public final Function1<DeliverySlotContent, Unit> onSlotSelected;
        @NotNull
        private final List<DeliverySlotContent> slots;

        public DeliverySlotAdapter(@NotNull DeliverySlotPickerFragment deliverySlotPickerFragment, @Nullable List<DeliverySlotContent> list, @NotNull DeliverySlotContent deliverySlotContent, Function1<? super DeliverySlotContent, Unit> function1) {
            Intrinsics.checkNotNullParameter(list, "slots");
            Intrinsics.checkNotNullParameter(function1, "onSlotSelected");
            this.f59796i = deliverySlotPickerFragment;
            this.slots = list;
            this.currentSelectedSlot = deliverySlotContent;
            this.onSlotSelected = function1;
        }

        public int getItemCount() {
            return this.slots.size();
        }

        public void onBindViewHolder(@NotNull DeliverySlotViewHolder deliverySlotViewHolder, int i11) {
            Intrinsics.checkNotNullParameter(deliverySlotViewHolder, "holder");
            DeliverySlotContent deliverySlotContent = this.slots.get(i11);
            boolean areEqual = Intrinsics.areEqual((Object) deliverySlotContent, (Object) this.currentSelectedSlot);
            boolean z11 = true;
            if (i11 != this.slots.size() - 1) {
                z11 = false;
            }
            deliverySlotViewHolder.bind(deliverySlotContent, areEqual, z11);
        }

        @NotNull
        public DeliverySlotViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            DeliverySlotPickerFragment deliverySlotPickerFragment = this.f59796i;
            ItemDeliverySlotBinding inflate = ItemDeliverySlotBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
            return new DeliverySlotViewHolder(deliverySlotPickerFragment, inflate, new DeliverySlotPickerFragment$DeliverySlotAdapter$onCreateViewHolder$1(this));
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/fragments/DeliverySlotPickerFragment$DeliverySlotPickerFragmentCloseListener;", "", "onClosed", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface DeliverySlotPickerFragmentCloseListener {
        void onClosed();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/fragments/DeliverySlotPickerFragment$DeliverySlotPickerFragmentListener;", "", "onDeliverySlotSelected", "", "slot", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlotContent;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface DeliverySlotPickerFragmentListener {
        void onDeliverySlotSelected(@NotNull DeliverySlotContent deliverySlotContent);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/fragments/DeliverySlotPickerFragment$DeliverySlotViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/databinding/ItemDeliverySlotBinding;", "onItemClick", "Lkotlin/Function1;", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlotContent;", "Lkotlin/ParameterName;", "name", "deliverySlot", "", "(Lcom/talabat/fragments/DeliverySlotPickerFragment;Lcom/talabat/databinding/ItemDeliverySlotBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "isSelected", "", "isLast", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class DeliverySlotViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final ItemDeliverySlotBinding binding;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DeliverySlotPickerFragment f59798h;
        @NotNull
        private final Function1<DeliverySlotContent, Unit> onItemClick;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeliverySlotViewHolder(@NotNull DeliverySlotPickerFragment deliverySlotPickerFragment, @NotNull ItemDeliverySlotBinding itemDeliverySlotBinding, Function1<? super DeliverySlotContent, Unit> function1) {
            super(itemDeliverySlotBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemDeliverySlotBinding, "binding");
            Intrinsics.checkNotNullParameter(function1, "onItemClick");
            this.f59798h = deliverySlotPickerFragment;
            this.binding = itemDeliverySlotBinding;
            this.onItemClick = function1;
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m10486bind$lambda0(DeliverySlotViewHolder deliverySlotViewHolder, DeliverySlotContent deliverySlotContent, View view) {
            Intrinsics.checkNotNullParameter(deliverySlotViewHolder, "this$0");
            Intrinsics.checkNotNullParameter(deliverySlotContent, "$deliverySlot");
            deliverySlotViewHolder.onItemClick.invoke(deliverySlotContent);
        }

        public final void bind(@NotNull DeliverySlotContent deliverySlotContent, boolean z11, boolean z12) {
            int i11;
            Intrinsics.checkNotNullParameter(deliverySlotContent, "deliverySlot");
            AppCompatTextView appCompatTextView = this.binding.tvSlotTile;
            String string = this.f59798h.getString(R.string.f54876am);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.localization.R.string.am)");
            String string2 = this.f59798h.getString(R.string.f54884pm);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(com.talabat.localization.R.string.pm)");
            appCompatTextView.setText(deliverySlotContent.getLocalisedDisplayTime(string, string2));
            this.binding.rbDeliverySlot.setRadioButtonChecked(z11);
            View view = this.binding.divider;
            if (z12) {
                i11 = 8;
            } else {
                i11 = 0;
            }
            view.setVisibility(i11);
            this.binding.getRoot().setOnClickListener(new a(this, deliverySlotContent));
        }
    }

    public DeliverySlotPickerFragment(@NotNull DSBottomSheet dSBottomSheet, @NotNull List<DeliverySlotContent> list, @Nullable DeliverySlotContent deliverySlotContent, @NotNull DeliverySlotPickerFragmentListener deliverySlotPickerFragmentListener2, @NotNull DeliverySlotPickerFragmentCloseListener deliverySlotPickerFragmentCloseListener2) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        Intrinsics.checkNotNullParameter(list, "deliverySlots");
        Intrinsics.checkNotNullParameter(deliverySlotPickerFragmentListener2, "deliverySlotPickerFragmentListener");
        Intrinsics.checkNotNullParameter(deliverySlotPickerFragmentCloseListener2, "deliverySlotPickerFragmentCloseListener");
        this.dsBottomSheet = dSBottomSheet;
        this.deliverySlots = list;
        this.selectedDeliverySlot = deliverySlotContent;
        this.deliverySlotPickerFragmentListener = deliverySlotPickerFragmentListener2;
        this.deliverySlotPickerFragmentCloseListener = deliverySlotPickerFragmentCloseListener2;
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m10484onViewCreated$lambda0(DeliverySlotPickerFragment deliverySlotPickerFragment, View view) {
        Intrinsics.checkNotNullParameter(deliverySlotPickerFragment, "this$0");
        deliverySlotPickerFragment.deliverySlotPickerFragmentCloseListener.onClosed();
        deliverySlotPickerFragment.dsBottomSheet.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m10485onViewCreated$lambda3(DeliverySlotPickerFragment deliverySlotPickerFragment, View view) {
        Intrinsics.checkNotNullParameter(deliverySlotPickerFragment, "this$0");
        deliverySlotPickerFragment.dsBottomSheet.dismiss();
        DeliverySlotContent deliverySlotContent = deliverySlotPickerFragment.selectedDeliverySlot;
        if (deliverySlotContent != null) {
            deliverySlotPickerFragment.deliverySlotPickerFragmentListener.onDeliverySlotSelected(deliverySlotContent);
        }
    }

    /* access modifiers changed from: private */
    public final void refreshButtonState() {
        FragmentDeliverySlotPickerDialogBinding fragmentDeliverySlotPickerDialogBinding = this.binding;
        if (fragmentDeliverySlotPickerDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeliverySlotPickerDialogBinding = null;
        }
        fragmentDeliverySlotPickerDialogBinding.btnConfirm.setEnabled(this.selectedDeliverySlot != null);
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
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentDeliverySlotPickerDialogBinding fragmentDeliverySlotPickerDialogBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "DeliverySlotPickerFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "DeliverySlotPickerFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentDeliverySlotPickerDialogBinding inflate = FragmentDeliverySlotPickerDialogBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentDeliverySlotPickerDialogBinding = inflate;
        }
        LinearLayout root = fragmentDeliverySlotPickerDialogBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        TraceMachine.exitMethod();
        return root;
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
        refreshButtonState();
        FragmentDeliverySlotPickerDialogBinding fragmentDeliverySlotPickerDialogBinding = this.binding;
        FragmentDeliverySlotPickerDialogBinding fragmentDeliverySlotPickerDialogBinding2 = null;
        if (fragmentDeliverySlotPickerDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeliverySlotPickerDialogBinding = null;
        }
        fragmentDeliverySlotPickerDialogBinding.ivClose.setOnClickListener(new f(this));
        FragmentDeliverySlotPickerDialogBinding fragmentDeliverySlotPickerDialogBinding3 = this.binding;
        if (fragmentDeliverySlotPickerDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeliverySlotPickerDialogBinding3 = null;
        }
        RecyclerView recyclerView = fragmentDeliverySlotPickerDialogBinding3.rvDeliverySlots;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new DeliverySlotAdapter(this, this.deliverySlots, this.selectedDeliverySlot, new DeliverySlotPickerFragment$onViewCreated$2$1(this)));
        FragmentDeliverySlotPickerDialogBinding fragmentDeliverySlotPickerDialogBinding4 = this.binding;
        if (fragmentDeliverySlotPickerDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentDeliverySlotPickerDialogBinding2 = fragmentDeliverySlotPickerDialogBinding4;
        }
        fragmentDeliverySlotPickerDialogBinding2.btnConfirm.setOnClickListener(new g(this));
    }
}
