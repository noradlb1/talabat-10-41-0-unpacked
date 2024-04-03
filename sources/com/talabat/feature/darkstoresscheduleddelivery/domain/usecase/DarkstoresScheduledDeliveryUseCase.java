package com.talabat.feature.darkstoresscheduleddelivery.domain.usecase;

import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliveryDate;
import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliverySlot;
import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliverySlotContent;
import com.talabat.feature.darkstoresscheduleddelivery.domain.repository.DarkstoresScheduledDeliveryRepository;
import io.reactivex.Single;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pm.a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/domain/usecase/DarkstoresScheduledDeliveryUseCase;", "", "repository", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/repository/DarkstoresScheduledDeliveryRepository;", "(Lcom/talabat/feature/darkstoresscheduleddelivery/domain/repository/DarkstoresScheduledDeliveryRepository;)V", "convertToSlots", "", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlotContent;", "deliveryDate", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliveryDate;", "getDeliverySlots", "Lio/reactivex/Single;", "vendorId", "", "getDisplayTime", "", "from", "Ljava/util/Date;", "to", "com_talabat_feature_darkstores-scheduled-delivery_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresScheduledDeliveryUseCase {
    @NotNull
    private final DarkstoresScheduledDeliveryRepository repository;

    @Inject
    public DarkstoresScheduledDeliveryUseCase(@NotNull DarkstoresScheduledDeliveryRepository darkstoresScheduledDeliveryRepository) {
        Intrinsics.checkNotNullParameter(darkstoresScheduledDeliveryRepository, "repository");
        this.repository = darkstoresScheduledDeliveryRepository;
    }

    private final List<DeliverySlotContent> convertToSlots(DeliveryDate deliveryDate) {
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", locale);
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("dd-MM-yyyy", locale);
        try {
            Date parse = simpleDateFormat.parse(deliveryDate.getDate());
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            Intrinsics.checkNotNull(parse);
            String format = simpleDateFormat3.format(parse);
            Iterable<DeliverySlot> slots = deliveryDate.getSlots();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(slots, 10));
            for (DeliverySlot deliverySlot : slots) {
                Date parse2 = simpleDateFormat2.parse(deliverySlot.getFrom());
                Date parse3 = simpleDateFormat2.parse(deliverySlot.getTo());
                Intrinsics.checkNotNull(parse2);
                Intrinsics.checkNotNull(parse3);
                arrayList.add(new DeliverySlotContent(getDisplayTime(parse2, parse3), format + " " + deliverySlot.getFrom(), instance.get(5), instance.get(2)));
            }
            return arrayList;
        } catch (ParseException unused) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getDeliverySlots$lambda-0  reason: not valid java name */
    public static final List m10209getDeliverySlots$lambda0(DarkstoresScheduledDeliveryUseCase darkstoresScheduledDeliveryUseCase, List list) {
        Intrinsics.checkNotNullParameter(darkstoresScheduledDeliveryUseCase, "this$0");
        Intrinsics.checkNotNullParameter(list, "deliveryDates");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, darkstoresScheduledDeliveryUseCase.convertToSlots((DeliveryDate) it.next()));
        }
        return arrayList;
    }

    private final String getDisplayTime(Date date, Date date2) {
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a", locale);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("h:mm", locale);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i11 = instance.get(9);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        if (i11 == instance2.get(9)) {
            String format = simpleDateFormat2.format(date);
            String format2 = simpleDateFormat.format(date2);
            return format + " - " + format2;
        }
        String format3 = simpleDateFormat.format(date);
        String format4 = simpleDateFormat.format(date2);
        return format3 + " - " + format4;
    }

    @NotNull
    public final Single<List<DeliverySlotContent>> getDeliverySlots(int i11) {
        Single<R> map = this.repository.getDeliverySlots(i11).map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "repository.getDeliverySl…convertToSlots)\n        }");
        return map;
    }
}
