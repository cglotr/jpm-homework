# JPM Homework

Homework [requirements](https://github.com/cglotr/jpm-homework/blob/master/homework.md)

## Demo

Happy path [video](https://drive.google.com/file/d/10JXGdLfcgTu3YrdpeOYRtd4X5EM6D3_Z/view?usp=sharing) demo

Cancel failure [demo](https://github.com/cglotr/jpm-homework/blob/master/demo_cancel_failed.png)

## Notes

- Additional commands:
    - `Exit` - To exit the program
    - `Login` - To login as Admin user
    - `Logout` - To logout as Admin user
- Assumptions:
    - `Admin` users can also do `Buyer` actions

## Components

1. [Show Manager](https://github.com/cglotr/jpm-homework/blob/master/src/main/java/org/jpmorgan/managers/ShowManagerImpl.java)

   Handles show booking operations. Main logic is contained here

2. [Commands](https://github.com/cglotr/jpm-homework/tree/master/src/main/java/org/jpmorgan/commands)

   Handles input parsing

3. [Display Manager](https://github.com/cglotr/jpm-homework/blob/master/src/main/java/org/jpmorgan/managers/DisplayManagerImpl.java)

   Handles nicely printing the output

## Test

![coverage](https://github.com/cglotr/jpm-homework/blob/master/coverage.png)

## IDE

[IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=linux)
