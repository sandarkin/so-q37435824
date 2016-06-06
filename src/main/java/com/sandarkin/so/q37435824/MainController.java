package com.sandarkin.so.q37435824;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @RequestMapping("/something/{myParam}")
  @PreAuthorize("@securityService.check(#myParam)")
  public String getSomething(@PathVariable("myParam") Integer myParam) {
    return "Hello! myParam value is " + myParam;
  }

}
