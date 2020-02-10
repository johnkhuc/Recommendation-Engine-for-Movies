# Recommendation Engine for Movies
> Using simple and weighted averages to recommend movies based on user ratings

`John Khuc`

## Table of Contents
- [Data Sets](#data-sets)
- [Class Overview](#class-overview)
- [Features](#features)
- [Results](#results)
- [Further Improvment](#further-improvement)

## Data Sets
- **ratedmoviesfull.csv** contains classes for Movie ID, Title, Year, Country, Genre, Directors, Length, Poster URL 
![Rated Movies](https://i.gyazo.com/4170f3f763d9947e520076cfc1881b61.png)
- **ratings.csv** contains classes for Rater ID, Movie ID, Rating, Time  
![Ratings](https://i.gyazo.com/e97beae574731732b4045b43b1c12dfe.png)

## Class Overview
![Overview](https://i.gyazo.com/ba958c52d9d9f6cbbeafe6022540a0e5.png)

## Features
- Filtering By Certain Criteria's (i.e. Comedy, 60 to 90 minutes, Directed by "Christopher Nolan")
- Recommending Movies based on Criteria's and Similar User Ratings 

## Results
![Results](https://i.gyazo.com/1ddfac63308ac5eba44b6b8136e4182c.png)

## Further Improvement
- Content Based (recommend based on individual user) instead of Collaborative filtering
- Try different algorithms and models
  - Neighborhood based (KNN)
  - Factorization based (SVD)
  - Rule based (Associating profiles based on interactions)
  - Model based (Predictive models)



