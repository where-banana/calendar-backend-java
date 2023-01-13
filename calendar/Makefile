all: clean package run

package:
	mvn clean package

run:
	docker compose up

clean:
	mvn clean
	docker rm -f $(shell docker ps -aq)
	docker rmi -f calendar-app
