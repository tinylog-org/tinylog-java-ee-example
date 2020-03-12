# Using tinylog on Java EE

Maven based example application to demonstrate how to use [tinylog](https://github.com/pmwmedia/tinylog) as logging framework for Java EE applications

If you want to use the logging back-end of a `java.util.logging` (JUL) based server like Tomcat or Glassfish, you can use the Maven artifact `tinylog-jul`.

If you want to use the logging back-end of a JBoss Logging based sever like Wildfly or JBoss EAP, you can use the Maven artifact `tinylog-jboss`.

However, it is also possible to use `tinylog-impl`, if you want to use the native logging back-end of tinylog for configuration and outputting log entries. It is even possible to use `tinylog-impl` together with `tinylog-jul` or `tinylog-jboss`. In this case, all log entries will be output by the native logging back-end of tinylog and additionally by the logging back-end of the web or application server.
