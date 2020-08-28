all:
	javac -d . avaj_launcher/src/**/*.java
	java -cp . weather.Simulate "scenario.txt"
clean:
	rm -rf weather aircraft
re: clean all