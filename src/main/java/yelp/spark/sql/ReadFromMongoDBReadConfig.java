package yelp.spark.sql;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;

import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.config.ReadConfig;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;


public final class ReadFromMongoDBReadConfig {

  public static void main(final String[] args) throws InterruptedException {

    SparkSession spark = SparkSession.builder()
      .master("local")
      .appName("MongoSparkConnectorIntro")
      .config("spark.mongodb.input.uri", "mongodb://localhost/yelp.sampleReviews2")
      .config("spark.mongodb.output.uri", "mongodb://localhost/yelp.sampleReviews2")
      .getOrCreate();

    // Create a JavaSparkContext using the SparkSession's SparkContext object
    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());

    /*Start Example: Read data from MongoDB************************/

    // Create a custom ReadConfig
    Map<String, String> readOverrides = new HashMap<String, String>();
    readOverrides.put("collection", "spark");
    readOverrides.put("readPreference.name", "secondaryPreferred");
    ReadConfig readConfig = ReadConfig.create(jsc).withOptions(readOverrides);

    // Load data using the custom ReadConfig
    JavaMongoRDD<Document> customRdd = MongoSpark.load(jsc, readConfig);

    /*End Example**************************************************/

    // Analyze data from MongoDB
    System.out.println(customRdd.count());
// /   System.out.println(customRdd.first());

    jsc.close();

  }
}