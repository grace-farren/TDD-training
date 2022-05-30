# TDD-training PreAssessment - Industrial Logic

## Assessemnt 1 
We ask that you identify the various design problems (code smells) in the code and clean up (refactor) the code so its easy to understand and maintain.
You are free to change the code any way you like, as long as you don't break existing functionality.
It is a good idea to write some automated unit tests to ensure you do not break any functionality.

## Sales Tax Problem 
Big Bill's company, Wild West Stores, has a billing system that has been generating some unusually big bills of late.
Old Mrs. Smith was billed $3,000 dollars sales tax for buying 5 items at the store.
Big Bill has had enough!
He wants a quality sales tax calculator and wants YOU to program it.
Big Bill has high expectations from you and the new system.
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.
When you purchase items you receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. The sales tax is rounded up to the nearest 0.05 amount.
Write an application that prints out the receipt details for these shopping baskets...

| Input | Output |
|-------|--------|
|1 book at 12.49 | 1 book: 12.49 |
|1 music CD at 14.99 | 1 music CD: 16.49 |
| 1 chocolate bar at 0.85	| 1 chocolate bar: 0.85 |
| | Sales Taxes: 1.50|
| | Total: 29.83| 
| 1 imported box of chocolates at 10.00 | 1 imported box of chocolates: 10.50 |
| 1 imported bottle of perfume at 47.50	 | 1 imported bottle of perfume: 54.65 |
| | Sales Taxes: 7.65|
| | Total: 65.15|
| 1 imported bottle of perfume at 27.99 | 1 imported bottle of perfume: 32.19| 
| 1 bottle of perfume at 18.99 | 1 bottle of perfume: 20.89 |
| 1 packet of headache pills at 9.75 | 1 packet of headache pills: 9.75 | 
| 1 box of imported chocolates at 11.25	| 1 imported box of chocolates: 11.85|
| | Sales Taxes: 6.70| 
| | Total: 74.68|

Note: Document the necessary assumptions.
