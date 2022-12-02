package org.root;

import org.apache.log4j.BasicConfigurator;
import org.apache.mahout.cf.taste.common.Refreshable;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.RMSRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.CityBlockSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.*;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.common.LongPair;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * ITEM-Based Recommender System on Lens Data
 * <p>
 * TODO : sl4j configurator for debug off
 * TODO : convert all recommenders into a java interface
 * TODO : create a website to view outputs
 */

public class App {

    public static void main(String[] args) throws IOException, TasteException {

        BasicConfigurator.configure();

        System.out.println("Item Based Recommender");

        System.out.println("User Based Recommender");

        System.out.println("Boolean Preference Model Based Recommender");

        // Data Model

        // User Similarity

        // Item Similarity

        // User Neighbourhood

        // Recommender

        // Evaluate

    }

}
