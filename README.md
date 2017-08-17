# Lightbulb
Event-driven lightbulb

## Requirements
- Java something

## Usage
### Compiling and Running
- Compile: `make all` or `javac *.java`
- Run: `java main`

### The program
- Lightbulb starts OFF (signified by a black screen)
- Pressing the button at any point turns the light ON
- Every second, a `tick()` occurs
- After five `tick()`s, the lightbulb transitions from ON to DIM
- The lightbulb will remain on DIM for two `tick()`s, at which point it will turn OFF
