# CustomerRewards


This is a Spring Boot application which calculates the monthly rewards as well as the total rewards for a given dataset of customers and transactions.


I have created only a small dataset using the CommandLineRunner, ideally you would want the dataset to persist somewhere and then you would read it. But to make things simpler I have chosen this route.

Set Up Needed to run the Application

1) IDE which can run Spring Boot applications(Make sure to have the necessary plugins needed)
2) I have used POSTGRES as my database here, so make sure that POSTGRES has been set with the database name as given in src/main/resources/application.properties.



To Run the application

1) Run the file CustomerRewardsApplication.java(src/main/java/com/customerRewards/CustomerRewardsApplication.java)
2) Go to a Browser of you choice and type in the following links for the following API's:
  
  a)For Total Rewards for each of the customer: http://localhost:8080/api/v1/customerRewards/Rewards
  
  b)For Monthly Rewards for individual customer: http://localhost:8080/api/v1/customerRewards/Rewards/{customerId}
  Replace the {customerId} with either the number 1,2 or 3 as these are the available customer ID's
  
  c)For All the Transaction Data: http://localhost:8080/api/v1/customerRewards/Transactions
  


To Run the Tests

1) To run all the tests associated with Customer classes locate the Customer Tests Under src/test/java/com/customerRewards/customer
2) To run all the tests associated with Transaction classes locate the Customer Tests Under src/test/java/com/customerRewards/transactions
  
