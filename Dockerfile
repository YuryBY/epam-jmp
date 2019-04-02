FROM centos:7

MAINTAINER Yury Bakhmutski <Yury_Bakhmutski@epam.com>

LABEL description="This is a dockerfile for event-service project based on Centos system"

USER root

RUN yum -y update

RUN yum list available \*openjdk\*
#RUN yum -y install java-11-openjdk
RUN yum -y install java-1.8.0-openjdk

ARG SERVICE_LOCATION=/apps/docker/event-service

RUN mkdir -p "$SERVICE_LOCATION"
WORKDIR $SERVICE_LOCATION
RUN cd $SERVICE_LOCATION

ADD event-service-rest/target/event-service-rest-1.0-SNAPSHOT.jar $SERVICE_LOCATION

ENTRYPOINT ["java", "-jar", "event-service-rest-1.0-SNAPSHOT.jar"]
#ENTRYPOINT ["/run-jar-entrypoint.sh"]

#COPY data/httpd.conf /etc/httpd/conf/httpd.conf
#ADD data/html.tar.gz /var/www/html/
#EXPOSE 80
#ENV HOME /root
#WORKDIR /root
#ENTRYPOINT [“ping”]
#CMD [“google.com”]