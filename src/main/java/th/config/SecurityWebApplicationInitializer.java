package th.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    /**
     * Overrided because Spring Security has its own filters that are applied before anything else, and in order to provide correct encoding, my filter has to be the first.
     *
     * @param servletContext context of servlet.
     */
    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        super.beforeSpringSecurityFilterChain(servletContext);

        FilterRegistration.Dynamic characterEncodingFilter;
        characterEncodingFilter = servletContext.addFilter("encodingFilter",
                new CharacterEncodingFilter());
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
        characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
    }

}
