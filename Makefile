.DEFAULT_GOAL := build-run
build:
	gradle installDist
run:
	./build/install/app/bin/app
test:
	./gradlew test
lint:
	./gradlew checkstyleMain
build-run: build run
.PHONY: build