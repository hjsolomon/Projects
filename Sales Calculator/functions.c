#include <stdio.h>
#include <stdlib.h>
#include "functions.h"

void get_totals(int rows, int col, int array[][col])
{
    //int array[][col]

    FILE *outputFile = fopen("Total_sales.txt", "w");

    for (int i = 0; i < rows; i++)
    {
        int tally = 0;
        for (int j = 0; j < col; j++)
        {
            tally += array[i][j + 1];
            printf("%5d", array[i][j]);

        }
        fprintf(outputFile, "%5d", i);
        fprintf(outputFile, "%6d\n", tally);
    }

    fclose(outputFile);
}

void get_profits(int rows, int col, int array[][col], float costs[], float purch[])
{
    FILE *outputFile = fopen("Profits.txt", "w");
    fprintf(outputFile, "%8s", "Item");
    fprintf(outputFile, "%8s", "#");
    fprintf(outputFile, "%8s", "Sales");
    fprintf(outputFile, "%8s", "Cost");
    fprintf(outputFile, "%8s\n", "Revenue");

    for (int i = 1; i < rows; i++)
    {
        int tally = 0;

        for (int j = 0; j < col; j++)
        {
            tally += array[i][j + 1];
        }

        float sales = tally * purch[i];
        float cost = tally * costs[i];
        float revenue = sales - cost;

        fprintf(outputFile, "%8d", i);
        fprintf(outputFile, "%8d", tally);
        fprintf(outputFile, "%8.2f", sales);
        fprintf(outputFile, "%8.2f", cost);
        fprintf(outputFile, "%8.2f\n", revenue);
    }

    fclose(outputFile);
}

void top_earner(int rows, int col, int** array, float costs[], float purch[])
{
    FILE *outputFile = fopen("Top_earners.txt", "w");

    fprintf(outputFile, "%4s", "Item");
    fprintf(outputFile, "%4s", "#");
    fprintf(outputFile, "  %4s\n", "Revenue");

    int count = 0;
    float currentBest = 0;
    int bestID;
    int bestNumSales;
    float allRevenues[51];

    for (int i = 0; i < rows; i++)
    {
        int tally = 0;
        for (int j = 0; j < col; j++)
        {
            tally += array[i][j + 1];
        }

        float sales = tally * purch[i];
        float cost = tally * costs[i];
        float revenue = sales - cost;
        allRevenues[i] = revenue;
    }

    while (count < 10)
    {
        for (int k = 0; k < rows; k++)
        {
            int tally = 0;
            if (allRevenues[k] > currentBest)
            {
                for (int j = 0; j < col; j++)
                {
                    tally += array[k][j + 1];
                }
                currentBest = allRevenues[k];
                bestID = k;
                bestNumSales = tally;
            }
        }
        fprintf(outputFile, "%4d", bestID);
        fprintf(outputFile, "%4d", bestNumSales);
        fprintf(outputFile, "    %4.2f\n", currentBest);
        currentBest = 0;
        allRevenues[bestID] = 0;
        count++;
    }

    fclose(outputFile);
}

float *readCosts(int numItems)
{
    int new_item;
    float cost, purchase;
    int counter = 0;
    float *array = calloc(numItems, numItems * sizeof(float));
    FILE *inputFile = fopen("Costs.txt", "r");
    while (fscanf(inputFile, "%i %f %f", &new_item, &purchase, &cost) > 0)
    {
        array[counter] = cost;
        counter++;
    }
    fclose(inputFile);

    return array;
}

float *readPurch(int numItems)
{
    int new_item;
    float cost, purchase;
    int counter = 0;
    float *array = calloc(numItems, numItems * sizeof(float));
    FILE *inputFile = fopen("Costs.txt", "r");
    while (fscanf(inputFile, "%i %f %f", &new_item, &purchase, &cost) > 0)
    {
        array[counter] = purchase;
        counter++;
    }
    fclose(inputFile);

    return array;
}
