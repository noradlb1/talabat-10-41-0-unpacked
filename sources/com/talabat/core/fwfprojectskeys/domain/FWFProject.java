package com.talabat.core.fwfprojectskeys.domain;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/FWFProject;", "", "()V", "fwfProjectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getFwfProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getAllKeys", "", "", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class FWFProject {
    @NotNull
    public abstract List<String> getAllKeys();

    @NotNull
    public abstract FWFProjectName getFwfProjectName();
}
