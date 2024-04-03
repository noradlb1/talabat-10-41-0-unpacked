package JsonModels;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.domain.address.Address;
import datamodels.CustomerInfo;

public class CustomerJson {
    public Address[] addresses;
    public CustomerInfo customer;
    public TokenisationCreditCard[] tokens;
}
