# APCSA_Keniel_AB_Reg_Naphtali

Help a group of people select a movie to watch.

---
### Movie.java

**Attributes**
- `String title`
- `String genre`
- `int year`
- `double rating`
- `int runtime`

**Methods**
- Accessors for each attribute
- Mutators for each attribute, if ever needed
- `toString()`
- `getRuntimeString()`: Convert `this.runtime` from an integer of minutes into a formatted string.

---
### Roulette.java

**No Attributes**

**Methods**
- `Movie chooseOne(ArrayList<Movie> list)`: Select and return a single Movie from a list of Movies
- `Movie[] chooseX(ArrayList<Movie> list, int x)`: Select and return x Movies from a list of Movies

---
### MovieRoulette.java (Driver class)

**Methods**
- `void getRandomMovies(ArrayList<Movie> list)`: Acquire and display any number of random Movies from a list
- `void main(String[] args)`: The main method. Run the program from this file if you want it to work.