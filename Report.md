# Report

## - Main goal:

Improve and automatize the current electricity billing system. Get rid of manual reading and
billing process

## - Design pattern used: SINGLETON.

Automated electricity billing system includes in itself one headquarter that provides its
services to many customers. As the basic principle of Singleton letsyou ensure that a class
has only one instance, while providing a global access point to this instance, it is a perfect fit
for our project. As we would use a database to collect and store data about customers it is
also good and safe choice due to single instance of such database

## - Design pattern used: ADAPTER.

Adapter design pattern allows to transform the interface or data of one object into such a
form so that it can be understood by another object. Clients of our company could be divided
into two major categories: Individuals and Entities, while the former can be identified by their
confirmation document(f. e. passport in Russia), the latter should be distinguished by its
identification number(f. e. taxpayer identification number in Russia). Adapter pattern helps us
to simplify and convert every type of data into ID’s.

## - Classes created:

**Database** - main class of our project, where the Singletonpattern is implemented.
The following functions belong to Database class:
+ _findDebtors(): void -_ called by default every month,identifying debtors and
de-energizing them.
+ _deleteCustomer(): void -_ called by the customer ifs/he refuses to use our service.
+ addCustomer() function is called, when the new user wants to sign up to use our
service.
+ _calculateCosts(): void -_ runs always to calculateexpenses of the user.
+ _newRandom(): float -_ is used to generate the amountof money for our system and
for the customers.
+ _getCustomer(Account): void -_ is used to check if theuser exists in our system.
+ _accountExist(String): boolean -_ is used to check ifthe given email is used in our
system.
+ _getInstance() void -_ is used to create a Singletonclass.
+ _Database()_ is a constructor.

**Customer** - consists of information about the user.Includes account details and some
functions users can operate with, such as making payments, checking the balance, and
watching the history of bills.


The following functions belong to Customer class:
+ _makePayment( float payment )_ : void - this functionallows a customer to add some
amount of money to the balance. If the customer can pay some bill fully, the function
decreases the balance and sends the amount of money to close that bill. The function
doesn't return anything.
+ _getSummary(): List<Bill>_ - the function returnsall bills that a customer has ever had.
+ _getRemainder(): float_ - the function returns theamount of money needed for a customer
to close the debts.
+ _getBalance()_ : float - returns the balance of acustomer.
+ _setToDebtor()_ : - If the user doesn't have enoughmoney in his/her balance, the function
will be called to set the state of the customer to debtor.
+ _updateCurrentBill(int month, int year): void_ - The function will be called when the month is
ended. The function adds the bill of the months that just ended to the list of all bills that
customer has.

**Account** - contains private fields of emails and passwordsfor each customer. Provide
getters for email and password, while providing only the setter for the passport

**Bill** - Has information about the current state ofthe user according to a particular month.
Uses a boolean variable to indicate the state of the customer. True sets if the customer paid
for a month otherwise it is False and the user is considered as a debtor.

**Functionality** - contains actions users can perform.Log in, sign up, navigate through the
account. This class allows main() to be simplistic and to have overall more readable and
cleaner code.

**Information** - acts as an adapter, converting datareceived from classes given below. Unifies
different types of data provided by individuals and entities. Uses _InformationInterface_ as an
interface.

**PersonInfromation** - this class contains data providedby individuals.

**OrganizationInformation -** this class contains dataprovided by entities.

```
Project was created by: Bobiev Nodir, Davlatkhodja Magzumov, Aibek Bakirov, Valikhan
Ilyasov and Kaiyrly Alimzhan
```

