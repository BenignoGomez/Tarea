package py.edu.facitec.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import py.edu.facitec.controller.HomeController;
import py.edu.facitec.dao.ClienteDAO;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class,ClienteDAO.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/static/");
		resolver.setSuffix(".html");
		return resolver;
	}
	
	//Habilita el acceso a recursos estaticos
	//como JavaScrip Css y nuestras propias páginas html
	
	//En el caso de estar en la carpeta WEB-INF no es necesario realizar esta configuración
	//Solo se habilita la página jsp en el controller.
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	@Bean
	public FormattingConversionService mvcConversionService() {
	DefaultFormattingConversionService conversionService =
	new DefaultFormattingConversionService(true);
	DateFormatterRegistrar registrar =
	new DateFormatterRegistrar();
	registrar.setFormatter(new DateFormatter("yyyy-MM-dd")); 
	registrar.registerFormatters(conversionService);
	return conversionService;
	}
	
	
}