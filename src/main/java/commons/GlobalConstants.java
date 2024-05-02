package commons;

import lombok.Getter;

import java.io.File;

@Getter
public class GlobalConstants {

    private  static  GlobalConstants globalInstance;
    private  GlobalConstants(){
    }
    public static synchronized GlobalConstants getGlobalConstant(){
        if (globalInstance == null){
            globalInstance = new GlobalConstants();
        }
        return globalInstance;
    }

    private final String projectPath = System.getProperty("user.dir");
    private final String javaVersion = System.getProperty("jave.version");
    private final long longTime = 30;
   // private final String BROWSER_EXTENSION_FOLDER = GlobalConstants.getGlobalConstant().getProjectPath() + File.separator + "browserExtensions" + File.separator;
}
