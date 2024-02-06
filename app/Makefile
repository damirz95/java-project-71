.DEFAULT_GOAL := build-run
clean:
	./gradlew clean
build:
	./gradlew clean build
install:
	./gradlew clean install
run:
	./build/install/app/bin/app
test:
	./gradlew test
lint:
	./gradlew checkstyleMain
report:
	./gradlew jacocoTestReport
build-run: build run
.PHONY: build