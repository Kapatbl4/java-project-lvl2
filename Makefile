install: #install
	./gradlew clean install

run-dist: #run
	./build/install/app/bin/app

check-updates: #update check
	./gradlew dependencyUpdates

report: #test report
	./gradlew jacocoTestReport

build: # build
	./gradlew checkstyleMain
	./gradlew test
	./gradlew clean build
.PHONY : build
.PHONY : test