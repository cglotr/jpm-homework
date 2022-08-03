# Take-home Assignment

To be completed by Monday 8 August 2022

## Use Case

- Build a simple Java application for the use case of ‘Booking a Show’. The program must take input from command line.
- The program would setup available seats per show, allow buyers to select 1 or more available seats and buy/cancel tickets.
- The application shall cater to the below 2 types of users & their requirements - Admin and Buyer



### Admin

The users should be able to Setup and view the list of shows and seat allocations.

Commands to be implemented for Admin:

1. `Setup <Show Number> <Number of Rows> <Number of seats per row>  <Cancellation window in minutes>`

   (To setup the number of seats per show)

2. `View <Show Number>`

   (To display Show Number, Ticket#, Buyer Phone#, Seat Numbers allocated to the buyer)

### Buyer

The users should be able retrieve list of available seats for a show, select 1 or more seats , buy and cancel tickets.

Commands to be implemented for Buyer:

1. `Availability  <Show Number>`

   (To list all available seat numbers for a show. E,g A1, F4 etc)

2. `Book  <Show Number> <Phone#> <Comma separated list of seats>`

   (To book a ticket. This must generate a unique ticket # and display)

3. `Cancel  <Ticket#>  <Phone#>`

   (To cancel a ticket. See contraints in the section below)

## Constraints:

- Assume max seats per row is 10 and max rows are 26. Example seat number A1,  H5 etc. The “Add” command for admin must ensure rows cannot be added beyond the upper limit of 26.
- After booking, User can cancel the seats within a time window of 2 minutes (configurable).   Cancellation after that is not allowed.
- Only one booking per phone# is allowed per show.

## Requirements

1. Implement the solution as Java standalone application (Java 8+). Can be Springboot as well. The data shall be in-memory.
2. Write appropriate Unit Tests.
3. Implement the above use case considering object oriented principles and development best practices. The implementation should be a tested working executable.
4. The project code to be uploaded to Github and share back to us for offline review by 8 August 2022. Please let me know if you require an extension.
5. Just make an assumption if anything is not mentioned here. The same can be highlighted in the readme notes when submitting.
