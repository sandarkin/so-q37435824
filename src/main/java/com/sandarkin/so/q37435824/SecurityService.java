package com.sandarkin.so.q37435824;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SecurityService {

  public boolean check(Integer param) {
    log.info("myParam value from PathVariable equals " + param);
    return param == 1;
  }

}
