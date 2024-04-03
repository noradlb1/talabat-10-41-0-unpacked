package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Date;

public final class ReservationBuilder extends IndexableBuilder<ReservationBuilder> {
    public ReservationBuilder() {
        super("Reservation");
    }

    @NonNull
    public ReservationBuilder setPartySize(@NonNull long j11) {
        put("partySize", j11);
        return this;
    }

    @NonNull
    public ReservationBuilder setReservationFor(@NonNull LocalBusinessBuilder localBusinessBuilder) {
        put("reservationFor", (S[]) new LocalBusinessBuilder[]{localBusinessBuilder});
        return this;
    }

    @NonNull
    public ReservationBuilder setStartDate(@NonNull Date date) {
        Preconditions.checkNotNull(date);
        put("startDate", date.getTime());
        return this;
    }
}
