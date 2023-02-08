# CustomerRewards


This is a React Application with SpringBoot on the backend which calculates the monthly rewards as well as the total rewards for a given dataset of customers and transactions.


I have created only a small dataset using the CommandLineRunner, ideally you would want the dataset to persist somewhere and then you would read it. But to make things simpler I have chosen this route.

Set Up Needed to run the Application

1) IDE which can run Spring Boot applications(Make sure to have the necessary plugins needed)
2) I have used POSTGRES as my database here, so make sure that POSTGRES has been set with the database name as given in src/main/resources/application.properties.
3) Make sure to have VSCode installed inorder to Run React and make the necessary installations needed for React and its components(I have used Ant Design component here for the React Front End)



To Run the application go to the CustomerRewards/CustomerFrontEnd

# Run npm start in order to Start the React Application.

Make sure to run the application with the SpringBoot code as well.

Select the option from the dropdown

1) Customer Total Rewards -> For total customer reward points for each of the Customer

2) Transaction List -> For all the transaction list present in the dataset

3) Monthly Customer Rewards -> For a month on month based customer reward points on the basis of each customer
  


To Run the Tests on the BackEnd

1) To run all the tests associated with Customer classes locate the Customer Tests Under src/test/java/com/customerRewards/customer
2) To run all the tests associated with Transaction classes locate the Customer Tests Under src/test/java/com/customerRewards/transactions
  
