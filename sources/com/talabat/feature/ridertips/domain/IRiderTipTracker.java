package com.talabat.feature.ridertips.domain;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J+\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\fJ+\u0010\r\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\nJ+\u0010\u000e\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\nJ+\u0010\u000f\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\nJ+\u0010\u0010\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/ridertips/domain/IRiderTipTracker;", "", "disclaimerClicked", "", "onRiderTipClicked", "riderTipValue", "", "tipClickOrigin", "", "screenName", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)V", "onRiderTipLoaded", "(Ljava/lang/Double;Ljava/lang/String;)V", "onRiderTipOpened", "onRiderTipRemoved", "onRiderTipSaved", "onRiderTipUnsaved", "com_talabat_feature_ridertips_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IRiderTipTracker {
    void disclaimerClicked();

    void onRiderTipClicked(@Nullable Double d11, @Nullable String str, @Nullable String str2);

    void onRiderTipLoaded(@Nullable Double d11, @Nullable String str);

    void onRiderTipOpened(@Nullable Double d11, @Nullable String str, @Nullable String str2);

    void onRiderTipRemoved(@Nullable Double d11, @Nullable String str, @Nullable String str2);

    void onRiderTipSaved(@Nullable Double d11, @Nullable String str, @Nullable String str2);

    void onRiderTipUnsaved(@Nullable Double d11, @Nullable String str, @Nullable String str2);
}
