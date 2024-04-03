package com.talabat.feature.pharmacy.presentation;

import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/talabat/feature/pharmacy/presentation/PrescriptionDestinations;", "", "route", "", "entryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;)V", "getEntryPoint", "()Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getRoute", "()Ljava/lang/String;", "MAIN", "DETAILS", "com_talabat_feature_pharmacy_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum PrescriptionDestinations {
    MAIN("/pharmacy-prescription", TalabatFlutterEntryPoints.PHARMACY_PRESCRIPTION_MAIN),
    DETAILS("/pharmacy-order-details", TalabatFlutterEntryPoints.PHARMACY_PRESCRIPTION_DETAILS);
    
    @NotNull
    private final TalabatFlutterEntryPoints entryPoint;
    @NotNull
    private final String route;

    private PrescriptionDestinations(String str, TalabatFlutterEntryPoints talabatFlutterEntryPoints) {
        this.route = str;
        this.entryPoint = talabatFlutterEntryPoints;
    }

    @NotNull
    public final TalabatFlutterEntryPoints getEntryPoint() {
        return this.entryPoint;
    }

    @NotNull
    public final String getRoute() {
        return this.route;
    }
}
