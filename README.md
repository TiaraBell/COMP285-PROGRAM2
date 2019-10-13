# COMP285-PROGRAM2
COMP285 Programming Assignment 2: Pruned Intensity Graphs

I’ve been tasked with reducing the search space of possible paths in an image graph in order to accurately detect objects within the images. In order to do this, I must implement the use of minimum spanning trees. Given an image graph, which is represented by a 2D array of values, I must return the minimum intensity weight value of a pruned graph that I’ve constructed from the graph given. I plan to first construct the graph from the image using the 2D array that is given and find the intensity weight value of this graph. Then I will run an algorithm that finds the minimum spanning tree for the graph and return the new minimum intensity weight value.
