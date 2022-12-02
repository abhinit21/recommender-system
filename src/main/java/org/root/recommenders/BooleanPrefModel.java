package org.root.recommenders;

import org.apache.log4j.BasicConfigurator;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.RMSRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.GenericBooleanPrefDataModel;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BooleanPrefModel {

    public static void main(String[] args) throws IOException, TasteException {

        BasicConfigurator.configure();

        long start = System.nanoTime();

        DataModel model = new FileDataModel(new File("src/main/java/org/root/data/ratings.csv"));

        RecommenderBuilder recommenderBuilder = dataModel -> {
            UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(100, similarity, dataModel);
            return new GenericBooleanPrefUserBasedRecommender(dataModel, neighborhood, similarity);
        };

        Recommender recommender = recommenderBuilder.buildRecommender(model);

        List<RecommendedItem> recommendations = recommender.recommend(4, 5);

        for (RecommendedItem recommendedItem : recommendations)
            System.out.println(recommendedItem);

        RecommenderEvaluator evaluator = new RMSRecommenderEvaluator();

        double score = evaluator.evaluate(recommenderBuilder, null, model, 0.5, 0.1);

        System.out.println("RMSE : " + score);

        long end = System.nanoTime();

        System.out.println("Execution Time : " + (end - start) + " ns");

    }

}
