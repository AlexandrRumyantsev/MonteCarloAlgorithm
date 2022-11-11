import java.util.*;
public class MonteCarloAlgorithm {

    final int L, N;
    Integer max = 0;
    String  maxS;
    ArrayList<String> population;
    Map<String, Integer> theFitnessLandscape;

    public MonteCarloAlgorithm(int l, int n){
        this.L = l;
        this.N = n;
        this.population = new ArrayList<>();
        this.theFitnessLandscape = new HashMap<>();
    }

    public void generatePopulation(){
        for (int i = 0; i < N; i++){
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < L; j++ ) {
                tmp.append(Math.random() >= 0.5 ? 1 : 0);
            }
            population.add(tmp.toString());
        }
    }

    public void fillTheFitnessLandscape(){
        for (String individual : population) {
            int fitness = countFitness(individual);
            theFitnessLandscape.put(individual, fitness);
        }
    }

    private static int countFitness(String s){
        return Integer.parseInt(s,2);
    }

    public void searchBestIndividual() {
        int i = 1;
           for(Map.Entry<String, Integer> pair : theFitnessLandscape.entrySet()) {
               System.out.println("Step: " + i);
               if (pair.getValue() > max) {
                   max = pair.getValue();
                   maxS = pair.getKey();
               }
               System.out.println("Chosen individual: "+pair.getKey()+" its fitness "+pair.getValue());
               System.out.println("Best individual: "+maxS+ " with "+ max+" fitness");
               i++;
           }
        }
     public void printTheFitnessLandscape(){
        System.out.println("FitnessLandscape table:");
         System.out.println("____________________________________");
        for (Map.Entry<String, Integer> pair : theFitnessLandscape.entrySet()){
            System.out.println(pair.getKey()+ "  "+ pair.getValue());
        }
         System.out.println("____________________________________");
     }
}
