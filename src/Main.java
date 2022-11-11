
public class Main {
    public static void main(String[] args){
        MonteCarloAlgorithm test = new MonteCarloAlgorithm(15,32);
        test.generatePopulation();
        test.fillTheFitnessLandscape();
        test.printTheFitnessLandscape();
        test.searchBestIndividual();

    }
}
