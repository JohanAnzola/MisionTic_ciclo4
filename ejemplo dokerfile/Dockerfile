FROM debian:latest
RUN apt-get update && apt-get install -y vim 
RUN  apt-get install -y apache2
RUN service apache2 start
WORKDIR /var/www/html/
RUN mkdir proyecto

ADD index.html /var/www/html/proyecto/index.html 
EXPOSE 80
CMD /bin/bash