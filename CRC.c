#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char temp[100];

void xorStrings(char *temp, char *generator, int genLen)
{
    for(int i = 0; i < genLen; i++)
    {
        temp[i] = (temp[i] == generator[i]) ? '0' : '1';
    }
}

int main()
{
    char data[100], generator[30], temp[130];

    printf("enter the data bits: ");
    scanf("%s", data);

    printf("enter generator polynomial: ");
    scanf("%s", generator);

    int dataLen = strlen(data);
    int genLen = strlen(generator);

    strcpy(temp, data);

    for(int i = 0; i < genLen - 1; i++)
    {
        strcat(temp, "0");
    }

    int totalLen = strlen(temp);

    for(int i = 0; i <= totalLen - genLen; i++)
    {
        if(temp[i] == '1')
            xorStrings(&temp[i], generator, genLen);
    }

    char crc[30];

    strcpy(crc, &temp[totalLen - genLen + 1]);

    printf("crc: %s\n", crc);

    printf("final transmitted frame: %s%s\n", data, crc);

    return 0;
}
