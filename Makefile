# Makefile for Lightbulb

all:
	javac *.java
	
main: all

clean:
	rm -f *.class
