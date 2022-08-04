# JPM Homework

Homework [requirements](https://github.com/cglotr/jpm-homework/blob/master/homework.md)

## Demo

Happy path [video](https://drive.google.com/file/d/1ZclcB71T_-A_yIGKT1zIzjb7TNkplzzs/view?usp=sharing) demo

Cancel failure [demo](https://github.com/cglotr/jpm-homework/blob/master/demo_cancel_failed.png)

## Components

1. [Show Manager](https://github.com/cglotr/jpm-homework/blob/master/src/main/java/org/jpmorgan/managers/DisplayManagerImpl.java)

   Handles show booking operations. Main logic is contained here

2. [Commands](https://github.com/cglotr/jpm-homework/tree/master/src/main/java/org/jpmorgan/commands)

   Handles input parsing

3. [Display Manager](https://github.com/cglotr/jpm-homework/blob/master/src/main/java/org/jpmorgan/managers/DisplayManagerImpl.java)

   Handles nicely printing the output

## Test

![coverage](https://github.com/cglotr/jpm-homework/blob/master/coverage.png)

## Notes

- Added additional command `Exit` to exit the program

## IDE

[IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=linux)
