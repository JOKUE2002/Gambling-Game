# Gambling-Game
Little Gambling game calculation.

# How it works
Every player has to pay an entry fee of 0 to 100$. 
Now everyone gets 100 points onto a virtual account and a coin.
They'll throw the coin 100 times. 
If it shows head, their current score will be stocked up by 50% ( x1.5 )
else if it shows tail, their current score will be decreased by 40% ( x0.6 )

if their account has an score of over 100 (greater or equal) they'll win double of their entry fee, else they'll lose it.

# Code
The code of the whole game is very simple. A for loop, that'll loop 100 times, a random boolean and an if statement, that'll multiply the account according to the outcome. After the loop, the code checks, whether he has won or not.

# Goal of the project
My goal was to calculate the probability to win the game. Therefor the computer simulates a given number of rounds. On my decent laptop 10000 games (with 100 throws each) take around 1.2 minutes, 100000 games take around 10-14 minutes.
To make it all faster, I went down the track of multithreading (creating many threads and starting all one after another.

# Further goals
To see whether the multithreading was efficient or not, I implemented it with and without multithreading. To see it all, I'm taking times of everything and track it in a CSV-File, that'll later be opened in excel/numbers/open office to show diagrams

# Results
--Will follow later--
