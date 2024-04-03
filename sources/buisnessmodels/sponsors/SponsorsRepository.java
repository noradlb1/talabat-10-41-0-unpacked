package buisnessmodels.sponsors;

public interface SponsorsRepository {
    long getMaxSponsoredRank();

    int getMaxSponsoredSlots();

    boolean isSponsoredSortingActive();
}
