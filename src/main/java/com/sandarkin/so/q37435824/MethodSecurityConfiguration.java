package com.sandarkin.so.q37435824;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.parameters.AnnotationParameterNameDiscoverer;
import org.springframework.web.bind.annotation.PathVariable;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

  @Autowired
  private ApplicationContext context;

  @Override
  protected MethodSecurityExpressionHandler createExpressionHandler() {
    DefaultMethodSecurityExpressionHandler result = new DefaultMethodSecurityExpressionHandler();
    result.setApplicationContext(this.context);
    result.setParameterNameDiscoverer(new AnnotationParameterNameDiscoverer(PathVariable.class.getName()));
    return result;
  }

}
