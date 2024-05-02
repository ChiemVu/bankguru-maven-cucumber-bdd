package pageUIs;

public class CommonPageUI {
    //menu link
    public static final String DYNAMIC_MANAGER_MENU = "xpath=//ul[@class='menusubnav']//a[text()='%s']";
    public static final String DYNAMIC_TEXTBOX = "xpath=//td[text()='%s']/following-sibling::td/input";
    public static final String DYNAMIC_MESSAGE = "xpath=//p[@class='heading3' and text()='%s']";
    public static final String DYNAMIC_BUTTON_BY_ATTRIBUTE_VALUE = "xpath=//input[@value='%s']";
    public static final String ADDRESS_TEXTAREA = "xpath=//td[text()='%s']/following-sibling::td/textarea";
    }
