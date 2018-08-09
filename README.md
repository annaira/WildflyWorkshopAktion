
Changes needed for WildFly
-------------------------------------

This is my implemention while reading Workshop Java EE 7: 
Ein praktischer Einstieg in die Java Enterprise Edition mit dem Web Profile.
https://amzn.to/2vxacqj

**Chapter 2**

Change the archetype to 

    <!-- https://mvnrepository.com/artifact/org.wildfly.archetype/wildfly-javaee7-webapp-blank-archetype -->
    <dependency>
        <groupId>org.wildfly.archetype</groupId>
        <artifactId>wildfly-javaee7-webapp-blank-archetype</artifactId>
        <version>8.2.0.Final</version>
    </dependency>


Change the command `mvn package jboss-as:deploy` to `mvn package wildfly:deploy`.

**Appendix**

URLs for the TimeServlet:    
* http://localhost:8080/my-aktion/TimeServlet
* http://localhost:8080/my-aktion/time.jsp
* http://localhost:8080/my-aktion/xtime.html
* http://localhost:8080/my-aktion/time.jsf