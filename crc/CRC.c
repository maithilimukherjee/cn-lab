#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
    char data[100];
    char originalData[100];
    char gen[30];

    printf("enter dataword:");
    scanf("%s", data);
    printf("dataword: %s\n", data);
    strcpy(originalData, data);

    printf("enter generator polynomial:");
    scanf("%s", gen);

    int dataLen = strlen(data);
    int genLen = strlen(gen);

    for(int i = 0; i<genLen-1; i++)
    {
        data[dataLen + i] = '0';
    }

    data[dataLen + genLen - 1] = '\0';

    printf("dataword after appending zeros: %s\n", data);

    for(int i = 0; i< dataLen; i++)
    {
        if(data[i]=='1')
        {
            for(int j = 0; j<genLen; j++)
            {
                data[i+j] = (data[i+j]==gen[j])?'0':'1';
            }
        }
    }

    printf("crc remainder: ");

    for(int i = dataLen; i< dataLen+genLen-1; i++)
    {
        printf("%c", data[i]);
        strncat(originalData, &data[i], 1);
    }

    printf("\ntransmitted data: %s\n", originalData);

}
