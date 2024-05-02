package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
//
@Sources({"file:environmentConfig/${env}.properties"})
public interface Environment extends  Config{
    @Key("App.UserUrl")
    String appUserUrl();

    @Key("App.AdminUrl")
    String appAdminUrl();

    @Key("App.EmailID")
    String appEmailID();

    @Key("App.UserID")
    String appUserID();

    @Key("App.Password")
    String appPassword();
}
