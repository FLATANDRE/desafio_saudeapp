FROM jboss/wildfly
ADD target/saude-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
