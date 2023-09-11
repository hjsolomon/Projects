#include "matrix_math.h"
#include <stdio.h>
#include <stdlib.h>

struct matrix // Matrix struct with an int representing the size of the matrix and an array containing all values of the matrix
{
    int size;
    float *data;
};

typedef struct matrix Matrix;




/********************************************************
 *   readMatrix(char *filename)
 *   Reads the matrix data from the specified file and allocates a pointer to a new matrix with the data
 *
 *   Input:
 *       *filename: The name of the file to read
 * 
 *   Returns:
 *       A pointer to the new matrix
 *********************************************************/
struct matrix *readMatrix(char *filename)
{
    FILE *f1 = fopen(filename, "r"); // opens the file
    int size;
    fscanf(f1, "%i", &size); // scans the size of the matrix from the file
    float *array = malloc(sizeof(float) * size); // allocates memory on the heap for an array with "size" elements
    float value;
    int count = 0;
    while (fscanf(f1, "%f", &value) > 0) // scans the rest of the values from the file, adding them to the array
    {
        array[count] = value;
        count++;
    }

    Matrix *m = malloc(sizeof(Matrix)); // allocates memory on the heap for a matrix
    m[0].size = size; // sets the value of the matrix's size to size
    m[0].data = array; // sets the value of the matrix's data to array
    return m; // returns the pointer to the array
}


/********************************************************
 *   deleteMatrix(struct matrix *A)
 *   Deletes the data of the given matrix
 *
 *   Input:
 *       *A : the matrix to be deleted
 * 
 *   Returns:
 *       0
 *********************************************************/
int deleteMatrix(struct matrix *A)
{
    free(A); // frees the memory allocated to the matrix
    return 0;
}


/********************************************************
 *   addition(struct matrix A, struct matrix B)
 *   Adds the values of the given matrices together and prints to the terminal
 *
 *   Input:
 *       *A : the first matrix to be added
 *       *B : the second matrix to be added
 * 
 *   Returns:
 *       void
 *********************************************************/
void addition(struct matrix A, struct matrix B)
{
    int size = A.size;
    printf("A + B = \n"); // prints the header
    for (int i = 0; i < size; i++) // loops through each array, printing the sum of each value
    {
        printf("%8.2f", (A.data[i] + B.data[i]));
    }
}


/********************************************************
 *   subtraction(struct matrix A, struct matrix B)
 *   Subtracts the values of the given matrices together and prints to the terminal
 *
 *   Input:
 *       *A : the first matrix to be subtracted
 *       *B : the second matrix to be subtracted
 * 
 *   Returns:
 *       void
 *********************************************************/
void subtraction(struct matrix A, struct matrix B)
{
    int size = A.size;
    printf("A - B = \n"); // prints the header
    for (int i = 0; i < size; i++) // loops through each array, printing the data of each value
    {
        printf("%7.2f", (A.data[i] - B.data[i]));
    }
}
