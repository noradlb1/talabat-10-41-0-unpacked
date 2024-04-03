package buisnessmodels.sponsors;

public interface Sponsored {
    public static final long DEFAULT_MAX_SPONSORED_RANK = 9999;

    @AvailabilityStatus
    int getAvailabilityStatus();

    long getSponsoredRank();
}
