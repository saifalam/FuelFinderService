FROM dostiharise/ubuntu-java-mysql

RUN mkdir -p /appdev
#COPY run.bash /start.bash
#RUN chmod +x /start.bash 

# Change mysql host for all hostip and grant permission to all
RUN sed -i -E 's/^bind-address/#bind-address/g' /etc/mysql/mysql.conf.d/mysqld.cnf
RUN service mysql restart && mysql -e "GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root';FLUSH privileges;"

WORKDIR /appdev
EXPOSE 8080 3306 22

CMD ["./run.bash"]
