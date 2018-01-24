package com.moelholm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreeterService {
public static final Logger log = LoggerFactory.getLogger(GreeterService.class);

  @SuppressWarnings(value = "unchecked")
  public String sayHello(String ...caller) {
    String result = null;
    log.info("caller = {}", caller);
    boolean f = prettyFormat(caller[0]);
    if (f) {
      result = String.format("Hello World, %s", caller).toUpperCase();
    }

    return result;
  }

  private boolean prettyFormat(String input){
    return input.contains("e");
  }
}
