package JsonModels;

import datamodels.Country;
import datamodels.Token;

public class LandingResponse {
    public Country[] countries;
    public boolean isCancelable;
    public boolean redirectApplication;
    public Token token;
}
