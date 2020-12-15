# MVC Game

This repository contains an implementation of a simple MVC game. The aim of the code is to use various design patterns to encapsulate the behavior of the game.

## Design patterns

The game contains these **major** patterns:

1. MVC
2. Strategy
3. Bridge
4. Proxy
5. State
6. Visitor
7. Observer
8. Command
9. Memento
10. Abstract factory

**Extra** patterns used:

1. Null object
2. Mixin

## Features

The game contains these **major** features:

1. Shooting force change.
2. Angle of the cannon.
3. Gravity for realistic shooting mode.
4. Score counting.
5. Reduction of dependency on a specific graphics library (bridge).
6. Firing multiple shots at once.
7. Model control by commands.
8. Undo (step-back).
9. Two strategies for missile movement (simple, realistic).

**Extra** features implemented:

1. Sounds – shoot, hit, and background music.

## Running the game

The game is implemented using Java 12 and JavaFX library. To compile and run the game, use this maven command: `compile javafx:run`. To run the test, use the maven commands `clean test`.

## Resources

1. Shoot sound – [https://mixkit.co/](https://mixkit.co/)
2. Hit sound – [https://mixkit.co/](https://mixkit.co/)
3. Background music – [rolemusic.sawsquarenoise.com](http://rolemusic.sawsquarenoise.com/)
