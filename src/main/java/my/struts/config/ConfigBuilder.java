package my.struts.config;

import my.struts.presentation.controller.DisplayEarthquakeController;
import my.struts.presentation.controller.LoginSubmitController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.NonNull;

/**
 * configurationです。
 */
public class ConfigBuilder {

    private static AnnotationConfigApplicationContext appConfigContext
            = new AnnotationConfigApplicationContext(AppConfig.class);

    private static AnnotationConfigApplicationContext modelMapperConfigContext
            = new AnnotationConfigApplicationContext(ModelMapperConfig.class);

    @NonNull
    public static LoginSubmitController getLoginSubmitController() {
        return appConfigContext.getBean(LoginSubmitController.class);
    }

    @NonNull
    public static DisplayEarthquakeController getDisplayEarthquakeController() {
        return appConfigContext.getBean(DisplayEarthquakeController.class);
    }
}