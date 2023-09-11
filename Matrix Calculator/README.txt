Program takes in 4 arguments: the name of the executable, two file names, and a character (a or s) representing the operation type.
The input files are read and the data is passed into two matrices, both containing an int representing their sizes and an array of floats
representing the data. If the last argument in the command line is "a", the values in each matrix will be added to their respective counterparts in the other 
matrix. If the last argument in the command line is "s", the values in each matrix will be subtracted from their respective counterparts in the other matrix.
All values from addition and subtraction are printed to the terminal.

The program can be compiled using the make command, or alternatively entering "gcc matrix_calc.c matrix_math.c -o matrixCalc" into the terminal followed by 
"./matrixCalc.exe "filename1" "filename2" "operationType""

Information from this thread: https://stackoverflow.com/questions/8004237/how-do-i-properly-compare-strings-in-c was used in the implementation of string comparison in the main 
function.

Brief collaboration with Jacob Murphy

