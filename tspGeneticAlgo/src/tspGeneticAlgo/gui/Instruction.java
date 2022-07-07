package tspGeneticAlgo.gui;

public class Instruction {
    private final String contentText;
    public Instruction(){
        this.contentText = "<html>"+
                "<h1>Welcome to TSP-GA simple graph!</h1>" +
                "<body>"+
                "Before make any changes, we highly recommend that you should read about Genetic Algorithm at:<br/>" +
                "<i>https://en.wikipedia.org/wiki/Genetic_algorithm</i><br/>"+
                "<h2>There are 6 components you need to consider in GA:</h2>"+
                "- <b>\"Population\"</b> size is the number of individual typically contains several hundreds or thousands of<br/>" +
                "possible solutions.<br/>"+
                "- <b>\"Total generations\"</b> is the life span of the population, in this case, it is the number of iterations<br/>" +
                "or epochs that our application will do the Selection - Crossover - Mutation on the population.<br/>"+
                "- <b>\"Citites\"</b> is the number of cities, also the number of nodes. Each node contains cartesian coordinates<br/>" +
                "x and y and the distance and the distance between 2 nodes is Euclidean distance.<br/>"+
                "- <b>\"Elitism\"</b> is the number of the best and fittest individuals in current generation that is kept<br/>" +
                "and transferred to the next generation.<br/>"+
                "- <b>\"Crossover rate\"</b> is the rate or the probability that 2 chromosomes may exchange part of their genes<br/>"+
                "- <b>\"Mutation rate\"</b> is the rate or the probability that a chromosome change some of their genes to maintain<br/>"+
                "the biodiversity in the population and avoid premature convergence"+
                "<h2>Tuning the parameter:</h2>"+
                "It is worth tuning parameters such as the mutation probability, crossover probability and population size<br/>" +
                "to find reasonable settings for the problem class being worked on.<br/>"+
                "- An adequate population size ensures sufficient genetic diversity for the problem at hand, but can lead to<br/>" +
                "a waste of computational resources if set to a value larger than required.<br/>"+
                "- A recombination rate that is too high may lead to premature convergence of the genetic algorithm<br/>"+
                "- A very small mutation rate may lead to genetic drift (which is non-ergodic in nature)<br/>"+
                "- A mutation rate that is too high may lead to loss of good solutions.<br/>"+
                "<h2>Running the app:</h2>"+
                "Click on <b>\"Start button\"</b> perform GA on a random sets of data points with all parameter set above.<br/>"+
                "Click on <b>\"Stop button\"</b> to get the temporary best solution.<br/>"+
                "Click on <b>\"Restart button\"</b> to reset all the program.<br/>"+
                "<h1>Now let's dive into the world of Genetic Algorithm.</h1>"+
                "</body>"+
                "</html>";
    }

    public String getContentText() {
        return contentText;
    }
}