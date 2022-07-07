# OOP.DSAI.20212.01
## Team 01's project on TSP using Genetic Algorithm
Our project's source code is divided into 8 packages:
- "ga" package contains the general implementation for Genetic Algorithm which is related to "population" and "individual".
- "route" and "node" is the representative for the city and the moving strategy among city. A route may contain a specific number of nodes and each node has 2 attributes x and y to locate it on the 2D map.
- "tsp" run the GA to solve Traveling Saleman Problem without GUI.
- "gui" contains code for building the Graphic User Interface for the app and you have to run the main function inside GUI class to run the whole application.