install: #install
	./gradlew clean install

run-dist: #run
	./build/install/app/bin/app

check-updates: #update check
	./gradlew dependencyUpdates

build: # build
	./gradlew clean build
.PHONY : build
.PHONY : test