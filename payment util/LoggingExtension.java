package com.example;
import org.junit.jupiter.api.extension.*;
import java.util.*;
public class LoggingExtension implements BeforeEachCallback,AfterEachCallback{
 private final Map<String,Long> times=new HashMap<>();
 public void beforeEach(ExtensionContext c){
  times.put(c.getUniqueId(),System.currentTimeMillis());
  System.out.println("START: "+c.getDisplayName());
 }
 public void afterEach(ExtensionContext c){
  long d=System.currentTimeMillis()-times.get(c.getUniqueId());
  System.out.println("END: "+c.getDisplayName());
  System.out.println("Execution Time: "+d+" ms");
 }
}
