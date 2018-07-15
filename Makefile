# Makefile for Lightbulb

JAVAFLAGS=-Xlint

all: Main.class

Main.class: Main.java
	javac Main.java $(JAVAFLAGS)

clean:
	rm -f *.class
