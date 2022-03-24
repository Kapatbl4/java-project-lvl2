install: #install
	./gradlew clean install

run-dist: #run
	./build/install/app/bin/app

check-updates: #update check
	./gradlew dependencyUpdates