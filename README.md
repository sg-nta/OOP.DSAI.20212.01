# OOP.DSAI.20212.01
## Team 01's project on TSP using Genetic Algorithm
Our project's source code is divided into 8 packages:
- "ga" package contains the general implementation for Genetic Algorithm which is related to "population" and "individual".
- "route" and "node" is the representative for the city and the moving strategy among city. A route may contain a specific number of nodes and each node has 2 attributes x and y to locate it on the 2D map.
- "tsp" run the GA to solve Traveling Saleman Problem without GUI.
- "gui" contains code for building the Graphic User Interface for the app and you have to run the main function inside GUI class to run the whole application.

Assignments of members:
1. Hoang Van An:
• components package (20%):
– Design package
– toString method
• Construct class diagram (30%)
• geneticalgorithm package (30%)
– UpdateFitness method
– Try different strategies for algorithms
• gui package (60%)
– Create Help button with guidelines for the application.
– Create Print route button.
– Improve GUI class (ButtonListener, color, size)
– Improve Draw class (color, size, experiment the proper scale to fit the frame)
– Create class RoundJTextField, Instructions.
• presentation slide (90%)
• report (20%)
2. Nguyen Truong Truong An:
• Construct use case diagram (40%)
• components package (10%)
• presentation slide (10%)
• report (20%)
3. Nguyen The An:
• Construct class diagram (60%)
• Construct use case diagram (60%)
• components package (70%):
– Design package
– Create classes Node, Individual, Route, Population
• geneticalgorithm package (70%)
– Design package
– GeneticOperator class
– Selection, CrossOVer, Mutation class
– TournamentSelection, TwoPointCrossOver, TwoPointSwappingMutation class
• gui package (40%)
– Create Draw class
– Create initial GUI class
– Implement Timer in GUI
• report (50%)
4. Nguyen Phuc Truong An:
• Construct class diagram (10%)
• components package (10%): comparator method
• geneticalgorithm package (10%): Handle Exception
• report (10%) : Conclusion