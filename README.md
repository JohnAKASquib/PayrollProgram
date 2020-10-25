# CSC 430 PayrollProgram
This software is used to help manage company personnel, calculate for them after-tax salary, welfare items, as well as edit and manage the personal information of each employee.

## Logging In
For an employee or HR Member to log into the program, they must input their assigned Employee ID and password. Each user will be given three chances to input the correct information. If they do not input the correct information after three chances, they will be locked out of the system and must an HR member to reset their password. This is implemented to increase database security and allow data maniplulation strictly to signed in HR Members.

## Employee Interface
When logged in, employees will be able to view their salary as well as their chosen benefit package, and the benefits given in that package.

## HR Member Interface
HR Members will be prompted to input the Employee ID of the employee they wish to modify. Inputting an unregistered ID will prompt the HR Member to input a valid ID and will not create a new ID. When a valid ID is input, the HR Member will be shown the full name, SS number, address, date of birth, home and mobile phone number, employee password and email address. They will also be shown how long the employee has worked at the company, hours worked since their last salary, whether the employee is full time or part time, their gross an net income, and their chosen benefits package.
