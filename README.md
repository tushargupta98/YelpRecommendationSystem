Team Members: Tushar Gupta, V.J.R. Karthik Akella

Assignment: Log Analysis on system messages

The Log Analysis is implemented using Spark API.

Prerequisites:

For Executing the spark API, the following environment should be set
Java version : JDK 1.8
MongoDB : 3.4
Spark version : 2.11

Libraries required : spark jars required to run the SPARK java class to be included in the environment path variable.

Java_HOME and spark_HOME should be set in the evironment.

About This Project: This is an ALS(Collaborative Filtering) based Recommendation system built using 
- Apache Spark
- Mongo DB
- Java
- YelpChallenge Dataset

It includes:
1) All the business logic used to pre process, generate model and post process data
  - MongoDB Queries
  - Java Files
  
2) recommendationsystem.YelpRecommendationEngine is the class excuting main logic

output.txt contains the output generated by the execution

3) new_collection_query.js and reviewsQueries.txt contains the list of commands that were executed from the command prompt to preprocess the data

4) YelpDataset.java was used to further process that data as per the requirements
