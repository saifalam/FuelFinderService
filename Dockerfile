FROM dostiharise/ubuntu-java-mysql

RUN mkdir -p /appdev
#COPY run.bash /start.bash
#RUN chmod +x /start.bash 

WORKDIR /appdev
EXPOSE 8080 3306 22

CMD ["./run.bash"]
