#include <stdlib.h>
#include <stdio.h>
#include "matrix_math.h"
#include <string.h>

struct matrix // Matrix struct with an int representing the size of the matrix and an array containing all values of the matrix
{
     int size;
     float *data;
};

typedef struct matrix Matrix;

int main(int argc, char *argv[]) // main program - takes in 4 arguments: the program name, the file names, and the operation type
{

     Matrix *m1;
     Matrix *m2;
     m1 = readMatrix(argv[1]); // uses readMatrix() to create two matrix pointers from the input files
     m2 = readMatrix(argv[2]);

     if (m1[0].size != m2[0].size || m1[0].size < 1) // checking if the matrices have the same size and a size > 0
     {
          printf("This math cannot be performed.\n"); // error message
     }
     else
     {
          if (strcmp(argv[3], "a") == 0) // adds the two matrices if the third argument is "a"
          {
               addition(m1[0], m2[0]);
          }
          else if (strcmp(argv[3], "s") == 0) // subtracts the two matrices if the third argument is "s"
          {
               subtraction(m1[0], m2[0]);
          }
     }
}