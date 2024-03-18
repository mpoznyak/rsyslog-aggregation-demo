FROM	centos:7
RUN     yum -y install wget \
	&& cd /etc/yum.repos.d/ \
        && wget http://rpms.adiscon.com/v8-stable/rsyslog.repo
RUN	yum install -y rsyslog rsyslog-kafka rsyslog-omhttp \
	&& rm /etc/rsyslog.d/listen.conf